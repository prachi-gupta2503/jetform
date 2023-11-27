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

package com.adjecti.jetform.liferay.service.persistence;

import com.adjecti.jetform.liferay.model.EntityWorkflow;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the entity workflow service. This utility wraps <code>com.adjecti.jetform.liferay.service.persistence.impl.EntityWorkflowPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityWorkflowPersistence
 * @generated
 */
public class EntityWorkflowUtil {

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
	public static void clearCache(EntityWorkflow entityWorkflow) {
		getPersistence().clearCache(entityWorkflow);
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
	public static Map<Serializable, EntityWorkflow> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EntityWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EntityWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EntityWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EntityWorkflow> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EntityWorkflow update(EntityWorkflow entityWorkflow) {
		return getPersistence().update(entityWorkflow);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EntityWorkflow update(
		EntityWorkflow entityWorkflow, ServiceContext serviceContext) {

		return getPersistence().update(entityWorkflow, serviceContext);
	}

	/**
	 * Returns all the entity workflows where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching entity workflows
	 */
	public static List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK) {

		return getPersistence().findByClassNameAndClassPK(className, classPK);
	}

	/**
	 * Returns a range of all the entity workflows where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EntityWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of entity workflows
	 * @param end the upper bound of the range of entity workflows (not inclusive)
	 * @return the range of matching entity workflows
	 */
	public static List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK, int start, int end) {

		return getPersistence().findByClassNameAndClassPK(
			className, classPK, start, end);
	}

