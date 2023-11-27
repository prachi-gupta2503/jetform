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

package net.ayudh.comnet.admin.service.persistence.impl;

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

import net.ayudh.comnet.admin.exception.NoSuchApplicationUserException;
import net.ayudh.comnet.admin.model.ApplicationUser;
import net.ayudh.comnet.admin.model.impl.ApplicationUserImpl;
import net.ayudh.comnet.admin.model.impl.ApplicationUserModelImpl;
import net.ayudh.comnet.admin.service.persistence.ApplicationUserPersistence;
import net.ayudh.comnet.admin.service.persistence.impl.constants.comnetPersistenceConstants;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the application user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ApplicationUserPersistence.class)
public class ApplicationUserPersistenceImpl
	extends BasePersistenceImpl<ApplicationUser>
	implements ApplicationUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ApplicationUserUtil</code> to access the application user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ApplicationUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns the application user where employeeId = &#63; or throws a <code>NoSuchApplicationUserException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching application user
	 * @throws NoSuchApplicationUserException if a matching application user could not be found
	 */
	@Override
	public ApplicationUser findByEmployeeId(long employeeId)
		throws NoSuchApplicationUserException {

		ApplicationUser applicationUser = fetchByEmployeeId(employeeId);

		if (applicationUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("employeeId=");
			sb.append(employeeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchApplicationUserException(sb.toString());
		}

		return applicationUser;
	}

	/**
	 * Returns the application user where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	@Override
	public ApplicationUser fetchByEmployeeId(long employeeId) {
		return fetchByEmployeeId(employeeId, true);
	}

	/**
	 * Returns the application user where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	@Override
	public ApplicationUser fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {employeeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmployeeId, finderArgs, this);
		}

		if (result instanceof ApplicationUser) {
			ApplicationUser applicationUser = (ApplicationUser)result;

			if (employeeId != applicationUser.getEmployeeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_APPLICATIONUSER_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				List<ApplicationUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmployeeId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {employeeId};
							}

							_log.warn(
								"ApplicationUserPersistenceImpl.fetchByEmployeeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ApplicationUser applicationUser = list.get(0);

					result = applicationUser;

					cacheResult(applicationUser);
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
			return (ApplicationUser)result;
		}
	}

	/**
	 * Removes the application user where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the application user that was removed
	 */
	@Override
	public ApplicationUser removeByEmployeeId(long employeeId)
		throws NoSuchApplicationUserException {

		ApplicationUser applicationUser = findByEmployeeId(employeeId);

		return remove(applicationUser);
	}

	/**
	 * Returns the number of application users where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching application users
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPLICATIONUSER_WHERE);

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
		"applicationUser.employeeId = ?";

	private FinderPath _finderPathFetchByLoginId;
	private FinderPath _finderPathCountByLoginId;

	/**
	 * Returns the application user where loginId = &#63; or throws a <code>NoSuchApplicationUserException</code> if it could not be found.
	 *
	 * @param loginId the login ID
	 * @return the matching application user
	 * @throws NoSuchApplicationUserException if a matching application user could not be found
	 */
	@Override
	public ApplicationUser findByLoginId(String loginId)
		throws NoSuchApplicationUserException {

		ApplicationUser applicationUser = fetchByLoginId(loginId);

		if (applicationUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("loginId=");
			sb.append(loginId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchApplicationUserException(sb.toString());
		}

		return applicationUser;
	}

	/**
	 * Returns the application user where loginId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param loginId the login ID
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	@Override
	public ApplicationUser fetchByLoginId(String loginId) {
		return fetchByLoginId(loginId, true);
	}

	/**
	 * Returns the application user where loginId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param loginId the login ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	@Override
	public ApplicationUser fetchByLoginId(
		String loginId, boolean useFinderCache) {

		loginId = Objects.toString(loginId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {loginId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLoginId, finderArgs, this);
		}

		if (result instanceof ApplicationUser) {
			ApplicationUser applicationUser = (ApplicationUser)result;

			if (!Objects.equals(loginId, applicationUser.getLoginId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_APPLICATIONUSER_WHERE);

			boolean bindLoginId = false;

			if (loginId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOGINID_LOGINID_3);
			}
			else {
				bindLoginId = true;

				sb.append(_FINDER_COLUMN_LOGINID_LOGINID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLoginId) {
					queryPos.add(loginId);
				}

				List<ApplicationUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLoginId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {loginId};
							}

							_log.warn(
								"ApplicationUserPersistenceImpl.fetchByLoginId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ApplicationUser applicationUser = list.get(0);

					result = applicationUser;

					cacheResult(applicationUser);
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
			return (ApplicationUser)result;
		}
	}

	/**
	 * Removes the application user where loginId = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @return the application user that was removed
	 */
	@Override
	public ApplicationUser removeByLoginId(String loginId)
		throws NoSuchApplicationUserException {

		ApplicationUser applicationUser = findByLoginId(loginId);

		return remove(applicationUser);
	}

	/**
	 * Returns the number of application users where loginId = &#63;.
	 *
	 * @param loginId the login ID
	 * @return the number of matching application users
	 */
	@Override
	public int countByLoginId(String loginId) {
		loginId = Objects.toString(loginId, "");

		FinderPath finderPath = _finderPathCountByLoginId;

		Object[] finderArgs = new Object[] {loginId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPLICATIONUSER_WHERE);

			boolean bindLoginId = false;

			if (loginId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOGINID_LOGINID_3);
			}
			else {
				bindLoginId = true;

				sb.append(_FINDER_COLUMN_LOGINID_LOGINID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLoginId) {
					queryPos.add(loginId);
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

	private static final String _FINDER_COLUMN_LOGINID_LOGINID_2 =
		"applicationUser.loginId = ?";

	private static final String _FINDER_COLUMN_LOGINID_LOGINID_3 =
		"(applicationUser.loginId IS NULL OR applicationUser.loginId = '')";

	public ApplicationUserPersistenceImpl() {
		setModelClass(ApplicationUser.class);

		setModelImplClass(ApplicationUserImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the application user in the entity cache if it is enabled.
	 *
	 * @param applicationUser the application user
	 */
	@Override
	public void cacheResult(ApplicationUser applicationUser) {
		entityCache.putResult(
			ApplicationUserImpl.class, applicationUser.getPrimaryKey(),
			applicationUser);

		finderCache.putResult(
			_finderPathFetchByEmployeeId,
			new Object[] {applicationUser.getEmployeeId()}, applicationUser);

		finderCache.putResult(
			_finderPathFetchByLoginId,
			new Object[] {applicationUser.getLoginId()}, applicationUser);
	}

	/**
	 * Caches the application users in the entity cache if it is enabled.
	 *
	 * @param applicationUsers the application users
	 */
	@Override
	public void cacheResult(List<ApplicationUser> applicationUsers) {
		for (ApplicationUser applicationUser : applicationUsers) {
			if (entityCache.getResult(
					ApplicationUserImpl.class,
					applicationUser.getPrimaryKey()) == null) {

				cacheResult(applicationUser);
			}
		}
	}

	/**
	 * Clears the cache for all application users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApplicationUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the application user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApplicationUser applicationUser) {
		entityCache.removeResult(ApplicationUserImpl.class, applicationUser);
	}

	@Override
	public void clearCache(List<ApplicationUser> applicationUsers) {
		for (ApplicationUser applicationUser : applicationUsers) {
			entityCache.removeResult(
				ApplicationUserImpl.class, applicationUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ApplicationUserImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ApplicationUserModelImpl applicationUserModelImpl) {

		Object[] args = new Object[] {applicationUserModelImpl.getEmployeeId()};

		finderCache.putResult(
			_finderPathCountByEmployeeId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByEmployeeId, args, applicationUserModelImpl,
			false);

		args = new Object[] {applicationUserModelImpl.getLoginId()};

		finderCache.putResult(
			_finderPathCountByLoginId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByLoginId, args, applicationUserModelImpl, false);
	}

	/**
	 * Creates a new application user with the primary key. Does not add the application user to the database.
	 *
	 * @param applicationUserId the primary key for the new application user
	 * @return the new application user
	 */
	@Override
	public ApplicationUser create(long applicationUserId) {
		ApplicationUser applicationUser = new ApplicationUserImpl();

		applicationUser.setNew(true);
		applicationUser.setPrimaryKey(applicationUserId);

		applicationUser.setCompanyId(CompanyThreadLocal.getCompanyId());

		return applicationUser;
	}

	/**
	 * Removes the application user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user that was removed
	 * @throws NoSuchApplicationUserException if a application user with the primary key could not be found
	 */
	@Override
	public ApplicationUser remove(long applicationUserId)
		throws NoSuchApplicationUserException {

		return remove((Serializable)applicationUserId);
	}

	/**
	 * Removes the application user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the application user
	 * @return the application user that was removed
	 * @throws NoSuchApplicationUserException if a application user with the primary key could not be found
	 */
	@Override
	public ApplicationUser remove(Serializable primaryKey)
		throws NoSuchApplicationUserException {

		Session session = null;

		try {
			session = openSession();

			ApplicationUser applicationUser = (ApplicationUser)session.get(
				ApplicationUserImpl.class, primaryKey);

			if (applicationUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicationUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(applicationUser);
		}
		catch (NoSuchApplicationUserException noSuchEntityException) {
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
	protected ApplicationUser removeImpl(ApplicationUser applicationUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicationUser)) {
				applicationUser = (ApplicationUser)session.get(
					ApplicationUserImpl.class,
					applicationUser.getPrimaryKeyObj());
			}

			if (applicationUser != null) {
				session.delete(applicationUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (applicationUser != null) {
			clearCache(applicationUser);
		}

		return applicationUser;
	}

	@Override
	public ApplicationUser updateImpl(ApplicationUser applicationUser) {
		boolean isNew = applicationUser.isNew();

		if (!(applicationUser instanceof ApplicationUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(applicationUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					applicationUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in applicationUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ApplicationUser implementation " +
					applicationUser.getClass());
		}

		ApplicationUserModelImpl applicationUserModelImpl =
			(ApplicationUserModelImpl)applicationUser;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (applicationUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				applicationUser.setCreateDate(now);
			}
			else {
				applicationUser.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!applicationUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				applicationUser.setModifiedDate(now);
			}
			else {
				applicationUser.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(applicationUser);
			}
			else {
				applicationUser = (ApplicationUser)session.merge(
					applicationUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ApplicationUserImpl.class, applicationUserModelImpl, false, true);

		cacheUniqueFindersCache(applicationUserModelImpl);

		if (isNew) {
			applicationUser.setNew(false);
		}

		applicationUser.resetOriginalValues();

		return applicationUser;
	}

	/**
	 * Returns the application user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the application user
	 * @return the application user
	 * @throws NoSuchApplicationUserException if a application user with the primary key could not be found
	 */
	@Override
	public ApplicationUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicationUserException {

		ApplicationUser applicationUser = fetchByPrimaryKey(primaryKey);

		if (applicationUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicationUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return applicationUser;
	}

	/**
	 * Returns the application user with the primary key or throws a <code>NoSuchApplicationUserException</code> if it could not be found.
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user
	 * @throws NoSuchApplicationUserException if a application user with the primary key could not be found
	 */
	@Override
	public ApplicationUser findByPrimaryKey(long applicationUserId)
		throws NoSuchApplicationUserException {

		return findByPrimaryKey((Serializable)applicationUserId);
	}

	/**
	 * Returns the application user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user, or <code>null</code> if a application user with the primary key could not be found
	 */
	@Override
	public ApplicationUser fetchByPrimaryKey(long applicationUserId) {
		return fetchByPrimaryKey((Serializable)applicationUserId);
	}

	/**
	 * Returns all the application users.
	 *
	 * @return the application users
	 */
	@Override
	public List<ApplicationUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the application users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application users
	 * @param end the upper bound of the range of application users (not inclusive)
	 * @return the range of application users
	 */
	@Override
	public List<ApplicationUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the application users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application users
	 * @param end the upper bound of the range of application users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of application users
	 */
	@Override
	public List<ApplicationUser> findAll(
		int start, int end,
		OrderByComparator<ApplicationUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the application users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application users
	 * @param end the upper bound of the range of application users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of application users
	 */
	@Override
	public List<ApplicationUser> findAll(
		int start, int end,
		OrderByComparator<ApplicationUser> orderByComparator,
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

		List<ApplicationUser> list = null;

		if (useFinderCache) {
			list = (List<ApplicationUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPLICATIONUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICATIONUSER;

				sql = sql.concat(ApplicationUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ApplicationUser>)QueryUtil.list(
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
	 * Removes all the application users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ApplicationUser applicationUser : findAll()) {
			remove(applicationUser);
		}
	}

	/**
	 * Returns the number of application users.
	 *
	 * @return the number of application users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPLICATIONUSER);

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
		return "applicationUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPLICATIONUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ApplicationUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the application user persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ApplicationUserModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ApplicationUser.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_finderPathFetchByLoginId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLoginId",
			new String[] {String.class.getName()}, new String[] {"loginId"},
			true);

		_finderPathCountByLoginId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLoginId",
			new String[] {String.class.getName()}, new String[] {"loginId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ApplicationUserImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = comnetPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = comnetPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = comnetPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_APPLICATIONUSER =
		"SELECT applicationUser FROM ApplicationUser applicationUser";

	private static final String _SQL_SELECT_APPLICATIONUSER_WHERE =
		"SELECT applicationUser FROM ApplicationUser applicationUser WHERE ";

	private static final String _SQL_COUNT_APPLICATIONUSER =
		"SELECT COUNT(applicationUser) FROM ApplicationUser applicationUser";

	private static final String _SQL_COUNT_APPLICATIONUSER_WHERE =
		"SELECT COUNT(applicationUser) FROM ApplicationUser applicationUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "applicationUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ApplicationUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ApplicationUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ApplicationUserPersistenceImpl.class);

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

	private static class ApplicationUserModelArgumentsResolver
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

			ApplicationUserModelImpl applicationUserModelImpl =
				(ApplicationUserModelImpl)baseModel;

			long columnBitmask = applicationUserModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					applicationUserModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						applicationUserModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					applicationUserModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ApplicationUserModelImpl applicationUserModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						applicationUserModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = applicationUserModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}