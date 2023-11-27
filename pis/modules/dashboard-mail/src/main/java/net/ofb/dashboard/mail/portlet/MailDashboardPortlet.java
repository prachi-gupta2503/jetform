package net.ofb.dashboard.mail.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.ws.rs.core.HttpHeaders;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;

import net.ofb.dashboard.mail.constants.MailDashboardPortletKeys;

/**
 * @author arjun
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.dashboard",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=MailDashboard",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MailDashboardPortletKeys.MAILDASHBOARD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MailDashboardPortlet extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(MailDashboardPortlet.class.getName());
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String unreadCount="0";
		try {
			User user= UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
			/*String mailURL=PropsUtil.get("mail.count.url.rest");
			String password=PrincipalThreadLocal.getPassword();
			String jsonStr = getDashboardData(mailURL,adminUser, adminPassword, delegatedUser);
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject(jsonStr);
			unreadCount=String.valueOf(jsonObject.getJSONArray("m").length());*/
			
			String mailAuthURL=PropsUtil.get("mail.auth.url");
			String adminUser=PropsUtil.get("mail.admin.user");
			String adminPassword=PropsUtil.get("mail.admin.password");
			
			LOGGER.info("MailAuthURL : "+mailAuthURL+", User: "+adminUser+", Password: "+adminPassword);
			String delegatedUser=user.getEmailAddress().substring(0, user.getEmailAddress().indexOf("@"));
			
			unreadCount = getMailCount(mailAuthURL, adminUser, adminPassword, delegatedUser);
			
			LOGGER.info("unreadCount : "+unreadCount);
			
			renderRequest.setAttribute("dashboardData", unreadCount);
		}catch(Exception e) {
			LOGGER.info(e);
		}
		super.doView(renderRequest, renderResponse);
	}
	
	private String getMailCount(String authUrl, String adminUser, String adminPassword, String delegatedUser) throws IOException, JSONException {
		LOGGER.info("getMailCount(" + authUrl + ", "+ adminUser +", "+adminPassword+", "+delegatedUser+")");
		String payloadAdminAuth ="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">\n" + 
				"    <soap:Body>\n" + 
				"        <AuthRequest xmlns=\"urn:zimbraAdmin\">\n" + 
				"            <name>"+adminUser+"</name>\n" + 
				"            <password>"+adminPassword+"</password>\n" + 
				"        </AuthRequest>\n" + 
				"    </soap:Body>\n" + 
				"</soap:Envelope>";
		
		String responseAdminAuth=invokeSoap(authUrl, payloadAdminAuth, null, null);
		
		LOGGER.info("responseAdminAuth : "+responseAdminAuth);
		
		int p1=0;
		int p2=0;
		String adminAuthToken="";
		
		p1=responseAdminAuth.indexOf("<authToken>");
		
		if(p1>0) {
			p1+="<authToken>".length();
			p2=responseAdminAuth.indexOf("</authToken>");
			
			if(p2>p1) {
				adminAuthToken=responseAdminAuth.substring(p1, p2);
			}
		}
		
		LOGGER.info("adminAuthToken : "+adminAuthToken);
		
		String cookieHeader="ZM_ADMIN_AUTH_TOKEN="+adminAuthToken;
		
		String payloadDelegateAuth="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">\n" + 
				"    <soap:Body>\n" + 
				"        <DelegateAuthRequest duration=\"86400\" xmlns=\"urn:zimbraAdmin\">\n" + 
				"            <account by=\"name\">"+delegatedUser+"</account>\n" + 
				"        </DelegateAuthRequest>\n" + 
				"    </soap:Body>\n" + 
				"</soap:Envelope>";
		
		
		String responseDelegateAuth=invokeSoap(authUrl, payloadDelegateAuth, "Bearer "+adminAuthToken, cookieHeader);
		
		LOGGER.info("responseDelegateAuth : "+responseDelegateAuth);
		
		String delegatedAuthToken="";
		
		p1=responseDelegateAuth.indexOf("<authToken>");
		
		if(p1>0) {
			p1+="<authToken>".length();
			p2=responseDelegateAuth.indexOf("</authToken>");
			
			if(p2>p1) {
				delegatedAuthToken=responseDelegateAuth.substring(p1, p2);
			}
		}
		LOGGER.info("delegatedAuthToken : "+delegatedAuthToken);
		
		String payloadGetFolder="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">\n" + 
				"  <soap:Body>\n" + 
				"    <GetFolderRequest xmlns=\"urn:zimbraMail\">\n" + 
				"        <folder l=\"2\"/>\n" + 
				"    </GetFolderRequest>\n" + 
				"  </soap:Body>\n" + 
				"</soap:Envelope>";
		
		String mailFolderURL=PropsUtil.get("mail.folder.url");
		
		cookieHeader="ZM_AUTH_TOKEN="+delegatedAuthToken+"; "+cookieHeader;
		
		String responseGetFolder=invokeSoap(mailFolderURL, payloadGetFolder, "Bearer "+delegatedAuthToken, cookieHeader);
		
		LOGGER.info("responseGetFolder : "+responseGetFolder);
		
		String unreadCount="0";
		p1=responseGetFolder.indexOf("<folder ", responseGetFolder.indexOf("<GetFolderResponse ")+"<GetFolderResponse ".length());
		
		if(p1>0) {
			p1+="<folder ".length() ;
			p2=responseGetFolder.indexOf(">", p1);
			
			if(p2>p1) {
				String folderPart=responseGetFolder.substring(p1, p2);
				LOGGER.info("folderPart : "+folderPart);
				if(StringUtils.isNotBlank(folderPart)) {
					p1=folderPart.indexOf(" u=\"");
					
					if(p1>0) {
						p1+=" u=\"".length();
						p2=folderPart.indexOf("\"", p1);
						if(p2>p1) {
							unreadCount=folderPart.substring(p1, p2);
						}
					}
				}
			}
		}
		
		LOGGER.info("unreadCount : "+unreadCount);
		return unreadCount;	
	}
	
	private String invokeSoap(String soapUrl, String payload, String authHeader, String cookieHeader) throws IOException {
		
		LOGGER.info("invokeSoap(\nSoapUrl\n=====================================\n" + soapUrl +
				",\n==============================\nPayload\n==============================\n"+ payload +
				",\n==============================\nAuthHeader\n=============================\n"+authHeader+
				",\n==============================\nCookieHeader\n=============================\n"+cookieHeader+
				"\n=============================="+
				"\n)");
		
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpPost httpPost = new HttpPost(soapUrl);
			httpPost.setHeader("Accept", "*/*");
			httpPost.setHeader("Content-type", "application/xml");
			
			if(StringUtils.isNotBlank(authHeader)) {
				httpPost.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
			}
			
			if(StringUtils.isNotBlank(cookieHeader)) {
				httpPost.setHeader(HttpHeaders.COOKIE, cookieHeader);
				//httpPost.setHeader(HttpHeaders.SET_COOKIE, cookieHeader);
			}
			
			StringEntity stringEntity = new StringEntity(payload);
			httpPost.setEntity(stringEntity);
			
			String endPointURL=soapUrl;
			
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				
				LOGGER.info(status+" - received from "+endPointURL);
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Error occured - unexpected response status: " + status);
				}
			};
			
			String responseBody = httpclient.execute(httpPost, responseHandler);
			LOGGER.info(responseBody);
			
			if (responseBody.contains("Error") || responseBody.contains("Exception")) {	
				throw new IOException(responseBody);
			}else {
				return responseBody;
			}
		} catch (IOException e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new IOException(e);
		}
	}
}