	/**
	 * Returns an ordered range of all the entity workflows where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EntityWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of entity workflows
	 * @param end the upper bound of the range of entity workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching entity workflows
	 */
	public static List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK, int start, int end,
		OrderByComparator<EntityWorkflow> orderByComparator) {

		return getPersistence().findByClassNameAndClassPK(
			className, classPK, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the entity workflows where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EntityWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of entity workflows
	 * @param end the upper bound of the range of entity workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching entity workflows
	 */
	public static List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK, int start, int end,
		OrderByComparator<EntityWorkflow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByClassNameAndClassPK(
			className, classPK, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity workflow
	 * @throws NoSuchEntityWorkflowException if a matching entity workflow could not be found
	 */
	public static EntityWorkflow findByClassNameAndClassPK_First(
			String className, long classPK,
			OrderByComparator<EntityWorkflow> orderByComparator)
		throws com.adjecti.jetform.liferay.exception.
			NoSuchEntityWorkflowException {

		return getPersistence().findByClassNameAndClassPK_First(
			className, classPK, orderByComparator);
	}

	/**
	 * Returns the first entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity workflow, or <code>null</code> if a matching entity workflow could not be found
	 */
	public static EntityWorkflow fetchByClassNameAndClassPK_First(
		String className, long classPK,
		OrderByComparator<EntityWorkflow> orderByComparator) {

		return getPersistence().fetchByClassNameAndClassPK_First(
			className, classPK, orderByComparator);
	}

	/**
	 * Returns the last entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity workflow
	 * @throws NoSuchEntityWorkflowException if a matching entity workflow could not be found
	 */
	public static EntityWorkflow findByClassNameAndClassPK_Last(
			String className, long classPK,
			OrderByComparator<EntityWorkflow> orderByComparator)
		throws com.adjecti.jetform.liferay.exception.
			NoSuchEntityWorkflowException {

		return getPersistence().findByClassNameAndClassPK_Last(
			className, classPK, orderByComparator);
	}

	/**
	 * Returns the last entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity workflow, or <code>null</code> if a matching entity workflow could not be found
	 */
	public static EntityWorkflow fetchByClassNameAndClassPK_Last(
		String className, long classPK,
		OrderByComparator<EntityWorkflow> orderByComparator) {

		return getPersistence().fetchByClassNameAndClassPK_Last(
			className, classPK, orderByComparator);
	}

	/**
	 * Returns the entity workflows before and after the current entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param entityWorkflowId the primary key of the current entity workflow
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next entity workflow
	 * @throws NoSuchEntityWorkflowException if a entity workflow with the primary key could not be found
	 */
	public static EntityWorkflow[] findByClassNameAndClassPK_PrevAndNext(
			long entityWorkflowId, String className, long classPK,
			OrderByComparator<EntityWorkflow> orderByComparator)
		throws com.adjecti.jetform.liferay.exception.
			NoSuchEntityWorkflowException {

		return getPersistence().findByClassNameAndClassPK_PrevAndNext(
			entityWorkflowId, className, classPK, orderByComparator);
	}

	/**
	 * Removes all the entity workflows where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 */
	public static void removeByClassNameAndClassPK(
		String className, long classPK) {

		getPersistence().removeByClassNameAndClassPK(className, classPK);
	}

	/**
	 * Returns the number of entity workflows where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching entity workflows
	 */
	public static int countByClassNameAndClassPK(
		String className, long classPK) {

		return getPersistence().countByClassNameAndClassPK(className, classPK);
	}

	/**
	 * Caches the entity workflow in the entity cache if it is enabled.
	 *
	 * @param entityWorkflow the entity workflow
	 */
	public static void cacheResult(EntityWorkflow entityWorkflow) {
		getPersistence().cacheResult(entityWorkflow);
	}

	/**
	 * Caches the entity workflows in the entity cache if it is enabled.
	 *
	 * @param entityWorkflows the entity workflows
	 */
	public static void cacheResult(List<EntityWorkflow> entityWorkflows) {
		getPersistence().cacheResult(entityWorkflows);
	}

	/**
	 * Creates a new entity workflow with the primary key. Does not add the entity workflow to the database.
	 *
	 * @param entityWorkflowId the primary key for the new entity workflow
	 * @return the new entity workflow
	 */
	public static EntityWorkflow create(long entityWorkflowId) {
		return getPersistence().create(entityWorkflowId);
	}

	/**
	 * Removes the entity workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow that was removed
	 * @throws NoSuchEntityWorkflowException if a entity workflow with the primary key could not be found
	 */
	public static EntityWorkflow remove(long entityWorkflowId)
		throws com.adjecti.jetform.liferay.exception.
			NoSuchEntityWorkflowException {

		return getPersistence().remove(entityWorkflowId);
	}

	public static EntityWorkflow updateImpl(EntityWorkflow entityWorkflow) {
		return getPersistence().updateImpl(entityWorkflow);
	}

	/**
	 * Returns the entity workflow with the primary key or throws a <code>NoSuchEntityWorkflowException</code> if it could not be found.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow
	 * @throws NoSuchEntityWorkflowException if a entity workflow with the primary key could not be found
	 */
	public static EntityWorkflow findByPrimaryKey(long entityWorkflowId)
		throws com.adjecti.jetform.liferay.exception.
			NoSuchEntityWorkflowException {

		return getPersistence().findByPrimaryKey(entityWorkflowId);
	}

	/**
	 * Returns the entity workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow, or <code>null</code> if a entity workflow with the primary key could not be found
	 */
	public static EntityWorkflow fetchByPrimaryKey(long entityWorkflowId) {
		return getPersistence().fetchByPrimaryKey(entityWorkflowId);
	}

	/**
	 * Returns all the entity workflows.
	 *
	 * @return the entity workflows
	 */
	public static List<EntityWorkflow> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the entity workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EntityWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity workflows
	 * @param end the upper bound of the range of entity workflows (not inclusive)
	 * @return the range of entity workflows
	 */
	public static List<EntityWorkflow> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the entity workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EntityWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity workflows
	 * @param end the upper bound of the range of entity workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of entity workflows
	 */
	public static List<EntityWorkflow> findAll(
		int start, int end,
		OrderByComparator<EntityWorkflow> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the entity workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EntityWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity workflows
	 * @param end the upper bound of the range of entity workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of entity workflows
	 */
	public static List<EntityWorkflow> findAll(
		int start, int end, OrderByComparator<EntityWorkflow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the entity workflows from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of entity workflows.
	 *
	 * @return the number of entity workflows
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EntityWorkflowPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EntityWorkflowPersistence, EntityWorkflowPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EntityWorkflowPersistence.class);

		ServiceTracker<EntityWorkflowPersistence, EntityWorkflowPersistence>
			serviceTracker =
				new ServiceTracker
					<EntityWorkflowPersistence, EntityWorkflowPersistence>(
						bundle.getBundleContext(),
						EntityWorkflowPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}