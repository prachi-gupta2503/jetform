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

import com.adjecti.common.util.ReflectionUtil;
import com.adjecti.mdm.liferay.exception.NoSuchOrganizationDetailException;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.mdm.liferay.service.base.OrganizationDetailLocalServiceBaseImpl;
import com.adjecti.mdm.liferay.util.MDMUtils;

import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRouterUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.OrganizationNameException;
import com.liferay.portal.kernel.exception.OrganizationParentException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.security.audit.event.generators.util.Attribute;
import com.liferay.portal.security.audit.event.generators.util.AttributesBuilder;
import com.liferay.portal.security.audit.event.generators.util.AuditMessageBuilder;
import com.adjecti.mdm.liferay.util.AuditEventUtil;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;


/**
 * The implementation of the organization detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.OrganizationDetailLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetailLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.mdm.liferay.model.OrganizationDetail",
	service = AopService.class
)
public class OrganizationDetailLocalServiceImpl
	extends OrganizationDetailLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.mdm.liferay.service.OrganizationDetailLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil</code>.
	 */
	
	private final static Log LOGGER = LogFactoryUtil.getLog(OrganizationDetailLocalServiceImpl.class.getName());
	 
	
	
	public OrganizationDetail getOrganizationDetailByOrganizationId(long organizationId) {
		try {
			LOGGER.info("getOrganizationDetailByOrganizationId(long organizationId) : "+organizationId);
			return organizationDetailPersistence.findByOrganizationId(organizationId);
		}catch(Exception exe) {}
		
		return null;
	}
	public List<OrganizationDetail> getOrganizationDetailByType(String type) {
		try {
			return organizationDetailPersistence.findByType(type);
		}catch(Exception exe) {}
		
		return null;
	}
	
	public OrganizationDetail getOrganizationDetailByCode(String code) {
		try {
			return organizationDetailPersistence.findByOrganizationCode(code).get(0);
		}catch(Exception exe) {}
		
		return null;
	}
	
	public OrganizationDetail getOrganizationDetailByOrganizationCode(String code) {
		try {
			return organizationDetailPersistence.findByOrganizationCode(code).get(0);
		}catch(Exception exe) {}
		
		return null;
	}
	
	public List<OrganizationDetail> getOrganizationDetailByTypeAndOrganizationCode(String type, String organizationCode) {
		try {
			return organizationDetailPersistence.findByTypeAndOrganizationCode(type, organizationCode);
		}catch(Exception exe) {}
		
		return null;
	}
	
	public List<Organization> getOrganizationByTypeAndCode(String code, String type) {
		List<Organization> result=new ArrayList<Organization>();
		try {
			long classNameId=ClassNameLocalServiceUtil.getClassNameId(Organization.class);
			List<ExpandoValue> values=ExpandoValueLocalServiceUtil.getColumnValues(CompanyThreadLocal.getCompanyId(),classNameId, "CUSTOM_FIELDS", "code", QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for(ExpandoValue value:values) {
				LOGGER.info(value.getData() +" -- "+code);
				if(StringUtils.equalsIgnoreCase(StringUtils.trim(value.getData()), code)){
					Organization org= OrganizationLocalServiceUtil.getOrganization(value.getClassPK());
					if(StringUtils.equalsIgnoreCase(org.getType(),type)) {
						result.add(org);
					}
				}
			}
		}catch(Exception exe) {
			LOGGER.error(exe);
		}
		
		return result;
	}
	
	public OrganizationDetail addOrganizationDetail(Organization org) {
		OrganizationDetail od=null;
		try {
			String code=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "code", org.getOrganizationId(), StringPool.BLANK);
			String longName=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "longName", org.getOrganizationId(), StringPool.BLANK);
			String parentCode=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "code", org.getParentOrganizationId(), StringPool.BLANK);
			
			String unitType=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "unitType", org.getOrganizationId(), StringPool.BLANK);
            LOGGER.info("ODLSIMPL UNIT TYPE : "+unitType);
			return addOrganizationDetail(org, code, longName, parentCode,unitType);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
		return od;	
	}
	
	public OrganizationDetail addOrganizationDetail(Organization org, String code, String longName, String parentCode,String unitType) {
		OrganizationDetail od=null;
		LOGGER.info("inside addOrganizationDetail");
		try {
			
			od=OrganizationDetailLocalServiceUtil.createOrganizationDetail(org.getOrganizationId());
			od.setShortName(org.getName());
			od.setOrganizationCode(code);
			od.setLongName(longName);
			od.setType(org.getType());
			od.setOrganizationId(org.getOrganizationId());
			od.setUnitType(unitType);
			od.setParentId(org.getParentOrganizationId());
			od.setParentCode(parentCode);
			 LOGGER.info("ODLSIMPL addOrganizationDetail UNIT TYPE123 : "+unitType);
			
			organizationDetailPersistence.update(od);
			LOGGER.info("After Update "+od);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return od;	
	}
	
	public OrganizationDetail updateOrganizationDetail(Organization org) {
		OrganizationDetail od=null;
		try {
			String code=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "code", org.getOrganizationId(), StringPool.BLANK);
			String longName=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "longName", org.getOrganizationId(), StringPool.BLANK);
			String parentCode=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "code", org.getParentOrganizationId(), StringPool.BLANK);
			 String unitType=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "unitType", org.getOrganizationId(), StringPool.BLANK);
			 String orgStatus=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "status", org.getOrganizationId(), StringPool.BLANK);
			 
			return updateOrganizationDetail(org, code, longName, parentCode,unitType,orgStatus);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
		return od;	
	}
	
	public OrganizationDetail updateOrganizationDetail(Organization org, String code, String longName, String parentCode,String unitType,String orgStatus) {
		OrganizationDetail od=null;
		try {
			od=OrganizationDetailLocalServiceUtil.getOrganizationDetail(org.getOrganizationId());
		} catch (Exception e) {
			LOGGER.error(e);
		}
		try {
			if(od==null) {
				od=OrganizationDetailLocalServiceUtil.createOrganizationDetail(org.getOrganizationId());			
			}
			od.setShortName(org.getName());
			od.setOrganizationCode(code);
			od.setLongName(longName);
			od.setType(org.getType());
			od.setOrganizationId(org.getOrganizationId());

			od.setParentId(org.getParentOrganizationId());
			od.setParentCode(parentCode);
			od.setUnitType(unitType);
			od.setOrgStatus(orgStatus==null?"":orgStatus);
			OrganizationDetailLocalServiceUtil.updateOrganizationDetail(od);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return od;	
	}
	
	public boolean deleteOrganizationDetail(Organization org) {
		
		LOGGER.info("deleteOrganizationDetail");
		/*
		 * try { //OrganizationDetailLocalServiceUtil.deleteOrganizationDetail(org.
		 * getOrganizationId()); return true; } catch (Exception e) { LOGGER.error(e); }
		 */
		
		return false;	
	}
	
	 public boolean deleteeOrganizationDetail(long organizationDetailId) {
         try {
                 LOGGER.info("Delete ORg id"+organizationDetailId);
         //        OrganizationDetail findByOrganizationId = organizationDetailPersistence.findByOrganizationId(organizationDetailId);        
         //        LOGGER.info("findByOrganizationId  "+findByOrganizationId);
         //        OrganizationDetail remove = organizationDetailPersistence.remove(organizationDetailId);
                 OrganizationDetail deleteOrganizationDetail = OrganizationDetailLocalServiceUtil.deleteOrganizationDetail(organizationDetailId);
                 LOGGER.info("deleteOrganizationDetail  "+deleteOrganizationDetail);
                 Organization deleteOrganization = OrganizationLocalServiceUtil.deleteOrganization(organizationDetailId);
                 LOGGER.info("Delete ORg remove deleteOrganization"+deleteOrganization);
                 return true;
                 
         } catch (Exception e) {
                 LOGGER.error(e);
                 LOGGER.error(e);
         }
         
         
         
            
         return false;        
 }
 
 
	
	public Organization addOrganization(String code, String name, String description, String type, String parentCode, String parentType, boolean prefixParentName) throws OrganizationParentException, OrganizationNameException {
		Organization parent=null;
		try {
			parent=getOrganizationByTypeAndCode(parentCode, parentType).get(0);
		}catch(Exception e) {
			throw new OrganizationParentException("No "+parentType +" exists with code "+parentCode);
		}
		if(parent==null) {
			throw new OrganizationParentException("No "+parentType +" exists with code "+parentCode);
		}
		
		String prefixedName=(prefixParentName?(parent.getName()+"-"+name):name);
		
		if(existsOrganizationByParentIdAndName(parent.getOrganizationId(), prefixedName)){
			throw new OrganizationNameException("A "+type+" already exists with the name "+name+" under "+parentType+" code "+parentCode);
		}
		
		if(existsOrganizationByParentIdCodeAndType(parent.getOrganizationId(), code, type)){
			throw new OrganizationNameException("A "+type+" already exists with the code "+code+" under "+parentType+" code "+parentCode);
		}
		
		long countryId=0;
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		try {
			Country country = CountryServiceUtil.getCountryByA2("IN");
			countryId=country.getCountryId();
		} catch (Exception e1) {
			LOGGER.info("Error fetching country by A2(IN)");
		}
		
		try {
			
			Map<String, Serializable> expandoAttributes=new HashMap<String, Serializable>();
			expandoAttributes.put("code", code);
			expandoAttributes.put("longName", description);
			expandoAttributes.put("description", description);
			serviceContext.setExpandoBridgeAttributes(expandoAttributes);
			Organization child=OrganizationLocalServiceUtil.addOrganization(PrincipalThreadLocal.getUserId(), parent.getOrganizationId(), prefixedName, type, 0, countryId, ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, StringPool.BLANK, false, serviceContext);
			return child;
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;	
	}
	
	public Organization saveOrganization(long organizationId,String code,String unitType,String name, String description, String type, long parentId,ServiceContext serviceContext,String comments) throws PortalException {
		long countryId=0;
		//ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		try {
			Country country = CountryServiceUtil.getCountryByA2("IN");
			countryId=country.getCountryId();
		} catch (Exception e1) {
			LOGGER.info("Error fetching country by A2(IN)");
		}
		String error="";
		String errorCode="";
		List<OrganizationDetail> organizationDetailTypeByCode = null;
		try {
		 organizationDetailTypeByCode = OrganizationDetailLocalServiceUtil.getOrganizationDetailByTypeAndOrganizationCode(type,code);
		}catch(Exception e) {
			
		}
		Organization organizationByParentIdAndName = null;
		try {
		 organizationByParentIdAndName = OrganizationDetailLocalServiceUtil.getOrganizationByParentIdAndName(parentId, name);
	    }catch(Exception e) {
		
	    }
		
		/* if(!organizationDetailTypeByCode.isEmpty()) { errorCode="ERR01"; } */
		 if(organizationByParentIdAndName!=null) { errorCode="ERR02"; }
		
		try {
			Map<String, Serializable> expandoAttributes=new HashMap<String, Serializable>();
			expandoAttributes.put("code", code);
			expandoAttributes.put("unitType", unitType);
			expandoAttributes.put("longName", description);
			expandoAttributes.put("description", description);
			serviceContext.setExpandoBridgeAttributes(expandoAttributes);
			Organization organization=null;
		    byte[]logoBytes=new byte[1];
		    LOGGER.info("OrganizationDetailLocalServiceImpl called change "+organizationId);
			if(organizationId>0) {
				OrganizationLocalServiceUtil.updateOrganization(serviceContext.getCompanyId(), organizationId, parentId, name, type, 0, countryId,  ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, comments, false, logoBytes, false, serviceContext);
			}else {
				LOGGER.info("above if(!type.equalsIgnoreCase(\"section\"))  ");
				/*if(!type.equalsIgnoreCase("section")) {
				LOGGER.info("inside if(!type.equalsIgnoreCase(\"section\"))  ");
				if(!organizationDetailTypeByCode.isEmpty()) {
					errorCode="ERR01";
				}
				}
				if(organizationByParentIdAndName!=null) {
					errorCode="ERR02";
				}*/
				LOGGER.info(parentId);
				LOGGER.info(name);
				LOGGER.info(type);
				LOGGER.info(countryId);
				LOGGER.info(ListTypeConstants.ORGANIZATION_STATUS_DEFAULT);
				LOGGER.info(comments);
				LOGGER.info(serviceContext);
				LOGGER.info(PrincipalThreadLocal.getUserId());
				organization=OrganizationLocalServiceUtil.addOrganization(PrincipalThreadLocal.getUserId(), parentId, name, type, 0, countryId, ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, comments, false, serviceContext);
				LOGGER.info(organization);
				if(organization.getType().equals("Section")) {
					OrganizationDetail organizationDetail = OrganizationDetailLocalServiceUtil.getOrganizationDetail(organization.getOrganizationId());
					MDMUtils.createEgovSection(organizationDetail);
				}
			}
			return organization;
		} catch (Exception e) {
			LOGGER.error(e);
			LOGGER.info("Insite the organization Exception ");
			throw new PortalException(errorCode);
		}
		//return null;	
	}
	
	public boolean existsOrganizationByParentIdAndName(long parentId, String name) {
		try {
			return !OrganizationLocalServiceUtil.getOrganizations(CompanyThreadLocal.getCompanyId(), parentId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS).isEmpty();
		}catch(Exception e) {
		}
		return false;
	}
	
	public boolean existsOrganizationByParentIdCodeAndType(long parentId, String code, String type) {
		return getOrganizationByParentIdCodeAndType(parentId, code, type)!=null;
	}

	public Organization getOrganizationByParentIdAndName(long parentId, String name) {
		try {
			return OrganizationLocalServiceUtil.getOrganizations(CompanyThreadLocal.getCompanyId(), parentId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0);
		}catch(Exception e) {
		}
		return null;
	}

	
	public Organization getOrganizationByParentIdCodeAndType(long parentId, String code, String type) {
		Organization result=null;
		try {
			List<Organization> list=getOrganizationByTypeAndCode(code, type);
			for(Organization o:list) {
				if(o.getParentOrganizationId()==parentId) {
					result=o;
					break;
				}
			}
		}catch(Exception e) {
		}
		return result;
	}
	
	public List<OrganizationDetail> getUnits() {
		try {
			return organizationDetailPersistence.findByType("Unit");
		}catch(Exception exe) {}
		
		return null;
	}
	
	public List<OrganizationDetail> getUnit(long divisionId) {
		try {
			return getOrganizationDetailByParentIdAndType(divisionId,"Unit");
		}catch(Exception exe) {}
		
		return null;
	}
	
	
	public int getUnitsCount() {
		try {
			return organizationDetailPersistence.findByType("Unit").size();
		}catch(Exception exe) {}
		
		return 0;
	}
	
	public List<OrganizationDetail> getUnitsByDivisionId(long divisionId) {
		try {
			return getOrganizationDetailByParentIdAndType(divisionId,"Unit");
		}catch(Exception exe) {}
		
		return null;
	}
	
	public List<OrganizationDetail> getSectionsByUnitId(long unitId) {
		try {
			return getOrganizationDetailByParentIdAndType(unitId,"Section");
		}catch(Exception exe) {}
		
		return null;
	}
	
	public List<OrganizationDetail> getSections(long unitId) {
		try {
			return getOrganizationDetailByParentIdAndType(unitId,"Section");
		}catch(Exception exe) {}
		
		return null;
	}
	
	public int getSectionsCount(long unitId) {
		try {
			return getSections(unitId).size();
		}catch(Exception exe) {}
		return 0;
	}
	
	public int getTotalSectionsCount() {
		try {
			return getOrganizationDetailByType("Section").size();
		}catch(Exception exe) {}
		return 0;
	}
	
	public List<OrganizationDetail> getSectionsByCode(String organizationCode) {
		try {
			return organizationDetailPersistence.findByTypeAndOrganizationCode("Section", organizationCode);
		}catch(Exception exe) {}
		
		return null;
	}
	
	public int getSectionsCountByCode(String organizationCode) {
		try {
			return getSectionsByCode(organizationCode).size();
		}catch(Exception exe) {}
		return 0;
	}
	
	public OrganizationDetail getSectionByUnitCodeAndSectionCode(String unitCode, String sectionCode) {
		try {
			return organizationDetailPersistence.findByParentCodeAndOrganizationCode(unitCode, sectionCode).get(0);
		}catch(Exception exe) {}
		
		return null;
	}
	
	public List<OrganizationDetail> getOrganizationDetailByParentIdAndType(long parentId, String type) {
		try {
			return organizationDetailPersistence.findByParentIdAndType(parentId, type);
		}catch(Exception exe) {}
		
		return null;
	}
	
	public List<OrganizationDetail> getOrganizationDetailByParentIdAndOrganizationCode(long parentId, String code) {
		try {
			return organizationDetailPersistence.findByParentIdAndOrganizationCode(parentId, code);
		}catch(Exception exe) {}
		
		return null;
	}
	
	public List<OrganizationDetail> getOrganizationDetailByParentIdAndShortName(long parentId, String shortName) {
		try {
			return organizationDetailPersistence.findByParentIdAndShortName(parentId, shortName);
		}catch(Exception exe) {}
		
		return null;
	}
	
	public List<Organization> getOrganizations() {
		return MDMUtils.getOrganizations();
	}
	
	public List<Organization> getOrganizationsByType(String type) {
		return MDMUtils.getOrganizationsByType(type);
	}
	
	public Organization getByOrganizationId(long organizationId) {
		try {
			return MDMUtils.getOrganizationById(organizationId);
		}catch(Exception exe) {}
		return null;
	}
	
	public List<Organization> getOrganizationsByParentIdAndType(long parentId, String type) {
	
		return MDMUtils.getOrganizationsByParentIdAndType(parentId, type);
	} 
	
	public JSONObject getOrganizationHierarchy() {
		return getChildOrganizationHierarchy(0);
		
	}
	private void getOrganizationHierarchy(long parentId, JSONObject parentJSON) {
		JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		List<Organization> organizations=MDMUtils.getOrganizationsByParentId(parentId);
		if(CollectionUtils.isNotEmpty(organizations)) {
			for(Organization o:organizations) {
				JSONObject jsonObject=toJSON(o);
				jsonArray.put(jsonObject);
				getOrganizationHierarchy(o.getOrganizationId(), jsonObject);
			}
			parentJSON.put("children", jsonArray);
			parentJSON.put("childrenCount", organizations.size());
		}
	}
	
	public List<Organization> getChildOrganizations(long parentId) {
		return MDMUtils.getOrganizationsByParentId(parentId);
	}
	
	public JSONObject getChildOrganizationHierarchy(long parentId) {
		JSONObject jsonObject=null;
		if(parentId==0) {
			jsonObject=JSONFactoryUtil.createJSONObject();
		}else {
			jsonObject=toJSON(MDMUtils.getOrganizationById(parentId));
		}
		
		getOrganizationHierarchy(parentId, jsonObject);
		LOGGER.info("getChildOrganizationHierarchy : "+jsonObject.getJSONArray("children"));
		return jsonObject;
	}
	
	public boolean beforeUpdateOrganizationDetail(Object entity, Map<String, String[]> paramMap) {
		LOGGER.info("beforeUpdateOrganizationDetail : "+entity );
		String keys="";
		String values="";
		for(Map.Entry<String, String[]> entry:paramMap.entrySet()) {
			keys+=entry.getKey()+", ";
			if(entry.getValue()==null) {
				values+="null, ";
				continue;
			}
			values+="[";
			for(String s:entry.getValue()) {
				values+=s+",";
			}
			values+="],";
		}
		LOGGER.info("beforeUpdateOrganizationDetail keys : "+keys);
		LOGGER.info("beforeUpdateOrganizationDetail values : "+values);
		
		OrganizationDetail org=(OrganizationDetail)entity;
		try {
			long userId=PrincipalThreadLocal.getUserId();
			long parentId=Long.parseLong(paramMap.get("parentId")[0]);
			String sectionCode=paramMap.get("sectionCode")[0];
			String shortName=paramMap.get("shortName")[0];
			String longName=paramMap.get("longName")[0];
			String type=paramMap.get("type")[0];
			OrganizationDetail unit=getOrganizationDetail(parentId);
			
			try {
				List<OrganizationDetail> sections=getOrganizationDetailByParentIdAndOrganizationCode(parentId, sectionCode);
				if(CollectionUtils.isNotEmpty(sections)) {
					if(sections.size()>1 || org.getOrganizationDetailId()!=sections.get(0).getOrganizationDetailId()){
						LOGGER.info("Already a section exists with code "+sectionCode+" under the unit "+unit.getOrganizationCode());
						return false;
					}
				}
			}catch(Exception e) {
				LOGGER.info(e);
			}
				
			String name=StringUtils.trim(unit.getShortName())+"-"+StringUtils.trim(shortName);
			Organization section=null;
			try {
				if(org.getOrganizationDetailId()<=0) {
					boolean site=false;
					ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
					Country country=CountryServiceUtil.getCountryByA2("IN");
					section= OrganizationLocalServiceUtil.addOrganization(userId, parentId, name, type, 0,country.getCountryId() ,ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, longName, site, serviceContext);
				}else {
					section= OrganizationLocalServiceUtil.getOrganization(org.getOrganizationDetailId());
					if(!StringUtils.trim(section.getName()).equalsIgnoreCase(StringUtils.trim(name))) {
						section.setName(name);
					}
				}
			}catch(Exception e) {
				
			}
			if(section!=null) {
				LOGGER.info("beforeUpdateOrganizationDetail sectionId : "+section.getOrganizationId());
				org.setParentCode(unit.getOrganizationCode());
				org.setOrganizationDetailId(section.getOrganizationId());
				org.setOrganizationId(section.getOrganizationId());
			}
			return true;
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
		return false;
		
	}
	
	public boolean beforeDeleteOrganizationDetail(Object entity, boolean logical) {
		LOGGER.info("beforeDeleteOrganizationDetail : "+entity );
		
		OrganizationDetail org=(OrganizationDetail)entity;
		try {
			OrganizationLocalServiceUtil.deleteOrganization(org.getOrganizationDetailId());
			return true;
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
		return false;
		
	}
	
	public Map<String,String> importOrganizationDetail(List<Map<String, String[]>> records) {
		LOGGER.info("In importOrganizationDetail(List<Map<String, String[]>> records)");
		Map<String,String> result=new HashMap<String,String>();
		
		result.put("importCtr", "0");
		result.put("failedCtr", "0");
		result.put("totalCtr", "0");

		if(CollectionUtils.isEmpty(records)) {
			return result;
		}
		
		int ctr=0;
		int importCtr=0;

		for(Map<String, String[]> paramMap : records) {
			ctr++;
			try {
				String unitCode=StringUtils.trim(paramMap.get("unitCode")[0]);
				String sectionCode=StringUtils.trim(paramMap.get("sectionCode")[0]);
				String shortName=StringUtils.trim(paramMap.get("shortName")[0]);
				String longName=StringUtils.trim(paramMap.get("longName")[0]);
				String type=StringUtils.trim(paramMap.get("type")[0]);
				
				addOrganization(sectionCode, shortName, longName, type, unitCode, "Unit", true);

				result.put("Row"+ctr, "Success");
				importCtr++;

			}catch(Exception e) {
				result.put("Row"+ctr, e.getMessage());
				continue;
			}
			
		}
		
		result.put("importCtr", String.valueOf(importCtr));
		result.put("failedCtr", String.valueOf(records.size()-importCtr));
		result.put("totalCtr", String.valueOf(records.size()));
		return result;
		
	}
	
	public Map<String,String> importOrganizationDetail_Old(List<Map<String, String[]>> records) {
		LOGGER.info("In importOrganizationDetail(List<Map<String, String[]>> records)");
		Map<String,String> result=new HashMap<String,String>();
		int importCtr=0;
		int failedCtr=0;
		
		result.put("importCtr", String.valueOf(importCtr));
		result.put("failedCtr", String.valueOf(failedCtr));
		
		long countryId=0;
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		try {
			Country country = CountryServiceUtil.getCountryByA2("IN");
			countryId=country.getCountryId();
		} catch (Exception e1) {
			LOGGER.info("Error fetching country by A2(IN)");
		}

		if(CollectionUtils.isEmpty(records)) {
			return result;
		}
		
		int ctr=0;
		for(Map<String, String[]> paramMap : records) {
			ctr++;
			String error="";

			try {
				long userId=PrincipalThreadLocal.getUserId();
				String unitCode=StringUtils.trim(paramMap.get("unitCode")[0]);
				String sectionCode=StringUtils.trim(paramMap.get("sectionCode")[0]);
				String shortName=StringUtils.trim(paramMap.get("shortName")[0]);
				String longName=StringUtils.trim(paramMap.get("longName")[0]);
				String type=StringUtils.trim(paramMap.get("type")[0]);
				
				LOGGER.info("Searching OrganizationDetail with code "+unitCode);
				OrganizationDetail unitDet= null;
				Organization unitOrg= null;
				
				try {
					unitDet=getOrganizationDetailByTypeAndOrganizationCode("Unit", unitCode).get(0);
					LOGGER.info("unitDetails from OrganizationDetail : organizationDetailId = "+unitDet.getOrganizationDetailId()+", organizationId = "+unitDet.getOrganizationId()+", organizationCode = "+unitDet.getOrganizationCode()+", type = "+unitDet.getType());
					unitOrg=OrganizationLocalServiceUtil.getOrganization(CompanyThreadLocal.getCompanyId(), unitDet.getShortName());
					LOGGER.info("unitOrg from Organization : organizationId = "+unitOrg.getOrganizationId()+", name = "+unitOrg.getName()+", type = "+unitOrg.getType());
				}catch(Exception e) {
					LOGGER.info(e);
				}
				
				if(unitDet==null) {
					error="No unit exists with the Unit Code "+unitCode+" in OrganizationDetail";
					result.put("Row"+ctr, error);
					continue;
				}
				if(unitOrg==null) {
					error="No unit exists with the Unit Code "+unitCode+" in Liferay Organization ";
					result.put("Row"+ctr, error);
					continue;
				}
		
				try {
					List<OrganizationDetail> sections=getOrganizationDetailByParentIdAndOrganizationCode(unitOrg.getOrganizationId(), sectionCode);
					
					if(sections!=null && sections.size()>0) {
						error="A section already exists with code "+sectionCode+" under the unit "+unitCode;
						LOGGER.info(error);
						result.put("Row"+ctr, error);
						continue;
					}
				}catch(Exception e) {
					LOGGER.info(e);
				}
				
				
				String sectionName=unitDet.getShortName()+"-"+shortName;
				
				boolean site=false;
				
				Organization section = null;
				try {
					section=OrganizationLocalServiceUtil.addOrganization(userId, unitOrg.getOrganizationId(), sectionName, type, 0, countryId, ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, longName, site, serviceContext);
					LOGGER.info("Liferay Section : organizationId = "+section.getOrganizationId()+", name = "+section.getName()+", parentId = "+section.getParentOrganizationId());
				}catch(Exception e) {
					LOGGER.info(e);
				}
				
				if(section==null) {
					error="Section can not be created for sectionCode "+sectionCode+" due to either a section already exists with name "+sectionName+" or invalid section name.";
					LOGGER.info(error);
					result.put("Row"+ctr, error);
					continue;
				}
				
				LOGGER.info("Organization created with OrganizationId : "+section.getOrganizationId());
				OrganizationDetail orgDet=organizationDetailPersistence.create(section.getOrganizationId());
				orgDet.setOrganizationId(section.getOrganizationId());
				orgDet.setOrganizationCode(sectionCode);
				
				orgDet.setShortName(shortName);
				orgDet.setLongName(longName);
				orgDet.setType(type);
				orgDet.setParentId(unitOrg.getOrganizationId());
				orgDet.setParentCode(unitDet.getOrganizationCode());
				orgDet.setStatus(1);
				organizationDetailPersistence.update(orgDet);
				
				LOGGER.info("OrganizationDetail created with OrganizationId : "+section.getOrganizationId());
				result.put("Row"+ctr, "Success");
				
				importCtr++;
			}catch(Exception e) {
				LOGGER.error(e);
			}
		}
		
		result.put("importCtr", String.valueOf(importCtr));
		result.put("failedCtr", String.valueOf(records.size()-importCtr));
		result.put("totalCtr", String.valueOf(records.size()));

		
		return result;
		
	}
	private Organization getOrganizationByCode(String code, String type) {
		long classNameId=ClassNameLocalServiceUtil.getClassNameId(Organization.class.getName());
		String tableName="CUSTOM_FIELDS";
		String columnName="code";
		String data=code;
		Organization organization=null;
		
		List<ExpandoValue> values=ExpandoValueLocalServiceUtil.getColumnValues(CompanyThreadLocal.getCompanyId(), classNameId, tableName, columnName, data, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for(ExpandoValue value:values) {
			try {
				organization=OrganizationLocalServiceUtil.getOrganization(value.getClassPK());
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
		return null;
	}
	public List<Organization> syncUnits() {
		
		List<Organization> orgUnits=new ArrayList<Organization>();
		List<OrganizationDetail> unitDets=getUnits();
		Map<String, Organization> orgDivs=new HashMap<String, Organization>();
		
		long companyId=CompanyThreadLocal.getCompanyId();
		long userId=PrincipalThreadLocal.getUserId();
		long countryId=0;
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		try {
			Country country = CountryServiceUtil.getCountryByA2("IN");
			countryId=country.getCountryId();
		} catch (Exception e1) {
			LOGGER.info("Error fetching country by A2(IN)");
		}
		
		String userName=PrincipalThreadLocal.getName();
		for(OrganizationDetail unitDet:unitDets) {
			try {
				Organization orgDiv=null;
				long divisionId=0;
				if(StringUtils.isNotEmpty(unitDet.getDivision())) {
					String divisionName=unitDet.getDivision().trim();
					orgDiv=orgDivs.get(divisionName.toLowerCase());
					if(orgDiv==null) {
						try {
							orgDiv=OrganizationLocalServiceUtil.getOrganization(companyId, divisionName.trim());
						}catch(Exception e) {
						}
						if(orgDiv==null) {
							try {
								orgDiv=OrganizationLocalServiceUtil.addOrganization(userId, 0, divisionName, "Division", 0, countryId, ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, divisionName, false, serviceContext);
							}catch(Exception e) {
								LOGGER.info(e);
							}
						}
						
						if(orgDiv!=null) {
							orgDivs.put(divisionName.toLowerCase(), orgDiv);
						}
					}
					divisionId = (orgDiv!=null?orgDiv.getOrganizationId():0);
				}
				
				Organization orgUnit=null;
				try {
					orgUnit=OrganizationLocalServiceUtil.getOrganization(companyId, unitDet.getShortName());
					if(orgUnit!=null && orgUnit.getParentOrganizationId()!=divisionId) {
						orgUnit.setParentOrganizationId(divisionId);
						OrganizationLocalServiceUtil.updateOrganization(orgUnit);
					}
					
				}catch(Exception e) {
					LOGGER.info(e);
				}
				
				if(orgUnit==null) {
					try {
						orgUnit=OrganizationLocalServiceUtil.addOrganization(userId, divisionId, unitDet.getShortName(), "Unit", 0, countryId, ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, unitDet.getLongName(), false, serviceContext);
					}catch(Exception e) {
						LOGGER.info(e);
					}
				}
				
				if(orgUnit!=null) {
					try {
						unitDet.setOrganizationDetailId(orgUnit.getOrganizationId());
						unitDet.setOrganizationId(orgUnit.getOrganizationId());
						unitDet.setCompanyId(companyId);
						unitDet.setUserId(userId);
						unitDet.setUserName(userName);
						unitDet.setParentId(divisionId);
						
						OrganizationDetailLocalServiceUtil.updateOrganizationDetail(unitDet);
						orgUnits.add(orgUnit);
					}catch(Exception e) {
						LOGGER.info(e);
					}
				}
			}catch(Exception e) {
				LOGGER.info(e);
			}
		}
		return orgUnits;
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
	
	public List<OrganizationDetail> getDivisions() {
		try {
			return organizationDetailPersistence.findByType("Division");
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		return null;
	}

	public List<OrganizationDetail> searchOrganizationDetails(Map<String, String> searchFilter){
		List<OrganizationDetail> result=null;
		try {
			if(searchFilter!=null && searchFilter.size()>1) {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(OrganizationDetail.class, getClass().getClassLoader()); 
				for(Map.Entry<String, String> entry:searchFilter.entrySet()) {
					if(entry.getKey().equalsIgnoreCase("objectClass")) {
						continue;
					}
					
					LOGGER.info("Params- "+entry.getKey() +" : "+entry.getValue());
					Method method=ReflectionUtil.getAccessorMethodByFieldName(OrganizationDetail.class, entry.getKey());
					if(method!=null) {
						if(entry.getValue()!=null) {
							List<Object> valuelist = new ArrayList<Object>(); 
							String strValue=entry.getValue();
							String[] strValues=null;
								
							//If an attribute has comma separated values
							if(strValue.indexOf(",")>0) {
								strValues=strValue.split(",");
								for(String sv:strValues) {
									Object paramValue=ReflectionUtil.parseStringToDataType(StringUtils.trim(sv), method.getReturnType());
									if(paramValue!=null) {
										valuelist.add(paramValue);
									}
								}
							}else {
								Object paramValue=ReflectionUtil.parseStringToDataType(strValue, method.getReturnType());
								if(paramValue!=null) {
									valuelist.add(paramValue);
								}
							}
								
							if(CollectionUtils.isNotEmpty(valuelist)) {
								if(valuelist.size()==1) {
									dynamicQuery.add(RestrictionsFactoryUtil.eq(entry.getKey(), valuelist.get(0)));
								}else {
									dynamicQuery.add(RestrictionsFactoryUtil.in(entry.getKey(), valuelist));
								}
							}
						}
					}
				}
				result=dynamicQuery(dynamicQuery);
			}else{
				result=organizationDetailPersistence.findAll();
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		return result;
	}
	
	public Organization updateStatus(ThemeDisplay themeDisplay, String status,long organizationId) {
		Organization oldOrganization=null;
		Organization newOrganization=null;
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		Map<String, Serializable> expandoAttributes=new HashMap<String, Serializable>();
		expandoAttributes.put("status", status);
		byte[]logoBytes=new byte[1];
		serviceContext.setExpandoBridgeAttributes(expandoAttributes);
		try {
			OrganizationDetail organizationDetail =organizationDetailPersistence.findByOrganizationId(organizationId);
			oldOrganization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			LOGGER.info(serviceContext.getCompanyId());
			LOGGER.info(status+"/"+organizationDetail);
			organizationDetail.setOrgStatus(status);
			organizationDetail.setStatus(0);
			OrganizationDetailLocalServiceUtil.updateOrganizationDetail(organizationDetail);
			newOrganization=OrganizationLocalServiceUtil.updateOrganization(serviceContext.getCompanyId(), organizationId, oldOrganization.getParentOrganizationId(), oldOrganization.getName(), oldOrganization.getType(), 0, oldOrganization.getCountryId(),  ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, oldOrganization.getComments(), false, logoBytes, false, serviceContext);
			String eventType = "MOVE TO TRASH";
			AuditEventUtil.logEvent(themeDisplay,serviceContext,status, String.valueOf(organizationId),Organization.class.getName());
			
			
			List<Attribute> attributes = new ArrayList<Attribute>();
			attributes.add(new Attribute(oldOrganization.getName()));
			attributes.addAll(getModifiedAttributes(newOrganization,oldOrganization));
			LOGGER.info(attributes);
			if (attributes.size()>1) {
				AuditRouterUtil.route(getAuditMessage(eventType, newOrganization, attributes));
			}
			
		} catch (NoSuchOrganizationDetailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newOrganization;
	}
	protected List<Attribute> getModifiedAttributes(final Organization newOrganizationEntry,
			final Organization oldOrganizationEntry) {
		final AttributesBuilder attributesBuilder = new AttributesBuilder(newOrganizationEntry, oldOrganizationEntry);
		attributesBuilder.add("name");
		attributesBuilder.add("type");
		return attributesBuilder.getAttributes();
	}
	private AuditMessage getAuditMessage(String eventType, Organization organization, List<Attribute> attributes) {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		AuditMessage auditMessage = null;
		try {
			User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
			auditMessage = AuditMessageBuilder.buildAuditMessage(eventType, Organization.class.getName(),
					organization.getOrganizationId(), attributes);

			auditMessage.setUserId(user.getUserId());
			auditMessage.setUserName(user.getFullName());
			auditMessage.setClientIP(user.getLoginIP());

		} catch (Exception e) {
			
		}
		return auditMessage;
	}
	
	  public List<OrganizationDetail> getByUnitType(String unitType){
          
          return organizationDetailPersistence.findByunitType(unitType);
  
  }
	  
	  public boolean removeOrganizationDetailByOrganizationId(long organizationDeatailId) {
		 
		  try{
			  LOGGER.info("Delete ORg idOO "+organizationDeatailId);
			          OrganizationDetail deleteOrganizationDetail = organizationDetailPersistence.remove(organizationDeatailId);
	           
	                 LOGGER.info("deleteOrganizationDetail  "+deleteOrganizationDetail);
			/*
			 * Organization deleteOrganization =
			 * OrganizationLocalServiceUtil.deleteOrganization(organizationDeatailId);
			 * LOGGER.info("Delete ORg remove deleteOrganization"+deleteOrganization);
			 */
	                 return true;
	                 
	         } catch (Exception e) {
	                LOGGER.error(e);
	         }
	          
	         
	            
	         return false;        
		}
	
	  public boolean dataIsAvailbleOrNot(String fieldName,String fieldValue,String type,long organizationId) {
			boolean isDataAvailabe=false;
			if(fieldName.equalsIgnoreCase("code")) {
			       List<OrganizationDetail> findByOrganizationCodeAndType = organizationDetailPersistence.findByOrganizationCodeAndType(fieldValue, type);	
				   if(findByOrganizationCodeAndType.size()>0 && organizationId==0) {
					   isDataAvailabe=true;
				   }else if(((findByOrganizationCodeAndType.size()==0)||(findByOrganizationCodeAndType.size()==1)) && organizationId>0) {
					  for(OrganizationDetail organizationDetail:findByOrganizationCodeAndType) {
							if(organizationDetail.getOrganizationDetailId()==organizationId) {
								isDataAvailabe=false;
							}else {
								isDataAvailabe=true;
							}
						}
				   }else if(findByOrganizationCodeAndType.size()>1 && organizationId>0) {
					         isDataAvailabe=true;   
				   }
			}else if(fieldName.equalsIgnoreCase("name")) {
				List<OrganizationDetail> findByShortName = organizationDetailPersistence.findByShortName(fieldValue);
				if(organizationId==0 && findByShortName.size()>0) {
				isDataAvailabe=true;
				}else if(organizationId>0 && findByShortName.size()==1 &&  findByShortName.size()==0) {
					for(OrganizationDetail organizationDetail:findByShortName) {
						if(organizationDetail.getOrganizationDetailId()==organizationId) {
							isDataAvailabe=false;
						}else {
							isDataAvailabe=true;
						}
					}
					
				}else if(findByShortName.size()>1 && organizationId>0) {
			         isDataAvailabe=true;   
		   }
			}
				
			return isDataAvailabe;
			
		}
	  
	 
	  public boolean codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(String type,long parentId,String fieldName,String fieldValue,long organizationId) {
		  boolean isCodeAvailabe=false;
		  if(fieldName.equalsIgnoreCase("code")) {
		  List<OrganizationDetail> codeIsAvailableOrNotBasedOnTypeAndUnit = organizationDetailPersistence.findByTypeAndParentIdAndOrganizationCode(type, parentId, fieldValue);
		  if(codeIsAvailableOrNotBasedOnTypeAndUnit.size()>0 && organizationId==0) {
			  isCodeAvailabe=true;
			 LOGGER.info("codeIsAvailableOrNotBasedOnTypeAndUnit.size()  "+codeIsAvailableOrNotBasedOnTypeAndUnit.size());
		  }else if(((codeIsAvailableOrNotBasedOnTypeAndUnit.size()==1) ||(codeIsAvailableOrNotBasedOnTypeAndUnit.size()==0)) && organizationId>0) {
				for(OrganizationDetail organizationDetail:codeIsAvailableOrNotBasedOnTypeAndUnit) {
					if(organizationDetail.getOrganizationDetailId()==organizationId) {
						isCodeAvailabe=false;
					}else {
						isCodeAvailabe=true;
					}
				}
				
		  }else if(codeIsAvailableOrNotBasedOnTypeAndUnit.size()>1 && organizationId>0) {
			//	long count = codeIsAvailableOrNotBasedOnTypeAndUnit.stream().filter(data->(data.getOrganizationId()==organizationId)).count();
				isCodeAvailabe=true;
			}
		  }else if(fieldName.equalsIgnoreCase("name")) {
			  List<OrganizationDetail> findByShortName = organizationDetailPersistence.findByShortName(fieldValue);
			  //List<OrganizationDetail> findByTypeAndParentIdAndShortName = organizationDetailPersistence.findByTypeAndParentIdAndShortName(type, parentId, fieldValue);
			   if(findByShortName.size()>0 && organizationId==0) {
				  isCodeAvailabe=true;
				 LOGGER.info("codeIsAvailableOrNotBasedOnTypeAndUnit.size()  "+findByShortName.size());
			  }else if(((findByShortName.size()==1) ||(findByShortName.size()==0)) && organizationId>0) {
					for(OrganizationDetail organizationDetail:findByShortName) {
						if(organizationDetail.getOrganizationDetailId()==organizationId) {
							isCodeAvailabe=false;
						}else {
							isCodeAvailabe=true;
						}
					}
					
			  }else if(findByShortName.size()>1 && organizationId>0) {
				//	long count = codeIsAvailableOrNotBasedOnTypeAndUnit.stream().filter(data->(data.getOrganizationId()==organizationId)).count();
					isCodeAvailabe=true;
				}
			/*
			 if(findByShortName.size()>0) { isCodeAvailabe=true; }else {
			 isCodeAvailabe=false; }
			 */
		  
		  }
		  return isCodeAvailabe;
		}
	  
	  public List<OrganizationDetail>  getByName(String shortName){
		  return organizationDetailPersistence.findByShortName(shortName);
	  }
	  
	  public List<OrganizationDetail>  getByStateId(long stateId){
		  return organizationDetailPersistence.findByStateId(stateId);
	  }

	  
	  public List<OrganizationDetail>  getByParentId(long parentId){
		  return organizationDetailPersistence.findByParentId(parentId);
	  }

	  public List<OrganizationDetail>  getByParentIdAndType(long parentId,String type){
		  return organizationDetailPersistence.findByParentIdAndType(parentId,type);
	  }

}