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

package com.adjecti.mdm.liferay.service.impl;

import com.adjecti.mdm.liferay.model.Post;
import com.adjecti.mdm.liferay.service.base.PostLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the post local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.PostLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.mdm.liferay.model.Post",
	service = AopService.class
)
public class PostLocalServiceImpl extends PostLocalServiceBaseImpl {

	@Override
	public Post addPost(String code, String name_En, String name_Hi, long designationId, boolean postBox,
			String description) throws PortalException {
		
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long postId = CounterLocalServiceUtil.increment(Post.class.getName());
		Post post = postPersistence.create(postId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		long groupId = serviceContext.getScopeGroup().getGroupId();
		long companyId = serviceContext.getCompanyId();
		post.setGroupId(groupId);
		post.setCompanyId(companyId);
		post.setUserId(userId);
		post.setUserName(user.getFullName());
		post.setCreateDate(serviceContext.getCreateDate());
		post.setModifiedDate(new Date());
		post.setCode(code);
		post.setName_En(name_En);
		post.setName_Hi(name_Hi);
		post.setDesignationId(designationId);
		post.setPostBox(postBox);
		post.setDescription(description);
		
		postPersistence.update(post);
		
		return post;
	}
	
	public void deletePostById(long postId) throws PortalException
	{
		Post post = postPersistence.findByPrimaryKey(postId);
		postPersistence.remove(post);
		resourceLocalService.deleteResource(
				post, ResourceConstants.SCOPE_INDIVIDUAL);
	}

	public Post updatePostData(long postId,String code, String name_En, String name_Hi, long designationId, boolean postBox,String description) throws PortalException
	{

		Post post = postPersistence.findByPrimaryKey(postId);
		post.setModifiedDate(new Date());
		post.setCode(code);
		post.setName_En(name_En);
		post.setName_Hi(name_Hi);
		post.setDesignationId(designationId);
		post.setPostBox(postBox);
		post.setDescription(description);
		postPersistence.update(post);
		return post;
	
	}

}