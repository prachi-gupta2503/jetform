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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import net.ayudh.portal.notification.exception.NoSuchNotificationException;
import net.ayudh.portal.notification.model.Notification;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationUtil
 * @generated
 */
@ProviderType
public interface NotificationPersistence extends BasePersistence<Notification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificationUtil} to access the notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the notifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notifications
	 */
	public java.util.List<Notification> findByUuid(String uuid);

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
	public java.util.List<Notification> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Notification> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

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
	public java.util.List<Notification> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the first notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

	/**
	 * Returns the last notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the last notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

	/**
	 * Returns the notifications before and after the current notification in the ordered set where uuid = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public Notification[] findByUuid_PrevAndNext(
			long notificationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Removes all the notifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of notifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notifications
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the notification where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNotificationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByUUID_G(String uuid, long groupId)
		throws NoSuchNotificationException;

	/**
	 * Returns the notification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the notification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the notification where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the notification that was removed
	 */
	public Notification removeByUUID_G(String uuid, long groupId)
		throws NoSuchNotificationException;

	/**
	 * Returns the number of notifications where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notifications
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notifications
	 */
	public java.util.List<Notification> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<Notification> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Notification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

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
	public java.util.List<Notification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the first notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

	/**
	 * Returns the last notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the last notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

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
	public Notification[] findByUuid_C_PrevAndNext(
			long notificationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Removes all the notifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notifications
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the notifications where topic = &#63;.
	 *
	 * @param topic the topic
	 * @return the matching notifications
	 */
	public java.util.List<Notification> findByTopic(String topic);

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
	public java.util.List<Notification> findByTopic(
		String topic, int start, int end);

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
	public java.util.List<Notification> findByTopic(
		String topic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

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
	public java.util.List<Notification> findByTopic(
		String topic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notification in the ordered set where topic = &#63;.
	 *
	 * @param topic the topic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByTopic_First(
			String topic,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the first notification in the ordered set where topic = &#63;.
	 *
	 * @param topic the topic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByTopic_First(
		String topic,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

	/**
	 * Returns the last notification in the ordered set where topic = &#63;.
	 *
	 * @param topic the topic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByTopic_Last(
			String topic,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the last notification in the ordered set where topic = &#63;.
	 *
	 * @param topic the topic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByTopic_Last(
		String topic,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

	/**
	 * Returns the notifications before and after the current notification in the ordered set where topic = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param topic the topic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public Notification[] findByTopic_PrevAndNext(
			long notificationId, String topic,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Removes all the notifications where topic = &#63; from the database.
	 *
	 * @param topic the topic
	 */
	public void removeByTopic(String topic);

	/**
	 * Returns the number of notifications where topic = &#63;.
	 *
	 * @param topic the topic
	 * @return the number of matching notifications
	 */
	public int countByTopic(String topic);

	/**
	 * Returns all the notifications where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching notifications
	 */
	public java.util.List<Notification> findByClientId(String clientId);

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
	public java.util.List<Notification> findByClientId(
		String clientId, int start, int end);

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
	public java.util.List<Notification> findByClientId(
		String clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

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
	public java.util.List<Notification> findByClientId(
		String clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notification in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByClientId_First(
			String clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the first notification in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByClientId_First(
		String clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

	/**
	 * Returns the last notification in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByClientId_Last(
			String clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the last notification in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByClientId_Last(
		String clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

	/**
	 * Returns the notifications before and after the current notification in the ordered set where clientId = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public Notification[] findByClientId_PrevAndNext(
			long notificationId, String clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Removes all the notifications where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	public void removeByClientId(String clientId);

	/**
	 * Returns the number of notifications where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching notifications
	 */
	public int countByClientId(String clientId);

	/**
	 * Returns all the notifications where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @return the matching notifications
	 */
	public java.util.List<Notification> findByTopicAndClientId(
		String topic, String clientId);

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
	public java.util.List<Notification> findByTopicAndClientId(
		String topic, String clientId, int start, int end);

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
	public java.util.List<Notification> findByTopicAndClientId(
		String topic, String clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

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
	public java.util.List<Notification> findByTopicAndClientId(
		String topic, String clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notification in the ordered set where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByTopicAndClientId_First(
			String topic, String clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the first notification in the ordered set where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByTopicAndClientId_First(
		String topic, String clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

	/**
	 * Returns the last notification in the ordered set where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByTopicAndClientId_Last(
			String topic, String clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the last notification in the ordered set where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByTopicAndClientId_Last(
		String topic, String clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

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
	public Notification[] findByTopicAndClientId_PrevAndNext(
			long notificationId, String topic, String clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Removes all the notifications where topic = &#63; and clientId = &#63; from the database.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 */
	public void removeByTopicAndClientId(String topic, String clientId);

	/**
	 * Returns the number of notifications where topic = &#63; and clientId = &#63;.
	 *
	 * @param topic the topic
	 * @param clientId the client ID
	 * @return the number of matching notifications
	 */
	public int countByTopicAndClientId(String topic, String clientId);

	/**
	 * Returns all the notifications where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching notifications
	 */
	public java.util.List<Notification> findByStatus(int status);

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
	public java.util.List<Notification> findByStatus(
		int status, int start, int end);

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
	public java.util.List<Notification> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

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
	public java.util.List<Notification> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notification in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the first notification in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

	/**
	 * Returns the last notification in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	public Notification findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Returns the last notification in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	public Notification fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

	/**
	 * Returns the notifications before and after the current notification in the ordered set where status = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public Notification[] findByStatus_PrevAndNext(
			long notificationId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Notification>
				orderByComparator)
		throws NoSuchNotificationException;

	/**
	 * Removes all the notifications where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of notifications where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching notifications
	 */
	public int countByStatus(int status);

	/**
	 * Caches the notification in the entity cache if it is enabled.
	 *
	 * @param notification the notification
	 */
	public void cacheResult(Notification notification);

	/**
	 * Caches the notifications in the entity cache if it is enabled.
	 *
	 * @param notifications the notifications
	 */
	public void cacheResult(java.util.List<Notification> notifications);

	/**
	 * Creates a new notification with the primary key. Does not add the notification to the database.
	 *
	 * @param notificationId the primary key for the new notification
	 * @return the new notification
	 */
	public Notification create(long notificationId);

	/**
	 * Removes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification that was removed
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public Notification remove(long notificationId)
		throws NoSuchNotificationException;

	public Notification updateImpl(Notification notification);

	/**
	 * Returns the notification with the primary key or throws a <code>NoSuchNotificationException</code> if it could not be found.
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	public Notification findByPrimaryKey(long notificationId)
		throws NoSuchNotificationException;

	/**
	 * Returns the notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification, or <code>null</code> if a notification with the primary key could not be found
	 */
	public Notification fetchByPrimaryKey(long notificationId);

	/**
	 * Returns all the notifications.
	 *
	 * @return the notifications
	 */
	public java.util.List<Notification> findAll();

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
	public java.util.List<Notification> findAll(int start, int end);

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
	public java.util.List<Notification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator);

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
	public java.util.List<Notification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the notifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of notifications.
	 *
	 * @return the number of notifications
	 */
	public int countAll();

}