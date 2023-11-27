package com.adjecti.pis.ext.listener;

import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeOrganization;
import com.adjecti.pis.liferay.service.EmployeeOrganizationLocalServiceUtil;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.map.HashedMap;
import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class EmployeeModelListener extends BaseModelListener<Employee> {
	
	static final Log LOGGER = LogFactoryUtil.getLog(EmployeeModelListener.class.getName());
	
	@Override
	public void onAfterUpdate(Employee model) throws ModelListenerException {
		
		LOGGER.info("*********** EmployeeModelListener : onAfterUpdate");		
		long employeeId = model.getEmployeeId();
		long updatedOrganizationId = model.getOrganizationId();
		List<EmployeeOrganization> employeeOrganizations = EmployeeOrganizationLocalServiceUtil.getEmployeeOrganizationsByEmployeeId(employeeId);
		LOGGER.info("******** Printing Emloyee additional Section ******");
		LOGGER.info(employeeOrganizations);
		List<EmployeeOrganization> employeePreviousOrganizations = employeeOrganizations.stream()
				                                                                            .filter(employeeOrganization -> employeeOrganization.getOrganizationId() != updatedOrganizationId)
				                                                                            .collect(Collectors.toList());
		
		if(!employeePreviousOrganizations.isEmpty()) {
			
			LOGGER.info("******* Deleting the employeePreviousOrganizations **********");
			deletePreviousAdditionalOrganization(employeePreviousOrganizations,model.getLoginId());
		}
		
	}
	
private void deletePreviousAdditionalOrganization(List<EmployeeOrganization> employeePreviousOrganizations,String loginId){
	            LOGGER.info("inside deletePreviousAdditionalOrganization method ");
				List<String> attributes =new ArrayList<String>(); 
				attributes.add("sectioncode");
				attributes.add("section");
				attributes.add("sectiondescription");
				
				for(EmployeeOrganization employeePreviousOrganization:employeePreviousOrganizations) {
					
					long subOrganizationId = employeePreviousOrganization.getSubOrganizationId();
					  OrganizationDetail org;
					  LOGGER.info("inside for(EmployeeOrganization employeePreviousOrganization:employeePreviousOrganizations) { ");
					try {
						List<String> oldValues = new ArrayList<String>();
						
						org = OrganizationDetailLocalServiceUtil.getOrganizationDetail(subOrganizationId);
						
						String sectionCode=org.getOrganizationCode();
						String sectionName=org.getShortName();
						String longName=org.getLongName();
						 LOGGER.info("printnig the sectionCode :"+sectionCode+" sectionName : "+sectionName+"longName : "+longName);
						
						oldValues.add(sectionCode);
						oldValues.add(sectionName);
						oldValues.add(longName);
						LOGGER.info("calling the PISUserUtil.updateIDAMUser(loginId, attributes, oldValues, null) response -: ");
						boolean updateIDAMUser = PISUserUtil.updateIDAMUser(loginId, attributes, oldValues, new ArrayList<String>());
						LOGGER.info("Printing the updateIDAMUser"+updateIDAMUser);
						
						LOGGER.info("PISUserUtil.updateIDAMUser(loginId, attributes, oldValues, null) response -: "+updateIDAMUser);
						if(updateIDAMUser) {
							LOGGER.info("Deleting the employeePreviousOrganization");
							LOGGER.info(employeePreviousOrganization);
							EmployeeOrganizationLocalServiceUtil.deleteEmployeeOrganization(employeePreviousOrganization);
							
						}
					} catch (PortalException e) {
						
						LOGGER.info("inside catch ");
						e.printStackTrace();
					}
				}
		   
	}
	
  /*private Map<String,List<String>> extractPreviousAdditionalOrganizationInfo1(List<EmployeeOrganization> employeePreviousOrganizations){
	
	Map<String,List<String>> employeePreviousOrganizationInfo = new HashedMap<>();
	employeePreviousOrganizationInfo.put("sectioncode", new ArrayList<String>());
	employeePreviousOrganizationInfo.put("section", new ArrayList<String>());
	employeePreviousOrganizationInfo.put("sectiondescription", new ArrayList<String>());
	
	
	   employeePreviousOrganizations.stream().forEach(employeePreviousOrganization ->
	  { 
		  long subOrganizationId = employeePreviousOrganization.getSubOrganizationId();
		  OrganizationDetail org;
		  
		try {
			org = OrganizationDetailLocalServiceUtil.getOrganizationDetail(subOrganizationId);
			String sectionCode=org.getOrganizationCode();
			String sectionName=org.getShortName();
			String longName=org.getLongName();
			
			employeePreviousOrganizationInfo.get("sectioncode").add(sectionCode);
			employeePreviousOrganizationInfo.get("section").add(sectionName);
			employeePreviousOrganizationInfo.get("sectiondescription").add(longName);
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	   });
	   
	   return employeePreviousOrganizationInfo;
}

	private void deletePreviousAdditionalOrganization(List<EmployeeOrganization> employeePreviousOrganizations) {
		
		employeePreviousOrganizations.forEach(employeePreviousOrganization -> {
			EmployeeOrganizationLocalServiceUtil.deleteEmployeeOrganization(employeePreviousOrganization);
			LOGGER.info(employeePreviousOrganization);
		});
		
	}*/

}