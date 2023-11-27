package com.adj.rsapi.application;

import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PostLocalServiceUtil;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeContactException;
import com.adjecti.pis.liferay.model.Contact;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeReporting;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.service.ContactLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeContactLocalServiceUtil;
import com.adj.rsapi.application.EmployeeDetailsViewModel;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
import com.adjecti.pis.liferay.service.persistence.EmployeeReportingUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component
public class EmployeeDetailsHandlerImpl implements EmployeeDetailsHandler {

	public EmployeeDetailsViewModel getEmpByPersonalNo(String personalNo) throws PortalException {
		Employee employee = EmployeeLocalServiceUtil.getEmployeeByPersonalNo(personalNo);
		if(employee ==null) {
			return null;
		}
		
		People people = PeopleLocalServiceUtil.getPeople(employee.getPeopleId());
		return getEmployeeDetails(employee, people);
	}

	public EmployeeDetailsViewModel getEmpByEmpId(long employeeId) throws PortalException {
		Employee employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
		if(employee ==null) {
			return null;
		}
		
		System.out.println(employee.getUserId());
		People people = PeopleLocalServiceUtil.getPeople(employee.getPeopleId());
		return getEmployeeDetails(employee, people);
	}

	public EmployeeDetailsViewModel getEmployeeDetails(Employee employee, People people)
			throws NoSuchEmployeeContactException, PortalException {
		
		EmployeeDetailsViewModel employeeViewModel = new EmployeeDetailsViewModel();
		employeeViewModel.setUserId(employee.getUserId());
	
		employeeViewModel.setPersonalNo(employee.getPersonalNo());
		employeeViewModel.setFullName(
				people.getFirstName_En() + " " + people.getMiddleName_En() + " " + people.getLastName_En());
		employeeViewModel
				.setDesignation(DesignationLocalServiceUtil.getDesignation(employee.getDesignationId()).getName_En());
		employeeViewModel.setPost(PostLocalServiceUtil.getPost(employee.getPostId()).getName_En());
			Organization organization = OrganizationLocalServiceUtil.getOrganization(employee.getOrganizationId());
		employeeViewModel.setUnit(organization.getName());
		List<Organization> organizations = organization.getAncestors();
		for (Organization org : organizations) {
			if (org.getType().equalsIgnoreCase("Section")) {
				employeeViewModel.setSection(org.getName());
			}
			if (org.getType().equalsIgnoreCase("Division")) {
				employeeViewModel.setDivision(org.getName());
			}
		}
		
		Contact contact = ContactLocalServiceUtil.getContact(EmployeeContactLocalServiceUtil.getEmployeeContactByEmployeeId(employee.getEmployeeId()).getContactId());
		employeeViewModel.setMobileNo(contact.getMobile());
		employeeViewModel.setEmailId(employee.getEmailId());
		
		List<EmployeeReporting> employeeReporting=EmployeeReportingUtil.findByEmployeeId(employee.getEmployeeId());
		People reporting=PeopleLocalServiceUtil.getPeople(EmployeeLocalServiceUtil.getEmployee(employeeReporting.get(0).getEmployeeId()).getPeopleId());
		employeeViewModel.setReportingLevel1(reporting.getFirstName_En()+" "+reporting.getMiddleName_En()+" "+reporting.getLastName_En());

		// employeeViewModel.setReportingLevel2(reportingLevel2);
		// employeeViewModel.setReportingLevel3(reportingLevel3);
		return employeeViewModel;

	}
}
