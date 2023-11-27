package com.adjecti.pis.service.persistence.impl;

import com.adjecti.pis.dto.RegistrationRequestSearchParameter;
import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.service.impl.RegistrationRequestLocalServiceImpl;
import com.adjecti.pis.service.persistence.RegistrationRequestFinder;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(service = RegistrationRequestFinder.class)
public class RegistrationRequestFinderImpl extends RegistrationRequestFinderBaseImpl implements RegistrationRequestFinder{
	
	private static Log LOGGER = LogFactoryUtil.getLog(RegistrationRequestFinderImpl.class);
	public List<RegistrationRequest> findBySearchParameter(RegistrationRequestSearchParameter registrationRequestSearchParameter) {

		Session session = null;
		List<RegistrationRequest> requestList = new ArrayList<RegistrationRequest>();
	    try {
	        session = openSession();

	        ClassLoader classLoader = getClass().getClassLoader();

	    
	       DynamicQuery query = DynamicQueryFactoryUtil.forClass(RegistrationRequest.class, classLoader);
	       if(registrationRequestSearchParameter.getUnitIds()!=null && registrationRequestSearchParameter.getUnitIds().length>0) {
	    	   
	    	   query.add(PropertyFactoryUtil.forName("unitId").in(registrationRequestSearchParameter.getUnitIds()));
	       }
	       if(registrationRequestSearchParameter.getGroupIds() !=null && registrationRequestSearchParameter.getGroupIds().length>0) {
	    	   query.add(PropertyFactoryUtil.forName("groupId").in(registrationRequestSearchParameter.getGroupIds()));
	       }
	       if(registrationRequestSearchParameter.getStatuses() != null && registrationRequestSearchParameter.getStatuses().length>0) {
	    	   query.add(PropertyFactoryUtil.forName("status").in(registrationRequestSearchParameter.getStatuses()));
	       }
	      
	       
	       if(registrationRequestSearchParameter.getBulkOnbordingFileId()>0) {
	    	   query.add(PropertyFactoryUtil.forName("bulkOnbordingFileId").eq(registrationRequestSearchParameter.getBulkOnbordingFileId()));
	       }
	       if(registrationRequestSearchParameter.getDesignationId()>0) {
	    	   query.add(PropertyFactoryUtil.forName("designationId").eq(registrationRequestSearchParameter.getDesignationId()));
	       }
	       if(registrationRequestSearchParameter.getGradeId()>0) {
	    	   query.add(PropertyFactoryUtil.forName("gradeId").eq(registrationRequestSearchParameter.getGradeId()));
	       }
	       if(registrationRequestSearchParameter.getTradeId()>0) {
	    	   query.add(PropertyFactoryUtil.forName("tradeId").eq(registrationRequestSearchParameter.getTradeId()));
	       }
	       if(registrationRequestSearchParameter.isExcludeInvalid()) {
	    	   query.add(RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("errorMessage").isNull(), PropertyFactoryUtil.forName("errorMessage").eq("")));
	       }
	     
	       requestList = findWithDynamicQuery(query);

	    }
	    catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	        	LOGGER.info(e);
	        }
	    }
	    finally {
	        closeSession(session);
	    }
		return requestList;
	}
}	
