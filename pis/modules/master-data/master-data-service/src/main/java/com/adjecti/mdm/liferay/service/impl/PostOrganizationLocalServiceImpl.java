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

import com.adjecti.mdm.liferay.model.PostOrganization;
import com.adjecti.mdm.liferay.service.base.PostOrganizationLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the post organization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.PostOrganizationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostOrganizationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.mdm.liferay.model.PostOrganization",
	service = AopService.class
)
public class PostOrganizationLocalServiceImpl
	extends PostOrganizationLocalServiceBaseImpl {

	@Override
	public PostOrganization addPostOrganization(long postId,long organizationId,boolean postBox) throws PortalException
	{
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long postOrganizationId = CounterLocalServiceUtil.increment(PostOrganization.class.getName());
		PostOrganization postOrganization = postOrganizationPersistence.create(postOrganizationId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		postOrganization.setUserName(user.getFullName());
		postOrganization.setUserId(userId);
		postOrganization.setPostId(postId);
		postOrganization.setOrganizationId(organizationId);
		postOrganization.setPostBox(postBox);
		postOrganizationPersistence.update(postOrganization);
		
		return postOrganization;
	}
	public List<PostOrganization> getPostOrganizationsByPostId(long postId)
	{
		return 	postOrganizationPersistence.findByPostId(postId);	

	}
	
	public void deletePostOrganizationByPostId(long postId)
	{
		postOrganizationPersistence.removeByPostId(postId);
	}
	
	public PostOrganization updatePostOrganization(long postId,long[] orgIds,boolean postBox) throws PortalException
	{
		List<Long> orgIdList = Arrays.asList(ArrayUtils.toObject(orgIds));
		List<PostOrganization> postOrganizations = postOrganizationPersistence.findByPostId(postId);
		
		for(PostOrganization postOrg : postOrganizations) {
			if(!orgIdList.contains(postOrg.getOrganizationId())) {
				// remove code
				postOrganizationPersistence.remove(postOrg.getPostOrganizationId());
				
			}
		}
		for(long orgId : orgIds) {
			List<PostOrganization> po = postOrganizationPersistence.findByPostAndOrganizationId(postId,orgId);
			if(po.size() == 0) {
				addPostOrganization(postId, orgId, postBox);		
			} 
		}
		return null;
	}

}