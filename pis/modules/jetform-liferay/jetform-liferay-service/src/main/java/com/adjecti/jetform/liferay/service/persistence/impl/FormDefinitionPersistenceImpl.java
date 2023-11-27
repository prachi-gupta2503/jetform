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

import com.adjecti.jetform.liferay.exception.NoSuchFormDefinitionException;
import com.adjecti.jetform.liferay.model.FormDefinition;
import com.adjecti.jetform.liferay.model.impl.FormDefinitionImpl;
import com.adjecti.jetform.liferay.model.impl.FormDefinitionModelImpl;
import com.adjecti.jetform.liferay.service.persistence.FormDefinitionPersistence;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

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
 * The persistence implementation for the form definition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FormDefinitionPersistence.class)
public class FormDefinitionPersistenceImpl
	extends BasePersistenceImpl<FormDefinition>
	implements FormDefinitionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FormDefinitionUtil</code> to access the form definition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FormDefinitionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the form definitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching form definitions
	 */
	@Override
	public List<FormDefinition> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form definitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of matching form definitions
	 */
	@Override
	public List<FormDefinition> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form definitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form definitions
	 */
	@Override
	public List<FormDefinition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form definitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form definitions
	 */
	@Override
	public List<FormDefinition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<FormDefinition> list = null;

		if (useFinderCache) {
			list = (List<FormDefinition>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormDefinition formDefinition : list) {
					if (!uuid.equals(formDefinition.getUuid())) {
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

			sb.append(_SQL_SELECT_FORMDEFINITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FormDefinitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<FormDefinition>)QueryUtil.list(
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
	 * Returns the first form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	@Override
	public FormDefinition findByUuid_First(
			String uuid, OrderByComparator<FormDefinition> orderByComparator)
		throws NoSuchFormDefinitionException {

		FormDefinition formDefinition = fetchByUuid_First(
			uuid, orderByComparator);

		if (formDefinition != null) {
			return formDefinition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFormDefinitionException(sb.toString());
	}

	/**
	 * Returns the first form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public FormDefinition fetchByUuid_First(
		String uuid, OrderByComparator<FormDefinition> orderByComparator) {

		List<FormDefinition> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	@Override
	public FormDefinition findByUuid_Last(
			String uuid, OrderByComparator<FormDefinition> orderByComparator)
		throws NoSuchFormDefinitionException {

		FormDefinition formDefinition = fetchByUuid_Last(
			uuid, orderByComparator);

		if (formDefinition != null) {
			return formDefinition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFormDefinitionException(sb.toString());
	}

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public FormDefinition fetchByUuid_Last(
		String uuid, OrderByComparator<FormDefinition> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FormDefinition> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form definitions before and after the current form definition in the ordered set where uuid = &#63;.
	 *
	 * @param formDefinitionId the primary key of the current form definition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	@Override
	public FormDefinition[] findByUuid_PrevAndNext(
			long formDefinitionId, String uuid,
			OrderByComparator<FormDefinition> orderByComparator)
		throws NoSuchFormDefinitionException {

		uuid = Objects.toString(uuid, "");

		FormDefinition formDefinition = findByPrimaryKey(formDefinitionId);

		Session session = null;

		try {
			session = openSession();

			FormDefinition[] array = new FormDefinitionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, formDefinition, uuid, orderByComparator, true);

			array[1] = formDefinition;

			array[2] = getByUuid_PrevAndNext(
				session, formDefinition, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FormDefinition getByUuid_PrevAndNext(
		Session session, FormDefinition formDefinition, String uuid,
		OrderByComparator<FormDefinition> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FORMDEFINITION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
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
			sb.append(FormDefinitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						formDefinition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormDefinition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form definitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FormDefinition formDefinition :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(formDefinition);
		}
	}

	/**
	 * Returns the number of form definitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching form definitions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FORMDEFINITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"formDefinition.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(formDefinition.uuid IS NULL OR formDefinition.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the form definition where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormDefinitionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	@Override
	public FormDefinition findByUUID_G(String uuid, long groupId)
		throws NoSuchFormDefinitionException {

		FormDefinition formDefinition = fetchByUUID_G(uuid, groupId);

		if (formDefinition == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFormDefinitionException(sb.toString());
		}

		return formDefinition;
	}

	/**
	 * Returns the form definition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public FormDefinition fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the form definition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public FormDefinition fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof FormDefinition) {
			FormDefinition formDefinition = (FormDefinition)result;

			if (!Objects.equals(uuid, formDefinition.getUuid()) ||
				(groupId != formDefinition.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FORMDEFINITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<FormDefinition> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FormDefinition formDefinition = list.get(0);

					result = formDefinition;

					cacheResult(formDefinition);
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
			return (FormDefinition)result;
		}
	}

	/**
	 * Removes the form definition where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the form definition that was removed
	 */
	@Override
	public FormDefinition removeByUUID_G(String uuid, long groupId)
		throws NoSuchFormDefinitionException {

		FormDefinition formDefinition = findByUUID_G(uuid, groupId);

		return remove(formDefinition);
	}

	/**
	 * Returns the number of form definitions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching form definitions
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMDEFINITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"formDefinition.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(formDefinition.uuid IS NULL OR formDefinition.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"formDefinition.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching form definitions
	 */
	@Override
	public List<FormDefinition> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of matching form definitions
	 */
	@Override
	public List<FormDefinition> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form definitions
	 */
	@Override
	public List<FormDefinition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form definitions
	 */
	@Override
	public List<FormDefinition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<FormDefinition> list = null;

		if (useFinderCache) {
			list = (List<FormDefinition>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormDefinition formDefinition : list) {
					if (!uuid.equals(formDefinition.getUuid()) ||
						(companyId != formDefinition.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FORMDEFINITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FormDefinitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<FormDefinition>)QueryUtil.list(
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
	 * Returns the first form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	@Override
	public FormDefinition findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FormDefinition> orderByComparator)
		throws NoSuchFormDefinitionException {

		FormDefinition formDefinition = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (formDefinition != null) {
			return formDefinition;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFormDefinitionException(sb.toString());
	}

	/**
	 * Returns the first form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public FormDefinition fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FormDefinition> orderByComparator) {

		List<FormDefinition> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	@Override
	public FormDefinition findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FormDefinition> orderByComparator)
		throws NoSuchFormDefinitionException {

		FormDefinition formDefinition = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (formDefinition != null) {
			return formDefinition;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFormDefinitionException(sb.toString());
	}

	/**
	 * Returns the last form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public FormDefinition fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FormDefinition> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FormDefinition> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form definitions before and after the current form definition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param formDefinitionId the primary key of the current form definition
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	@Override
	public FormDefinition[] findByUuid_C_PrevAndNext(
			long formDefinitionId, String uuid, long companyId,
			OrderByComparator<FormDefinition> orderByComparator)
		throws NoSuchFormDefinitionException {

		uuid = Objects.toString(uuid, "");

		FormDefinition formDefinition = findByPrimaryKey(formDefinitionId);

		Session session = null;

		try {
			session = openSession();

			FormDefinition[] array = new FormDefinitionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, formDefinition, uuid, companyId, orderByComparator,
				true);

			array[1] = formDefinition;

			array[2] = getByUuid_C_PrevAndNext(
				session, formDefinition, uuid, companyId, orderByComparator,
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

	protected FormDefinition getByUuid_C_PrevAndNext(
		Session session, FormDefinition formDefinition, String uuid,
		long companyId, OrderByComparator<FormDefinition> orderByComparator,
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

		sb.append(_SQL_SELECT_FORMDEFINITION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(FormDefinitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						formDefinition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormDefinition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form definitions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FormDefinition formDefinition :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(formDefinition);
		}
	}

	/**
	 * Returns the number of form definitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching form definitions
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMDEFINITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"formDefinition.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(formDefinition.uuid IS NULL OR formDefinition.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"formDefinition.companyId = ?";

	private FinderPath _finderPathFetchByFormClass;
	private FinderPath _finderPathCountByFormClass;

	/**
	 * Returns the form definition where formClass = &#63; or throws a <code>NoSuchFormDefinitionException</code> if it could not be found.
	 *
	 * @param formClass the form class
	 * @return the matching form definition
	 * @throws NoSuchFormDefinitionException if a matching form definition could not be found
	 */
	@Override
	public FormDefinition findByFormClass(String formClass)
		throws NoSuchFormDefinitionException {

		FormDefinition formDefinition = fetchByFormClass(formClass);

		if (formDefinition == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("formClass=");
			sb.append(formClass);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFormDefinitionException(sb.toString());
		}

		return formDefinition;
	}

	/**
	 * Returns the form definition where formClass = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param formClass the form class
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public FormDefinition fetchByFormClass(String formClass) {
		return fetchByFormClass(formClass, true);
	}

	/**
	 * Returns the form definition where formClass = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param formClass the form class
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public FormDefinition fetchByFormClass(
		String formClass, boolean useFinderCache) {

		formClass = Objects.toString(formClass, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {formClass};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFormClass, finderArgs, this);
		}

		if (result instanceof FormDefinition) {
			FormDefinition formDefinition = (FormDefinition)result;

			if (!Objects.equals(formClass, formDefinition.getFormClass())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FORMDEFINITION_WHERE);

			boolean bindFormClass = false;

			if (formClass.isEmpty()) {
				sb.append(_FINDER_COLUMN_FORMCLASS_FORMCLASS_3);
			}
			else {
				bindFormClass = true;

				sb.append(_FINDER_COLUMN_FORMCLASS_FORMCLASS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFormClass) {
					queryPos.add(formClass);
				}

				List<FormDefinition> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFormClass, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {formClass};
							}

							_log.warn(
								"FormDefinitionPersistenceImpl.fetchByFormClass(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FormDefinition formDefinition = list.get(0);

					result = formDefinition;

					cacheResult(formDefinition);
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
			return (FormDefinition)result;
		}
	}

	/**
	 * Removes the form definition where formClass = &#63; from the database.
	 *
	 * @param formClass the form class
	 * @return the form definition that was removed
	 */
	@Override
	public FormDefinition removeByFormClass(String formClass)
		throws NoSuchFormDefinitionException {

		FormDefinition formDefinition = findByFormClass(formClass);

		return remove(formDefinition);
	}

	/**
	 * Returns the number of form definitions where formClass = &#63;.
	 *
	 * @param formClass the form class
	 * @return the number of matching form definitions
	 */
	@Override
	public int countByFormClass(String formClass) {
		formClass = Objects.toString(formClass, "");

		FinderPath finderPath = _finderPathCountByFormClass;

		Object[] finderArgs = new Object[] {formClass};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FORMDEFINITION_WHERE);

			boolean bindFormClass = false;

			if (formClass.isEmpty()) {
				sb.append(_FINDER_COLUMN_FORMCLASS_FORMCLASS_3);
			}
			else {
				bindFormClass = true;

				sb.append(_FINDER_COLUMN_FORMCLASS_FORMCLASS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFormClass) {
					queryPos.add(formClass);
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

	private static final String _FINDER_COLUMN_FORMCLASS_FORMCLASS_2 =
		"formDefinition.formClass = ?";

	private static final String _FINDER_COLUMN_FORMCLASS_FORMCLASS_3 =
		"(formDefinition.formClass IS NULL OR formDefinition.formClass = '')";

	public FormDefinitionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FormDefinition.class);

		setModelImplClass(FormDefinitionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the form definition in the entity cache if it is enabled.
	 *
	 * @param formDefinition the form definition
	 */
	@Override
	public void cacheResult(FormDefinition formDefinition) {
		entityCache.putResult(
			FormDefinitionImpl.class, formDefinition.getPrimaryKey(),
			formDefinition);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				formDefinition.getUuid(), formDefinition.getGroupId()
			},
			formDefinition);

		finderCache.putResult(
			_finderPathFetchByFormClass,
			new Object[] {formDefinition.getFormClass()}, formDefinition);
	}

	/**
	 * Caches the form definitions in the entity cache if it is enabled.
	 *
	 * @param formDefinitions the form definitions
	 */
	@Override
	public void cacheResult(List<FormDefinition> formDefinitions) {
		for (FormDefinition formDefinition : formDefinitions) {
			if (entityCache.getResult(
					FormDefinitionImpl.class, formDefinition.getPrimaryKey()) ==
						null) {

				cacheResult(formDefinition);
			}
		}
	}

	/**
	 * Clears the cache for all form definitions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FormDefinitionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the form definition.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FormDefinition formDefinition) {
		entityCache.removeResult(FormDefinitionImpl.class, formDefinition);
	}

	@Override
	public void clearCache(List<FormDefinition> formDefinitions) {
		for (FormDefinition formDefinition : formDefinitions) {
			entityCache.removeResult(FormDefinitionImpl.class, formDefinition);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FormDefinitionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FormDefinitionModelImpl formDefinitionModelImpl) {

		Object[] args = new Object[] {
			formDefinitionModelImpl.getUuid(),
			formDefinitionModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, formDefinitionModelImpl, false);

		args = new Object[] {formDefinitionModelImpl.getFormClass()};

		finderCache.putResult(
			_finderPathCountByFormClass, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByFormClass, args, formDefinitionModelImpl, false);
	}

	/**
	 * Creates a new form definition with the primary key. Does not add the form definition to the database.
	 *
	 * @param formDefinitionId the primary key for the new form definition
	 * @return the new form definition
	 */
	@Override
	public FormDefinition create(long formDefinitionId) {
		FormDefinition formDefinition = new FormDefinitionImpl();

		formDefinition.setNew(true);
		formDefinition.setPrimaryKey(formDefinitionId);

		String uuid = PortalUUIDUtil.generate();

		formDefinition.setUuid(uuid);

		formDefinition.setCompanyId(CompanyThreadLocal.getCompanyId());

		return formDefinition;
	}

	/**
	 * Removes the form definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition that was removed
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	@Override
	public FormDefinition remove(long formDefinitionId)
		throws NoSuchFormDefinitionException {

		return remove((Serializable)formDefinitionId);
	}

	/**
	 * Removes the form definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the form definition
	 * @return the form definition that was removed
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	@Override
	public FormDefinition remove(Serializable primaryKey)
		throws NoSuchFormDefinitionException {

		Session session = null;

		try {
			session = openSession();

			FormDefinition formDefinition = (FormDefinition)session.get(
				FormDefinitionImpl.class, primaryKey);

			if (formDefinition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormDefinitionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(formDefinition);
		}
		catch (NoSuchFormDefinitionException noSuchEntityException) {
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
	protected FormDefinition removeImpl(FormDefinition formDefinition) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(formDefinition)) {
				formDefinition = (FormDefinition)session.get(
					FormDefinitionImpl.class,
					formDefinition.getPrimaryKeyObj());
			}

			if (formDefinition != null) {
				session.delete(formDefinition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (formDefinition != null) {
			clearCache(formDefinition);
		}

		return formDefinition;
	}

	@Override
	public FormDefinition updateImpl(FormDefinition formDefinition) {
		boolean isNew = formDefinition.isNew();

		if (!(formDefinition instanceof FormDefinitionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(formDefinition.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					formDefinition);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in formDefinition proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FormDefinition implementation " +
					formDefinition.getClass());
		}

		FormDefinitionModelImpl formDefinitionModelImpl =
			(FormDefinitionModelImpl)formDefinition;

		if (Validator.isNull(formDefinition.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			formDefinition.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (formDefinition.getCreateDate() == null)) {
			if (serviceContext == null) {
				formDefinition.setCreateDate(now);
			}
			else {
				formDefinition.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!formDefinitionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				formDefinition.setModifiedDate(now);
			}
			else {
				formDefinition.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(formDefinition);
			}
			else {
				formDefinition = (FormDefinition)session.merge(formDefinition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FormDefinitionImpl.class, formDefinitionModelImpl, false, true);

		cacheUniqueFindersCache(formDefinitionModelImpl);

		if (isNew) {
			formDefinition.setNew(false);
		}

		formDefinition.resetOriginalValues();

		return formDefinition;
	}

	/**
	 * Returns the form definition with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the form definition
	 * @return the form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	@Override
	public FormDefinition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormDefinitionException {

		FormDefinition formDefinition = fetchByPrimaryKey(primaryKey);

		if (formDefinition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormDefinitionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return formDefinition;
	}

	/**
	 * Returns the form definition with the primary key or throws a <code>NoSuchFormDefinitionException</code> if it could not be found.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition
	 * @throws NoSuchFormDefinitionException if a form definition with the primary key could not be found
	 */
	@Override
	public FormDefinition findByPrimaryKey(long formDefinitionId)
		throws NoSuchFormDefinitionException {

		return findByPrimaryKey((Serializable)formDefinitionId);
	}

	/**
	 * Returns the form definition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition, or <code>null</code> if a form definition with the primary key could not be found
	 */
	@Override
	public FormDefinition fetchByPrimaryKey(long formDefinitionId) {
		return fetchByPrimaryKey((Serializable)formDefinitionId);
	}

	/**
	 * Returns all the form definitions.
	 *
	 * @return the form definitions
	 */
	@Override
	public List<FormDefinition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of form definitions
	 */
	@Override
	public List<FormDefinition> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the form definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of form definitions
	 */
	@Override
	public List<FormDefinition> findAll(
		int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of form definitions
	 */
	@Override
	public List<FormDefinition> findAll(
		int start, int end, OrderByComparator<FormDefinition> orderByComparator,
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

		List<FormDefinition> list = null;

		if (useFinderCache) {
			list = (List<FormDefinition>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FORMDEFINITION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FORMDEFINITION;

				sql = sql.concat(FormDefinitionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FormDefinition>)QueryUtil.list(
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
	 * Removes all the form definitions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FormDefinition formDefinition : findAll()) {
			remove(formDefinition);
		}
	}

	/**
	 * Returns the number of form definitions.
	 *
	 * @return the number of form definitions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FORMDEFINITION);

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
		return "formDefinitionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FORMDEFINITION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FormDefinitionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the form definition persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new FormDefinitionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", FormDefinition.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathFetchByFormClass = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFormClass",
			new String[] {String.class.getName()}, new String[] {"formClass"},
			true);

		_finderPathCountByFormClass = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFormClass",
			new String[] {String.class.getName()}, new String[] {"formClass"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(FormDefinitionImpl.class.getName());

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

	private static final String _SQL_SELECT_FORMDEFINITION =
		"SELECT formDefinition FROM FormDefinition formDefinition";

	private static final String _SQL_SELECT_FORMDEFINITION_WHERE =
		"SELECT formDefinition FROM FormDefinition formDefinition WHERE ";

	private static final String _SQL_COUNT_FORMDEFINITION =
		"SELECT COUNT(formDefinition) FROM FormDefinition formDefinition";

	private static final String _SQL_COUNT_FORMDEFINITION_WHERE =
		"SELECT COUNT(formDefinition) FROM FormDefinition formDefinition WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "formDefinition.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FormDefinition exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FormDefinition exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FormDefinitionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

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

	private static class FormDefinitionModelArgumentsResolver
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

			FormDefinitionModelImpl formDefinitionModelImpl =
				(FormDefinitionModelImpl)baseModel;

			long columnBitmask = formDefinitionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					formDefinitionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						formDefinitionModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					formDefinitionModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			FormDefinitionModelImpl formDefinitionModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						formDefinitionModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = formDefinitionModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}