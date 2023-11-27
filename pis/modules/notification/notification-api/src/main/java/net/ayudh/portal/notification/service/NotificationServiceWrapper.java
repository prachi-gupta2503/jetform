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

package net.ayudh.portal.notification.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NotificationService}.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationService
 * @generated
 */
public class NotificationServiceWrapper
	implements NotificationService, ServiceWrapper<NotificationService> {

	public NotificationServiceWrapper(NotificationService notificationService) {
		_notificationService = notificationService;
	}

	@Override
	public java.util.List<net.ayudh.portal.notification.model.Notification>
		getNotificationsByClientId(String clientId) {

		return _notificationService.getNotificationsByClientId(clientId);
	}

	@Override
	public java.util.List<net.ayudh.portal.notification.model.Notification>
		getNotificationsByStatus(int status) {

		return _notificationService.getNotificationsByStatus(status);
	}

	@Override
	public java.util.List<net.ayudh.portal.notification.model.Notification>
		getNotificationsByTopic(String topic) {

		return _notificationService.getNotificationsByTopic(topic);
	}

	@Override
	public java.util.List<net.ayudh.portal.notification.model.Notification>
		getNotificationsByTopicAndClientId(String topic, String clientId) {

		return _notificationService.getNotificationsByTopicAndClientId(
			topic, clientId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _notificationService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<net.ayudh.portal.notification.model.Notification>
		getUnreadNotifications() {

		return _notificationService.getUnreadNotifications();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.UserNotificationEvent>
		getUnreadUserNotifications() {

		return _notificationService.getUnreadUserNotifications();
	}

	@Override
	public net.ayudh.portal.notification.model.Notification publish(
			java.util.Map<String, String> message)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationService.publish(message);
	}

	@Override
	public net.ayudh.portal.notification.model.Notification publish(
			String topic, String clientId,
			java.util.Map<String, String> message)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationService.publish(topic, clientId, message);
	}

	@Override
	public int unreadNotificationsCount() {
		return _notificationService.unreadNotificationsCount();
	}

	@Override
	public java.util.List<net.ayudh.portal.notification.model.Notification>
		updateNotificationStatus(long notificationId) {

		return _notificationService.updateNotificationStatus(notificationId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.UserNotificationEvent>
		updateUserNotificationArchievedStatus(long userNotificationEventId) {

		return _notificationService.updateUserNotificationArchievedStatus(
			userNotificationEventId);
	}

	@Override
	public NotificationService getWrappedService() {
		return _notificationService;
	}

	@Override
	public void setWrappedService(NotificationService notificationService) {
		_notificationService = notificationService;
	}

	private NotificationService _notificationService;

}