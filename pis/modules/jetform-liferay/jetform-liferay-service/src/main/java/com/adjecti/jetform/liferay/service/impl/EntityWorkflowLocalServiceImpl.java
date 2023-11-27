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

package com.adjecti.jetform.liferay.service.impl;

import com.adjecti.jetform.liferay.model.EntityWorkflow;
import com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil;
import com.adjecti.jetform.liferay.service.base.EntityWorkflowLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the entity workflow local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.jetform.liferay.service.EntityWorkflowLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityWorkflowLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.jetform.liferay.model.EntityWorkflow",
	service = AopService.class
)
public class EntityWorkflowLocalServiceImpl
	extends EntityWorkflowLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.jetform.liferay.service.EntityWorkflowLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.jetform.liferay.service.EntityWorkflowLocalServiceUtil</code>.
	 */
	final static Log LOGGER = LogFactoryUtil.getLog(EntityWorkflowLocalServiceImpl.class.getName());

	public EntityWorkflow getEntityWorkflow(String className, long classPK) {
		try {
			List<EntityWorkflow> list=entityWorkflowPersistence.findByClassNameAndClassPK(className, classPK);
			return list.get(0);
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public boolean beforeUpdateEntityWorkflow(Object entity, Map<String, String[]> fieldValues) {
		
		try {
			
			Map<String, String[]> updateParams=new HashMap<String, String[]>();
			updateParams.put("status", fieldValues.get("status"));
			updateParams.put("primaryKey", fieldValues.get("classPK"));
			updateParams.put("formClass", fieldValues.get("className"));
			JetFormBuilderLocalServiceUtil.saveObject(updateParams, fieldValues.get("className")[0].trim());
			return true;
		}catch(Exception e) {
			LOGGER.error(e);
		}
		return false;
	}
}