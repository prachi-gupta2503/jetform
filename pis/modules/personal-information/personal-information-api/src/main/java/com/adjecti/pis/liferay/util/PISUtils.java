package com.adjecti.pis.liferay.util;

import com.adjecti.mdm.liferay.util.OrganizationUtils;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PISUtils {
	private static final String SECTION = "Section";

	public static List<Employee> searchEmployee(long unitId, long sectionId, long groupId, long tradeId, long gradeId,
			long designationId, boolean onDeputation, boolean retired, boolean onProbation) throws PortalException {

		if ((sectionId > 0 && unitId == 0) || (sectionId > 0 && unitId > 0)) {

			return getSearchedEmployees(sectionId, groupId, tradeId, gradeId, designationId);
		} else if (sectionId == 0 && unitId > 0) {

			return getSearchedEmployees(unitId, groupId, tradeId, gradeId, designationId);
		} else if (sectionId == 0 && unitId == 0) {
			Set<Employee> employees = new HashSet<Employee>();
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
			for (Organization org : user.getOrganizations()) {
				employees.addAll(
						getSearchedEmployees(org.getOrganizationId(), groupId, tradeId, gradeId, designationId));

			}
			return employees.stream().collect(Collectors.toList());
		}
		return null;
	}

	private static List<Employee> getSearchedEmployees(long organizationId, long groupId, long tradeId, long gradeId,
			long designationId) throws PortalException {

		Set<Employee> empList = new HashSet<Employee>();
		List<Organization> recursiveSubOrgs = OrganizationUtils
				.getRecursiveSubOrgsByParentOrg(OrganizationLocalServiceUtil.getOrganization(organizationId));
		for (Organization org : recursiveSubOrgs) {
			Organization orgType = OrganizationUtils.getOrgnizationByType(org.getOrganizationId(), SECTION);
			if (orgType != null) {
				empList.addAll(EmployeeLocalServiceUtil.getEmployeeByorgAndTradeAndGradeAndDesignationAndGroupId(
						org.getOrganizationId(), groupId, tradeId, gradeId, designationId));
			}
		}
		return empList.stream().collect(Collectors.toList());
	}
}