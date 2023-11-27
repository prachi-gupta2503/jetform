package com.adjecti.pis.liferay.notification;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;

public class PISNotificationUtil {
	
	public static void sendNotificationToApprovers(List<User> approvers,String notificationMessage) throws IOException, PortletException{
		for(User approver:approvers) {
			sendNotification(approver,notificationMessage);
	     }
}
   
	public static void sendNotificationToUser(User user,String notificationMessage) throws IOException, PortletException{
		sendNotification(user,notificationMessage);
     }
	
	private static void sendNotification(User user,String notificationMessage) {
		try {
			
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();	
			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
			payloadJSON.put("userId", user.getUserId());
			payloadJSON.put("notificationMessage",notificationMessage);
			payloadJSON.put("companyId", user.getCompanyId());
			payloadJSON.put("groupId", user.getGroupId());
			
		   UserNotificationEventLocalServiceUtil.addUserNotificationEvent(user.getUserId(),PISNotificationHandler.PIS_PORTLET_ID,(new Date()).getTime(),UserNotificationDeliveryConstants.TYPE_WEBSITE, user.getUserId(),payloadJSON.toString(),false, serviceContext);
		   
		}catch (Exception e) {
		    	e.printStackTrace();
		    }
		
	}
	
}