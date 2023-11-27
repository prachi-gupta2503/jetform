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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeJoiningServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeJoiningSoap implements Serializable {

	public static EmployeeJoiningSoap toSoapModel(EmployeeJoining model) {
		EmployeeJoiningSoap soapModel = new EmployeeJoiningSoap();

		soapModel.setEmployeeJoiningId(model.getEmployeeJoiningId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAadhaarNo(model.getAadhaarNo());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setExServiceMan(model.isExServiceMan());
		soapModel.setPanNo(model.getPanNo());
		soapModel.setPersonalNo(model.getPersonalNo());
		soapModel.setPeopleId(model.getPeopleId());
		soapModel.setFullName(model.getFullName());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setGradeId(model.getGradeId());
		soapModel.setPayLevelId(model.getPayLevelId());
		soapModel.setPostId(model.getPostId());
		soapModel.setTradeId(model.getTradeId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setSubOrganizationId(model.getSubOrganizationId());
		soapModel.setDesignationClassId(model.getDesignationClassId());
		soapModel.setDesignationGroupId(model.getDesignationGroupId());
		soapModel.setJoiningModeId(model.getJoiningModeId());
		soapModel.setJoiningLetterId(model.getJoiningLetterId());
		soapModel.setGradeModeId(model.getGradeModeId());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setSelectionDate(model.getSelectionDate());
		soapModel.setConfirmationDate(model.getConfirmationDate());
		soapModel.setGradeConfirmationDate(model.getGradeConfirmationDate());
		soapModel.setGovtServiceDate(model.getGovtServiceDate());
		soapModel.setRecruitmentBatch(model.getRecruitmentBatch());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setEmailId(model.getEmailId());
		soapModel.setPostBox(model.getPostBox());
		soapModel.setDateOfJoining(model.getDateOfJoining());
		soapModel.setDateOfJoiningOrganization(
			model.getDateOfJoiningOrganization());
		soapModel.setRank(model.getRank());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeJoiningSoap[] toSoapModels(EmployeeJoining[] models) {
		EmployeeJoiningSoap[] soapModels =
			new EmployeeJoiningSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeJoiningSoap[][] toSoapModels(
		EmployeeJoining[][] models) {

		EmployeeJoiningSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeJoiningSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeJoiningSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeJoiningSoap[] toSoapModels(
		List<EmployeeJoining> models) {

		List<EmployeeJoiningSoap> soapModels =
			new ArrayList<EmployeeJoiningSoap>(models.size());

		for (EmployeeJoining model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeJoiningSoap[soapModels.size()]);
	}

	public EmployeeJoiningSoap() {
	}

	public long getPrimaryKey() {
		return _employeeJoiningId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeJoiningId(pk);
	}

	public long getEmployeeJoiningId() {
		return _employeeJoiningId;
	}

	public void setEmployeeJoiningId(long employeeJoiningId) {
		_employeeJoiningId = employeeJoiningId;
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

	public String getAadhaarNo() {
		return _aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		_aadhaarNo = aadhaarNo;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public boolean getExServiceMan() {
		return _exServiceMan;
	}

	public boolean isExServiceMan() {
		return _exServiceMan;
	}

	public void setExServiceMan(boolean exServiceMan) {
		_exServiceMan = exServiceMan;
	}

	public String getPanNo() {
		return _panNo;
	}

	public void setPanNo(String panNo) {
		_panNo = panNo;
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

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
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

	public long getJoiningModeId() {
		return _joiningModeId;
	}

	public void setJoiningModeId(long joiningModeId) {
		_joiningModeId = joiningModeId;
	}

	public long getJoiningLetterId() {
		return _joiningLetterId;
	}

	public void setJoiningLetterId(long joiningLetterId) {
		_joiningLetterId = joiningLetterId;
	}

	public long getGradeModeId() {
		return _gradeModeId;
	}

	public void setGradeModeId(long gradeModeId) {
		_gradeModeId = gradeModeId;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public Date getSelectionDate() {
		return _selectionDate;
	}

	public void setSelectionDate(Date selectionDate) {
		_selectionDate = selectionDate;
	}

	public Date getConfirmationDate() {
		return _confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		_confirmationDate = confirmationDate;
	}

	public Date getGradeConfirmationDate() {
		return _gradeConfirmationDate;
	}

	public void setGradeConfirmationDate(Date gradeConfirmationDate) {
		_gradeConfirmationDate = gradeConfirmationDate;
	}

	public Date getGovtServiceDate() {
		return _govtServiceDate;
	}

	public void setGovtServiceDate(Date govtServiceDate) {
		_govtServiceDate = govtServiceDate;
	}

	public String getRecruitmentBatch() {
		return _recruitmentBatch;
	}

	public void setRecruitmentBatch(String recruitmentBatch) {
		_recruitmentBatch = recruitmentBatch;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public String getEmailId() {
		return _emailId;
	}

	public void setEmailId(String emailId) {
		_emailId = emailId;
	}

	public String getPostBox() {
		return _postBox;
	}

	public void setPostBox(String postBox) {
		_postBox = postBox;
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

	public long getRank() {
		return _rank;
	}

	public void setRank(long rank) {
		_rank = rank;
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

	private long _employeeJoiningId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _aadhaarNo;
	private String _emailAddress;
	private boolean _exServiceMan;
	private String _panNo;
	private String _personalNo;
	private long _peopleId;
	private String _fullName;
	private long _designationId;
	private long _gradeId;
	private long _payLevelId;
	private long _postId;
	private long _tradeId;
	private long _organizationId;
	private long _subOrganizationId;
	private long _designationClassId;
	private long _designationGroupId;
	private long _joiningModeId;
	private long _joiningLetterId;
	private long _gradeModeId;
	private Date _fromDate;
	private Date _toDate;
	private Date _selectionDate;
	private Date _confirmationDate;
	private Date _gradeConfirmationDate;
	private Date _govtServiceDate;
	private String _recruitmentBatch;
	private long _employeeId;
	private String _emailId;
	private String _postBox;
	private Date _dateOfJoining;
	private Date _dateOfJoiningOrganization;
	private long _rank;
	private long _joiningProcessId;
	private int _status;

}