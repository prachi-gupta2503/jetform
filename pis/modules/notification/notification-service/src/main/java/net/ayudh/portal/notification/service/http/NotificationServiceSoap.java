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

package net.ayudh.portal.notification.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

import net.ayudh.portal.notification.service.NotificationServiceUtil;

/**
 * Provides the SOAP utility for the
 * <code>NotificationServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>net.ayudh.portal.notification.model.NotificationSoap</code>. If the method in the
 * service utility returns a
 * <code>net.ayudh.portal.notification.model.Notification</code>, that is translated to a
 * <code>net.ayudh.portal.notification.model.NotificationSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class NotificationServiceSoap {

	public static net.ayudh.portal.notification.model.NotificationSoap[]
			getNotificationsByClientId(String clientId)
		throws RemoteException {

		try {
			java.util.List<net.ayudh.portal.notification.model.Notification>
				returnValue =
					NotificationServiceUtil.getNotificationsByClientId(
						clientId);

			return net.ayudh.portal.notification.model.NotificationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static net.ayudh.portal.notification.model.NotificationSoap[]
			getNotificationsByTopic(String topic)
		throws RemoteException {

		try {
			java.util.List<net.ayudh.portal.notification.model.Notification>
				returnValue = NotificationServiceUtil.getNotificationsByTopic(
					topic);

			return net.ayudh.portal.notification.model.NotificationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static net.ayudh.portal.notification.model.NotificationSoap[]
			getNotificationsByTopicAndClientId(String topic, String clientId)
		throws RemoteException {

		try {
			java.util.List<net.ayudh.portal.notification.model.Notification>
				returnValue =
					NotificationServiceUtil.getNotificationsByTopicAndClientId(
						topic, clientId);

			return net.ayudh.portal.notification.model.NotificationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static net.ayudh.portal.notification.model.NotificationSoap[]
			getNotificationsByStatus(int status)
		throws RemoteException {

		try {
			java.util.List<net.ayudh.portal.notification.model.Notification>
				returnValue = NotificationServiceUtil.getNotificationsByStatus(
					status);

			return net.ayudh.portal.notification.model.NotificationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static net.ayudh.portal.notification.model.NotificationSoap[]
			updateNotificationStatus(long notificationId)
		throws RemoteException {

		try {
			java.util.List<net.ayudh.portal.notification.model.Notification>
				returnValue = NotificationServiceUtil.updateNotificationStatus(
					notificationId);

			return net.ayudh.portal.notification.model.NotificationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static net.ayudh.portal.notification.model.NotificationSoap[]
			getUnreadNotifications()
		throws RemoteException {

		try {
			java.util.List<net.ayudh.portal.notification.model.Notification>
				returnValue = NotificationServiceUtil.getUnreadNotifications();

			return net.ayudh.portal.notification.model.NotificationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.UserNotificationEventSoap[]
			getUnreadUserNotifications()
		throws RemoteException {

		try {
			java.util.List
				<com.liferay.portal.kernel.model.UserNotificationEvent>
					returnValue =
						NotificationServiceUtil.getUnreadUserNotifications();

			return com.liferay.portal.kernel.model.UserNotificationEventSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.UserNotificationEventSoap[]
			updateUserNotificationArchievedStatus(long userNotificationEventId)
		throws RemoteException {

		try {
			java.util.List
				<com.liferay.portal.kernel.model.UserNotificationEvent>
					returnValue =
						NotificationServiceUtil.
							updateUserNotificationArchievedStatus(
								userNotificationEventId);

			return com.liferay.portal.kernel.model.UserNotificationEventSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int unreadNotificationsCount() throws RemoteException {
		try {
			int returnValue =
				NotificationServiceUtil.unreadNotificationsCount();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		NotificationServiceSoap.class);

}