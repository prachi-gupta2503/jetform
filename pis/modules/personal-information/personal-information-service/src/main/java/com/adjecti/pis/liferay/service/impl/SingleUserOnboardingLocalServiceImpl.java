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

import com.adjecti.pis.liferay.model.SingleUserOnboarding;
import com.adjecti.pis.liferay.service.SingleUserOnboardingLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.SingleUserOnboardingLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the single user onboarding local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.SingleUserOnboardingLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SingleUserOnboardingLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.SingleUserOnboarding",
	service = AopService.class
)
public class SingleUserOnboardingLocalServiceImpl
	extends SingleUserOnboardingLocalServiceBaseImpl {

public int currentStatusBySingleUserOnboardingId(long singleUserOnboardingId) throws PortalException {
		
		
		return 	SingleUserOnboardingLocalServiceUtil.getSingleUserOnboarding(singleUserOnboardingId).getStatus();		
		
	}
public String updateStatusBySingleUserOnboardingId(long SingleUserOnboardingId,int status) throws PortalException {
	
	      SingleUserOnboarding singleUserOnboarding = SingleUserOnboardingLocalServiceUtil.getSingleUserOnboarding(SingleUserOnboardingId);
	      singleUserOnboarding.setStatus(status);
	      singleUserOnboarding.setReason("");
	      SingleUserOnboardingLocalServiceUtil.updateSingleUserOnboarding(singleUserOnboarding);
	return 	"";		
	
}

public List<SingleUserOnboarding> getByUnitId(String unitId)
{
return singleUserOnboardingPersistence.findByUnit(unitId);	
}
public List<SingleUserOnboarding> getBySectionAndStatus(long sectionId,int status){
	return singleUserOnboardingPersistence.findBySectionAndStatus(sectionId, status);
}

}