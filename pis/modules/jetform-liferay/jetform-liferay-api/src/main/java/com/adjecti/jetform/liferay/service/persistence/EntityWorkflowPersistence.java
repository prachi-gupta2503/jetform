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

import com.adjecti.jetform.liferay.exception.NoSuchEntityWorkflowException;
import com.adjecti.jetform.liferay.model.EntityWorkflow;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the entity workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityWorkflowUtil
 * @generated
 */
@ProviderType
public interface EntityWorkflowPersistence
	extends BasePersistence<EntityWorkflow> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EntityWorkflowUtil} to access the entity workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the entity workflows where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching entity workflows
	 */
	public java.util.List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK);

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
	public java.util.List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK, int start, int end);

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
	public java.util.List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntityWorkflow>
			orderByComparator);

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
	public java.util.List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntityWorkflow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity workflow
	 * @throws NoSuchEntityWorkflowException if a matching entity workflow could not be found
	 */
	public EntityWorkflow findByClassNameAndClassPK_First(
			String className, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<EntityWorkflow>
				orderByComparator)
		throws NoSuchEntityWorkflowException;

	/**
	 * Returns the first entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity workflow, or <code>null</code> if a matching entity workflow could not be found
	 */
	public EntityWorkflow fetchByClassNameAndClassPK_First(
		String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<EntityWorkflow>
			orderByComparator);

	/**
	 * Returns the last entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity workflow
	 * @throws NoSuchEntityWorkflowException if a matching entity workflow could not be found
	 */
	public EntityWorkflow findByClassNameAndClassPK_Last(
			String className, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<EntityWorkflow>
				orderByComparator)
		throws NoSuchEntityWorkflowException;

	/**
	 * Returns the last entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity workflow, or <code>null</code> if a matching entity workflow could not be found
	 */
	public EntityWorkflow fetchByClassNameAndClassPK_Last(
		String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<EntityWorkflow>
			orderByComparator);

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
	public EntityWorkflow[] findByClassNameAndClassPK_PrevAndNext(
			long entityWorkflowId, String className, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<EntityWorkflow>
				orderByComparator)
		throws NoSuchEntityWorkflowException;

	/**
	 * Removes all the entity workflows where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 */
	public void removeByClassNameAndClassPK(String className, long classPK);

	/**
	 * Returns the number of entity workflows where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching entity workflows
	 */
	public int countByClassNameAndClassPK(String className, long classPK);

	/**
	 * Caches the entity workflow in the entity cache if it is enabled.
	 *
	 * @param entityWorkflow the entity workflow
	 */
	public void cacheResult(EntityWorkflow entityWorkflow);

	/**
	 * Caches the entity workflows in the entity cache if it is enabled.
	 *
	 * @param entityWorkflows the entity workflows
	 */
	public void cacheResult(java.util.List<EntityWorkflow> entityWorkflows);

	/**
	 * Creates a new entity workflow with the primary key. Does not add the entity workflow to the database.
	 *
	 * @param entityWorkflowId the primary key for the new entity workflow
	 * @return the new entity workflow
	 */
	public EntityWorkflow create(long entityWorkflowId);

	/**
	 * Removes the entity workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow that was removed
	 * @throws NoSuchEntityWorkflowException if a entity workflow with the primary key could not be found
	 */
	public EntityWorkflow remove(long entityWorkflowId)
		throws NoSuchEntityWorkflowException;

	public EntityWorkflow updateImpl(EntityWorkflow entityWorkflow);

	/**
	 * Returns the entity workflow with the primary key or throws a <code>NoSuchEntityWorkflowException</code> if it could not be found.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow
	 * @throws NoSuchEntityWorkflowException if a entity workflow with the primary key could not be found
	 */
	public EntityWorkflow findByPrimaryKey(long entityWorkflowId)
		throws NoSuchEntityWorkflowException;

	/**
	 * Returns the entity workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow, or <code>null</code> if a entity workflow with the primary key could not be found
	 */
	public EntityWorkflow fetchByPrimaryKey(long entityWorkflowId);

	/**
	 * Returns all the entity workflows.
	 *
	 * @return the entity workflows
	 */
	public java.util.List<EntityWorkflow> findAll();

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
	public java.util.List<EntityWorkflow> findAll(int start, int end);

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
	public java.util.List<EntityWorkflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntityWorkflow>
			orderByComparator);

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
	public java.util.List<EntityWorkflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntityWorkflow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the entity workflows from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of entity workflows.
	 *
	 * @return the number of entity workflows
	 */
	public int countAll();

}