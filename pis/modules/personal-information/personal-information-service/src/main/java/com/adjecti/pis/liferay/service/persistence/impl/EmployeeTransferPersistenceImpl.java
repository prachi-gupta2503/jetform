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

package com.adjecti.pis.liferay.service.persistence.impl;

import com.adjecti.pis.liferay.exception.NoSuchEmployeeTransferException;
import com.adjecti.pis.liferay.model.EmployeeTransfer;
import com.adjecti.pis.liferay.model.impl.EmployeeTransferImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeTransferModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeTransferPersistence;
import com.adjecti.pis.liferay.service.persistence.impl.constants.pisPersistenceConstants;

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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the employee transfer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeTransferPersistence.class)
public class EmployeeTransferPersistenceImpl
	extends BasePersistenceImpl<EmployeeTransfer>
	implements EmployeeTransferPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeTransferUtil</code> to access the employee transfer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeTransferImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGradeModeId;
	private FinderPath _finderPathWithoutPaginationFindByGradeModeId;
	private FinderPath _finderPathCountByGradeModeId;

	/**
	 * Returns all the employee transfers where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByGradeModeId(long gradeModeId) {
		return findByGradeModeId(
			gradeModeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee transfers where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return findByGradeModeId(gradeModeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee transfers where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return findByGradeModeId(
			gradeModeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee transfers where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGradeModeId;
				finderArgs = new Object[] {gradeModeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGradeModeId;
			finderArgs = new Object[] {
				gradeModeId, start, end, orderByComparator
			};
		}

		List<EmployeeTransfer> list = null;

		if (useFinderCache) {
			list = (List<EmployeeTransfer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeTransfer employeeTransfer : list) {
					if (gradeModeId != employeeTransfer.getGradeModeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEETRANSFER_WHERE);

			sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeTransferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(gradeModeId);

				list = (List<EmployeeTransfer>)QueryUtil.list(
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
	 * Returns the first employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer findByGradeModeId_First(
			long gradeModeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = fetchByGradeModeId_First(
			gradeModeId, orderByComparator);

		if (employeeTransfer != null) {
			return employeeTransfer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeModeId=");
		sb.append(gradeModeId);

		sb.append("}");

		throw new NoSuchEmployeeTransferException(sb.toString());
	}

	/**
	 * Returns the first employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer fetchByGradeModeId_First(
		long gradeModeId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		List<EmployeeTransfer> list = findByGradeModeId(
			gradeModeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer findByGradeModeId_Last(
			long gradeModeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);

		if (employeeTransfer != null) {
			return employeeTransfer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeModeId=");
		sb.append(gradeModeId);

		sb.append("}");

		throw new NoSuchEmployeeTransferException(sb.toString());
	}

	/**
	 * Returns the last employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer fetchByGradeModeId_Last(
		long gradeModeId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		int count = countByGradeModeId(gradeModeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeTransfer> list = findByGradeModeId(
			gradeModeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	@Override
	public EmployeeTransfer[] findByGradeModeId_PrevAndNext(
			long employeeTransferId, long gradeModeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = findByPrimaryKey(
			employeeTransferId);

		Session session = null;

		try {
			session = openSession();

			EmployeeTransfer[] array = new EmployeeTransferImpl[3];

			array[0] = getByGradeModeId_PrevAndNext(
				session, employeeTransfer, gradeModeId, orderByComparator,
				true);

			array[1] = employeeTransfer;

			array[2] = getByGradeModeId_PrevAndNext(
				session, employeeTransfer, gradeModeId, orderByComparator,
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

	protected EmployeeTransfer getByGradeModeId_PrevAndNext(
		Session session, EmployeeTransfer employeeTransfer, long gradeModeId,
		OrderByComparator<EmployeeTransfer> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEETRANSFER_WHERE);

		sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

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
			sb.append(EmployeeTransferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(gradeModeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeTransfer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeTransfer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee transfers where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	@Override
	public void removeByGradeModeId(long gradeModeId) {
		for (EmployeeTransfer employeeTransfer :
				findByGradeModeId(
					gradeModeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeTransfer);
		}
	}

	/**
	 * Returns the number of employee transfers where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee transfers
	 */
	@Override
	public int countByGradeModeId(long gradeModeId) {
		FinderPath finderPath = _finderPathCountByGradeModeId;

		Object[] finderArgs = new Object[] {gradeModeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEETRANSFER_WHERE);

			sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(gradeModeId);

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

	private static final String _FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2 =
		"employeeTransfer.gradeModeId = ?";

	private FinderPath _finderPathWithPaginationFindByFromOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByFromOrganizationId;
	private FinderPath _finderPathCountByFromOrganizationId;

	/**
	 * Returns all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @return the matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId) {

		return findByFromOrganizationId(
			fromOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId, int start, int end) {

		return findByFromOrganizationId(fromOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return findByFromOrganizationId(
			fromOrganizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFromOrganizationId;
				finderArgs = new Object[] {fromOrganizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFromOrganizationId;
			finderArgs = new Object[] {
				fromOrganizationId, start, end, orderByComparator
			};
		}

		List<EmployeeTransfer> list = null;

		if (useFinderCache) {
			list = (List<EmployeeTransfer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeTransfer employeeTransfer : list) {
					if (fromOrganizationId !=
							employeeTransfer.getFromOrganizationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEETRANSFER_WHERE);

			sb.append(_FINDER_COLUMN_FROMORGANIZATIONID_FROMORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeTransferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fromOrganizationId);

				list = (List<EmployeeTransfer>)QueryUtil.list(
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
	 * Returns the first employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer findByFromOrganizationId_First(
			long fromOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = fetchByFromOrganizationId_First(
			fromOrganizationId, orderByComparator);

		if (employeeTransfer != null) {
			return employeeTransfer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fromOrganizationId=");
		sb.append(fromOrganizationId);

		sb.append("}");

		throw new NoSuchEmployeeTransferException(sb.toString());
	}

	/**
	 * Returns the first employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer fetchByFromOrganizationId_First(
		long fromOrganizationId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		List<EmployeeTransfer> list = findByFromOrganizationId(
			fromOrganizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer findByFromOrganizationId_Last(
			long fromOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = fetchByFromOrganizationId_Last(
			fromOrganizationId, orderByComparator);

		if (employeeTransfer != null) {
			return employeeTransfer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fromOrganizationId=");
		sb.append(fromOrganizationId);

		sb.append("}");

		throw new NoSuchEmployeeTransferException(sb.toString());
	}

	/**
	 * Returns the last employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer fetchByFromOrganizationId_Last(
		long fromOrganizationId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		int count = countByFromOrganizationId(fromOrganizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeTransfer> list = findByFromOrganizationId(
			fromOrganizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	@Override
	public EmployeeTransfer[] findByFromOrganizationId_PrevAndNext(
			long employeeTransferId, long fromOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = findByPrimaryKey(
			employeeTransferId);

		Session session = null;

		try {
			session = openSession();

			EmployeeTransfer[] array = new EmployeeTransferImpl[3];

			array[0] = getByFromOrganizationId_PrevAndNext(
				session, employeeTransfer, fromOrganizationId,
				orderByComparator, true);

			array[1] = employeeTransfer;

			array[2] = getByFromOrganizationId_PrevAndNext(
				session, employeeTransfer, fromOrganizationId,
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

	protected EmployeeTransfer getByFromOrganizationId_PrevAndNext(
		Session session, EmployeeTransfer employeeTransfer,
		long fromOrganizationId,
		OrderByComparator<EmployeeTransfer> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEETRANSFER_WHERE);

		sb.append(_FINDER_COLUMN_FROMORGANIZATIONID_FROMORGANIZATIONID_2);

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
			sb.append(EmployeeTransferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fromOrganizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeTransfer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeTransfer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee transfers where fromOrganizationId = &#63; from the database.
	 *
	 * @param fromOrganizationId the from organization ID
	 */
	@Override
	public void removeByFromOrganizationId(long fromOrganizationId) {
		for (EmployeeTransfer employeeTransfer :
				findByFromOrganizationId(
					fromOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeTransfer);
		}
	}

	/**
	 * Returns the number of employee transfers where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @return the number of matching employee transfers
	 */
	@Override
	public int countByFromOrganizationId(long fromOrganizationId) {
		FinderPath finderPath = _finderPathCountByFromOrganizationId;

		Object[] finderArgs = new Object[] {fromOrganizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEETRANSFER_WHERE);

			sb.append(_FINDER_COLUMN_FROMORGANIZATIONID_FROMORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fromOrganizationId);

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
		_FINDER_COLUMN_FROMORGANIZATIONID_FROMORGANIZATIONID_2 =
			"employeeTransfer.fromOrganizationId = ?";

	private FinderPath _finderPathWithPaginationFindByToOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByToOrganizationId;
	private FinderPath _finderPathCountByToOrganizationId;

	/**
	 * Returns all the employee transfers where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @return the matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId) {

		return findByToOrganizationId(
			toOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee transfers where toOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param toOrganizationId the to organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId, int start, int end) {

		return findByToOrganizationId(toOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee transfers where toOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param toOrganizationId the to organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return findByToOrganizationId(
			toOrganizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee transfers where toOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param toOrganizationId the to organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByToOrganizationId;
				finderArgs = new Object[] {toOrganizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByToOrganizationId;
			finderArgs = new Object[] {
				toOrganizationId, start, end, orderByComparator
			};
		}

		List<EmployeeTransfer> list = null;

		if (useFinderCache) {
			list = (List<EmployeeTransfer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeTransfer employeeTransfer : list) {
					if (toOrganizationId !=
							employeeTransfer.getToOrganizationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEETRANSFER_WHERE);

			sb.append(_FINDER_COLUMN_TOORGANIZATIONID_TOORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeTransferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(toOrganizationId);

				list = (List<EmployeeTransfer>)QueryUtil.list(
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
	 * Returns the first employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer findByToOrganizationId_First(
			long toOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = fetchByToOrganizationId_First(
			toOrganizationId, orderByComparator);

		if (employeeTransfer != null) {
			return employeeTransfer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toOrganizationId=");
		sb.append(toOrganizationId);

		sb.append("}");

		throw new NoSuchEmployeeTransferException(sb.toString());
	}

	/**
	 * Returns the first employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer fetchByToOrganizationId_First(
		long toOrganizationId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		List<EmployeeTransfer> list = findByToOrganizationId(
			toOrganizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer findByToOrganizationId_Last(
			long toOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = fetchByToOrganizationId_Last(
			toOrganizationId, orderByComparator);

		if (employeeTransfer != null) {
			return employeeTransfer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toOrganizationId=");
		sb.append(toOrganizationId);

		sb.append("}");

		throw new NoSuchEmployeeTransferException(sb.toString());
	}

	/**
	 * Returns the last employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer fetchByToOrganizationId_Last(
		long toOrganizationId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		int count = countByToOrganizationId(toOrganizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeTransfer> list = findByToOrganizationId(
			toOrganizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	@Override
	public EmployeeTransfer[] findByToOrganizationId_PrevAndNext(
			long employeeTransferId, long toOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = findByPrimaryKey(
			employeeTransferId);

		Session session = null;

		try {
			session = openSession();

			EmployeeTransfer[] array = new EmployeeTransferImpl[3];

			array[0] = getByToOrganizationId_PrevAndNext(
				session, employeeTransfer, toOrganizationId, orderByComparator,
				true);

			array[1] = employeeTransfer;

			array[2] = getByToOrganizationId_PrevAndNext(
				session, employeeTransfer, toOrganizationId, orderByComparator,
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

	protected EmployeeTransfer getByToOrganizationId_PrevAndNext(
		Session session, EmployeeTransfer employeeTransfer,
		long toOrganizationId,
		OrderByComparator<EmployeeTransfer> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEETRANSFER_WHERE);

		sb.append(_FINDER_COLUMN_TOORGANIZATIONID_TOORGANIZATIONID_2);

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
			sb.append(EmployeeTransferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(toOrganizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeTransfer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeTransfer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee transfers where toOrganizationId = &#63; from the database.
	 *
	 * @param toOrganizationId the to organization ID
	 */
	@Override
	public void removeByToOrganizationId(long toOrganizationId) {
		for (EmployeeTransfer employeeTransfer :
				findByToOrganizationId(
					toOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeTransfer);
		}
	}

	/**
	 * Returns the number of employee transfers where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @return the number of matching employee transfers
	 */
	@Override
	public int countByToOrganizationId(long toOrganizationId) {
		FinderPath finderPath = _finderPathCountByToOrganizationId;

		Object[] finderArgs = new Object[] {toOrganizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEETRANSFER_WHERE);

			sb.append(_FINDER_COLUMN_TOORGANIZATIONID_TOORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(toOrganizationId);

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
		_FINDER_COLUMN_TOORGANIZATIONID_TOORGANIZATIONID_2 =
			"employeeTransfer.toOrganizationId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the employee transfers where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee transfers where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee transfers where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee transfers where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmployeeId;
				finderArgs = new Object[] {employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeId;
			finderArgs = new Object[] {
				employeeId, start, end, orderByComparator
			};
		}

		List<EmployeeTransfer> list = null;

		if (useFinderCache) {
			list = (List<EmployeeTransfer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeTransfer employeeTransfer : list) {
					if (employeeId != employeeTransfer.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEETRANSFER_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeTransferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeTransfer>)QueryUtil.list(
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
	 * Returns the first employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeTransfer != null) {
			return employeeTransfer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeTransferException(sb.toString());
	}

	/**
	 * Returns the first employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		List<EmployeeTransfer> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeTransfer != null) {
			return employeeTransfer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeTransferException(sb.toString());
	}

	/**
	 * Returns the last employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	@Override
	public EmployeeTransfer fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeTransfer> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	@Override
	public EmployeeTransfer[] findByEmployeeId_PrevAndNext(
			long employeeTransferId, long employeeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = findByPrimaryKey(
			employeeTransferId);

		Session session = null;

		try {
			session = openSession();

			EmployeeTransfer[] array = new EmployeeTransferImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeTransfer, employeeId, orderByComparator, true);

			array[1] = employeeTransfer;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeTransfer, employeeId, orderByComparator,
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

	protected EmployeeTransfer getByEmployeeId_PrevAndNext(
		Session session, EmployeeTransfer employeeTransfer, long employeeId,
		OrderByComparator<EmployeeTransfer> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEETRANSFER_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			sb.append(EmployeeTransferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeTransfer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeTransfer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee transfers where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeTransfer employeeTransfer :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeTransfer);
		}
	}

	/**
	 * Returns the number of employee transfers where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee transfers
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEETRANSFER_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 =
		"employeeTransfer.employeeId = ?";

	public EmployeeTransferPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeTransfer.class);

		setModelImplClass(EmployeeTransferImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee transfer in the entity cache if it is enabled.
	 *
	 * @param employeeTransfer the employee transfer
	 */
	@Override
	public void cacheResult(EmployeeTransfer employeeTransfer) {
		entityCache.putResult(
			EmployeeTransferImpl.class, employeeTransfer.getPrimaryKey(),
			employeeTransfer);
	}

	/**
	 * Caches the employee transfers in the entity cache if it is enabled.
	 *
	 * @param employeeTransfers the employee transfers
	 */
	@Override
	public void cacheResult(List<EmployeeTransfer> employeeTransfers) {
		for (EmployeeTransfer employeeTransfer : employeeTransfers) {
			if (entityCache.getResult(
					EmployeeTransferImpl.class,
					employeeTransfer.getPrimaryKey()) == null) {

				cacheResult(employeeTransfer);
			}
		}
	}

	/**
	 * Clears the cache for all employee transfers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeTransferImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee transfer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeTransfer employeeTransfer) {
		entityCache.removeResult(EmployeeTransferImpl.class, employeeTransfer);
	}

	@Override
	public void clearCache(List<EmployeeTransfer> employeeTransfers) {
		for (EmployeeTransfer employeeTransfer : employeeTransfers) {
			entityCache.removeResult(
				EmployeeTransferImpl.class, employeeTransfer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeTransferImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee transfer with the primary key. Does not add the employee transfer to the database.
	 *
	 * @param employeeTransferId the primary key for the new employee transfer
	 * @return the new employee transfer
	 */
	@Override
	public EmployeeTransfer create(long employeeTransferId) {
		EmployeeTransfer employeeTransfer = new EmployeeTransferImpl();

		employeeTransfer.setNew(true);
		employeeTransfer.setPrimaryKey(employeeTransferId);

		employeeTransfer.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeTransfer;
	}

	/**
	 * Removes the employee transfer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer that was removed
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	@Override
	public EmployeeTransfer remove(long employeeTransferId)
		throws NoSuchEmployeeTransferException {

		return remove((Serializable)employeeTransferId);
	}

	/**
	 * Removes the employee transfer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee transfer
	 * @return the employee transfer that was removed
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	@Override
	public EmployeeTransfer remove(Serializable primaryKey)
		throws NoSuchEmployeeTransferException {

		Session session = null;

		try {
			session = openSession();

			EmployeeTransfer employeeTransfer = (EmployeeTransfer)session.get(
				EmployeeTransferImpl.class, primaryKey);

			if (employeeTransfer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeTransferException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeTransfer);
		}
		catch (NoSuchEmployeeTransferException noSuchEntityException) {
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
	protected EmployeeTransfer removeImpl(EmployeeTransfer employeeTransfer) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeTransfer)) {
				employeeTransfer = (EmployeeTransfer)session.get(
					EmployeeTransferImpl.class,
					employeeTransfer.getPrimaryKeyObj());
			}

			if (employeeTransfer != null) {
				session.delete(employeeTransfer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeTransfer != null) {
			clearCache(employeeTransfer);
		}

		return employeeTransfer;
	}

	@Override
	public EmployeeTransfer updateImpl(EmployeeTransfer employeeTransfer) {
		boolean isNew = employeeTransfer.isNew();

		if (!(employeeTransfer instanceof EmployeeTransferModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeTransfer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeTransfer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeTransfer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeTransfer implementation " +
					employeeTransfer.getClass());
		}

		EmployeeTransferModelImpl employeeTransferModelImpl =
			(EmployeeTransferModelImpl)employeeTransfer;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeTransfer.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeTransfer.setCreateDate(now);
			}
			else {
				employeeTransfer.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeTransferModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeTransfer.setModifiedDate(now);
			}
			else {
				employeeTransfer.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeTransfer);
			}
			else {
				employeeTransfer = (EmployeeTransfer)session.merge(
					employeeTransfer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeTransferImpl.class, employeeTransferModelImpl, false, true);

		if (isNew) {
			employeeTransfer.setNew(false);
		}

		employeeTransfer.resetOriginalValues();

		return employeeTransfer;
	}

	/**
	 * Returns the employee transfer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee transfer
	 * @return the employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	@Override
	public EmployeeTransfer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeTransferException {

		EmployeeTransfer employeeTransfer = fetchByPrimaryKey(primaryKey);

		if (employeeTransfer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeTransferException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeTransfer;
	}

	/**
	 * Returns the employee transfer with the primary key or throws a <code>NoSuchEmployeeTransferException</code> if it could not be found.
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	@Override
	public EmployeeTransfer findByPrimaryKey(long employeeTransferId)
		throws NoSuchEmployeeTransferException {

		return findByPrimaryKey((Serializable)employeeTransferId);
	}

	/**
	 * Returns the employee transfer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer, or <code>null</code> if a employee transfer with the primary key could not be found
	 */
	@Override
	public EmployeeTransfer fetchByPrimaryKey(long employeeTransferId) {
		return fetchByPrimaryKey((Serializable)employeeTransferId);
	}

	/**
	 * Returns all the employee transfers.
	 *
	 * @return the employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee transfers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee transfers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findAll(
		int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee transfers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee transfers
	 */
	@Override
	public List<EmployeeTransfer> findAll(
		int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator,
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

		List<EmployeeTransfer> list = null;

		if (useFinderCache) {
			list = (List<EmployeeTransfer>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEETRANSFER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEETRANSFER;

				sql = sql.concat(EmployeeTransferModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeTransfer>)QueryUtil.list(
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
	 * Removes all the employee transfers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeTransfer employeeTransfer : findAll()) {
			remove(employeeTransfer);
		}
	}

	/**
	 * Returns the number of employee transfers.
	 *
	 * @return the number of employee transfers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEETRANSFER);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "employeeTransferId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEETRANSFER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeTransferModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee transfer persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeTransferModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeTransfer.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByGradeModeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGradeModeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"gradeModeId"}, true);

		_finderPathWithoutPaginationFindByGradeModeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGradeModeId",
			new String[] {Long.class.getName()}, new String[] {"gradeModeId"},
			true);

		_finderPathCountByGradeModeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGradeModeId",
			new String[] {Long.class.getName()}, new String[] {"gradeModeId"},
			false);

		_finderPathWithPaginationFindByFromOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFromOrganizationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fromOrganizationId"}, true);

		_finderPathWithoutPaginationFindByFromOrganizationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByFromOrganizationId", new String[] {Long.class.getName()},
				new String[] {"fromOrganizationId"}, true);

		_finderPathCountByFromOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFromOrganizationId", new String[] {Long.class.getName()},
			new String[] {"fromOrganizationId"}, false);

		_finderPathWithPaginationFindByToOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByToOrganizationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"toOrganizationId"}, true);

		_finderPathWithoutPaginationFindByToOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByToOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"toOrganizationId"}, true);

		_finderPathCountByToOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByToOrganizationId", new String[] {Long.class.getName()},
			new String[] {"toOrganizationId"}, false);

		_finderPathWithPaginationFindByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeeId"}, true);

		_finderPathWithoutPaginationFindByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeTransferImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = pisPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = pisPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = pisPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_EMPLOYEETRANSFER =
		"SELECT employeeTransfer FROM EmployeeTransfer employeeTransfer";

	private static final String _SQL_SELECT_EMPLOYEETRANSFER_WHERE =
		"SELECT employeeTransfer FROM EmployeeTransfer employeeTransfer WHERE ";

	private static final String _SQL_COUNT_EMPLOYEETRANSFER =
		"SELECT COUNT(employeeTransfer) FROM EmployeeTransfer employeeTransfer";

	private static final String _SQL_COUNT_EMPLOYEETRANSFER_WHERE =
		"SELECT COUNT(employeeTransfer) FROM EmployeeTransfer employeeTransfer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeTransfer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeTransfer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeTransfer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeTransferPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"active"});

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

	private static class EmployeeTransferModelArgumentsResolver
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

			EmployeeTransferModelImpl employeeTransferModelImpl =
				(EmployeeTransferModelImpl)baseModel;

			long columnBitmask = employeeTransferModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeTransferModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeTransferModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeTransferModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeTransferModelImpl employeeTransferModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeTransferModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeTransferModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}