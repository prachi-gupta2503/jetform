package com.adj.rsapi.application;

import com.adj.rsapi.application.EmployeeDetailsViewModel;
import com.liferay.portal.kernel.exception.PortalException;

public interface EmployeeDetailsHandler {
	public EmployeeDetailsViewModel getEmpByPersonalNo(String personalNo) throws PortalException;
	public EmployeeDetailsViewModel getEmpByEmpId(long employeeId) throws PortalException ;
}
