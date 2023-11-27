/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package net.ayudh.portal.notification.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import net.ayudh.portal.notification.model.Notification;
import net.ayudh.portal.notification.service.base.NotificationServiceBaseImpl;

/**
 * The implementation of the notification remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>net.ayudh.portal.notification.service.NotificationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=comnetportal",
		"json.web.service.context.path=Notification"
	},
	service = AopService.class
)
public class NotificationServiceImpl extends NotificationServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>net.ayudh.portal.notification.service.NotificationServiceUtil</code> to access the notification remote service.
	 */
	
	@AccessControlled(guestAccessEnabled = true)
	public Notification publish(String topic, String clientId, Map<String, String> message) throws PortalException {
		return notificationLocalService.publish(topic, clientId, message);
	}
	
	public Notification publish(Map<String, String> message) throws PortalException {
		return notificationLocalService.publish(message);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public List<Notification> getNotificationsByClientId(String clientId) {
		return notificationLocalService.getNotificationsByClientId(clientId);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public List<Notification> getNotificationsByTopic(String topic) {
		return notificationLocalService.getNotificationsByTopic(topic);
	}
	@AccessControlled(guestAccessEnabled = true)
	public List<Notification> getNotificationsByTopicAndClientId(String topic, String clientId) {
		return notificationLocalService.getNotificationsByTopicAndClientId(topic, clientId);
	}
	@AccessControlled(guestAccessEnabled = true)
	public List<Notification> getNotificationsByStatus(int status){
		return notificationLocalService.getNotificationsByStatus(status);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public List<Notification> updateNotificationStatus(long notificationId){	
		return notificationLocalService.updateNotificationStatus(notificationId);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	 public List<Notification> getUnreadNotifications(){
         return notificationLocalService.getUnreadNotifications();
	 }
	
	public List<UserNotificationEvent> getUnreadUserNotifications(){
		try {
			return UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEvents(getUserId(), false);
		} catch (PrincipalException e) {
			return null;
		}
	}
	public List<UserNotificationEvent> updateUserNotificationArchievedStatus(long userNotificationEventId){
		UserNotificationEvent userNotificationEvent =
			UserNotificationEventLocalServiceUtil.fetchUserNotificationEvent(
				userNotificationEventId);
		userNotificationEvent.setArchived(true);
		UserNotificationEventLocalServiceUtil.updateUserNotificationEvent(userNotificationEvent);
		return getUnreadUserNotifications();
	}
	
	 public int unreadNotificationsCount() {
	     return notificationLocalService.getNotificationsByStatus(0).size()+UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEventsCount(ServiceContextThreadLocal.getServiceContext().getUserId(), false);
	 }
}