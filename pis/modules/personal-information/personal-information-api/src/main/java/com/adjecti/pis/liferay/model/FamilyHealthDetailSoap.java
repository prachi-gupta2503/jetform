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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.FamilyHealthDetailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class FamilyHealthDetailSoap implements Serializable {

	public static FamilyHealthDetailSoap toSoapModel(FamilyHealthDetail model) {
		FamilyHealthDetailSoap soapModel = new FamilyHealthDetailSoap();

		soapModel.setFamilyHealthDetailId(model.getFamilyHealthDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBoardUniversity(model.getBoardUniversity());
		soapModel.setCityOfStudy(model.getCityOfStudy());
		soapModel.setDeseaseDetails(model.getDeseaseDetails());
		soapModel.setFromYear(model.getFromYear());
		soapModel.setInstitutionName(model.getInstitutionName());
		soapModel.setToYear(model.getToYear());
		soapModel.setFamilyMemberId(model.getFamilyMemberId());
		soapModel.setStateId(model.getStateId());
		soapModel.setHospitalName(model.getHospitalName());
		soapModel.setUnderTreatment(model.isUnderTreatment());
		soapModel.setCityOfHospital(model.getCityOfHospital());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setDiseaseTypeId(model.getDiseaseTypeId());

		return soapModel;
	}

	public static FamilyHealthDetailSoap[] toSoapModels(
		FamilyHealthDetail[] models) {

		FamilyHealthDetailSoap[] soapModels =
			new FamilyHealthDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FamilyHealthDetailSoap[][] toSoapModels(
		FamilyHealthDetail[][] models) {

		FamilyHealthDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new FamilyHealthDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FamilyHealthDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FamilyHealthDetailSoap[] toSoapModels(
		List<FamilyHealthDetail> models) {

		List<FamilyHealthDetailSoap> soapModels =
			new ArrayList<FamilyHealthDetailSoap>(models.size());

		for (FamilyHealthDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new FamilyHealthDetailSoap[soapModels.size()]);
	}

	public FamilyHealthDetailSoap() {
	}

	public long getPrimaryKey() {
		return _familyHealthDetailId;
	}

	public void setPrimaryKey(long pk) {
		setFamilyHealthDetailId(pk);
	}

	public long getFamilyHealthDetailId() {
		return _familyHealthDetailId;
	}

	public void setFamilyHealthDetailId(long familyHealthDetailId) {
		_familyHealthDetailId = familyHealthDetailId;
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

	public String getDeseaseDetails() {
		return _deseaseDetails;
	}

	public void setDeseaseDetails(String deseaseDetails) {
		_deseaseDetails = deseaseDetails;
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

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	public String getHospitalName() {
		return _hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		_hospitalName = hospitalName;
	}

	public boolean getUnderTreatment() {
		return _underTreatment;
	}

	public boolean isUnderTreatment() {
		return _underTreatment;
	}

	public void setUnderTreatment(boolean underTreatment) {
		_underTreatment = underTreatment;
	}

	public String getCityOfHospital() {
		return _cityOfHospital;
	}

	public void setCityOfHospital(String cityOfHospital) {
		_cityOfHospital = cityOfHospital;
	}

	public long getLevelId() {
		return _levelId;
	}

	public void setLevelId(long levelId) {
		_levelId = levelId;
	}

	public long getDiseaseTypeId() {
		return _diseaseTypeId;
	}

	public void setDiseaseTypeId(long diseaseTypeId) {
		_diseaseTypeId = diseaseTypeId;
	}

	private long _familyHealthDetailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _boardUniversity;
	private String _cityOfStudy;
	private String _deseaseDetails;
	private int _fromYear;
	private String _institutionName;
	private int _toYear;
	private long _familyMemberId;
	private long _stateId;
	private String _hospitalName;
	private boolean _underTreatment;
	private String _cityOfHospital;
	private long _levelId;
	private long _diseaseTypeId;

}