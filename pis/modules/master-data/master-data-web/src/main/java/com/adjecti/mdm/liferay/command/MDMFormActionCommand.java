package com.adjecti.mdm.liferay.command;

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.jetform.liferay.service.JetFormBuilderLocalService;
import com.adjecti.mdm.liferay.constants.MDMPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MDMPortletKeys.MDM,
		"mvc.command.name=saveForm" }, service = MVCActionCommand.class)
public class MDMFormActionCommand extends  BaseMVCActionCommand{
	private static final Log LOGGER = LogFactoryUtil.getLog(MDMFormActionCommand.class.getName());
	
	@Reference
	JetFormBuilderLocalService jetFormBuilderLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("LayoutSupportActionCommand.doProcessAction called");
		actionRequest.setAttribute("jetFormBuilderLocalService", jetFormBuilderLocalService);

		process(actionRequest, actionResponse);
		//String mvcPath=ParamUtil.get(actionRequest, "mvcPath", "");
		
	}
	
	void process(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
			String formClass = ParamUtil.getString(actionRequest, "formClass");
			String redirectPage = ParamUtil.getString(actionRequest, "redirectPage");
			//LOGGER.info("formClass : "+formClass);
			//Class entityClazz = BulkEmployee.class;
			/*Class formClazz=FormEntityCache.getFormClass(formClass);
			//LOGGER.info("formClazz : "+formClazz);
			Class entityClazz=formClazz;
			if(formClazz.isAnnotationPresent(HtmlForm.class)){
				HtmlForm formAnnotation=(HtmlForm) formClazz.getAnnotation(HtmlForm.class);
				if(formAnnotation.entityClass()!=Object.class) {
					entityClazz=formAnnotation.entityClass();
				}
			}*/
			Class formClazz=FormEntityCache.getFormClass(formClass);
			Object object = loadFormModel(actionRequest, formClazz);
			if(StringUtils.isNotEmpty(redirectPage)) {
				actionResponse.sendRedirect(redirectPage);
			}
			//FormFactoryUtil.saveObject((PersistedModel) object, formClazz);
		}catch(Exception e) {
			LOGGER.info(e);
		}
	}

	protected Object loadFormModel(ActionRequest actionRequest, Class entityClass)
			throws InstantiationException, IllegalAccessException {
		//LOGGER.info("loadFormModel");
		Map<String, String[]> paramMap = actionRequest.getParameterMap();
		return jetFormBuilderLocalService.saveObject(paramMap, entityClass);
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); Object model =
		 * entityClass.newInstance();
		 * 
		 * Method[] methods = entityClass.getMethods();
		 * LOGGER.info("loadFormModel methods: " + methods.length); Map<String, Method>
		 * setMethodMap = new HashMap<String, Method>(); for (Method method : methods) {
		 * String name = method.getName(); if (name.startsWith("set")) { name =
		 * name.substring("set".length()); LOGGER.info("parameter name : " + name);
		 * setMethodMap.put(name.toLowerCase(), method); } }
		 * 
		 * 
		 * 
		 * for (Map.Entry<String, String[]> paramEntry : paramMap.entrySet()) {
		 * LOGGER.info("paramEntry.getKey() : " + paramEntry.getKey()); Method method =
		 * setMethodMap.get(paramEntry.getKey().toLowerCase()); if (method != null) {
		 * try { String value = (paramEntry.getValue() != null &&
		 * paramEntry.getValue().length >= 1 ? paramEntry.getValue()[0] : null);
		 * LOGGER.info("paramEntry.getKey() : " + paramEntry.getKey() + " - value : " +
		 * value); if (value != null) {
		 * 
		 * Class[] paramType = method.getParameterTypes(); if (paramType.length > 0) {
		 * if (paramType[0] == int.class || paramType[0] == Integer.class) {
		 * method.invoke(model, Integer.parseInt(paramEntry.getValue()[0])); } else if
		 * (paramType[0] == long.class || paramType[0] == Long.class) {
		 * method.invoke(model, Long.parseLong(paramEntry.getValue()[0])); } else if
		 * (paramType[0] == float.class || paramType[0] == Float.class) {
		 * method.invoke(model, Float.parseFloat(paramEntry.getValue()[0])); } else if
		 * (paramType[0] == double.class || paramType[0] == Double.class) {
		 * method.invoke(model, Double.parseDouble(paramEntry.getValue()[0])); } else if
		 * (paramType[0] == boolean.class || paramType[0] == Boolean.class) {
		 * method.invoke(model, Boolean.parseBoolean(paramEntry.getValue()[0])); } else
		 * if (paramType[0] == Date.class) { method.invoke(model,
		 * dateFormat.parse(paramEntry.getValue()[0])); } else if (paramType[0] ==
		 * String.class) { method.invoke(model, paramEntry.getValue()[0]); } } } } catch
		 * (Exception e) { LOGGER.info(e.getCause() + "::::" + method.getName()); } } }
		 * return model;
		 */
	}
}
