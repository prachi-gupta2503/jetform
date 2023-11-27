package com.adj.rsapi.application;

import com.adjecti.mdm.liferay.model.Cadre;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.mdm.liferay.service.CadreLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationGroupLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.mdm.liferay.service.TradeLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Adjecti
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/employee-detail",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest", "liferay.auth.verifier=false",
		"liferay.oauth2=false", }, service = Application.class)
public class PersonalInformationRsApplication extends Application {
	@Reference
	private EmployeeDetailsHandler detailsHandler;

	
	private static final Log LOGGER = LogFactoryUtil.getLog(PersonalInformationRsApplication.class.getName());
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		System.out.println("default service called-test3");
		return "It works!";
	}

	@GET
	@Path("/{employeeId}")
	@Produces("application/json")
	public EmployeeDetailsViewModel employeeByEmpId(@PathParam("employeeId") long employeeId, @Context HttpServletResponse response) throws PortalException {
		EmployeeDetailsViewModel employeeViewModal = null;
		try {
			employeeViewModal = detailsHandler.getEmpByEmpId(employeeId);
		} catch (Exception e) {
			System.out.println("Exception- "+e.getMessage());
			response.setStatus(404);
		}

		return employeeViewModal;

	}

	@GET
	@Path("/by-personal-no/{personalNo}")
	@Produces("application/json")
	public EmployeeDetailsViewModel employeeByPNo(@PathParam("personalNo") String personalNo,@Context HttpServletResponse response) throws PortalException {


		EmployeeDetailsViewModel employeeViewModal = null;
		try {
			employeeViewModal = detailsHandler.getEmpByPersonalNo(personalNo);
		} catch (Exception e) {
			response.setStatus(404);
		}

		return employeeViewModal;

	}

	@GET
	@Path("/by-grade-name")
	@Produces("application/json")
	public String getByGradeName(@QueryParam("gradeName") String gradeName,@Context HttpServletResponse response) throws PortalException {

		JSONArray array=JSONFactoryUtil.createJSONArray();
		try {
			array=EmployeeLocalServiceUtil.getByGradeName(gradeName);
		} catch (Exception e) {
			response.setStatus(404);
		}

		return array.toString();
	}

	@GET
	@Path("/get-employees")
	@Produces("application/json")
	public String getEmployees(@QueryParam("grade") long grade,
			@QueryParam("trade") long trade,@QueryParam("designation") long designation,
			@QueryParam("unit") long unit,@QueryParam("keyword") String keyword,@QueryParam("designationGroup") long designationGroup,
			@QueryParam("cadre") long cadre,
			@Context HttpServletResponse response) throws PortalException {
		LOGGER.info("In getEmployee method : "+cadre);
		JSONArray array=JSONFactoryUtil.createJSONArray();
		if(grade!=0 || trade!=0 || designation!=0 || unit!=0 || designationGroup!=0 || Validator.isNotNull(keyword) || cadre !=0) {
			array= EmployeeLocalServiceUtil.getEmployeeBySearchFilter(unit, trade, grade, designation,designationGroup,cadre,  keyword);
		}else {

			try {
				array=EmployeeLocalServiceUtil.getEmployees();
			} catch (Exception e) {
				response.setStatus(404);
			}
		}

		return array.toString();
	}
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public String searchEmployees(@Context HttpServletRequest request,	@Context HttpServletResponse response) throws PortalException {
		LOGGER.info("In searchEmployees method - 1");
		JSONArray array=JSONFactoryUtil.createJSONArray();
		
		try {
			array=EmployeeLocalServiceUtil.getEmployeeList(request.getParameterMap());
		} catch (Exception e) {
			LOGGER.error(e);
			response.setStatus(404);
		}

		return array.toString();
	}
	
	private Map<String, String> getSingleValueMap(HttpServletRequest request) {
		  Map<String, String> map = new HashMap<String, String>();
		  Map<String, String[]> parameters = request.getParameterMap();
		  for (String key : parameters.keySet()) {
			    String[] values = parameters.get(key);
			    map.put(key, values != null && values.length > 0 ? values[0] : null);
		  }
		  return map;
	}
	

	@GET
	@Path("/get-master-data")
	@Produces("application/json")
	public String getMasterData(@QueryParam("type") String type, @Context HttpServletResponse response) throws PortalException {

		JSONObject array=JSONFactoryUtil.createJSONObject();
		if(type==null) {
			array.put("grade",gradeToJson(response));
			array.put("trade",tradeToJson(response));
			array.put("designation",designationToJson(response));
			array.put("unit",unitToJson(response));
			array.put("designationGroup",designationGroupToJson(response));
			array.put("cadre",cadreToJson(response));
			

		}else {

			Method method;
			try {

				PersonalInformationRsApplication personalInformationRsApplication = new PersonalInformationRsApplication();
				method = PersonalInformationRsApplication.class.getDeclaredMethod(type+"ToJson",HttpServletResponse.class);
				array.put(type,method.invoke(personalInformationRsApplication, response));
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return array.toString();
	}
	
	@GET
	@Path("/get-designation-by-cadre")
	@Produces("application/json")
	public String getDesignationByCadre(@QueryParam("cadre") String cadre, @Context HttpServletResponse response) throws PortalException {

		JSONObject array=JSONFactoryUtil.createJSONObject();
		
		array.put("designation",designationToJson(response,cadre));
		
		return array.toString();
	}

	private JSONArray tradeToJson(HttpServletResponse response) {
		List<Trade> trades=new ArrayList<>();
		try {
			trades=TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			response.setStatus(404);
		}
		JSONArray array=JSONFactoryUtil.createJSONArray();
		for(Trade trade:trades) {
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
			jsonObject.put("key", trade.getTradeId());
			jsonObject.put("value", trade.getName());
			array.put(jsonObject);
		}
		return array;
	}

	private JSONArray gradeToJson(HttpServletResponse response) {
		List<Grade> grades=new ArrayList<>();
		try {
			grades=GradeLocalServiceUtil.getGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			response.setStatus(404);
		}
		JSONArray array=JSONFactoryUtil.createJSONArray();
		for(Grade grade:grades) {
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
			jsonObject.put("key", grade.getGradeId());
			jsonObject.put("value", grade.getName());
			array.put(jsonObject);
		}
		return array;
	}

	private JSONArray designationToJson(HttpServletResponse response) {
		List<Designation> designations=new ArrayList<>();
		try {
			designations=DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			response.setStatus(404);
		}
		JSONArray array=JSONFactoryUtil.createJSONArray();
		for(Designation designation:designations) {
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
			jsonObject.put("key", designation.getDesignationId());
			jsonObject.put("value", designation.getName_En());
			array.put(jsonObject);
		}

		return array;
	}
	
	private JSONArray designationToJson(HttpServletResponse response, String cadre) {
		List<Designation> designations=new ArrayList<>();
		try {
			designations=DesignationLocalServiceUtil.getDesignationsByCadreId(Long.parseLong(cadre.trim()));
		} catch (Exception e) {
			response.setStatus(404);
		}
		JSONArray array=JSONFactoryUtil.createJSONArray();
		for(Designation designation:designations) {
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
			jsonObject.put("key", designation.getDesignationId());
			jsonObject.put("value", designation.getName_En());
			array.put(jsonObject);
		}

		return array;
	}

	private JSONArray designationGroupToJson(HttpServletResponse response) {
		
		LOGGER.info("In designationGroupToJson : "+response);
		
		List<DesignationGroup> designationGroups=new ArrayList<>();
		try {
			LOGGER.info("In try : "+designationGroups);
			designationGroups=DesignationGroupLocalServiceUtil.getDesignationGroups(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			response.setStatus(404);
		}
		
		LOGGER.info("designationGroups : "+designationGroups);
		
		JSONArray array=JSONFactoryUtil.createJSONArray();
		for(DesignationGroup designationGroup:designationGroups) {
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
			jsonObject.put("key", designationGroup.getDesignationGroupId());
			jsonObject.put("value", designationGroup.getName());
			array.put(jsonObject);
		}

		return array;
	}
	
private JSONArray cadreToJson(HttpServletResponse response) {
		
		LOGGER.info("In cadresToJson : "+response);
		
		List<Cadre> cadres=new ArrayList<Cadre>();
		try {
			cadres=CadreLocalServiceUtil.getCadres(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			response.setStatus(404);
		}
		
		LOGGER.info("cadres : "+cadres);
		
		JSONArray array=JSONFactoryUtil.createJSONArray();
		for(Cadre cadre:cadres) {
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
			jsonObject.put("key", cadre.getCadreId());
			jsonObject.put("value", cadre.getName());
			array.put(jsonObject);
		}

		return array;
	}


	@GET
	@Path("/get-sections")
	@Produces("application/json")
	public String sectionToJson(@QueryParam("unitId") long unitId, @Context HttpServletResponse response) {
		List<OrganizationDetail> organizations=new ArrayList<>();
		try {
			organizations=OrganizationDetailLocalServiceUtil.getSections(unitId);
		} catch (Exception e) {
			response.setStatus(404);
		}
		JSONArray array=JSONFactoryUtil.createJSONArray();
		for(OrganizationDetail organization:organizations) {
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
			jsonObject.put("key", organization.getOrganizationId());
			jsonObject.put("value", organization.getShortName());
			array.put(jsonObject);
		}
		return array.toJSONString();
	}
	
	
	private JSONArray unitToJson(HttpServletResponse response) {
		List<OrganizationDetail> organizations=new ArrayList<>();
		try {
			organizations=OrganizationDetailLocalServiceUtil.getUnits();
		} catch (Exception e) {
			response.setStatus(404);
		}
		JSONArray array=JSONFactoryUtil.createJSONArray();
		for(OrganizationDetail organization:organizations) {
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
			jsonObject.put("key", organization.getOrganizationId());
			jsonObject.put("value", organization.getShortName());
			array.put(jsonObject);
		}

		return array;
	}
	private JSONArray organizationToJson(HttpServletResponse response) {
		List<Organization> organizations=new ArrayList<>();
		try {
			organizations=OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			response.setStatus(404);
		}
		JSONArray array=JSONFactoryUtil.createJSONArray();
		for(Organization organization:organizations) {
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
			jsonObject.put("key", organization.getOrganizationId());
			jsonObject.put("value", organization.getName());
			array.put(jsonObject);
		}
		
		return array;
	}
	
		@GET
		@Path("/get-employees-by-retirementMonth")
		@Produces("application/json")
		public String getEmployeeByRetirementMonth(@QueryParam("year") int year,
				@QueryParam("month") int month,@QueryParam("organizationId") long organizationId, @Context HttpServletResponse response) throws PortalException {

			JSONArray array=JSONFactoryUtil.createJSONArray();
			array=EmployeeLocalServiceUtil.getByRetirementMonth(year, month,organizationId);


			return array.toString();
		}
		
		@GET
		@Path("/get-divisions")
		@Produces("application/json")
		public String divisionToJson(@Context HttpServletResponse response) {
			List<Organization> organizations=new ArrayList<Organization>();
			try {
				organizations=getDivisions();
			} catch (Exception e) {
				response.setStatus(404);
			}
			JSONArray array=JSONFactoryUtil.createJSONArray();
			for(Organization org:organizations) {
				JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
				jsonObject.put("key", org.getOrganizationId());
				jsonObject.put("value", org.getName());
				array.put(jsonObject);
			}
			return array.toJSONString();
		}
		
		
		private List<Organization> getDivisions() {
			List<Organization> divisionList = new ArrayList<Organization>();
			divisionList = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
	                    .stream()
	                    .filter(org->org.getType().equalsIgnoreCase("Division"))
	                    .map(division->division).collect(Collectors.toList());
			return divisionList;
		}

		@GET
		@Path("/get-units")
		@Produces("application/json")
		public String getUnitByParentId(@QueryParam("divisionId") long divisionId ,@Context HttpServletResponse response) {
			List<OrganizationDetail> organizations=new ArrayList<OrganizationDetail>();
			try {
				organizations=OrganizationDetailLocalServiceUtil.getUnit(divisionId);
			} catch (Exception e) {
				response.setStatus(404);
			}
			JSONArray array=JSONFactoryUtil.createJSONArray();
			for(OrganizationDetail organization:organizations) {
				JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
				jsonObject.put("key", organization.getOrganizationId());
				jsonObject.put("value", organization.getShortName());
				array.put(jsonObject);
			}
			return array.toJSONString();
		}
		
	}