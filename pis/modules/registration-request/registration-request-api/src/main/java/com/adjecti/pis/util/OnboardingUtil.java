package com.adjecti.pis.util;

import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.pis.constant.OnboardingUserRole;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OnboardingUtil {

   
	public static boolean isAdmin(long userId) throws PortalException {
		User user = UserLocalServiceUtil.getUserById(userId);
		System.out.println(user);
		return user.getRoles().stream()
				.anyMatch(role -> role.getName().equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.ADMIN_ROLE)));
	}

	public static boolean isApprover(long userId) throws PortalException {

		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId);
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName()
					.equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.APPROVER_ROLE))) {
				return true;
			}
		}

		return false;
	}

	public static boolean isUploader(long userId) throws PortalException {
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId);
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName()
					.equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.CREATER_ROLE))) {
				return true;
			}
		}

		return false;
	}
	
	
	public static boolean isApprover(long userId, Organization unit ) throws PortalException {
		if(!unit.getType().equalsIgnoreCase("Unit")) {
			return false;
		}
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId,unit.getGroupId());
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName()
					.equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.APPROVER_ROLE))) {
				return true;
			}
		}

		return false;
	}

	public static boolean isUploader(long userId, Organization unit ) throws PortalException {
		if(!unit.getType().equalsIgnoreCase("Unit")) {
			return false;
		}
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId,unit.getGroupId());
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName()
					.equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.CREATER_ROLE))) {
				return true;
			}
		}

		return false;
	}
	
	public static boolean hasRoleInUnit(long userId, Organization unit, String userRole) throws PortalException {
		System.out.println("hasRoleInUnit");
		if(!unit.getType().equalsIgnoreCase("Unit")) {
			return false;
		}
		if(isAdmin(userId)) {
			return true;
		}
		
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId, unit.getGroupId());
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName().equalsIgnoreCase(userRole)) {
				return true;
			}
		}

		return false;
	}
	
	public static List<Organization> getUnitsByRole(long userId, OnboardingUserRole  onboardingUserRole) throws PortalException {
		List<Organization> unitList = new ArrayList<Organization>();
		
		if(onboardingUserRole.equals(OnboardingUserRole.ADMIN_ROLE) && isAdmin(userId) ) {
			List<Role> roleList = UserLocalServiceUtil.getUser(userId).getRoles();
			unitList = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
	                    .stream()
	                    .filter(org->org.getType().equalsIgnoreCase("unit"))
	                    .map(unit->unit).collect(Collectors.toList());
        } else if(onboardingUserRole.equals(OnboardingUserRole.CREATER_ROLE) && isUploader(userId)) {
            List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
            for(Organization org : orgList) {
            	if(isUploader(userId, org )) {
                    unitList.add(org);
                }
            }
        }else if(onboardingUserRole.equals(OnboardingUserRole.APPROVER_ROLE) && isApprover(userId)) {
            List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
            for(Organization org : orgList) {
            	if(isApprover(userId, org )) {
                    unitList.add(org);
                }
            }
        }
       
        return unitList;
    }
	
	
	public static List<Organization> getUnitByRoles(long userId) throws PortalException {
        List<Role> roleList = UserLocalServiceUtil.getUser(userId).getRoles();
        List<Organization> unitList = new ArrayList<Organization>();
        if(roleList.stream().anyMatch(role -> role.getName().equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.ADMIN_ROLE)))) {
            unitList = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
                    .stream()
                    .filter(org->org.getType().equalsIgnoreCase("unit"))
                    .map(unit->unit).collect(Collectors.toList());
        } else if(isUploader(userId)) {
            List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
            for(Organization org : orgList) {
            	if(isUploader(userId, org )) {
                    unitList.add(org);
                }
            }
        }else if(isApprover(userId)) {
            List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
            for(Organization org : orgList) {
            	if(isApprover(userId, org )) {
                    unitList.add(org);
                }
            }
        }
       
        return unitList;
    }
	
	public static List<OrganizationDetail> getUnitDetailsByRoles(long userId) throws PortalException {
        List<Role> roleList = UserLocalServiceUtil.getUser(userId).getRoles();
        List<Organization> unitList = new ArrayList<Organization>();
        if(roleList.stream().anyMatch(role -> role.getName().equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.ADMIN_ROLE)))) {
            unitList = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
                    .stream()
                    .filter(org->org.getType().equalsIgnoreCase("unit"))
                    .map(unit->unit).collect(Collectors.toList());
        } else if(isUploader(userId)) {
            List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
            for(Organization org : orgList) {
            	if(isUploader(userId, org )) {
                    unitList.add(org);
                }
            }
        }else if(isApprover(userId)) {
            List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
            for(Organization org : orgList) {
            	if(isApprover(userId, org )) {
                    unitList.add(org);
                }
            }
        }
        
        List<OrganizationDetail> unitDetailsList = new ArrayList<OrganizationDetail>();
        
        for(Organization org : unitList) {
        	OrganizationDetail orgDetail = OrganizationDetailLocalServiceUtil.getOrganizationDetailByOrganizationId(org.getOrganizationId());
        	if(orgDetail != null) {
        		unitDetailsList.add(orgDetail);
        	}
        }
       
        return unitDetailsList;
    }
    
    private static Organization getUnitOfOrganizationList(Organization organization) throws PortalException {
        
        if(organization.getType().equalsIgnoreCase("unit")) {
            return organization;
        }
        if(null == organization.getParentOrganization()) {
            return null;
        }
        return getUnitOfOrganizationList(organization.getParentOrganization());
        
    }
}