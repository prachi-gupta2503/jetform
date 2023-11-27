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

import com.adjecti.mdm.liferay.exception.NoSuchOrganizationDetailException;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.impl.OrganizationDetailImpl;
import com.adjecti.mdm.liferay.model.impl.OrganizationDetailModelImpl;
import com.adjecti.mdm.liferay.service.persistence.OrganizationDetailPersistence;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the organization detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OrganizationDetailPersistence.class)
public class OrganizationDetailPersistenceImpl
	extends BasePersistenceImpl<OrganizationDetail>
	implements OrganizationDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OrganizationDetailUtil</code> to access the organization detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OrganizationDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByShortNameAndType;
	private FinderPath _finderPathWithoutPaginationFindByShortNameAndType;
	private FinderPath _finderPathCountByShortNameAndType;

	/**
	 * Returns all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type) {

		return findByShortNameAndType(
			shortName, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type, int start, int end) {

		return findByShortNameAndType(shortName, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByShortNameAndType(
			shortName, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		shortName = Objects.toString(shortName, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByShortNameAndType;
				finderArgs = new Object[] {shortName, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByShortNameAndType;
			finderArgs = new Object[] {
				shortName, type, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!shortName.equals(organizationDetail.getShortName()) ||
						!type.equals(organizationDetail.getType())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_SHORTNAME_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindShortName) {
					queryPos.add(shortName);
				}

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByShortNameAndType_First(
			String shortName, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByShortNameAndType_First(
			shortName, type, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("shortName=");
		sb.append(shortName);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByShortNameAndType_First(
		String shortName, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByShortNameAndType(
			shortName, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByShortNameAndType_Last(
			String shortName, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByShortNameAndType_Last(
			shortName, type, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("shortName=");
		sb.append(shortName);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByShortNameAndType_Last(
		String shortName, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByShortNameAndType(shortName, type);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByShortNameAndType(
			shortName, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByShortNameAndType_PrevAndNext(
			long organizationDetailId, String shortName, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		shortName = Objects.toString(shortName, "");
		type = Objects.toString(type, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByShortNameAndType_PrevAndNext(
				session, organizationDetail, shortName, type, orderByComparator,
				true);

			array[1] = organizationDetail;

			array[2] = getByShortNameAndType_PrevAndNext(
				session, organizationDetail, shortName, type, orderByComparator,
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

	protected OrganizationDetail getByShortNameAndType_PrevAndNext(
		Session session, OrganizationDetail organizationDetail,
		String shortName, String type,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindShortName = false;

		if (shortName.isEmpty()) {
			sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_SHORTNAME_3);
		}
		else {
			bindShortName = true;

			sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_SHORTNAME_2);
		}

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_TYPE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindShortName) {
			queryPos.add(shortName);
		}

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where shortName = &#63; and type = &#63; from the database.
	 *
	 * @param shortName the short name
	 * @param type the type
	 */
	@Override
	public void removeByShortNameAndType(String shortName, String type) {
		for (OrganizationDetail organizationDetail :
				findByShortNameAndType(
					shortName, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @return the number of matching organization details
	 */
	@Override
	public int countByShortNameAndType(String shortName, String type) {
		shortName = Objects.toString(shortName, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByShortNameAndType;

		Object[] finderArgs = new Object[] {shortName, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_SHORTNAME_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_SHORTNAMEANDTYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindShortName) {
					queryPos.add(shortName);
				}

				if (bindType) {
					queryPos.add(type);
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

	private static final String _FINDER_COLUMN_SHORTNAMEANDTYPE_SHORTNAME_2 =
		"organizationDetail.shortName = ? AND ";

	private static final String _FINDER_COLUMN_SHORTNAMEANDTYPE_SHORTNAME_3 =
		"(organizationDetail.shortName IS NULL OR organizationDetail.shortName = '') AND ";

	private static final String _FINDER_COLUMN_SHORTNAMEANDTYPE_TYPE_2 =
		"organizationDetail.type = ?";

	private static final String _FINDER_COLUMN_SHORTNAMEANDTYPE_TYPE_3 =
		"(organizationDetail.type IS NULL OR organizationDetail.type = '')";

	private FinderPath _finderPathWithPaginationFindByOrganizationCodeAndType;
	private FinderPath
		_finderPathWithoutPaginationFindByOrganizationCodeAndType;
	private FinderPath _finderPathCountByOrganizationCodeAndType;

	/**
	 * Returns all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type) {

		return findByOrganizationCodeAndType(
			organizationCode, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type, int start, int end) {

		return findByOrganizationCodeAndType(
			organizationCode, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByOrganizationCodeAndType(
			organizationCode, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		organizationCode = Objects.toString(organizationCode, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByOrganizationCodeAndType;
				finderArgs = new Object[] {organizationCode, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrganizationCodeAndType;
			finderArgs = new Object[] {
				organizationCode, type, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!organizationCode.equals(
							organizationDetail.getOrganizationCode()) ||
						!type.equals(organizationDetail.getType())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_ORGANIZATIONCODE_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
				}

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByOrganizationCodeAndType_First(
			String organizationCode, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByOrganizationCodeAndType_First(
				organizationCode, type, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationCode=");
		sb.append(organizationCode);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByOrganizationCodeAndType_First(
		String organizationCode, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByOrganizationCodeAndType(
			organizationCode, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByOrganizationCodeAndType_Last(
			String organizationCode, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByOrganizationCodeAndType_Last(
				organizationCode, type, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationCode=");
		sb.append(organizationCode);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByOrganizationCodeAndType_Last(
		String organizationCode, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByOrganizationCodeAndType(organizationCode, type);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByOrganizationCodeAndType(
			organizationCode, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByOrganizationCodeAndType_PrevAndNext(
			long organizationDetailId, String organizationCode, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		organizationCode = Objects.toString(organizationCode, "");
		type = Objects.toString(type, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByOrganizationCodeAndType_PrevAndNext(
				session, organizationDetail, organizationCode, type,
				orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByOrganizationCodeAndType_PrevAndNext(
				session, organizationDetail, organizationCode, type,
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

	protected OrganizationDetail getByOrganizationCodeAndType_PrevAndNext(
		Session session, OrganizationDetail organizationDetail,
		String organizationCode, String type,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindOrganizationCode = false;

		if (organizationCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_ORGANIZATIONCODE_3);
		}
		else {
			bindOrganizationCode = true;

			sb.append(
				_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_ORGANIZATIONCODE_2);
		}

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_TYPE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindOrganizationCode) {
			queryPos.add(organizationCode);
		}

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where organizationCode = &#63; and type = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 */
	@Override
	public void removeByOrganizationCodeAndType(
		String organizationCode, String type) {

		for (OrganizationDetail organizationDetail :
				findByOrganizationCodeAndType(
					organizationCode, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @return the number of matching organization details
	 */
	@Override
	public int countByOrganizationCodeAndType(
		String organizationCode, String type) {

		organizationCode = Objects.toString(organizationCode, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByOrganizationCodeAndType;

		Object[] finderArgs = new Object[] {organizationCode, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_ORGANIZATIONCODE_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
				}

				if (bindType) {
					queryPos.add(type);
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

	private static final String
		_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_ORGANIZATIONCODE_2 =
			"organizationDetail.organizationCode = ? AND ";

	private static final String
		_FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_ORGANIZATIONCODE_3 =
			"(organizationDetail.organizationCode IS NULL OR organizationDetail.organizationCode = '') AND ";

	private static final String _FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_TYPE_2 =
		"organizationDetail.type = ?";

	private static final String _FINDER_COLUMN_ORGANIZATIONCODEANDTYPE_TYPE_3 =
		"(organizationDetail.type IS NULL OR organizationDetail.type = '')";

	private FinderPath _finderPathWithPaginationFindByunitType;
	private FinderPath _finderPathWithoutPaginationFindByunitType;
	private FinderPath _finderPathCountByunitType;

	/**
	 * Returns all the organization details where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByunitType(String unitType) {
		return findByunitType(
			unitType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByunitType(
		String unitType, int start, int end) {

		return findByunitType(unitType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByunitType(
		String unitType, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByunitType(unitType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByunitType(
		String unitType, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		unitType = Objects.toString(unitType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByunitType;
				finderArgs = new Object[] {unitType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByunitType;
			finderArgs = new Object[] {unitType, start, end, orderByComparator};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!unitType.equals(organizationDetail.getUnitType())) {
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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindUnitType = false;

			if (unitType.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNITTYPE_UNITTYPE_3);
			}
			else {
				bindUnitType = true;

				sb.append(_FINDER_COLUMN_UNITTYPE_UNITTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUnitType) {
					queryPos.add(unitType);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByunitType_First(
			String unitType,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByunitType_First(
			unitType, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitType=");
		sb.append(unitType);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByunitType_First(
		String unitType,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByunitType(
			unitType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByunitType_Last(
			String unitType,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByunitType_Last(
			unitType, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitType=");
		sb.append(unitType);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByunitType_Last(
		String unitType,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByunitType(unitType);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByunitType(
			unitType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByunitType_PrevAndNext(
			long organizationDetailId, String unitType,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		unitType = Objects.toString(unitType, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByunitType_PrevAndNext(
				session, organizationDetail, unitType, orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByunitType_PrevAndNext(
				session, organizationDetail, unitType, orderByComparator,
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

	protected OrganizationDetail getByunitType_PrevAndNext(
		Session session, OrganizationDetail organizationDetail, String unitType,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindUnitType = false;

		if (unitType.isEmpty()) {
			sb.append(_FINDER_COLUMN_UNITTYPE_UNITTYPE_3);
		}
		else {
			bindUnitType = true;

			sb.append(_FINDER_COLUMN_UNITTYPE_UNITTYPE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUnitType) {
			queryPos.add(unitType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where unitType = &#63; from the database.
	 *
	 * @param unitType the unit type
	 */
	@Override
	public void removeByunitType(String unitType) {
		for (OrganizationDetail organizationDetail :
				findByunitType(
					unitType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @return the number of matching organization details
	 */
	@Override
	public int countByunitType(String unitType) {
		unitType = Objects.toString(unitType, "");

		FinderPath finderPath = _finderPathCountByunitType;

		Object[] finderArgs = new Object[] {unitType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindUnitType = false;

			if (unitType.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNITTYPE_UNITTYPE_3);
			}
			else {
				bindUnitType = true;

				sb.append(_FINDER_COLUMN_UNITTYPE_UNITTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUnitType) {
					queryPos.add(unitType);
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

	private static final String _FINDER_COLUMN_UNITTYPE_UNITTYPE_2 =
		"organizationDetail.unitType = ?";

	private static final String _FINDER_COLUMN_UNITTYPE_UNITTYPE_3 =
		"(organizationDetail.unitType IS NULL OR organizationDetail.unitType = '')";

	private FinderPath _finderPathWithPaginationFindByParentId;
	private FinderPath _finderPathWithoutPaginationFindByParentId;
	private FinderPath _finderPathCountByParentId;

	/**
	 * Returns all the organization details where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentId(long parentId) {
		return findByParentId(
			parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentId(
		long parentId, int start, int end) {

		return findByParentId(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentId(
		long parentId, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByParentId(parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentId(
		long parentId, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParentId;
				finderArgs = new Object[] {parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentId;
			finderArgs = new Object[] {parentId, start, end, orderByComparator};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (parentId != organizationDetail.getParentId()) {
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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentId_First(
			long parentId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByParentId_First(
			parentId, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentId_First(
		long parentId,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByParentId(
			parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentId_Last(
			long parentId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByParentId_Last(
			parentId, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentId_Last(
		long parentId,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByParentId(parentId);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByParentId(
			parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByParentId_PrevAndNext(
			long organizationDetailId, long parentId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByParentId_PrevAndNext(
				session, organizationDetail, parentId, orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByParentId_PrevAndNext(
				session, organizationDetail, parentId, orderByComparator,
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

	protected OrganizationDetail getByParentId_PrevAndNext(
		Session session, OrganizationDetail organizationDetail, long parentId,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		sb.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByParentId(long parentId) {
		for (OrganizationDetail organizationDetail :
				findByParentId(
					parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching organization details
	 */
	@Override
	public int countByParentId(long parentId) {
		FinderPath finderPath = _finderPathCountByParentId;

		Object[] finderArgs = new Object[] {parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

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

	private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 =
		"organizationDetail.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByParentIdAndType;
	private FinderPath _finderPathWithoutPaginationFindByParentIdAndType;
	private FinderPath _finderPathCountByParentIdAndType;

	/**
	 * Returns all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type) {

		return findByParentIdAndType(
			parentId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type, int start, int end) {

		return findByParentIdAndType(parentId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByParentIdAndType(
			parentId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParentIdAndType;
				finderArgs = new Object[] {parentId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentIdAndType;
			finderArgs = new Object[] {
				parentId, type, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if ((parentId != organizationDetail.getParentId()) ||
						!type.equals(organizationDetail.getType())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_PARENTIDANDTYPE_PARENTID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTIDANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_PARENTIDANDTYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				if (bindType) {
					queryPos.add(StringUtil.toLowerCase(type));
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentIdAndType_First(
			long parentId, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByParentIdAndType_First(
			parentId, type, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentIdAndType_First(
		long parentId, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByParentIdAndType(
			parentId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentIdAndType_Last(
			long parentId, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByParentIdAndType_Last(
			parentId, type, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentIdAndType_Last(
		long parentId, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByParentIdAndType(parentId, type);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByParentIdAndType(
			parentId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByParentIdAndType_PrevAndNext(
			long organizationDetailId, long parentId, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		type = Objects.toString(type, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByParentIdAndType_PrevAndNext(
				session, organizationDetail, parentId, type, orderByComparator,
				true);

			array[1] = organizationDetail;

			array[2] = getByParentIdAndType_PrevAndNext(
				session, organizationDetail, parentId, type, orderByComparator,
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

	protected OrganizationDetail getByParentIdAndType_PrevAndNext(
		Session session, OrganizationDetail organizationDetail, long parentId,
		String type, OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		sb.append(_FINDER_COLUMN_PARENTIDANDTYPE_PARENTID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_PARENTIDANDTYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_PARENTIDANDTYPE_TYPE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentId);

		if (bindType) {
			queryPos.add(StringUtil.toLowerCase(type));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where parentId = &#63; and type = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 */
	@Override
	public void removeByParentIdAndType(long parentId, String type) {
		for (OrganizationDetail organizationDetail :
				findByParentIdAndType(
					parentId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the number of matching organization details
	 */
	@Override
	public int countByParentIdAndType(long parentId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByParentIdAndType;

		Object[] finderArgs = new Object[] {parentId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_PARENTIDANDTYPE_PARENTID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTIDANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_PARENTIDANDTYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				if (bindType) {
					queryPos.add(StringUtil.toLowerCase(type));
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

	private static final String _FINDER_COLUMN_PARENTIDANDTYPE_PARENTID_2 =
		"organizationDetail.parentId = ? AND ";

	private static final String _FINDER_COLUMN_PARENTIDANDTYPE_TYPE_2 =
		"lower(organizationDetail.type) = ?";

	private static final String _FINDER_COLUMN_PARENTIDANDTYPE_TYPE_3 =
		"(organizationDetail.type IS NULL OR organizationDetail.type = '')";

	private FinderPath
		_finderPathWithPaginationFindByTypeAndParentIdAndOrganizationCode;
	private FinderPath
		_finderPathWithoutPaginationFindByTypeAndParentIdAndOrganizationCode;
	private FinderPath _finderPathCountByTypeAndParentIdAndOrganizationCode;

	/**
	 * Returns all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndParentIdAndOrganizationCode(
		String type, long parentId, String organizationCode) {

		return findByTypeAndParentIdAndOrganizationCode(
			type, parentId, organizationCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndParentIdAndOrganizationCode(
		String type, long parentId, String organizationCode, int start,
		int end) {

		return findByTypeAndParentIdAndOrganizationCode(
			type, parentId, organizationCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndParentIdAndOrganizationCode(
		String type, long parentId, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByTypeAndParentIdAndOrganizationCode(
			type, parentId, organizationCode, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndParentIdAndOrganizationCode(
		String type, long parentId, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");
		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTypeAndParentIdAndOrganizationCode;
				finderArgs = new Object[] {type, parentId, organizationCode};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTypeAndParentIdAndOrganizationCode;
			finderArgs = new Object[] {
				type, parentId, organizationCode, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!type.equals(organizationDetail.getType()) ||
						(parentId != organizationDetail.getParentId()) ||
						!organizationCode.equals(
							organizationDetail.getOrganizationCode())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_TYPE_2);
			}

			sb.append(
				_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_PARENTID_2);

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(StringUtil.toLowerCase(type));
				}

				queryPos.add(parentId);

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByTypeAndParentIdAndOrganizationCode_First(
			String type, long parentId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByTypeAndParentIdAndOrganizationCode_First(
				type, parentId, organizationCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append(", organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByTypeAndParentIdAndOrganizationCode_First(
		String type, long parentId, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list =
			findByTypeAndParentIdAndOrganizationCode(
				type, parentId, organizationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByTypeAndParentIdAndOrganizationCode_Last(
			String type, long parentId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByTypeAndParentIdAndOrganizationCode_Last(
				type, parentId, organizationCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append(", organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByTypeAndParentIdAndOrganizationCode_Last(
		String type, long parentId, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByTypeAndParentIdAndOrganizationCode(
			type, parentId, organizationCode);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list =
			findByTypeAndParentIdAndOrganizationCode(
				type, parentId, organizationCode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[]
			findByTypeAndParentIdAndOrganizationCode_PrevAndNext(
				long organizationDetailId, String type, long parentId,
				String organizationCode,
				OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		type = Objects.toString(type, "");
		organizationCode = Objects.toString(organizationCode, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByTypeAndParentIdAndOrganizationCode_PrevAndNext(
				session, organizationDetail, type, parentId, organizationCode,
				orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByTypeAndParentIdAndOrganizationCode_PrevAndNext(
				session, organizationDetail, type, parentId, organizationCode,
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

	protected OrganizationDetail
		getByTypeAndParentIdAndOrganizationCode_PrevAndNext(
			Session session, OrganizationDetail organizationDetail, String type,
			long parentId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_TYPE_2);
		}

		sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_PARENTID_2);

		boolean bindOrganizationCode = false;

		if (organizationCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
		}
		else {
			bindOrganizationCode = true;

			sb.append(
				_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(StringUtil.toLowerCase(type));
		}

		queryPos.add(parentId);

		if (bindOrganizationCode) {
			queryPos.add(organizationCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 */
	@Override
	public void removeByTypeAndParentIdAndOrganizationCode(
		String type, long parentId, String organizationCode) {

		for (OrganizationDetail organizationDetail :
				findByTypeAndParentIdAndOrganizationCode(
					type, parentId, organizationCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	@Override
	public int countByTypeAndParentIdAndOrganizationCode(
		String type, long parentId, String organizationCode) {

		type = Objects.toString(type, "");
		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath =
			_finderPathCountByTypeAndParentIdAndOrganizationCode;

		Object[] finderArgs = new Object[] {type, parentId, organizationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_TYPE_2);
			}

			sb.append(
				_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_PARENTID_2);

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(StringUtil.toLowerCase(type));
				}

				queryPos.add(parentId);

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
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

	private static final String
		_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_TYPE_2 =
			"lower(organizationDetail.type) = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_TYPE_3 =
			"(organizationDetail.type IS NULL OR organizationDetail.type = '') AND ";

	private static final String
		_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_PARENTID_2 =
			"organizationDetail.parentId = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_2 =
			"organizationDetail.organizationCode = ?";

	private static final String
		_FINDER_COLUMN_TYPEANDPARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_3 =
			"(organizationDetail.organizationCode IS NULL OR organizationDetail.organizationCode = '')";

	private FinderPath
		_finderPathWithPaginationFindByTypeAndParentIdAndShortName;
	private FinderPath
		_finderPathWithoutPaginationFindByTypeAndParentIdAndShortName;
	private FinderPath _finderPathCountByTypeAndParentIdAndShortName;

	/**
	 * Returns all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName) {

		return findByTypeAndParentIdAndShortName(
			type, parentId, shortName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName, int start, int end) {

		return findByTypeAndParentIdAndShortName(
			type, parentId, shortName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByTypeAndParentIdAndShortName(
			type, parentId, shortName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");
		shortName = Objects.toString(shortName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTypeAndParentIdAndShortName;
				finderArgs = new Object[] {type, parentId, shortName};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTypeAndParentIdAndShortName;
			finderArgs = new Object[] {
				type, parentId, shortName, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!type.equals(organizationDetail.getType()) ||
						(parentId != organizationDetail.getParentId()) ||
						!shortName.equals(organizationDetail.getShortName())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_TYPE_2);
			}

			sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_PARENTID_2);

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_SHORTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(StringUtil.toLowerCase(type));
				}

				queryPos.add(parentId);

				if (bindShortName) {
					queryPos.add(shortName);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByTypeAndParentIdAndShortName_First(
			String type, long parentId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByTypeAndParentIdAndShortName_First(
				type, parentId, shortName, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append(", shortName=");
		sb.append(shortName);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByTypeAndParentIdAndShortName_First(
		String type, long parentId, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByTypeAndParentIdAndShortName(
			type, parentId, shortName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByTypeAndParentIdAndShortName_Last(
			String type, long parentId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByTypeAndParentIdAndShortName_Last(
				type, parentId, shortName, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append(", shortName=");
		sb.append(shortName);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByTypeAndParentIdAndShortName_Last(
		String type, long parentId, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByTypeAndParentIdAndShortName(
			type, parentId, shortName);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByTypeAndParentIdAndShortName(
			type, parentId, shortName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByTypeAndParentIdAndShortName_PrevAndNext(
			long organizationDetailId, String type, long parentId,
			String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		type = Objects.toString(type, "");
		shortName = Objects.toString(shortName, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByTypeAndParentIdAndShortName_PrevAndNext(
				session, organizationDetail, type, parentId, shortName,
				orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByTypeAndParentIdAndShortName_PrevAndNext(
				session, organizationDetail, type, parentId, shortName,
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

	protected OrganizationDetail getByTypeAndParentIdAndShortName_PrevAndNext(
		Session session, OrganizationDetail organizationDetail, String type,
		long parentId, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_TYPE_2);
		}

		sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_PARENTID_2);

		boolean bindShortName = false;

		if (shortName.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_SHORTNAME_3);
		}
		else {
			bindShortName = true;

			sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_SHORTNAME_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(StringUtil.toLowerCase(type));
		}

		queryPos.add(parentId);

		if (bindShortName) {
			queryPos.add(shortName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where type = &#63; and parentId = &#63; and shortName = &#63; from the database.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 */
	@Override
	public void removeByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName) {

		for (OrganizationDetail organizationDetail :
				findByTypeAndParentIdAndShortName(
					type, parentId, shortName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	@Override
	public int countByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName) {

		type = Objects.toString(type, "");
		shortName = Objects.toString(shortName, "");

		FinderPath finderPath = _finderPathCountByTypeAndParentIdAndShortName;

		Object[] finderArgs = new Object[] {type, parentId, shortName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_TYPE_2);
			}

			sb.append(_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_PARENTID_2);

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(
					_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_SHORTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(StringUtil.toLowerCase(type));
				}

				queryPos.add(parentId);

				if (bindShortName) {
					queryPos.add(shortName);
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

	private static final String
		_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_TYPE_2 =
			"lower(organizationDetail.type) = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_TYPE_3 =
			"(organizationDetail.type IS NULL OR organizationDetail.type = '') AND ";

	private static final String
		_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_PARENTID_2 =
			"organizationDetail.parentId = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_SHORTNAME_2 =
			"organizationDetail.shortName = ?";

	private static final String
		_FINDER_COLUMN_TYPEANDPARENTIDANDSHORTNAME_SHORTNAME_3 =
			"(organizationDetail.shortName IS NULL OR organizationDetail.shortName = '')";

	private FinderPath _finderPathWithPaginationFindByParentCode;
	private FinderPath _finderPathWithoutPaginationFindByParentCode;
	private FinderPath _finderPathCountByParentCode;

	/**
	 * Returns all the organization details where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCode(String parentCode) {
		return findByParentCode(
			parentCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where parentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCode(
		String parentCode, int start, int end) {

		return findByParentCode(parentCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCode(
		String parentCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByParentCode(
			parentCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCode(
		String parentCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		parentCode = Objects.toString(parentCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParentCode;
				finderArgs = new Object[] {parentCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentCode;
			finderArgs = new Object[] {
				parentCode, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!parentCode.equals(
							organizationDetail.getParentCode())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindParentCode = false;

			if (parentCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTCODE_PARENTCODE_3);
			}
			else {
				bindParentCode = true;

				sb.append(_FINDER_COLUMN_PARENTCODE_PARENTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParentCode) {
					queryPos.add(parentCode);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentCode_First(
			String parentCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByParentCode_First(
			parentCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCode=");
		sb.append(parentCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentCode_First(
		String parentCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByParentCode(
			parentCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentCode_Last(
			String parentCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByParentCode_Last(
			parentCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCode=");
		sb.append(parentCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentCode_Last(
		String parentCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByParentCode(parentCode);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByParentCode(
			parentCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByParentCode_PrevAndNext(
			long organizationDetailId, String parentCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		parentCode = Objects.toString(parentCode, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByParentCode_PrevAndNext(
				session, organizationDetail, parentCode, orderByComparator,
				true);

			array[1] = organizationDetail;

			array[2] = getByParentCode_PrevAndNext(
				session, organizationDetail, parentCode, orderByComparator,
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

	protected OrganizationDetail getByParentCode_PrevAndNext(
		Session session, OrganizationDetail organizationDetail,
		String parentCode,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindParentCode = false;

		if (parentCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_PARENTCODE_PARENTCODE_3);
		}
		else {
			bindParentCode = true;

			sb.append(_FINDER_COLUMN_PARENTCODE_PARENTCODE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindParentCode) {
			queryPos.add(parentCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where parentCode = &#63; from the database.
	 *
	 * @param parentCode the parent code
	 */
	@Override
	public void removeByParentCode(String parentCode) {
		for (OrganizationDetail organizationDetail :
				findByParentCode(
					parentCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @return the number of matching organization details
	 */
	@Override
	public int countByParentCode(String parentCode) {
		parentCode = Objects.toString(parentCode, "");

		FinderPath finderPath = _finderPathCountByParentCode;

		Object[] finderArgs = new Object[] {parentCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindParentCode = false;

			if (parentCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTCODE_PARENTCODE_3);
			}
			else {
				bindParentCode = true;

				sb.append(_FINDER_COLUMN_PARENTCODE_PARENTCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParentCode) {
					queryPos.add(parentCode);
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

	private static final String _FINDER_COLUMN_PARENTCODE_PARENTCODE_2 =
		"organizationDetail.parentCode = ?";

	private static final String _FINDER_COLUMN_PARENTCODE_PARENTCODE_3 =
		"(organizationDetail.parentCode IS NULL OR organizationDetail.parentCode = '')";

	private FinderPath _finderPathFetchByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns the organization detail where organizationId = &#63; or throws a <code>NoSuchOrganizationDetailException</code> if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByOrganizationId(long organizationId)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByOrganizationId(
			organizationId);

		if (organizationDetail == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("organizationId=");
			sb.append(organizationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchOrganizationDetailException(sb.toString());
		}

		return organizationDetail;
	}

	/**
	 * Returns the organization detail where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByOrganizationId(long organizationId) {
		return fetchByOrganizationId(organizationId, true);
	}

	/**
	 * Returns the organization detail where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByOrganizationId(
		long organizationId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {organizationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByOrganizationId, finderArgs, this);
		}

		if (result instanceof OrganizationDetail) {
			OrganizationDetail organizationDetail = (OrganizationDetail)result;

			if (organizationId != organizationDetail.getOrganizationId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				List<OrganizationDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByOrganizationId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {organizationId};
							}

							_log.warn(
								"OrganizationDetailPersistenceImpl.fetchByOrganizationId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					OrganizationDetail organizationDetail = list.get(0);

					result = organizationDetail;

					cacheResult(organizationDetail);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (OrganizationDetail)result;
		}
	}

	/**
	 * Removes the organization detail where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @return the organization detail that was removed
	 */
	@Override
	public OrganizationDetail removeByOrganizationId(long organizationId)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = findByOrganizationId(
			organizationId);

		return remove(organizationDetail);
	}

	/**
	 * Returns the number of organization details where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organization details
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

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
		"organizationDetail.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationCode;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationCode;
	private FinderPath _finderPathCountByOrganizationCode;

	/**
	 * Returns all the organization details where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByOrganizationCode(
		String organizationCode) {

		return findByOrganizationCode(
			organizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByOrganizationCode(
		String organizationCode, int start, int end) {

		return findByOrganizationCode(organizationCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByOrganizationCode(
			organizationCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrganizationCode;
				finderArgs = new Object[] {organizationCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrganizationCode;
			finderArgs = new Object[] {
				organizationCode, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!organizationCode.equals(
							organizationDetail.getOrganizationCode())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByOrganizationCode_First(
			String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByOrganizationCode_First(
			organizationCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByOrganizationCode_First(
		String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByOrganizationCode(
			organizationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByOrganizationCode_Last(
			String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByOrganizationCode_Last(
			organizationCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByOrganizationCode_Last(
		String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByOrganizationCode(organizationCode);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByOrganizationCode(
			organizationCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByOrganizationCode_PrevAndNext(
			long organizationDetailId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		organizationCode = Objects.toString(organizationCode, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByOrganizationCode_PrevAndNext(
				session, organizationDetail, organizationCode,
				orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByOrganizationCode_PrevAndNext(
				session, organizationDetail, organizationCode,
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

	protected OrganizationDetail getByOrganizationCode_PrevAndNext(
		Session session, OrganizationDetail organizationDetail,
		String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindOrganizationCode = false;

		if (organizationCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_3);
		}
		else {
			bindOrganizationCode = true;

			sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindOrganizationCode) {
			queryPos.add(organizationCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where organizationCode = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 */
	@Override
	public void removeByOrganizationCode(String organizationCode) {
		for (OrganizationDetail organizationDetail :
				findByOrganizationCode(
					organizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	@Override
	public int countByOrganizationCode(String organizationCode) {
		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = _finderPathCountByOrganizationCode;

		Object[] finderArgs = new Object[] {organizationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
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

	private static final String
		_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_2 =
			"organizationDetail.organizationCode = ?";

	private static final String
		_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_3 =
			"(organizationDetail.organizationCode IS NULL OR organizationDetail.organizationCode = '')";

	private FinderPath
		_finderPathWithPaginationFindByParentCodeAndOrganizationCode;
	private FinderPath
		_finderPathWithoutPaginationFindByParentCodeAndOrganizationCode;
	private FinderPath _finderPathCountByParentCodeAndOrganizationCode;

	/**
	 * Returns all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode) {

		return findByParentCodeAndOrganizationCode(
			parentCode, organizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode, int start, int end) {

		return findByParentCodeAndOrganizationCode(
			parentCode, organizationCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByParentCodeAndOrganizationCode(
			parentCode, organizationCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		parentCode = Objects.toString(parentCode, "");
		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByParentCodeAndOrganizationCode;
				finderArgs = new Object[] {parentCode, organizationCode};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByParentCodeAndOrganizationCode;
			finderArgs = new Object[] {
				parentCode, organizationCode, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!parentCode.equals(
							organizationDetail.getParentCode()) ||
						!organizationCode.equals(
							organizationDetail.getOrganizationCode())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindParentCode = false;

			if (parentCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_PARENTCODE_3);
			}
			else {
				bindParentCode = true;

				sb.append(
					_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_PARENTCODE_2);
			}

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParentCode) {
					queryPos.add(parentCode);
				}

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentCodeAndOrganizationCode_First(
			String parentCode, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByParentCodeAndOrganizationCode_First(
				parentCode, organizationCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCode=");
		sb.append(parentCode);

		sb.append(", organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentCodeAndOrganizationCode_First(
		String parentCode, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByParentCodeAndOrganizationCode(
			parentCode, organizationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentCodeAndOrganizationCode_Last(
			String parentCode, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByParentCodeAndOrganizationCode_Last(
				parentCode, organizationCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCode=");
		sb.append(parentCode);

		sb.append(", organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentCodeAndOrganizationCode_Last(
		String parentCode, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByParentCodeAndOrganizationCode(
			parentCode, organizationCode);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByParentCodeAndOrganizationCode(
			parentCode, organizationCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByParentCodeAndOrganizationCode_PrevAndNext(
			long organizationDetailId, String parentCode,
			String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		parentCode = Objects.toString(parentCode, "");
		organizationCode = Objects.toString(organizationCode, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByParentCodeAndOrganizationCode_PrevAndNext(
				session, organizationDetail, parentCode, organizationCode,
				orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByParentCodeAndOrganizationCode_PrevAndNext(
				session, organizationDetail, parentCode, organizationCode,
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

	protected OrganizationDetail getByParentCodeAndOrganizationCode_PrevAndNext(
		Session session, OrganizationDetail organizationDetail,
		String parentCode, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindParentCode = false;

		if (parentCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_PARENTCODE_3);
		}
		else {
			bindParentCode = true;

			sb.append(
				_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_PARENTCODE_2);
		}

		boolean bindOrganizationCode = false;

		if (organizationCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
		}
		else {
			bindOrganizationCode = true;

			sb.append(
				_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindParentCode) {
			queryPos.add(parentCode);
		}

		if (bindOrganizationCode) {
			queryPos.add(organizationCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where parentCode = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 */
	@Override
	public void removeByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode) {

		for (OrganizationDetail organizationDetail :
				findByParentCodeAndOrganizationCode(
					parentCode, organizationCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	@Override
	public int countByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode) {

		parentCode = Objects.toString(parentCode, "");
		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = _finderPathCountByParentCodeAndOrganizationCode;

		Object[] finderArgs = new Object[] {parentCode, organizationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindParentCode = false;

			if (parentCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_PARENTCODE_3);
			}
			else {
				bindParentCode = true;

				sb.append(
					_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_PARENTCODE_2);
			}

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParentCode) {
					queryPos.add(parentCode);
				}

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
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

	private static final String
		_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_PARENTCODE_2 =
			"organizationDetail.parentCode = ? AND ";

	private static final String
		_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_PARENTCODE_3 =
			"(organizationDetail.parentCode IS NULL OR organizationDetail.parentCode = '') AND ";

	private static final String
		_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_ORGANIZATIONCODE_2 =
			"organizationDetail.organizationCode = ?";

	private static final String
		_FINDER_COLUMN_PARENTCODEANDORGANIZATIONCODE_ORGANIZATIONCODE_3 =
			"(organizationDetail.organizationCode IS NULL OR organizationDetail.organizationCode = '')";

	private FinderPath _finderPathWithPaginationFindByParentCodeAndShortName;
	private FinderPath _finderPathWithoutPaginationFindByParentCodeAndShortName;
	private FinderPath _finderPathCountByParentCodeAndShortName;

	/**
	 * Returns all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName) {

		return findByParentCodeAndShortName(
			parentCode, shortName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName, int start, int end) {

		return findByParentCodeAndShortName(
			parentCode, shortName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByParentCodeAndShortName(
			parentCode, shortName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		parentCode = Objects.toString(parentCode, "");
		shortName = Objects.toString(shortName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByParentCodeAndShortName;
				finderArgs = new Object[] {parentCode, shortName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentCodeAndShortName;
			finderArgs = new Object[] {
				parentCode, shortName, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!parentCode.equals(
							organizationDetail.getParentCode()) ||
						!shortName.equals(organizationDetail.getShortName())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindParentCode = false;

			if (parentCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_PARENTCODE_3);
			}
			else {
				bindParentCode = true;

				sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_PARENTCODE_2);
			}

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_SHORTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParentCode) {
					queryPos.add(parentCode);
				}

				if (bindShortName) {
					queryPos.add(shortName);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentCodeAndShortName_First(
			String parentCode, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByParentCodeAndShortName_First(
				parentCode, shortName, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCode=");
		sb.append(parentCode);

		sb.append(", shortName=");
		sb.append(shortName);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentCodeAndShortName_First(
		String parentCode, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByParentCodeAndShortName(
			parentCode, shortName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentCodeAndShortName_Last(
			String parentCode, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByParentCodeAndShortName_Last(
				parentCode, shortName, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCode=");
		sb.append(parentCode);

		sb.append(", shortName=");
		sb.append(shortName);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentCodeAndShortName_Last(
		String parentCode, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByParentCodeAndShortName(parentCode, shortName);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByParentCodeAndShortName(
			parentCode, shortName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByParentCodeAndShortName_PrevAndNext(
			long organizationDetailId, String parentCode, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		parentCode = Objects.toString(parentCode, "");
		shortName = Objects.toString(shortName, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByParentCodeAndShortName_PrevAndNext(
				session, organizationDetail, parentCode, shortName,
				orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByParentCodeAndShortName_PrevAndNext(
				session, organizationDetail, parentCode, shortName,
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

	protected OrganizationDetail getByParentCodeAndShortName_PrevAndNext(
		Session session, OrganizationDetail organizationDetail,
		String parentCode, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindParentCode = false;

		if (parentCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_PARENTCODE_3);
		}
		else {
			bindParentCode = true;

			sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_PARENTCODE_2);
		}

		boolean bindShortName = false;

		if (shortName.isEmpty()) {
			sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_SHORTNAME_3);
		}
		else {
			bindShortName = true;

			sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_SHORTNAME_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindParentCode) {
			queryPos.add(parentCode);
		}

		if (bindShortName) {
			queryPos.add(shortName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where parentCode = &#63; and shortName = &#63; from the database.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 */
	@Override
	public void removeByParentCodeAndShortName(
		String parentCode, String shortName) {

		for (OrganizationDetail organizationDetail :
				findByParentCodeAndShortName(
					parentCode, shortName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	@Override
	public int countByParentCodeAndShortName(
		String parentCode, String shortName) {

		parentCode = Objects.toString(parentCode, "");
		shortName = Objects.toString(shortName, "");

		FinderPath finderPath = _finderPathCountByParentCodeAndShortName;

		Object[] finderArgs = new Object[] {parentCode, shortName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindParentCode = false;

			if (parentCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_PARENTCODE_3);
			}
			else {
				bindParentCode = true;

				sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_PARENTCODE_2);
			}

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(_FINDER_COLUMN_PARENTCODEANDSHORTNAME_SHORTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParentCode) {
					queryPos.add(parentCode);
				}

				if (bindShortName) {
					queryPos.add(shortName);
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

	private static final String
		_FINDER_COLUMN_PARENTCODEANDSHORTNAME_PARENTCODE_2 =
			"organizationDetail.parentCode = ? AND ";

	private static final String
		_FINDER_COLUMN_PARENTCODEANDSHORTNAME_PARENTCODE_3 =
			"(organizationDetail.parentCode IS NULL OR organizationDetail.parentCode = '') AND ";

	private static final String
		_FINDER_COLUMN_PARENTCODEANDSHORTNAME_SHORTNAME_2 =
			"organizationDetail.shortName = ?";

	private static final String
		_FINDER_COLUMN_PARENTCODEANDSHORTNAME_SHORTNAME_3 =
			"(organizationDetail.shortName IS NULL OR organizationDetail.shortName = '')";

	private FinderPath
		_finderPathWithPaginationFindByParentIdAndOrganizationCode;
	private FinderPath
		_finderPathWithoutPaginationFindByParentIdAndOrganizationCode;
	private FinderPath _finderPathCountByParentIdAndOrganizationCode;

	/**
	 * Returns all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode) {

		return findByParentIdAndOrganizationCode(
			parentId, organizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode, int start, int end) {

		return findByParentIdAndOrganizationCode(
			parentId, organizationCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByParentIdAndOrganizationCode(
			parentId, organizationCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByParentIdAndOrganizationCode;
				finderArgs = new Object[] {parentId, organizationCode};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByParentIdAndOrganizationCode;
			finderArgs = new Object[] {
				parentId, organizationCode, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if ((parentId != organizationDetail.getParentId()) ||
						!organizationCode.equals(
							organizationDetail.getOrganizationCode())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_PARENTID_2);

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentIdAndOrganizationCode_First(
			long parentId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByParentIdAndOrganizationCode_First(
				parentId, organizationCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentIdAndOrganizationCode_First(
		long parentId, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByParentIdAndOrganizationCode(
			parentId, organizationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentIdAndOrganizationCode_Last(
			long parentId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByParentIdAndOrganizationCode_Last(
				parentId, organizationCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentIdAndOrganizationCode_Last(
		long parentId, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByParentIdAndOrganizationCode(
			parentId, organizationCode);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByParentIdAndOrganizationCode(
			parentId, organizationCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByParentIdAndOrganizationCode_PrevAndNext(
			long organizationDetailId, long parentId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		organizationCode = Objects.toString(organizationCode, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByParentIdAndOrganizationCode_PrevAndNext(
				session, organizationDetail, parentId, organizationCode,
				orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByParentIdAndOrganizationCode_PrevAndNext(
				session, organizationDetail, parentId, organizationCode,
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

	protected OrganizationDetail getByParentIdAndOrganizationCode_PrevAndNext(
		Session session, OrganizationDetail organizationDetail, long parentId,
		String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		sb.append(_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_PARENTID_2);

		boolean bindOrganizationCode = false;

		if (organizationCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
		}
		else {
			bindOrganizationCode = true;

			sb.append(
				_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentId);

		if (bindOrganizationCode) {
			queryPos.add(organizationCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where parentId = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 */
	@Override
	public void removeByParentIdAndOrganizationCode(
		long parentId, String organizationCode) {

		for (OrganizationDetail organizationDetail :
				findByParentIdAndOrganizationCode(
					parentId, organizationCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	@Override
	public int countByParentIdAndOrganizationCode(
		long parentId, String organizationCode) {

		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = _finderPathCountByParentIdAndOrganizationCode;

		Object[] finderArgs = new Object[] {parentId, organizationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_PARENTID_2);

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
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

	private static final String
		_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_PARENTID_2 =
			"organizationDetail.parentId = ? AND ";

	private static final String
		_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_2 =
			"organizationDetail.organizationCode = ?";

	private static final String
		_FINDER_COLUMN_PARENTIDANDORGANIZATIONCODE_ORGANIZATIONCODE_3 =
			"(organizationDetail.organizationCode IS NULL OR organizationDetail.organizationCode = '')";

	private FinderPath _finderPathWithPaginationFindByParentIdAndShortName;
	private FinderPath _finderPathWithoutPaginationFindByParentIdAndShortName;
	private FinderPath _finderPathCountByParentIdAndShortName;

	/**
	 * Returns all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName) {

		return findByParentIdAndShortName(
			parentId, shortName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName, int start, int end) {

		return findByParentIdAndShortName(
			parentId, shortName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByParentIdAndShortName(
			parentId, shortName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		shortName = Objects.toString(shortName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByParentIdAndShortName;
				finderArgs = new Object[] {parentId, shortName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentIdAndShortName;
			finderArgs = new Object[] {
				parentId, shortName, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if ((parentId != organizationDetail.getParentId()) ||
						!shortName.equals(organizationDetail.getShortName())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_PARENTIDANDSHORTNAME_PARENTID_2);

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTIDANDSHORTNAME_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(_FINDER_COLUMN_PARENTIDANDSHORTNAME_SHORTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				if (bindShortName) {
					queryPos.add(shortName);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentIdAndShortName_First(
			long parentId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByParentIdAndShortName_First(
				parentId, shortName, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", shortName=");
		sb.append(shortName);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentIdAndShortName_First(
		long parentId, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByParentIdAndShortName(
			parentId, shortName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByParentIdAndShortName_Last(
			long parentId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByParentIdAndShortName_Last(
				parentId, shortName, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append(", shortName=");
		sb.append(shortName);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByParentIdAndShortName_Last(
		long parentId, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByParentIdAndShortName(parentId, shortName);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByParentIdAndShortName(
			parentId, shortName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByParentIdAndShortName_PrevAndNext(
			long organizationDetailId, long parentId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		shortName = Objects.toString(shortName, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByParentIdAndShortName_PrevAndNext(
				session, organizationDetail, parentId, shortName,
				orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByParentIdAndShortName_PrevAndNext(
				session, organizationDetail, parentId, shortName,
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

	protected OrganizationDetail getByParentIdAndShortName_PrevAndNext(
		Session session, OrganizationDetail organizationDetail, long parentId,
		String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		sb.append(_FINDER_COLUMN_PARENTIDANDSHORTNAME_PARENTID_2);

		boolean bindShortName = false;

		if (shortName.isEmpty()) {
			sb.append(_FINDER_COLUMN_PARENTIDANDSHORTNAME_SHORTNAME_3);
		}
		else {
			bindShortName = true;

			sb.append(_FINDER_COLUMN_PARENTIDANDSHORTNAME_SHORTNAME_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentId);

		if (bindShortName) {
			queryPos.add(shortName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where parentId = &#63; and shortName = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 */
	@Override
	public void removeByParentIdAndShortName(long parentId, String shortName) {
		for (OrganizationDetail organizationDetail :
				findByParentIdAndShortName(
					parentId, shortName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	@Override
	public int countByParentIdAndShortName(long parentId, String shortName) {
		shortName = Objects.toString(shortName, "");

		FinderPath finderPath = _finderPathCountByParentIdAndShortName;

		Object[] finderArgs = new Object[] {parentId, shortName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_PARENTIDANDSHORTNAME_PARENTID_2);

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTIDANDSHORTNAME_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(_FINDER_COLUMN_PARENTIDANDSHORTNAME_SHORTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				if (bindShortName) {
					queryPos.add(shortName);
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

	private static final String _FINDER_COLUMN_PARENTIDANDSHORTNAME_PARENTID_2 =
		"organizationDetail.parentId = ? AND ";

	private static final String
		_FINDER_COLUMN_PARENTIDANDSHORTNAME_SHORTNAME_2 =
			"organizationDetail.shortName = ?";

	private static final String
		_FINDER_COLUMN_PARENTIDANDSHORTNAME_SHORTNAME_3 =
			"(organizationDetail.shortName IS NULL OR organizationDetail.shortName = '')";

	private FinderPath _finderPathWithPaginationFindByShortName;
	private FinderPath _finderPathWithoutPaginationFindByShortName;
	private FinderPath _finderPathCountByShortName;

	/**
	 * Returns all the organization details where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByShortName(String shortName) {
		return findByShortName(
			shortName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByShortName(
		String shortName, int start, int end) {

		return findByShortName(shortName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByShortName(
		String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByShortName(shortName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByShortName(
		String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		shortName = Objects.toString(shortName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByShortName;
				finderArgs = new Object[] {shortName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByShortName;
			finderArgs = new Object[] {
				shortName, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!shortName.equals(organizationDetail.getShortName())) {
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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SHORTNAME_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(_FINDER_COLUMN_SHORTNAME_SHORTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindShortName) {
					queryPos.add(shortName);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByShortName_First(
			String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByShortName_First(
			shortName, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("shortName=");
		sb.append(shortName);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByShortName_First(
		String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByShortName(
			shortName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByShortName_Last(
			String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByShortName_Last(
			shortName, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("shortName=");
		sb.append(shortName);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByShortName_Last(
		String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByShortName(shortName);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByShortName(
			shortName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByShortName_PrevAndNext(
			long organizationDetailId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		shortName = Objects.toString(shortName, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByShortName_PrevAndNext(
				session, organizationDetail, shortName, orderByComparator,
				true);

			array[1] = organizationDetail;

			array[2] = getByShortName_PrevAndNext(
				session, organizationDetail, shortName, orderByComparator,
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

	protected OrganizationDetail getByShortName_PrevAndNext(
		Session session, OrganizationDetail organizationDetail,
		String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindShortName = false;

		if (shortName.isEmpty()) {
			sb.append(_FINDER_COLUMN_SHORTNAME_SHORTNAME_3);
		}
		else {
			bindShortName = true;

			sb.append(_FINDER_COLUMN_SHORTNAME_SHORTNAME_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindShortName) {
			queryPos.add(shortName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where shortName = &#63; from the database.
	 *
	 * @param shortName the short name
	 */
	@Override
	public void removeByShortName(String shortName) {
		for (OrganizationDetail organizationDetail :
				findByShortName(
					shortName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	@Override
	public int countByShortName(String shortName) {
		shortName = Objects.toString(shortName, "");

		FinderPath finderPath = _finderPathCountByShortName;

		Object[] finderArgs = new Object[] {shortName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SHORTNAME_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(_FINDER_COLUMN_SHORTNAME_SHORTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindShortName) {
					queryPos.add(shortName);
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

	private static final String _FINDER_COLUMN_SHORTNAME_SHORTNAME_2 =
		"organizationDetail.shortName = ?";

	private static final String _FINDER_COLUMN_SHORTNAME_SHORTNAME_3 =
		"(organizationDetail.shortName IS NULL OR organizationDetail.shortName = '')";

	private FinderPath _finderPathWithPaginationFindByType;
	private FinderPath _finderPathWithoutPaginationFindByType;
	private FinderPath _finderPathCountByType;

	/**
	 * Returns all the organization details where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByType(String type) {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByType(
		String type, int start, int end) {

		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByType(
		String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByType(type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByType(
		String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType;
				finderArgs = new Object[] {type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!type.equals(organizationDetail.getType())) {
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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByType_First(
			String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByType_First(
			type, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByType_First(
		String type, OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByType(
			type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByType_Last(
			String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByType_Last(
			type, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByType_Last(
		String type, OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByType(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByType_PrevAndNext(
			long organizationDetailId, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		type = Objects.toString(type, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByType_PrevAndNext(
				session, organizationDetail, type, orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByType_PrevAndNext(
				session, organizationDetail, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrganizationDetail getByType_PrevAndNext(
		Session session, OrganizationDetail organizationDetail, String type,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByType(String type) {
		for (OrganizationDetail organizationDetail :
				findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching organization details
	 */
	@Override
	public int countByType(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByType;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
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

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 =
		"organizationDetail.type = ?";

	private static final String _FINDER_COLUMN_TYPE_TYPE_3 =
		"(organizationDetail.type IS NULL OR organizationDetail.type = '')";

	private FinderPath _finderPathWithPaginationFindByTypeAndOrganizationCode;
	private FinderPath
		_finderPathWithoutPaginationFindByTypeAndOrganizationCode;
	private FinderPath _finderPathCountByTypeAndOrganizationCode;

	/**
	 * Returns all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode) {

		return findByTypeAndOrganizationCode(
			type, organizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode, int start, int end) {

		return findByTypeAndOrganizationCode(
			type, organizationCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByTypeAndOrganizationCode(
			type, organizationCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");
		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTypeAndOrganizationCode;
				finderArgs = new Object[] {type, organizationCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTypeAndOrganizationCode;
			finderArgs = new Object[] {
				type, organizationCode, start, end, orderByComparator
			};
		}

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (!type.equals(organizationDetail.getType()) ||
						!organizationCode.equals(
							organizationDetail.getOrganizationCode())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_TYPE_2);
			}

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
				}

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByTypeAndOrganizationCode_First(
			String type, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByTypeAndOrganizationCode_First(
				type, organizationCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByTypeAndOrganizationCode_First(
		String type, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByTypeAndOrganizationCode(
			type, organizationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByTypeAndOrganizationCode_Last(
			String type, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail =
			fetchByTypeAndOrganizationCode_Last(
				type, organizationCode, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByTypeAndOrganizationCode_Last(
		String type, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByTypeAndOrganizationCode(type, organizationCode);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByTypeAndOrganizationCode(
			type, organizationCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByTypeAndOrganizationCode_PrevAndNext(
			long organizationDetailId, String type, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		type = Objects.toString(type, "");
		organizationCode = Objects.toString(organizationCode, "");

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByTypeAndOrganizationCode_PrevAndNext(
				session, organizationDetail, type, organizationCode,
				orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByTypeAndOrganizationCode_PrevAndNext(
				session, organizationDetail, type, organizationCode,
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

	protected OrganizationDetail getByTypeAndOrganizationCode_PrevAndNext(
		Session session, OrganizationDetail organizationDetail, String type,
		String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_TYPE_2);
		}

		boolean bindOrganizationCode = false;

		if (organizationCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
		}
		else {
			bindOrganizationCode = true;

			sb.append(
				_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		if (bindOrganizationCode) {
			queryPos.add(organizationCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where type = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 */
	@Override
	public void removeByTypeAndOrganizationCode(
		String type, String organizationCode) {

		for (OrganizationDetail organizationDetail :
				findByTypeAndOrganizationCode(
					type, organizationCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	@Override
	public int countByTypeAndOrganizationCode(
		String type, String organizationCode) {

		type = Objects.toString(type, "");
		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = _finderPathCountByTypeAndOrganizationCode;

		Object[] finderArgs = new Object[] {type, organizationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_TYPE_2);
			}

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
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

	private static final String _FINDER_COLUMN_TYPEANDORGANIZATIONCODE_TYPE_2 =
		"organizationDetail.type = ? AND ";

	private static final String _FINDER_COLUMN_TYPEANDORGANIZATIONCODE_TYPE_3 =
		"(organizationDetail.type IS NULL OR organizationDetail.type = '') AND ";

	private static final String
		_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_ORGANIZATIONCODE_2 =
			"organizationDetail.organizationCode = ?";

	private static final String
		_FINDER_COLUMN_TYPEANDORGANIZATIONCODE_ORGANIZATIONCODE_3 =
			"(organizationDetail.organizationCode IS NULL OR organizationDetail.organizationCode = '')";

	private FinderPath _finderPathWithPaginationFindByStateId;
	private FinderPath _finderPathWithoutPaginationFindByStateId;
	private FinderPath _finderPathCountByStateId;

	/**
	 * Returns all the organization details where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByStateId(long stateId) {
		return findByStateId(
			stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByStateId(
		long stateId, int start, int end) {

		return findByStateId(stateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findByStateId(stateId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	@Override
	public List<OrganizationDetail> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

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

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationDetail organizationDetail : list) {
					if (stateId != organizationDetail.getStateId()) {
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

			sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_STATEID_STATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Returns the first organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByStateId_First(
			long stateId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByStateId_First(
			stateId, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateId=");
		sb.append(stateId);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the first organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByStateId_First(
		long stateId, OrderByComparator<OrganizationDetail> orderByComparator) {

		List<OrganizationDetail> list = findByStateId(
			stateId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail findByStateId_Last(
			long stateId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByStateId_Last(
			stateId, orderByComparator);

		if (organizationDetail != null) {
			return organizationDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateId=");
		sb.append(stateId);

		sb.append("}");

		throw new NoSuchOrganizationDetailException(sb.toString());
	}

	/**
	 * Returns the last organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	@Override
	public OrganizationDetail fetchByStateId_Last(
		long stateId, OrderByComparator<OrganizationDetail> orderByComparator) {

		int count = countByStateId(stateId);

		if (count == 0) {
			return null;
		}

		List<OrganizationDetail> list = findByStateId(
			stateId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail[] findByStateId_PrevAndNext(
			long organizationDetailId, long stateId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = findByPrimaryKey(
			organizationDetailId);

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail[] array = new OrganizationDetailImpl[3];

			array[0] = getByStateId_PrevAndNext(
				session, organizationDetail, stateId, orderByComparator, true);

			array[1] = organizationDetail;

			array[2] = getByStateId_PrevAndNext(
				session, organizationDetail, stateId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrganizationDetail getByStateId_PrevAndNext(
		Session session, OrganizationDetail organizationDetail, long stateId,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONDETAIL_WHERE);

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
			sb.append(OrganizationDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(stateId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization details where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	@Override
	public void removeByStateId(long stateId) {
		for (OrganizationDetail organizationDetail :
				findByStateId(
					stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching organization details
	 */
	@Override
	public int countByStateId(long stateId) {
		FinderPath finderPath = _finderPathCountByStateId;

		Object[] finderArgs = new Object[] {stateId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONDETAIL_WHERE);

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
		"organizationDetail.stateId = ?";

	public OrganizationDetailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(OrganizationDetail.class);

		setModelImplClass(OrganizationDetailImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the organization detail in the entity cache if it is enabled.
	 *
	 * @param organizationDetail the organization detail
	 */
	@Override
	public void cacheResult(OrganizationDetail organizationDetail) {
		entityCache.putResult(
			OrganizationDetailImpl.class, organizationDetail.getPrimaryKey(),
			organizationDetail);

		finderCache.putResult(
			_finderPathFetchByOrganizationId,
			new Object[] {organizationDetail.getOrganizationId()},
			organizationDetail);
	}

	/**
	 * Caches the organization details in the entity cache if it is enabled.
	 *
	 * @param organizationDetails the organization details
	 */
	@Override
	public void cacheResult(List<OrganizationDetail> organizationDetails) {
		for (OrganizationDetail organizationDetail : organizationDetails) {
			if (entityCache.getResult(
					OrganizationDetailImpl.class,
					organizationDetail.getPrimaryKey()) == null) {

				cacheResult(organizationDetail);
			}
		}
	}

	/**
	 * Clears the cache for all organization details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OrganizationDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganizationDetail organizationDetail) {
		entityCache.removeResult(
			OrganizationDetailImpl.class, organizationDetail);
	}

	@Override
	public void clearCache(List<OrganizationDetail> organizationDetails) {
		for (OrganizationDetail organizationDetail : organizationDetails) {
			entityCache.removeResult(
				OrganizationDetailImpl.class, organizationDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OrganizationDetailImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		OrganizationDetailModelImpl organizationDetailModelImpl) {

		Object[] args = new Object[] {
			organizationDetailModelImpl.getOrganizationId()
		};

		finderCache.putResult(
			_finderPathCountByOrganizationId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByOrganizationId, args, organizationDetailModelImpl,
			false);
	}

	/**
	 * Creates a new organization detail with the primary key. Does not add the organization detail to the database.
	 *
	 * @param organizationDetailId the primary key for the new organization detail
	 * @return the new organization detail
	 */
	@Override
	public OrganizationDetail create(long organizationDetailId) {
		OrganizationDetail organizationDetail = new OrganizationDetailImpl();

		organizationDetail.setNew(true);
		organizationDetail.setPrimaryKey(organizationDetailId);

		organizationDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return organizationDetail;
	}

	/**
	 * Removes the organization detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail that was removed
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail remove(long organizationDetailId)
		throws NoSuchOrganizationDetailException {

		return remove((Serializable)organizationDetailId);
	}

	/**
	 * Removes the organization detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization detail
	 * @return the organization detail that was removed
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail remove(Serializable primaryKey)
		throws NoSuchOrganizationDetailException {

		Session session = null;

		try {
			session = openSession();

			OrganizationDetail organizationDetail =
				(OrganizationDetail)session.get(
					OrganizationDetailImpl.class, primaryKey);

			if (organizationDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(organizationDetail);
		}
		catch (NoSuchOrganizationDetailException noSuchEntityException) {
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
	protected OrganizationDetail removeImpl(
		OrganizationDetail organizationDetail) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organizationDetail)) {
				organizationDetail = (OrganizationDetail)session.get(
					OrganizationDetailImpl.class,
					organizationDetail.getPrimaryKeyObj());
			}

			if (organizationDetail != null) {
				session.delete(organizationDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (organizationDetail != null) {
			clearCache(organizationDetail);
		}

		return organizationDetail;
	}

	@Override
	public OrganizationDetail updateImpl(
		OrganizationDetail organizationDetail) {

		boolean isNew = organizationDetail.isNew();

		if (!(organizationDetail instanceof OrganizationDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(organizationDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					organizationDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in organizationDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OrganizationDetail implementation " +
					organizationDetail.getClass());
		}

		OrganizationDetailModelImpl organizationDetailModelImpl =
			(OrganizationDetailModelImpl)organizationDetail;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (organizationDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				organizationDetail.setCreateDate(now);
			}
			else {
				organizationDetail.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!organizationDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				organizationDetail.setModifiedDate(now);
			}
			else {
				organizationDetail.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(organizationDetail);
			}
			else {
				organizationDetail = (OrganizationDetail)session.merge(
					organizationDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OrganizationDetailImpl.class, organizationDetailModelImpl, false,
			true);

		cacheUniqueFindersCache(organizationDetailModelImpl);

		if (isNew) {
			organizationDetail.setNew(false);
		}

		organizationDetail.resetOriginalValues();

		return organizationDetail;
	}

	/**
	 * Returns the organization detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization detail
	 * @return the organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationDetailException {

		OrganizationDetail organizationDetail = fetchByPrimaryKey(primaryKey);

		if (organizationDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return organizationDetail;
	}

	/**
	 * Returns the organization detail with the primary key or throws a <code>NoSuchOrganizationDetailException</code> if it could not be found.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail findByPrimaryKey(long organizationDetailId)
		throws NoSuchOrganizationDetailException {

		return findByPrimaryKey((Serializable)organizationDetailId);
	}

	/**
	 * Returns the organization detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail, or <code>null</code> if a organization detail with the primary key could not be found
	 */
	@Override
	public OrganizationDetail fetchByPrimaryKey(long organizationDetailId) {
		return fetchByPrimaryKey((Serializable)organizationDetailId);
	}

	/**
	 * Returns all the organization details.
	 *
	 * @return the organization details
	 */
	@Override
	public List<OrganizationDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of organization details
	 */
	@Override
	public List<OrganizationDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization details
	 */
	@Override
	public List<OrganizationDetail> findAll(
		int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization details
	 */
	@Override
	public List<OrganizationDetail> findAll(
		int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
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

		List<OrganizationDetail> list = null;

		if (useFinderCache) {
			list = (List<OrganizationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ORGANIZATIONDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONDETAIL;

				sql = sql.concat(OrganizationDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OrganizationDetail>)QueryUtil.list(
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
	 * Removes all the organization details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OrganizationDetail organizationDetail : findAll()) {
			remove(organizationDetail);
		}
	}

	/**
	 * Returns the number of organization details.
	 *
	 * @return the number of organization details
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
					_SQL_COUNT_ORGANIZATIONDETAIL);

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
		return "organizationDetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ORGANIZATIONDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OrganizationDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the organization detail persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new OrganizationDetailModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", OrganizationDetail.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByShortNameAndType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByShortNameAndType",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"shortName", "type_"}, true);

		_finderPathWithoutPaginationFindByShortNameAndType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByShortNameAndType",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"shortName", "type_"}, true);

		_finderPathCountByShortNameAndType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByShortNameAndType",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"shortName", "type_"}, false);

		_finderPathWithPaginationFindByOrganizationCodeAndType =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByOrganizationCodeAndType",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"organizationCode", "type_"}, true);

		_finderPathWithoutPaginationFindByOrganizationCodeAndType =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByOrganizationCodeAndType",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"organizationCode", "type_"}, true);

		_finderPathCountByOrganizationCodeAndType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationCodeAndType",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"organizationCode", "type_"}, false);

		_finderPathWithPaginationFindByunitType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByunitType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"unitType"}, true);

		_finderPathWithoutPaginationFindByunitType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByunitType",
			new String[] {String.class.getName()}, new String[] {"unitType"},
			true);

		_finderPathCountByunitType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByunitType",
			new String[] {String.class.getName()}, new String[] {"unitType"},
			false);

		_finderPathWithPaginationFindByParentId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parentId"}, true);

		_finderPathWithoutPaginationFindByParentId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] {Long.class.getName()}, new String[] {"parentId"},
			true);

		_finderPathCountByParentId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] {Long.class.getName()}, new String[] {"parentId"},
			false);

		_finderPathWithPaginationFindByParentIdAndType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentIdAndType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"parentId", "type_"}, true);

		_finderPathWithoutPaginationFindByParentIdAndType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentIdAndType",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"parentId", "type_"}, true);

		_finderPathCountByParentIdAndType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentIdAndType",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"parentId", "type_"}, false);

		_finderPathWithPaginationFindByTypeAndParentIdAndOrganizationCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTypeAndParentIdAndOrganizationCode",
				new String[] {
					String.class.getName(), Long.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"type_", "parentId", "organizationCode"}, true);

		_finderPathWithoutPaginationFindByTypeAndParentIdAndOrganizationCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTypeAndParentIdAndOrganizationCode",
				new String[] {
					String.class.getName(), Long.class.getName(),
					String.class.getName()
				},
				new String[] {"type_", "parentId", "organizationCode"}, true);

		_finderPathCountByTypeAndParentIdAndOrganizationCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByTypeAndParentIdAndOrganizationCode",
				new String[] {
					String.class.getName(), Long.class.getName(),
					String.class.getName()
				},
				new String[] {"type_", "parentId", "organizationCode"}, false);

		_finderPathWithPaginationFindByTypeAndParentIdAndShortName =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTypeAndParentIdAndShortName",
				new String[] {
					String.class.getName(), Long.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"type_", "parentId", "shortName"}, true);

		_finderPathWithoutPaginationFindByTypeAndParentIdAndShortName =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTypeAndParentIdAndShortName",
				new String[] {
					String.class.getName(), Long.class.getName(),
					String.class.getName()
				},
				new String[] {"type_", "parentId", "shortName"}, true);

		_finderPathCountByTypeAndParentIdAndShortName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypeAndParentIdAndShortName",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"type_", "parentId", "shortName"}, false);

		_finderPathWithPaginationFindByParentCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parentCode"}, true);

		_finderPathWithoutPaginationFindByParentCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentCode",
			new String[] {String.class.getName()}, new String[] {"parentCode"},
			true);

		_finderPathCountByParentCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentCode",
			new String[] {String.class.getName()}, new String[] {"parentCode"},
			false);

		_finderPathFetchByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"organizationId"}, true);

		_finderPathCountByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"organizationId"}, false);

		_finderPathWithPaginationFindByOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"organizationCode"}, true);

		_finderPathWithoutPaginationFindByOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationCode",
			new String[] {String.class.getName()},
			new String[] {"organizationCode"}, true);

		_finderPathCountByOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationCode", new String[] {String.class.getName()},
			new String[] {"organizationCode"}, false);

		_finderPathWithPaginationFindByParentCodeAndOrganizationCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByParentCodeAndOrganizationCode",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"parentCode", "organizationCode"}, true);

		_finderPathWithoutPaginationFindByParentCodeAndOrganizationCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByParentCodeAndOrganizationCode",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"parentCode", "organizationCode"}, true);

		_finderPathCountByParentCodeAndOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentCodeAndOrganizationCode",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"parentCode", "organizationCode"}, false);

		_finderPathWithPaginationFindByParentCodeAndShortName =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByParentCodeAndShortName",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"parentCode", "shortName"}, true);

		_finderPathWithoutPaginationFindByParentCodeAndShortName =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByParentCodeAndShortName",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"parentCode", "shortName"}, true);

		_finderPathCountByParentCodeAndShortName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentCodeAndShortName",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"parentCode", "shortName"}, false);

		_finderPathWithPaginationFindByParentIdAndOrganizationCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByParentIdAndOrganizationCode",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"parentId", "organizationCode"}, true);

		_finderPathWithoutPaginationFindByParentIdAndOrganizationCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByParentIdAndOrganizationCode",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"parentId", "organizationCode"}, true);

		_finderPathCountByParentIdAndOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentIdAndOrganizationCode",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"parentId", "organizationCode"}, false);

		_finderPathWithPaginationFindByParentIdAndShortName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentIdAndShortName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"parentId", "shortName"}, true);

		_finderPathWithoutPaginationFindByParentIdAndShortName =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByParentIdAndShortName",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"parentId", "shortName"}, true);

		_finderPathCountByParentIdAndShortName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentIdAndShortName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"parentId", "shortName"}, false);

		_finderPathWithPaginationFindByShortName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByShortName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"shortName"}, true);

		_finderPathWithoutPaginationFindByShortName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByShortName",
			new String[] {String.class.getName()}, new String[] {"shortName"},
			true);

		_finderPathCountByShortName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByShortName",
			new String[] {String.class.getName()}, new String[] {"shortName"},
			false);

		_finderPathWithPaginationFindByType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"type_"}, true);

		_finderPathWithoutPaginationFindByType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] {String.class.getName()}, new String[] {"type_"},
			true);

		_finderPathCountByType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] {String.class.getName()}, new String[] {"type_"},
			false);

		_finderPathWithPaginationFindByTypeAndOrganizationCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTypeAndOrganizationCode",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"type_", "organizationCode"}, true);

		_finderPathWithoutPaginationFindByTypeAndOrganizationCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTypeAndOrganizationCode",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"type_", "organizationCode"}, true);

		_finderPathCountByTypeAndOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypeAndOrganizationCode",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"type_", "organizationCode"}, false);

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
		entityCache.removeCache(OrganizationDetailImpl.class.getName());

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

	private static final String _SQL_SELECT_ORGANIZATIONDETAIL =
		"SELECT organizationDetail FROM OrganizationDetail organizationDetail";

	private static final String _SQL_SELECT_ORGANIZATIONDETAIL_WHERE =
		"SELECT organizationDetail FROM OrganizationDetail organizationDetail WHERE ";

	private static final String _SQL_COUNT_ORGANIZATIONDETAIL =
		"SELECT COUNT(organizationDetail) FROM OrganizationDetail organizationDetail";

	private static final String _SQL_COUNT_ORGANIZATIONDETAIL_WHERE =
		"SELECT COUNT(organizationDetail) FROM OrganizationDetail organizationDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "organizationDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OrganizationDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OrganizationDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OrganizationDetailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

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

	private static class OrganizationDetailModelArgumentsResolver
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

			OrganizationDetailModelImpl organizationDetailModelImpl =
				(OrganizationDetailModelImpl)baseModel;

			long columnBitmask = organizationDetailModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					organizationDetailModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						organizationDetailModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					organizationDetailModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			OrganizationDetailModelImpl organizationDetailModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						organizationDetailModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = organizationDetailModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}