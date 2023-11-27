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

package com.adjecti.pis.service.persistence.impl;

import com.adjecti.pis.exception.NoSuchBulkOnbordingFileException;
import com.adjecti.pis.model.BulkOnbordingFile;
import com.adjecti.pis.model.impl.BulkOnbordingFileImpl;
import com.adjecti.pis.model.impl.BulkOnbordingFileModelImpl;
import com.adjecti.pis.service.persistence.BulkOnbordingFilePersistence;
import com.adjecti.pis.service.persistence.impl.constants.OFBPersistenceConstants;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the bulk onbording file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BulkOnbordingFilePersistence.class)
public class BulkOnbordingFilePersistenceImpl
	extends BasePersistenceImpl<BulkOnbordingFile>
	implements BulkOnbordingFilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BulkOnbordingFileUtil</code> to access the bulk onbording file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BulkOnbordingFileImpl.class.getName();

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
	 * Returns all the bulk onbording files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bulk onbording files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
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

		List<BulkOnbordingFile> list = null;

		if (useFinderCache) {
			list = (List<BulkOnbordingFile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BulkOnbordingFile bulkOnbordingFile : list) {
					if (!uuid.equals(bulkOnbordingFile.getUuid())) {
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

			sb.append(_SQL_SELECT_BULKONBORDINGFILE_WHERE);

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
				sb.append(BulkOnbordingFileModelImpl.ORDER_BY_JPQL);
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

				list = (List<BulkOnbordingFile>)QueryUtil.list(
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
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByUuid_First(
			String uuid, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByUuid_First(
			uuid, orderByComparator);

		if (bulkOnbordingFile != null) {
			return bulkOnbordingFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBulkOnbordingFileException(sb.toString());
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByUuid_First(
		String uuid, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		List<BulkOnbordingFile> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByUuid_Last(
			String uuid, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByUuid_Last(
			uuid, orderByComparator);

		if (bulkOnbordingFile != null) {
			return bulkOnbordingFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBulkOnbordingFileException(sb.toString());
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByUuid_Last(
		String uuid, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BulkOnbordingFile> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public BulkOnbordingFile[] findByUuid_PrevAndNext(
			long bulkOnbordingFileId, String uuid,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		uuid = Objects.toString(uuid, "");

		BulkOnbordingFile bulkOnbordingFile = findByPrimaryKey(
			bulkOnbordingFileId);

		Session session = null;

		try {
			session = openSession();

			BulkOnbordingFile[] array = new BulkOnbordingFileImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bulkOnbordingFile, uuid, orderByComparator, true);

			array[1] = bulkOnbordingFile;

			array[2] = getByUuid_PrevAndNext(
				session, bulkOnbordingFile, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BulkOnbordingFile getByUuid_PrevAndNext(
		Session session, BulkOnbordingFile bulkOnbordingFile, String uuid,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
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

		sb.append(_SQL_SELECT_BULKONBORDINGFILE_WHERE);

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
			sb.append(BulkOnbordingFileModelImpl.ORDER_BY_JPQL);
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
						bulkOnbordingFile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BulkOnbordingFile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bulk onbording files where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BulkOnbordingFile bulkOnbordingFile :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bulkOnbordingFile);
		}
	}

	/**
	 * Returns the number of bulk onbording files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bulk onbording files
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BULKONBORDINGFILE_WHERE);

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
		"bulkOnbordingFile.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bulkOnbordingFile.uuid IS NULL OR bulkOnbordingFile.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the bulk onbording file where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBulkOnbordingFileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByUUID_G(String uuid, long groupId)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByUUID_G(uuid, groupId);

		if (bulkOnbordingFile == null) {
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

			throw new NoSuchBulkOnbordingFileException(sb.toString());
		}

		return bulkOnbordingFile;
	}

	/**
	 * Returns the bulk onbording file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the bulk onbording file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByUUID_G(
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

		if (result instanceof BulkOnbordingFile) {
			BulkOnbordingFile bulkOnbordingFile = (BulkOnbordingFile)result;

			if (!Objects.equals(uuid, bulkOnbordingFile.getUuid()) ||
				(groupId != bulkOnbordingFile.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BULKONBORDINGFILE_WHERE);

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

				List<BulkOnbordingFile> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					BulkOnbordingFile bulkOnbordingFile = list.get(0);

					result = bulkOnbordingFile;

					cacheResult(bulkOnbordingFile);
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
			return (BulkOnbordingFile)result;
		}
	}

	/**
	 * Removes the bulk onbording file where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bulk onbording file that was removed
	 */
	@Override
	public BulkOnbordingFile removeByUUID_G(String uuid, long groupId)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = findByUUID_G(uuid, groupId);

		return remove(bulkOnbordingFile);
	}

	/**
	 * Returns the number of bulk onbording files where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bulk onbording files
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BULKONBORDINGFILE_WHERE);

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
		"bulkOnbordingFile.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(bulkOnbordingFile.uuid IS NULL OR bulkOnbordingFile.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"bulkOnbordingFile.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
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

		List<BulkOnbordingFile> list = null;

		if (useFinderCache) {
			list = (List<BulkOnbordingFile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BulkOnbordingFile bulkOnbordingFile : list) {
					if (!uuid.equals(bulkOnbordingFile.getUuid()) ||
						(companyId != bulkOnbordingFile.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BULKONBORDINGFILE_WHERE);

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
				sb.append(BulkOnbordingFileModelImpl.ORDER_BY_JPQL);
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

				list = (List<BulkOnbordingFile>)QueryUtil.list(
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
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (bulkOnbordingFile != null) {
			return bulkOnbordingFile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBulkOnbordingFileException(sb.toString());
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		List<BulkOnbordingFile> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (bulkOnbordingFile != null) {
			return bulkOnbordingFile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBulkOnbordingFileException(sb.toString());
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<BulkOnbordingFile> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public BulkOnbordingFile[] findByUuid_C_PrevAndNext(
			long bulkOnbordingFileId, String uuid, long companyId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		uuid = Objects.toString(uuid, "");

		BulkOnbordingFile bulkOnbordingFile = findByPrimaryKey(
			bulkOnbordingFileId);

		Session session = null;

		try {
			session = openSession();

			BulkOnbordingFile[] array = new BulkOnbordingFileImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, bulkOnbordingFile, uuid, companyId, orderByComparator,
				true);

			array[1] = bulkOnbordingFile;

			array[2] = getByUuid_C_PrevAndNext(
				session, bulkOnbordingFile, uuid, companyId, orderByComparator,
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

	protected BulkOnbordingFile getByUuid_C_PrevAndNext(
		Session session, BulkOnbordingFile bulkOnbordingFile, String uuid,
		long companyId, OrderByComparator<BulkOnbordingFile> orderByComparator,
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

		sb.append(_SQL_SELECT_BULKONBORDINGFILE_WHERE);

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
			sb.append(BulkOnbordingFileModelImpl.ORDER_BY_JPQL);
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
						bulkOnbordingFile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BulkOnbordingFile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bulk onbording files where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (BulkOnbordingFile bulkOnbordingFile :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(bulkOnbordingFile);
		}
	}

	/**
	 * Returns the number of bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bulk onbording files
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BULKONBORDINGFILE_WHERE);

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
		"bulkOnbordingFile.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(bulkOnbordingFile.uuid IS NULL OR bulkOnbordingFile.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"bulkOnbordingFile.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByfileId;
	private FinderPath _finderPathWithoutPaginationFindByfileId;
	private FinderPath _finderPathCountByfileId;

	/**
	 * Returns all the bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByfileId(long bulkOnbordingFileId) {
		return findByfileId(
			bulkOnbordingFileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId, int start, int end) {

		return findByfileId(bulkOnbordingFileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return findByfileId(
			bulkOnbordingFileId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfileId;
				finderArgs = new Object[] {bulkOnbordingFileId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfileId;
			finderArgs = new Object[] {
				bulkOnbordingFileId, start, end, orderByComparator
			};
		}

		List<BulkOnbordingFile> list = null;

		if (useFinderCache) {
			list = (List<BulkOnbordingFile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BulkOnbordingFile bulkOnbordingFile : list) {
					if (bulkOnbordingFileId !=
							bulkOnbordingFile.getBulkOnbordingFileId()) {

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

			sb.append(_SQL_SELECT_BULKONBORDINGFILE_WHERE);

			sb.append(_FINDER_COLUMN_FILEID_BULKONBORDINGFILEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BulkOnbordingFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bulkOnbordingFileId);

				list = (List<BulkOnbordingFile>)QueryUtil.list(
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
	 * Returns the first bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByfileId_First(
			long bulkOnbordingFileId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByfileId_First(
			bulkOnbordingFileId, orderByComparator);

		if (bulkOnbordingFile != null) {
			return bulkOnbordingFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bulkOnbordingFileId=");
		sb.append(bulkOnbordingFileId);

		sb.append("}");

		throw new NoSuchBulkOnbordingFileException(sb.toString());
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByfileId_First(
		long bulkOnbordingFileId,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		List<BulkOnbordingFile> list = findByfileId(
			bulkOnbordingFileId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByfileId_Last(
			long bulkOnbordingFileId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByfileId_Last(
			bulkOnbordingFileId, orderByComparator);

		if (bulkOnbordingFile != null) {
			return bulkOnbordingFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bulkOnbordingFileId=");
		sb.append(bulkOnbordingFileId);

		sb.append("}");

		throw new NoSuchBulkOnbordingFileException(sb.toString());
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByfileId_Last(
		long bulkOnbordingFileId,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		int count = countByfileId(bulkOnbordingFileId);

		if (count == 0) {
			return null;
		}

		List<BulkOnbordingFile> list = findByfileId(
			bulkOnbordingFileId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the bulk onbording files where bulkOnbordingFileId = &#63; from the database.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 */
	@Override
	public void removeByfileId(long bulkOnbordingFileId) {
		for (BulkOnbordingFile bulkOnbordingFile :
				findByfileId(
					bulkOnbordingFileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(bulkOnbordingFile);
		}
	}

	/**
	 * Returns the number of bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the number of matching bulk onbording files
	 */
	@Override
	public int countByfileId(long bulkOnbordingFileId) {
		FinderPath finderPath = _finderPathCountByfileId;

		Object[] finderArgs = new Object[] {bulkOnbordingFileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BULKONBORDINGFILE_WHERE);

			sb.append(_FINDER_COLUMN_FILEID_BULKONBORDINGFILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bulkOnbordingFileId);

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

	private static final String _FINDER_COLUMN_FILEID_BULKONBORDINGFILEID_2 =
		"bulkOnbordingFile.bulkOnbordingFileId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the bulk onbording files where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bulk onbording files where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUserId(
		long userId, int start, int end) {

		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUserId(
		long userId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUserId(
		long userId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<BulkOnbordingFile> list = null;

		if (useFinderCache) {
			list = (List<BulkOnbordingFile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BulkOnbordingFile bulkOnbordingFile : list) {
					if (userId != bulkOnbordingFile.getUserId()) {
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

			sb.append(_SQL_SELECT_BULKONBORDINGFILE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BulkOnbordingFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<BulkOnbordingFile>)QueryUtil.list(
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
	 * Returns the first bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByUserId_First(
			long userId, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByUserId_First(
			userId, orderByComparator);

		if (bulkOnbordingFile != null) {
			return bulkOnbordingFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchBulkOnbordingFileException(sb.toString());
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByUserId_First(
		long userId, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		List<BulkOnbordingFile> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByUserId_Last(
			long userId, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByUserId_Last(
			userId, orderByComparator);

		if (bulkOnbordingFile != null) {
			return bulkOnbordingFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchBulkOnbordingFileException(sb.toString());
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByUserId_Last(
		long userId, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<BulkOnbordingFile> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public BulkOnbordingFile[] findByUserId_PrevAndNext(
			long bulkOnbordingFileId, long userId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = findByPrimaryKey(
			bulkOnbordingFileId);

		Session session = null;

		try {
			session = openSession();

			BulkOnbordingFile[] array = new BulkOnbordingFileImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, bulkOnbordingFile, userId, orderByComparator, true);

			array[1] = bulkOnbordingFile;

			array[2] = getByUserId_PrevAndNext(
				session, bulkOnbordingFile, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BulkOnbordingFile getByUserId_PrevAndNext(
		Session session, BulkOnbordingFile bulkOnbordingFile, long userId,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
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

		sb.append(_SQL_SELECT_BULKONBORDINGFILE_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(BulkOnbordingFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bulkOnbordingFile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BulkOnbordingFile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bulk onbording files where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (BulkOnbordingFile bulkOnbordingFile :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bulkOnbordingFile);
		}
	}

	/**
	 * Returns the number of bulk onbording files where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching bulk onbording files
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BULKONBORDINGFILE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"bulkOnbordingFile.userId = ?";

	private FinderPath _finderPathWithPaginationFindByUnitId;
	private FinderPath _finderPathWithoutPaginationFindByUnitId;
	private FinderPath _finderPathCountByUnitId;

	/**
	 * Returns all the bulk onbording files where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUnitId(Long unitId) {
		return findByUnitId(unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bulk onbording files where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUnitId(
		Long unitId, int start, int end) {

		return findByUnitId(unitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUnitId(
		Long unitId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return findByUnitId(unitId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findByUnitId(
		Long unitId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUnitId;
				finderArgs = new Object[] {unitId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUnitId;
			finderArgs = new Object[] {unitId, start, end, orderByComparator};
		}

		List<BulkOnbordingFile> list = null;

		if (useFinderCache) {
			list = (List<BulkOnbordingFile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BulkOnbordingFile bulkOnbordingFile : list) {
					if (!Objects.equals(
							unitId, bulkOnbordingFile.getUnitId())) {

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

			sb.append(_SQL_SELECT_BULKONBORDINGFILE_WHERE);

			sb.append(_FINDER_COLUMN_UNITID_UNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BulkOnbordingFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId.longValue());

				list = (List<BulkOnbordingFile>)QueryUtil.list(
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
	 * Returns the first bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByUnitId_First(
			Long unitId, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByUnitId_First(
			unitId, orderByComparator);

		if (bulkOnbordingFile != null) {
			return bulkOnbordingFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append("}");

		throw new NoSuchBulkOnbordingFileException(sb.toString());
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByUnitId_First(
		Long unitId, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		List<BulkOnbordingFile> list = findByUnitId(
			unitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile findByUnitId_Last(
			Long unitId, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByUnitId_Last(
			unitId, orderByComparator);

		if (bulkOnbordingFile != null) {
			return bulkOnbordingFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append("}");

		throw new NoSuchBulkOnbordingFileException(sb.toString());
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByUnitId_Last(
		Long unitId, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		int count = countByUnitId(unitId);

		if (count == 0) {
			return null;
		}

		List<BulkOnbordingFile> list = findByUnitId(
			unitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public BulkOnbordingFile[] findByUnitId_PrevAndNext(
			long bulkOnbordingFileId, Long unitId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = findByPrimaryKey(
			bulkOnbordingFileId);

		Session session = null;

		try {
			session = openSession();

			BulkOnbordingFile[] array = new BulkOnbordingFileImpl[3];

			array[0] = getByUnitId_PrevAndNext(
				session, bulkOnbordingFile, unitId, orderByComparator, true);

			array[1] = bulkOnbordingFile;

			array[2] = getByUnitId_PrevAndNext(
				session, bulkOnbordingFile, unitId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BulkOnbordingFile getByUnitId_PrevAndNext(
		Session session, BulkOnbordingFile bulkOnbordingFile, Long unitId,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
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

		sb.append(_SQL_SELECT_BULKONBORDINGFILE_WHERE);

		sb.append(_FINDER_COLUMN_UNITID_UNITID_2);

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
			sb.append(BulkOnbordingFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(unitId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bulkOnbordingFile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BulkOnbordingFile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bulk onbording files where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	@Override
	public void removeByUnitId(Long unitId) {
		for (BulkOnbordingFile bulkOnbordingFile :
				findByUnitId(
					unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bulkOnbordingFile);
		}
	}

	/**
	 * Returns the number of bulk onbording files where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching bulk onbording files
	 */
	@Override
	public int countByUnitId(Long unitId) {
		FinderPath finderPath = _finderPathCountByUnitId;

		Object[] finderArgs = new Object[] {unitId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BULKONBORDINGFILE_WHERE);

			sb.append(_FINDER_COLUMN_UNITID_UNITID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId.longValue());

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

	private static final String _FINDER_COLUMN_UNITID_UNITID_2 =
		"bulkOnbordingFile.unitId = ?";

	public BulkOnbordingFilePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BulkOnbordingFile.class);

		setModelImplClass(BulkOnbordingFileImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the bulk onbording file in the entity cache if it is enabled.
	 *
	 * @param bulkOnbordingFile the bulk onbording file
	 */
	@Override
	public void cacheResult(BulkOnbordingFile bulkOnbordingFile) {
		entityCache.putResult(
			BulkOnbordingFileImpl.class, bulkOnbordingFile.getPrimaryKey(),
			bulkOnbordingFile);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				bulkOnbordingFile.getUuid(), bulkOnbordingFile.getGroupId()
			},
			bulkOnbordingFile);
	}

	/**
	 * Caches the bulk onbording files in the entity cache if it is enabled.
	 *
	 * @param bulkOnbordingFiles the bulk onbording files
	 */
	@Override
	public void cacheResult(List<BulkOnbordingFile> bulkOnbordingFiles) {
		for (BulkOnbordingFile bulkOnbordingFile : bulkOnbordingFiles) {
			if (entityCache.getResult(
					BulkOnbordingFileImpl.class,
					bulkOnbordingFile.getPrimaryKey()) == null) {

				cacheResult(bulkOnbordingFile);
			}
		}
	}

	/**
	 * Clears the cache for all bulk onbording files.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BulkOnbordingFileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bulk onbording file.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BulkOnbordingFile bulkOnbordingFile) {
		entityCache.removeResult(
			BulkOnbordingFileImpl.class, bulkOnbordingFile);
	}

	@Override
	public void clearCache(List<BulkOnbordingFile> bulkOnbordingFiles) {
		for (BulkOnbordingFile bulkOnbordingFile : bulkOnbordingFiles) {
			entityCache.removeResult(
				BulkOnbordingFileImpl.class, bulkOnbordingFile);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BulkOnbordingFileImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BulkOnbordingFileModelImpl bulkOnbordingFileModelImpl) {

		Object[] args = new Object[] {
			bulkOnbordingFileModelImpl.getUuid(),
			bulkOnbordingFileModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, bulkOnbordingFileModelImpl, false);
	}

	/**
	 * Creates a new bulk onbording file with the primary key. Does not add the bulk onbording file to the database.
	 *
	 * @param bulkOnbordingFileId the primary key for the new bulk onbording file
	 * @return the new bulk onbording file
	 */
	@Override
	public BulkOnbordingFile create(long bulkOnbordingFileId) {
		BulkOnbordingFile bulkOnbordingFile = new BulkOnbordingFileImpl();

		bulkOnbordingFile.setNew(true);
		bulkOnbordingFile.setPrimaryKey(bulkOnbordingFileId);

		String uuid = PortalUUIDUtil.generate();

		bulkOnbordingFile.setUuid(uuid);

		bulkOnbordingFile.setCompanyId(CompanyThreadLocal.getCompanyId());

		return bulkOnbordingFile;
	}

	/**
	 * Removes the bulk onbording file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file that was removed
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public BulkOnbordingFile remove(long bulkOnbordingFileId)
		throws NoSuchBulkOnbordingFileException {

		return remove((Serializable)bulkOnbordingFileId);
	}

	/**
	 * Removes the bulk onbording file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bulk onbording file
	 * @return the bulk onbording file that was removed
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public BulkOnbordingFile remove(Serializable primaryKey)
		throws NoSuchBulkOnbordingFileException {

		Session session = null;

		try {
			session = openSession();

			BulkOnbordingFile bulkOnbordingFile =
				(BulkOnbordingFile)session.get(
					BulkOnbordingFileImpl.class, primaryKey);

			if (bulkOnbordingFile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBulkOnbordingFileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bulkOnbordingFile);
		}
		catch (NoSuchBulkOnbordingFileException noSuchEntityException) {
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
	protected BulkOnbordingFile removeImpl(
		BulkOnbordingFile bulkOnbordingFile) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bulkOnbordingFile)) {
				bulkOnbordingFile = (BulkOnbordingFile)session.get(
					BulkOnbordingFileImpl.class,
					bulkOnbordingFile.getPrimaryKeyObj());
			}

			if (bulkOnbordingFile != null) {
				session.delete(bulkOnbordingFile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bulkOnbordingFile != null) {
			clearCache(bulkOnbordingFile);
		}

		return bulkOnbordingFile;
	}

	@Override
	public BulkOnbordingFile updateImpl(BulkOnbordingFile bulkOnbordingFile) {
		boolean isNew = bulkOnbordingFile.isNew();

		if (!(bulkOnbordingFile instanceof BulkOnbordingFileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bulkOnbordingFile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bulkOnbordingFile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bulkOnbordingFile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BulkOnbordingFile implementation " +
					bulkOnbordingFile.getClass());
		}

		BulkOnbordingFileModelImpl bulkOnbordingFileModelImpl =
			(BulkOnbordingFileModelImpl)bulkOnbordingFile;

		if (Validator.isNull(bulkOnbordingFile.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bulkOnbordingFile.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (bulkOnbordingFile.getCreateDate() == null)) {
			if (serviceContext == null) {
				bulkOnbordingFile.setCreateDate(now);
			}
			else {
				bulkOnbordingFile.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!bulkOnbordingFileModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				bulkOnbordingFile.setModifiedDate(now);
			}
			else {
				bulkOnbordingFile.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bulkOnbordingFile);
			}
			else {
				bulkOnbordingFile = (BulkOnbordingFile)session.merge(
					bulkOnbordingFile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BulkOnbordingFileImpl.class, bulkOnbordingFileModelImpl, false,
			true);

		cacheUniqueFindersCache(bulkOnbordingFileModelImpl);

		if (isNew) {
			bulkOnbordingFile.setNew(false);
		}

		bulkOnbordingFile.resetOriginalValues();

		return bulkOnbordingFile;
	}

	/**
	 * Returns the bulk onbording file with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bulk onbording file
	 * @return the bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public BulkOnbordingFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBulkOnbordingFileException {

		BulkOnbordingFile bulkOnbordingFile = fetchByPrimaryKey(primaryKey);

		if (bulkOnbordingFile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBulkOnbordingFileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bulkOnbordingFile;
	}

	/**
	 * Returns the bulk onbording file with the primary key or throws a <code>NoSuchBulkOnbordingFileException</code> if it could not be found.
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public BulkOnbordingFile findByPrimaryKey(long bulkOnbordingFileId)
		throws NoSuchBulkOnbordingFileException {

		return findByPrimaryKey((Serializable)bulkOnbordingFileId);
	}

	/**
	 * Returns the bulk onbording file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file, or <code>null</code> if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public BulkOnbordingFile fetchByPrimaryKey(long bulkOnbordingFileId) {
		return fetchByPrimaryKey((Serializable)bulkOnbordingFileId);
	}

	/**
	 * Returns all the bulk onbording files.
	 *
	 * @return the bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bulk onbording files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findAll(
		int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bulk onbording files
	 */
	@Override
	public List<BulkOnbordingFile> findAll(
		int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
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

		List<BulkOnbordingFile> list = null;

		if (useFinderCache) {
			list = (List<BulkOnbordingFile>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BULKONBORDINGFILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BULKONBORDINGFILE;

				sql = sql.concat(BulkOnbordingFileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BulkOnbordingFile>)QueryUtil.list(
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
	 * Removes all the bulk onbording files from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BulkOnbordingFile bulkOnbordingFile : findAll()) {
			remove(bulkOnbordingFile);
		}
	}

	/**
	 * Returns the number of bulk onbording files.
	 *
	 * @return the number of bulk onbording files
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BULKONBORDINGFILE);

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
		return "bulkOnbordingFileId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BULKONBORDINGFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BulkOnbordingFileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bulk onbording file persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new BulkOnbordingFileModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", BulkOnbordingFile.class.getName()));

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

		_finderPathWithPaginationFindByfileId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfileId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"bulkOnbordingFileId"}, true);

		_finderPathWithoutPaginationFindByfileId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfileId",
			new String[] {Long.class.getName()},
			new String[] {"bulkOnbordingFileId"}, true);

		_finderPathCountByfileId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfileId",
			new String[] {Long.class.getName()},
			new String[] {"bulkOnbordingFileId"}, false);

		_finderPathWithPaginationFindByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByUnitId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"unitId"}, true);

		_finderPathWithoutPaginationFindByUnitId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnitId",
			new String[] {Long.class.getName()}, new String[] {"unitId"}, true);

		_finderPathCountByUnitId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnitId",
			new String[] {Long.class.getName()}, new String[] {"unitId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(BulkOnbordingFileImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = OFBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = OFBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OFBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_BULKONBORDINGFILE =
		"SELECT bulkOnbordingFile FROM BulkOnbordingFile bulkOnbordingFile";

	private static final String _SQL_SELECT_BULKONBORDINGFILE_WHERE =
		"SELECT bulkOnbordingFile FROM BulkOnbordingFile bulkOnbordingFile WHERE ";

	private static final String _SQL_COUNT_BULKONBORDINGFILE =
		"SELECT COUNT(bulkOnbordingFile) FROM BulkOnbordingFile bulkOnbordingFile";

	private static final String _SQL_COUNT_BULKONBORDINGFILE_WHERE =
		"SELECT COUNT(bulkOnbordingFile) FROM BulkOnbordingFile bulkOnbordingFile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bulkOnbordingFile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BulkOnbordingFile exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BulkOnbordingFile exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BulkOnbordingFilePersistenceImpl.class);

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

	private static class BulkOnbordingFileModelArgumentsResolver
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

			BulkOnbordingFileModelImpl bulkOnbordingFileModelImpl =
				(BulkOnbordingFileModelImpl)baseModel;

			long columnBitmask = bulkOnbordingFileModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					bulkOnbordingFileModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						bulkOnbordingFileModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					bulkOnbordingFileModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			BulkOnbordingFileModelImpl bulkOnbordingFileModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						bulkOnbordingFileModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = bulkOnbordingFileModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}