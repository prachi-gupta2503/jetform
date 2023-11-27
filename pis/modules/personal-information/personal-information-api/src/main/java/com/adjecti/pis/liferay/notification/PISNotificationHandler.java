package com.adjecti.pis.liferay.notification;


import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import org.osgi.service.component.annotations.Component;

@Component(service=UserNotificationHandler.class)
public class PISNotificationHandler extends BaseUserNotificationHandler {

	public static final String PIS_PORTLET_ID="com_adjecti_pis_liferay_PISMVCPortlet";
	public PISNotificationHandler() {
		setPortletId(PISNotificationHandler.PIS_PORTLET_ID);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
		
		JSONObject jSONObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String notificationText = jSONObject.getString("notificationMessage");
		
		String body = StringUtil.replace(getBodyTemplate(), new String[] {"[$TITLE$]"}, new String[] {notificationText});
		return body;
	}
	
	@Override
	protected String getBodyTemplate() throws Exception {
		StringBundler sb=new StringBundler();
		sb.append("<div class=title>[$TITLE$]</div>");
		return sb.toString();
	}
}
