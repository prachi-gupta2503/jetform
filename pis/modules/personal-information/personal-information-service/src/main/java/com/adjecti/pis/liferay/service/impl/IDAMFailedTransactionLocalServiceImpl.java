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

package com.adjecti.pis.liferay.service.impl;

import com.adjecti.pis.liferay.exception.NoSuchIDAMFailedTransactionException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.IDAMFailedTransaction;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.IDAMFailedTransactionLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.IDAMFailedTransactionLocalServiceBaseImpl;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Arrays;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the idam failed transaction local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.IdamFailedTransactionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IdamFailedTransactionLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.IdamFailedTransaction",
	service = AopService.class
)
public class IDAMFailedTransactionLocalServiceImpl
	extends IDAMFailedTransactionLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.pis.liferay.service.IdamFailedTransactionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.pis.liferay.service.IdamFailedTransactionLocalServiceUtil</code>.
	 */
	private final static Log _logger = LogFactoryUtil.getLog(IDAMFailedTransaction.class.getName());
	
	public boolean updateIdamEmployee(long idamFailedTransactionId){
	 try {
		IDAMFailedTransaction idamFailedTransaction = IDAMFailedTransactionLocalServiceUtil.getIDAMFailedTransaction(idamFailedTransactionId);
	    Employee employee = EmployeeLocalServiceUtil.getEmployee(idamFailedTransaction.getEmployeeId());
	    String[] strAttributes=idamFailedTransaction.getAttribute().split(",");
	    String[] strOldValues=idamFailedTransaction.getOldValue().split(",");
	    String[] strNewValues=idamFailedTransaction.getNewValue().split(",");
	    List<String> attributes=Arrays.asList(strAttributes);
	    List<String> oldValues=Arrays.asList(strOldValues);
	    List<String> newValues=Arrays.asList(strNewValues);
	   
	    return PISUserUtil.updateIDAMUser(employee.getLoginId(), attributes,oldValues, newValues);
	 } catch ( Exception e) {
		 _logger.error(e);
		}
	 
	 return false;
	 }
	
	public void deleteIdamFailedTransaction(long idamFailedTransactionId) {
		try {
			idamFailedTransactionPersistence.remove(idamFailedTransactionId);
		} catch (NoSuchIDAMFailedTransactionException e) {
			 _logger.error(e);
		}
	}
	
	
}