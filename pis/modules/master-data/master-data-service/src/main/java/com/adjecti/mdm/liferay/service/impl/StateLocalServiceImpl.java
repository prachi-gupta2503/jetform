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

package com.adjecti.mdm.liferay.service.impl;

import com.adjecti.mdm.liferay.model.State;
import com.adjecti.mdm.liferay.service.StateLocalServiceUtil;
import com.adjecti.mdm.liferay.service.base.StateLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the state local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.StateLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StateLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.mdm.liferay.model.State",
	service = AopService.class
)
public class StateLocalServiceImpl extends StateLocalServiceBaseImpl {
	private final static Log LOGGER = LogFactoryUtil.getLog(StateLocalServiceImpl.class.getName());
	public List<State> getStateList(long countryId){

		List<State> list=new ArrayList<State>();
		List<State> states=StateLocalServiceUtil.getStates(0, StateLocalServiceUtil.getStatesCount());
		LOGGER.info(states);
	    for(State state:states) {
	    	if(countryId==state.getCountryId()) {
	    		list.add(state);
	    	}
	    }
	   
		return list;
	}
}