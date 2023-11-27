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

package com.adjecti.jetform.liferay.service.persistence.impl;

import com.adjecti.jetform.liferay.exception.NoSuchEntityWorkflowException;
import com.adjecti.jetform.liferay.model.EntityWorkflow;
import com.adjecti.jetform.liferay.model.impl.EntityWorkflowImpl;
import com.adjecti.jetform.liferay.model.impl.EntityWorkflowModelImpl;
import com.adjecti.jetform.liferay.service.persistence.EntityWorkflowPersistence;
import com.adjecti.jetform.liferay.service.persistence.impl.constants.jetformPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the entity workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EntityWorkflowPersistence.class)
public class EntityWorkflowPersistenceImpl
	extends BasePersistenceImpl<EntityWorkflow>
	implements EntityWorkflowPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EntityWorkflowUtil</code> to access the entity workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EntityWorkflowImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByClassNameAndClassPK;
	private FinderPath _finderPathWithoutPaginationFindByClassNameAndClassPK;
	private FinderPath _finderPathCountByClassNameAndClassPK;

	/**
	 * Returns all the entity workflows where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching entity workflows
	 */
	@Override
	public List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK) {

		return findByClassNameAndClassPK(
			className, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK, int start, int end) {

		return findByClassNameAndClassPK(className, classPK, start, end, null);
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
	@Override
	public List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK, int start, int end,
		OrderByComparator<EntityWorkflow> orderByComparator) {

		return findByClassNameAndClassPK(
			className, classPK, start, end, orderByComparator, true);
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
	@Override
	public List<EntityWorkflow> findByClassNameAndClassPK(
		String className, long classPK, int start, int end,
		OrderByComparator<EntityWorkflow> orderByComparator,
		boolean useFinderCache) {

		className = Objects.toString(className, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByClassNameAndClassPK;
				finderArgs = new Object[] {className, classPK};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByClassNameAndClassPK;
			finderArgs = new Object[] {
				className, classPK, start, end, orderByComparator
			};
		}

		List<EntityWorkflow> list = null;

		if (useFinderCache) {
			list = (List<EntityWorkflow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EntityWorkflow entityWorkflow : list) {
					if (!className.equals(entityWorkflow.getClassName()) ||
						(classPK != entityWorkflow.getClassPK())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ENTITYWORKFLOW_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2);
			}

			sb.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EntityWorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClassName) {
					queryPos.add(StringUtil.toLowerCase(className));
				}

				queryPos.add(classPK);

				list = (List<EntityWorkflow>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityWorkflow findByClassNameAndClassPK_First(
			String className, long classPK,
			OrderByComparator<EntityWorkflow> orderByComparator)
		throws NoSuchEntityWorkflowException {

		EntityWorkflow entityWorkflow = fetchByClassNameAndClassPK_First(
			className, classPK, orderByComparator);

		if (entityWorkflow != null) {
			return entityWorkflow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("className=");
		sb.append(className);

		sb.append(", classPK=");
		sb.append(classPK);

		sb.append("}");

		throw new NoSuchEntityWorkflowException(sb.toString());
	}

	/**
	 * Returns the first entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity workflow, or <code>null</code> if a matching entity workflow could not be found
	 */
	@Override
	public EntityWorkflow fetchByClassNameAndClassPK_First(
		String className, long classPK,
		OrderByComparator<EntityWorkflow> orderByComparator) {

		List<EntityWorkflow> list = findByClassNameAndClassPK(
			className, classPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityWorkflow findByClassNameAndClassPK_Last(
			String className, long classPK,
			OrderByComparator<EntityWorkflow> orderByComparator)
		throws NoSuchEntityWorkflowException {

		EntityWorkflow entityWorkflow = fetchByClassNameAndClassPK_Last(
			className, classPK, orderByComparator);

		if (entityWorkflow != null) {
			return entityWorkflow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("className=");
		sb.append(className);

		sb.append(", classPK=");
		sb.append(classPK);

		sb.append("}");

		throw new NoSuchEntityWorkflowException(sb.toString());
	}

	/**
	 * Returns the last entity workflow in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity workflow, or <code>null</code> if a matching entity workflow could not be found
	 */
	@Override
	public EntityWorkflow fetchByClassNameAndClassPK_Last(
		String className, long classPK,
		OrderByComparator<EntityWorkflow> orderByComparator) {

		int count = countByClassNameAndClassPK(className, classPK);

		if (count == 0) {
			return null;
		}

		List<EntityWorkflow> list = findByClassNameAndClassPK(
			className, classPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityWorkflow[] findByClassNameAndClassPK_PrevAndNext(
			long entityWorkflowId, String className, long classPK,
			OrderByComparator<EntityWorkflow> orderByComparator)
		throws NoSuchEntityWorkflowException {

		className = Objects.toString(className, "");

		EntityWorkflow entityWorkflow = findByPrimaryKey(entityWorkflowId);

		Session session = null;

		try {
			session = openSession();

			EntityWorkflow[] array = new EntityWorkflowImpl[3];

			array[0] = getByClassNameAndClassPK_PrevAndNext(
				session, entityWorkflow, className, classPK, orderByComparator,
				true);

			array[1] = entityWorkflow;

			array[2] = getByClassNameAndClassPK_PrevAndNext(
				session, entityWorkflow, className, classPK, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityWorkflow getByClassNameAndClassPK_PrevAndNext(
		Session session, EntityWorkflow entityWorkflow, String className,
		long classPK, OrderByComparator<EntityWorkflow> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ENTITYWORKFLOW_WHERE);

		boolean bindClassName = false;

		if (className.isEmpty()) {
			sb.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			sb.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2);
		}

		sb.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EntityWorkflowModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindClassName) {
			queryPos.add(StringUtil.toLowerCase(className));
		}

		queryPos.add(classPK);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						entityWorkflow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EntityWorkflow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity workflows where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 */
	@Override
	public void removeByClassNameAndClassPK(String className, long classPK) {
		for (EntityWorkflow entityWorkflow :
				findByClassNameAndClassPK(
					className, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(entityWorkflow);
		}
	}

	/**
	 * Returns the number of entity workflows where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching entity workflows
	 */
	@Override
	public int countByClassNameAndClassPK(String className, long classPK) {
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByClassNameAndClassPK;

		Object[] finderArgs = new Object[] {className, classPK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ENTITYWORKFLOW_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2);
			}

			sb.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClassName) {
					queryPos.add(StringUtil.toLowerCase(className));
				}

				queryPos.add(classPK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2 =
		"lower(entityWorkflow.className) = ? AND ";

	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3 =
		"(entityWorkflow.className IS NULL OR entityWorkflow.className = '') AND ";

	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2 =
		"entityWorkflow.classPK = ?";

	public EntityWorkflowPersistenceImpl() {
		setModelClass(EntityWorkflow.class);

		setModelImplClass(EntityWorkflowImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the entity workflow in the entity cache if it is enabled.
	 *
	 * @param entityWorkflow the entity workflow
	 */
	@Override
	public void cacheResult(EntityWorkflow entityWorkflow) {
		entityCache.putResult(
			EntityWorkflowImpl.class, entityWorkflow.getPrimaryKey(),
			entityWorkflow);
	}

	/**
	 * Caches the entity workflows in the entity cache if it is enabled.
	 *
	 * @param entityWorkflows the entity workflows
	 */
	@Override
	public void cacheResult(List<EntityWorkflow> entityWorkflows) {
		for (EntityWorkflow entityWorkflow : entityWorkflows) {
			if (entityCache.getResult(
					EntityWorkflowImpl.class, entityWorkflow.getPrimaryKey()) ==
						null) {

				cacheResult(entityWorkflow);
			}
		}
	}

	/**
	 * Clears the cache for all entity workflows.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EntityWorkflowImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the entity workflow.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EntityWorkflow entityWorkflow) {
		entityCache.removeResult(EntityWorkflowImpl.class, entityWorkflow);
	}

	@Override
	public void clearCache(List<EntityWorkflow> entityWorkflows) {
		for (EntityWorkflow entityWorkflow : entityWorkflows) {
			entityCache.removeResult(EntityWorkflowImpl.class, entityWorkflow);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EntityWorkflowImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new entity workflow with the primary key. Does not add the entity workflow to the database.
	 *
	 * @param entityWorkflowId the primary key for the new entity workflow
	 * @return the new entity workflow
	 */
	@Override
	public EntityWorkflow create(long entityWorkflowId) {
		EntityWorkflow entityWorkflow = new EntityWorkflowImpl();

		entityWorkflow.setNew(true);
		entityWorkflow.setPrimaryKey(entityWorkflowId);

		entityWorkflow.setCompanyId(CompanyThreadLocal.getCompanyId());

		return entityWorkflow;
	}

	/**
	 * Removes the entity workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow that was removed
	 * @throws NoSuchEntityWorkflowException if a entity workflow with the primary key could not be found
	 */
	@Override
	public EntityWorkflow remove(long entityWorkflowId)
		throws NoSuchEntityWorkflowException {

		return remove((Serializable)entityWorkflowId);
	}

	/**
	 * Removes the entity workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the entity workflow
	 * @return the entity workflow that was removed
	 * @throws NoSuchEntityWorkflowException if a entity workflow with the primary key could not be found
	 */
	@Override
	public EntityWorkflow remove(Serializable primaryKey)
		throws NoSuchEntityWorkflowException {

		Session session = null;

		try {
			session = openSession();

			EntityWorkflow entityWorkflow = (EntityWorkflow)session.get(
				EntityWorkflowImpl.class, primaryKey);

			if (entityWorkflow == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntityWorkflowException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(entityWorkflow);
		}
		catch (NoSuchEntityWorkflowException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EntityWorkflow removeImpl(EntityWorkflow entityWorkflow) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(entityWorkflow)) {
				entityWorkflow = (EntityWorkflow)session.get(
					EntityWorkflowImpl.class,
					entityWorkflow.getPrimaryKeyObj());
			}

			if (entityWorkflow != null) {
				session.delete(entityWorkflow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (entityWorkflow != null) {
			clearCache(entityWorkflow);
		}

		return entityWorkflow;
	}

	@Override
	public EntityWorkflow updateImpl(EntityWorkflow entityWorkflow) {
		boolean isNew = entityWorkflow.isNew();

		if (!(entityWorkflow instanceof EntityWorkflowModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(entityWorkflow.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					entityWorkflow);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in entityWorkflow proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EntityWorkflow implementation " +
					entityWorkflow.getClass());
		}

		EntityWorkflowModelImpl entityWorkflowModelImpl =
			(EntityWorkflowModelImpl)entityWorkflow;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (entityWorkflow.getCreateDate() == null)) {
			if (serviceContext == null) {
				entityWorkflow.setCreateDate(now);
			}
			else {
				entityWorkflow.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!entityWorkflowModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				entityWorkflow.setModifiedDate(now);
			}
			else {
				entityWorkflow.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(entityWorkflow);
			}
			else {
				entityWorkflow = (EntityWorkflow)session.merge(entityWorkflow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EntityWorkflowImpl.class, entityWorkflowModelImpl, false, true);

		if (isNew) {
			entityWorkflow.setNew(false);
		}

		entityWorkflow.resetOriginalValues();

		return entityWorkflow;
	}

	/**
	 * Returns the entity workflow with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the entity workflow
	 * @return the entity workflow
	 * @throws NoSuchEntityWorkflowException if a entity workflow with the primary key could not be found
	 */
	@Override
	public EntityWorkflow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntityWorkflowException {

		EntityWorkflow entityWorkflow = fetchByPrimaryKey(primaryKey);

		if (entityWorkflow == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntityWorkflowException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return entityWorkflow;
	}

	/**
	 * Returns the entity workflow with the primary key or throws a <code>NoSuchEntityWorkflowException</code> if it could not be found.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow
	 * @throws NoSuchEntityWorkflowException if a entity workflow with the primary key could not be found
	 */
	@Override
	public EntityWorkflow findByPrimaryKey(long entityWorkflowId)
		throws NoSuchEntityWorkflowException {

		return findByPrimaryKey((Serializable)entityWorkflowId);
	}

	/**
	 * Returns the entity workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow, or <code>null</code> if a entity workflow with the primary key could not be found
	 */
	@Override
	public EntityWorkflow fetchByPrimaryKey(long entityWorkflowId) {
		return fetchByPrimaryKey((Serializable)entityWorkflowId);
	}

	/**
	 * Returns all the entity workflows.
	 *
	 * @return the entity workflows
	 */
	@Override
	public List<EntityWorkflow> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityWorkflow> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<EntityWorkflow> findAll(
		int start, int end,
		OrderByComparator<EntityWorkflow> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<EntityWorkflow> findAll(
		int start, int end, OrderByComparator<EntityWorkflow> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<EntityWorkflow> list = null;

		if (useFinderCache) {
			list = (List<EntityWorkflow>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ENTITYWORKFLOW);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ENTITYWORKFLOW;

				sql = sql.concat(EntityWorkflowModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EntityWorkflow>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the entity workflows from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EntityWorkflow entityWorkflow : findAll()) {
			remove(entityWorkflow);
		}
	}

	/**
	 * Returns the number of entity workflows.
	 *
	 * @return the number of entity workflows
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ENTITYWORKFLOW);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "entityWorkflowId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ENTITYWORKFLOW;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EntityWorkflowModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the entity workflow persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EntityWorkflowModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EntityWorkflow.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByClassNameAndClassPK = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassNameAndClassPK",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"className", "classPK"}, true);

		_finderPathWithoutPaginationFindByClassNameAndClassPK =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByClassNameAndClassPK",
				new String[] {String.class.getName(), Long.class.getName()},
				new String[] {"className", "classPK"}, true);

		_finderPathCountByClassNameAndClassPK = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameAndClassPK",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"className", "classPK"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EntityWorkflowImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = jetformPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = jetformPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = jetformPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ENTITYWORKFLOW =
		"SELECT entityWorkflow FROM EntityWorkflow entityWorkflow";

	private static final String _SQL_SELECT_ENTITYWORKFLOW_WHERE =
		"SELECT entityWorkflow FROM EntityWorkflow entityWorkflow WHERE ";

	private static final String _SQL_COUNT_ENTITYWORKFLOW =
		"SELECT COUNT(entityWorkflow) FROM EntityWorkflow entityWorkflow";

	private static final String _SQL_COUNT_ENTITYWORKFLOW_WHERE =
		"SELECT COUNT(entityWorkflow) FROM EntityWorkflow entityWorkflow WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "entityWorkflow.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EntityWorkflow exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EntityWorkflow exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EntityWorkflowPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class EntityWorkflowModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			EntityWorkflowModelImpl entityWorkflowModelImpl =
				(EntityWorkflowModelImpl)baseModel;

			long columnBitmask = entityWorkflowModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					entityWorkflowModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						entityWorkflowModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					entityWorkflowModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EntityWorkflowModelImpl entityWorkflowModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						entityWorkflowModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = entityWorkflowModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}