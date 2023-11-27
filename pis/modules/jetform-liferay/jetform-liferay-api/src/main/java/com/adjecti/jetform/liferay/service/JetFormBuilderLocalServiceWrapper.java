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
 * Provides a wrapper for {@link JetFormBuilderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JetFormBuilderLocalService
 * @generated
 */
public class JetFormBuilderLocalServiceWrapper
	implements JetFormBuilderLocalService,
			   ServiceWrapper<JetFormBuilderLocalService> {

	public JetFormBuilderLocalServiceWrapper(
		JetFormBuilderLocalService jetFormBuilderLocalService) {

		_jetFormBuilderLocalService = jetFormBuilderLocalService;
	}

	@Override
	public long approveEntity(
		String className, long classPK, long userId, String remark) {

		return _jetFormBuilderLocalService.approveEntity(
			className, classPK, userId, remark);
	}

	@Override
	public String deleteEntity(String className, long id, boolean logical) {
		return _jetFormBuilderLocalService.deleteEntity(className, id, logical);
	}

	@Override
	public java.util.List<Object> findAll(
		String objectClass, String attributeName, String attributeValue) {

		return _jetFormBuilderLocalService.findAll(
			objectClass, attributeName, attributeValue);
	}

	@Override
	public void generateForm(String formClass) throws ClassNotFoundException {
		_jetFormBuilderLocalService.generateForm(formClass);
	}

	@Override
	public com.adjecti.jetform.liferay.model.EntityWorkflow getEntityWorkflow(
		String className, long classPK) {

		return _jetFormBuilderLocalService.getEntityWorkflow(
			className, classPK);
	}

	@Override
	public java.util.List<com.adjecti.jetform.model.KeyValue> getListOptions(
		Class entityClass, java.util.Map<String, String> filter,
		String valueField, String labelField) {

		return _jetFormBuilderLocalService.getListOptions(
			entityClass, filter, valueField, labelField);
	}

	@Override
	public java.util.List<com.adjecti.jetform.model.KeyValue> getListOptions(
		String formClass, String elementName) {

		return _jetFormBuilderLocalService.getListOptions(
			formClass, elementName);
	}

	@Override
	public java.util.List<com.adjecti.jetform.model.KeyValue> getListOptions(
		String entityClass, String searchField, String searchValue,
		String valueField, String labelField) {

		return _jetFormBuilderLocalService.getListOptions(
			entityClass, searchField, searchValue, valueField, labelField);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jetFormBuilderLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.adjecti.jetform.model.KeyValue getRelationObjectAsKeyValue(
		String objectClassName, String objectClassPK, String keyField,
		String valueField) {

		return _jetFormBuilderLocalService.getRelationObjectAsKeyValue(
			objectClassName, objectClassPK, keyField, valueField);
	}

	@Override
	public com.adjecti.jetform.model.KeyValue getRelationObjectAsKeyValue(
		String formClassName, String objectClassName, String objectClassPK,
		String keyField, String valueField) {

		return _jetFormBuilderLocalService.getRelationObjectAsKeyValue(
			formClassName, objectClassName, objectClassPK, keyField,
			valueField);
	}

	@Override
	public java.util.Map<String, String> importData(
		String formClass, java.io.File file) {

		return _jetFormBuilderLocalService.importData(formClass, file);
	}

	@Override
	public java.util.Map<String, String> importExcel(
		String formClass, long fileEntryId) {

		return _jetFormBuilderLocalService.importExcel(formClass, fileEntryId);
	}

	@Override
	public boolean isUnique(
		String className, long id, String fieldName, String fieldValue) {

		return _jetFormBuilderLocalService.isUnique(
			className, id, fieldName, fieldValue);
	}

	@Override
	public Object readObject(String objectClassName, String classPK) {
		return _jetFormBuilderLocalService.readObject(objectClassName, classPK);
	}

	@Override
	public com.adjecti.jetform.model.KeyValue readObjectAsKeyValue(
		String objectClassName, String objectClassPK, String keyField,
		String valueField) {

		return _jetFormBuilderLocalService.readObjectAsKeyValue(
			objectClassName, objectClassPK, keyField, valueField);
	}

	@Override
	public java.util.List<?> readObjects(String objectClass) {
		return _jetFormBuilderLocalService.readObjects(objectClass);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray readObjectsAsJson(
		java.util.Map<String, String> searchFilter) {

		return _jetFormBuilderLocalService.readObjectsAsJson(searchFilter);
	}

	@Override
	public long rejectEntity(
		String className, long classPK, long userId, String remark) {

		return _jetFormBuilderLocalService.rejectEntity(
			className, classPK, userId, remark);
	}

	@Override
	public com.adjecti.jetform.annotation.HtmlFormWrapper rendererForm(
			Class className)
		throws ClassNotFoundException,
			   com.liferay.portal.kernel.json.JSONException {

		return _jetFormBuilderLocalService.rendererForm(className);
	}

	@Override
	public com.adjecti.jetform.annotation.HtmlFormWrapper rendererForm(
			String className)
		throws ClassNotFoundException,
			   com.liferay.portal.kernel.json.JSONException {

		return _jetFormBuilderLocalService.rendererForm(className);
	}

	@Override
	public com.adjecti.jetform.annotation.HtmlFormWrapper rendererForm(
			String className, String formClassPK)
		throws ClassNotFoundException,
			   com.liferay.portal.kernel.json.JSONException {

		return _jetFormBuilderLocalService.rendererForm(className, formClassPK);
	}

	@Override
	public com.adjecti.jetform.annotation.HtmlFormWrapper
			rendererFormByFormFlowProcessId(
				String className, String formFlowProcessId)
		throws com.liferay.portal.kernel.json.JSONException {

		return _jetFormBuilderLocalService.rendererFormByFormFlowProcessId(
			className, formFlowProcessId);
	}

	@Override
	public String saveForm(java.util.Map<String, Object> params) {
		return _jetFormBuilderLocalService.saveForm(params);
	}

	@Override
	public long saveObject(
		java.util.Map<String, String[]> paramMap, Class entityClass) {

		return _jetFormBuilderLocalService.saveObject(paramMap, entityClass);
	}

	@Override
	public long saveObject(
		java.util.Map<String, String[]> paramMap, String entityClassName) {

		return _jetFormBuilderLocalService.saveObject(
			paramMap, entityClassName);
	}

	@Override
	public long saveObject(
			java.util.Map<String, String[]> paramMap, String entityClassName,
			String primaryKeyName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jetFormBuilderLocalService.saveObject(
			paramMap, entityClassName, primaryKeyName);
	}

	@Override
	public String unDeleteEntity(String className, long id) {
		return _jetFormBuilderLocalService.unDeleteEntity(className, id);
	}

	@Override
	public JetFormBuilderLocalService getWrappedService() {
		return _jetFormBuilderLocalService;
	}

	@Override
	public void setWrappedService(
		JetFormBuilderLocalService jetFormBuilderLocalService) {

		_jetFormBuilderLocalService = jetFormBuilderLocalService;
	}

	private JetFormBuilderLocalService _jetFormBuilderLocalService;

}