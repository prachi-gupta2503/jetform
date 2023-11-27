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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.DesignationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DesignationSoap implements Serializable {

	public static DesignationSoap toSoapModel(Designation model) {
		DesignationSoap soapModel = new DesignationSoap();

		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setName_En(model.getName_En());
		soapModel.setName_Hi(model.getName_Hi());
		soapModel.setShortName(model.getShortName());
		soapModel.setLongName(model.getLongName());
		soapModel.setDescription(model.getDescription());
		soapModel.setDesignationClassId(model.getDesignationClassId());
		soapModel.setDesignationGroupId(model.getDesignationGroupId());
		soapModel.setDesignationGroup(model.getDesignationGroup());
		soapModel.setGradeId(model.getGradeId());
		soapModel.setOrganizationType(model.getOrganizationType());
		soapModel.setSequenceNo(model.getSequenceNo());
		soapModel.setRank(model.getRank());
		soapModel.setScopeType(model.getScopeType());
		soapModel.setScopeOrganizationId(model.getScopeOrganizationId());
		soapModel.setScopeOrganizationTypeId(
			model.getScopeOrganizationTypeId());
		soapModel.setScopePostId(model.getScopePostId());
		soapModel.setDesignationModeId(model.getDesignationModeId());
		soapModel.setSuccessorGradeId(model.getSuccessorGradeId());
		soapModel.setScopeOrganizationName(model.getScopeOrganizationName());
		soapModel.setScopePostName(model.getScopePostName());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static DesignationSoap[] toSoapModels(Designation[] models) {
		DesignationSoap[] soapModels = new DesignationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DesignationSoap[][] toSoapModels(Designation[][] models) {
		DesignationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DesignationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DesignationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DesignationSoap[] toSoapModels(List<Designation> models) {
		List<DesignationSoap> soapModels = new ArrayList<DesignationSoap>(
			models.size());

		for (Designation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DesignationSoap[soapModels.size()]);
	}

	public DesignationSoap() {
	}

	public long getPrimaryKey() {
		return _designationId;
	}

	public void setPrimaryKey(long pk) {
		setDesignationId(pk);
	}

	public long getDesignationId() {
		return _designationId;
	}

	public void setDesignationId(long designationId) {
		_designationId = designationId;
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

	public String getName_En() {
		return _name_En;
	}

	public void setName_En(String name_En) {
		_name_En = name_En;
	}

	public String getName_Hi() {
		return _name_Hi;
	}

	public void setName_Hi(String name_Hi) {
		_name_Hi = name_Hi;
	}

	public String getShortName() {
		return _shortName;
	}

	public void setShortName(String shortName) {
		_shortName = shortName;
	}

	public String getLongName() {
		return _longName;
	}

	public void setLongName(String longName) {
		_longName = longName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public String getDesignationGroup() {
		return _designationGroup;
	}

	public void setDesignationGroup(String designationGroup) {
		_designationGroup = designationGroup;
	}

	public long getGradeId() {
		return _gradeId;
	}

	public void setGradeId(long gradeId) {
		_gradeId = gradeId;
	}

	public String getOrganizationType() {
		return _organizationType;
	}

	public void setOrganizationType(String organizationType) {
		_organizationType = organizationType;
	}

	public String getSequenceNo() {
		return _sequenceNo;
	}

	public void setSequenceNo(String sequenceNo) {
		_sequenceNo = sequenceNo;
	}

	public int getRank() {
		return _rank;
	}

	public void setRank(int rank) {
		_rank = rank;
	}

	public int getScopeType() {
		return _scopeType;
	}

	public void setScopeType(int scopeType) {
		_scopeType = scopeType;
	}

	public long getScopeOrganizationId() {
		return _scopeOrganizationId;
	}

	public void setScopeOrganizationId(long scopeOrganizationId) {
		_scopeOrganizationId = scopeOrganizationId;
	}

	public long getScopeOrganizationTypeId() {
		return _scopeOrganizationTypeId;
	}

	public void setScopeOrganizationTypeId(long scopeOrganizationTypeId) {
		_scopeOrganizationTypeId = scopeOrganizationTypeId;
	}

	public long getScopePostId() {
		return _scopePostId;
	}

	public void setScopePostId(long scopePostId) {
		_scopePostId = scopePostId;
	}

	public long getDesignationModeId() {
		return _designationModeId;
	}

	public void setDesignationModeId(long designationModeId) {
		_designationModeId = designationModeId;
	}

	public long getSuccessorGradeId() {
		return _successorGradeId;
	}

	public void setSuccessorGradeId(long successorGradeId) {
		_successorGradeId = successorGradeId;
	}

	public String getScopeOrganizationName() {
		return _scopeOrganizationName;
	}

	public void setScopeOrganizationName(String scopeOrganizationName) {
		_scopeOrganizationName = scopeOrganizationName;
	}

	public String getScopePostName() {
		return _scopePostName;
	}

	public void setScopePostName(String scopePostName) {
		_scopePostName = scopePostName;
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

	private long _designationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _name_En;
	private String _name_Hi;
	private String _shortName;
	private String _longName;
	private String _description;
	private long _designationClassId;
	private long _designationGroupId;
	private String _designationGroup;
	private long _gradeId;
	private String _organizationType;
	private String _sequenceNo;
	private int _rank;
	private int _scopeType;
	private long _scopeOrganizationId;
	private long _scopeOrganizationTypeId;
	private long _scopePostId;
	private long _designationModeId;
	private long _successorGradeId;
	private String _scopeOrganizationName;
	private String _scopePostName;
	private boolean _deleted;
	private int _status;

}