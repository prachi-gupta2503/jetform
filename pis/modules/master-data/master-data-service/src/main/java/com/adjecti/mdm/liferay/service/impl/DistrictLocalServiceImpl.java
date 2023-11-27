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
import com.adjecti.mdm.liferay.model.District;
import com.adjecti.mdm.liferay.service.DistrictLocalServiceUtil;
import com.adjecti.mdm.liferay.service.base.DistrictLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the district local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.DistrictLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DistrictLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.mdm.liferay.model.District",
	service = AopService.class
)
public class DistrictLocalServiceImpl extends DistrictLocalServiceBaseImpl {

	public List<District> getDistrictList(long stateId){
		List<District> list=new ArrayList<District>();
		List<District> districts=DistrictLocalServiceUtil.getDistricts(0, DistrictLocalServiceUtil.getDistrictsCount());
	    for(District district:districts) {
	    	if(stateId==district.getStateId()) {
	    		list.add(district);
	    	}
	    }
	    return list;
	}
	
	public List<District> getByDistrictIdAndDeleted(long districtId,boolean deleted){
			
	    return districtPersistence.findByDistrictIdAndDeleted(districtId,deleted);
	}
	public List<District> getByStateIdAndDeleted(long stateId,boolean deleted){
		
	    return districtPersistence.findByDistrictList(stateId, deleted);
	}
}