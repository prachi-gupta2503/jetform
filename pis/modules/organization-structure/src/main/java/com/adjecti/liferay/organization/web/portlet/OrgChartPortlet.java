package com.adjecti.liferay.organization.web.portlet;

import com.adjecti.liferay.organization.web.constants.OrgChartPortletKeys;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.ParamUtil;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;


import org.osgi.service.component.annotations.Component;

/**
 * @author user
 */
@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.header-portlet-css=/css/orgchart.css", 
				"com.liferay.portlet.header-portlet-javascript=/js/jquery-3.5.1.min.js",
				"com.liferay.portlet.header-portlet-javascript=/js/orgchart.js",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=OrgChart",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + OrgChartPortletKeys.ORGCHART,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
		)
public class OrgChartPortlet extends MVCPortlet {
	/**
	@ProcessAction(name="addOrganization")
	public void addOrganization(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
System.out.println("not called");
		
		long organizationId =ParamUtil.getLong(actionRequest, "organizationId");
		long parentOrganizationId =ParamUtil.getLong(actionRequest, "parentId");
		String name=ParamUtil.getString(actionRequest, "name");
		//String fullName=ParamUtil.getString(actionRequest, "fullName");
		String shortName=ParamUtil.getString(actionRequest, "shortName");
		long organizationTypeId =ParamUtil.getLong(actionRequest, "organizationTypeId");
		//String organizationType=ParamUtil.getString(actionRequest, "organizationType");
		String type = "organization";
		long regionId = 0;
		long countryId = 0;
		long statusId = 12017;
		String comments = "";
		boolean site = true;

		try {
			Organization organization=null;
			OrganizationDetail organizationDetail=null;
			if(organizationId!=0) {
				organization= OrganizationLocalServiceUtil.getOrganization(organizationId);
				organizationDetail=OrganizationDetailLocalServiceUtil.getAllOrganizationDetailByOrganizationId(organizationId).get(0);
				organization.setName(name);
				organization.setParentOrganizationId(parentOrganizationId);
				OrganizationLocalServiceUtil.updateOrganization(organization);
				organizationDetail.setOrganizationId(organization.getOrganizationId());
				organizationDetail.setShortName(shortName);
				organizationDetail.setOrganizationTypeId(organizationTypeId);
				OrganizationDetailLocalServiceUtil.updateOrganizationDetail(organizationDetail);
				
			}else {
				
				organization=	OrganizationLocalServiceUtil.addOrganization(ServiceContextThreadLocal.getServiceContext().getUserId(),
						parentOrganizationId, name, type, regionId,
						countryId, statusId, comments, site, ServiceContextThreadLocal.getServiceContext());
				
				organizationDetail=OrganizationDetailLocalServiceUtil.createOrganizationDetail(CounterLocalServiceUtil.increment(OrganizationDetail.class.getName()));
				organizationDetail.setOrganizationId(organization.getOrganizationId());
				organizationDetail.setShortName(shortName);
				organizationDetail.setOrganizationTypeId(organizationTypeId);
				OrganizationDetailLocalServiceUtil.addOrganizationDetail(organizationDetail);
				
			}
//			if(organization==null) {
//				
//				organization=	OrganizationLocalServiceUtil.addOrganization(ServiceContextThreadLocal.getServiceContext().getUserId(),
//						parentOrganizationId, name, type, regionId,
//						countryId, statusId, comments, site, ServiceContextThreadLocal.getServiceContext());
//			
//				
//			}else {
//				organization.setName(name);
//				organization.setParentOrganizationId(parentOrganizationId);
//				OrganizationLocalServiceUtil.updateOrganization(organization);
//			}
			
			//OrganizationDetailLocalServiceUtil.
			//addCustomFields(fullName, name, organizationType);


		} catch (PortalException e) {
			e.printStackTrace();
		}
	}
	
	
//	private void addCustomFields(String fullName,String name,String organizationType) {
//		long classNameId = ClassNameLocalServiceUtil.getClassNameId(Organization.class.getName());
//		ExpandoTable expandoTable;
//		ExpandoColumn expandoColumnFullName;
//		ExpandoColumn expandoColumnOrganizationType;
//		try {
//			expandoTable = ExpandoTableLocalServiceUtil.getTable(ServiceContextThreadLocal.getServiceContext().getCompanyId(), classNameId, "CUSTOM_FIELDS");
//			expandoColumnFullName =  ExpandoColumnLocalServiceUtil.getColumn(ServiceContextThreadLocal.getServiceContext().getCompanyId(), classNameId, expandoTable.getName(), "Full Name");
//			ExpandoValueLocalServiceUtil.addValue(classNameId, expandoTable.getTableId(),
//					expandoColumnFullName.getColumnId(),OrganizationLocalServiceUtil.getOrganizationId(ServiceContextThreadLocal.getServiceContext().getCompanyId(), name),
//					fullName);
//			expandoColumnOrganizationType =  ExpandoColumnLocalServiceUtil.getColumn(ServiceContextThreadLocal.getServiceContext().getCompanyId(), classNameId, expandoTable.getName(), "Organization Type");
//			ExpandoValueLocalServiceUtil.addValue(classNameId, expandoTable.getTableId(),
//					expandoColumnOrganizationType.getColumnId(),OrganizationLocalServiceUtil.getOrganizationId(ServiceContextThreadLocal.getServiceContext().getCompanyId(), name),
//					organizationType);
//		} catch (PortalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
 * 
 * */
 
}