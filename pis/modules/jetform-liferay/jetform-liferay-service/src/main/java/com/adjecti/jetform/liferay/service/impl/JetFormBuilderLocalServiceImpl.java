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

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElementWrapper;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormWrapper;
import com.adjecti.jetform.liferay.helper.JetFormAnnotationHelper;
import com.adjecti.jetform.liferay.helper.JetFormDataHelper;
import com.adjecti.jetform.liferay.helper.JetFormRendererHelper;
import com.adjecti.jetform.liferay.model.EntityWorkflow;
import com.adjecti.jetform.liferay.service.EntityWorkflowLocalServiceUtil;
import com.adjecti.jetform.liferay.service.base.JetFormBuilderLocalServiceBaseImpl;
import com.adjecti.jetform.liferay.util.JetFormDataUtil;
import com.adjecti.jetform.model.KeyValue;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ResourceLocalService;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 * The implementation of the jet form builder local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.jetform.liferay.service.JetFormBuilderLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JetFormBuilderLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adjecti.jetform.liferay.model.JetFormBuilder", service = AopService.class)
public class JetFormBuilderLocalServiceImpl extends JetFormBuilderLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.adjecti.liferay.core.service.FormFactoryLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.adjecti.liferay.core.service.FormFactoryLocalServiceUtil</code>.
	 */
	final static Log LOGGER = LogFactoryUtil.getLog(JetFormBuilderLocalServiceImpl.class.getName());

	final static DateFormat SOURCE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	final static DateFormat TARGET_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	// final static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	final static NumberFormat DECIMAL_NUMBER_FORMAT = new DecimalFormat("###,###,##0.00");
	final static NumberFormat INTEGER_NUMBER_FORMAT = new DecimalFormat("###,###,##0");
	static boolean developmentMode = false;

	@BeanReference(type = ResourceLocalService.class)
	private ResourceLocalService _resourceLocalService;

	public void generateForm(String formClass) throws ClassNotFoundException {
		LOGGER.info(formClass);
		annotationHelper.generateForm(formClass);
	}

	public HtmlFormWrapper rendererFormByFormFlowProcessId(String className, String formFlowProcessId)
			throws JSONException {
		return rendererHelper.rendererFormByFormFlowProcessId(className, formFlowProcessId);

	}

	public HtmlFormWrapper rendererForm(String className) throws JSONException, ClassNotFoundException {
		return rendererHelper.rendererForm(className);

	}

	public HtmlFormWrapper rendererForm(Class className) throws JSONException, ClassNotFoundException {
		return rendererHelper.rendererForm(className);

	}

	public HtmlFormWrapper rendererForm(String className, String formClassPK)
			throws JSONException, ClassNotFoundException {
		return rendererHelper.rendererForm(className, formClassPK);

	}

	public KeyValue getRelationObjectAsKeyValue(String formClassName, String objectClassName, String objectClassPK,
			String keyField, String valueField) {

		return dataHelper.getRelationObjectAsKeyValue(formClassName, objectClassName, objectClassPK, keyField,
				valueField);

	}

	public KeyValue getRelationObjectAsKeyValue(String objectClassName, String objectClassPK, String keyField,
			String valueField) {
		return dataHelper.getRelationObjectAsKeyValue(objectClassName, objectClassPK, keyField, valueField);
	}

	public KeyValue readObjectAsKeyValue(String objectClassName, String objectClassPK, String keyField,
			String valueField) {

		return dataHelper.readObjectAsKeyValue(objectClassName, objectClassPK, keyField, valueField);
	}

	public Object readObject(String objectClassName, String classPK) {
		return dataHelper.readObject(objectClassName, classPK);
	}

	public List<Object> findAll(String objectClass, String attributeName, String attributeValue) {
		return dataHelper.findAll(objectClass, attributeName, attributeValue);
	}

	public List<?> readObjects(String objectClass) {
		try {
			Class objectClazz = FormEntityCache.getFormClass(objectClass);
			return dataHelper.readObjects(objectClazz);
		} catch (Exception e) {
		}
		return null;
	}

	public JSONArray readObjectsAsJson(Map<String, String> searchFilter) {
		String objectClass = searchFilter.get("objectClass");
		HtmlFormWrapper childForm = null;
		HtmlFormWrapper form = null;
		try {
			form = rendererHelper.rendererForm(objectClass);
			List<HtmlElementWrapper> elements = form.getAllElements();
			for (HtmlElementWrapper element : elements) {
				if (element.isControlType(ControlType.form)) {

					childForm = rendererHelper.rendererForm(element.getFormClass());
					element.setChildForm(childForm);
				}

			}
		} catch (JSONException e) {

			e.printStackTrace();
		}

		return dataHelper.readObjectsAsJson(searchFilter, form);
	}

	public long saveObject(Map<String, String[]> paramMap, String entityClassName) {
		Class entityClass = FormEntityCache.getFormClass(entityClassName);
		return saveObject(paramMap, entityClass);
	}

	public long saveObject(Map<String, String[]> paramMap, Class entityClass) {
		try {
			HtmlFormWrapper form = rendererHelper.rendererForm(entityClass);
			return saveObject(paramMap, form.getEntityClass(), form.getKeyElement().getName());
		} catch (Exception e) {
			// LOGGER.info(e);
		}

		return 0;
	}

	public long saveObject(Map<String, String[]> paramMap, String entityClassName, String primaryKeyName)
			throws PortalException {
		try {
			Class entityClass = FormEntityCache.getFormClass(entityClassName);
			return dataHelper.saveObject(paramMap, entityClass, primaryKeyName);
		} catch (Exception e) {
			// LOGGER.info(e);
		}
		return 0;
	}

	private String generateFormId() {
		return HtmlForm.class.getSimpleName() + "-" + new Double(Math.random() * 9999999).intValue();
	}

	public List<KeyValue> getListOptions(String formClass, String elementName) {
		HtmlFormWrapper form = null;
		try {
			form = rendererHelper.rendererForm(formClass);
			return dataHelper.getListOptions(formClass, elementName, form);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<KeyValue> getListOptions(String entityClass, String searchField, String searchValue, String valueField,
			String labelField) {
		return dataHelper.getListOptions(entityClass, searchField, searchValue, valueField, labelField);
	}

	public List<KeyValue> getListOptions(Class entityClass, Map<String, String> filter, String valueField,
			String labelField) {
		return dataHelper.getListOptions(entityClass, filter, valueField, labelField);
	}

	public Map<String, String> importData(String formClass, File file) {
		HtmlFormWrapper form = null;
		try {
			form = rendererHelper.rendererForm(formClass);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return dataHelper.importData(formClass, file, form);
	}

	public String saveForm(Map<String, Object> params) {
		String namespace = (String) params.get("namespace");
		String formClassName = (String) params.get(namespace + "formClass");
		HtmlFormWrapper childForm = null;
		HtmlFormWrapper form = null;
		try {
			form = rendererHelper.rendererForm(formClassName);
			List<HtmlElementWrapper> elements = form.getAllElements();
			for (HtmlElementWrapper element : elements) {
				if (element.isControlType(ControlType.form)) {
					childForm = rendererHelper.rendererForm(element.getFormClass());
					element.setChildForm(childForm);
				}

			}
		} catch (JSONException e) {

			e.printStackTrace();
		}
		return dataHelper.saveForm(params, form);

	}

	public String deleteEntity(String className, long id, boolean logical) {

		return dataHelper.deleteEntity(className, id, logical);
	}

	public String unDeleteEntity(String className, long id) {

		return dataHelper.unDeleteEntity(className, id);
	}

	public Map<String, String> importExcel(String formClass, long fileEntryId) {
		HtmlFormWrapper form = null;
		try {
			form = rendererHelper.rendererForm(formClass);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return dataHelper.importExcel(formClass, fileEntryId, form);
	}

	public long approveEntity(String className, long classPK, long userId, String remark) {
		try {

			return dataHelper.approveEntity(className, classPK, userId, remark);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return 0;
	}

	public long rejectEntity(String className, long classPK, long userId, String remark) {
		try {

			return dataHelper.rejectEntity(className, classPK, userId, remark);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return 0;
	}

	public EntityWorkflow getEntityWorkflow(String className, long classPK) {
		return EntityWorkflowLocalServiceUtil.getEntityWorkflow(className, classPK);
	}

	public boolean isUnique(String className, long id, String fieldName, String fieldValue) {
		return dataHelper.isUnique(className, id, fieldName, fieldValue);
	}

	@Reference(cardinality = ReferenceCardinality.OPTIONAL)
	private JetFormAnnotationHelper annotationHelper;
	@Reference
	private JetFormRendererHelper rendererHelper;
	@Reference
	private JetFormDataHelper dataHelper;

}