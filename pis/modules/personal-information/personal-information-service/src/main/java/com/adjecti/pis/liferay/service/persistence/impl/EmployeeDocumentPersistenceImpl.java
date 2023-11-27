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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDocumentException;
import com.adjecti.pis.liferay.model.EmployeeDocument;
import com.adjecti.pis.liferay.model.impl.EmployeeDocumentImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeDocumentModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeDocumentPersistence;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the employee document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeDocumentPersistence.class)
public class EmployeeDocumentPersistenceImpl
	extends BasePersistenceImpl<EmployeeDocument>
	implements EmployeeDocumentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeDocumentUtil</code> to access the employee document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeDocumentImpl.class.getName();

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
	 * Returns all the employee documents where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee documents
	 */
	@Override
	public List<EmployeeDocument> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee documents where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @return the range of matching employee documents
	 */
	@Override
	public List<EmployeeDocument> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee documents where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee documents
	 */
	@Override
	public List<EmployeeDocument> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee documents where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee documents
	 */
	@Override
	public List<EmployeeDocument> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator,
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

		List<EmployeeDocument> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDocument employeeDocument : list) {
					if (employeeId != employeeDocument.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEDOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeDocument>)QueryUtil.list(
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
	 * Returns the first employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	@Override
	public EmployeeDocument findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeDocument> orderByComparator)
		throws NoSuchEmployeeDocumentException {

		EmployeeDocument employeeDocument = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeDocument != null) {
			return employeeDocument;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeDocumentException(sb.toString());
	}

	/**
	 * Returns the first employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	@Override
	public EmployeeDocument fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		List<EmployeeDocument> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	@Override
	public EmployeeDocument findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeDocument> orderByComparator)
		throws NoSuchEmployeeDocumentException {

		EmployeeDocument employeeDocument = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeDocument != null) {
			return employeeDocument;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeDocumentException(sb.toString());
	}

	/**
	 * Returns the last employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	@Override
	public EmployeeDocument fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDocument> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee documents before and after the current employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDocumentId the primary key of the current employee document
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	@Override
	public EmployeeDocument[] findByEmployeeId_PrevAndNext(
			long employeeDocumentId, long employeeId,
			OrderByComparator<EmployeeDocument> orderByComparator)
		throws NoSuchEmployeeDocumentException {

		EmployeeDocument employeeDocument = findByPrimaryKey(
			employeeDocumentId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDocument[] array = new EmployeeDocumentImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeDocument, employeeId, orderByComparator, true);

			array[1] = employeeDocument;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeDocument, employeeId, orderByComparator,
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

	protected EmployeeDocument getByEmployeeId_PrevAndNext(
		Session session, EmployeeDocument employeeDocument, long employeeId,
		OrderByComparator<EmployeeDocument> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDOCUMENT_WHERE);

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
			sb.append(EmployeeDocumentModelImpl.ORDER_BY_JPQL);
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
						employeeDocument)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDocument> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee documents where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeDocument employeeDocument :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDocument);
		}
	}

	/**
	 * Returns the number of employee documents where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee documents
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDOCUMENT_WHERE);

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
		"employeeDocument.employeeId = ?";

	private FinderPath _finderPathFetchByDocumentId;
	private FinderPath _finderPathCountByDocumentId;

	/**
	 * Returns the employee document where documentId = &#63; or throws a <code>NoSuchEmployeeDocumentException</code> if it could not be found.
	 *
	 * @param documentId the document ID
	 * @return the matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	@Override
	public EmployeeDocument findByDocumentId(long documentId)
		throws NoSuchEmployeeDocumentException {

		EmployeeDocument employeeDocument = fetchByDocumentId(documentId);

		if (employeeDocument == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("documentId=");
			sb.append(documentId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeeDocumentException(sb.toString());
		}

		return employeeDocument;
	}

	/**
	 * Returns the employee document where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentId the document ID
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	@Override
	public EmployeeDocument fetchByDocumentId(long documentId) {
		return fetchByDocumentId(documentId, true);
	}

	/**
	 * Returns the employee document where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentId the document ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	@Override
	public EmployeeDocument fetchByDocumentId(
		long documentId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {documentId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDocumentId, finderArgs, this);
		}

		if (result instanceof EmployeeDocument) {
			EmployeeDocument employeeDocument = (EmployeeDocument)result;

			if (documentId != employeeDocument.getDocumentId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EMPLOYEEDOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

				List<EmployeeDocument> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDocumentId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {documentId};
							}

							_log.warn(
								"EmployeeDocumentPersistenceImpl.fetchByDocumentId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeeDocument employeeDocument = list.get(0);

					result = employeeDocument;

					cacheResult(employeeDocument);
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
			return (EmployeeDocument)result;
		}
	}

	/**
	 * Removes the employee document where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @return the employee document that was removed
	 */
	@Override
	public EmployeeDocument removeByDocumentId(long documentId)
		throws NoSuchEmployeeDocumentException {

		EmployeeDocument employeeDocument = findByDocumentId(documentId);

		return remove(employeeDocument);
	}

	/**
	 * Returns the number of employee documents where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching employee documents
	 */
	@Override
	public int countByDocumentId(long documentId) {
		FinderPath finderPath = _finderPathCountByDocumentId;

		Object[] finderArgs = new Object[] {documentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

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

	private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2 =
		"employeeDocument.documentId = ?";

	public EmployeeDocumentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeDocument.class);

		setModelImplClass(EmployeeDocumentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee document in the entity cache if it is enabled.
	 *
	 * @param employeeDocument the employee document
	 */
	@Override
	public void cacheResult(EmployeeDocument employeeDocument) {
		entityCache.putResult(
			EmployeeDocumentImpl.class, employeeDocument.getPrimaryKey(),
			employeeDocument);

		finderCache.putResult(
			_finderPathFetchByDocumentId,
			new Object[] {employeeDocument.getDocumentId()}, employeeDocument);
	}

	/**
	 * Caches the employee documents in the entity cache if it is enabled.
	 *
	 * @param employeeDocuments the employee documents
	 */
	@Override
	public void cacheResult(List<EmployeeDocument> employeeDocuments) {
		for (EmployeeDocument employeeDocument : employeeDocuments) {
			if (entityCache.getResult(
					EmployeeDocumentImpl.class,
					employeeDocument.getPrimaryKey()) == null) {

				cacheResult(employeeDocument);
			}
		}
	}

	/**
	 * Clears the cache for all employee documents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDocumentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee document.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDocument employeeDocument) {
		entityCache.removeResult(EmployeeDocumentImpl.class, employeeDocument);
	}

	@Override
	public void clearCache(List<EmployeeDocument> employeeDocuments) {
		for (EmployeeDocument employeeDocument : employeeDocuments) {
			entityCache.removeResult(
				EmployeeDocumentImpl.class, employeeDocument);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeDocumentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeDocumentModelImpl employeeDocumentModelImpl) {

		Object[] args = new Object[] {
			employeeDocumentModelImpl.getDocumentId()
		};

		finderCache.putResult(
			_finderPathCountByDocumentId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDocumentId, args, employeeDocumentModelImpl,
			false);
	}

	/**
	 * Creates a new employee document with the primary key. Does not add the employee document to the database.
	 *
	 * @param employeeDocumentId the primary key for the new employee document
	 * @return the new employee document
	 */
	@Override
	public EmployeeDocument create(long employeeDocumentId) {
		EmployeeDocument employeeDocument = new EmployeeDocumentImpl();

		employeeDocument.setNew(true);
		employeeDocument.setPrimaryKey(employeeDocumentId);

		employeeDocument.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeDocument;
	}

	/**
	 * Removes the employee document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document that was removed
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	@Override
	public EmployeeDocument remove(long employeeDocumentId)
		throws NoSuchEmployeeDocumentException {

		return remove((Serializable)employeeDocumentId);
	}

	/**
	 * Removes the employee document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee document
	 * @return the employee document that was removed
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	@Override
	public EmployeeDocument remove(Serializable primaryKey)
		throws NoSuchEmployeeDocumentException {

		Session session = null;

		try {
			session = openSession();

			EmployeeDocument employeeDocument = (EmployeeDocument)session.get(
				EmployeeDocumentImpl.class, primaryKey);

			if (employeeDocument == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDocumentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeDocument);
		}
		catch (NoSuchEmployeeDocumentException noSuchEntityException) {
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
	protected EmployeeDocument removeImpl(EmployeeDocument employeeDocument) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDocument)) {
				employeeDocument = (EmployeeDocument)session.get(
					EmployeeDocumentImpl.class,
					employeeDocument.getPrimaryKeyObj());
			}

			if (employeeDocument != null) {
				session.delete(employeeDocument);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeDocument != null) {
			clearCache(employeeDocument);
		}

		return employeeDocument;
	}

	@Override
	public EmployeeDocument updateImpl(EmployeeDocument employeeDocument) {
		boolean isNew = employeeDocument.isNew();

		if (!(employeeDocument instanceof EmployeeDocumentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDocument.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeDocument);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDocument proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDocument implementation " +
					employeeDocument.getClass());
		}

		EmployeeDocumentModelImpl employeeDocumentModelImpl =
			(EmployeeDocumentModelImpl)employeeDocument;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeDocument.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeDocument.setCreateDate(now);
			}
			else {
				employeeDocument.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeDocumentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeDocument.setModifiedDate(now);
			}
			else {
				employeeDocument.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeDocument);
			}
			else {
				employeeDocument = (EmployeeDocument)session.merge(
					employeeDocument);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeDocumentImpl.class, employeeDocumentModelImpl, false, true);

		cacheUniqueFindersCache(employeeDocumentModelImpl);

		if (isNew) {
			employeeDocument.setNew(false);
		}

		employeeDocument.resetOriginalValues();

		return employeeDocument;
	}

	/**
	 * Returns the employee document with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee document
	 * @return the employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	@Override
	public EmployeeDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDocumentException {

		EmployeeDocument employeeDocument = fetchByPrimaryKey(primaryKey);

		if (employeeDocument == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDocumentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeDocument;
	}

	/**
	 * Returns the employee document with the primary key or throws a <code>NoSuchEmployeeDocumentException</code> if it could not be found.
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	@Override
	public EmployeeDocument findByPrimaryKey(long employeeDocumentId)
		throws NoSuchEmployeeDocumentException {

		return findByPrimaryKey((Serializable)employeeDocumentId);
	}

	/**
	 * Returns the employee document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document, or <code>null</code> if a employee document with the primary key could not be found
	 */
	@Override
	public EmployeeDocument fetchByPrimaryKey(long employeeDocumentId) {
		return fetchByPrimaryKey((Serializable)employeeDocumentId);
	}

	/**
	 * Returns all the employee documents.
	 *
	 * @return the employee documents
	 */
	@Override
	public List<EmployeeDocument> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @return the range of employee documents
	 */
	@Override
	public List<EmployeeDocument> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee documents
	 */
	@Override
	public List<EmployeeDocument> findAll(
		int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee documents
	 */
	@Override
	public List<EmployeeDocument> findAll(
		int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator,
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

		List<EmployeeDocument> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDocument>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEDOCUMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDOCUMENT;

				sql = sql.concat(EmployeeDocumentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeDocument>)QueryUtil.list(
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
	 * Removes all the employee documents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDocument employeeDocument : findAll()) {
			remove(employeeDocument);
		}
	}

	/**
	 * Returns the number of employee documents.
	 *
	 * @return the number of employee documents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEDOCUMENT);

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
		return "employeeDocumentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEDOCUMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDocumentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee document persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeDocumentModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeDocument.class.getName()));

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

		_finderPathFetchByDocumentId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDocumentId",
			new String[] {Long.class.getName()}, new String[] {"documentId"},
			true);

		_finderPathCountByDocumentId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentId",
			new String[] {Long.class.getName()}, new String[] {"documentId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeDocumentImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEDOCUMENT =
		"SELECT employeeDocument FROM EmployeeDocument employeeDocument";

	private static final String _SQL_SELECT_EMPLOYEEDOCUMENT_WHERE =
		"SELECT employeeDocument FROM EmployeeDocument employeeDocument WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEDOCUMENT =
		"SELECT COUNT(employeeDocument) FROM EmployeeDocument employeeDocument";

	private static final String _SQL_COUNT_EMPLOYEEDOCUMENT_WHERE =
		"SELECT COUNT(employeeDocument) FROM EmployeeDocument employeeDocument WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeDocument.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeDocument exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeDocument exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeDocumentPersistenceImpl.class);

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

	private static class EmployeeDocumentModelArgumentsResolver
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

			EmployeeDocumentModelImpl employeeDocumentModelImpl =
				(EmployeeDocumentModelImpl)baseModel;

			long columnBitmask = employeeDocumentModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeDocumentModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeDocumentModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeDocumentModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeDocumentModelImpl employeeDocumentModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeDocumentModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeDocumentModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}