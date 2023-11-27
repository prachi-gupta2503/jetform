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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeSoap implements Serializable {

	public static EmployeeSoap toSoapModel(Employee model) {
		EmployeeSoap soapModel = new EmployeeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setState(model.getState());
		soapModel.setPersonalNo(model.getPersonalNo());
		soapModel.setPeopleId(model.getPeopleId());
		soapModel.setEmailId(model.getEmailId());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setGradeId(model.getGradeId());
		soapModel.setPayLevelId(model.getPayLevelId());
		soapModel.setPostId(model.getPostId());
		soapModel.setTradeId(model.getTradeId());
		soapModel.setCadreId(model.getCadreId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setSubOrganizationId(model.getSubOrganizationId());
		soapModel.setGradeModeId(model.getGradeModeId());
		soapModel.setDesignationClassId(model.getDesignationClassId());
		soapModel.setDesignationGroupId(model.getDesignationGroupId());
		soapModel.setPostName(model.getPostName());
		soapModel.setEmploymentStatus(model.getEmploymentStatus());
		soapModel.setDateOfJoining(model.getDateOfJoining());
		soapModel.setDateOfJoiningOrganization(
			model.getDateOfJoiningOrganization());
		soapModel.setCurrentDesignationDate(model.getCurrentDesignationDate());
		soapModel.setRetirementDate(model.getRetirementDate());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());
		soapModel.setProcessType(model.getProcessType());
		soapModel.setLoginId(model.getLoginId());
		soapModel.setBioData(model.getBioData());
		soapModel.setMessage(model.getMessage());
		soapModel.setGpfNps(model.getGpfNps());
		soapModel.setGpfNpsNo(model.getGpfNpsNo());
		soapModel.setRank(model.getRank());

		return soapModel;
	}

	public static EmployeeSoap[] toSoapModels(Employee[] models) {
		EmployeeSoap[] soapModels = new EmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[][] toSoapModels(Employee[][] models) {
		EmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[] toSoapModels(List<Employee> models) {
		List<EmployeeSoap> soapModels = new ArrayList<EmployeeSoap>(
			models.size());

		for (Employee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeSoap[soapModels.size()]);
	}

	public EmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _employeeId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getPersonalNo() {
		return _personalNo;
	}

	public void setPersonalNo(String personalNo) {
		_personalNo = personalNo;
	}

	public long getPeopleId() {
		return _peopleId;
	}

	public void setPeopleId(long peopleId) {
		_peopleId = peopleId;
	}

	public String getEmailId() {
		return _emailId;
	}

	public void setEmailId(String emailId) {
		_emailId = emailId;
	}

	public long getDesignationId() {
		return _designationId;
	}

	public void setDesignationId(long designationId) {
		_designationId = designationId;
	}

	public long getGradeId() {
		return _gradeId;
	}

	public void setGradeId(long gradeId) {
		_gradeId = gradeId;
	}

	public long getPayLevelId() {
		return _payLevelId;
	}

	public void setPayLevelId(long payLevelId) {
		_payLevelId = payLevelId;
	}

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
	}

	public long getTradeId() {
		return _tradeId;
	}

	public void setTradeId(long tradeId) {
		_tradeId = tradeId;
	}

	public long getCadreId() {
		return _cadreId;
	}

	public void setCadreId(long cadreId) {
		_cadreId = cadreId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getSubOrganizationId() {
		return _subOrganizationId;
	}

	public void setSubOrganizationId(long subOrganizationId) {
		_subOrganizationId = subOrganizationId;
	}

	public long getGradeModeId() {
		return _gradeModeId;
	}

	public void setGradeModeId(long gradeModeId) {
		_gradeModeId = gradeModeId;
	}

	public long getDesignationClassId() {
		return _designationClassId;
	}

	public void setDesignationClassId(long designationClassId) {
		_designationClassId = designationClassId;
	}

	public long getDesignationGroupId() {
		return _designationGroupId;
	}

	public void setDesignationGroupId(long designationGroupId) {
		_designationGroupId = designationGroupId;
	}

	public String getPostName() {
		return _postName;
	}

	public void setPostName(String postName) {
		_postName = postName;
	}

	public int getEmploymentStatus() {
		return _employmentStatus;
	}

	public void setEmploymentStatus(int employmentStatus) {
		_employmentStatus = employmentStatus;
	}

	public Date getDateOfJoining() {
		return _dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		_dateOfJoining = dateOfJoining;
	}

	public Date getDateOfJoiningOrganization() {
		return _dateOfJoiningOrganization;
	}

	public void setDateOfJoiningOrganization(Date dateOfJoiningOrganization) {
		_dateOfJoiningOrganization = dateOfJoiningOrganization;
	}

	public Date getCurrentDesignationDate() {
		return _currentDesignationDate;
	}

	public void setCurrentDesignationDate(Date currentDesignationDate) {
		_currentDesignationDate = currentDesignationDate;
	}

	public Date getRetirementDate() {
		return _retirementDate;
	}

	public void setRetirementDate(Date retirementDate) {
		_retirementDate = retirementDate;
	}

	public long getJoiningProcessId() {
		return _joiningProcessId;
	}

	public void setJoiningProcessId(long joiningProcessId) {
		_joiningProcessId = joiningProcessId;
	}

	public String getProcessType() {
		return _processType;
	}

	public void setProcessType(String processType) {
		_processType = processType;
	}

	public String getLoginId() {
		return _loginId;
	}

	public void setLoginId(String loginId) {
		_loginId = loginId;
	}

	public String getBioData() {
		return _bioData;
	}

	public void setBioData(String bioData) {
		_bioData = bioData;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public String getGpfNps() {
		return _gpfNps;
	}

	public void setGpfNps(String gpfNps) {
		_gpfNps = gpfNps;
	}

	public String getGpfNpsNo() {
		return _gpfNpsNo;
	}

	public void setGpfNpsNo(String gpfNpsNo) {
		_gpfNpsNo = gpfNpsNo;
	}

	public int getRank() {
		return _rank;
	}

	public void setRank(int rank) {
		_rank = rank;
	}

	private String _uuid;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _state;
	private String _personalNo;
	private long _peopleId;
	private String _emailId;
	private long _designationId;
	private long _gradeId;
	private long _payLevelId;
	private long _postId;
	private long _tradeId;
	private long _cadreId;
	private long _organizationId;
	private long _subOrganizationId;
	private long _gradeModeId;
	private long _designationClassId;
	private long _designationGroupId;
	private String _postName;
	private int _employmentStatus;
	private Date _dateOfJoining;
	private Date _dateOfJoiningOrganization;
	private Date _currentDesignationDate;
	private Date _retirementDate;
	private long _joiningProcessId;
	private String _processType;
	private String _loginId;
	private String _bioData;
	private String _message;
	private String _gpfNps;
	private String _gpfNpsNo;
	private int _rank;

}