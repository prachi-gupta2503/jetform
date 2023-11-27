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

package com.adjecti.pis.service.impl;

import com.adjecti.pis.model.BulkOnbordingFile;
import com.adjecti.pis.service.base.BulkOnbordingFileLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the bulk onbording file local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.service.BulkOnbordingFileLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BulkOnbordingFileLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.model.BulkOnbordingFile",
	service = AopService.class
)
public class BulkOnbordingFileLocalServiceImpl
	extends BulkOnbordingFileLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.pis.service.BulkOnbordingFileLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.pis.service.BulkOnbordingFileLocalServiceUtil</code>.
	 */
	
	public List<BulkOnbordingFile> getBulkOnboardingRecordsByUserId(long userId) throws PortalException {
		return bulkOnbordingFilePersistence.findByUserId(userId);
		
	}
	
	public List<BulkOnbordingFile> getBulkOnboardingRecords(long userId, long unitId) throws PortalException {
		return bulkOnbordingFilePersistence.findByUnitId(unitId);
			
	}
	

	public int getBulkOnbordingFilesCount(long unitId) {
		return bulkOnbordingFilePersistence.countByUnitId(unitId);
	}
	
	public int getUploadedRecordsCount(long unitId) {
		int recordsCount = 0;
		List<BulkOnbordingFile> onboardingFiles = bulkOnbordingFilePersistence.findByUnitId(unitId);
		for(BulkOnbordingFile bulkOnbordingFile : onboardingFiles ) {
			recordsCount = recordsCount + bulkOnbordingFile.getTotalRecords().intValue();
		}
		return recordsCount;
	}
	
}