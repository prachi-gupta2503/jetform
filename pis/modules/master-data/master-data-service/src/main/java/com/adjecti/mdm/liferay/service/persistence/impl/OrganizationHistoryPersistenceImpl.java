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

package com.adjecti.mdm.liferay.service.persistence.impl;

import com.adjecti.mdm.liferay.exception.NoSuchOrganizationHistoryException;
import com.adjecti.mdm.liferay.model.OrganizationHistory;
import com.adjecti.mdm.liferay.model.impl.OrganizationHistoryImpl;
import com.adjecti.mdm.liferay.model.impl.OrganizationHistoryModelImpl;
import com.adjecti.mdm.liferay.service.persistence.OrganizationHistoryPersistence;
import com.adjecti.mdm.liferay.service.persistence.impl.constants.mdmPersistenceConstants;

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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the organization history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OrganizationHistoryPersistence.class)
public class OrganizationHistoryPersistenceImpl
	extends BasePersistenceImpl<OrganizationHistory>
	implements OrganizationHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OrganizationHistoryUtil</code> to access the organization history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OrganizationHistoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the organization histories where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization histories
	 */
	@Override
	public List<OrganizationHistory> findByOrganizationId(long organizationId) {
		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization histories where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @return the range of matching organization histories
	 */
	@Override
	public List<OrganizationHistory> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization histories where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization histories
	 */
	@Override
	public List<OrganizationHistory> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization histories where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization histories
	 */
	@Override
	public List<OrganizationHistory> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrganizationId;
				finderArgs = new Object[] {organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrganizationId;
			finderArgs = new Object[] {
				organizationId, start, end, orderByComparator
			};
		}

		List<OrganizationHistory> list = null;

		if (useFinderCache) {
			list = (List<OrganizationHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationHistory organizationHistory : list) {
					if (organizationId !=
							organizationHistory.getOrganizationId()) {

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
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ORGANIZATIONHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<OrganizationHistory>)QueryUtil.list(
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
	 * Returns the first organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	@Override
	public OrganizationHistory findByOrganizationId_First(
			long organizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException {

		OrganizationHistory organizationHistory = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (organizationHistory != null) {
			return organizationHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchOrganizationHistoryException(sb.toString());
	}

	/**
	 * Returns the first organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	@Override
	public OrganizationHistory fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		List<OrganizationHistory> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	@Override
	public OrganizationHistory findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException {

		OrganizationHistory organizationHistory = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (organizationHistory != null) {
			return organizationHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchOrganizationHistoryException(sb.toString());
	}

	/**
	 * Returns the last organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	@Override
	public OrganizationHistory fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<OrganizationHistory> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization histories before and after the current organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationHistoryId the primary key of the current organization history
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization history
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	@Override
	public OrganizationHistory[] findByOrganizationId_PrevAndNext(
			long organizationHistoryId, long organizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException {

		OrganizationHistory organizationHistory = findByPrimaryKey(
			organizationHistoryId);

		Session session = null;

		try {
			session = openSession();

			OrganizationHistory[] array = new OrganizationHistoryImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, organizationHistory, organizationId, orderByComparator,
				true);

			array[1] = organizationHistory;

			array[2] = getByOrganizationId_PrevAndNext(
				session, organizationHistory, organizationId, orderByComparator,
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

	protected OrganizationHistory getByOrganizationId_PrevAndNext(
		Session session, OrganizationHistory organizationHistory,
		long organizationId,
		OrderByComparator<OrganizationHistory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ORGANIZATIONHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

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
			sb.append(OrganizationHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization histories where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (OrganizationHistory organizationHistory :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(organizationHistory);
		}
	}

	/**
	 * Returns the number of organization histories where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organization histories
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 =
		"organizationHistory.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByPreviousOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByPreviousOrganizationId;
	private FinderPath _finderPathCountByPreviousOrganizationId;

	/**
	 * Returns all the organization histories where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @return the matching organization histories
	 */
	@Override
	public List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId) {

		return findByPreviousOrganizationId(
			previousOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization histories where previousOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @return the range of matching organization histories
	 */
	@Override
	public List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId, int start, int end) {

		return findByPreviousOrganizationId(
			previousOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization histories where previousOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization histories
	 */
	@Override
	public List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId, int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return findByPreviousOrganizationId(
			previousOrganizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization histories where previousOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization histories
	 */
	@Override
	public List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId, int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByPreviousOrganizationId;
				finderArgs = new Object[] {previousOrganizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPreviousOrganizationId;
			finderArgs = new Object[] {
				previousOrganizationId, start, end, orderByComparator
			};
		}

		List<OrganizationHistory> list = null;

		if (useFinderCache) {
			list = (List<OrganizationHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationHistory organizationHistory : list) {
					if (previousOrganizationId !=
							organizationHistory.getPreviousOrganizationId()) {

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
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ORGANIZATIONHISTORY_WHERE);

			sb.append(
				_FINDER_COLUMN_PREVIOUSORGANIZATIONID_PREVIOUSORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(previousOrganizationId);

				list = (List<OrganizationHistory>)QueryUtil.list(
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
	 * Returns the first organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	@Override
	public OrganizationHistory findByPreviousOrganizationId_First(
			long previousOrganizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException {

		OrganizationHistory organizationHistory =
			fetchByPreviousOrganizationId_First(
				previousOrganizationId, orderByComparator);

		if (organizationHistory != null) {
			return organizationHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("previousOrganizationId=");
		sb.append(previousOrganizationId);

		sb.append("}");

		throw new NoSuchOrganizationHistoryException(sb.toString());
	}

	/**
	 * Returns the first organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	@Override
	public OrganizationHistory fetchByPreviousOrganizationId_First(
		long previousOrganizationId,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		List<OrganizationHistory> list = findByPreviousOrganizationId(
			previousOrganizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	@Override
	public OrganizationHistory findByPreviousOrganizationId_Last(
			long previousOrganizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException {

		OrganizationHistory organizationHistory =
			fetchByPreviousOrganizationId_Last(
				previousOrganizationId, orderByComparator);

		if (organizationHistory != null) {
			return organizationHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("previousOrganizationId=");
		sb.append(previousOrganizationId);

		sb.append("}");

		throw new NoSuchOrganizationHistoryException(sb.toString());
	}

	/**
	 * Returns the last organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	@Override
	public OrganizationHistory fetchByPreviousOrganizationId_Last(
		long previousOrganizationId,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		int count = countByPreviousOrganizationId(previousOrganizationId);

		if (count == 0) {
			return null;
		}

		List<OrganizationHistory> list = findByPreviousOrganizationId(
			previousOrganizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization histories before and after the current organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param organizationHistoryId the primary key of the current organization history
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization history
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	@Override
	public OrganizationHistory[] findByPreviousOrganizationId_PrevAndNext(
			long organizationHistoryId, long previousOrganizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException {

		OrganizationHistory organizationHistory = findByPrimaryKey(
			organizationHistoryId);

		Session session = null;

		try {
			session = openSession();

			OrganizationHistory[] array = new OrganizationHistoryImpl[3];

			array[0] = getByPreviousOrganizationId_PrevAndNext(
				session, organizationHistory, previousOrganizationId,
				orderByComparator, true);

			array[1] = organizationHistory;

			array[2] = getByPreviousOrganizationId_PrevAndNext(
				session, organizationHistory, previousOrganizationId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrganizationHistory getByPreviousOrganizationId_PrevAndNext(
		Session session, OrganizationHistory organizationHistory,
		long previousOrganizationId,
		OrderByComparator<OrganizationHistory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ORGANIZATIONHISTORY_WHERE);

		sb.append(
			_FINDER_COLUMN_PREVIOUSORGANIZATIONID_PREVIOUSORGANIZATIONID_2);

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
			sb.append(OrganizationHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(previousOrganizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization histories where previousOrganizationId = &#63; from the database.
	 *
	 * @param previousOrganizationId the previous organization ID
	 */
	@Override
	public void removeByPreviousOrganizationId(long previousOrganizationId) {
		for (OrganizationHistory organizationHistory :
				findByPreviousOrganizationId(
					previousOrganizationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(organizationHistory);
		}
	}

	/**
	 * Returns the number of organization histories where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @return the number of matching organization histories
	 */
	@Override
	public int countByPreviousOrganizationId(long previousOrganizationId) {
		FinderPath finderPath = _finderPathCountByPreviousOrganizationId;

		Object[] finderArgs = new Object[] {previousOrganizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONHISTORY_WHERE);

			sb.append(
				_FINDER_COLUMN_PREVIOUSORGANIZATIONID_PREVIOUSORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(previousOrganizationId);

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

	private static final String
		_FINDER_COLUMN_PREVIOUSORGANIZATIONID_PREVIOUSORGANIZATIONID_2 =
			"organizationHistory.previousOrganizationId = ?";

	public OrganizationHistoryPersistenceImpl() {
		setModelClass(OrganizationHistory.class);

		setModelImplClass(OrganizationHistoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the organization history in the entity cache if it is enabled.
	 *
	 * @param organizationHistory the organization history
	 */
	@Override
	public void cacheResult(OrganizationHistory organizationHistory) {
		entityCache.putResult(
			OrganizationHistoryImpl.class, organizationHistory.getPrimaryKey(),
			organizationHistory);
	}

	/**
	 * Caches the organization histories in the entity cache if it is enabled.
	 *
	 * @param organizationHistories the organization histories
	 */
	@Override
	public void cacheResult(List<OrganizationHistory> organizationHistories) {
		for (OrganizationHistory organizationHistory : organizationHistories) {
			if (entityCache.getResult(
					OrganizationHistoryImpl.class,
					organizationHistory.getPrimaryKey()) == null) {

				cacheResult(organizationHistory);
			}
		}
	}

	/**
	 * Clears the cache for all organization histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OrganizationHistoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganizationHistory organizationHistory) {
		entityCache.removeResult(
			OrganizationHistoryImpl.class, organizationHistory);
	}

	@Override
	public void clearCache(List<OrganizationHistory> organizationHistories) {
		for (OrganizationHistory organizationHistory : organizationHistories) {
			entityCache.removeResult(
				OrganizationHistoryImpl.class, organizationHistory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OrganizationHistoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new organization history with the primary key. Does not add the organization history to the database.
	 *
	 * @param organizationHistoryId the primary key for the new organization history
	 * @return the new organization history
	 */
	@Override
	public OrganizationHistory create(long organizationHistoryId) {
		OrganizationHistory organizationHistory = new OrganizationHistoryImpl();

		organizationHistory.setNew(true);
		organizationHistory.setPrimaryKey(organizationHistoryId);

		organizationHistory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return organizationHistory;
	}

	/**
	 * Removes the organization history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history that was removed
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	@Override
	public OrganizationHistory remove(long organizationHistoryId)
		throws NoSuchOrganizationHistoryException {

		return remove((Serializable)organizationHistoryId);
	}

	/**
	 * Removes the organization history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization history
	 * @return the organization history that was removed
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	@Override
	public OrganizationHistory remove(Serializable primaryKey)
		throws NoSuchOrganizationHistoryException {

		Session session = null;

		try {
			session = openSession();

			OrganizationHistory organizationHistory =
				(OrganizationHistory)session.get(
					OrganizationHistoryImpl.class, primaryKey);

			if (organizationHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(organizationHistory);
		}
		catch (NoSuchOrganizationHistoryException noSuchEntityException) {
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
	protected OrganizationHistory removeImpl(
		OrganizationHistory organizationHistory) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organizationHistory)) {
				organizationHistory = (OrganizationHistory)session.get(
					OrganizationHistoryImpl.class,
					organizationHistory.getPrimaryKeyObj());
			}

			if (organizationHistory != null) {
				session.delete(organizationHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (organizationHistory != null) {
			clearCache(organizationHistory);
		}

		return organizationHistory;
	}

	@Override
	public OrganizationHistory updateImpl(
		OrganizationHistory organizationHistory) {

		boolean isNew = organizationHistory.isNew();

		if (!(organizationHistory instanceof OrganizationHistoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(organizationHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					organizationHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in organizationHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OrganizationHistory implementation " +
					organizationHistory.getClass());
		}

		OrganizationHistoryModelImpl organizationHistoryModelImpl =
			(OrganizationHistoryModelImpl)organizationHistory;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (organizationHistory.getCreateDate() == null)) {
			if (serviceContext == null) {
				organizationHistory.setCreateDate(now);
			}
			else {
				organizationHistory.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!organizationHistoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				organizationHistory.setModifiedDate(now);
			}
			else {
				organizationHistory.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(organizationHistory);
			}
			else {
				organizationHistory = (OrganizationHistory)session.merge(
					organizationHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OrganizationHistoryImpl.class, organizationHistoryModelImpl, false,
			true);

		if (isNew) {
			organizationHistory.setNew(false);
		}

		organizationHistory.resetOriginalValues();

		return organizationHistory;
	}

	/**
	 * Returns the organization history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization history
	 * @return the organization history
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	@Override
	public OrganizationHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationHistoryException {

		OrganizationHistory organizationHistory = fetchByPrimaryKey(primaryKey);

		if (organizationHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return organizationHistory;
	}

	/**
	 * Returns the organization history with the primary key or throws a <code>NoSuchOrganizationHistoryException</code> if it could not be found.
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	@Override
	public OrganizationHistory findByPrimaryKey(long organizationHistoryId)
		throws NoSuchOrganizationHistoryException {

		return findByPrimaryKey((Serializable)organizationHistoryId);
	}

	/**
	 * Returns the organization history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history, or <code>null</code> if a organization history with the primary key could not be found
	 */
	@Override
	public OrganizationHistory fetchByPrimaryKey(long organizationHistoryId) {
		return fetchByPrimaryKey((Serializable)organizationHistoryId);
	}

	/**
	 * Returns all the organization histories.
	 *
	 * @return the organization histories
	 */
	@Override
	public List<OrganizationHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @return the range of organization histories
	 */
	@Override
	public List<OrganizationHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization histories
	 */
	@Override
	public List<OrganizationHistory> findAll(
		int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization histories
	 */
	@Override
	public List<OrganizationHistory> findAll(
		int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator,
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

		List<OrganizationHistory> list = null;

		if (useFinderCache) {
			list = (List<OrganizationHistory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ORGANIZATIONHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONHISTORY;

				sql = sql.concat(OrganizationHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OrganizationHistory>)QueryUtil.list(
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
	 * Removes all the organization histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OrganizationHistory organizationHistory : findAll()) {
			remove(organizationHistory);
		}
	}

	/**
	 * Returns the number of organization histories.
	 *
	 * @return the number of organization histories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_ORGANIZATIONHISTORY);

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
		return "organizationHistoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ORGANIZATIONHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OrganizationHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the organization history persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new OrganizationHistoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", OrganizationHistory.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"organizationId"}, true);

		_finderPathWithoutPaginationFindByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"organizationId"}, true);

		_finderPathCountByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"organizationId"}, false);

		_finderPathWithPaginationFindByPreviousOrganizationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByPreviousOrganizationId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"previousOrganizationId"}, true);

		_finderPathWithoutPaginationFindByPreviousOrganizationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByPreviousOrganizationId",
				new String[] {Long.class.getName()},
				new String[] {"previousOrganizationId"}, true);

		_finderPathCountByPreviousOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPreviousOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"previousOrganizationId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(OrganizationHistoryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = mdmPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = mdmPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = mdmPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_ORGANIZATIONHISTORY =
		"SELECT organizationHistory FROM OrganizationHistory organizationHistory";

	private static final String _SQL_SELECT_ORGANIZATIONHISTORY_WHERE =
		"SELECT organizationHistory FROM OrganizationHistory organizationHistory WHERE ";

	private static final String _SQL_COUNT_ORGANIZATIONHISTORY =
		"SELECT COUNT(organizationHistory) FROM OrganizationHistory organizationHistory";

	private static final String _SQL_COUNT_ORGANIZATIONHISTORY_WHERE =
		"SELECT COUNT(organizationHistory) FROM OrganizationHistory organizationHistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "organizationHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OrganizationHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OrganizationHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OrganizationHistoryPersistenceImpl.class);

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

	private static class OrganizationHistoryModelArgumentsResolver
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

			OrganizationHistoryModelImpl organizationHistoryModelImpl =
				(OrganizationHistoryModelImpl)baseModel;

			long columnBitmask =
				organizationHistoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					organizationHistoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						organizationHistoryModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					organizationHistoryModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			OrganizationHistoryModelImpl organizationHistoryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						organizationHistoryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = organizationHistoryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}