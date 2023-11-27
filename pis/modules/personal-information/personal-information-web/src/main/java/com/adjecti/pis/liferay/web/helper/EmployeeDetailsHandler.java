package com.adjecti.pis.liferay.web.helper;

import com.adjecti.pis.liferay.exception.NoSuchEmployeeContactException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.web.model.AddressListViewModel;
import com.adjecti.pis.liferay.web.model.AddressViewModel;
import com.adjecti.pis.liferay.web.model.ContactViewModel;
import com.adjecti.pis.liferay.web.model.EmployeeDetailsData;
import com.adjecti.pis.liferay.web.model.EmployeeViewModel;
import com.adjecti.pis.liferay.web.model.OfficialViewModel;
import com.adjecti.pis.liferay.web.model.PersonalViewModel;
import com.adjecti.pis.liferay.web.model.QualificationViewModel;
import com.adjecti.pis.liferay.web.model.UserViewModel;
import com.adjecti.pis.liferay.web.model.WorkstationViewModel;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

public interface EmployeeDetailsHandler {
	public EmployeeDetailsData getEmployeeAllDetails(long employeeId)throws PortalException;
	public UserViewModel getUser(Employee employee,People people) throws PortalException;
	public OfficialViewModel getOfficial(Employee employee) throws PortalException ;
	public PersonalViewModel getPersonal(People people) throws PortalException;
	public List<EmployeeViewModel> getAllEmployee() throws PortalException;
	public QualificationViewModel getQualification(Employee employee) throws PortalException;
	public AddressViewModel getAddress(Employee employee) throws PortalException;
	public ContactViewModel getContact(Employee employee) throws PortalException;
	public WorkstationViewModel getWorkstation(Employee employee) throws NoSuchEmployeeContactException;
	public List<AddressListViewModel> getAllAddressList(Employee employee);
	public String getOrgnizationByType(long organizationId, String orgType);
	public List<EmployeeViewModel> convertEmployeeToEmployeeViewModel(List<Employee> employees)throws PortalException;
	public EmployeeViewModel convertEmployeeToEmployeeViewModel(Employee employee) throws PortalException;
}