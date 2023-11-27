package com.adjecti.pis.ext.listener;

import com.adjecti.pis.liferay.model.EmployeeTraining;
import com.adjecti.pis.liferay.service.EmployeeTrainingLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.osgi.service.component.annotations.Component;
@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class EmployeeTrainingModelListener extends BaseModelListener<EmployeeTraining>  {
	static final Log LOGGER = LogFactoryUtil.getLog(EmployeeTrainingModelListener.class.getName());
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(EmployeeTraining model) throws ModelListenerException {
		LOGGER.info("AfterCreate");
		
	}

	@Override
	public void onAfterRemove(EmployeeTraining model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterRemove(model);
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterUpdate(EmployeeTraining model) throws ModelListenerException {
			     /*try {
			d1 = sdf.parse("2020-11-16 00:00:00");
			d2 = sdf.parse("2020-11-18 13:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     long difference_In_Time= d2.getTime() - d1.getTime();
	     int difference_In_Days=(int) ((difference_In_Time/ (1000 * 60 * 60 * 24))% 365);
	     System.out.println("Days "+difference_In_Days);
	     model.setDurationMonths(difference_In_Days);
	     EmployeeTrainingLocalServiceUtil.updateEmployeeTraining(model);*/
}

	@Override
	public void onBeforeAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeCreate(EmployeeTraining model) throws ModelListenerException {
		LOGGER.info("BeforeCreate");
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	     String startDate = sdf.format(model.getStartDate());
	     String endDate = sdf.format(model.getEndDate());
	     LOGGER.info("startDate  "+startDate);
	     LOGGER.info("endtDate  "+endDate);
		 LocalDate d1 = LocalDate.parse(startDate);  
	     LocalDate d2 = LocalDate.parse(endDate);  
	     LOGGER.info("D1! "+d1);
	     LOGGER.info("D2! "+d2);
	     int daysSinceJava8Released = 0;
	     daysSinceJava8Released = ((int) ChronoUnit.DAYS.between(d1, d2))+1;
	       
	     LOGGER.info("daysSinceJava8Released "+daysSinceJava8Released);
	     model.setDurationMonths(daysSinceJava8Released);
	     
	}

	@Override
	public void onBeforeRemove(EmployeeTraining model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemove(model);
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(EmployeeTraining model) throws ModelListenerException {
		LOGGER.info("BeforeUpdate");

		 SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		    
	     String startDate = sdf.format(model.getStartDate());
	     String endDate = sdf.format(model.getEndDate());
	     LOGGER.info("startDate  "+startDate);
	     LOGGER.info("endDate  "+endDate);
		 LocalDate d1 = LocalDate.parse(startDate);  
	     LocalDate d2 = LocalDate.parse(endDate);  
	     LOGGER.info("D1! "+d1);
	     LOGGER.info("D2! "+d2);
	     int daysSinceJava8Released = 0;
	     
	    	 daysSinceJava8Released =((int) ChronoUnit.DAYS.between(d1, d2))+1;
	     
	    
	     LOGGER.info("daysSinceJava8Released "+daysSinceJava8Released);
	     model.setDurationMonths(daysSinceJava8Released);
	    

	
	}

}
