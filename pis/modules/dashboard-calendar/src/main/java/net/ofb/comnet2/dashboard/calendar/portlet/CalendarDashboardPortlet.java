package net.ofb.comnet2.dashboard.calendar.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.ws.rs.core.HttpHeaders;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;

import net.ofb.comnet2.dashboard.calendar.constants.DashboardCalendarPortletKeys;
import net.ofb.comnet2.dashboard.calendar.model.Event;



/**
 * @author Chinm
 */
@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.dashboard",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Calendar Dashboard", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DashboardCalendarPortletKeys.DASHBOARDCALENDAR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, 
	service = Portlet.class)
public class CalendarDashboardPortlet extends MVCPortlet {

	private static final Log LOGGER = LogFactoryUtil.getLog(CalendarDashboardPortlet.class.getName());

	/*@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			User user = UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
			String calendarURL = PropsUtil.get("mail.dashboard.calendar.url");
			
			String password = null;
			String strResponse = getDashboardData(calendarURL, user.getEmailAddress(), password);
			renderRequest.setAttribute("dashboardData", strResponse);
		} catch (Exception e) {
			LOGGER.info(e);
		}
		super.doView(renderRequest, renderResponse);
	}

	private String getDashboardData(String url, String email, String password) throws Exception {
		String result = null;
		URL urlObj = new URL(url);
		StringBuilder sb = new StringBuilder();

		Scanner sc = new Scanner(urlObj.openStream());
		try {
			while (sc.hasNext()) {
				sb.append(sc.next());
			}
			sc.close();
			result = sb.toString();
			//result = result.replaceAll("<[^>]*>", "");
		} catch (Exception e) {
		}
		return result;
	}
	 */
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ArrayList<Event> events = new ArrayList<Event>();

		JSONArray zimbraCalendarEvents = getzimbraCalendarEvents();
		for (int i = 0; i < zimbraCalendarEvents.length(); i++) {
			JSONObject eventObject = zimbraCalendarEvents.getJSONObject(i);
			System.out.println(eventObject);
			Event event = new Event();
			JSONArray invArray = eventObject.getJSONArray("inv");
			JSONArray compArray = invArray.getJSONObject(0).getJSONArray("comp");
			JSONArray startDateArray = compArray.getJSONObject(0).getJSONArray("s");
			JSONArray endDateArray = compArray.getJSONObject(0).getJSONArray("e");
			String eventTitle = compArray.getJSONObject(0).getString("name");
			String eventLocation = compArray.getJSONObject(0).getString("loc");
			String eventStartDate = startDateArray.getJSONObject(0).getString("d");
			String eventEndDate = endDateArray.getJSONObject(0).getString("d");
			event.setTitle(eventTitle);
			event.setLocation(eventLocation);
			event.setStart(convertDate(eventStartDate));
			event.setEnd(convertDate(eventEndDate));
			try {
				JSONObject eventDetailJson = JSONFactoryUtil.createJSONObject(event.toString());
				event.setUrl("javascript:showEventDetails('"+eventDetailJson+"');");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			events.add(event);
		}

		JSONArray eventsArray = JSONFactoryUtil.createJSONArray(events);
		renderRequest.setAttribute("events", eventsArray);

		super.doView(renderRequest, renderResponse);

	}

	private String convertDate(String date) {
		String convertedDate = "";
		String year = date.substring(0, 4);
		String month = date.substring(4, 6);
		String day = date.substring(6, 8);
		String hour = "00";
		String minute = "00";
		String second = "00";
		if(date.contains("T")) {
			 hour = date.substring(9, 11);
			 minute = date.substring(11, 13);
			 second = date.substring(13, 15);
				
		}
		convertedDate = year + "-" + month + "-" + day + "T" + hour + ":" + minute + ":" + second;
		return convertedDate;
	}

