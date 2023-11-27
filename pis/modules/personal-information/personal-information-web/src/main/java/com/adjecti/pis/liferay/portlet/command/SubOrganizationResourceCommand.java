package com.adjecti.pis.liferay.portlet.command;

import com.adjecti.mdm.liferay.util.OrganizationUtils;
import com.adjecti.pis.liferay.constants.MVCCommandNames;
import com.adjecti.pis.liferay.constants.PISMVCPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    property = {
	        "javax.portlet.name=" + PISMVCPortletKeys.PISMVC,
	        "mvc.command.name="+MVCCommandNames.SUB_ORGANIZATIONS
	    },
	    service = MVCResourceCommand.class
	)
public class SubOrganizationResourceCommand implements MVCResourceCommand {

	@Override
    public boolean serveResource(
        ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        
        try {
        	long unitId = ParamUtil.getLong(resourceRequest, "unitId");
    		resourceResponse.setContentType("application/json");
    		PrintWriter out = resourceResponse.getWriter();
    		//Set<Organization> subOrganizations = new HashSet<Organization>();
    		List<Organization> sections=new ArrayList<>();
    		Organization organization = null;
    		try {
    			organization = OrganizationLocalServiceUtil.getOrganization(unitId);
    		} catch (PortalException e) {
    			e.printStackTrace();
    		}
    		   for(Organization section:OrganizationUtils.getRecursiveSubOrgsByParentOrg(organization)){
    			   Organization org=OrganizationUtils.getOrgnizationByType(section.getOrganizationId(), "Section");
    			    if(org!=null)	   {
    				   sections.add(org);
    			   } 
    		   } 
    		//String sections = JSONFactoryUtil.looseSerialize(sections);
    		out.write(JSONFactoryUtil.looseSerialize(sections));
    		out.flush();
            return false;
        }
        catch (Exception e) {
            return true;
        }
    }

}
