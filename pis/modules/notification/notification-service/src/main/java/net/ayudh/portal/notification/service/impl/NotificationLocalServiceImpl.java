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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import net.ayudh.portal.notification.model.Notification;
import net.ayudh.portal.notification.service.base.NotificationLocalServiceBaseImpl;

/**
 * The implementation of the notification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>net.ayudh.portal.notification.service.NotificationLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=net.ayudh.portal.notification.model.Notification", service = AopService.class)
public class NotificationLocalServiceImpl extends NotificationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>net.ayudh.portal.notification.service.NotificationLocalService</code>
	 * via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>net.ayudh.portal.notification.service.NotificationLocalServiceUtil</
	 * code>.
	 */

	final static Log LOGGER = LogFactoryUtil.getLog(NotificationLocalServiceImpl.class.getName());

	public Notification publish(String topic, String clientId, Map<String, String> message) throws PortalException {
		Notification notification = null;
		LOGGER.info("Notification publish(String topic, String clientId, String message) throws PortalException");
		try {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			for (Map.Entry<String, String> entry : message.entrySet()) {
				jsonObject.put(entry.getKey(), entry.getValue());
			}
			notification = notificationPersistence
					.create(CounterLocalServiceUtil.increment(Notification.class.getName()));
			notification.setTopic(topic);
			notification.setClientId(clientId);
			notification.setMessage(jsonObject.toJSONString());
			notificationPersistence.update(notification);

			registerUserNotification(notification);
		} catch (Exception e) {
			LOGGER.info(e);
			throw new PortalException("Error in publishing the message.");
		}
		return notification;
	}

	public Notification publish(Map<String, String> message) throws PortalException {
		Notification notification = null;
		LOGGER.info("Notification publish(String topic, String clientId, String message) throws PortalException");
		try {
			String topic = null;
			String clientId = null;
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			for (Map.Entry<String, String> entry : message.entrySet()) {
				if (entry.getKey().equalsIgnoreCase("topic")) {
					topic = entry.getValue();
				} else if (entry.getKey().equalsIgnoreCase("clientId")) {
					clientId = entry.getValue();
				} else {
					jsonObject.put(entry.getKey(), entry.getValue());
				}
			}
			notification = notificationPersistence
					.create(CounterLocalServiceUtil.increment(Notification.class.getName()));
			notification.setTopic(topic);
			notification.setClientId(clientId);
			notification.setMessage(jsonObject.toJSONString());
			notificationPersistence.update(notification);
			
			registerUserNotification(notification);
		} catch (Exception e) {
			LOGGER.info(e);
			throw new PortalException("Error in publishing the message.");
		}
		return notification;
	}

	private void registerUserNotification(Notification notification) {

		try {
			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject(notification.getMessage());
			User user = UserLocalServiceUtil.getUserByScreenName(CompanyThreadLocal.getCompanyId(),
					String.valueOf(payloadJSON.get("userName")));
			payloadJSON.put("userId", user.getUserId());
			payloadJSON.put("notificationMessage", notification.getMessage());
			payloadJSON.put("companyId", user.getCompanyId());
			payloadJSON.put("groupId", user.getGroupId());

			UserNotificationEvent event = UserNotificationEventLocalServiceUtil.createUserNotificationEvent(
					CounterLocalServiceUtil.increment(UserNotificationEvent.class.getName()));
			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(event);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Notification> getNotificationsByClientId(String clientId) {
		try {
			return notificationPersistence.findByClientId(clientId);
		} catch (Exception e) {
		}
		return null;
	}

	public List<Notification> getNotificationsByTopic(String topic) {
		try {
			return notificationPersistence.findByTopic(topic);
		} catch (Exception e) {
		}
		return null;
	}

	public List<Notification> getNotificationsByTopicAndClientId(String topic, String clientId) {
		try {
			return notificationPersistence.findByTopicAndClientId(topic, clientId);
		} catch (Exception e) {
		}
		return null;
	}

	public List<Notification> getNotificationsByStatus(int status) {
		try {
			return notificationPersistence.findByStatus(status);
		} catch (Exception e) {
		}
		return null;
	}

	public List<Notification> getUnreadNotifications() {
		try {
			return notificationPersistence.findByStatus(0);
		} catch (Exception e) {
		}
		return null;
	}

	public List<Notification> updateNotificationStatus(long notificationId) {
		Notification notification;
		try {
			notification = notificationLocalService.getNotification(notificationId);
			notification.setStatus(1);
			notificationPersistence.update(notification);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return getUnreadNotifications();
	}
}