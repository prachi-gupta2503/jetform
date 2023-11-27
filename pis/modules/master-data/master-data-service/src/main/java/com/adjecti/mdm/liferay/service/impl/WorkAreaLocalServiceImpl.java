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

import com.adjecti.mdm.liferay.model.WorkArea;
import com.adjecti.mdm.liferay.service.base.WorkAreaLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the work area local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.WorkAreaLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.mdm.liferay.model.WorkArea",
	service = AopService.class
)
public class WorkAreaLocalServiceImpl extends WorkAreaLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.mdm.liferay.service.WorkAreaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.mdm.liferay.service.WorkAreaLocalServiceUtil</code>.
	 */
	
	private final static Log LOGGER = LogFactoryUtil.getLog(WorkAreaLocalServiceImpl.class.getName());
	
	
	public WorkArea addWorkArea(long workAreaId, long parentId, String name, long workAreaTypeId)
			throws PortalException {
		LOGGER.info("workArea Id :" + workAreaId);
		
		WorkArea workArea = null;
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		User user = userLocalService.getUser(serviceContext.getUserId());

		if (workAreaId != 0) {
			workArea = workAreaPersistence.findByPrimaryKey(workAreaId);
		}else {
			workAreaId = counterLocalService.increment(WorkArea.class.getName());
			workArea = workAreaPersistence.create(workAreaId);
		}
		
		workArea.setParentWorkAreaId(parentId);
		workArea.setName(name);
		workArea.setWorkAreaTypeId(workAreaTypeId);

		if(workArea.isNew()) {
			Date today=new Date();
			workArea.setUserId(user.getUserId());
			workArea.setCompanyId(user.getCompanyId());
			workArea.setUserName(user.getFullName());
			workArea.setGroupId(user.getGroupId());
			workArea.setCreateDate(today);
		}
		
		workArea = workAreaPersistence.update(workArea);

		return workArea;
	}

	public List<WorkArea> getWorkAreasByParentId(long parentId) {
		return workAreaPersistence.findByParentWorkAreaId(parentId);
	}
	
	public boolean hasChild(long workAreaId) {
		return workAreaLocalService.hasChild(workAreaId);
	}
}