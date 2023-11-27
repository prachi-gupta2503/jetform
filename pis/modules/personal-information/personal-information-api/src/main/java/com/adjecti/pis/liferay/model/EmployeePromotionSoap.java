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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeePromotionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeePromotionSoap implements Serializable {

	public static EmployeePromotionSoap toSoapModel(EmployeePromotion model) {
		EmployeePromotionSoap soapModel = new EmployeePromotionSoap();

		soapModel.setEmployeePromotionId(model.getEmployeePromotionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setPromotionDate(model.getPromotionDate());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGradeId(model.getGradeId());
		soapModel.setGradeModeId(model.getGradeModeId());
		soapModel.setPromotionLetterId(model.getPromotionLetterId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setPersonalNo(model.getPersonalNo());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeePromotionSoap[] toSoapModels(
		EmployeePromotion[] models) {

		EmployeePromotionSoap[] soapModels =
			new EmployeePromotionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeePromotionSoap[][] toSoapModels(
		EmployeePromotion[][] models) {

		EmployeePromotionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeePromotionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeePromotionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeePromotionSoap[] toSoapModels(
		List<EmployeePromotion> models) {

		List<EmployeePromotionSoap> soapModels =
			new ArrayList<EmployeePromotionSoap>(models.size());

		for (EmployeePromotion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeePromotionSoap[soapModels.size()]);
	}

	public EmployeePromotionSoap() {
	}

	public long getPrimaryKey() {
		return _employeePromotionId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeePromotionId(pk);
	}

	public long getEmployeePromotionId() {
		return _employeePromotionId;
	}

	public void setEmployeePromotionId(long employeePromotionId) {
		_employeePromotionId = employeePromotionId;
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

	public Date getPromotionDate() {
		return _promotionDate;
	}

	public void setPromotionDate(Date promotionDate) {
		_promotionDate = promotionDate;
	}

	public long getDesignationId() {
		return _designationId;
	}

	public void setDesignationId(long designationId) {
		_designationId = designationId;
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

	public long getGradeModeId() {
		return _gradeModeId;
	}

	public void setGradeModeId(long gradeModeId) {
		_gradeModeId = gradeModeId;
	}

	public long getPromotionLetterId() {
		return _promotionLetterId;
	}

	public void setPromotionLetterId(long promotionLetterId) {
		_promotionLetterId = promotionLetterId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getPersonalNo() {
		return _personalNo;
	}

	public void setPersonalNo(long personalNo) {
		_personalNo = personalNo;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeePromotionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private Date _promotionDate;
	private long _designationId;
	private long _employeeId;
	private long _gradeId;
	private long _gradeModeId;
	private long _promotionLetterId;
	private long _organizationId;
	private long _personalNo;
	private int _status;

}