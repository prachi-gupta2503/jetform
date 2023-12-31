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

import com.adjecti.mdm.liferay.service.base.DiseaseLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the disease local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.DiseaseLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DiseaseLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.mdm.liferay.model.Disease",
	service = AopService.class
)
public class DiseaseLocalServiceImpl extends DiseaseLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.mdm.liferay.service.DiseaseLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.mdm.liferay.service.DiseaseLocalServiceUtil</code>.
	 */
}