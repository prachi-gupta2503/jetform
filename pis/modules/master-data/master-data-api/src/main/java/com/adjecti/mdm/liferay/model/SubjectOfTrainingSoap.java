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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.SubjectOfTrainingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SubjectOfTrainingSoap implements Serializable {

	public static SubjectOfTrainingSoap toSoapModel(SubjectOfTraining model) {
		SubjectOfTrainingSoap soapModel = new SubjectOfTrainingSoap();

		soapModel.setSubjectOfTrainingId(model.getSubjectOfTrainingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setCode(model.getCode());
		soapModel.setTrainingSubject(model.getTrainingSubject());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SubjectOfTrainingSoap[] toSoapModels(
		SubjectOfTraining[] models) {

		SubjectOfTrainingSoap[] soapModels =
			new SubjectOfTrainingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubjectOfTrainingSoap[][] toSoapModels(
		SubjectOfTraining[][] models) {

		SubjectOfTrainingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SubjectOfTrainingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubjectOfTrainingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubjectOfTrainingSoap[] toSoapModels(
		List<SubjectOfTraining> models) {

		List<SubjectOfTrainingSoap> soapModels =
			new ArrayList<SubjectOfTrainingSoap>(models.size());

		for (SubjectOfTraining model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubjectOfTrainingSoap[soapModels.size()]);
	}

	public SubjectOfTrainingSoap() {
	}

	public long getPrimaryKey() {
		return _subjectOfTrainingId;
	}

	public void setPrimaryKey(long pk) {
		setSubjectOfTrainingId(pk);
	}

	public long getSubjectOfTrainingId() {
		return _subjectOfTrainingId;
	}

	public void setSubjectOfTrainingId(long subjectOfTrainingId) {
		_subjectOfTrainingId = subjectOfTrainingId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getTrainingSubject() {
		return _trainingSubject;
	}

	public void setTrainingSubject(String trainingSubject) {
		_trainingSubject = trainingSubject;
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

	private long _subjectOfTrainingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private String _code;
	private String _trainingSubject;
	private boolean _deleted;
	private int _status;

}