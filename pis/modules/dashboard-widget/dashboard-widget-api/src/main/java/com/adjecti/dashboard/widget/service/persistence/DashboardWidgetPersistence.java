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

package com.adjecti.dashboard.widget.service.persistence;

import com.adjecti.dashboard.widget.exception.NoSuchDashboardWidgetException;
import com.adjecti.dashboard.widget.model.DashboardWidget;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dashboard widget service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DashboardWidgetUtil
 * @generated
 */
@ProviderType
public interface DashboardWidgetPersistence
	extends BasePersistence<DashboardWidget> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DashboardWidgetUtil} to access the dashboard widget persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dashboard widgets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dashboard widgets
	 */
	public java.util.List<DashboardWidget> findByUuid(String uuid);

	/**
	 * Returns a range of all the dashboard widgets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DashboardWidgetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @return the range of matching dashboard widgets
	 */
	public java.util.List<DashboardWidget> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the dashboard widgets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DashboardWidgetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dashboard widgets
	 */
	public java.util.List<DashboardWidget> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dashboard widgets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DashboardWidgetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dashboard widgets
	 */
	public java.util.List<DashboardWidget> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dashboard widget in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dashboard widget
	 * @throws NoSuchDashboardWidgetException if a matching dashboard widget could not be found
	 */
	public DashboardWidget findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
				orderByComparator)
		throws NoSuchDashboardWidgetException;

	/**
	 * Returns the first dashboard widget in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dashboard widget, or <code>null</code> if a matching dashboard widget could not be found
	 */
	public DashboardWidget fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
			orderByComparator);

	/**
	 * Returns the last dashboard widget in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dashboard widget
	 * @throws NoSuchDashboardWidgetException if a matching dashboard widget could not be found
	 */
	public DashboardWidget findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
				orderByComparator)
		throws NoSuchDashboardWidgetException;

	/**
	 * Returns the last dashboard widget in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dashboard widget, or <code>null</code> if a matching dashboard widget could not be found
	 */
	public DashboardWidget fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
			orderByComparator);

	/**
	 * Returns the dashboard widgets before and after the current dashboard widget in the ordered set where uuid = &#63;.
	 *
	 * @param dashboardWidgetId the primary key of the current dashboard widget
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dashboard widget
	 * @throws NoSuchDashboardWidgetException if a dashboard widget with the primary key could not be found
	 */
	public DashboardWidget[] findByUuid_PrevAndNext(
			long dashboardWidgetId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
				orderByComparator)
		throws NoSuchDashboardWidgetException;

	/**
	 * Removes all the dashboard widgets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dashboard widgets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dashboard widgets
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dashboard widget where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDashboardWidgetException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dashboard widget
	 * @throws NoSuchDashboardWidgetException if a matching dashboard widget could not be found
	 */
	public DashboardWidget findByUUID_G(String uuid, long groupId)
		throws NoSuchDashboardWidgetException;

	/**
	 * Returns the dashboard widget where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dashboard widget, or <code>null</code> if a matching dashboard widget could not be found
	 */
	public DashboardWidget fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dashboard widget where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dashboard widget, or <code>null</code> if a matching dashboard widget could not be found
	 */
	public DashboardWidget fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dashboard widget where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dashboard widget that was removed
	 */
	public DashboardWidget removeByUUID_G(String uuid, long groupId)
		throws NoSuchDashboardWidgetException;

	/**
	 * Returns the number of dashboard widgets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dashboard widgets
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dashboard widgets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dashboard widgets
	 */
	public java.util.List<DashboardWidget> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the dashboard widgets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DashboardWidgetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @return the range of matching dashboard widgets
	 */
	public java.util.List<DashboardWidget> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the dashboard widgets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DashboardWidgetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dashboard widgets
	 */
	public java.util.List<DashboardWidget> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dashboard widgets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DashboardWidgetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dashboard widgets
	 */
	public java.util.List<DashboardWidget> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dashboard widget in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dashboard widget
	 * @throws NoSuchDashboardWidgetException if a matching dashboard widget could not be found
	 */
	public DashboardWidget findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
				orderByComparator)
		throws NoSuchDashboardWidgetException;

	/**
	 * Returns the first dashboard widget in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dashboard widget, or <code>null</code> if a matching dashboard widget could not be found
	 */
	public DashboardWidget fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
			orderByComparator);

	/**
	 * Returns the last dashboard widget in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dashboard widget
	 * @throws NoSuchDashboardWidgetException if a matching dashboard widget could not be found
	 */
	public DashboardWidget findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
				orderByComparator)
		throws NoSuchDashboardWidgetException;

	/**
	 * Returns the last dashboard widget in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dashboard widget, or <code>null</code> if a matching dashboard widget could not be found
	 */
	public DashboardWidget fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
			orderByComparator);

	/**
	 * Returns the dashboard widgets before and after the current dashboard widget in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dashboardWidgetId the primary key of the current dashboard widget
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dashboard widget
	 * @throws NoSuchDashboardWidgetException if a dashboard widget with the primary key could not be found
	 */
	public DashboardWidget[] findByUuid_C_PrevAndNext(
			long dashboardWidgetId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
				orderByComparator)
		throws NoSuchDashboardWidgetException;

	/**
	 * Removes all the dashboard widgets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dashboard widgets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dashboard widgets
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the dashboard widget where portletName = &#63; or throws a <code>NoSuchDashboardWidgetException</code> if it could not be found.
	 *
	 * @param portletName the portlet name
	 * @return the matching dashboard widget
	 * @throws NoSuchDashboardWidgetException if a matching dashboard widget could not be found
	 */
	public DashboardWidget findByportletName(String portletName)
		throws NoSuchDashboardWidgetException;

	/**
	 * Returns the dashboard widget where portletName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param portletName the portlet name
	 * @return the matching dashboard widget, or <code>null</code> if a matching dashboard widget could not be found
	 */
	public DashboardWidget fetchByportletName(String portletName);

	/**
	 * Returns the dashboard widget where portletName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param portletName the portlet name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dashboard widget, or <code>null</code> if a matching dashboard widget could not be found
	 */
	public DashboardWidget fetchByportletName(
		String portletName, boolean useFinderCache);

	/**
	 * Removes the dashboard widget where portletName = &#63; from the database.
	 *
	 * @param portletName the portlet name
	 * @return the dashboard widget that was removed
	 */
	public DashboardWidget removeByportletName(String portletName)
		throws NoSuchDashboardWidgetException;

	/**
	 * Returns the number of dashboard widgets where portletName = &#63;.
	 *
	 * @param portletName the portlet name
	 * @return the number of matching dashboard widgets
	 */
	public int countByportletName(String portletName);

	/**
	 * Caches the dashboard widget in the entity cache if it is enabled.
	 *
	 * @param dashboardWidget the dashboard widget
	 */
	public void cacheResult(DashboardWidget dashboardWidget);

	/**
	 * Caches the dashboard widgets in the entity cache if it is enabled.
	 *
	 * @param dashboardWidgets the dashboard widgets
	 */
	public void cacheResult(java.util.List<DashboardWidget> dashboardWidgets);

	/**
	 * Creates a new dashboard widget with the primary key. Does not add the dashboard widget to the database.
	 *
	 * @param dashboardWidgetId the primary key for the new dashboard widget
	 * @return the new dashboard widget
	 */
	public DashboardWidget create(long dashboardWidgetId);

	/**
	 * Removes the dashboard widget with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dashboardWidgetId the primary key of the dashboard widget
	 * @return the dashboard widget that was removed
	 * @throws NoSuchDashboardWidgetException if a dashboard widget with the primary key could not be found
	 */
	public DashboardWidget remove(long dashboardWidgetId)
		throws NoSuchDashboardWidgetException;

	public DashboardWidget updateImpl(DashboardWidget dashboardWidget);

	/**
	 * Returns the dashboard widget with the primary key or throws a <code>NoSuchDashboardWidgetException</code> if it could not be found.
	 *
	 * @param dashboardWidgetId the primary key of the dashboard widget
	 * @return the dashboard widget
	 * @throws NoSuchDashboardWidgetException if a dashboard widget with the primary key could not be found
	 */
	public DashboardWidget findByPrimaryKey(long dashboardWidgetId)
		throws NoSuchDashboardWidgetException;

	/**
	 * Returns the dashboard widget with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dashboardWidgetId the primary key of the dashboard widget
	 * @return the dashboard widget, or <code>null</code> if a dashboard widget with the primary key could not be found
	 */
	public DashboardWidget fetchByPrimaryKey(long dashboardWidgetId);

	/**
	 * Returns all the dashboard widgets.
	 *
	 * @return the dashboard widgets
	 */
	public java.util.List<DashboardWidget> findAll();

	/**
	 * Returns a range of all the dashboard widgets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DashboardWidgetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @return the range of dashboard widgets
	 */
	public java.util.List<DashboardWidget> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dashboard widgets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DashboardWidgetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dashboard widgets
	 */
	public java.util.List<DashboardWidget> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dashboard widgets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DashboardWidgetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dashboard widgets
	 */
	public java.util.List<DashboardWidget> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DashboardWidget>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dashboard widgets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dashboard widgets.
	 *
	 * @return the number of dashboard widgets
	 */
	public int countAll();

}