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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.JoiningProcessRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class JoiningProcessRequestSoap implements Serializable {

	public static JoiningProcessRequestSoap toSoapModel(
		JoiningProcessRequest model) {

		JoiningProcessRequestSoap soapModel = new JoiningProcessRequestSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setJoiningProcessRequestId(
			model.getJoiningProcessRequestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProcessFileId(model.getProcessFileId());
		soapModel.setProcessFileNo(model.getProcessFileNo());
		soapModel.setOfficeOrderNo(model.getOfficeOrderNo());
		soapModel.setDoPart1Content(model.getDoPart1Content());
		soapModel.setDoPart1FileId(model.getDoPart1FileId());
		soapModel.setDoPart2Content(model.getDoPart2Content());
		soapModel.setDoPart2FileId(model.getDoPart2FileId());

		return soapModel;
	}

	public static JoiningProcessRequestSoap[] toSoapModels(
		JoiningProcessRequest[] models) {

		JoiningProcessRequestSoap[] soapModels =
			new JoiningProcessRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JoiningProcessRequestSoap[][] toSoapModels(
		JoiningProcessRequest[][] models) {

		JoiningProcessRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new JoiningProcessRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JoiningProcessRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JoiningProcessRequestSoap[] toSoapModels(
		List<JoiningProcessRequest> models) {

		List<JoiningProcessRequestSoap> soapModels =
			new ArrayList<JoiningProcessRequestSoap>(models.size());

		for (JoiningProcessRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new JoiningProcessRequestSoap[soapModels.size()]);
	}

	public JoiningProcessRequestSoap() {
	}

	public long getPrimaryKey() {
		return _joiningProcessRequestId;
	}

	public void setPrimaryKey(long pk) {
		setJoiningProcessRequestId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getJoiningProcessRequestId() {
		return _joiningProcessRequestId;
	}

	public void setJoiningProcessRequestId(long joiningProcessRequestId) {
		_joiningProcessRequestId = joiningProcessRequestId;
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

	public long getJoiningProcessId() {
		return _joiningProcessId;
	}

	public void setJoiningProcessId(long joiningProcessId) {
		_joiningProcessId = joiningProcessId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
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

	public String getOfficeOrderNo() {
		return _officeOrderNo;
	}

	public void setOfficeOrderNo(String officeOrderNo) {
		_officeOrderNo = officeOrderNo;
	}

	public String getDoPart1Content() {
		return _doPart1Content;
	}

	public void setDoPart1Content(String doPart1Content) {
		_doPart1Content = doPart1Content;
	}

	public long getDoPart1FileId() {
		return _doPart1FileId;
	}

	public void setDoPart1FileId(long doPart1FileId) {
		_doPart1FileId = doPart1FileId;
	}

	public String getDoPart2Content() {
		return _doPart2Content;
	}

	public void setDoPart2Content(String doPart2Content) {
		_doPart2Content = doPart2Content;
	}

	public long getDoPart2FileId() {
		return _doPart2FileId;
	}

	public void setDoPart2FileId(long doPart2FileId) {
		_doPart2FileId = doPart2FileId;
	}

	private String _uuid;
	private long _joiningProcessRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _joiningProcessId;
	private long _employeeId;
	private long _processFileId;
	private String _processFileNo;
	private String _officeOrderNo;
	private String _doPart1Content;
	private long _doPart1FileId;
	private String _doPart2Content;
	private long _doPart2FileId;

}