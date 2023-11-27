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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Notification. This utility wraps
 * <code>net.ayudh.portal.notification.service.impl.NotificationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationService
 * @generated
 */
public class NotificationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>net.ayudh.portal.notification.service.impl.NotificationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			getNotificationsByClientId(String clientId) {

		return getService().getNotificationsByClientId(clientId);
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			getNotificationsByStatus(int status) {

		return getService().getNotificationsByStatus(status);
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			getNotificationsByTopic(String topic) {

		return getService().getNotificationsByTopic(topic);
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			getNotificationsByTopicAndClientId(String topic, String clientId) {

		return getService().getNotificationsByTopicAndClientId(topic, clientId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			getUnreadNotifications() {

		return getService().getUnreadNotifications();
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.UserNotificationEvent>
			getUnreadUserNotifications() {

		return getService().getUnreadUserNotifications();
	}

	public static net.ayudh.portal.notification.model.Notification publish(
			java.util.Map<String, String> message)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().publish(message);
	}

	public static net.ayudh.portal.notification.model.Notification publish(
			String topic, String clientId,
			java.util.Map<String, String> message)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().publish(topic, clientId, message);
	}

	public static int unreadNotificationsCount() {
		return getService().unreadNotificationsCount();
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			updateNotificationStatus(long notificationId) {

		return getService().updateNotificationStatus(notificationId);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.UserNotificationEvent>
			updateUserNotificationArchievedStatus(
				long userNotificationEventId) {

		return getService().updateUserNotificationArchievedStatus(
			userNotificationEventId);
	}

	public static NotificationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotificationService, NotificationService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NotificationService.class);

		ServiceTracker<NotificationService, NotificationService>
			serviceTracker =
				new ServiceTracker<NotificationService, NotificationService>(
					bundle.getBundleContext(), NotificationService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}