	private JSONArray getzimbraCalendarEvents() {

		
		
		String soapUrl=PropsUtil.get("calendar.auth.url");
		String adminUser=PropsUtil.get("calendar.admin.user");
		String adminPassword=PropsUtil.get("calendar.admin.password");

		
		 
		
		System.out.println("URL : "+soapUrl+", User: "+adminUser+", Password: "+adminPassword);
		
		/*
		 * String delegatedUser="suman.saha";
		 */
User user = null;
try {
	user = UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
} catch (PortalException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}
String delegatedUser=user.getEmailAddress().substring(0, user.getEmailAddress().indexOf("@"));
		
		
		String data="";
		try {
			data = getCalender(soapUrl, adminUser, adminPassword, delegatedUser);
			
			System.out.println("***************************************************************");
			
			System.out.println(data);
			
			System.out.println();
			
			
			System.out.println("++++++++++++++++++++++**************************+++++++++++++++++++");
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JSONArray eventsArray = null;
		try {
			JSONObject dataObject = JSONFactoryUtil.createJSONObject(data);
			eventsArray = JSONFactoryUtil.createJSONArray(dataObject.getString("appt"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return eventsArray;
	}

	private String getJSONData() {
		String data = "{\r\n" + "   \"appt\":[\r\n" + "      {\r\n" + "         \"f\":\"d\",\r\n"
				+ "         \"uid\":\"0207d61b-4bee-4e42-a4b6-1b45600b2ae8\",\r\n" + "         \"id\":\"509\",\r\n"
				+ "         \"l\":\"10\",\r\n" + "         \"rev\":1621,\r\n" + "         \"s\":0,\r\n"
				+ "         \"d\":1648120095000,\r\n" + "         \"inv\":[\r\n" + "            {\r\n"
				+ "               \"type\":\"appt\",\r\n" + "               \"tz\":[\r\n" + "                  {\r\n"
				+ "                     \"id\":\"Asia/Kolkata\",\r\n" + "                     \"stdoff\":330,\r\n"
				+ "                     \"stdname\":\"IST\"\r\n" + "                  }\r\n" + "               ],\r\n"
				+ "               \"seq\":0,\r\n" + "               \"id\":508,\r\n"
				+ "               \"compNum\":0,\r\n" + "               \"comp\":[\r\n" + "                  {\r\n"
				+ "                     \"method\":\"REQUEST\",\r\n" + "                     \"compNum\":0,\r\n"
				+ "                     \"rsvp\":false,\r\n" + "                     \"name\":\"abc\",\r\n"
				+ "                     \"loc\":\"My location\",\r\n" + "                     \"at\":[\r\n"
				+ "                        {\r\n" + "                           \"a\":\"suman.saha@ayudh.net\",\r\n"
				+ "                           \"url\":\"suman.saha@ayudh.net\",\r\n"
				+ "                           \"d\":\"suman.saha@ayudh.net\",\r\n"
				+ "                           \"role\":\"REQ\",\r\n" + "                           \"ptst\":\"NE\"\r\n"
				+ "                        }\r\n" + "                     ],\r\n"
				+ "                     \"noBlob\":true,\r\n" + "                     \"fba\":\"T\",\r\n"
				+ "                     \"fb\":\"B\",\r\n" + "                     \"transp\":\"O\",\r\n"
				+ "                     \"or\":{\r\n" + "                        \"a\":\"mk.das@ayudh.net\",\r\n"
				+ "                        \"url\":\"mk.das@ayudh.net\",\r\n"
				+ "                        \"d\":\"mk.das@ayudh.net\"\r\n" + "                     },\r\n"
				+ "                     \"url\":\"\",\r\n"
				+ "                     \"x_uid\":\"0207d61b-4bee-4e42-a4b6-1b45600b2ae8\",\r\n"
				+ "                     \"uid\":\"0207d61b-4bee-4e42-a4b6-1b45600b2ae8\",\r\n"
				+ "                     \"seq\":0,\r\n" + "                     \"d\":1648120095000,\r\n"
				+ "                     \"calItemId\":\"509\",\r\n" + "                     \"apptId\":\"509\",\r\n"
				+ "                     \"ciFolder\":\"10\",\r\n" + "                     \"status\":\"CONF\",\r\n"
				+ "                     \"class\":\"PUB\",\r\n" + "                     \"s\":[\r\n"
				+ "                        {\r\n" + "                           \"d\":\"31060822T133000\",\r\n"
				+ "                           \"tz\":\"Asia/Kolkata\",\r\n"
				+ "                           \"u\":35805744000000\r\n" + "                        }\r\n"
				+ "                     ],\r\n" + "                     \"e\":[\r\n" + "                        {\r\n"
				+ "                           \"tz\":\"Asia/Kolkata\",\r\n"
				+ "                           \"u\":35805746400000,\r\n"
				+ "                           \"d\":\"31060822T141000\"\r\n" + "                        }\r\n"
				+ "                     ],\r\n" + "                     \"draft\":true\r\n" + "                  }\r\n"
				+ "               ]\r\n" + "            }\r\n" + "         ]\r\n" + "      },\r\n" + "      {\r\n"
				+ "         \"f\":\"d\",\r\n" + "         \"uid\":\"02e0c4a7-5bd6-4628-b924-371fdf7adf20\",\r\n"
				+ "         \"id\":\"630\",\r\n" + "         \"l\":\"10\",\r\n" + "         \"rev\":1911,\r\n"
				+ "         \"s\":0,\r\n" + "         \"d\":1650346446000,\r\n" + "         \"inv\":[\r\n"
				+ "            {\r\n" + "               \"type\":\"appt\",\r\n" + "               \"tz\":[\r\n"
				+ "                  {\r\n" + "                     \"id\":\"Asia/Kolkata\",\r\n"
				+ "                     \"stdoff\":330,\r\n" + "                     \"stdname\":\"IST\"\r\n"
				+ "                  }\r\n" + "               ],\r\n" + "               \"seq\":0,\r\n"
				+ "               \"id\":629,\r\n" + "               \"compNum\":0,\r\n"
				+ "               \"comp\":[\r\n" + "                  {\r\n"
				+ "                     \"method\":\"REQUEST\",\r\n" + "                     \"compNum\":0,\r\n"
				+ "                     \"rsvp\":false,\r\n"
				+ "                     \"name\":\"OOFFICE_testing of meeting\",\r\n"
				+ "                     \"loc\":\"My location\",\r\n" + "                     \"at\":[\r\n"
				+ "                        {\r\n" + "                           \"a\":\"suman.saha@ayudh.net\",\r\n"
				+ "                           \"url\":\"suman.saha@ayudh.net\",\r\n"
				+ "                           \"d\":\"suman.saha@ayudh.net\",\r\n"
				+ "                           \"role\":\"REQ\",\r\n" + "                           \"ptst\":\"NE\"\r\n"
				+ "                        }\r\n" + "                     ],\r\n"
				+ "                     \"noBlob\":true,\r\n" + "                     \"fba\":\"T\",\r\n"
				+ "                     \"fb\":\"B\",\r\n" + "                     \"transp\":\"O\",\r\n"
				+ "                     \"or\":{\r\n" + "                        \r\n" + "                     },\r\n"
				+ "                     \"url\":\"\",\r\n"
				+ "                     \"x_uid\":\"02e0c4a7-5bd6-4628-b924-371fdf7adf20\",\r\n"
				+ "                     \"uid\":\"02e0c4a7-5bd6-4628-b924-371fdf7adf20\",\r\n"
				+ "                     \"seq\":0,\r\n" + "                     \"d\":1650346446000,\r\n"
				+ "                     \"calItemId\":\"630\",\r\n" + "                     \"apptId\":\"630\",\r\n"
				+ "                     \"ciFolder\":\"10\",\r\n" + "                     \"status\":\"CONF\",\r\n"
				+ "                     \"class\":\"PUB\",\r\n" + "                     \"s\":[\r\n"
				+ "                        {\r\n" + "                           \"d\":\"20220619T110000\",\r\n"
				+ "                           \"tz\":\"Asia/Kolkata\",\r\n"
				+ "                           \"u\":1650346200000\r\n" + "                        }\r\n"
				+ "                     ],\r\n" + "                     \"e\":[\r\n" + "                        {\r\n"
				+ "                           \"tz\":\"Asia/Kolkata\",\r\n"
				+ "                           \"u\":1650346800000,\r\n"
				+ "                           \"d\":\"20220619T111000\"\r\n" + "                        }\r\n"
				+ "                     ],\r\n" + "                     \"draft\":true\r\n" + "                  }\r\n"
				+ "               ]\r\n" + "            }\r\n" + "         ]\r\n" + "      },\r\n" + "      {\r\n"
				+ "         \"f\":\"d\",\r\n" + "         \"uid\":\"07340532-82c0-4efd-973d-d82b6aac5e7f\",\r\n"
				+ "         \"id\":\"503\",\r\n" + "         \"l\":\"10\",\r\n" + "         \"rev\":1618,\r\n"
				+ "         \"s\":0,\r\n" + "         \"d\":1648115129000,\r\n" + "         \"inv\":[\r\n"
				+ "            {\r\n" + "               \"type\":\"appt\",\r\n" + "               \"tz\":[\r\n"
				+ "                  {\r\n" + "                     \"id\":\"Asia/Kolkata\",\r\n"
				+ "                     \"stdoff\":330,\r\n" + "                     \"stdname\":\"IST\"\r\n"
				+ "                  }\r\n" + "               ],\r\n" + "               \"seq\":0,\r\n"
				+ "               \"id\":502,\r\n" + "               \"compNum\":0,\r\n"
				+ "               \"comp\":[\r\n" + "                  {\r\n"
				+ "                     \"method\":\"REQUEST\",\r\n" + "                     \"compNum\":0,\r\n"
				+ "                     \"rsvp\":false,\r\n"
				+ "                     \"name\":\"testNewgenFromEgovjsp\",\r\n"
				+ "                     \"loc\":\"My location\",\r\n" + "                     \"at\":[\r\n"
				+ "                        {\r\n" + "                           \"a\":\"suman.saha@ayudh.net\",\r\n"
				+ "                           \"url\":\"suman.saha@ayudh.net\",\r\n"
				+ "                           \"d\":\"suman.saha@ayudh.net\",\r\n"
				+ "                           \"role\":\"REQ\",\r\n" + "                           \"ptst\":\"NE\"\r\n"
				+ "                        }\r\n" + "                     ],\r\n"
				+ "                     \"noBlob\":true,\r\n" + "                     \"fba\":\"T\",\r\n"
				+ "                     \"fb\":\"B\",\r\n" + "                     \"transp\":\"O\",\r\n"
				+ "                     \"or\":{\r\n" + "                        \"a\":\"mk.das@ayudh.net\",\r\n"
				+ "                        \"url\":\"mk.das@ayudh.net\",\r\n"
				+ "                        \"d\":\"mk.das@ayudh.net\"\r\n" + "                     },\r\n"
				+ "                     \"url\":\"\",\r\n"
				+ "                     \"x_uid\":\"07340532-82c0-4efd-973d-d82b6aac5e7f\",\r\n"
				+ "                     \"uid\":\"07340532-82c0-4efd-973d-d82b6aac5e7f\",\r\n"
				+ "                     \"seq\":0,\r\n" + "                     \"d\":1648115129000,\r\n"
				+ "                     \"calItemId\":\"503\",\r\n" + "                     \"apptId\":\"503\",\r\n"
				+ "                     \"ciFolder\":\"10\",\r\n" + "                     \"status\":\"CONF\",\r\n"
				+ "                     \"class\":\"PUB\",\r\n" + "                     \"s\":[\r\n"
				+ "                        {\r\n" + "                           \"d\":\"20220326T170000\",\r\n"
				+ "                           \"tz\":\"Asia/Kolkata\",\r\n"
				+ "                           \"u\":1648294200000\r\n" + "                        }\r\n"
				+ "                     ],\r\n" + "                     \"e\":[\r\n" + "                        {\r\n"
				+ "                           \"tz\":\"Asia/Kolkata\",\r\n"
				+ "                           \"u\":1648297800000,\r\n"
				+ "                           \"d\":\"20220326T180000\"\r\n" + "                        }\r\n"
				+ "                     ],\r\n" + "                     \"draft\":true\r\n" + "                  }\r\n"
				+ "               ]\r\n" + "            }\r\n" + "         ]\r\n" + "      }\r\n" + "   ]\r\n" + "}";
		return data;
	}
	
	public String getCalender(String soapUrl, String adminUser, String adminPassword, String delegatedUser)
			throws IOException, Exception {
		System.out.println(
				"getMailCount(" + soapUrl + ", " + adminUser + ", " + adminPassword + ", " + delegatedUser + ")");
		String payloadAdminAuth = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">\n"
				+ "    <soap:Body>\n" + "        <AuthRequest xmlns=\"urn:zimbraAdmin\">\n" + "            <name>"
				+ adminUser + "</name>\n" + "            <password>" + adminPassword + "</password>\n"
				+ "   </AuthRequest>\n" + "    </soap:Body>\n" + "</soap:Envelope>";

		String responseAdminAuth = invokeSoap(soapUrl, payloadAdminAuth, null, null);

		System.out.println("responseAdminAuth : " + responseAdminAuth);

		int p1 = 0;
		int p2 = 0;
		String adminAuthToken = "";

		p1 = responseAdminAuth.indexOf("<authToken>");

		if (p1 > 0) {
			p1 += "<authToken>".length();
			p2 = responseAdminAuth.indexOf("</authToken>");

			if (p2 > p1) {
				adminAuthToken = responseAdminAuth.substring(p1, p2);
			}
		}

		System.out.println("adminAuthToken : " + adminAuthToken);

		String cookieHeader = "ZM_ADMIN_AUTH_TOKEN=" + adminAuthToken;

		String payloadDelegateAuth = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">\n"
				+ "    <soap:Body>\n" + "        <DelegateAuthRequest duration=\"86400\" xmlns=\"urn:zimbraAdmin\">\n"
				+ "            <account by=\"name\">" + delegatedUser + "</account>\n"
				+ "        </DelegateAuthRequest>\n" + "    </soap:Body>\n" + "</soap:Envelope>";

		String responseDelegateAuth = invokeSoap(soapUrl, payloadDelegateAuth, "Bearer " + adminAuthToken,
				cookieHeader);

		System.out.println("responseDelegateAuth : " + responseDelegateAuth);

		String delegatedAuthToken = "";

		p1 = responseDelegateAuth.indexOf("<authToken>");

		if (p1 > 0) {
			p1 += "<authToken>".length();
			p2 = responseDelegateAuth.indexOf("</authToken>");

			if (p2 > p1) {
				delegatedAuthToken = responseDelegateAuth.substring(p1, p2);
			}
		}
		System.out.println("delegatedAuthToken : " + delegatedAuthToken);

	
		
		
		String payloadGetCal = "";
	
	/*
	 * String CalUrl
	 * ="https://uatmail.ayudh.net/home/"+delegatedUser+"/calendar.html";
	 */
	 
	
//Change For Production
	 String CalUrl="https://uatmail.ayudh.net/home/"+delegatedUser+"/calendar?fmt=json&end=+1mon";
	
	  cookieHeader="ZM_AUTH_TOKEN="+delegatedAuthToken+"; "+cookieHeader;
		System.out.println("Get Folder Cookie");
		System.out.println(cookieHeader);
		String responseGetCal = invokeSoapForCalender(CalUrl, payloadGetCal, "Bearer " + delegatedAuthToken,cookieHeader);
		//System.out.println("responseGetCalendar  : " + responseGetCal);


	 return responseGetCal;
	}

	private String invokeSoap(String soapUrl, String payload, String authHeader, String cookieHeader)
			throws IOException {

		System.out.println("invokeSoap(\nSoapUrl\n=====================================\n" + soapUrl
				+ ",\n==============================\nPayload\n==============================\n" + payload
				+ ",\n==============================\nAuthHeader\n=============================\n" + authHeader
				+ ",\n==============================\nCookieHeader\n=============================\n" + cookieHeader
				+ "\n==============================" + "\n)");

		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpPost httpPost = new HttpPost(soapUrl);
			httpPost.setHeader("Accept", "*/*");
			httpPost.setHeader("Content-type", "application/xml");

			if (StringUtils.isNotBlank(authHeader)) {
				httpPost.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
			}

			if (StringUtils.isNotBlank(cookieHeader)) {
				httpPost.setHeader("Cookie", cookieHeader);
			}

			StringEntity stringEntity = new StringEntity(payload);
			httpPost.setEntity(stringEntity);

			String endPointURL = soapUrl;

			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();

				System.out.println(status + " - received from " + endPointURL);
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
				/*
				 * System.out.println("Entity"); System.out.println(entity);
				 * System.out.println(EntityUtils.toString(entity));
				 */
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Error occured - unexpected response status: " + status);
				}
			};

			String responseBody = httpclient.execute(httpPost, responseHandler);
		/* System.out.println(responseBody); */

			if (responseBody.contains("Error") || responseBody.contains("Exception")) {
				throw new IOException(responseBody);
			} else {
				return responseBody;
			}
			
}
		catch (IOException e) {
			System.out.println(e);
			throw e;
		} catch (Exception e) {
			System.out.println(e);
			throw new IOException(e);
		}
		
	}

	
	
	
	
	
	private String invokeSoapForCalender(String soapUrl, String payload, String authHeader, String cookieHeader)
			throws IOException {

		System.out.println("invokeSoap(\nSoapUrl\n=====================================\n" + soapUrl
				+ ",\n==============================\nPayload\n==============================\n" + payload
				+ ",\n==============================\nAuthHeader\n=============================\n" + authHeader
				+ ",\n==============================\nCookieHeader\n=============================\n" + cookieHeader
				+ "\n==============================" + "\n)");

		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			
			HttpGet httpGet=new HttpGet(soapUrl);
			httpGet.setHeader("Accept", "*/*");
			if (StringUtils.isNotBlank(authHeader)) {
				httpGet.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
			}

			if (StringUtils.isNotBlank(cookieHeader)) {
				httpGet.setHeader("Cookie", cookieHeader);
			}

		    String endPointURL = soapUrl;

			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();

				System.out.println(status + " - received from " + endPointURL);
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Error occured - unexpected response status: " + status);
				}
			};

			String responseBody = httpclient.execute(httpGet, responseHandler);
		
		/* System.out.println(responseBody); */

			if (responseBody.contains("Error") || responseBody.contains("Exception")) {
				throw new IOException(responseBody);
			} else {
				return responseBody;
			}
			
}
		catch (IOException e) {
			System.out.println(e);
			throw e;
		} catch (Exception e) {
			System.out.println(e);
			throw new IOException(e);
		}
		
	}
	
}