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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import net.ayudh.portal.notification.service.NotificationServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>NotificationServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationServiceSoap
 * @generated
 */
public class NotificationServiceHttp {

	public static net.ayudh.portal.notification.model.Notification publish(
			HttpPrincipal httpPrincipal, String topic, String clientId,
			java.util.Map<String, String> message)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "publish",
				_publishParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, topic, clientId, message);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (net.ayudh.portal.notification.model.Notification)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static net.ayudh.portal.notification.model.Notification publish(
			HttpPrincipal httpPrincipal, java.util.Map<String, String> message)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "publish",
				_publishParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, message);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (net.ayudh.portal.notification.model.Notification)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			getNotificationsByClientId(
				HttpPrincipal httpPrincipal, String clientId) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "getNotificationsByClientId",
				_getNotificationsByClientIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clientId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<net.ayudh.portal.notification.model.Notification>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			getNotificationsByTopic(HttpPrincipal httpPrincipal, String topic) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "getNotificationsByTopic",
				_getNotificationsByTopicParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, topic);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<net.ayudh.portal.notification.model.Notification>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			getNotificationsByTopicAndClientId(
				HttpPrincipal httpPrincipal, String topic, String clientId) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class,
				"getNotificationsByTopicAndClientId",
				_getNotificationsByTopicAndClientIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, topic, clientId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<net.ayudh.portal.notification.model.Notification>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			getNotificationsByStatus(HttpPrincipal httpPrincipal, int status) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "getNotificationsByStatus",
				_getNotificationsByStatusParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<net.ayudh.portal.notification.model.Notification>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			updateNotificationStatus(
				HttpPrincipal httpPrincipal, long notificationId) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "updateNotificationStatus",
				_updateNotificationStatusParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, notificationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<net.ayudh.portal.notification.model.Notification>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<net.ayudh.portal.notification.model.Notification>
			getUnreadNotifications(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "getUnreadNotifications",
				_getUnreadNotificationsParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<net.ayudh.portal.notification.model.Notification>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.UserNotificationEvent>
			getUnreadUserNotifications(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "getUnreadUserNotifications",
				_getUnreadUserNotificationsParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.portal.kernel.model.UserNotificationEvent>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.UserNotificationEvent>
			updateUserNotificationArchievedStatus(
				HttpPrincipal httpPrincipal, long userNotificationEventId) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class,
				"updateUserNotificationArchievedStatus",
				_updateUserNotificationArchievedStatusParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userNotificationEventId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.portal.kernel.model.UserNotificationEvent>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int unreadNotificationsCount(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "unreadNotificationsCount",
				_unreadNotificationsCountParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		NotificationServiceHttp.class);

	private static final Class<?>[] _publishParameterTypes0 = new Class[] {
		String.class, String.class, java.util.Map.class
	};
	private static final Class<?>[] _publishParameterTypes1 = new Class[] {
		java.util.Map.class
	};
	private static final Class<?>[] _getNotificationsByClientIdParameterTypes2 =
		new Class[] {String.class};
	private static final Class<?>[] _getNotificationsByTopicParameterTypes3 =
		new Class[] {String.class};
	private static final Class<?>[]
		_getNotificationsByTopicAndClientIdParameterTypes4 = new Class[] {
			String.class, String.class
		};
	private static final Class<?>[] _getNotificationsByStatusParameterTypes5 =
		new Class[] {int.class};
	private static final Class<?>[] _updateNotificationStatusParameterTypes6 =
		new Class[] {long.class};
	private static final Class<?>[] _getUnreadNotificationsParameterTypes7 =
		new Class[] {};
	private static final Class<?>[] _getUnreadUserNotificationsParameterTypes8 =
		new Class[] {};
	private static final Class<?>[]
		_updateUserNotificationArchievedStatusParameterTypes9 = new Class[] {
			long.class
		};
	private static final Class<?>[] _unreadNotificationsCountParameterTypes10 =
		new Class[] {};

}