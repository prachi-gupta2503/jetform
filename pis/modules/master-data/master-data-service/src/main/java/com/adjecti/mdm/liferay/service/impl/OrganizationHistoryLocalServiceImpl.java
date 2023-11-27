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

import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.OrganizationHistory;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.mdm.liferay.service.base.OrganizationHistoryLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the organization history local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.OrganizationHistoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationHistoryLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.adjecti.mdm.liferay.model.OrganizationHistory",
		service = AopService.class
		)
public class OrganizationHistoryLocalServiceImpl
extends OrganizationHistoryLocalServiceBaseImpl {

	public List<OrganizationHistory> saveSplitOrganizationHistory(List<Long> organizationIds,long originalSectionId ,String status ) throws PortalException ,PortalException{
		if(organizationIds.isEmpty())
			return null;
		OrganizationDetail organizationDetail=null;
		organizationDetail = OrganizationDetailLocalServiceUtil.getOrganizationDetail(originalSectionId);
		OrganizationDetail parentOrganizationDetail = OrganizationDetailLocalServiceUtil.getOrganizationDetail(organizationDetail.getParentId());
		List<OrganizationHistory> histories=new ArrayList<OrganizationHistory>();
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		for (Long organizationId : organizationIds) {
			
			long organizationHistoryId = counterLocalService.increment(OrganizationHistory.class.getName());
			OrganizationHistory organizationHistory = organizationHistoryLocalService.createOrganizationHistory(organizationHistoryId);

			organizationHistory.setOrganizationHistoryId(organizationHistoryId);
			organizationHistory.setUserId(userId);
			organizationHistory.setUserName(user.getFullName());
			organizationHistory.setCompanyId(companyId);
			organizationHistory.setGroupId(groupId);

			OrganizationDetail currentOrganizationDetail = OrganizationDetailLocalServiceUtil.getOrganizationDetail(organizationId);

			organizationHistory.setOrganizationId(organizationId);
			organizationHistory.setOrganizationName(currentOrganizationDetail.getShortName());

			organizationHistory.setPreviousOrganizationId(organizationDetail.getOrganizationDetailId());
			organizationHistory.setPreviousOrganizationName(organizationDetail.getShortName());
			organizationHistory.setPreviousParentOrganizationId(organizationDetail.getParentId());
			organizationHistory.setPreviousParentOrganizationName(parentOrganizationDetail.getShortName());
			organizationHistory.setStatus(status);

			organizationHistory = organizationHistoryPersistence.update(organizationHistory);
			histories.add(organizationHistory);
		}
		return histories;
	}
	
	public List<OrganizationHistory> getByPreviousOrganizationId(long organizationId){
		return organizationHistoryPersistence.findByPreviousOrganizationId(organizationId);
	}
}