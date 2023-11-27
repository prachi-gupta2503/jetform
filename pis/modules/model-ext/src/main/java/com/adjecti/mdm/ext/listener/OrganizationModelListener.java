package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.EmployeeTraining;
import com.adjecti.pis.liferay.model.EmployeeTransfer;
import com.adjecti.pis.liferay.model.IDAMFailedTransaction;
import com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeTrainingLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeTransferLocalServiceUtil;
import com.adjecti.pis.liferay.service.IDAMFailedTransactionLocalServiceUtil;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class OrganizationModelListener extends BaseModelListener<Organization> {
	
	final static Log LOGGER = LogFactoryUtil.getLog(OrganizationModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Organization model) throws ModelListenerException {
		LOGGER.info("OrganizationEntityListener:onAfterCreate called");
		OrganizationDetailLocalServiceUtil.addOrganizationDetail(model);
		/*
		 * long classNameId=ClassNameLocalServiceUtil.getClassNameId(
		 * "com.liferay.portal.kernel.model.Organization");
		 * 
		 * List<Group> groups = GroupLocalServiceUtil.getGroups(-1, -1); //Group group =
		 * groups.stream().filter(g->g.getClassPK()==model.getOrganizationId()).findAny(
		 * ).get(); Group group=null; for(Group g:groups) {
		 * if(g.getClassPK()==model.getOrganizationId() &&
		 * g.getClassNameId()==classNameId) { group=g; } } if(group==null) {
		 * 
		 * Group newGroup =
		 * GroupLocalServiceUtil.createGroup(CounterLocalServiceUtil.increment());
		 * newGroup.setClassPK(model.getOrganizationId());
		 * newGroup.setClassNameId(classNameId);
		 * newGroup.setCreatorUserId(model.getUserId());
		 * newGroup.setGroupKey(model.getName()+" LFR_ORGANIZATION"); newGroup.
		 * setName("<?xml version='1.0' encoding='UTF-8'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Name language-id=\"en_US\">"
		 * +model.getName()+"</Name></root>"); newGroup.setType(3);
		 * newGroup.setFriendlyURL("/"+model.getName()); newGroup.setActive(true);
		 * newGroup.setSite(false);
		 * newGroup.setTreePath("/"+model.getOrganizationId()+"/");
		 * 
		 * GroupLocalServiceUtil.updateGroup(newGroup);
		 * 
		 * }
		 */
	}
	
	@Override
	public void onAfterUpdate(Organization model) throws ModelListenerException {
		LOGGER.info("OrganizationEntityListener:onAfterUpdate called"+model);
		OrganizationDetailLocalServiceUtil.updateOrganizationDetail(model);
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
		LOGGER.info("OrganizationEntityListener:onAfterAddAssociation called");
	}

	@Override
	public void onAfterRemove(Organization model) throws ModelListenerException {
		LOGGER.info("OrganizationEntityListener:onAfterRemove called");
		OrganizationDetailLocalServiceUtil.deleteOrganizationDetail(model);
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		LOGGER.info("OrganizationEntityListener:onAfterRemoveAssociation called");
	}
	
	@Override
	public void onBeforeCreate(Organization model) throws ModelListenerException {
		LOGGER.info("OrganizationEntityListener:onBeforeCreate called");
		String code=String.valueOf(model.getExpandoBridge().getAttribute("code"));
		try {
			String treePath="";
			if(null!=model.getParentOrganization()) {
				treePath= model.getParentOrganization().getTreePath()+model.getOrganizationId()+"/";
			}else {
				treePath= model.getOrganizationId()+"/";
			}
				model.setTreePath(treePath);
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LOGGER.info("code : "+code+"   TreePath:   "+model.getTreePath());
		if(StringUtils.isBlank(code)) {
			 throw new ModelListenerException ("Organization code is mandatory..");
		}
		
		boolean unique=isUniqueCode(model, code);
		 LOGGER.info("unique : "+unique);
		if(!unique) {
			throw new ModelListenerException ("A "+model.getType()+" already exists with the code["+code+"].");
		}
		
		
		
	}

	@Override
	public void onBeforeRemove(Organization model) throws ModelListenerException {
		LOGGER.info("OrganizationEntityListener:onBeforeRemove called");
		/*
		 * int count=0; if(model.getType().equalsIgnoreCase("institute")) { try {
		 * 
		 * List<Employee> list=
		 * EmployeeLocalServiceUtil.getEmployeeByOrganizationId(model.getOrganizationId(
		 * )); List<EmployeeJoining> findByOrganizationID =
		 * EmployeeJoiningLocalServiceUtil.findByOrganizationID(model.getOrganizationId(
		 * )); List<EmployeeTraining> employeeTrainings =
		 * EmployeeTrainingLocalServiceUtil.getEmployeeTrainings(-1,-1);
		 * for(EmployeeTraining employeeTraining:employeeTrainings) {
		 * LOGGER.info("employeeTraining.getInstituteId()  "+employeeTraining.
		 * getInstituteId()+"   model.getOrganizationId()  "+model.getOrganizationId());
		 * if(employeeTraining.getInstituteId()==model.getOrganizationId()) { count++;
		 * LOGGER.info("employeeTraining.getInstituteId()  "+employeeTraining.
		 * getInstituteId()+"   model.getOrganizationId()  "+model.getOrganizationId()
		 * +" COUNT "+count); } }
		 * 
		 * if(findByOrganizationID.size()>0 || list.size()>0){ count++;
		 * LOGGER.info("Count Inside If List "+ count); }
		 * 
		 * LOGGER.info("Count "+ count);
		 * 
		 * 
		 * 
		 * 
		 * }catch(Exception e) {}
		 * 
		 * if(count>0 ){ LOGGER.info(" Inside if Count "+ count); throw new
		 * ModelListenerException("One or more employee exists for this organization id ["
		 * +model.getOrganizationId()+"].");
		 * 
		 * } }
		 * 
		 * 
		 * if(model.getType().equalsIgnoreCase("unit")) {
		 * LOGGER.info(" Inside Unit Count "+ count); int countn=0;
		 * List<EmployeeTransfer> employeeTransfers =
		 * EmployeeTransferLocalServiceUtil.getEmployeeTransfers(-1,-1);
		 * 
		 * for(EmployeeTransfer employeeTransfer:employeeTransfers) {
		 * LOGGER.info((employeeTransfer.getFromOrganizationId()==model.
		 * getOrganizationId()) ||
		 * (employeeTransfer.getToOrganizationId()==model.getOrganizationId()));
		 * LOGGER.info("employeeTransfer.getFromOrganizationId()"+employeeTransfer.
		 * getFromOrganizationId()+"  model.getOrganizationId() "+model.
		 * getOrganizationId()+"employeeTransfer.getToOrganizationId()"+employeeTransfer
		 * .getToOrganizationId());
		 * if((employeeTransfer.getFromOrganizationId()==model.getOrganizationId()) ||
		 * (employeeTransfer.getToOrganizationId()==model.getOrganizationId())) {
		 * countn++; } }
		 * 
		 * if(countn>0) { LOGGER.info("Countn "+countn); throw new
		 * ModelListenerException("One or more employee exists for this Unit id ["+model
		 * .getOrganizationId()+"]."); } //throw new
		 * ModelListenerException("One or more employee exists for this organization id ["
		 * +model.getOrganizationId()+"]."); }
		 */
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		LOGGER.info("OrganizationEntityListener:onBeforeRemoveAssociation called");
	}

	@Override
	public void onBeforeUpdate(Organization model) throws ModelListenerException {
		LOGGER.info("OrganizationEntityListener:onBeforeUpdate called");
		
		String code=String.valueOf(model.getExpandoBridge().getAttribute("code"));
		
		LOGGER.info("code : "+code+", model.getType() : "+model.getType()+", ParentOrgName : "+model.getParentOrganizationName()+", ParentOrgId : "+model.getParentOrganizationId());
		
		if(StringUtils.isBlank(code)) {
			 throw new ModelListenerException ("Organization code is mandatory");
		}
		
		boolean unique=isUniqueCode(model, code);
		 LOGGER.info("Unique Value onBeforeUpdate called "+unique);
         
		
		if(!unique) {
			LOGGER.info("if(!unique) onBeforeUpdate called "+unique); 
			throw new ModelListenerException ("A "+model.getType()+" already exists with the code["+code+"].");
		}
		
		Organization oldModel=null;
		OrganizationDetail oldExpadoValue=null;
		try {
			oldModel= OrganizationLocalServiceUtil.getOrganization(model.getOrganizationId());
			oldExpadoValue=OrganizationDetailLocalServiceUtil.getOrganizationDetailByOrganizationId(model.getOrganizationId());
		} catch (PortalException e1) {
			LOGGER.error(e1.getMessage());
		}
		String oldCode=code;
		String longName=String.valueOf(model.getExpandoBridge().getAttribute("longName"));
		String oldLongName=longName;
		if(oldExpadoValue!=null) {
			
			oldCode=String.valueOf(oldExpadoValue.getOrganizationCode());
			oldLongName=oldExpadoValue.getLongName();
		}
		LOGGER.info("oldcode : "+oldCode);
		LOGGER.info("new code : "+code);
		
		LOGGER.info("oldLongName : "+oldLongName);
		LOGGER.info("new longName : "+longName);
		
		String oldName=oldModel.getName();
		LOGGER.info("oldname : "+oldName);
		String name=model.getName();
		LOGGER.info("new name : "+name);
		
		String oldType=oldModel.getType();
		LOGGER.info("oldType : "+oldType);
		String type=model.getType();
		LOGGER.info("new type : "+type);
		
		List<Employee> employees=new ArrayList<>();
		if("unit".equalsIgnoreCase(type)) {
			employees = EmployeeLocalServiceUtil.getEmployeeByOrganizationId(model.getOrganizationId());
		}else if("section".equalsIgnoreCase(type)) {
			employees = EmployeeLocalServiceUtil.getEmployeesBySubOrganizationId(model.getOrganizationId());
		}
		LOGGER.info("employees size::"+ employees.size());
		for(Employee employee:employees) {
			
			List<String> attributes=new ArrayList<String>();
			List<String> oldValues=new ArrayList<String>();
			List<String> newValues=new ArrayList<String>();
			
			try {
				if("unit".equalsIgnoreCase(type)) {
					if(!StringUtils.equals(oldCode,code)) {
						
						attributes.add("unitcode");
						oldValues.add(oldCode);
						newValues.add(code);
					}
					if(!StringUtils.equals(oldName,name)) {
						
						attributes.add("unit");
						oldValues.add(oldName);
						newValues.add(name);
					}
					
					if(!StringUtils.equals(oldLongName,longName)) {
						
						attributes.add("unitdescription");
						oldValues.add(oldLongName);
						newValues.add(longName);
					}
				}
				else if("section".equalsIgnoreCase(type)) {
					if(!StringUtils.equals(oldCode,code)) {
						
						attributes.add("sectioncode");
						oldValues.add(oldCode);
						newValues.add(code);
					}
					if(!StringUtils.equals(oldName,name)) {
						
						attributes.add("section");
						oldValues.add(oldName);
						newValues.add(name);
					}
					
					if(!StringUtils.equals(oldLongName,longName)) {
						
						attributes.add("sectiondescription");
						oldValues.add(oldLongName);
						newValues.add(longName);
					}
				}
				else if("division".equalsIgnoreCase(type)) {
					if(!StringUtils.equals(oldCode,code)) {
						
						attributes.add("divisioncode");
						oldValues.add(oldCode);
						newValues.add(code);
					}
					if(!StringUtils.equals(oldName,name)) {
						
						attributes.add("division");
						oldValues.add(oldName);
						newValues.add(name);
					}
					
					if(!StringUtils.equals(oldLongName,longName)) {
						
						attributes.add("divisiondescription");
						oldValues.add(oldLongName);
						newValues.add(longName);
					}
				}
					
			} catch (Exception e1) {
				LOGGER.error(e1.getMessage());
			}
			
			
			boolean status=PISUserUtil.updateIDAMUser(employee.getLoginId(), attributes, oldValues, newValues);
			LOGGER.info("attributes"+attributes);
			LOGGER.info("oldValues"+oldValues);
			LOGGER.info("newValues"+newValues);
			
			//status=false;
			if(!status) {
				saveIDAMFailedTransaction(model,attributes,oldValues,newValues,employee.getEmployeeId());
			}
		}

	}
	
	private void saveIDAMFailedTransaction(Organization model, List<String> attributes, List<String> oldValues,
			List<String> newValues, long employeeId) {
		
		IDAMFailedTransaction idamFailedTransaction = IDAMFailedTransactionLocalServiceUtil.createIDAMFailedTransaction(CounterLocalServiceUtil.increment());
		idamFailedTransaction.setEmployeeId(employeeId);
		idamFailedTransaction.setIdamUrl(PISUserUtil.getIdamAPIEndPoint());
		idamFailedTransaction.setFiredon(new Date());
		idamFailedTransaction.setClassId(model.getOrganizationId());
		idamFailedTransaction.setClassName(Organization.class.getSimpleName());
		idamFailedTransaction.setAttribute(String.join(",", attributes));;
		idamFailedTransaction.setOldValue(String.join(",",oldValues));
		idamFailedTransaction.setNewValue(String.join(",", newValues));;
		IDAMFailedTransactionLocalServiceUtil.updateIDAMFailedTransaction(idamFailedTransaction);
		
	}

	private boolean isUniqueCode(Organization model, String code) {
		long companyId=0;
		companyId=model.getCompanyId();
		if(companyId==0) {
			companyId=CompanyThreadLocal.getCompanyId();
		}
		

		LOGGER.info("companyId == "+companyId);
		
		boolean unique=true;
		List<ExpandoValue> values=ExpandoValueLocalServiceUtil.getColumnValues(companyId, Organization.class.getName(), "CUSTOM_FIELDS", "code", code, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(values!=null && values.size()>1) {
			for(ExpandoValue value:values) {
				LOGGER.info("ClassPK == "+value.getClassPK()+", value.getData() : "+value.getData());
				if(value.getClassPK()==model.getOrganizationId()) {
					continue;
				}
				try {
					Organization org=OrganizationLocalServiceUtil.getOrganization(value.getClassPK());
					LOGGER.info("org.getOrganizationId() :"+org.getOrganizationId() +", org.getName() : "+org.getName() +", org.getType() == "+org.getType()+", code: "+org.getExpandoBridge().getAttribute("code"));
					
					if("division".equalsIgnoreCase(org.getType()) && "division".equalsIgnoreCase(model.getType()) ) {
						unique=false;
						break;
					}
					
					LOGGER.info("Condition : "+("unit".equalsIgnoreCase(org.getType()) && "unit".equalsIgnoreCase(model.getType())));
					
					if("unit".equalsIgnoreCase(org.getType()) && "unit".equalsIgnoreCase(model.getType()) ) {
						unique=false;
						break;
					}
					
					if("section".equalsIgnoreCase(org.getType()) && "section".equalsIgnoreCase(model.getType()) ) {
						if(org.getParentOrganizationId()==model.getParentOrganizationId()) {
							unique=false;
							break;
						}
					}
					
                    if("institute".equalsIgnoreCase(org.getType()) && "institute".equalsIgnoreCase(model.getType()) ) {
                        if(org.getParentOrganizationId()==model.getParentOrganizationId()) {
                                unique=false;
                                LOGGER.info("OrganizationModelListener:onBeforeCreate if(\"institute\".equalsIgnoreCase(org.getType()) && \"institute\".equalsIgnoreCase(model.getType()) )"+unique);
                                break;
                        }
                }
					
				} catch (PortalException e) {
					LOGGER.error(e.getMessage());
				}				
			}
		}		
		return unique;
	}

}
