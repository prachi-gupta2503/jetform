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

import com.adjecti.mdm.liferay.exception.NoSuchDocumentTypeException;
import com.adjecti.mdm.liferay.model.DocumentType;
import com.adjecti.mdm.liferay.model.impl.DocumentTypeImpl;
import com.adjecti.mdm.liferay.model.impl.DocumentTypeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.DocumentTypePersistence;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the document type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DocumentTypePersistence.class)
public class DocumentTypePersistenceImpl
	extends BasePersistenceImpl<DocumentType>
	implements DocumentTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocumentTypeUtil</code> to access the document type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocumentTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDocumentTypeName;
	private FinderPath _finderPathCountByDocumentTypeName;

	/**
	 * Returns the document type where name = &#63; or throws a <code>NoSuchDocumentTypeException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching document type
	 * @throws NoSuchDocumentTypeException if a matching document type could not be found
	 */
	@Override
	public DocumentType findByDocumentTypeName(String name)
		throws NoSuchDocumentTypeException {

		DocumentType documentType = fetchByDocumentTypeName(name);

		if (documentType == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDocumentTypeException(sb.toString());
		}

		return documentType;
	}

	/**
	 * Returns the document type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching document type, or <code>null</code> if a matching document type could not be found
	 */
	@Override
	public DocumentType fetchByDocumentTypeName(String name) {
		return fetchByDocumentTypeName(name, true);
	}

	/**
	 * Returns the document type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document type, or <code>null</code> if a matching document type could not be found
	 */
	@Override
	public DocumentType fetchByDocumentTypeName(
		String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDocumentTypeName, finderArgs, this);
		}

		if (result instanceof DocumentType) {
			DocumentType documentType = (DocumentType)result;

			if (!Objects.equals(name, documentType.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCUMENTTYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_DOCUMENTTYPENAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_DOCUMENTTYPENAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				List<DocumentType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDocumentTypeName, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"DocumentTypePersistenceImpl.fetchByDocumentTypeName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocumentType documentType = list.get(0);

					result = documentType;

					cacheResult(documentType);
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
			return (DocumentType)result;
		}
	}

	/**
	 * Removes the document type where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the document type that was removed
	 */
	@Override
	public DocumentType removeByDocumentTypeName(String name)
		throws NoSuchDocumentTypeException {

		DocumentType documentType = findByDocumentTypeName(name);

		return remove(documentType);
	}

	/**
	 * Returns the number of document types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching document types
	 */
	@Override
	public int countByDocumentTypeName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByDocumentTypeName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTTYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_DOCUMENTTYPENAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_DOCUMENTTYPENAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_DOCUMENTTYPENAME_NAME_2 =
		"documentType.name = ?";

	private static final String _FINDER_COLUMN_DOCUMENTTYPENAME_NAME_3 =
		"(documentType.name IS NULL OR documentType.name = '')";

	public DocumentTypePersistenceImpl() {
		setModelClass(DocumentType.class);

		setModelImplClass(DocumentTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the document type in the entity cache if it is enabled.
	 *
	 * @param documentType the document type
	 */
	@Override
	public void cacheResult(DocumentType documentType) {
		entityCache.putResult(
			DocumentTypeImpl.class, documentType.getPrimaryKey(), documentType);

		finderCache.putResult(
			_finderPathFetchByDocumentTypeName,
			new Object[] {documentType.getName()}, documentType);
	}

	/**
	 * Caches the document types in the entity cache if it is enabled.
	 *
	 * @param documentTypes the document types
	 */
	@Override
	public void cacheResult(List<DocumentType> documentTypes) {
		for (DocumentType documentType : documentTypes) {
			if (entityCache.getResult(
					DocumentTypeImpl.class, documentType.getPrimaryKey()) ==
						null) {

				cacheResult(documentType);
			}
		}
	}

	/**
	 * Clears the cache for all document types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the document type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentType documentType) {
		entityCache.removeResult(DocumentTypeImpl.class, documentType);
	}

	@Override
	public void clearCache(List<DocumentType> documentTypes) {
		for (DocumentType documentType : documentTypes) {
			entityCache.removeResult(DocumentTypeImpl.class, documentType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DocumentTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DocumentTypeModelImpl documentTypeModelImpl) {

		Object[] args = new Object[] {documentTypeModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByDocumentTypeName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDocumentTypeName, args, documentTypeModelImpl,
			false);
	}

	/**
	 * Creates a new document type with the primary key. Does not add the document type to the database.
	 *
	 * @param documentTypeId the primary key for the new document type
	 * @return the new document type
	 */
	@Override
	public DocumentType create(long documentTypeId) {
		DocumentType documentType = new DocumentTypeImpl();

		documentType.setNew(true);
		documentType.setPrimaryKey(documentTypeId);

		documentType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return documentType;
	}

	/**
	 * Removes the document type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type that was removed
	 * @throws NoSuchDocumentTypeException if a document type with the primary key could not be found
	 */
	@Override
	public DocumentType remove(long documentTypeId)
		throws NoSuchDocumentTypeException {

		return remove((Serializable)documentTypeId);
	}

	/**
	 * Removes the document type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document type
	 * @return the document type that was removed
	 * @throws NoSuchDocumentTypeException if a document type with the primary key could not be found
	 */
	@Override
	public DocumentType remove(Serializable primaryKey)
		throws NoSuchDocumentTypeException {

		Session session = null;

		try {
			session = openSession();

			DocumentType documentType = (DocumentType)session.get(
				DocumentTypeImpl.class, primaryKey);

			if (documentType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(documentType);
		}
		catch (NoSuchDocumentTypeException noSuchEntityException) {
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
	protected DocumentType removeImpl(DocumentType documentType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentType)) {
				documentType = (DocumentType)session.get(
					DocumentTypeImpl.class, documentType.getPrimaryKeyObj());
			}

			if (documentType != null) {
				session.delete(documentType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (documentType != null) {
			clearCache(documentType);
		}

		return documentType;
	}

	@Override
	public DocumentType updateImpl(DocumentType documentType) {
		boolean isNew = documentType.isNew();

		if (!(documentType instanceof DocumentTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(documentType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					documentType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in documentType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocumentType implementation " +
					documentType.getClass());
		}

		DocumentTypeModelImpl documentTypeModelImpl =
			(DocumentTypeModelImpl)documentType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (documentType.getCreateDate() == null)) {
			if (serviceContext == null) {
				documentType.setCreateDate(now);
			}
			else {
				documentType.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!documentTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				documentType.setModifiedDate(now);
			}
			else {
				documentType.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(documentType);
			}
			else {
				documentType = (DocumentType)session.merge(documentType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DocumentTypeImpl.class, documentTypeModelImpl, false, true);

		cacheUniqueFindersCache(documentTypeModelImpl);

		if (isNew) {
			documentType.setNew(false);
		}

		documentType.resetOriginalValues();

		return documentType;
	}

	/**
	 * Returns the document type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document type
	 * @return the document type
	 * @throws NoSuchDocumentTypeException if a document type with the primary key could not be found
	 */
	@Override
	public DocumentType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentTypeException {

		DocumentType documentType = fetchByPrimaryKey(primaryKey);

		if (documentType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return documentType;
	}

	/**
	 * Returns the document type with the primary key or throws a <code>NoSuchDocumentTypeException</code> if it could not be found.
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type
	 * @throws NoSuchDocumentTypeException if a document type with the primary key could not be found
	 */
	@Override
	public DocumentType findByPrimaryKey(long documentTypeId)
		throws NoSuchDocumentTypeException {

		return findByPrimaryKey((Serializable)documentTypeId);
	}

	/**
	 * Returns the document type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type, or <code>null</code> if a document type with the primary key could not be found
	 */
	@Override
	public DocumentType fetchByPrimaryKey(long documentTypeId) {
		return fetchByPrimaryKey((Serializable)documentTypeId);
	}

	/**
	 * Returns all the document types.
	 *
	 * @return the document types
	 */
	@Override
	public List<DocumentType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document types
	 * @param end the upper bound of the range of document types (not inclusive)
	 * @return the range of document types
	 */
	@Override
	public List<DocumentType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the document types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document types
	 * @param end the upper bound of the range of document types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document types
	 */
	@Override
	public List<DocumentType> findAll(
		int start, int end, OrderByComparator<DocumentType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document types
	 * @param end the upper bound of the range of document types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document types
	 */
	@Override
	public List<DocumentType> findAll(
		int start, int end, OrderByComparator<DocumentType> orderByComparator,
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

		List<DocumentType> list = null;

		if (useFinderCache) {
			list = (List<DocumentType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCUMENTTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTTYPE;

				sql = sql.concat(DocumentTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DocumentType>)QueryUtil.list(
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
	 * Removes all the document types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentType documentType : findAll()) {
			remove(documentType);
		}
	}

	/**
	 * Returns the number of document types.
	 *
	 * @return the number of document types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCUMENTTYPE);

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
		return "documentTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOCUMENTTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DocumentTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DocumentType.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByDocumentTypeName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDocumentTypeName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByDocumentTypeName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentTypeName", new String[] {String.class.getName()},
			new String[] {"name"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DocumentTypeImpl.class.getName());

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

	private static final String _SQL_SELECT_DOCUMENTTYPE =
		"SELECT documentType FROM DocumentType documentType";

	private static final String _SQL_SELECT_DOCUMENTTYPE_WHERE =
		"SELECT documentType FROM DocumentType documentType WHERE ";

	private static final String _SQL_COUNT_DOCUMENTTYPE =
		"SELECT COUNT(documentType) FROM DocumentType documentType";

	private static final String _SQL_COUNT_DOCUMENTTYPE_WHERE =
		"SELECT COUNT(documentType) FROM DocumentType documentType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "documentType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DocumentType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DocumentType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentTypePersistenceImpl.class);

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

	private static class DocumentTypeModelArgumentsResolver
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

			DocumentTypeModelImpl documentTypeModelImpl =
				(DocumentTypeModelImpl)baseModel;

			long columnBitmask = documentTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(documentTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						documentTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(documentTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DocumentTypeModelImpl documentTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = documentTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = documentTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}