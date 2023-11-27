package com.adjecti.pis.liferay.portlet.command;

import com.adjecti.pis.liferay.constants.PISMVCPortletKeys;
import com.adjecti.pis.liferay.web.helper.EmployeeDetailsHandler;
import com.adjecti.pis.liferay.web.model.EmployeeDetailsData;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = { "javax.portlet.name=" + PISMVCPortletKeys.PISMVC,
		"mvc.command.name=" + PISMVCPortletKeys.EMPLOYEE_LIST,
		"mvc.command.name=" + PISMVCPortletKeys.EMPLOYEE_PROFILE, }, service = MVCRenderCommand.class)
public class EmployeeViewRenderCommand implements MVCRenderCommand {
	final static Log LOGGER = LogFactoryUtil.getLog(EmployeeViewRenderCommand.class.getName());
	final static String EMPLOYEE_LIST = "/employee/employee_list.jsp";
	//final static String EMPLOYEE_PROFILE = "/employee/profile/employee_profile.jsp";
	final static String EMPLOYEE_PROFILE = "/employee/employee_profile.jsp";
	final static String ERROR = "/error.jsp";
	@Reference
	private EmployeeDetailsHandler employeeDetailsHandler;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("render(RenderRequest renderRequest, RenderResponse renderResponse)");
		long employeeId = ParamUtil.getLong(renderRequest, "employeeId", 0);
		
		LOGGER.info("employeeId : "+employeeId);
		if (employeeId > 0) {
			try {

				EmployeeDetailsData detailsData = employeeDetailsHandler.getEmployeeAllDetails(employeeId);

				renderRequest.setAttribute("userVM", detailsData.getUserViewModel());
				renderRequest.setAttribute("officialVM", detailsData.getOfficialViewModel());
				renderRequest.setAttribute("personalVM", detailsData.getPersonalViewModel());
				renderRequest.setAttribute("qualificationVM", detailsData.getQualificationViewModel());
				renderRequest.setAttribute("addressVM", detailsData.getAddressViewModel());
				renderRequest.setAttribute("contactVM", detailsData.getContactViewModel());
				renderRequest.setAttribute("workstationVM", detailsData.getWorkstationViewModel());
				renderRequest.setAttribute("addressListVM", detailsData.getAddressListViewModels());
				return EMPLOYEE_PROFILE;
			} catch (PortalException e) {
				LOGGER.info(e);
			}
		} else {
			try {
				renderRequest.setAttribute("employees", employeeDetailsHandler.getAllEmployee());
				return EMPLOYEE_LIST;
			} catch (PortalException e) {
				LOGGER.info(e);
			}
		}
		return ERROR;
	}
}
