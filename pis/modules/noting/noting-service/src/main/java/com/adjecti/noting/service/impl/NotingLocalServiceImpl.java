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

package com.adjecti.noting.service.impl;

import com.adjecti.noting.model.Noting;
import com.adjecti.noting.service.NotingLocalServiceUtil;
import com.adjecti.noting.service.base.NotingLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the noting local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.noting.service.NotingLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotingLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.noting.model.Noting",
	service = AopService.class
)
public class NotingLocalServiceImpl extends NotingLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.noting.service.NotingLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.noting.service.NotingLocalServiceUtil</code>.
	 */
	
	public Noting addNoting(String title, String content, long pdfId) throws PortalException {
		// TODO Auto-generated method stub
		System.out.println("==================");
		Noting noting = NotingLocalServiceUtil.createNoting(CounterLocalServiceUtil.increment(Noting.class.getName()));
		System.out.println("=================="+noting.getPrimaryKey());
		
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long userId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		Date createDate = serviceContext.getCreateDate();
		User user = userLocalService.getUser(userId);
		long groupId = user.getGroupId();
		
		noting.setUserId(userId);
		noting.setCompanyId(companyId);
		noting.setGroupId(groupId);
		noting.setCreateDate(createDate);
		noting.setModifiedDate(createDate);
		
		noting.setContent(content);
		noting.setPdfId(pdfId);
		noting.setTitle(title);
		
		return notingPersistence.update(noting);
	}
	
}