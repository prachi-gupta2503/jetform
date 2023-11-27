package net.ayudh.comnet.admin.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;

public class AppAdminUtil {
	public Organization getOrgnizationTypeDivision(Organization organization) throws PortalException {
		if(organization.getType().equals("Unit")) {
			organization=getOrgnizationTypeDivision(organization.getParentOrganization());
		}
		if(organization.getType().equals("Division")) {
			return organization;
		}
		return organization;
	}
}
