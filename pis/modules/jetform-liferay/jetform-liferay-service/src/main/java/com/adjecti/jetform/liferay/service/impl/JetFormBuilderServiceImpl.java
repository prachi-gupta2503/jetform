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

import com.adjecti.jetform.liferay.service.base.JetFormBuilderServiceBaseImpl;
import com.adjecti.jetform.model.KeyValue;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONArray;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the jet form builder remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.jetform.liferay.service.JetFormBuilderService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JetFormBuilderServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=jetform",
		"json.web.service.context.path=JetFormBuilder"
	},
	service = AopService.class
)
public class JetFormBuilderServiceImpl extends JetFormBuilderServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.adjecti.jetform.liferay.service.JetFormBuilderServiceUtil</code> to access the jet form builder remote service.
	 */
	
	public String saveForm(Map<String, Object> params) {
		return jetFormBuilderLocalService.saveForm(params);
	}
	
	
	public JSONArray readObjectsAsJson(Map<String, String> searchFilter) {
		return jetFormBuilderLocalService.readObjectsAsJson(searchFilter);
	}
	
	public KeyValue getRelationObjectAsKeyValue(String objectClassName, String objectClassPK, String keyField, String valueField) {
		return jetFormBuilderLocalService.readObjectAsKeyValue(objectClassName, objectClassPK, keyField, valueField);
	}
	
	public List<KeyValue> getListOptions(String entityClass, String searchField, String searchValue, String valueField,
			String labelField){
		return jetFormBuilderLocalService.getListOptions(entityClass, searchField, searchValue, valueField, labelField);
	}
	
	
	public String deleteEntity(String className, long id, boolean logical) {
		return jetFormBuilderLocalService.deleteEntity(className, id, logical);
	}
	
	public long approveEntity(String className, long classPK, long userId, String remark) {
		return jetFormBuilderLocalService.approveEntity(className,classPK,userId,remark);
	}
	
	public long rejectEntity(String className, long classPK, long userId, String remark) {
		return jetFormBuilderLocalService.rejectEntity(className,classPK,userId,remark);
	}
	
	public Map<String, String> importExcel(String formClass, long fileEntryId) {
		return jetFormBuilderLocalService.importExcel(formClass, fileEntryId);
	}
	
	public String unDeleteEntity(String className, long id) {
		return jetFormBuilderLocalService.unDeleteEntity(className, id);
	}
	
	public void generateForm(String formClass) throws ClassNotFoundException {
		jetFormBuilderLocalService.generateForm(formClass);
		
	}
	public boolean isUnique(String className, long id, String fieldName, String fieldValue) {
		return jetFormBuilderLocalService.isUnique(className,id,fieldName,fieldValue);
	}
	
		
}