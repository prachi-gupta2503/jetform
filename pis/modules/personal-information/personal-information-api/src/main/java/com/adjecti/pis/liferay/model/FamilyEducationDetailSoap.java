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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.FamilyEducationDetailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class FamilyEducationDetailSoap implements Serializable {

	public static FamilyEducationDetailSoap toSoapModel(
		FamilyEducationDetail model) {

		FamilyEducationDetailSoap soapModel = new FamilyEducationDetailSoap();

		soapModel.setFamilyEducationDetailId(
			model.getFamilyEducationDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBoardUniversity(model.getBoardUniversity());
		soapModel.setCityOfStudy(model.getCityOfStudy());
		soapModel.setFromYear(model.getFromYear());
		soapModel.setInstitutionName(model.getInstitutionName());
		soapModel.setToYear(model.getToYear());
		soapModel.setFamilyMemberId(model.getFamilyMemberId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setStateId(model.getStateId());

		return soapModel;
	}

	public static FamilyEducationDetailSoap[] toSoapModels(
		FamilyEducationDetail[] models) {

		FamilyEducationDetailSoap[] soapModels =
			new FamilyEducationDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FamilyEducationDetailSoap[][] toSoapModels(
		FamilyEducationDetail[][] models) {

		FamilyEducationDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new FamilyEducationDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FamilyEducationDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FamilyEducationDetailSoap[] toSoapModels(
		List<FamilyEducationDetail> models) {

		List<FamilyEducationDetailSoap> soapModels =
			new ArrayList<FamilyEducationDetailSoap>(models.size());

		for (FamilyEducationDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new FamilyEducationDetailSoap[soapModels.size()]);
	}

	public FamilyEducationDetailSoap() {
	}

	public long getPrimaryKey() {
		return _familyEducationDetailId;
	}

	public void setPrimaryKey(long pk) {
		setFamilyEducationDetailId(pk);
	}

	public long getFamilyEducationDetailId() {
		return _familyEducationDetailId;
	}

	public void setFamilyEducationDetailId(long familyEducationDetailId) {
		_familyEducationDetailId = familyEducationDetailId;
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

	public String getCityOfStudy() {
		return _cityOfStudy;
	}

	public void setCityOfStudy(String cityOfStudy) {
		_cityOfStudy = cityOfStudy;
	}

	public int getFromYear() {
		return _fromYear;
	}

	public void setFromYear(int fromYear) {
		_fromYear = fromYear;
	}

	public String getInstitutionName() {
		return _institutionName;
	}

	public void setInstitutionName(String institutionName) {
		_institutionName = institutionName;
	}

	public int getToYear() {
		return _toYear;
	}

	public void setToYear(int toYear) {
		_toYear = toYear;
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

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	private long _familyEducationDetailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _boardUniversity;
	private String _cityOfStudy;
	private int _fromYear;
	private String _institutionName;
	private int _toYear;
	private long _familyMemberId;
	private long _levelId;
	private long _stateId;

}