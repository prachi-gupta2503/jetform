package com.adjecti.jetform.liferay.helper.impl;

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.common.util.JetFormResourceCache;
import com.adjecti.jetform.annotation.HtmlElementGroupWrapper;
import com.adjecti.jetform.annotation.HtmlElementWrapper;
import com.adjecti.jetform.annotation.HtmlFormWrapper;
import com.adjecti.jetform.liferay.helper.JetFormDataHelper;
import com.adjecti.jetform.liferay.helper.JetFormRendererHelper;
import com.adjecti.jetform.liferay.util.JetFormDataUtil;
import com.adjecti.jetform.liferay.util.JetFormUtil;
import com.adjecti.jetform.model.KeyValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = JetFormRendererHelper.class)

public class JetFormRendererHelperImpl implements JetFormRendererHelper {

	final static Log LOGGER = LogFactoryUtil.getLog(JetFormRendererHelperImpl.class.getName());

	@Override
	public HtmlFormWrapper rendererForm(Class<?> className) throws JSONException {
		return rendererForm(className.getName());

	}

	@Override
	public HtmlFormWrapper rendererForm(String className) throws JSONException {

		HtmlFormWrapper htmlFormWrapper = null;
		ObjectMapper objectMapper = new ObjectMapper();
		String formDefinationPath = PropsUtil.get("jetform.formDefinition.location");

		try {
			String filePath = JetFormResourceCache.getFilePath(formDefinationPath + "/" + className + ".json");

			htmlFormWrapper = objectMapper.readValue(new File(filePath), HtmlFormWrapper.class);

			List<HtmlElementWrapper> elements = getHtmlElements(htmlFormWrapper.getElements());
			List<HtmlElementGroupWrapper> elementGroups = getHtmlGroupElements(htmlFormWrapper.getElementGroups());

			htmlFormWrapper.setElements(elements);
			htmlFormWrapper.setElementGroups(elementGroups);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return htmlFormWrapper;
	}

	@Override
	public HtmlFormWrapper rendererForm(String className, String formClassPK) throws JSONException {
		Class entClass = FormEntityCache.getFormClass(className);

		HtmlFormWrapper form = rendererForm(className);
		Map<String, Object> relationEntities = new HashMap<String, Object>();
		Object model = JetFormDataUtil.getEntity(form, formClassPK);
		JetFormDataUtil.getRelationObjects(relationEntities, null, entClass, model, true);
		form.setEntity(model);
		form.setRelationEntities(relationEntities);
		form.setPrimaryKey(formClassPK);

		JetFormUtil.validate();
		return form;

	}

	@Override
	public HtmlFormWrapper rendererFormByFormFlowProcessId(String className, String formFlowProcessId)
			throws JSONException {
		HtmlFormWrapper form = null;
		try {
			form = rendererForm(className);
			Class entClass = FormEntityCache.getFormClass(form.getEntityClass());
			if (StringUtils.isNotBlank(formFlowProcessId) && !formFlowProcessId.trim().equals("0")) {
				Object model = null;
				if (form.isFormFlowProcess()) {
					LOGGER.info("form.isFormFlowProcess() == form.getEntityClass() : " + form.getEntityClass()
							+ ", formFlowProcessId : " + formFlowProcessId);
					model = JetFormDataUtil.readObject(form.getEntityClass(), formFlowProcessId);
				} else if (form.getFormFlowKeyElement() != null) {
					LOGGER.info("form.getFormFlowKeyElement() : " + form.getFormFlowKeyElement().getName()
							+ ",  form.getEntityClass() : " + form.getEntityClass() + ", formFlowProcessId : "
							+ formFlowProcessId);
					model = jetFormDataHelper.findFirst(form.getEntityClass(), form.getFormFlowKeyElement().getName(),
							formFlowProcessId);
				}
				if (model != null) {
					form.setEntity(model);
					form.setPrimaryKey(JetFormDataUtil.getPrimaryKeyValue(entClass, model));

					Map<String, Object> relationEntities = new HashMap<String, Object>();
					JetFormDataUtil.getRelationObjects(relationEntities, null, entClass, model, true);

					form.setRelationEntities(relationEntities);
				}
			}
			JetFormUtil.validate();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return form;
	}

	private List<HtmlElementWrapper> getHtmlElements(List<HtmlElementWrapper> elements) {
		for (HtmlElementWrapper element : elements) {
			if (element.getRelation() != null && !element.getRelation().isNon()) {
				if (StringUtils.isEmpty(element.getDepends())) {
					List<KeyValue> listOptions = JetFormDataUtil.getListOptions(element.getRelation());
					element.setListOptions(listOptions);

				}
			}

		}
		return elements;
	}

	private List<HtmlElementGroupWrapper> getHtmlGroupElements(List<HtmlElementGroupWrapper> groupElements) {
		for (HtmlElementGroupWrapper groupElement : groupElements) {
			List<HtmlElementWrapper> elements = getHtmlElements(groupElement.getElements());
			groupElement.setElements(elements);
		}

		return groupElements;
	}

	@Reference
	JetFormDataHelper jetFormDataHelper;
}