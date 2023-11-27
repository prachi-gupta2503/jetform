package com.adjecti.form.portlet;

import com.adjecti.form.constants.FormDbStorageAdapterPortletKeys;
import com.liferay.dynamic.data.mapping.form.values.factory.DDMFormValuesFactory;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.model.DDMStructureVersion;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalService;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author adj_2
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.adjecti",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FormDbStorageAdapter",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FormDbStorageAdapterPortletKeys.FORMDBSTORAGEADAPTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FormDbStorageAdapterPortlet extends MVCPortlet {
	
	@Reference
	DDMStructureLocalService ddmStructureLocalService;
	
	@Reference
	DDMFormInstanceLocalService ddmFormInstanceLocalService;
	
	@Reference
	DDMFormValuesFactory _ddmFormValuesFactory;
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<DDMFormInstance> ddmFormInstances = ddmFormInstanceLocalService.getDDMFormInstances(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		Map<Long, String> formMap = ddmFormInstances.stream()
			      .collect(Collectors.toMap(DDMFormInstance::getFormInstanceId, DDMFormInstance::getName));
		
		renderRequest.setAttribute("formMap", formMap);
		
		super.doView(renderRequest, renderResponse);
	}
	
	public void addFormData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		// TODO add own submit actions

		ServiceContext serviceContext = null;
        long formInstanceRecordId = ParamUtil.getLong(actionRequest, "formInstanceRecordId");

        System.out.println("============================================================"+formInstanceRecordId);
        DDMFormInstance ddmFormInstance =  DDMFormInstanceLocalServiceUtil.fetchDDMFormInstance(formInstanceRecordId);
        DDMStructureVersion ddmStructureVersion = null;
        try {
            ddmStructureVersion = ddmFormInstance.getStructure().getLatestStructureVersion();
        } catch (PortalException e) {
            e.printStackTrace();
        }
        
        DDMForm ddmForm = ddmStructureVersion.getDDMForm();
        DDMFormValues ddmFormValues = _ddmFormValuesFactory.create(actionRequest, ddmForm);

        try {
            serviceContext = ServiceContextFactory.getInstance(
                DDMFormInstanceRecord.class.getName(), actionRequest);
        } catch (PortalException e) {
            e.printStackTrace();
        }
                    
        if(formInstanceRecordId > 0) {
            try {
                DDMFormInstanceRecordLocalServiceUtil.updateFormInstanceRecord(serviceContext.getUserId(), formInstanceRecordId, Boolean.FALSE,
                        ddmFormValues, serviceContext);
            } catch (PortalException e) {
                e.printStackTrace();
            }
        }else {
            try {
                DDMFormInstanceRecordLocalServiceUtil.addFormInstanceRecord(serviceContext.getUserId(), serviceContext.getScopeGroupId(),
                        ddmFormInstance.getFormInstanceId(), ddmFormValues,
                        serviceContext);
            } catch (PortalException e) {
                e.printStackTrace();
            }
        }
		
	}
}