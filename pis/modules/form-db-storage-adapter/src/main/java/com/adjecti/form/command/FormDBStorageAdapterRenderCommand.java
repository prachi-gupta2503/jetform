package com.adjecti.form.command;

import com.adjecti.form.constants.FormDbStorageAdapterPortletKeys;
import com.liferay.dynamic.data.mapping.form.renderer.DDMFormRenderer;
import com.liferay.dynamic.data.mapping.form.values.factory.DDMFormValuesFactory;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		 property = {
		 "javax.portlet.name="+FormDbStorageAdapterPortletKeys.FORMDBSTORAGEADAPTER,
		 "mvc.command.name=view_form"
		 },
		 service = MVCRenderCommand.class
)
public class FormDBStorageAdapterRenderCommand  implements MVCRenderCommand {
public final static String VIEW_FORM ="/view_form.jsp";
	
	@Reference
	DDMFormValuesFactory ddmFormValuesFactory;
	
	@Reference
	DDMFormRenderer _ddmFormRenderer;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long formInstanceRecordId = ParamUtil.getLong(renderRequest, "formInstanceId");

		renderRequest.setAttribute("formInstanceRecordId", formInstanceRecordId);

		return VIEW_FORM;
	}
}
