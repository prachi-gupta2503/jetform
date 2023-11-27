package net.ofb.dashboard.egov.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;

import net.ofb.dashboard.egov.constants.EgovDashboardPortletKeys;

/**
 * @author Jitendra
 */
@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.dashboard",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=eGov Dashboard", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EgovDashboardPortletKeys.EGOVDASHBOARD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		}, service = Portlet.class)
public class EgovDashboardPortlet extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(EgovDashboardPortlet.class.getName());
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			String eGovURL=PropsUtil.get("egov.inbox.count.endpoint");
			User user=UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
			String jsonStr = getDashboardData(eGovURL, user.getScreenName());
			renderRequest.setAttribute("dashboardData", JSONFactoryUtil.createJSONObject(jsonStr));
		}catch(Exception e) {
			LOGGER.info(e);
		}
		super.doView(renderRequest, renderResponse);
	}

	private String getDashboardData(String url, String userName) throws Exception {
		LOGGER.info("getEGovDashboardData(" + url + ", "+ userName +")");
		
		if(StringUtils.isBlank(url) || StringUtils.isBlank(userName)) {
			return null;
		}
		
		/*
		 * https://uatdms.ayudh.net/OFB/EgovUser/getInboxCount/<username>
		 * https://uatdms.ayudh.net/OFB/EgovUser/getInboxCount/%s
		 * 
		 */
		
		String userUrl=String.format(url, userName);
		
		LOGGER.info("Before connecting "+userUrl);
		
		int connTimeout = 0;
		try {
			connTimeout=Integer.parseInt(StringUtils.trim(PropsUtil.get("remote.connection.timeout")));
		}catch(Exception e) {}
		
		int connReqTimeout = 0;
		try {
			connReqTimeout=Integer.parseInt(StringUtils.trim(PropsUtil.get("remote.connection.request.timeout")));
		}catch(Exception e) {}
		
		int socketTimeout = 0;
		try {
			socketTimeout=Integer.parseInt(StringUtils.trim(PropsUtil.get("remote.socket.timeout")));
		}catch(Exception e) {}
		
		
		if(connTimeout<=0) {
			connTimeout=1000;
		}
		
		if(connReqTimeout<=0) {
			connReqTimeout=1000;
		}
		
		if(socketTimeout<=0) {
			socketTimeout=1000;
		}
		
		RequestConfig config = RequestConfig.custom().setConnectTimeout(connTimeout)
				.setConnectionRequestTimeout(connReqTimeout).setSocketTimeout(socketTimeout).build();

		try (CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build()) {
			HttpGet httpGet = new HttpGet(userUrl);
			httpGet.setHeader("Accept", "*/*");
			httpGet.setHeader("Content-type",  "text/plain");
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			String responseBody = httpclient.execute(httpGet, responseHandler);
			LOGGER.info(responseBody);
			if (responseBody.toLowerCase().contains("error") || responseBody.toLowerCase().contains("fail")) {
				throw new PortalException(responseBody);
			}else {
				return responseBody;
			}
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
	}

	
	public static void main(String[] x)  throws Exception {
		
		
		/*
		 * https://uatdms.ayudh.net/OFB/EgovUser/getInboxCount/<username>
		 * https://uatdms.ayudh.net/OFB/EgovUser/getInboxCount/%s
		 * 
		 */
		
		String userUrl=String.format("https://uatdms.ayudh.net/OFB/EgovUser/getInboxCount/%s", "ali.aslam");
		
		System.out.println("Before connecting "+userUrl);
		
		int connTimeout = 1000;
		int connReqTimeout = 1000;
		int socketTimeout = 1000;
		
		RequestConfig config = RequestConfig.custom().setConnectTimeout(connTimeout)
				.setConnectionRequestTimeout(connReqTimeout).setSocketTimeout(socketTimeout).build();

		try (CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build()) {
			HttpGet httpGet = new HttpGet(userUrl);
			httpGet.setHeader("Accept", "*/*");
			httpGet.setHeader("Content-type",  "text/plain");
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			String responseBody = httpclient.execute(httpGet, responseHandler);
			LOGGER.info(responseBody);
			if (responseBody.toLowerCase().contains("error") || responseBody.toLowerCase().contains("fail")) {
				throw new PortalException(responseBody);
			}else {
				System.out.println( responseBody);
			}
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
	}

	
	/*
	 * @Override public void serveResource(ResourceRequest resourceRequest,
	 * ResourceResponse resourceResponse) throws IOException, PortletException {
	 * 
	 * JSONObject object = JSONFactoryUtil.createJSONObject(); object.put("CC",
	 * "1"); object.put("Notes", "14"); object.put("Files", "12"); object.put("DAK",
	 * "41"); resourceResponse.setContentType("application/json"); PrintWriter out =
	 * resourceResponse.getWriter(); out.write(object.toString()); out.flush();
	 * 
	 * super.serveResource(resourceRequest, resourceResponse); }
	 */
}
