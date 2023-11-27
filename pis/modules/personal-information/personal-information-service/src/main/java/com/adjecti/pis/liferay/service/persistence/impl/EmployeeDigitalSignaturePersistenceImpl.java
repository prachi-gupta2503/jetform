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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDigitalSignatureException;
import com.adjecti.pis.liferay.model.EmployeeDigitalSignature;
import com.adjecti.pis.liferay.model.impl.EmployeeDigitalSignatureImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeDigitalSignatureModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeDigitalSignaturePersistence;
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
 * The persistence implementation for the employee digital signature service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeDigitalSignaturePersistence.class)
public class EmployeeDigitalSignaturePersistenceImpl
	extends BasePersistenceImpl<EmployeeDigitalSignature>
	implements EmployeeDigitalSignaturePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeDigitalSignatureUtil</code> to access the employee digital signature persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeDigitalSignatureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the employee digital signatures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee digital signatures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of matching employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator,
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

		List<EmployeeDigitalSignature> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDigitalSignature>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDigitalSignature employeeDigitalSignature : list) {
					if (employeeId !=
							employeeDigitalSignature.getEmployeeId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEDIGITALSIGNATURE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDigitalSignatureModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeDigitalSignature>)QueryUtil.list(
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
	 * Returns the first employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	@Override
	public EmployeeDigitalSignature findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException {

		EmployeeDigitalSignature employeeDigitalSignature =
			fetchByEmployeeId_First(employeeId, orderByComparator);

		if (employeeDigitalSignature != null) {
			return employeeDigitalSignature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeDigitalSignatureException(sb.toString());
	}

	/**
	 * Returns the first employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	@Override
	public EmployeeDigitalSignature fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		List<EmployeeDigitalSignature> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	@Override
	public EmployeeDigitalSignature findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException {

		EmployeeDigitalSignature employeeDigitalSignature =
			fetchByEmployeeId_Last(employeeId, orderByComparator);

		if (employeeDigitalSignature != null) {
			return employeeDigitalSignature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeDigitalSignatureException(sb.toString());
	}

	/**
	 * Returns the last employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	@Override
	public EmployeeDigitalSignature fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDigitalSignature> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee digital signatures before and after the current employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDigitalSignatureId the primary key of the current employee digital signature
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	@Override
	public EmployeeDigitalSignature[] findByEmployeeId_PrevAndNext(
			long employeeDigitalSignatureId, long employeeId,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException {

		EmployeeDigitalSignature employeeDigitalSignature = findByPrimaryKey(
			employeeDigitalSignatureId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDigitalSignature[] array =
				new EmployeeDigitalSignatureImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeDigitalSignature, employeeId,
				orderByComparator, true);

			array[1] = employeeDigitalSignature;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeDigitalSignature, employeeId,
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

	protected EmployeeDigitalSignature getByEmployeeId_PrevAndNext(
		Session session, EmployeeDigitalSignature employeeDigitalSignature,
		long employeeId,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDIGITALSIGNATURE_WHERE);

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
			sb.append(EmployeeDigitalSignatureModelImpl.ORDER_BY_JPQL);
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
						employeeDigitalSignature)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDigitalSignature> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee digital signatures where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeDigitalSignature employeeDigitalSignature :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDigitalSignature);
		}
	}

	/**
	 * Returns the number of employee digital signatures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee digital signatures
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDIGITALSIGNATURE_WHERE);

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
		"employeeDigitalSignature.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByCid;
	private FinderPath _finderPathWithoutPaginationFindByCid;
	private FinderPath _finderPathCountByCid;

	/**
	 * Returns all the employee digital signatures where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the matching employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findByCid(String cid) {
		return findByCid(cid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee digital signatures where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of matching employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findByCid(
		String cid, int start, int end) {

		return findByCid(cid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findByCid(
		String cid, int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return findByCid(cid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findByCid(
		String cid, int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator,
		boolean useFinderCache) {

		cid = Objects.toString(cid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCid;
				finderArgs = new Object[] {cid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCid;
			finderArgs = new Object[] {cid, start, end, orderByComparator};
		}

		List<EmployeeDigitalSignature> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDigitalSignature>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDigitalSignature employeeDigitalSignature : list) {
					if (!cid.equals(employeeDigitalSignature.getCid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEEDIGITALSIGNATURE_WHERE);

			boolean bindCid = false;

			if (cid.isEmpty()) {
				sb.append(_FINDER_COLUMN_CID_CID_3);
			}
			else {
				bindCid = true;

				sb.append(_FINDER_COLUMN_CID_CID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDigitalSignatureModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCid) {
					queryPos.add(cid);
				}

				list = (List<EmployeeDigitalSignature>)QueryUtil.list(
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
	 * Returns the first employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	@Override
	public EmployeeDigitalSignature findByCid_First(
			String cid,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException {

		EmployeeDigitalSignature employeeDigitalSignature = fetchByCid_First(
			cid, orderByComparator);

		if (employeeDigitalSignature != null) {
			return employeeDigitalSignature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cid=");
		sb.append(cid);

		sb.append("}");

		throw new NoSuchEmployeeDigitalSignatureException(sb.toString());
	}

	/**
	 * Returns the first employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	@Override
	public EmployeeDigitalSignature fetchByCid_First(
		String cid,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		List<EmployeeDigitalSignature> list = findByCid(
			cid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	@Override
	public EmployeeDigitalSignature findByCid_Last(
			String cid,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException {

		EmployeeDigitalSignature employeeDigitalSignature = fetchByCid_Last(
			cid, orderByComparator);

		if (employeeDigitalSignature != null) {
			return employeeDigitalSignature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cid=");
		sb.append(cid);

		sb.append("}");

		throw new NoSuchEmployeeDigitalSignatureException(sb.toString());
	}

	/**
	 * Returns the last employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	@Override
	public EmployeeDigitalSignature fetchByCid_Last(
		String cid,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		int count = countByCid(cid);

		if (count == 0) {
			return null;
		}

		List<EmployeeDigitalSignature> list = findByCid(
			cid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee digital signatures before and after the current employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param employeeDigitalSignatureId the primary key of the current employee digital signature
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	@Override
	public EmployeeDigitalSignature[] findByCid_PrevAndNext(
			long employeeDigitalSignatureId, String cid,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException {

		cid = Objects.toString(cid, "");

		EmployeeDigitalSignature employeeDigitalSignature = findByPrimaryKey(
			employeeDigitalSignatureId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDigitalSignature[] array =
				new EmployeeDigitalSignatureImpl[3];

			array[0] = getByCid_PrevAndNext(
				session, employeeDigitalSignature, cid, orderByComparator,
				true);

			array[1] = employeeDigitalSignature;

			array[2] = getByCid_PrevAndNext(
				session, employeeDigitalSignature, cid, orderByComparator,
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

	protected EmployeeDigitalSignature getByCid_PrevAndNext(
		Session session, EmployeeDigitalSignature employeeDigitalSignature,
		String cid,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDIGITALSIGNATURE_WHERE);

		boolean bindCid = false;

		if (cid.isEmpty()) {
			sb.append(_FINDER_COLUMN_CID_CID_3);
		}
		else {
			bindCid = true;

			sb.append(_FINDER_COLUMN_CID_CID_2);
		}

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
			sb.append(EmployeeDigitalSignatureModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCid) {
			queryPos.add(cid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeDigitalSignature)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDigitalSignature> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee digital signatures where cid = &#63; from the database.
	 *
	 * @param cid the cid
	 */
	@Override
	public void removeByCid(String cid) {
		for (EmployeeDigitalSignature employeeDigitalSignature :
				findByCid(cid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDigitalSignature);
		}
	}

	/**
	 * Returns the number of employee digital signatures where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the number of matching employee digital signatures
	 */
	@Override
	public int countByCid(String cid) {
		cid = Objects.toString(cid, "");

		FinderPath finderPath = _finderPathCountByCid;

		Object[] finderArgs = new Object[] {cid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDIGITALSIGNATURE_WHERE);

			boolean bindCid = false;

			if (cid.isEmpty()) {
				sb.append(_FINDER_COLUMN_CID_CID_3);
			}
			else {
				bindCid = true;

				sb.append(_FINDER_COLUMN_CID_CID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCid) {
					queryPos.add(cid);
				}

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

	private static final String _FINDER_COLUMN_CID_CID_2 =
		"employeeDigitalSignature.cid = ?";

	private static final String _FINDER_COLUMN_CID_CID_3 =
		"(employeeDigitalSignature.cid IS NULL OR employeeDigitalSignature.cid = '')";

	public EmployeeDigitalSignaturePersistenceImpl() {
		setModelClass(EmployeeDigitalSignature.class);

		setModelImplClass(EmployeeDigitalSignatureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee digital signature in the entity cache if it is enabled.
	 *
	 * @param employeeDigitalSignature the employee digital signature
	 */
	@Override
	public void cacheResult(EmployeeDigitalSignature employeeDigitalSignature) {
		entityCache.putResult(
			EmployeeDigitalSignatureImpl.class,
			employeeDigitalSignature.getPrimaryKey(), employeeDigitalSignature);
	}

	/**
	 * Caches the employee digital signatures in the entity cache if it is enabled.
	 *
	 * @param employeeDigitalSignatures the employee digital signatures
	 */
	@Override
	public void cacheResult(
		List<EmployeeDigitalSignature> employeeDigitalSignatures) {

		for (EmployeeDigitalSignature employeeDigitalSignature :
				employeeDigitalSignatures) {

			if (entityCache.getResult(
					EmployeeDigitalSignatureImpl.class,
					employeeDigitalSignature.getPrimaryKey()) == null) {

				cacheResult(employeeDigitalSignature);
			}
		}
	}

	/**
	 * Clears the cache for all employee digital signatures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDigitalSignatureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee digital signature.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDigitalSignature employeeDigitalSignature) {
		entityCache.removeResult(
			EmployeeDigitalSignatureImpl.class, employeeDigitalSignature);
	}

	@Override
	public void clearCache(
		List<EmployeeDigitalSignature> employeeDigitalSignatures) {

		for (EmployeeDigitalSignature employeeDigitalSignature :
				employeeDigitalSignatures) {

			entityCache.removeResult(
				EmployeeDigitalSignatureImpl.class, employeeDigitalSignature);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EmployeeDigitalSignatureImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee digital signature with the primary key. Does not add the employee digital signature to the database.
	 *
	 * @param employeeDigitalSignatureId the primary key for the new employee digital signature
	 * @return the new employee digital signature
	 */
	@Override
	public EmployeeDigitalSignature create(long employeeDigitalSignatureId) {
		EmployeeDigitalSignature employeeDigitalSignature =
			new EmployeeDigitalSignatureImpl();

		employeeDigitalSignature.setNew(true);
		employeeDigitalSignature.setPrimaryKey(employeeDigitalSignatureId);

		employeeDigitalSignature.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return employeeDigitalSignature;
	}

	/**
	 * Removes the employee digital signature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature that was removed
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	@Override
	public EmployeeDigitalSignature remove(long employeeDigitalSignatureId)
		throws NoSuchEmployeeDigitalSignatureException {

		return remove((Serializable)employeeDigitalSignatureId);
	}

	/**
	 * Removes the employee digital signature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee digital signature
	 * @return the employee digital signature that was removed
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	@Override
	public EmployeeDigitalSignature remove(Serializable primaryKey)
		throws NoSuchEmployeeDigitalSignatureException {

		Session session = null;

		try {
			session = openSession();

			EmployeeDigitalSignature employeeDigitalSignature =
				(EmployeeDigitalSignature)session.get(
					EmployeeDigitalSignatureImpl.class, primaryKey);

			if (employeeDigitalSignature == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDigitalSignatureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeDigitalSignature);
		}
		catch (NoSuchEmployeeDigitalSignatureException noSuchEntityException) {
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
	protected EmployeeDigitalSignature removeImpl(
		EmployeeDigitalSignature employeeDigitalSignature) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDigitalSignature)) {
				employeeDigitalSignature =
					(EmployeeDigitalSignature)session.get(
						EmployeeDigitalSignatureImpl.class,
						employeeDigitalSignature.getPrimaryKeyObj());
			}

			if (employeeDigitalSignature != null) {
				session.delete(employeeDigitalSignature);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeDigitalSignature != null) {
			clearCache(employeeDigitalSignature);
		}

		return employeeDigitalSignature;
	}

	@Override
	public EmployeeDigitalSignature updateImpl(
		EmployeeDigitalSignature employeeDigitalSignature) {

		boolean isNew = employeeDigitalSignature.isNew();

		if (!(employeeDigitalSignature instanceof
				EmployeeDigitalSignatureModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDigitalSignature.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeDigitalSignature);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDigitalSignature proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDigitalSignature implementation " +
					employeeDigitalSignature.getClass());
		}

		EmployeeDigitalSignatureModelImpl employeeDigitalSignatureModelImpl =
			(EmployeeDigitalSignatureModelImpl)employeeDigitalSignature;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeDigitalSignature.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeDigitalSignature.setCreateDate(now);
			}
			else {
				employeeDigitalSignature.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeDigitalSignatureModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeDigitalSignature.setModifiedDate(now);
			}
			else {
				employeeDigitalSignature.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeDigitalSignature);
			}
			else {
				employeeDigitalSignature =
					(EmployeeDigitalSignature)session.merge(
						employeeDigitalSignature);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeDigitalSignatureImpl.class,
			employeeDigitalSignatureModelImpl, false, true);

		if (isNew) {
			employeeDigitalSignature.setNew(false);
		}

		employeeDigitalSignature.resetOriginalValues();

		return employeeDigitalSignature;
	}

	/**
	 * Returns the employee digital signature with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee digital signature
	 * @return the employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	@Override
	public EmployeeDigitalSignature findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDigitalSignatureException {

		EmployeeDigitalSignature employeeDigitalSignature = fetchByPrimaryKey(
			primaryKey);

		if (employeeDigitalSignature == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDigitalSignatureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeDigitalSignature;
	}

	/**
	 * Returns the employee digital signature with the primary key or throws a <code>NoSuchEmployeeDigitalSignatureException</code> if it could not be found.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	@Override
	public EmployeeDigitalSignature findByPrimaryKey(
			long employeeDigitalSignatureId)
		throws NoSuchEmployeeDigitalSignatureException {

		return findByPrimaryKey((Serializable)employeeDigitalSignatureId);
	}

	/**
	 * Returns the employee digital signature with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature, or <code>null</code> if a employee digital signature with the primary key could not be found
	 */
	@Override
	public EmployeeDigitalSignature fetchByPrimaryKey(
		long employeeDigitalSignatureId) {

		return fetchByPrimaryKey((Serializable)employeeDigitalSignatureId);
	}

	/**
	 * Returns all the employee digital signatures.
	 *
	 * @return the employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findAll(
		int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee digital signatures
	 */
	@Override
	public List<EmployeeDigitalSignature> findAll(
		int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator,
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

		List<EmployeeDigitalSignature> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDigitalSignature>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEDIGITALSIGNATURE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDIGITALSIGNATURE;

				sql = sql.concat(
					EmployeeDigitalSignatureModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeDigitalSignature>)QueryUtil.list(
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
	 * Removes all the employee digital signatures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDigitalSignature employeeDigitalSignature : findAll()) {
			remove(employeeDigitalSignature);
		}
	}

	/**
	 * Returns the number of employee digital signatures.
	 *
	 * @return the number of employee digital signatures
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
					_SQL_COUNT_EMPLOYEEDIGITALSIGNATURE);

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
		return "employeeDigitalSignatureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEDIGITALSIGNATURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDigitalSignatureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee digital signature persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeDigitalSignatureModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeDigitalSignature.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

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

		_finderPathWithPaginationFindByCid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"cid"}, true);

		_finderPathWithoutPaginationFindByCid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCid",
			new String[] {String.class.getName()}, new String[] {"cid"}, true);

		_finderPathCountByCid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCid",
			new String[] {String.class.getName()}, new String[] {"cid"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeDigitalSignatureImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEDIGITALSIGNATURE =
		"SELECT employeeDigitalSignature FROM EmployeeDigitalSignature employeeDigitalSignature";

	private static final String _SQL_SELECT_EMPLOYEEDIGITALSIGNATURE_WHERE =
		"SELECT employeeDigitalSignature FROM EmployeeDigitalSignature employeeDigitalSignature WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEDIGITALSIGNATURE =
		"SELECT COUNT(employeeDigitalSignature) FROM EmployeeDigitalSignature employeeDigitalSignature";

	private static final String _SQL_COUNT_EMPLOYEEDIGITALSIGNATURE_WHERE =
		"SELECT COUNT(employeeDigitalSignature) FROM EmployeeDigitalSignature employeeDigitalSignature WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"employeeDigitalSignature.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeDigitalSignature exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeDigitalSignature exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeDigitalSignaturePersistenceImpl.class);

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

	private static class EmployeeDigitalSignatureModelArgumentsResolver
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

			EmployeeDigitalSignatureModelImpl
				employeeDigitalSignatureModelImpl =
					(EmployeeDigitalSignatureModelImpl)baseModel;

			long columnBitmask =
				employeeDigitalSignatureModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeDigitalSignatureModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeDigitalSignatureModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeDigitalSignatureModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeDigitalSignatureModelImpl employeeDigitalSignatureModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeDigitalSignatureModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						employeeDigitalSignatureModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}