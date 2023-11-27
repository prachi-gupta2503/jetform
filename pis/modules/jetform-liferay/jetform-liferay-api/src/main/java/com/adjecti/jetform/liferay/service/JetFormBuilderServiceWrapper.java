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

package com.adjecti.jetform.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JetFormBuilderService}.
 *
 * @author Brian Wing Shun Chan
 * @see JetFormBuilderService
 * @generated
 */
public class JetFormBuilderServiceWrapper
	implements JetFormBuilderService, ServiceWrapper<JetFormBuilderService> {

	public JetFormBuilderServiceWrapper(
		JetFormBuilderService jetFormBuilderService) {

		_jetFormBuilderService = jetFormBuilderService;
	}

	@Override
	public long approveEntity(
		String className, long classPK, long userId, String remark) {

		return _jetFormBuilderService.approveEntity(
			className, classPK, userId, remark);
	}

	@Override
	public String deleteEntity(String className, long id, boolean logical) {
		return _jetFormBuilderService.deleteEntity(className, id, logical);
	}

	@Override
	public void generateForm(String formClass) throws ClassNotFoundException {
		_jetFormBuilderService.generateForm(formClass);
	}

	@Override
	public java.util.List<com.adjecti.jetform.model.KeyValue> getListOptions(
		String entityClass, String searchField, String searchValue,
		String valueField, String labelField) {

		return _jetFormBuilderService.getListOptions(
			entityClass, searchField, searchValue, valueField, labelField);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jetFormBuilderService.getOSGiServiceIdentifier();
	}

	@Override
	public com.adjecti.jetform.model.KeyValue getRelationObjectAsKeyValue(
		String objectClassName, String objectClassPK, String keyField,
		String valueField) {

		return _jetFormBuilderService.getRelationObjectAsKeyValue(
			objectClassName, objectClassPK, keyField, valueField);
	}

	@Override
	public java.util.Map<String, String> importExcel(
		String formClass, long fileEntryId) {

		return _jetFormBuilderService.importExcel(formClass, fileEntryId);
	}

	@Override
	public boolean isUnique(
		String className, long id, String fieldName, String fieldValue) {

		return _jetFormBuilderService.isUnique(
			className, id, fieldName, fieldValue);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray readObjectsAsJson(
		java.util.Map<String, String> searchFilter) {

		return _jetFormBuilderService.readObjectsAsJson(searchFilter);
	}

	@Override
	public long rejectEntity(
		String className, long classPK, long userId, String remark) {

		return _jetFormBuilderService.rejectEntity(
			className, classPK, userId, remark);
	}

	@Override
	public String saveForm(java.util.Map<String, Object> params) {
		return _jetFormBuilderService.saveForm(params);
	}

	@Override
	public String unDeleteEntity(String className, long id) {
		return _jetFormBuilderService.unDeleteEntity(className, id);
	}

	@Override
	public JetFormBuilderService getWrappedService() {
		return _jetFormBuilderService;
	}

	@Override
	public void setWrappedService(JetFormBuilderService jetFormBuilderService) {
		_jetFormBuilderService = jetFormBuilderService;
	}

	private JetFormBuilderService _jetFormBuilderService;

}