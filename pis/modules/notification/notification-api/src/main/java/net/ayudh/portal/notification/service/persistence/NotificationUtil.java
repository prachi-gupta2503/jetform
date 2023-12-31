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

package net.ayudh.portal.notification.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ayudh.portal.notification.model.Notification;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the notification service. This utility wraps <code>net.ayudh.portal.notification.service.persistence.impl.NotificationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationPersistence
 * @generated
 */
public class NotificationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Notification notification) {
		getPersistence().clearCache(notification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Notification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Notification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Notification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Notification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Notification update(Notification notification) {
		return getPersistence().update(notification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Notification update(
		Notification notification, ServiceContext serviceContext) {

		return getPersistence().update(notification, serviceContext);
	}

	/**
	 * Returns all the notifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notifications
	 */
	public static List<Notification> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the notifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of matching notifications
	 */
	public static List<Notification> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the notifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByUuid_First(
			String uuid, OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByUuid_First(
		String uuid, OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByUuid_Last(
			String uuid, OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByUuid_Last(
		String uuid, OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the notifications before and after the current notification in the ordered set where uuid = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public static Notification[] findByUuid_PrevAndNext(
			long notificationId, String uuid,
			OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByUuid_PrevAndNext(
			notificationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the notifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of notifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notifications
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the notification where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNotificationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByUUID_G(String uuid, long groupId)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the notification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the notification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the notification where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the notification that was removed
	 */
	public static Notification removeByUUID_G(String uuid, long groupId)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of notifications where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notifications
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notifications
	 */
	public static List<Notification> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of matching notifications
	 */
	public static List<Notification> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the notifications before and after the current notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public static Notification[] findByUuid_C_PrevAndNext(
			long notificationId, String uuid, long companyId,
			OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			notificationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the notifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notifications
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the notifications where topic = &#63;.
	 *
	 * @param topic the topic
	 * @return the matching notifications
	 */
	public static List<Notification> findByTopic(String topic) {
		return getPersistence().findByTopic(topic);
	}

	/**
	 * Returns a range of all the notifications where topic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param topic the topic
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of matching notifications
	 */
	public static List<Notification> findByTopic(
		String topic, int start, int end) {

		return getPersistence().findByTopic(topic, start, end);
	}

	/**
	 * Returns an ordered range of all the notifications where topic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param topic the topic
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByTopic(
		String topic, int start, int end,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().findByTopic(
			topic, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notifications where topic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param topic the topic
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByTopic(
		String topic, int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTopic(
			topic, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notification in the ordered set where topic = &#63;.
	 *
	 * @param topic the topic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByTopic_First(
			String topic, OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByTopic_First(topic, orderByComparator);
	}

	/**
	 * Returns the first notification in the ordered set where topic = &#63;.
	 *
	 * @param topic the topic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByTopic_First(
		String topic, OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByTopic_First(topic, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where topic = &#63;.
	 *
	 * @param topic the topic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByTopic_Last(
			String topic, OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByTopic_Last(topic, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where topic = &#63;.
	 *
	 * @param topic the topic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByTopic_Last(
		String topic, OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByTopic_Last(topic, orderByComparator);
	}

	/**
	 * Returns the notifications before and after the current notification in the ordered set where topic = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param topic the topic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public static Notification[] findByTopic_PrevAndNext(
			long notificationId, String topic,
			OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByTopic_PrevAndNext(
			notificationId, topic, orderByComparator);
	}

	/**
	 * Removes all the notifications where topic = &#63; from the database.
	 *
	 * @param topic the topic
	 */
	public static void removeByTopic(String topic) {
		getPersistence().removeByTopic(topic);
	}

	/**
	 * Returns the number of notifications where topic = &#63;.
	 *
	 * @param topic the topic
	 * @return the number of matching notifications
	 */
	public static int countByTopic(String topic) {
		return getPersistence().countByTopic(topic);
	}

	/**
	 * Returns all the notifications where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching notifications
	 */
	public static List<Notification> findByClientId(String clientId) {
		return getPersistence().findByClientId(clientId);
	}

	/**
	 * Returns a range of all the notifications where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of matching notifications
	 */
	public static List<Notification> findByClientId(
		String clientId, int start, int end) {

		return getPersistence().findByClientId(clientId, start, end);
	}

	/**
	 * Returns an ordered range of all the notifications where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByClientId(
		String clientId, int start, int end,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().findByClientId(
			clientId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notifications where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByClientId(
		String clientId, int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByClientId(
			clientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notification in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByClientId_First(
			String clientId, OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByClientId_First(
			clientId, orderByComparator);
	}

	/**
	 * Returns the first notification in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByClientId_First(
		String clientId, OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByClientId_First(
			clientId, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByClientId_Last(
			String clientId, OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByClientId_Last(
			clientId, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByClientId_Last(
		String clientId, OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByClientId_Last(
			clientId, orderByComparator);
	}

	/**
	 * Returns the notifications before and after the current notification in the ordered set where clientId = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public static Notification[] findByClientId_PrevAndNext(
			long notificationId, String clientId,
			OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByClientId_PrevAndNext(
			notificationId, clientId, orderByComparator);
	}

	/**
	 * Removes all the notifications where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	public static void removeByClientId(String clientId) {
		getPersistence().removeByClientId(clientId);
	}

	/**
	 * Returns the number of notifications where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching notifications
	 */
	public static int countByClientId(String clientId) {
		return getPersistence().countByClientId(clientId);
	}

	/**
	 * Returns all the notifications where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @return the matching notifications
	 */
	public static List<Notification> findByTopicAndClientId(
		String topic, String clientId) {

		return getPersistence().findByTopicAndClientId(topic, clientId);
	}

	/**
	 * Returns a range of all the notifications where topic = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of matching notifications
	 */
	public static List<Notification> findByTopicAndClientId(
		String topic, String clientId, int start, int end) {

		return getPersistence().findByTopicAndClientId(
			topic, clientId, start, end);
	}

	/**
	 * Returns an ordered range of all the notifications where topic = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByTopicAndClientId(
		String topic, String clientId, int start, int end,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().findByTopicAndClientId(
			topic, clientId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notifications where topic = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByTopicAndClientId(
		String topic, String clientId, int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTopicAndClientId(
			topic, clientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notification in the ordered set where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByTopicAndClientId_First(
			String topic, String clientId,
			OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByTopicAndClientId_First(
			topic, clientId, orderByComparator);
	}

	/**
	 * Returns the first notification in the ordered set where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByTopicAndClientId_First(
		String topic, String clientId,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByTopicAndClientId_First(
			topic, clientId, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByTopicAndClientId_Last(
			String topic, String clientId,
			OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByTopicAndClientId_Last(
			topic, clientId, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByTopicAndClientId_Last(
		String topic, String clientId,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByTopicAndClientId_Last(
			topic, clientId, orderByComparator);
	}

	/**
	 * Returns the notifications before and after the current notification in the ordered set where topic = &#63; and clientId = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public static Notification[] findByTopicAndClientId_PrevAndNext(
			long notificationId, String topic, String clientId,
			OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByTopicAndClientId_PrevAndNext(
			notificationId, topic, clientId, orderByComparator);
	}

	/**
	 * Removes all the notifications where topic = &#63; and clientId = &#63; from the database.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 */
	public static void removeByTopicAndClientId(String topic, String clientId) {
		getPersistence().removeByTopicAndClientId(topic, clientId);
	}

	/**
	 * Returns the number of notifications where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @return the number of matching notifications
	 */
	public static int countByTopicAndClientId(String topic, String clientId) {
		return getPersistence().countByTopicAndClientId(topic, clientId);
	}

	/**
	 * Returns all the notifications where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching notifications
	 */
	public static List<Notification> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the notifications where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of matching notifications
	 */
	public static List<Notification> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the notifications where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByStatus(
		int status, int start, int end,
		OrderByComparator<Notification> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notifications where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notifications
	 */
	public static List<Notification> findByStatus(
		int status, int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notification in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByStatus_First(
			int status, OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first notification in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByStatus_First(
		int status, OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public static Notification findByStatus_Last(
			int status, OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last notification in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public static Notification fetchByStatus_Last(
		int status, OrderByComparator<Notification> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the notifications before and after the current notification in the ordered set where status = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public static Notification[] findByStatus_PrevAndNext(
			long notificationId, int status,
			OrderByComparator<Notification> orderByComparator)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByStatus_PrevAndNext(
			notificationId, status, orderByComparator);
	}

	/**
	 * Removes all the notifications where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of notifications where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching notifications
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Caches the notification in the entity cache if it is enabled.
	 *
	 * @param notification the notification
	 */
	public static void cacheResult(Notification notification) {
		getPersistence().cacheResult(notification);
	}

	/**
	 * Caches the notifications in the entity cache if it is enabled.
	 *
	 * @param notifications the notifications
	 */
	public static void cacheResult(List<Notification> notifications) {
		getPersistence().cacheResult(notifications);
	}

	/**
	 * Creates a new notification with the primary key. Does not add the notification to the database.
	 *
	 * @param notificationId the primary key for the new notification
	 * @return the new notification
	 */
	public static Notification create(long notificationId) {
		return getPersistence().create(notificationId);
	}

	/**
	 * Removes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification that was removed
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public static Notification remove(long notificationId)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().remove(notificationId);
	}

	public static Notification updateImpl(Notification notification) {
		return getPersistence().updateImpl(notification);
	}

	/**
	 * Returns the notification with the primary key or throws a <code>NoSuchNotificationException</code> if it could not be found.
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public static Notification findByPrimaryKey(long notificationId)
		throws net.ayudh.portal.notification.exception.
			NoSuchNotificationException {

		return getPersistence().findByPrimaryKey(notificationId);
	}

	/**
	 * Returns the notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification, or <code>null</code> if a notification with the primary key could not be found
	 */
	public static Notification fetchByPrimaryKey(long notificationId) {
		return getPersistence().fetchByPrimaryKey(notificationId);
	}

	/**
	 * Returns all the notifications.
	 *
	 * @return the notifications
	 */
	public static List<Notification> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of notifications
	 */
	public static List<Notification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notifications
	 */
	public static List<Notification> findAll(
		int start, int end, OrderByComparator<Notification> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of notifications
	 */
	public static List<Notification> findAll(
		int start, int end, OrderByComparator<Notification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the notifications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of notifications.
	 *
	 * @return the number of notifications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NotificationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<NotificationPersistence, NotificationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NotificationPersistence.class);

		ServiceTracker<NotificationPersistence, NotificationPersistence>
			serviceTracker =
				new ServiceTracker
					<NotificationPersistence, NotificationPersistence>(
						bundle.getBundleContext(),
						NotificationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}