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

package com.adjecti.pis.liferay.service.impl;

import com.adjecti.mdm.liferay.model.Post;
import com.adjecti.mdm.liferay.model.PostOrganization;
import com.adjecti.mdm.liferay.service.PostLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PostOrganizationLocalServiceUtil;
import com.adjecti.pis.liferay.model.EmployeePost;
import com.adjecti.pis.liferay.service.base.EmployeePostServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee post remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeePostService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePostServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=pis",
		"json.web.service.context.path=EmployeePost" }, service = AopService.class)
public class EmployeePostServiceImpl extends EmployeePostServiceBaseImpl {

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getByEmployeeId(long employeeId) {
		List<EmployeePost> empPosts = employeePostLocalService.getByEmployeeId(employeeId);
		return toJSONArray(empPosts);
		
	}
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getByPersonalNo(String personalNo) {
		List<EmployeePost> empPosts = employeePostLocalService.getByPersonalNo(personalNo);
		return toJSONArray(empPosts);
	}
	
	private JSONArray toJSONArray(List<EmployeePost> employeePosts) {
		JSONArray result=JSONFactoryUtil.createJSONArray();
		for(EmployeePost ep:employeePosts) {
			try {
				Post p=PostLocalServiceUtil.getPost(ep.getPostId());
				Post dp=PostLocalServiceUtil.getPost(ep.getDelegatedPostId());
				List<PostOrganization> pos=PostOrganizationLocalServiceUtil.getPostOrganizationsByPostId(ep.getPostId());
				JSONObject json=JSONFactoryUtil.createJSONObject();
				json.put("employeePostId", ep.getEmployeePostId());
				json.put("postId", p.getPostId());
				json.put("postName_En", p.getName_En());
				json.put("postName_Hi", p.getName_Hi());
				json.put("delegatedPostId", dp.getPostId());
				json.put("delegatedPostName_En", dp.getName_En());
				json.put("delegatedPostName_Hi", dp.getName_Hi());
				json.put("fromDate", ep.getFromDate());
				json.put("toDate", ep.getToDate());
				
				JSONArray orgJSONArray=JSONFactoryUtil.createJSONArray();
				for(PostOrganization po:pos) {
					JSONObject jsonPo=JSONFactoryUtil.createJSONObject();
					Organization org=OrganizationLocalServiceUtil.getOrganization(po.getOrganizationId());
					jsonPo.put("organizationId", po.getOrganizationId());
					jsonPo.put("organizationName",org.getName());
					jsonPo.put("postBox",po.isPostBox());
					orgJSONArray.put(jsonPo);
				}
				json.put("organizations", orgJSONArray);
				result.put(json);
				
			}catch(Exception e) {};
		}
		return result;
	}

}