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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeePromotionRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeePromotionRequestSoap implements Serializable {

	public static EmployeePromotionRequestSoap toSoapModel(
		EmployeePromotionRequest model) {

		EmployeePromotionRequestSoap soapModel =
			new EmployeePromotionRequestSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEmployeePromotionRequestId(
			model.getEmployeePromotionRequestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setPromotionModeId(model.getPromotionModeId());
		soapModel.setPromotionDate(model.getPromotionDate());
		soapModel.setOfficeOrderNo(model.getOfficeOrderNo());
		soapModel.setProcessFileId(model.getProcessFileId());
		soapModel.setProcessFileNo(model.getProcessFileNo());

		return soapModel;
	}

	public static EmployeePromotionRequestSoap[] toSoapModels(
		EmployeePromotionRequest[] models) {

		EmployeePromotionRequestSoap[] soapModels =
			new EmployeePromotionRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeePromotionRequestSoap[][] toSoapModels(
		EmployeePromotionRequest[][] models) {

		EmployeePromotionRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeePromotionRequestSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeePromotionRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeePromotionRequestSoap[] toSoapModels(
		List<EmployeePromotionRequest> models) {

		List<EmployeePromotionRequestSoap> soapModels =
			new ArrayList<EmployeePromotionRequestSoap>(models.size());

		for (EmployeePromotionRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeePromotionRequestSoap[soapModels.size()]);
	}

	public EmployeePromotionRequestSoap() {
	}

	public long getPrimaryKey() {
		return _employeePromotionRequestId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeePromotionRequestId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEmployeePromotionRequestId() {
		return _employeePromotionRequestId;
	}

	public void setEmployeePromotionRequestId(long employeePromotionRequestId) {
		_employeePromotionRequestId = employeePromotionRequestId;
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

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public Long getDesignationId() {
		return _designationId;
	}

	public void setDesignationId(Long designationId) {
		_designationId = designationId;
	}

	public Long getPromotionModeId() {
		return _promotionModeId;
	}

	public void setPromotionModeId(Long promotionModeId) {
		_promotionModeId = promotionModeId;
	}

	public Date getPromotionDate() {
		return _promotionDate;
	}

	public void setPromotionDate(Date promotionDate) {
		_promotionDate = promotionDate;
	}

	public String getOfficeOrderNo() {
		return _officeOrderNo;
	}

	public void setOfficeOrderNo(String officeOrderNo) {
		_officeOrderNo = officeOrderNo;
	}

	public long getProcessFileId() {
		return _processFileId;
	}

	public void setProcessFileId(long processFileId) {
		_processFileId = processFileId;
	}

	public String getProcessFileNo() {
		return _processFileNo;
	}

	public void setProcessFileNo(String processFileNo) {
		_processFileNo = processFileNo;
	}

	private String _uuid;
	private long _employeePromotionRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private Long _designationId;
	private Long _promotionModeId;
	private Date _promotionDate;
	private String _officeOrderNo;
	private long _processFileId;
	private String _processFileNo;

}