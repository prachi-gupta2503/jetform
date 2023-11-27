package com.adjecti.pis.liferay.portlet.command;

import com.adjecti.pis.liferay.constants.MVCCommandNames;
import com.adjecti.pis.liferay.constants.PISMVCPortletKeys;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.util.PISUtils;
import com.adjecti.pis.liferay.web.helper.EmployeeDetailsHandler;
import com.adjecti.pis.liferay.web.model.EmployeeViewModel;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = { "javax.portlet.name=" + PISMVCPortletKeys.PISMVC,
		"mvc.command.name=" + MVCCommandNames.EMPLOYEE_SEARCH }, service = MVCActionCommand.class)
public class EmployeeSearchActionCommand extends BaseMVCActionCommand {
	@Reference
	private EmployeeDetailsHandler employeeDetailsHandler;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long unitId = ParamUtil.getLong(actionRequest, "unitId");
		long sectionId = ParamUtil.getLong(actionRequest, "selectionId");
		long groupId = ParamUtil.getLong(actionRequest, "groupId");
		long gradeId = ParamUtil.getLong(actionRequest, "gradeId");
		long tradeId = ParamUtil.getLong(actionRequest, "tradeId");
		long designationId = ParamUtil.getLong(actionRequest, "designationId");
		boolean onProbation = ParamUtil.getBoolean(actionRequest, "probationId");
		boolean onDeputation = ParamUtil.getBoolean(actionRequest, "deputationId");
		boolean retired = ParamUtil.getBoolean(actionRequest, "retiredId");

		String jspPage = ParamUtil.getString(actionRequest, "jspPage");
		
		List<Employee> employees = PISUtils.searchEmployee(unitId, sectionId, groupId, tradeId, gradeId, designationId,
				onDeputation, retired, onProbation);
		List<EmployeeViewModel> employeesViewModel = employeeDetailsHandler.convertEmployeeToEmployeeViewModel(employees);

		actionRequest.setAttribute("employees", employeesViewModel);
		// actionResponse.getRenderParameters().setValue("employees",
		// employees.toString());
		if(StringUtils.isNotEmpty(jspPage)) {
			actionResponse.getRenderParameters().setValue("jspPage", jspPage);
		}
	}

}
