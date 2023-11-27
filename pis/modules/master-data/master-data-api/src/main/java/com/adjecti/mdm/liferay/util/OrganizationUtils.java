package com.adjecti.mdm.liferay.util;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrganizationUtils {

	public static final String ORGANIZATION_TYPE = "Organization type";
	public static final String CUSTOM_FIELDS = "CUSTOM_FIELDS";

	public static List<Organization> getRecursiveSubOrganizationsByUser(User user) throws PortalException {

		Set<Organization> subOrgs = new HashSet<Organization>();
		;
		for (Organization org : user.getOrganizations()) {
			subOrgs.addAll(getRecursiveSubOrgsByParentOrg(org));
		}
		return subOrgs.stream().collect(Collectors.toList());

	}

	public static List<Organization> getRecursiveSubOrgsByParentOrg(Organization organization) {
		Set<Organization> subOrganizations = new HashSet<Organization>();
		return getChildOrganizations(organization, subOrganizations).stream().collect(Collectors.toList());
	}

	private static Set<Organization> getChildOrganizations(Organization organization,
			Set<Organization> subOrganizations) {
		subOrganizations.add(organization);
		if (organization.getSuborganizationsSize() > 0) {
			for (Organization org : organization.getSuborganizations()) {
				subOrganizations.add(org);
				getChildOrganizations(org, subOrganizations);
			}
		} else {
			subOrganizations.add(organization);
		}
		return subOrganizations;
	}

	public static Organization getOrgnizationByType(long organizationId, String orgType) {

		try {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);

			if (expandoValueIsSame(organization, orgType)) {
				return organization;
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	private static boolean expandoValueIsSame(Organization organization, String str) {
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(Organization.class.getName());
		try {
			ExpandoTable expandoTableData = ExpandoTableLocalServiceUtil.getTable(organization.getCompanyId(),
					classNameId, CUSTOM_FIELDS);
			ExpandoColumn expandoColumnData = ExpandoColumnLocalServiceUtil.getColumn(organization.getCompanyId(),
					classNameId, expandoTableData.getName(), ORGANIZATION_TYPE);
			ExpandoValue expandoValueData = ExpandoValueLocalServiceUtil.getValue(expandoTableData.getTableId(),
					expandoColumnData.getColumnId(), organization.getOrganizationId());
			if (str.equals(expandoValueData.getData())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
}
