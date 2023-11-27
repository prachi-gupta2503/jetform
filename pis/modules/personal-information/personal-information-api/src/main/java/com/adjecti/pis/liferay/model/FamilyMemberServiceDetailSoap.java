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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.FamilyMemberServiceDetailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class FamilyMemberServiceDetailSoap implements Serializable {

	public static FamilyMemberServiceDetailSoap toSoapModel(
		FamilyMemberServiceDetail model) {

		FamilyMemberServiceDetailSoap soapModel =
			new FamilyMemberServiceDetailSoap();

		soapModel.setFamilyMemberServiceDetailId(
			model.getFamilyMemberServiceDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBoardUniversity(model.getBoardUniversity());
		soapModel.setFromYear(model.getFromYear());
		soapModel.setToYear(model.getToYear());
		soapModel.setDescription(model.getDescription());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setOrganization(model.getOrganization());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setFamilyMemberId(model.getFamilyMemberId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setServiceTypeId(model.getServiceTypeId());

		return soapModel;
	}

	public static FamilyMemberServiceDetailSoap[] toSoapModels(
		FamilyMemberServiceDetail[] models) {

		FamilyMemberServiceDetailSoap[] soapModels =
			new FamilyMemberServiceDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FamilyMemberServiceDetailSoap[][] toSoapModels(
		FamilyMemberServiceDetail[][] models) {

		FamilyMemberServiceDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new FamilyMemberServiceDetailSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new FamilyMemberServiceDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FamilyMemberServiceDetailSoap[] toSoapModels(
		List<FamilyMemberServiceDetail> models) {

		List<FamilyMemberServiceDetailSoap> soapModels =
			new ArrayList<FamilyMemberServiceDetailSoap>(models.size());

		for (FamilyMemberServiceDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new FamilyMemberServiceDetailSoap[soapModels.size()]);
	}

	public FamilyMemberServiceDetailSoap() {
	}

	public long getPrimaryKey() {
		return _familyMemberServiceDetailId;
	}

	public void setPrimaryKey(long pk) {
		setFamilyMemberServiceDetailId(pk);
	}

	public long getFamilyMemberServiceDetailId() {
		return _familyMemberServiceDetailId;
	}

	public void setFamilyMemberServiceDetailId(
		long familyMemberServiceDetailId) {

		_familyMemberServiceDetailId = familyMemberServiceDetailId;
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

	public String getBoardUniversity() {
		return _boardUniversity;
	}

	public void setBoardUniversity(String boardUniversity) {
		_boardUniversity = boardUniversity;
	}

	public int getFromYear() {
		return _fromYear;
	}

	public void setFromYear(int fromYear) {
		_fromYear = fromYear;
	}

	public int getToYear() {
		return _toYear;
	}

	public void setToYear(int toYear) {
		_toYear = toYear;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getOrganization() {
		return _organization;
	}

	public void setOrganization(String organization) {
		_organization = organization;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public long getFamilyMemberId() {
		return _familyMemberId;
	}

	public void setFamilyMemberId(long familyMemberId) {
		_familyMemberId = familyMemberId;
	}

	public long getLevelId() {
		return _levelId;
	}

	public void setLevelId(long levelId) {
		_levelId = levelId;
	}

	public long getServiceTypeId() {
		return _serviceTypeId;
	}

	public void setServiceTypeId(long serviceTypeId) {
		_serviceTypeId = serviceTypeId;
	}

	private long _familyMemberServiceDetailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _boardUniversity;
	private int _fromYear;
	private int _toYear;
	private String _description;
	private Date _endDate;
	private String _organization;
	private Date _startDate;
	private long _familyMemberId;
	private long _levelId;
	private long _serviceTypeId;

}