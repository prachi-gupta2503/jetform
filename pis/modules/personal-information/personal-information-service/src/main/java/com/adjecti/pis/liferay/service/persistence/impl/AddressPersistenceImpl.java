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

import com.adjecti.pis.liferay.exception.NoSuchAddressException;
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.impl.AddressImpl;
import com.adjecti.pis.liferay.model.impl.AddressModelImpl;
import com.adjecti.pis.liferay.service.persistence.AddressPersistence;
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
 * The persistence implementation for the address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AddressPersistence.class)
public class AddressPersistenceImpl
	extends BasePersistenceImpl<Address> implements AddressPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AddressUtil</code> to access the address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AddressImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByJoiningProcessId;
	private FinderPath _finderPathWithoutPaginationFindByJoiningProcessId;
	private FinderPath _finderPathCountByJoiningProcessId;

	/**
	 * Returns all the addresses where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching addresses
	 */
	@Override
	public List<Address> findByJoiningProcessId(long joiningProcessId) {
		return findByJoiningProcessId(
			joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addresses where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	@Override
	public List<Address> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return findByJoiningProcessId(joiningProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the addresses where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addresses where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByJoiningProcessId;
				finderArgs = new Object[] {joiningProcessId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByJoiningProcessId;
			finderArgs = new Object[] {
				joiningProcessId, start, end, orderByComparator
			};
		}

		List<Address> list = null;

		if (useFinderCache) {
			list = (List<Address>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Address address : list) {
					if (joiningProcessId != address.getJoiningProcessId()) {
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

			sb.append(_SQL_SELECT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

				list = (List<Address>)QueryUtil.list(
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
	 * Returns the first address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByJoiningProcessId_First(
			long joiningProcessId, OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the first address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByJoiningProcessId_First(
		long joiningProcessId, OrderByComparator<Address> orderByComparator) {

		List<Address> list = findByJoiningProcessId(
			joiningProcessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByJoiningProcessId_Last(
			long joiningProcessId, OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByJoiningProcessId_Last(
		long joiningProcessId, OrderByComparator<Address> orderByComparator) {

		int count = countByJoiningProcessId(joiningProcessId);

		if (count == 0) {
			return null;
		}

		List<Address> list = findByJoiningProcessId(
			joiningProcessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address[] findByJoiningProcessId_PrevAndNext(
			long addressId, long joiningProcessId,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			Address[] array = new AddressImpl[3];

			array[0] = getByJoiningProcessId_PrevAndNext(
				session, address, joiningProcessId, orderByComparator, true);

			array[1] = address;

			array[2] = getByJoiningProcessId_PrevAndNext(
				session, address, joiningProcessId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Address getByJoiningProcessId_PrevAndNext(
		Session session, Address address, long joiningProcessId,
		OrderByComparator<Address> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ADDRESS_WHERE);

		sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

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
			sb.append(AddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(joiningProcessId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(address)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Address> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the addresses where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	@Override
	public void removeByJoiningProcessId(long joiningProcessId) {
		for (Address address :
				findByJoiningProcessId(
					joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(address);
		}
	}

	/**
	 * Returns the number of addresses where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching addresses
	 */
	@Override
	public int countByJoiningProcessId(long joiningProcessId) {
		FinderPath finderPath = _finderPathCountByJoiningProcessId;

		Object[] finderArgs = new Object[] {joiningProcessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

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
		_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2 =
			"address.joiningProcessId = ?";

	private FinderPath _finderPathWithPaginationFindByAccomodationTypeId;
	private FinderPath _finderPathWithoutPaginationFindByAccomodationTypeId;
	private FinderPath _finderPathCountByAccomodationTypeId;

	/**
	 * Returns all the addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the matching addresses
	 */
	@Override
	public List<Address> findByAccomodationTypeId(long accomodationTypeId) {
		return findByAccomodationTypeId(
			accomodationTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	@Override
	public List<Address> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end) {

		return findByAccomodationTypeId(accomodationTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return findByAccomodationTypeId(
			accomodationTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByAccomodationTypeId;
				finderArgs = new Object[] {accomodationTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAccomodationTypeId;
			finderArgs = new Object[] {
				accomodationTypeId, start, end, orderByComparator
			};
		}

		List<Address> list = null;

		if (useFinderCache) {
			list = (List<Address>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Address address : list) {
					if (accomodationTypeId != address.getAccomodationTypeId()) {
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

			sb.append(_SQL_SELECT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_ACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(accomodationTypeId);

				list = (List<Address>)QueryUtil.list(
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
	 * Returns the first address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByAccomodationTypeId_First(
			long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByAccomodationTypeId_First(
			accomodationTypeId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("accomodationTypeId=");
		sb.append(accomodationTypeId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the first address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByAccomodationTypeId_First(
		long accomodationTypeId, OrderByComparator<Address> orderByComparator) {

		List<Address> list = findByAccomodationTypeId(
			accomodationTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByAccomodationTypeId_Last(
			long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByAccomodationTypeId_Last(
			accomodationTypeId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("accomodationTypeId=");
		sb.append(accomodationTypeId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the last address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByAccomodationTypeId_Last(
		long accomodationTypeId, OrderByComparator<Address> orderByComparator) {

		int count = countByAccomodationTypeId(accomodationTypeId);

		if (count == 0) {
			return null;
		}

		List<Address> list = findByAccomodationTypeId(
			accomodationTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address[] findByAccomodationTypeId_PrevAndNext(
			long addressId, long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			Address[] array = new AddressImpl[3];

			array[0] = getByAccomodationTypeId_PrevAndNext(
				session, address, accomodationTypeId, orderByComparator, true);

			array[1] = address;

			array[2] = getByAccomodationTypeId_PrevAndNext(
				session, address, accomodationTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Address getByAccomodationTypeId_PrevAndNext(
		Session session, Address address, long accomodationTypeId,
		OrderByComparator<Address> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ADDRESS_WHERE);

		sb.append(_FINDER_COLUMN_ACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2);

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
			sb.append(AddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(accomodationTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(address)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Address> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the addresses where accomodationTypeId = &#63; from the database.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 */
	@Override
	public void removeByAccomodationTypeId(long accomodationTypeId) {
		for (Address address :
				findByAccomodationTypeId(
					accomodationTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(address);
		}
	}

	/**
	 * Returns the number of addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the number of matching addresses
	 */
	@Override
	public int countByAccomodationTypeId(long accomodationTypeId) {
		FinderPath finderPath = _finderPathCountByAccomodationTypeId;

		Object[] finderArgs = new Object[] {accomodationTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_ACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(accomodationTypeId);

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
		_FINDER_COLUMN_ACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2 =
			"address.accomodationTypeId = ?";

	private FinderPath
		_finderPathWithPaginationFindByJoiningProcessIdAndAccomodationTypeId;
	private FinderPath
		_finderPathWithoutPaginationFindByJoiningProcessIdAndAccomodationTypeId;
	private FinderPath _finderPathCountByJoiningProcessIdAndAccomodationTypeId;

	/**
	 * Returns all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @return the matching addresses
	 */
	@Override
	public List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId) {

		return findByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	@Override
	public List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId, int start, int end) {

		return findByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return findByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByJoiningProcessIdAndAccomodationTypeId;
				finderArgs = new Object[] {
					joiningProcessId, accomodationTypeId
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByJoiningProcessIdAndAccomodationTypeId;
			finderArgs = new Object[] {
				joiningProcessId, accomodationTypeId, start, end,
				orderByComparator
			};
		}

		List<Address> list = null;

		if (useFinderCache) {
			list = (List<Address>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Address address : list) {
					if ((joiningProcessId != address.getJoiningProcessId()) ||
						(accomodationTypeId !=
							address.getAccomodationTypeId())) {

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

			sb.append(_SQL_SELECT_ADDRESS_WHERE);

			sb.append(
				_FINDER_COLUMN_JOININGPROCESSIDANDACCOMODATIONTYPEID_JOININGPROCESSID_2);

			sb.append(
				_FINDER_COLUMN_JOININGPROCESSIDANDACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

				queryPos.add(accomodationTypeId);

				list = (List<Address>)QueryUtil.list(
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
	 * Returns the first address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByJoiningProcessIdAndAccomodationTypeId_First(
			long joiningProcessId, long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByJoiningProcessIdAndAccomodationTypeId_First(
			joiningProcessId, accomodationTypeId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append(", accomodationTypeId=");
		sb.append(accomodationTypeId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the first address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByJoiningProcessIdAndAccomodationTypeId_First(
		long joiningProcessId, long accomodationTypeId,
		OrderByComparator<Address> orderByComparator) {

		List<Address> list = findByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByJoiningProcessIdAndAccomodationTypeId_Last(
			long joiningProcessId, long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByJoiningProcessIdAndAccomodationTypeId_Last(
			joiningProcessId, accomodationTypeId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append(", accomodationTypeId=");
		sb.append(accomodationTypeId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByJoiningProcessIdAndAccomodationTypeId_Last(
		long joiningProcessId, long accomodationTypeId,
		OrderByComparator<Address> orderByComparator) {

		int count = countByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId);

		if (count == 0) {
			return null;
		}

		List<Address> list = findByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address[] findByJoiningProcessIdAndAccomodationTypeId_PrevAndNext(
			long addressId, long joiningProcessId, long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			Address[] array = new AddressImpl[3];

			array[0] = getByJoiningProcessIdAndAccomodationTypeId_PrevAndNext(
				session, address, joiningProcessId, accomodationTypeId,
				orderByComparator, true);

			array[1] = address;

			array[2] = getByJoiningProcessIdAndAccomodationTypeId_PrevAndNext(
				session, address, joiningProcessId, accomodationTypeId,
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

	protected Address getByJoiningProcessIdAndAccomodationTypeId_PrevAndNext(
		Session session, Address address, long joiningProcessId,
		long accomodationTypeId, OrderByComparator<Address> orderByComparator,
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

		sb.append(_SQL_SELECT_ADDRESS_WHERE);

		sb.append(
			_FINDER_COLUMN_JOININGPROCESSIDANDACCOMODATIONTYPEID_JOININGPROCESSID_2);

		sb.append(
			_FINDER_COLUMN_JOININGPROCESSIDANDACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2);

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
			sb.append(AddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(joiningProcessId);

		queryPos.add(accomodationTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(address)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Address> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 */
	@Override
	public void removeByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId) {

		for (Address address :
				findByJoiningProcessIdAndAccomodationTypeId(
					joiningProcessId, accomodationTypeId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(address);
		}
	}

	/**
	 * Returns the number of addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @return the number of matching addresses
	 */
	@Override
	public int countByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId) {

		FinderPath finderPath =
			_finderPathCountByJoiningProcessIdAndAccomodationTypeId;

		Object[] finderArgs = new Object[] {
			joiningProcessId, accomodationTypeId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ADDRESS_WHERE);

			sb.append(
				_FINDER_COLUMN_JOININGPROCESSIDANDACCOMODATIONTYPEID_JOININGPROCESSID_2);

			sb.append(
				_FINDER_COLUMN_JOININGPROCESSIDANDACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

				queryPos.add(accomodationTypeId);

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
		_FINDER_COLUMN_JOININGPROCESSIDANDACCOMODATIONTYPEID_JOININGPROCESSID_2 =
			"address.joiningProcessId = ? AND ";

	private static final String
		_FINDER_COLUMN_JOININGPROCESSIDANDACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2 =
			"address.accomodationTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByDistrictId;
	private FinderPath _finderPathWithoutPaginationFindByDistrictId;
	private FinderPath _finderPathCountByDistrictId;

	/**
	 * Returns all the addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching addresses
	 */
	@Override
	public List<Address> findByDistrictId(long districtId) {
		return findByDistrictId(
			districtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	@Override
	public List<Address> findByDistrictId(long districtId, int start, int end) {
		return findByDistrictId(districtId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return findByDistrictId(
			districtId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDistrictId;
				finderArgs = new Object[] {districtId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDistrictId;
			finderArgs = new Object[] {
				districtId, start, end, orderByComparator
			};
		}

		List<Address> list = null;

		if (useFinderCache) {
			list = (List<Address>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Address address : list) {
					if (districtId != address.getDistrictId()) {
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

			sb.append(_SQL_SELECT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_DISTRICTID_DISTRICTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(districtId);

				list = (List<Address>)QueryUtil.list(
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
	 * Returns the first address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByDistrictId_First(
			long districtId, OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByDistrictId_First(
			districtId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtId=");
		sb.append(districtId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the first address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByDistrictId_First(
		long districtId, OrderByComparator<Address> orderByComparator) {

		List<Address> list = findByDistrictId(
			districtId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByDistrictId_Last(
			long districtId, OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByDistrictId_Last(districtId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtId=");
		sb.append(districtId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the last address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByDistrictId_Last(
		long districtId, OrderByComparator<Address> orderByComparator) {

		int count = countByDistrictId(districtId);

		if (count == 0) {
			return null;
		}

		List<Address> list = findByDistrictId(
			districtId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where districtId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address[] findByDistrictId_PrevAndNext(
			long addressId, long districtId,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			Address[] array = new AddressImpl[3];

			array[0] = getByDistrictId_PrevAndNext(
				session, address, districtId, orderByComparator, true);

			array[1] = address;

			array[2] = getByDistrictId_PrevAndNext(
				session, address, districtId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Address getByDistrictId_PrevAndNext(
		Session session, Address address, long districtId,
		OrderByComparator<Address> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ADDRESS_WHERE);

		sb.append(_FINDER_COLUMN_DISTRICTID_DISTRICTID_2);

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
			sb.append(AddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(districtId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(address)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Address> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the addresses where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	@Override
	public void removeByDistrictId(long districtId) {
		for (Address address :
				findByDistrictId(
					districtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(address);
		}
	}

	/**
	 * Returns the number of addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching addresses
	 */
	@Override
	public int countByDistrictId(long districtId) {
		FinderPath finderPath = _finderPathCountByDistrictId;

		Object[] finderArgs = new Object[] {districtId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_DISTRICTID_DISTRICTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(districtId);

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

	private static final String _FINDER_COLUMN_DISTRICTID_DISTRICTID_2 =
		"address.districtId = ?";

	private FinderPath _finderPathWithPaginationFindByAddressId;
	private FinderPath _finderPathWithoutPaginationFindByAddressId;
	private FinderPath _finderPathCountByAddressId;

	/**
	 * Returns all the addresses where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @return the matching addresses
	 */
	@Override
	public List<Address> findByAddressId(long addressId) {
		return findByAddressId(
			addressId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addresses where addressId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param addressId the address ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	@Override
	public List<Address> findByAddressId(long addressId, int start, int end) {
		return findByAddressId(addressId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the addresses where addressId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param addressId the address ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByAddressId(
		long addressId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return findByAddressId(addressId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addresses where addressId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param addressId the address ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByAddressId(
		long addressId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAddressId;
				finderArgs = new Object[] {addressId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAddressId;
			finderArgs = new Object[] {
				addressId, start, end, orderByComparator
			};
		}

		List<Address> list = null;

		if (useFinderCache) {
			list = (List<Address>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Address address : list) {
					if (addressId != address.getAddressId()) {
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

			sb.append(_SQL_SELECT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_ADDRESSID_ADDRESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(addressId);

				list = (List<Address>)QueryUtil.list(
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
	 * Returns the first address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByAddressId_First(
			long addressId, OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByAddressId_First(addressId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("addressId=");
		sb.append(addressId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the first address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByAddressId_First(
		long addressId, OrderByComparator<Address> orderByComparator) {

		List<Address> list = findByAddressId(
			addressId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByAddressId_Last(
			long addressId, OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByAddressId_Last(addressId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("addressId=");
		sb.append(addressId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the last address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByAddressId_Last(
		long addressId, OrderByComparator<Address> orderByComparator) {

		int count = countByAddressId(addressId);

		if (count == 0) {
			return null;
		}

		List<Address> list = findByAddressId(
			addressId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the addresses where addressId = &#63; from the database.
	 *
	 * @param addressId the address ID
	 */
	@Override
	public void removeByAddressId(long addressId) {
		for (Address address :
				findByAddressId(
					addressId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(address);
		}
	}

	/**
	 * Returns the number of addresses where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @return the number of matching addresses
	 */
	@Override
	public int countByAddressId(long addressId) {
		FinderPath finderPath = _finderPathCountByAddressId;

		Object[] finderArgs = new Object[] {addressId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_ADDRESSID_ADDRESSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(addressId);

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

	private static final String _FINDER_COLUMN_ADDRESSID_ADDRESSID_2 =
		"address.addressId = ?";

	private FinderPath _finderPathWithPaginationFindByStateId;
	private FinderPath _finderPathWithoutPaginationFindByStateId;
	private FinderPath _finderPathCountByStateId;

	/**
	 * Returns all the addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching addresses
	 */
	@Override
	public List<Address> findByStateId(long stateId) {
		return findByStateId(
			stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	@Override
	public List<Address> findByStateId(long stateId, int start, int end) {
		return findByStateId(stateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return findByStateId(stateId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStateId;
				finderArgs = new Object[] {stateId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStateId;
			finderArgs = new Object[] {stateId, start, end, orderByComparator};
		}

		List<Address> list = null;

		if (useFinderCache) {
			list = (List<Address>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Address address : list) {
					if (stateId != address.getStateId()) {
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

			sb.append(_SQL_SELECT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_STATEID_STATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

				list = (List<Address>)QueryUtil.list(
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
	 * Returns the first address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByStateId_First(
			long stateId, OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByStateId_First(stateId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateId=");
		sb.append(stateId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the first address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByStateId_First(
		long stateId, OrderByComparator<Address> orderByComparator) {

		List<Address> list = findByStateId(stateId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByStateId_Last(
			long stateId, OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByStateId_Last(stateId, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateId=");
		sb.append(stateId);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the last address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByStateId_Last(
		long stateId, OrderByComparator<Address> orderByComparator) {

		int count = countByStateId(stateId);

		if (count == 0) {
			return null;
		}

		List<Address> list = findByStateId(
			stateId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where stateId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address[] findByStateId_PrevAndNext(
			long addressId, long stateId,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			Address[] array = new AddressImpl[3];

			array[0] = getByStateId_PrevAndNext(
				session, address, stateId, orderByComparator, true);

			array[1] = address;

			array[2] = getByStateId_PrevAndNext(
				session, address, stateId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Address getByStateId_PrevAndNext(
		Session session, Address address, long stateId,
		OrderByComparator<Address> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ADDRESS_WHERE);

		sb.append(_FINDER_COLUMN_STATEID_STATEID_2);

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
			sb.append(AddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(stateId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(address)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Address> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the addresses where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	@Override
	public void removeByStateId(long stateId) {
		for (Address address :
				findByStateId(
					stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(address);
		}
	}

	/**
	 * Returns the number of addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching addresses
	 */
	@Override
	public int countByStateId(long stateId) {
		FinderPath finderPath = _finderPathCountByStateId;

		Object[] finderArgs = new Object[] {stateId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_STATEID_STATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

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

	private static final String _FINDER_COLUMN_STATEID_STATEID_2 =
		"address.stateId = ?";

	public AddressPersistenceImpl() {
		setModelClass(Address.class);

		setModelImplClass(AddressImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the address in the entity cache if it is enabled.
	 *
	 * @param address the address
	 */
	@Override
	public void cacheResult(Address address) {
		entityCache.putResult(
			AddressImpl.class, address.getPrimaryKey(), address);
	}

	/**
	 * Caches the addresses in the entity cache if it is enabled.
	 *
	 * @param addresses the addresses
	 */
	@Override
	public void cacheResult(List<Address> addresses) {
		for (Address address : addresses) {
			if (entityCache.getResult(
					AddressImpl.class, address.getPrimaryKey()) == null) {

				cacheResult(address);
			}
		}
	}

	/**
	 * Clears the cache for all addresses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AddressImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the address.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Address address) {
		entityCache.removeResult(AddressImpl.class, address);
	}

	@Override
	public void clearCache(List<Address> addresses) {
		for (Address address : addresses) {
			entityCache.removeResult(AddressImpl.class, address);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AddressImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	@Override
	public Address create(long addressId) {
		Address address = new AddressImpl();

		address.setNew(true);
		address.setPrimaryKey(addressId);

		address.setCompanyId(CompanyThreadLocal.getCompanyId());

		return address;
	}

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address remove(long addressId) throws NoSuchAddressException {
		return remove((Serializable)addressId);
	}

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address remove(Serializable primaryKey)
		throws NoSuchAddressException {

		Session session = null;

		try {
			session = openSession();

			Address address = (Address)session.get(
				AddressImpl.class, primaryKey);

			if (address == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(address);
		}
		catch (NoSuchAddressException noSuchEntityException) {
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
	protected Address removeImpl(Address address) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(address)) {
				address = (Address)session.get(
					AddressImpl.class, address.getPrimaryKeyObj());
			}

			if (address != null) {
				session.delete(address);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (address != null) {
			clearCache(address);
		}

		return address;
	}

	@Override
	public Address updateImpl(Address address) {
		boolean isNew = address.isNew();

		if (!(address instanceof AddressModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(address.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(address);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in address proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Address implementation " +
					address.getClass());
		}

		AddressModelImpl addressModelImpl = (AddressModelImpl)address;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (address.getCreateDate() == null)) {
			if (serviceContext == null) {
				address.setCreateDate(now);
			}
			else {
				address.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!addressModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				address.setModifiedDate(now);
			}
			else {
				address.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(address);
			}
			else {
				address = (Address)session.merge(address);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AddressImpl.class, addressModelImpl, false, true);

		if (isNew) {
			address.setNew(false);
		}

		address.resetOriginalValues();

		return address;
	}

	/**
	 * Returns the address with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressException {

		Address address = fetchByPrimaryKey(primaryKey);

		if (address == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return address;
	}

	/**
	 * Returns the address with the primary key or throws a <code>NoSuchAddressException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address findByPrimaryKey(long addressId)
		throws NoSuchAddressException {

		return findByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns the address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address, or <code>null</code> if a address with the primary key could not be found
	 */
	@Override
	public Address fetchByPrimaryKey(long addressId) {
		return fetchByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns all the addresses.
	 *
	 * @return the addresses
	 */
	@Override
	public List<Address> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of addresses
	 */
	@Override
	public List<Address> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addresses
	 */
	@Override
	public List<Address> findAll(
		int start, int end, OrderByComparator<Address> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of addresses
	 */
	@Override
	public List<Address> findAll(
		int start, int end, OrderByComparator<Address> orderByComparator,
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

		List<Address> list = null;

		if (useFinderCache) {
			list = (List<Address>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ADDRESS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESS;

				sql = sql.concat(AddressModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Address>)QueryUtil.list(
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
	 * Removes all the addresses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Address address : findAll()) {
			remove(address);
		}
	}

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ADDRESS);

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
		return "addressId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ADDRESS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AddressModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the address persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AddressModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Address.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByJoiningProcessId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJoiningProcessId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"joiningProcessId"}, true);

		_finderPathWithoutPaginationFindByJoiningProcessId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJoiningProcessId",
			new String[] {Long.class.getName()},
			new String[] {"joiningProcessId"}, true);

		_finderPathCountByJoiningProcessId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJoiningProcessId", new String[] {Long.class.getName()},
			new String[] {"joiningProcessId"}, false);

		_finderPathWithPaginationFindByAccomodationTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAccomodationTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"accomodationTypeId"}, true);

		_finderPathWithoutPaginationFindByAccomodationTypeId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByAccomodationTypeId", new String[] {Long.class.getName()},
				new String[] {"accomodationTypeId"}, true);

		_finderPathCountByAccomodationTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAccomodationTypeId", new String[] {Long.class.getName()},
			new String[] {"accomodationTypeId"}, false);

		_finderPathWithPaginationFindByJoiningProcessIdAndAccomodationTypeId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByJoiningProcessIdAndAccomodationTypeId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"joiningProcessId", "accomodationTypeId"}, true);

		_finderPathWithoutPaginationFindByJoiningProcessIdAndAccomodationTypeId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByJoiningProcessIdAndAccomodationTypeId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"joiningProcessId", "accomodationTypeId"}, true);

		_finderPathCountByJoiningProcessIdAndAccomodationTypeId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByJoiningProcessIdAndAccomodationTypeId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"joiningProcessId", "accomodationTypeId"}, false);

		_finderPathWithPaginationFindByDistrictId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDistrictId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"districtId"}, true);

		_finderPathWithoutPaginationFindByDistrictId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDistrictId",
			new String[] {Long.class.getName()}, new String[] {"districtId"},
			true);

		_finderPathCountByDistrictId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDistrictId",
			new String[] {Long.class.getName()}, new String[] {"districtId"},
			false);

		_finderPathWithPaginationFindByAddressId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAddressId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"addressId"}, true);

		_finderPathWithoutPaginationFindByAddressId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAddressId",
			new String[] {Long.class.getName()}, new String[] {"addressId"},
			true);

		_finderPathCountByAddressId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAddressId",
			new String[] {Long.class.getName()}, new String[] {"addressId"},
			false);

		_finderPathWithPaginationFindByStateId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStateId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"stateId"}, true);

		_finderPathWithoutPaginationFindByStateId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStateId",
			new String[] {Long.class.getName()}, new String[] {"stateId"},
			true);

		_finderPathCountByStateId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStateId",
			new String[] {Long.class.getName()}, new String[] {"stateId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AddressImpl.class.getName());

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

	private static final String _SQL_SELECT_ADDRESS =
		"SELECT address FROM Address address";

	private static final String _SQL_SELECT_ADDRESS_WHERE =
		"SELECT address FROM Address address WHERE ";

	private static final String _SQL_COUNT_ADDRESS =
		"SELECT COUNT(address) FROM Address address";

	private static final String _SQL_COUNT_ADDRESS_WHERE =
		"SELECT COUNT(address) FROM Address address WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "address.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Address exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Address exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AddressPersistenceImpl.class);

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

	private static class AddressModelArgumentsResolver
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

			AddressModelImpl addressModelImpl = (AddressModelImpl)baseModel;

			long columnBitmask = addressModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(addressModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						addressModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(addressModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			AddressModelImpl addressModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = addressModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = addressModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}