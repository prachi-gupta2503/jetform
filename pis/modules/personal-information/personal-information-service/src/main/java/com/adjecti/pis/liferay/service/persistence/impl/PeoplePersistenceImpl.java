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

import com.adjecti.pis.liferay.exception.NoSuchPeopleException;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.model.impl.PeopleImpl;
import com.adjecti.pis.liferay.model.impl.PeopleModelImpl;
import com.adjecti.pis.liferay.service.persistence.PeoplePersistence;
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

import java.sql.Timestamp;

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
 * The persistence implementation for the people service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PeoplePersistence.class)
public class PeoplePersistenceImpl
	extends BasePersistenceImpl<People> implements PeoplePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PeopleUtil</code> to access the people persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PeopleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDateOfBirth;
	private FinderPath _finderPathWithoutPaginationFindByDateOfBirth;
	private FinderPath _finderPathCountByDateOfBirth;

	/**
	 * Returns all the peoples where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @return the matching peoples
	 */
	@Override
	public List<People> findByDateOfBirth(Date dateOfBirth) {
		return findByDateOfBirth(
			dateOfBirth, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples where dateOfBirth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dateOfBirth the date of birth
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	@Override
	public List<People> findByDateOfBirth(
		Date dateOfBirth, int start, int end) {

		return findByDateOfBirth(dateOfBirth, start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples where dateOfBirth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dateOfBirth the date of birth
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByDateOfBirth(
		Date dateOfBirth, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return findByDateOfBirth(
			dateOfBirth, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples where dateOfBirth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dateOfBirth the date of birth
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByDateOfBirth(
		Date dateOfBirth, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDateOfBirth;
				finderArgs = new Object[] {_getTime(dateOfBirth)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDateOfBirth;
			finderArgs = new Object[] {
				_getTime(dateOfBirth), start, end, orderByComparator
			};
		}

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (People people : list) {
					if (!Objects.equals(dateOfBirth, people.getDateOfBirth())) {
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

			sb.append(_SQL_SELECT_PEOPLE_WHERE);

			boolean bindDateOfBirth = false;

			if (dateOfBirth == null) {
				sb.append(_FINDER_COLUMN_DATEOFBIRTH_DATEOFBIRTH_1);
			}
			else {
				bindDateOfBirth = true;

				sb.append(_FINDER_COLUMN_DATEOFBIRTH_DATEOFBIRTH_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PeopleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDateOfBirth) {
					queryPos.add(new Timestamp(dateOfBirth.getTime()));
				}

				list = (List<People>)QueryUtil.list(
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
	 * Returns the first people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByDateOfBirth_First(
			Date dateOfBirth, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByDateOfBirth_First(
			dateOfBirth, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dateOfBirth=");
		sb.append(dateOfBirth);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the first people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByDateOfBirth_First(
		Date dateOfBirth, OrderByComparator<People> orderByComparator) {

		List<People> list = findByDateOfBirth(
			dateOfBirth, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByDateOfBirth_Last(
			Date dateOfBirth, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByDateOfBirth_Last(dateOfBirth, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dateOfBirth=");
		sb.append(dateOfBirth);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the last people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByDateOfBirth_Last(
		Date dateOfBirth, OrderByComparator<People> orderByComparator) {

		int count = countByDateOfBirth(dateOfBirth);

		if (count == 0) {
			return null;
		}

		List<People> list = findByDateOfBirth(
			dateOfBirth, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People[] findByDateOfBirth_PrevAndNext(
			long peopleId, Date dateOfBirth,
			OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = findByPrimaryKey(peopleId);

		Session session = null;

		try {
			session = openSession();

			People[] array = new PeopleImpl[3];

			array[0] = getByDateOfBirth_PrevAndNext(
				session, people, dateOfBirth, orderByComparator, true);

			array[1] = people;

			array[2] = getByDateOfBirth_PrevAndNext(
				session, people, dateOfBirth, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected People getByDateOfBirth_PrevAndNext(
		Session session, People people, Date dateOfBirth,
		OrderByComparator<People> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PEOPLE_WHERE);

		boolean bindDateOfBirth = false;

		if (dateOfBirth == null) {
			sb.append(_FINDER_COLUMN_DATEOFBIRTH_DATEOFBIRTH_1);
		}
		else {
			bindDateOfBirth = true;

			sb.append(_FINDER_COLUMN_DATEOFBIRTH_DATEOFBIRTH_2);
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
			sb.append(PeopleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDateOfBirth) {
			queryPos.add(new Timestamp(dateOfBirth.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(people)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<People> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the peoples where dateOfBirth = &#63; from the database.
	 *
	 * @param dateOfBirth the date of birth
	 */
	@Override
	public void removeByDateOfBirth(Date dateOfBirth) {
		for (People people :
				findByDateOfBirth(
					dateOfBirth, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(people);
		}
	}

	/**
	 * Returns the number of peoples where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @return the number of matching peoples
	 */
	@Override
	public int countByDateOfBirth(Date dateOfBirth) {
		FinderPath finderPath = _finderPathCountByDateOfBirth;

		Object[] finderArgs = new Object[] {_getTime(dateOfBirth)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PEOPLE_WHERE);

			boolean bindDateOfBirth = false;

			if (dateOfBirth == null) {
				sb.append(_FINDER_COLUMN_DATEOFBIRTH_DATEOFBIRTH_1);
			}
			else {
				bindDateOfBirth = true;

				sb.append(_FINDER_COLUMN_DATEOFBIRTH_DATEOFBIRTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDateOfBirth) {
					queryPos.add(new Timestamp(dateOfBirth.getTime()));
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

	private static final String _FINDER_COLUMN_DATEOFBIRTH_DATEOFBIRTH_1 =
		"people.dateOfBirth IS NULL";

	private static final String _FINDER_COLUMN_DATEOFBIRTH_DATEOFBIRTH_2 =
		"people.dateOfBirth = ?";

	private FinderPath _finderPathWithPaginationFindByAppellationId;
	private FinderPath _finderPathWithoutPaginationFindByAppellationId;
	private FinderPath _finderPathCountByAppellationId;

	/**
	 * Returns all the peoples where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @return the matching peoples
	 */
	@Override
	public List<People> findByAppellationId(long appellationId) {
		return findByAppellationId(
			appellationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples where appellationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param appellationId the appellation ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	@Override
	public List<People> findByAppellationId(
		long appellationId, int start, int end) {

		return findByAppellationId(appellationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples where appellationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param appellationId the appellation ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByAppellationId(
		long appellationId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return findByAppellationId(
			appellationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples where appellationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param appellationId the appellation ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByAppellationId(
		long appellationId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAppellationId;
				finderArgs = new Object[] {appellationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAppellationId;
			finderArgs = new Object[] {
				appellationId, start, end, orderByComparator
			};
		}

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (People people : list) {
					if (appellationId != people.getAppellationId()) {
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

			sb.append(_SQL_SELECT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_APPELLATIONID_APPELLATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PeopleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appellationId);

				list = (List<People>)QueryUtil.list(
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
	 * Returns the first people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByAppellationId_First(
			long appellationId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByAppellationId_First(
			appellationId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appellationId=");
		sb.append(appellationId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the first people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByAppellationId_First(
		long appellationId, OrderByComparator<People> orderByComparator) {

		List<People> list = findByAppellationId(
			appellationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByAppellationId_Last(
			long appellationId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByAppellationId_Last(
			appellationId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appellationId=");
		sb.append(appellationId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the last people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByAppellationId_Last(
		long appellationId, OrderByComparator<People> orderByComparator) {

		int count = countByAppellationId(appellationId);

		if (count == 0) {
			return null;
		}

		List<People> list = findByAppellationId(
			appellationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where appellationId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People[] findByAppellationId_PrevAndNext(
			long peopleId, long appellationId,
			OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = findByPrimaryKey(peopleId);

		Session session = null;

		try {
			session = openSession();

			People[] array = new PeopleImpl[3];

			array[0] = getByAppellationId_PrevAndNext(
				session, people, appellationId, orderByComparator, true);

			array[1] = people;

			array[2] = getByAppellationId_PrevAndNext(
				session, people, appellationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected People getByAppellationId_PrevAndNext(
		Session session, People people, long appellationId,
		OrderByComparator<People> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PEOPLE_WHERE);

		sb.append(_FINDER_COLUMN_APPELLATIONID_APPELLATIONID_2);

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
			sb.append(PeopleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(appellationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(people)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<People> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the peoples where appellationId = &#63; from the database.
	 *
	 * @param appellationId the appellation ID
	 */
	@Override
	public void removeByAppellationId(long appellationId) {
		for (People people :
				findByAppellationId(
					appellationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(people);
		}
	}

	/**
	 * Returns the number of peoples where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @return the number of matching peoples
	 */
	@Override
	public int countByAppellationId(long appellationId) {
		FinderPath finderPath = _finderPathCountByAppellationId;

		Object[] finderArgs = new Object[] {appellationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_APPELLATIONID_APPELLATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appellationId);

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

	private static final String _FINDER_COLUMN_APPELLATIONID_APPELLATIONID_2 =
		"people.appellationId = ?";

	private FinderPath _finderPathWithPaginationFindByGenderId;
	private FinderPath _finderPathWithoutPaginationFindByGenderId;
	private FinderPath _finderPathCountByGenderId;

	/**
	 * Returns all the peoples where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @return the matching peoples
	 */
	@Override
	public List<People> findByGenderId(long genderId) {
		return findByGenderId(
			genderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples where genderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param genderId the gender ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	@Override
	public List<People> findByGenderId(long genderId, int start, int end) {
		return findByGenderId(genderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples where genderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param genderId the gender ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByGenderId(
		long genderId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return findByGenderId(genderId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples where genderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param genderId the gender ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByGenderId(
		long genderId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGenderId;
				finderArgs = new Object[] {genderId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGenderId;
			finderArgs = new Object[] {genderId, start, end, orderByComparator};
		}

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (People people : list) {
					if (genderId != people.getGenderId()) {
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

			sb.append(_SQL_SELECT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_GENDERID_GENDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PeopleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(genderId);

				list = (List<People>)QueryUtil.list(
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
	 * Returns the first people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByGenderId_First(
			long genderId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByGenderId_First(genderId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("genderId=");
		sb.append(genderId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the first people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByGenderId_First(
		long genderId, OrderByComparator<People> orderByComparator) {

		List<People> list = findByGenderId(genderId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByGenderId_Last(
			long genderId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByGenderId_Last(genderId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("genderId=");
		sb.append(genderId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the last people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByGenderId_Last(
		long genderId, OrderByComparator<People> orderByComparator) {

		int count = countByGenderId(genderId);

		if (count == 0) {
			return null;
		}

		List<People> list = findByGenderId(
			genderId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where genderId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People[] findByGenderId_PrevAndNext(
			long peopleId, long genderId,
			OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = findByPrimaryKey(peopleId);

		Session session = null;

		try {
			session = openSession();

			People[] array = new PeopleImpl[3];

			array[0] = getByGenderId_PrevAndNext(
				session, people, genderId, orderByComparator, true);

			array[1] = people;

			array[2] = getByGenderId_PrevAndNext(
				session, people, genderId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected People getByGenderId_PrevAndNext(
		Session session, People people, long genderId,
		OrderByComparator<People> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PEOPLE_WHERE);

		sb.append(_FINDER_COLUMN_GENDERID_GENDERID_2);

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
			sb.append(PeopleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(genderId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(people)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<People> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the peoples where genderId = &#63; from the database.
	 *
	 * @param genderId the gender ID
	 */
	@Override
	public void removeByGenderId(long genderId) {
		for (People people :
				findByGenderId(
					genderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(people);
		}
	}

	/**
	 * Returns the number of peoples where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @return the number of matching peoples
	 */
	@Override
	public int countByGenderId(long genderId) {
		FinderPath finderPath = _finderPathCountByGenderId;

		Object[] finderArgs = new Object[] {genderId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_GENDERID_GENDERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(genderId);

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

	private static final String _FINDER_COLUMN_GENDERID_GENDERID_2 =
		"people.genderId = ?";

	private FinderPath _finderPathWithPaginationFindByMaritalStatusId;
	private FinderPath _finderPathWithoutPaginationFindByMaritalStatusId;
	private FinderPath _finderPathCountByMaritalStatusId;

	/**
	 * Returns all the peoples where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @return the matching peoples
	 */
	@Override
	public List<People> findByMaritalStatusId(long maritalStatusId) {
		return findByMaritalStatusId(
			maritalStatusId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples where maritalStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param maritalStatusId the marital status ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	@Override
	public List<People> findByMaritalStatusId(
		long maritalStatusId, int start, int end) {

		return findByMaritalStatusId(maritalStatusId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples where maritalStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param maritalStatusId the marital status ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByMaritalStatusId(
		long maritalStatusId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return findByMaritalStatusId(
			maritalStatusId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples where maritalStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param maritalStatusId the marital status ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByMaritalStatusId(
		long maritalStatusId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByMaritalStatusId;
				finderArgs = new Object[] {maritalStatusId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMaritalStatusId;
			finderArgs = new Object[] {
				maritalStatusId, start, end, orderByComparator
			};
		}

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (People people : list) {
					if (maritalStatusId != people.getMaritalStatusId()) {
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

			sb.append(_SQL_SELECT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_MARITALSTATUSID_MARITALSTATUSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PeopleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(maritalStatusId);

				list = (List<People>)QueryUtil.list(
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
	 * Returns the first people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByMaritalStatusId_First(
			long maritalStatusId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByMaritalStatusId_First(
			maritalStatusId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("maritalStatusId=");
		sb.append(maritalStatusId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the first people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByMaritalStatusId_First(
		long maritalStatusId, OrderByComparator<People> orderByComparator) {

		List<People> list = findByMaritalStatusId(
			maritalStatusId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByMaritalStatusId_Last(
			long maritalStatusId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByMaritalStatusId_Last(
			maritalStatusId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("maritalStatusId=");
		sb.append(maritalStatusId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the last people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByMaritalStatusId_Last(
		long maritalStatusId, OrderByComparator<People> orderByComparator) {

		int count = countByMaritalStatusId(maritalStatusId);

		if (count == 0) {
			return null;
		}

		List<People> list = findByMaritalStatusId(
			maritalStatusId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People[] findByMaritalStatusId_PrevAndNext(
			long peopleId, long maritalStatusId,
			OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = findByPrimaryKey(peopleId);

		Session session = null;

		try {
			session = openSession();

			People[] array = new PeopleImpl[3];

			array[0] = getByMaritalStatusId_PrevAndNext(
				session, people, maritalStatusId, orderByComparator, true);

			array[1] = people;

			array[2] = getByMaritalStatusId_PrevAndNext(
				session, people, maritalStatusId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected People getByMaritalStatusId_PrevAndNext(
		Session session, People people, long maritalStatusId,
		OrderByComparator<People> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PEOPLE_WHERE);

		sb.append(_FINDER_COLUMN_MARITALSTATUSID_MARITALSTATUSID_2);

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
			sb.append(PeopleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(maritalStatusId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(people)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<People> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the peoples where maritalStatusId = &#63; from the database.
	 *
	 * @param maritalStatusId the marital status ID
	 */
	@Override
	public void removeByMaritalStatusId(long maritalStatusId) {
		for (People people :
				findByMaritalStatusId(
					maritalStatusId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(people);
		}
	}

	/**
	 * Returns the number of peoples where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @return the number of matching peoples
	 */
	@Override
	public int countByMaritalStatusId(long maritalStatusId) {
		FinderPath finderPath = _finderPathCountByMaritalStatusId;

		Object[] finderArgs = new Object[] {maritalStatusId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_MARITALSTATUSID_MARITALSTATUSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(maritalStatusId);

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
		_FINDER_COLUMN_MARITALSTATUSID_MARITALSTATUSID_2 =
			"people.maritalStatusId = ?";

	private FinderPath _finderPathWithPaginationFindByCasteCategoryId;
	private FinderPath _finderPathWithoutPaginationFindByCasteCategoryId;
	private FinderPath _finderPathCountByCasteCategoryId;

	/**
	 * Returns all the peoples where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @return the matching peoples
	 */
	@Override
	public List<People> findByCasteCategoryId(long casteCategoryId) {
		return findByCasteCategoryId(
			casteCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples where casteCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param casteCategoryId the caste category ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	@Override
	public List<People> findByCasteCategoryId(
		long casteCategoryId, int start, int end) {

		return findByCasteCategoryId(casteCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples where casteCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param casteCategoryId the caste category ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByCasteCategoryId(
		long casteCategoryId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return findByCasteCategoryId(
			casteCategoryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples where casteCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param casteCategoryId the caste category ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByCasteCategoryId(
		long casteCategoryId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCasteCategoryId;
				finderArgs = new Object[] {casteCategoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCasteCategoryId;
			finderArgs = new Object[] {
				casteCategoryId, start, end, orderByComparator
			};
		}

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (People people : list) {
					if (casteCategoryId != people.getCasteCategoryId()) {
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

			sb.append(_SQL_SELECT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_CASTECATEGORYID_CASTECATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PeopleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(casteCategoryId);

				list = (List<People>)QueryUtil.list(
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
	 * Returns the first people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByCasteCategoryId_First(
			long casteCategoryId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByCasteCategoryId_First(
			casteCategoryId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("casteCategoryId=");
		sb.append(casteCategoryId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the first people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByCasteCategoryId_First(
		long casteCategoryId, OrderByComparator<People> orderByComparator) {

		List<People> list = findByCasteCategoryId(
			casteCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByCasteCategoryId_Last(
			long casteCategoryId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByCasteCategoryId_Last(
			casteCategoryId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("casteCategoryId=");
		sb.append(casteCategoryId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the last people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByCasteCategoryId_Last(
		long casteCategoryId, OrderByComparator<People> orderByComparator) {

		int count = countByCasteCategoryId(casteCategoryId);

		if (count == 0) {
			return null;
		}

		List<People> list = findByCasteCategoryId(
			casteCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People[] findByCasteCategoryId_PrevAndNext(
			long peopleId, long casteCategoryId,
			OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = findByPrimaryKey(peopleId);

		Session session = null;

		try {
			session = openSession();

			People[] array = new PeopleImpl[3];

			array[0] = getByCasteCategoryId_PrevAndNext(
				session, people, casteCategoryId, orderByComparator, true);

			array[1] = people;

			array[2] = getByCasteCategoryId_PrevAndNext(
				session, people, casteCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected People getByCasteCategoryId_PrevAndNext(
		Session session, People people, long casteCategoryId,
		OrderByComparator<People> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PEOPLE_WHERE);

		sb.append(_FINDER_COLUMN_CASTECATEGORYID_CASTECATEGORYID_2);

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
			sb.append(PeopleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(casteCategoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(people)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<People> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the peoples where casteCategoryId = &#63; from the database.
	 *
	 * @param casteCategoryId the caste category ID
	 */
	@Override
	public void removeByCasteCategoryId(long casteCategoryId) {
		for (People people :
				findByCasteCategoryId(
					casteCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(people);
		}
	}

	/**
	 * Returns the number of peoples where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @return the number of matching peoples
	 */
	@Override
	public int countByCasteCategoryId(long casteCategoryId) {
		FinderPath finderPath = _finderPathCountByCasteCategoryId;

		Object[] finderArgs = new Object[] {casteCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_CASTECATEGORYID_CASTECATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(casteCategoryId);

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
		_FINDER_COLUMN_CASTECATEGORYID_CASTECATEGORYID_2 =
			"people.casteCategoryId = ?";

	private FinderPath _finderPathWithPaginationFindByBloodGroupId;
	private FinderPath _finderPathWithoutPaginationFindByBloodGroupId;
	private FinderPath _finderPathCountByBloodGroupId;

	/**
	 * Returns all the peoples where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @return the matching peoples
	 */
	@Override
	public List<People> findByBloodGroupId(long bloodGroupId) {
		return findByBloodGroupId(
			bloodGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples where bloodGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param bloodGroupId the blood group ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	@Override
	public List<People> findByBloodGroupId(
		long bloodGroupId, int start, int end) {

		return findByBloodGroupId(bloodGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples where bloodGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param bloodGroupId the blood group ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByBloodGroupId(
		long bloodGroupId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return findByBloodGroupId(
			bloodGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples where bloodGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param bloodGroupId the blood group ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByBloodGroupId(
		long bloodGroupId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBloodGroupId;
				finderArgs = new Object[] {bloodGroupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBloodGroupId;
			finderArgs = new Object[] {
				bloodGroupId, start, end, orderByComparator
			};
		}

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (People people : list) {
					if (bloodGroupId != people.getBloodGroupId()) {
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

			sb.append(_SQL_SELECT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_BLOODGROUPID_BLOODGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PeopleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bloodGroupId);

				list = (List<People>)QueryUtil.list(
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
	 * Returns the first people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByBloodGroupId_First(
			long bloodGroupId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByBloodGroupId_First(
			bloodGroupId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bloodGroupId=");
		sb.append(bloodGroupId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the first people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByBloodGroupId_First(
		long bloodGroupId, OrderByComparator<People> orderByComparator) {

		List<People> list = findByBloodGroupId(
			bloodGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByBloodGroupId_Last(
			long bloodGroupId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByBloodGroupId_Last(
			bloodGroupId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bloodGroupId=");
		sb.append(bloodGroupId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the last people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByBloodGroupId_Last(
		long bloodGroupId, OrderByComparator<People> orderByComparator) {

		int count = countByBloodGroupId(bloodGroupId);

		if (count == 0) {
			return null;
		}

		List<People> list = findByBloodGroupId(
			bloodGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People[] findByBloodGroupId_PrevAndNext(
			long peopleId, long bloodGroupId,
			OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = findByPrimaryKey(peopleId);

		Session session = null;

		try {
			session = openSession();

			People[] array = new PeopleImpl[3];

			array[0] = getByBloodGroupId_PrevAndNext(
				session, people, bloodGroupId, orderByComparator, true);

			array[1] = people;

			array[2] = getByBloodGroupId_PrevAndNext(
				session, people, bloodGroupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected People getByBloodGroupId_PrevAndNext(
		Session session, People people, long bloodGroupId,
		OrderByComparator<People> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PEOPLE_WHERE);

		sb.append(_FINDER_COLUMN_BLOODGROUPID_BLOODGROUPID_2);

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
			sb.append(PeopleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bloodGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(people)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<People> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the peoples where bloodGroupId = &#63; from the database.
	 *
	 * @param bloodGroupId the blood group ID
	 */
	@Override
	public void removeByBloodGroupId(long bloodGroupId) {
		for (People people :
				findByBloodGroupId(
					bloodGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(people);
		}
	}

	/**
	 * Returns the number of peoples where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @return the number of matching peoples
	 */
	@Override
	public int countByBloodGroupId(long bloodGroupId) {
		FinderPath finderPath = _finderPathCountByBloodGroupId;

		Object[] finderArgs = new Object[] {bloodGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_BLOODGROUPID_BLOODGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bloodGroupId);

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

	private static final String _FINDER_COLUMN_BLOODGROUPID_BLOODGROUPID_2 =
		"people.bloodGroupId = ?";

	private FinderPath _finderPathWithPaginationFindByCitizenshipId;
	private FinderPath _finderPathWithoutPaginationFindByCitizenshipId;
	private FinderPath _finderPathCountByCitizenshipId;

	/**
	 * Returns all the peoples where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @return the matching peoples
	 */
	@Override
	public List<People> findByCitizenshipId(long citizenshipId) {
		return findByCitizenshipId(
			citizenshipId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples where citizenshipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param citizenshipId the citizenship ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	@Override
	public List<People> findByCitizenshipId(
		long citizenshipId, int start, int end) {

		return findByCitizenshipId(citizenshipId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples where citizenshipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param citizenshipId the citizenship ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByCitizenshipId(
		long citizenshipId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return findByCitizenshipId(
			citizenshipId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples where citizenshipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param citizenshipId the citizenship ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByCitizenshipId(
		long citizenshipId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCitizenshipId;
				finderArgs = new Object[] {citizenshipId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCitizenshipId;
			finderArgs = new Object[] {
				citizenshipId, start, end, orderByComparator
			};
		}

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (People people : list) {
					if (citizenshipId != people.getCitizenshipId()) {
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

			sb.append(_SQL_SELECT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_CITIZENSHIPID_CITIZENSHIPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PeopleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(citizenshipId);

				list = (List<People>)QueryUtil.list(
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
	 * Returns the first people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByCitizenshipId_First(
			long citizenshipId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByCitizenshipId_First(
			citizenshipId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("citizenshipId=");
		sb.append(citizenshipId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the first people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByCitizenshipId_First(
		long citizenshipId, OrderByComparator<People> orderByComparator) {

		List<People> list = findByCitizenshipId(
			citizenshipId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByCitizenshipId_Last(
			long citizenshipId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByCitizenshipId_Last(
			citizenshipId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("citizenshipId=");
		sb.append(citizenshipId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the last people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByCitizenshipId_Last(
		long citizenshipId, OrderByComparator<People> orderByComparator) {

		int count = countByCitizenshipId(citizenshipId);

		if (count == 0) {
			return null;
		}

		List<People> list = findByCitizenshipId(
			citizenshipId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People[] findByCitizenshipId_PrevAndNext(
			long peopleId, long citizenshipId,
			OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = findByPrimaryKey(peopleId);

		Session session = null;

		try {
			session = openSession();

			People[] array = new PeopleImpl[3];

			array[0] = getByCitizenshipId_PrevAndNext(
				session, people, citizenshipId, orderByComparator, true);

			array[1] = people;

			array[2] = getByCitizenshipId_PrevAndNext(
				session, people, citizenshipId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected People getByCitizenshipId_PrevAndNext(
		Session session, People people, long citizenshipId,
		OrderByComparator<People> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PEOPLE_WHERE);

		sb.append(_FINDER_COLUMN_CITIZENSHIPID_CITIZENSHIPID_2);

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
			sb.append(PeopleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(citizenshipId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(people)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<People> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the peoples where citizenshipId = &#63; from the database.
	 *
	 * @param citizenshipId the citizenship ID
	 */
	@Override
	public void removeByCitizenshipId(long citizenshipId) {
		for (People people :
				findByCitizenshipId(
					citizenshipId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(people);
		}
	}

	/**
	 * Returns the number of peoples where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @return the number of matching peoples
	 */
	@Override
	public int countByCitizenshipId(long citizenshipId) {
		FinderPath finderPath = _finderPathCountByCitizenshipId;

		Object[] finderArgs = new Object[] {citizenshipId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_CITIZENSHIPID_CITIZENSHIPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(citizenshipId);

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

	private static final String _FINDER_COLUMN_CITIZENSHIPID_CITIZENSHIPID_2 =
		"people.citizenshipId = ?";

	private FinderPath _finderPathWithPaginationFindByPhTypeId;
	private FinderPath _finderPathWithoutPaginationFindByPhTypeId;
	private FinderPath _finderPathCountByPhTypeId;

	/**
	 * Returns all the peoples where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @return the matching peoples
	 */
	@Override
	public List<People> findByPhTypeId(long phTypeId) {
		return findByPhTypeId(
			phTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples where phTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param phTypeId the ph type ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	@Override
	public List<People> findByPhTypeId(long phTypeId, int start, int end) {
		return findByPhTypeId(phTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples where phTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param phTypeId the ph type ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByPhTypeId(
		long phTypeId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return findByPhTypeId(phTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples where phTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param phTypeId the ph type ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByPhTypeId(
		long phTypeId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPhTypeId;
				finderArgs = new Object[] {phTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPhTypeId;
			finderArgs = new Object[] {phTypeId, start, end, orderByComparator};
		}

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (People people : list) {
					if (phTypeId != people.getPhTypeId()) {
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

			sb.append(_SQL_SELECT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_PHTYPEID_PHTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PeopleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(phTypeId);

				list = (List<People>)QueryUtil.list(
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
	 * Returns the first people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByPhTypeId_First(
			long phTypeId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByPhTypeId_First(phTypeId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phTypeId=");
		sb.append(phTypeId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the first people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByPhTypeId_First(
		long phTypeId, OrderByComparator<People> orderByComparator) {

		List<People> list = findByPhTypeId(phTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByPhTypeId_Last(
			long phTypeId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByPhTypeId_Last(phTypeId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phTypeId=");
		sb.append(phTypeId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the last people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByPhTypeId_Last(
		long phTypeId, OrderByComparator<People> orderByComparator) {

		int count = countByPhTypeId(phTypeId);

		if (count == 0) {
			return null;
		}

		List<People> list = findByPhTypeId(
			phTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where phTypeId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People[] findByPhTypeId_PrevAndNext(
			long peopleId, long phTypeId,
			OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = findByPrimaryKey(peopleId);

		Session session = null;

		try {
			session = openSession();

			People[] array = new PeopleImpl[3];

			array[0] = getByPhTypeId_PrevAndNext(
				session, people, phTypeId, orderByComparator, true);

			array[1] = people;

			array[2] = getByPhTypeId_PrevAndNext(
				session, people, phTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected People getByPhTypeId_PrevAndNext(
		Session session, People people, long phTypeId,
		OrderByComparator<People> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PEOPLE_WHERE);

		sb.append(_FINDER_COLUMN_PHTYPEID_PHTYPEID_2);

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
			sb.append(PeopleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(phTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(people)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<People> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the peoples where phTypeId = &#63; from the database.
	 *
	 * @param phTypeId the ph type ID
	 */
	@Override
	public void removeByPhTypeId(long phTypeId) {
		for (People people :
				findByPhTypeId(
					phTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(people);
		}
	}

	/**
	 * Returns the number of peoples where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @return the number of matching peoples
	 */
	@Override
	public int countByPhTypeId(long phTypeId) {
		FinderPath finderPath = _finderPathCountByPhTypeId;

		Object[] finderArgs = new Object[] {phTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_PHTYPEID_PHTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(phTypeId);

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

	private static final String _FINDER_COLUMN_PHTYPEID_PHTYPEID_2 =
		"people.phTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByReligionId;
	private FinderPath _finderPathWithoutPaginationFindByReligionId;
	private FinderPath _finderPathCountByReligionId;

	/**
	 * Returns all the peoples where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @return the matching peoples
	 */
	@Override
	public List<People> findByReligionId(long religionId) {
		return findByReligionId(
			religionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	@Override
	public List<People> findByReligionId(long religionId, int start, int end) {
		return findByReligionId(religionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByReligionId(
		long religionId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return findByReligionId(
			religionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByReligionId(
		long religionId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByReligionId;
				finderArgs = new Object[] {religionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByReligionId;
			finderArgs = new Object[] {
				religionId, start, end, orderByComparator
			};
		}

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (People people : list) {
					if (religionId != people.getReligionId()) {
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

			sb.append(_SQL_SELECT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_RELIGIONID_RELIGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PeopleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(religionId);

				list = (List<People>)QueryUtil.list(
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
	 * Returns the first people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByReligionId_First(
			long religionId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByReligionId_First(religionId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("religionId=");
		sb.append(religionId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the first people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByReligionId_First(
		long religionId, OrderByComparator<People> orderByComparator) {

		List<People> list = findByReligionId(
			religionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByReligionId_Last(
			long religionId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByReligionId_Last(religionId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("religionId=");
		sb.append(religionId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the last people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByReligionId_Last(
		long religionId, OrderByComparator<People> orderByComparator) {

		int count = countByReligionId(religionId);

		if (count == 0) {
			return null;
		}

		List<People> list = findByReligionId(
			religionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where religionId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People[] findByReligionId_PrevAndNext(
			long peopleId, long religionId,
			OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = findByPrimaryKey(peopleId);

		Session session = null;

		try {
			session = openSession();

			People[] array = new PeopleImpl[3];

			array[0] = getByReligionId_PrevAndNext(
				session, people, religionId, orderByComparator, true);

			array[1] = people;

			array[2] = getByReligionId_PrevAndNext(
				session, people, religionId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected People getByReligionId_PrevAndNext(
		Session session, People people, long religionId,
		OrderByComparator<People> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PEOPLE_WHERE);

		sb.append(_FINDER_COLUMN_RELIGIONID_RELIGIONID_2);

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
			sb.append(PeopleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(religionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(people)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<People> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the peoples where religionId = &#63; from the database.
	 *
	 * @param religionId the religion ID
	 */
	@Override
	public void removeByReligionId(long religionId) {
		for (People people :
				findByReligionId(
					religionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(people);
		}
	}

	/**
	 * Returns the number of peoples where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @return the number of matching peoples
	 */
	@Override
	public int countByReligionId(long religionId) {
		FinderPath finderPath = _finderPathCountByReligionId;

		Object[] finderArgs = new Object[] {religionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_RELIGIONID_RELIGIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(religionId);

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

	private static final String _FINDER_COLUMN_RELIGIONID_RELIGIONID_2 =
		"people.religionId = ?";

	private FinderPath _finderPathWithPaginationFindByJoiningProcessId;
	private FinderPath _finderPathWithoutPaginationFindByJoiningProcessId;
	private FinderPath _finderPathCountByJoiningProcessId;

	/**
	 * Returns all the peoples where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching peoples
	 */
	@Override
	public List<People> findByJoiningProcessId(long joiningProcessId) {
		return findByJoiningProcessId(
			joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	@Override
	public List<People> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return findByJoiningProcessId(joiningProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	@Override
	public List<People> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

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

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (People people : list) {
					if (joiningProcessId != people.getJoiningProcessId()) {
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

			sb.append(_SQL_SELECT_PEOPLE_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PeopleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

				list = (List<People>)QueryUtil.list(
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
	 * Returns the first people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByJoiningProcessId_First(
			long joiningProcessId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the first people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByJoiningProcessId_First(
		long joiningProcessId, OrderByComparator<People> orderByComparator) {

		List<People> list = findByJoiningProcessId(
			joiningProcessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	@Override
	public People findByJoiningProcessId_Last(
			long joiningProcessId, OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);

		if (people != null) {
			return people;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchPeopleException(sb.toString());
	}

	/**
	 * Returns the last people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	@Override
	public People fetchByJoiningProcessId_Last(
		long joiningProcessId, OrderByComparator<People> orderByComparator) {

		int count = countByJoiningProcessId(joiningProcessId);

		if (count == 0) {
			return null;
		}

		List<People> list = findByJoiningProcessId(
			joiningProcessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People[] findByJoiningProcessId_PrevAndNext(
			long peopleId, long joiningProcessId,
			OrderByComparator<People> orderByComparator)
		throws NoSuchPeopleException {

		People people = findByPrimaryKey(peopleId);

		Session session = null;

		try {
			session = openSession();

			People[] array = new PeopleImpl[3];

			array[0] = getByJoiningProcessId_PrevAndNext(
				session, people, joiningProcessId, orderByComparator, true);

			array[1] = people;

			array[2] = getByJoiningProcessId_PrevAndNext(
				session, people, joiningProcessId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected People getByJoiningProcessId_PrevAndNext(
		Session session, People people, long joiningProcessId,
		OrderByComparator<People> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PEOPLE_WHERE);

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
			sb.append(PeopleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(joiningProcessId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(people)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<People> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the peoples where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	@Override
	public void removeByJoiningProcessId(long joiningProcessId) {
		for (People people :
				findByJoiningProcessId(
					joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(people);
		}
	}

	/**
	 * Returns the number of peoples where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching peoples
	 */
	@Override
	public int countByJoiningProcessId(long joiningProcessId) {
		FinderPath finderPath = _finderPathCountByJoiningProcessId;

		Object[] finderArgs = new Object[] {joiningProcessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PEOPLE_WHERE);

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
			"people.joiningProcessId = ?";

	public PeoplePersistenceImpl() {
		setModelClass(People.class);

		setModelImplClass(PeopleImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the people in the entity cache if it is enabled.
	 *
	 * @param people the people
	 */
	@Override
	public void cacheResult(People people) {
		entityCache.putResult(PeopleImpl.class, people.getPrimaryKey(), people);
	}

	/**
	 * Caches the peoples in the entity cache if it is enabled.
	 *
	 * @param peoples the peoples
	 */
	@Override
	public void cacheResult(List<People> peoples) {
		for (People people : peoples) {
			if (entityCache.getResult(
					PeopleImpl.class, people.getPrimaryKey()) == null) {

				cacheResult(people);
			}
		}
	}

	/**
	 * Clears the cache for all peoples.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PeopleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the people.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(People people) {
		entityCache.removeResult(PeopleImpl.class, people);
	}

	@Override
	public void clearCache(List<People> peoples) {
		for (People people : peoples) {
			entityCache.removeResult(PeopleImpl.class, people);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PeopleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new people with the primary key. Does not add the people to the database.
	 *
	 * @param peopleId the primary key for the new people
	 * @return the new people
	 */
	@Override
	public People create(long peopleId) {
		People people = new PeopleImpl();

		people.setNew(true);
		people.setPrimaryKey(peopleId);

		people.setCompanyId(CompanyThreadLocal.getCompanyId());

		return people;
	}

	/**
	 * Removes the people with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people that was removed
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People remove(long peopleId) throws NoSuchPeopleException {
		return remove((Serializable)peopleId);
	}

	/**
	 * Removes the people with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the people
	 * @return the people that was removed
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People remove(Serializable primaryKey) throws NoSuchPeopleException {
		Session session = null;

		try {
			session = openSession();

			People people = (People)session.get(PeopleImpl.class, primaryKey);

			if (people == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPeopleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(people);
		}
		catch (NoSuchPeopleException noSuchEntityException) {
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
	protected People removeImpl(People people) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(people)) {
				people = (People)session.get(
					PeopleImpl.class, people.getPrimaryKeyObj());
			}

			if (people != null) {
				session.delete(people);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (people != null) {
			clearCache(people);
		}

		return people;
	}

	@Override
	public People updateImpl(People people) {
		boolean isNew = people.isNew();

		if (!(people instanceof PeopleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(people.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(people);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in people proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom People implementation " +
					people.getClass());
		}

		PeopleModelImpl peopleModelImpl = (PeopleModelImpl)people;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (people.getCreateDate() == null)) {
			if (serviceContext == null) {
				people.setCreateDate(now);
			}
			else {
				people.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!peopleModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				people.setModifiedDate(now);
			}
			else {
				people.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(people);
			}
			else {
				people = (People)session.merge(people);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PeopleImpl.class, peopleModelImpl, false, true);

		if (isNew) {
			people.setNew(false);
		}

		people.resetOriginalValues();

		return people;
	}

	/**
	 * Returns the people with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the people
	 * @return the people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPeopleException {

		People people = fetchByPrimaryKey(primaryKey);

		if (people == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPeopleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return people;
	}

	/**
	 * Returns the people with the primary key or throws a <code>NoSuchPeopleException</code> if it could not be found.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	@Override
	public People findByPrimaryKey(long peopleId) throws NoSuchPeopleException {
		return findByPrimaryKey((Serializable)peopleId);
	}

	/**
	 * Returns the people with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people, or <code>null</code> if a people with the primary key could not be found
	 */
	@Override
	public People fetchByPrimaryKey(long peopleId) {
		return fetchByPrimaryKey((Serializable)peopleId);
	}

	/**
	 * Returns all the peoples.
	 *
	 * @return the peoples
	 */
	@Override
	public List<People> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the peoples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of peoples
	 */
	@Override
	public List<People> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the peoples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of peoples
	 */
	@Override
	public List<People> findAll(
		int start, int end, OrderByComparator<People> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the peoples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of peoples
	 */
	@Override
	public List<People> findAll(
		int start, int end, OrderByComparator<People> orderByComparator,
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

		List<People> list = null;

		if (useFinderCache) {
			list = (List<People>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PEOPLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PEOPLE;

				sql = sql.concat(PeopleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<People>)QueryUtil.list(
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
	 * Removes all the peoples from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (People people : findAll()) {
			remove(people);
		}
	}

	/**
	 * Returns the number of peoples.
	 *
	 * @return the number of peoples
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PEOPLE);

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
		return "peopleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PEOPLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PeopleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the people persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PeopleModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", People.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByDateOfBirth = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDateOfBirth",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"dateOfBirth"}, true);

		_finderPathWithoutPaginationFindByDateOfBirth = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDateOfBirth",
			new String[] {Date.class.getName()}, new String[] {"dateOfBirth"},
			true);

		_finderPathCountByDateOfBirth = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDateOfBirth",
			new String[] {Date.class.getName()}, new String[] {"dateOfBirth"},
			false);

		_finderPathWithPaginationFindByAppellationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppellationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"appellationId"}, true);

		_finderPathWithoutPaginationFindByAppellationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppellationId",
			new String[] {Long.class.getName()}, new String[] {"appellationId"},
			true);

		_finderPathCountByAppellationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppellationId",
			new String[] {Long.class.getName()}, new String[] {"appellationId"},
			false);

		_finderPathWithPaginationFindByGenderId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGenderId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"genderId"}, true);

		_finderPathWithoutPaginationFindByGenderId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGenderId",
			new String[] {Long.class.getName()}, new String[] {"genderId"},
			true);

		_finderPathCountByGenderId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGenderId",
			new String[] {Long.class.getName()}, new String[] {"genderId"},
			false);

		_finderPathWithPaginationFindByMaritalStatusId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMaritalStatusId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"maritalStatusId"}, true);

		_finderPathWithoutPaginationFindByMaritalStatusId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMaritalStatusId",
			new String[] {Long.class.getName()},
			new String[] {"maritalStatusId"}, true);

		_finderPathCountByMaritalStatusId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaritalStatusId",
			new String[] {Long.class.getName()},
			new String[] {"maritalStatusId"}, false);

		_finderPathWithPaginationFindByCasteCategoryId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCasteCategoryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"casteCategoryId"}, true);

		_finderPathWithoutPaginationFindByCasteCategoryId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCasteCategoryId",
			new String[] {Long.class.getName()},
			new String[] {"casteCategoryId"}, true);

		_finderPathCountByCasteCategoryId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCasteCategoryId",
			new String[] {Long.class.getName()},
			new String[] {"casteCategoryId"}, false);

		_finderPathWithPaginationFindByBloodGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBloodGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"bloodGroupId"}, true);

		_finderPathWithoutPaginationFindByBloodGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBloodGroupId",
			new String[] {Long.class.getName()}, new String[] {"bloodGroupId"},
			true);

		_finderPathCountByBloodGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBloodGroupId",
			new String[] {Long.class.getName()}, new String[] {"bloodGroupId"},
			false);

		_finderPathWithPaginationFindByCitizenshipId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCitizenshipId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"citizenshipId"}, true);

		_finderPathWithoutPaginationFindByCitizenshipId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCitizenshipId",
			new String[] {Long.class.getName()}, new String[] {"citizenshipId"},
			true);

		_finderPathCountByCitizenshipId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCitizenshipId",
			new String[] {Long.class.getName()}, new String[] {"citizenshipId"},
			false);

		_finderPathWithPaginationFindByPhTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPhTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"phTypeId"}, true);

		_finderPathWithoutPaginationFindByPhTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhTypeId",
			new String[] {Long.class.getName()}, new String[] {"phTypeId"},
			true);

		_finderPathCountByPhTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhTypeId",
			new String[] {Long.class.getName()}, new String[] {"phTypeId"},
			false);

		_finderPathWithPaginationFindByReligionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReligionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"religionId"}, true);

		_finderPathWithoutPaginationFindByReligionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReligionId",
			new String[] {Long.class.getName()}, new String[] {"religionId"},
			true);

		_finderPathCountByReligionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReligionId",
			new String[] {Long.class.getName()}, new String[] {"religionId"},
			false);

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
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PeopleImpl.class.getName());

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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_PEOPLE =
		"SELECT people FROM People people";

	private static final String _SQL_SELECT_PEOPLE_WHERE =
		"SELECT people FROM People people WHERE ";

	private static final String _SQL_COUNT_PEOPLE =
		"SELECT COUNT(people) FROM People people";

	private static final String _SQL_COUNT_PEOPLE_WHERE =
		"SELECT COUNT(people) FROM People people WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "people.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No People exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No People exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PeoplePersistenceImpl.class);

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

	private static class PeopleModelArgumentsResolver
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

			PeopleModelImpl peopleModelImpl = (PeopleModelImpl)baseModel;

			long columnBitmask = peopleModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(peopleModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= peopleModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(peopleModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PeopleModelImpl peopleModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = peopleModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = peopleModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}