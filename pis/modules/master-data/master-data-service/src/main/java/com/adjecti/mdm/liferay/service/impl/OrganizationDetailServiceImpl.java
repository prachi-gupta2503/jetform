/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.adjecti.mdm.liferay.service.impl;

import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.mdm.liferay.service.base.OrganizationDetailServiceBaseImpl;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.OrganizationNameException;
import com.liferay.portal.kernel.exception.OrganizationParentException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the organization detail remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.OrganizationDetailService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetailServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=mdm",
		"json.web.service.context.path=OrganizationDetail"
	},
	service = AopService.class
)
public class OrganizationDetailServiceImpl
	extends OrganizationDetailServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.adjecti.mdm.liferay.service.OrganizationDetailServiceUtil</code> to access the organization detail remote service.
	 */
	private final static Log LOGGER = LogFactoryUtil.getLog(OrganizationDetailServiceImpl.class.getName());
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getOrganizations() {
		JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		List<Organization> organizations=MDMUtils.getOrganizations();
		for(Organization o:organizations) {
			JSONObject jsonObject=toJSON(o);
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getOrganizationsByType(String type) {
		JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		List<Organization> organizations=MDMUtils.getOrganizationsByType(type);
		for(Organization o:organizations) {
			JSONObject jsonObject=toJSON(o);
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getOrganizationDetailByTypes(String[] type) {
		JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		List<Organization> organizations=MDMUtils.getOrganizationsByTypes(type);
		for(Organization o:organizations) {
			JSONObject jsonObject=toJSON(o);
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONObject getOrganizationHierarchy() {
		return organizationDetailLocalService.getOrganizationHierarchy();
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getOrganizationHierarchyByOrganizationId(long organizationId) {
		JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		Organization organization=MDMUtils.getOrganizationById(organizationId);
		List<Organization> organizations=new ArrayList<Organization>();
		organizations.add(organization);
		List<Organization> org=MDMUtils.getOrganizationHierarchyByOrganizationId(organizationId, organizations);
		for(Organization o:org) {
			JSONObject jsonObject=toJSON(o);
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getOrganizationsByParentIdAndType(long parentId, String type) {
		JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		List<Organization> organizations=MDMUtils.getOrganizationsByParentIdAndType(parentId, type);
		for(Organization o:organizations) {
			JSONObject jsonObject=toJSON(o);
			String status = jsonObject.get("status").toString();
			if(status==null||status.equals("") || status.equals("Initiate Dissolve") ||status.equals("Initiate Merge") ||status.equals("Initiate Split") ) {
				
				jsonArray.put(jsonObject);
			}
		}
		return jsonArray;
		
	}
	
	

	@AccessControlled(guestAccessEnabled = true)
	public JSONObject getByOrganizationId(long organizationId) {
		return toJSON(MDMUtils.getOrganizationById(organizationId));
	}
	
	public JSONArray getChildOrganizations(long parentId) {
		JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		List<Organization> organizations=MDMUtils.getOrganizationsByParentId(parentId);
		for(Organization o:organizations) {
			JSONObject jsonObject=toJSON(o);
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}
	
	private JSONObject toJSON(Organization o) {
		JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
		jsonObject.put("organizationId", o.getOrganizationId());
		jsonObject.put("name", o.getName());
		jsonObject.put("type", o.getType());
		jsonObject.put("parentOrganizationId", o.getParentOrganizationId());
		jsonObject.put("parentOrganizationName", o.getParentOrganizationName());
		jsonObject.put("comments", o.getComments());
		jsonObject.put("description", getExpandoValue(Organization.class, o.getOrganizationId(), "description"));
		jsonObject.put("status", getExpandoValue(Organization.class, o.getOrganizationId(), "status"));
		
		JSONArray emailJsonArray=JSONFactoryUtil.createJSONArray();
		List<EmailAddress> emails=MDMUtils.getEmailAddresses(o.getCompanyId(), Organization.class.getName(), o.getOrganizationId());
		if(CollectionUtils.isNotEmpty(emails)) {
			for(EmailAddress email:emails) {
				emailJsonArray.put(email.getAddress());
			}
		}
		jsonObject.put("emails", emailJsonArray);
		
		JSONArray phoneJsonArray=JSONFactoryUtil.createJSONArray();
		List<Phone> phones=MDMUtils.getPhones(o.getCompanyId(), Organization.class.getName(), o.getOrganizationId());
		if(CollectionUtils.isNotEmpty(phones)) {
			for(Phone phone:phones) {
				phoneJsonArray.put(phone.getNumber());
			}
		}
		jsonObject.put("phones", phoneJsonArray);
		
		JSONArray websitesJsonArray=JSONFactoryUtil.createJSONArray();
		List<Website> websites=MDMUtils.getWebsites(o.getCompanyId(), Organization.class.getName(), o.getOrganizationId());
		if(CollectionUtils.isNotEmpty(websites)) {
			for(Website website:websites) {
				websitesJsonArray.put(website.getUrl());
			}
		}
		jsonObject.put("websites", websitesJsonArray);
		
		String logoUrl="";
		try {
			ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
			logoUrl=serviceContext.getPortalURL()+ "/image/organization_logo?img_id="+o.getLogoId()+"&t="+(new Date().getTime());
		} catch (Exception e) {
			LOGGER.error(e);
		}
		jsonObject.put("logoUrl", logoUrl);
		return jsonObject;
	}
	
	private String getExpandoValue(Class<Organization> clazz, long classPK, String columnName) {
		String value="";
		try {
			value=getExpandoValue(clazz, classPK, "CUSTOM_FIELDS", columnName, "");
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return value;
	}
	private String getExpandoValue(Class<Organization> clazz, long classPK, String tableName, String columnName, String defaultValue) {
		String value="";
		try {
			value=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), clazz.getName(), "CUSTOM_FIELDS", columnName, classPK, defaultValue);
		}catch (PortalException e) {
			LOGGER.error(e);
		}
		return value;
	}
	
	public List<Organization> syncUnits() {
		return organizationDetailLocalService.syncUnits();
	}

	public Organization saveOrganization(long organizationId,String code, String unitType,String name, String description, String type, long parentId, ServiceContext serviceContext,String comments) throws PortalException {
		return organizationDetailLocalService.saveOrganization(organizationId,code, unitType,name, description, type, parentId,serviceContext,comments);
		
	}

	public Organization updateStatus(ThemeDisplay themeDisplay,String status,long organizationId) {
		return organizationDetailLocalService.updateStatus(themeDisplay,status,organizationId);
	}
	
	public boolean removeOrganizationDetailByOrganizationId(long organizationDeatailId) {
		return OrganizationDetailLocalServiceUtil.removeOrganizationDetailByOrganizationId(organizationDeatailId);
	}
	public boolean dataIsAvailbleOrNot(String fieldName,String fieldValue,String type,long organizationId) {
		return OrganizationDetailLocalServiceUtil.dataIsAvailbleOrNot(fieldName,fieldValue,type,organizationId);
	}
	
	public boolean codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(String type,long parentId,String fieldName,String fieldValue,long organizationId) {
		return OrganizationDetailLocalServiceUtil.codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(type,parentId,fieldName,fieldValue,organizationId);
	}
	
	
	
}