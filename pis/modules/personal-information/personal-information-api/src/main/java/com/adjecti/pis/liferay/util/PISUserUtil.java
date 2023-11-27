package com.adjecti.pis.liferay.util;


import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.pis.liferay.constant.PISUserRole;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class PISUserUtil {
	private static final Log LOGGER = LogFactoryUtil.getLog(PISUserUtil.class.getName());
	
	private static String idamAPIEndPoint="";
	
	private PISUserUtil() {}
	
	public static boolean isAdmin(long userId) throws PortalException {
		User user = UserLocalServiceUtil.getUserById(userId);
		return user.getRoles().stream()
				.anyMatch(role -> (role.getName().equalsIgnoreCase(PISUserRole.valueOf(PISUserRole.ADMIN)) || role.getName().equalsIgnoreCase("Administrator") || role.getName().equalsIgnoreCase(PISUserRole.valueOf(PISUserRole.POWER_USER))));
	}

	public static boolean isApprover(long userId) throws PortalException {
		boolean isApprover=false;
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId);
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName()
					.equalsIgnoreCase(PISUserRole.valueOf(PISUserRole.APPROVER))) {
				isApprover= true;
				break;
			}
		}

		return isApprover;
	}

	public static boolean isUploader(long userId) throws PortalException {
		boolean isUploader=false;
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId);
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName()
					.equalsIgnoreCase(PISUserRole.valueOf(PISUserRole.CREATER))) {
				isUploader= true;
				break;
			}
		}

		return isUploader;
	}
	
	
	public static List<Organization> getUnitsByRole(long userId, PISUserRole  pISUserRole) throws PortalException {
		List<Organization> unitList = new ArrayList<Organization>();
		
		if(pISUserRole.equals(PISUserRole.CREATER) && isCreater(userId)) {
            List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
            for(Organization org : orgList) {
            	if(isCreater(userId, org )) {
                    unitList.add(org);
                }
            }
        }else if(pISUserRole.equals(PISUserRole.APPROVER) && isApprover(userId)) {
            List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
            for(Organization org : orgList) {
            	if(isApprover(userId, org )) {
                    unitList.add(org);
                }
            }
        }
       
        return unitList;
    }
	public static boolean isApprover(long userId, Organization unit ) throws PortalException {
		if(!unit.getType().equalsIgnoreCase("Unit")) {
			return false;
		}
		
		boolean isApprover=false;
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId,unit.getGroupId());
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName()
					.equalsIgnoreCase(PISUserRole.valueOf(PISUserRole.APPROVER))) {
				isApprover= true;
				break;
			}
		}

		return isApprover;
	}
	
	public static boolean isCreater(long userId, Organization unit ) throws PortalException {
		if(!unit.getType().equalsIgnoreCase("Unit")) {
			return false;
		}
		boolean isCreater=false;
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId,unit.getGroupId());
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName()
					.equalsIgnoreCase(PISUserRole.valueOf(PISUserRole.CREATER))) {
				isCreater= true;
				break;
			}
		}

		return isCreater;
	}
	
	public static boolean isCreater(long userId) throws PortalException {
		boolean isCreater=false;
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId);
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName()
					.equalsIgnoreCase(PISUserRole.valueOf(PISUserRole.CREATER))) {
				isCreater= true;
				break;
			}
		}

		return isCreater;
	}
	
	public  static boolean isPISAdmin(long userId) throws PortalException {
		User user = UserLocalServiceUtil.getUserById(userId);
		return user.getRoles().stream().anyMatch(role->role.getName().equalsIgnoreCase(PISUserRole.valueOf(PISUserRole.ADMIN)));
	}
	
	public  static boolean isSuperAdmin(long userId) throws PortalException {
		User user = UserLocalServiceUtil.getUserById(userId);
		return user.getRoles().stream().anyMatch(role->role.getName().equalsIgnoreCase("SUPER ADMIN"));
	}
	
	public static List<Organization> getUnitByRoles(long userId) throws PortalException {
		List<Organization> unitList = new ArrayList<Organization>();
		try {
			//List<Role> roleList = UserLocalServiceUtil.getUser(userId).getRoles();
			if(isAdmin(userId)) {
				List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				for(Organization o:orgList) {
					if(o.getType().equals("Unit")) {
						unitList.add(o);
					}
				}
			}else if(isCreater(userId)) {
	            List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	            for(Organization org : orgList) {
	            	if(isCreater(userId, org )) {
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
		}catch(Exception e) {}
        return unitList;
    }
	public static boolean updateIDAMUser(String loginId, String attribute, String oldValue, String newValue) throws Exception {
		JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
		JSONArray arrayOps=JSONFactoryUtil.createJSONArray();
		if(StringUtils.isNotEmpty(oldValue)) {
			JSONObject jsonRemove=JSONFactoryUtil.createJSONObject();
			JSONArray jsonRemoveArray=JSONFactoryUtil.createJSONArray();
			jsonRemoveArray.put(oldValue);
			jsonRemove.put("remove", jsonRemoveArray);
			arrayOps.put(jsonRemove);
		}
		if(StringUtils.isNotEmpty(newValue)) {
			JSONObject jsonAdd=JSONFactoryUtil.createJSONObject();
			JSONArray jsonAddArray=JSONFactoryUtil.createJSONArray();
			jsonAddArray.put(newValue);
			jsonAdd.put("add", jsonAddArray);
			arrayOps.put(jsonAdd);
		}
		
		if(arrayOps.length()>0) {
			return false;
		}
		jsonObject.put(attribute, arrayOps);
		
		String jsonData=jsonObject.toJSONString();
		
		LOGGER.info(jsonData);
		String iDAMUrl=getIdamAPIEndPoint();
		try {
			return invokeUpdateAPI(iDAMUrl, loginId, jsonData);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		return false;
	}

	public static boolean updateIDAMUser(String loginId, List<String> attributes, List<String> oldValues, List<String> newValues) {
		if(attributes.isEmpty()) {
			return true;
		}
		
		String[] arrAttributes=null;
		String[] arrOldValues=null;
		String[] arrNewValues=null;
		
		if(attributes.size()>0) {
			arrAttributes=new String[attributes.size()];
		}
		
		if(oldValues.size()>0) {
			arrOldValues=new String[oldValues.size()];
		}
		
		if(newValues.size()>0) {
			arrNewValues=new String[newValues.size()];
		}
		
		try {
			if(arrAttributes!=null) {
				for(int i=0;i<attributes.size();i++) {
					arrAttributes[i]=attributes.get(i);
				}
			}
			
			if(arrOldValues!=null) {
				for(int i=0;i<oldValues.size();i++) {
					arrOldValues[i]=oldValues.get(i);
				}
			}
			
			if(arrNewValues!=null) {
				for(int i=0;i<newValues.size();i++) {
					arrNewValues[i]=newValues.get(i);
				}
			}
			
			LOGGER.info("Before......PISUserUtil.updateIDAMUser");
			PISUserUtil.updateIDAMUser(loginId, arrAttributes, arrOldValues, arrNewValues);
			return true;
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

	public static boolean updateIDAMUser(String loginId, String[] attributes, String[] oldValues, String[] newValues) {
		LOGGER.info("Entring updateIDAMUser("+loginId+", {"+attributes+"}, {"+oldValues+"}, {"+newValues+"}");
		//JSONObject jsonObjects=JSONFactoryUtil.createJSONObject();
		if(attributes==null || attributes.length==0 ) {
			return false;
		}
		
		LOGGER.info("Before for loop ....");
		JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
		for(int i=0;i<attributes.length;i++) {
			String attribute=attributes[i];
			
			JSONArray arrayOps=JSONFactoryUtil.createJSONArray();
			
			if(oldValues!=null && oldValues.length>i) {
				String oldValue=oldValues[i];
				JSONObject jsonRemove=JSONFactoryUtil.createJSONObject();
				JSONArray jsonRemoveArray=JSONFactoryUtil.createJSONArray();
				jsonRemoveArray.put(oldValue);
				jsonRemove.put("remove", jsonRemoveArray);
				arrayOps.put(jsonRemove);
			}
			
			if(newValues!=null && newValues.length>i) {
				String newValue=newValues[i];
				JSONObject jsonAdd=JSONFactoryUtil.createJSONObject();
				JSONArray jsonAddArray=JSONFactoryUtil.createJSONArray();
				jsonAddArray.put(newValue);
				jsonAdd.put("add", jsonAddArray);
				arrayOps.put(jsonAdd);
			}
			jsonObject.put(attribute, arrayOps);
		
		}
		LOGGER.info("jsonObject.length() ...."+jsonObject.length());
		if(jsonObject.length()>0) {
			String jsonData=jsonObject.toJSONString();
			
			LOGGER.info(jsonData);
			String iDAMUrl=getIdamAPIEndPoint();
			try {
				return invokeUpdateAPI(iDAMUrl, loginId, jsonData);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
			return false;
		}
		return false;
	}
	
	public static boolean updateIDAMUser(String loginId, String attribute, String[] oldValues, String[] newValues) {
		LOGGER.info("Calling updateIDAMUser("+loginId+","+attribute+","+oldValues+","+newValues+")");
		//JSONObject jsonObjects=JSONFactoryUtil.createJSONObject();
		if(StringUtils.isBlank(attribute)) {
			return false;
		}
		
		JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
		JSONArray arrayOps=JSONFactoryUtil.createJSONArray();
		if(oldValues!=null && oldValues.length>0) {
			JSONObject jsonRemove=JSONFactoryUtil.createJSONObject();
			JSONArray jsonRemoveArray=JSONFactoryUtil.createJSONArray();
			for(String oldValue:oldValues) {
				jsonRemoveArray.put(oldValue);
			}
			jsonRemove.put("remove", jsonRemoveArray);
			arrayOps.put(jsonRemove);
		}
		
		if(newValues!=null && newValues.length>0) { 
			JSONObject jsonAdd=JSONFactoryUtil.createJSONObject();
			JSONArray jsonAddArray=JSONFactoryUtil.createJSONArray();
			for(String newValue:newValues) {
				jsonAddArray.put(newValue);
			}
			jsonAdd.put("add", jsonAddArray);
			arrayOps.put(jsonAdd);
		}
		
		if(arrayOps.length()<1) {
			return false;
		}
		jsonObject.put(attribute, arrayOps);
		
		String jsonData=jsonObject.toJSONString();
		
		String iDAMUrl=getIdamAPIEndPoint();
		try {
			return invokeUpdateAPI(iDAMUrl, loginId, jsonData);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
		return false;
	}
	
	private static boolean invokeUpdateAPI(String iDAMUrl, String loginId, String jsonData) throws Exception {
		LOGGER.info("invokeUpdateAPI("+iDAMUrl+","+ loginId+",jsonData)");
		LOGGER.info(jsonData);
		
		RequestConfig config = buildRequestConfig();
		
		String endPointURL=iDAMUrl+"/"+loginId;

		try (CloseableHttpClient httpclient = HttpClientBuilder.create()
				  .setDefaultRequestConfig(config).build()) {
			HttpPut httpPut = new HttpPut(endPointURL);
			httpPut.setHeader("Accept", "application/json");
			httpPut.setHeader("Content-type", "application/json");
			
			StringEntity stringEntity = new StringEntity(jsonData);
			httpPut.setEntity(stringEntity);
			
			//ResponseHandler<String> responseHandler = response -> {
			ResponseHandler<Integer> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				LOGGER.info(status+" - received from "+endPointURL);
				
				if (status >= 200 && status < 300) {
					//HttpEntity entity = response.getEntity();
					//return entity != null ? EntityUtils.toString(entity) : null;
					return status;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			//String responseBody = httpclient.execute(httpPut, responseHandler);
			int responseBody = httpclient.execute(httpPut, responseHandler);
			LOGGER.info("responseBody : "+ responseBody);
			//LOGGER.info(responseBody);
			//if(!responseBody.toLowerCase().contains("error") && !responseBody.toLowerCase().contains("fail")) {
			if (responseBody >= 200 && responseBody < 300) {	
				return true;
			}else {
				throw new IOException("User updation failed by the end point system.");
			}
			
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
	}
	
	public static String getIdamAPIEndPoint() {
		if(StringUtils.isEmpty(idamAPIEndPoint)) {
			idamAPIEndPoint= PropsUtil.get("idam.user.api.endpoint");
		}
		return idamAPIEndPoint;
	}
	
	public static void setIdamAPIEndPoint(String url) {
		idamAPIEndPoint=url;
	}
	
	public static void updateIdamUserPermission(Map<String, Boolean> permissons){
		
	
		/*jsonObject.put("DMS", (permissons.get("eGovAccess")==null || !permissons.get("eGovAccess")?"N":"Y"));
		jsonObject.put("zimbra", (permissons.get("emailAccess")==null || !permissons.get("emailAccess")?"N":"Y"));
		jsonObject.put("liferay", (permissons.get("pisAccess")==null || !permissons.get("pisAccess")?"N":"Y"));
		
		//#########New Attribtes ############//
		jsonObject.put("EGOV",  (permissons.get("eGovAccess")==null || !permissons.get("eGovAccess")?"N":"Y"));
		jsonObject.put("DSC", (permissons.get("digitalSigning")==null || !permissons.get("digitalSigning")?"N":"Y"));
	*/
	}
	public static boolean isEgovInboxEmpty(long employeeId, long sectionId) throws PortalException, UnknownHostException {
		try {
			Employee emp=EmployeeLocalServiceUtil.getEmployee(employeeId);
			String sectionCode=null;
			if(sectionId>0) {
				OrganizationDetail org=OrganizationDetailLocalServiceUtil.getOrganizationDetail(sectionId);
				sectionCode=org.getOrganizationCode();
			}
			return PISUserUtil.isEgovInboxEmpty(emp.getLoginId(), sectionCode);
			
		}catch (PortalException | UnknownHostException e) {
			throw e;
		}catch (Exception e) {
			LOGGER.error(e);
			throw new PortalException(e);
		}
	}
	public static boolean isEgovInboxEmpty(String loginId, String sectionCode) throws PortalException, UnknownHostException {

		String eGovURL=PropsUtil.get("egov.inbox.count.endpoint");
		
	
		String userUrl=String.format(eGovURL, loginId);
		if(StringUtils.isNotBlank(sectionCode)) {
			userUrl=userUrl.concat("?sectioncode=").concat(sectionCode);
		}
		
		LOGGER.info(userUrl);
		return isEgovSectionFileEmpty(userUrl);
		
		
	}
	
	public static boolean isEgovFileExist(String sectionCode) throws PortalException, UnknownHostException {
		String eGovURL=PropsUtil.get("egov.file.count.endpoint");
		if(StringUtils.isNotBlank(sectionCode)) {
			eGovURL=eGovURL.concat("?sectioncode=").concat(sectionCode);
		}
		
		LOGGER.info(eGovURL);
		return isEgovSectionFileEmpty(eGovURL);
		
		
	}
	
	private static boolean isEgovSectionFileEmpty(String userUrl) throws PortalException, UnknownHostException  {
		// TODO Auto-generated method stub
		RequestConfig config = buildRequestConfig();

		try (CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build()) {
			HttpGet httpGet = new HttpGet(userUrl);
			httpGet.setHeader("Accept", "*/*");
			httpGet.setHeader("Content-type",  "text/plain");
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			String responseBody = httpclient.execute(httpGet, responseHandler);
			LOGGER.info(responseBody);
			if (responseBody.toLowerCase().contains("error") || responseBody.toLowerCase().contains("fail")) {
				throw new PortalException(responseBody);
			}else {
				JSONObject jsonRespone=JSONFactoryUtil.createJSONObject(responseBody);
				int cc = 0, file = 0, note = 0, dak = 0, actionables=0, agenda=0, mom=0, committee=0, cng=0;
				if (jsonRespone != null) {
					try {
						cc = jsonRespone.getInt("CC");
					}catch(Exception e) {
						LOGGER.info("CC is null");
					}
					
					try {
						file = jsonRespone.getInt("File");
					}catch(Exception e) {
						LOGGER.info("File is null");
					}
					
					try {
						note = jsonRespone.getInt("Note");
					}catch(Exception e) {
						LOGGER.info("Note is null");
					}
					
					try {
						dak = jsonRespone.getInt("DAK");
					}catch(Exception e) {
						LOGGER.info("DAK is null");
					}
					
					try {
						actionables = jsonRespone.getInt("Actionables");
					}catch(Exception e) {
						LOGGER.info("Actionables is null");
					}
					
					try {
						agenda = jsonRespone.getInt("Agenda");
					}catch(Exception e) {
						LOGGER.info("Agenda is null");
					}
					
					try {
						mom = jsonRespone.getInt("MOM");
					}catch(Exception e) {
						LOGGER.info("MOM is null");
					}
					
					try {
						committee = jsonRespone.getInt("Committee");
					}catch(Exception e) {
						LOGGER.info("Committee is null");
					}
					
					try {
						cng = jsonRespone.getInt("CNG");
					}catch(Exception e) {
						LOGGER.info("CNG is null");
					}
					
				}
				if(cc == 0 && file == 0 && note == 0 && dak == 0 && actionables == 0 && agenda == 0 && mom == 0 && committee == 0 && cng==0) {
					return true;
				}else {
					return false;
				}
			}
		}catch (PortalException | UnknownHostException e) {
			LOGGER.error(e);
			throw e;
		}catch (Exception e) {
			LOGGER.error(e);
			throw new PortalException(e);
		}
	}

	private static RequestConfig buildRequestConfig() {
		int connTimeout = 0;
		try {
			connTimeout=Integer.parseInt(StringUtils.trim(PropsUtil.get("remote.connection.timeout")));
		}catch(Exception e) {}
		
		int connReqTimeout = 0;
		try {
			connReqTimeout=Integer.parseInt(StringUtils.trim(PropsUtil.get("remote.connection.request.timeout")));
		}catch(Exception e) {}
		
		int socketTimeout = 0;
		try {
			socketTimeout=Integer.parseInt(StringUtils.trim(PropsUtil.get("remote.socket.timeout")));
		}catch(Exception e) {}
		
		
		if(connTimeout<=0) {
			connTimeout=1000;
		}
		
		if(connReqTimeout<=0) {
			connReqTimeout=1000;
		}
		
		if(socketTimeout<=0) {
			socketTimeout=1000;
		}
		
		RequestConfig config = RequestConfig.custom().setConnectTimeout(connTimeout).setConnectionRequestTimeout(connReqTimeout).setSocketTimeout(socketTimeout).build();
		return config;
	}
	
	public static void main(String [] s) {
		String[] oldValues=null;
		String[] newValues=null;
		
		System.out.println("Calling updateIDAMUser(345666"+oldValues+","+newValues+")");

	}
}
