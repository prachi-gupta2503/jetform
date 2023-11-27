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

import com.adjecti.mdm.liferay.exception.NoSuchPostOrganizationException;
import com.adjecti.mdm.liferay.model.PostOrganization;
import com.adjecti.mdm.liferay.model.impl.PostOrganizationImpl;
import com.adjecti.mdm.liferay.model.impl.PostOrganizationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.PostOrganizationPersistence;
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
 * The persistence implementation for the post organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PostOrganizationPersistence.class)
public class PostOrganizationPersistenceImpl
	extends BasePersistenceImpl<PostOrganization>
	implements PostOrganizationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PostOrganizationUtil</code> to access the post organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PostOrganizationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPostId;
	private FinderPath _finderPathWithoutPaginationFindByPostId;
	private FinderPath _finderPathCountByPostId;

	/**
	 * Returns all the post organizations where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @return the matching post organizations
	 */
	@Override
	public List<PostOrganization> findByPostId(long postId) {
		return findByPostId(postId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the post organizations where postId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @return the range of matching post organizations
	 */
	@Override
	public List<PostOrganization> findByPostId(
		long postId, int start, int end) {

		return findByPostId(postId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the post organizations where postId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching post organizations
	 */
	@Override
	public List<PostOrganization> findByPostId(
		long postId, int start, int end,
		OrderByComparator<PostOrganization> orderByComparator) {

		return findByPostId(postId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the post organizations where postId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching post organizations
	 */
	@Override
	public List<PostOrganization> findByPostId(
		long postId, int start, int end,
		OrderByComparator<PostOrganization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPostId;
				finderArgs = new Object[] {postId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPostId;
			finderArgs = new Object[] {postId, start, end, orderByComparator};
		}

		List<PostOrganization> list = null;

		if (useFinderCache) {
			list = (List<PostOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PostOrganization postOrganization : list) {
					if (postId != postOrganization.getPostId()) {
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

			sb.append(_SQL_SELECT_POSTORGANIZATION_WHERE);

			sb.append(_FINDER_COLUMN_POSTID_POSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PostOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(postId);

				list = (List<PostOrganization>)QueryUtil.list(
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
	 * Returns the first post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	@Override
	public PostOrganization findByPostId_First(
			long postId, OrderByComparator<PostOrganization> orderByComparator)
		throws NoSuchPostOrganizationException {

		PostOrganization postOrganization = fetchByPostId_First(
			postId, orderByComparator);

		if (postOrganization != null) {
			return postOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("postId=");
		sb.append(postId);

		sb.append("}");

		throw new NoSuchPostOrganizationException(sb.toString());
	}

	/**
	 * Returns the first post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	@Override
	public PostOrganization fetchByPostId_First(
		long postId, OrderByComparator<PostOrganization> orderByComparator) {

		List<PostOrganization> list = findByPostId(
			postId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	@Override
	public PostOrganization findByPostId_Last(
			long postId, OrderByComparator<PostOrganization> orderByComparator)
		throws NoSuchPostOrganizationException {

		PostOrganization postOrganization = fetchByPostId_Last(
			postId, orderByComparator);

		if (postOrganization != null) {
			return postOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("postId=");
		sb.append(postId);

		sb.append("}");

		throw new NoSuchPostOrganizationException(sb.toString());
	}

	/**
	 * Returns the last post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	@Override
	public PostOrganization fetchByPostId_Last(
		long postId, OrderByComparator<PostOrganization> orderByComparator) {

		int count = countByPostId(postId);

		if (count == 0) {
			return null;
		}

		List<PostOrganization> list = findByPostId(
			postId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the post organizations before and after the current post organization in the ordered set where postId = &#63;.
	 *
	 * @param postOrganizationId the primary key of the current post organization
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next post organization
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	@Override
	public PostOrganization[] findByPostId_PrevAndNext(
			long postOrganizationId, long postId,
			OrderByComparator<PostOrganization> orderByComparator)
		throws NoSuchPostOrganizationException {

		PostOrganization postOrganization = findByPrimaryKey(
			postOrganizationId);

		Session session = null;

		try {
			session = openSession();

			PostOrganization[] array = new PostOrganizationImpl[3];

			array[0] = getByPostId_PrevAndNext(
				session, postOrganization, postId, orderByComparator, true);

			array[1] = postOrganization;

			array[2] = getByPostId_PrevAndNext(
				session, postOrganization, postId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PostOrganization getByPostId_PrevAndNext(
		Session session, PostOrganization postOrganization, long postId,
		OrderByComparator<PostOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_POSTORGANIZATION_WHERE);

		sb.append(_FINDER_COLUMN_POSTID_POSTID_2);

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
			sb.append(PostOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(postId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						postOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PostOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the post organizations where postId = &#63; from the database.
	 *
	 * @param postId the post ID
	 */
	@Override
	public void removeByPostId(long postId) {
		for (PostOrganization postOrganization :
				findByPostId(
					postId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(postOrganization);
		}
	}

	/**
	 * Returns the number of post organizations where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @return the number of matching post organizations
	 */
	@Override
	public int countByPostId(long postId) {
		FinderPath finderPath = _finderPathCountByPostId;

		Object[] finderArgs = new Object[] {postId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POSTORGANIZATION_WHERE);

			sb.append(_FINDER_COLUMN_POSTID_POSTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(postId);

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

	private static final String _FINDER_COLUMN_POSTID_POSTID_2 =
		"postOrganization.postId = ?";

	private FinderPath _finderPathWithPaginationFindByPostAndOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByPostAndOrganizationId;
	private FinderPath _finderPathCountByPostAndOrganizationId;

	/**
	 * Returns all the post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @return the matching post organizations
	 */
	@Override
	public List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId) {

		return findByPostAndOrganizationId(
			postId, organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @return the range of matching post organizations
	 */
	@Override
	public List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId, int start, int end) {

		return findByPostAndOrganizationId(
			postId, organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching post organizations
	 */
	@Override
	public List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId, int start, int end,
		OrderByComparator<PostOrganization> orderByComparator) {

		return findByPostAndOrganizationId(
			postId, organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching post organizations
	 */
	@Override
	public List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId, int start, int end,
		OrderByComparator<PostOrganization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByPostAndOrganizationId;
				finderArgs = new Object[] {postId, organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPostAndOrganizationId;
			finderArgs = new Object[] {
				postId, organizationId, start, end, orderByComparator
			};
		}

		List<PostOrganization> list = null;

		if (useFinderCache) {
			list = (List<PostOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PostOrganization postOrganization : list) {
					if ((postId != postOrganization.getPostId()) ||
						(organizationId !=
							postOrganization.getOrganizationId())) {

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

			sb.append(_SQL_SELECT_POSTORGANIZATION_WHERE);

			sb.append(_FINDER_COLUMN_POSTANDORGANIZATIONID_POSTID_2);

			sb.append(_FINDER_COLUMN_POSTANDORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PostOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(postId);

				queryPos.add(organizationId);

				list = (List<PostOrganization>)QueryUtil.list(
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
	 * Returns the first post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	@Override
	public PostOrganization findByPostAndOrganizationId_First(
			long postId, long organizationId,
			OrderByComparator<PostOrganization> orderByComparator)
		throws NoSuchPostOrganizationException {

		PostOrganization postOrganization = fetchByPostAndOrganizationId_First(
			postId, organizationId, orderByComparator);

		if (postOrganization != null) {
			return postOrganization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("postId=");
		sb.append(postId);

		sb.append(", organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchPostOrganizationException(sb.toString());
	}

	/**
	 * Returns the first post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	@Override
	public PostOrganization fetchByPostAndOrganizationId_First(
		long postId, long organizationId,
		OrderByComparator<PostOrganization> orderByComparator) {

		List<PostOrganization> list = findByPostAndOrganizationId(
			postId, organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	@Override
	public PostOrganization findByPostAndOrganizationId_Last(
			long postId, long organizationId,
			OrderByComparator<PostOrganization> orderByComparator)
		throws NoSuchPostOrganizationException {

		PostOrganization postOrganization = fetchByPostAndOrganizationId_Last(
			postId, organizationId, orderByComparator);

		if (postOrganization != null) {
			return postOrganization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("postId=");
		sb.append(postId);

		sb.append(", organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchPostOrganizationException(sb.toString());
	}

	/**
	 * Returns the last post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	@Override
	public PostOrganization fetchByPostAndOrganizationId_Last(
		long postId, long organizationId,
		OrderByComparator<PostOrganization> orderByComparator) {

		int count = countByPostAndOrganizationId(postId, organizationId);

		if (count == 0) {
			return null;
		}

		List<PostOrganization> list = findByPostAndOrganizationId(
			postId, organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the post organizations before and after the current post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postOrganizationId the primary key of the current post organization
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next post organization
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	@Override
	public PostOrganization[] findByPostAndOrganizationId_PrevAndNext(
			long postOrganizationId, long postId, long organizationId,
			OrderByComparator<PostOrganization> orderByComparator)
		throws NoSuchPostOrganizationException {

		PostOrganization postOrganization = findByPrimaryKey(
			postOrganizationId);

		Session session = null;

		try {
			session = openSession();

			PostOrganization[] array = new PostOrganizationImpl[3];

			array[0] = getByPostAndOrganizationId_PrevAndNext(
				session, postOrganization, postId, organizationId,
				orderByComparator, true);

			array[1] = postOrganization;

			array[2] = getByPostAndOrganizationId_PrevAndNext(
				session, postOrganization, postId, organizationId,
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

	protected PostOrganization getByPostAndOrganizationId_PrevAndNext(
		Session session, PostOrganization postOrganization, long postId,
		long organizationId,
		OrderByComparator<PostOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_POSTORGANIZATION_WHERE);

		sb.append(_FINDER_COLUMN_POSTANDORGANIZATIONID_POSTID_2);

		sb.append(_FINDER_COLUMN_POSTANDORGANIZATIONID_ORGANIZATIONID_2);

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
			sb.append(PostOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(postId);

		queryPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						postOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PostOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the post organizations where postId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByPostAndOrganizationId(
		long postId, long organizationId) {

		for (PostOrganization postOrganization :
				findByPostAndOrganizationId(
					postId, organizationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(postOrganization);
		}
	}

	/**
	 * Returns the number of post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @return the number of matching post organizations
	 */
	@Override
	public int countByPostAndOrganizationId(long postId, long organizationId) {
		FinderPath finderPath = _finderPathCountByPostAndOrganizationId;

		Object[] finderArgs = new Object[] {postId, organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_POSTORGANIZATION_WHERE);

			sb.append(_FINDER_COLUMN_POSTANDORGANIZATIONID_POSTID_2);

			sb.append(_FINDER_COLUMN_POSTANDORGANIZATIONID_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(postId);

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

	private static final String _FINDER_COLUMN_POSTANDORGANIZATIONID_POSTID_2 =
		"postOrganization.postId = ? AND ";

	private static final String
		_FINDER_COLUMN_POSTANDORGANIZATIONID_ORGANIZATIONID_2 =
			"postOrganization.organizationId = ?";

	public PostOrganizationPersistenceImpl() {
		setModelClass(PostOrganization.class);

		setModelImplClass(PostOrganizationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the post organization in the entity cache if it is enabled.
	 *
	 * @param postOrganization the post organization
	 */
	@Override
	public void cacheResult(PostOrganization postOrganization) {
		entityCache.putResult(
			PostOrganizationImpl.class, postOrganization.getPrimaryKey(),
			postOrganization);
	}

	/**
	 * Caches the post organizations in the entity cache if it is enabled.
	 *
	 * @param postOrganizations the post organizations
	 */
	@Override
	public void cacheResult(List<PostOrganization> postOrganizations) {
		for (PostOrganization postOrganization : postOrganizations) {
			if (entityCache.getResult(
					PostOrganizationImpl.class,
					postOrganization.getPrimaryKey()) == null) {

				cacheResult(postOrganization);
			}
		}
	}

	/**
	 * Clears the cache for all post organizations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PostOrganizationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the post organization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PostOrganization postOrganization) {
		entityCache.removeResult(PostOrganizationImpl.class, postOrganization);
	}

	@Override
	public void clearCache(List<PostOrganization> postOrganizations) {
		for (PostOrganization postOrganization : postOrganizations) {
			entityCache.removeResult(
				PostOrganizationImpl.class, postOrganization);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PostOrganizationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new post organization with the primary key. Does not add the post organization to the database.
	 *
	 * @param postOrganizationId the primary key for the new post organization
	 * @return the new post organization
	 */
	@Override
	public PostOrganization create(long postOrganizationId) {
		PostOrganization postOrganization = new PostOrganizationImpl();

		postOrganization.setNew(true);
		postOrganization.setPrimaryKey(postOrganizationId);

		postOrganization.setCompanyId(CompanyThreadLocal.getCompanyId());

		return postOrganization;
	}

	/**
	 * Removes the post organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization that was removed
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	@Override
	public PostOrganization remove(long postOrganizationId)
		throws NoSuchPostOrganizationException {

		return remove((Serializable)postOrganizationId);
	}

	/**
	 * Removes the post organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the post organization
	 * @return the post organization that was removed
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	@Override
	public PostOrganization remove(Serializable primaryKey)
		throws NoSuchPostOrganizationException {

		Session session = null;

		try {
			session = openSession();

			PostOrganization postOrganization = (PostOrganization)session.get(
				PostOrganizationImpl.class, primaryKey);

			if (postOrganization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPostOrganizationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(postOrganization);
		}
		catch (NoSuchPostOrganizationException noSuchEntityException) {
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
	protected PostOrganization removeImpl(PostOrganization postOrganization) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(postOrganization)) {
				postOrganization = (PostOrganization)session.get(
					PostOrganizationImpl.class,
					postOrganization.getPrimaryKeyObj());
			}

			if (postOrganization != null) {
				session.delete(postOrganization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (postOrganization != null) {
			clearCache(postOrganization);
		}

		return postOrganization;
	}

	@Override
	public PostOrganization updateImpl(PostOrganization postOrganization) {
		boolean isNew = postOrganization.isNew();

		if (!(postOrganization instanceof PostOrganizationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(postOrganization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					postOrganization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in postOrganization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PostOrganization implementation " +
					postOrganization.getClass());
		}

		PostOrganizationModelImpl postOrganizationModelImpl =
			(PostOrganizationModelImpl)postOrganization;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (postOrganization.getCreateDate() == null)) {
			if (serviceContext == null) {
				postOrganization.setCreateDate(now);
			}
			else {
				postOrganization.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!postOrganizationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				postOrganization.setModifiedDate(now);
			}
			else {
				postOrganization.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(postOrganization);
			}
			else {
				postOrganization = (PostOrganization)session.merge(
					postOrganization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PostOrganizationImpl.class, postOrganizationModelImpl, false, true);

		if (isNew) {
			postOrganization.setNew(false);
		}

		postOrganization.resetOriginalValues();

		return postOrganization;
	}

	/**
	 * Returns the post organization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the post organization
	 * @return the post organization
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	@Override
	public PostOrganization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPostOrganizationException {

		PostOrganization postOrganization = fetchByPrimaryKey(primaryKey);

		if (postOrganization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPostOrganizationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return postOrganization;
	}

	/**
	 * Returns the post organization with the primary key or throws a <code>NoSuchPostOrganizationException</code> if it could not be found.
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	@Override
	public PostOrganization findByPrimaryKey(long postOrganizationId)
		throws NoSuchPostOrganizationException {

		return findByPrimaryKey((Serializable)postOrganizationId);
	}

	/**
	 * Returns the post organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization, or <code>null</code> if a post organization with the primary key could not be found
	 */
	@Override
	public PostOrganization fetchByPrimaryKey(long postOrganizationId) {
		return fetchByPrimaryKey((Serializable)postOrganizationId);
	}

	/**
	 * Returns all the post organizations.
	 *
	 * @return the post organizations
	 */
	@Override
	public List<PostOrganization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the post organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @return the range of post organizations
	 */
	@Override
	public List<PostOrganization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the post organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of post organizations
	 */
	@Override
	public List<PostOrganization> findAll(
		int start, int end,
		OrderByComparator<PostOrganization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the post organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of post organizations
	 */
	@Override
	public List<PostOrganization> findAll(
		int start, int end,
		OrderByComparator<PostOrganization> orderByComparator,
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

		List<PostOrganization> list = null;

		if (useFinderCache) {
			list = (List<PostOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POSTORGANIZATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POSTORGANIZATION;

				sql = sql.concat(PostOrganizationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PostOrganization>)QueryUtil.list(
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
	 * Removes all the post organizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PostOrganization postOrganization : findAll()) {
			remove(postOrganization);
		}
	}

	/**
	 * Returns the number of post organizations.
	 *
	 * @return the number of post organizations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POSTORGANIZATION);

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
		return "postOrganizationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POSTORGANIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PostOrganizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the post organization persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PostOrganizationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PostOrganization.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByPostId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPostId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"postId"}, true);

		_finderPathWithoutPaginationFindByPostId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPostId",
			new String[] {Long.class.getName()}, new String[] {"postId"}, true);

		_finderPathCountByPostId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPostId",
			new String[] {Long.class.getName()}, new String[] {"postId"},
			false);

		_finderPathWithPaginationFindByPostAndOrganizationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByPostAndOrganizationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"postId", "organizationId"}, true);

		_finderPathWithoutPaginationFindByPostAndOrganizationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByPostAndOrganizationId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"postId", "organizationId"}, true);

		_finderPathCountByPostAndOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPostAndOrganizationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"postId", "organizationId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PostOrganizationImpl.class.getName());

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

	private static final String _SQL_SELECT_POSTORGANIZATION =
		"SELECT postOrganization FROM PostOrganization postOrganization";

	private static final String _SQL_SELECT_POSTORGANIZATION_WHERE =
		"SELECT postOrganization FROM PostOrganization postOrganization WHERE ";

	private static final String _SQL_COUNT_POSTORGANIZATION =
		"SELECT COUNT(postOrganization) FROM PostOrganization postOrganization";

	private static final String _SQL_COUNT_POSTORGANIZATION_WHERE =
		"SELECT COUNT(postOrganization) FROM PostOrganization postOrganization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "postOrganization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PostOrganization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PostOrganization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PostOrganizationPersistenceImpl.class);

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

	private static class PostOrganizationModelArgumentsResolver
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

			PostOrganizationModelImpl postOrganizationModelImpl =
				(PostOrganizationModelImpl)baseModel;

			long columnBitmask = postOrganizationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					postOrganizationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						postOrganizationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					postOrganizationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PostOrganizationModelImpl postOrganizationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						postOrganizationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = postOrganizationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}