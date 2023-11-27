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

package com.adjecti.pis.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeQualificationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeQualificationSoap implements Serializable {

	public static EmployeeQualificationSoap toSoapModel(
		EmployeeQualification model) {

		EmployeeQualificationSoap soapModel = new EmployeeQualificationSoap();

		soapModel.setEmployeeQualificationId(
			model.getEmployeeQualificationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setForeignDegree(model.isForeignDegree());
		soapModel.setForeignInstitution(model.getForeignInstitution());
		soapModel.setFromYear(model.getFromYear());
		soapModel.setMarksSecured(model.getMarksSecured());
		soapModel.setToYear(model.getToYear());
		soapModel.setDocumentProofId(model.getDocumentProofId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGradeId(model.getGradeId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setQualificationId(model.getQualificationId());
		soapModel.setSpecializationId(model.getSpecializationId());
		soapModel.setMarksPercentage(model.getMarksPercentage());
		soapModel.setPassedDate(model.getPassedDate());
		soapModel.setCertificateId(model.getCertificateId());
		soapModel.setQualificationDate(model.getQualificationDate());
		soapModel.setInstitution(model.getInstitution());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeQualificationSoap[] toSoapModels(
		EmployeeQualification[] models) {

		EmployeeQualificationSoap[] soapModels =
			new EmployeeQualificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeQualificationSoap[][] toSoapModels(
		EmployeeQualification[][] models) {

		EmployeeQualificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeQualificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeQualificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeQualificationSoap[] toSoapModels(
		List<EmployeeQualification> models) {

		List<EmployeeQualificationSoap> soapModels =
			new ArrayList<EmployeeQualificationSoap>(models.size());

		for (EmployeeQualification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeQualificationSoap[soapModels.size()]);
	}

	public EmployeeQualificationSoap() {
	}

	public long getPrimaryKey() {
		return _employeeQualificationId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeQualificationId(pk);
	}

	public long getEmployeeQualificationId() {
		return _employeeQualificationId;
	}

	public void setEmployeeQualificationId(long employeeQualificationId) {
		_employeeQualificationId = employeeQualificationId;
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

	public boolean getForeignDegree() {
		return _foreignDegree;
	}

	public boolean isForeignDegree() {
		return _foreignDegree;
	}

	public void setForeignDegree(boolean foreignDegree) {
		_foreignDegree = foreignDegree;
	}

	public String getForeignInstitution() {
		return _foreignInstitution;
	}

	public void setForeignInstitution(String foreignInstitution) {
		_foreignInstitution = foreignInstitution;
	}

	public int getFromYear() {
		return _fromYear;
	}

	public void setFromYear(int fromYear) {
		_fromYear = fromYear;
	}

	public float getMarksSecured() {
		return _marksSecured;
	}

	public void setMarksSecured(float marksSecured) {
		_marksSecured = marksSecured;
	}

	public int getToYear() {
		return _toYear;
	}

	public void setToYear(int toYear) {
		_toYear = toYear;
	}

	public long getDocumentProofId() {
		return _documentProofId;
	}

	public void setDocumentProofId(long documentProofId) {
		_documentProofId = documentProofId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getGradeId() {
		return _gradeId;
	}

	public void setGradeId(long gradeId) {
		_gradeId = gradeId;
	}

	public long getLevelId() {
		return _levelId;
	}

	public void setLevelId(long levelId) {
		_levelId = levelId;
	}

	public long getQualificationId() {
		return _qualificationId;
	}

	public void setQualificationId(long qualificationId) {
		_qualificationId = qualificationId;
	}

	public long getSpecializationId() {
		return _specializationId;
	}

	public void setSpecializationId(long specializationId) {
		_specializationId = specializationId;
	}

	public long getMarksPercentage() {
		return _marksPercentage;
	}

	public void setMarksPercentage(long marksPercentage) {
		_marksPercentage = marksPercentage;
	}

	public Date getPassedDate() {
		return _passedDate;
	}

	public void setPassedDate(Date passedDate) {
		_passedDate = passedDate;
	}

	public long getCertificateId() {
		return _certificateId;
	}

	public void setCertificateId(long certificateId) {
		_certificateId = certificateId;
	}

	public Date getQualificationDate() {
		return _qualificationDate;
	}

	public void setQualificationDate(Date qualificationDate) {
		_qualificationDate = qualificationDate;
	}

	public String getInstitution() {
		return _institution;
	}

	public void setInstitution(String institution) {
		_institution = institution;
	}

	public long getJoiningProcessId() {
		return _joiningProcessId;
	}

	public void setJoiningProcessId(long joiningProcessId) {
		_joiningProcessId = joiningProcessId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeeQualificationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _foreignDegree;
	private String _foreignInstitution;
	private int _fromYear;
	private float _marksSecured;
	private int _toYear;
	private long _documentProofId;
	private long _employeeId;
	private long _gradeId;
	private long _levelId;
	private long _qualificationId;
	private long _specializationId;
	private long _marksPercentage;
	private Date _passedDate;
	private long _certificateId;
	private Date _qualificationDate;
	private String _institution;
	private long _joiningProcessId;
	private int _status;

}