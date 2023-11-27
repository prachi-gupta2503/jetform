package com.adjecti.pis.ext.listener;

import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class UserEntityListener extends BaseModelListener<User> {
	
	final static Log LOGGER = LogFactoryUtil.getLog(UserEntityListener.class.getName());
	
	@Override
	public void onAfterCreate(User model) throws ModelListenerException {
		LOGGER.info("UserEntityListener:onAfterCreate called");
	}
	
	@Override
	public void onAfterUpdate(User model) throws ModelListenerException {
		LOGGER.info("UserEntityListener:onAfterUpdate called");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
		LOGGER.info("UserEntityListener:onAfterAddAssociation called");
	}

	@Override
	public void onAfterRemove(User model) throws ModelListenerException {
		LOGGER.info("UserEntityListener:onAfterRemove called");
		try {
			Employee employee=EmployeeLocalServiceUtil.getEmployeeByEmailId(model.getEmailAddress());
			EmployeeLocalServiceUtil.deleteEmployee(employee.getEmployeeId(), true);
			LOGGER.info("UserEntityListener:onAfterRemove employee was deleted successfully");
		} catch (Exception e) {
			LOGGER.error("UserEntityListener:onAfterRemove failed", e);
		}
		
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		LOGGER.info("UserEntityListener:onAfterRemoveAssociation called");
	}
	
	@Override
	public void onBeforeCreate(User model) throws ModelListenerException {
		LOGGER.info("UserEntityListener:onBeforeCreate called");
	}

	@Override
	public void onBeforeRemove(User model) throws ModelListenerException {
		LOGGER.info("UserEntityListener:onBeforeRemove called");
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		LOGGER.info("UserEntityListener:onBeforeRemoveAssociation called");
	}

	@Override
	public void onBeforeUpdate(User model) throws ModelListenerException {
		LOGGER.info("UserEntityListener:onBeforeUpdate called");
	}
}
