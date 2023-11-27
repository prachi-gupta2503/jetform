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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeConfirmationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeConfirmationSoap implements Serializable {

	public static EmployeeConfirmationSoap toSoapModel(
		EmployeeConfirmation model) {

		EmployeeConfirmationSoap soapModel = new EmployeeConfirmationSoap();

		soapModel.setEmployeeConfirmationId(model.getEmployeeConfirmationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setConfirmationDate(model.getConfirmationDate());
		soapModel.setConfirmationLetterId(model.getConfirmationLetterId());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setGradeId(model.getGradeId());
		soapModel.setGradeModeId(model.getGradeModeId());
		soapModel.setJoiningId(model.getJoiningId());
		soapModel.setPromotionId(model.getPromotionId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setConfirmationPostId(model.getConfirmationPostId());
		soapModel.setStatus(model.getStatus());
		soapModel.setEmployeeId(model.getEmployeeId());

		return soapModel;
	}

	public static EmployeeConfirmationSoap[] toSoapModels(
		EmployeeConfirmation[] models) {

		EmployeeConfirmationSoap[] soapModels =
			new EmployeeConfirmationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeConfirmationSoap[][] toSoapModels(
		EmployeeConfirmation[][] models) {

		EmployeeConfirmationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeConfirmationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeConfirmationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeConfirmationSoap[] toSoapModels(
		List<EmployeeConfirmation> models) {

		List<EmployeeConfirmationSoap> soapModels =
			new ArrayList<EmployeeConfirmationSoap>(models.size());

		for (EmployeeConfirmation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeConfirmationSoap[soapModels.size()]);
	}

	public EmployeeConfirmationSoap() {
	}

	public long getPrimaryKey() {
		return _employeeConfirmationId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeConfirmationId(pk);
	}

	public long getEmployeeConfirmationId() {
		return _employeeConfirmationId;
	}

	public void setEmployeeConfirmationId(long employeeConfirmationId) {
		_employeeConfirmationId = employeeConfirmationId;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Date getConfirmationDate() {
		return _confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		_confirmationDate = confirmationDate;
	}

	public long getConfirmationLetterId() {
		return _confirmationLetterId;
	}

	public void setConfirmationLetterId(long confirmationLetterId) {
		_confirmationLetterId = confirmationLetterId;
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

	public long getGradeModeId() {
		return _gradeModeId;
	}

	public void setGradeModeId(long gradeModeId) {
		_gradeModeId = gradeModeId;
	}

	public long getJoiningId() {
		return _joiningId;
	}

	public void setJoiningId(long joiningId) {
		_joiningId = joiningId;
	}

	public long getPromotionId() {
		return _promotionId;
	}

	public void setPromotionId(long promotionId) {
		_promotionId = promotionId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getConfirmationPostId() {
		return _confirmationPostId;
	}

	public void setConfirmationPostId(long confirmationPostId) {
		_confirmationPostId = confirmationPostId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	private long _employeeConfirmationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private Date _confirmationDate;
	private long _confirmationLetterId;
	private long _designationId;
	private long _gradeId;
	private long _gradeModeId;
	private long _joiningId;
	private long _promotionId;
	private long _organizationId;
	private long _confirmationPostId;
	private int _status;
	private long _employeeId;

}