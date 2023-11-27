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

package com.adjecti.mdm.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.TrainingCourseServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TrainingCourseSoap implements Serializable {

	public static TrainingCourseSoap toSoapModel(TrainingCourse model) {
		TrainingCourseSoap soapModel = new TrainingCourseSoap();

		soapModel.setTrainingCourseId(model.getTrainingCourseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setDescription(model.getDescription());
		soapModel.setInstitution(model.getInstitution());
		soapModel.setLocationOfInstitute(model.getLocationOfInstitute());
		soapModel.setName(model.getName());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setSpecializationId(model.getSpecializationId());
		soapModel.setStateInstituteId(model.getStateInstituteId());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static TrainingCourseSoap[] toSoapModels(TrainingCourse[] models) {
		TrainingCourseSoap[] soapModels = new TrainingCourseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TrainingCourseSoap[][] toSoapModels(
		TrainingCourse[][] models) {

		TrainingCourseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TrainingCourseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TrainingCourseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TrainingCourseSoap[] toSoapModels(
		List<TrainingCourse> models) {

		List<TrainingCourseSoap> soapModels = new ArrayList<TrainingCourseSoap>(
			models.size());

		for (TrainingCourse model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TrainingCourseSoap[soapModels.size()]);
	}

	public TrainingCourseSoap() {
	}

	public long getPrimaryKey() {
		return _trainingCourseId;
	}

	public void setPrimaryKey(long pk) {
		setTrainingCourseId(pk);
	}

	public long getTrainingCourseId() {
		return _trainingCourseId;
	}

	public void setTrainingCourseId(long trainingCourseId) {
		_trainingCourseId = trainingCourseId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getInstitution() {
		return _institution;
	}

	public void setInstitution(String institution) {
		_institution = institution;
	}

	public String getLocationOfInstitute() {
		return _locationOfInstitute;
	}

	public void setLocationOfInstitute(String locationOfInstitute) {
		_locationOfInstitute = locationOfInstitute;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getSpecializationId() {
		return _specializationId;
	}

	public void setSpecializationId(long specializationId) {
		_specializationId = specializationId;
	}

	public long getStateInstituteId() {
		return _stateInstituteId;
	}

	public void setStateInstituteId(long stateInstituteId) {
		_stateInstituteId = stateInstituteId;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _trainingCourseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _description;
	private String _institution;
	private String _locationOfInstitute;
	private String _name;
	private long _organizationId;
	private long _specializationId;
	private long _stateInstituteId;
	private boolean _deleted;
	private int _status;

}