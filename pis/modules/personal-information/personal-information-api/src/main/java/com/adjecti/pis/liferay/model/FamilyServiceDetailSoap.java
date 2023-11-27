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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.FamilyServiceDetailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class FamilyServiceDetailSoap implements Serializable {

	public static FamilyServiceDetailSoap toSoapModel(
		FamilyServiceDetail model) {

		FamilyServiceDetailSoap soapModel = new FamilyServiceDetailSoap();

		soapModel.setFamilyServiceDetailId(model.getFamilyServiceDetailId());
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
		soapModel.setCityOfStudy(model.getCityOfStudy());
		soapModel.setInstitutionName(model.getInstitutionName());
		soapModel.setStateId(model.getStateId());
		soapModel.setCityOfWork(model.getCityOfWork());
		soapModel.setDesignation(model.getDesignation());
		soapModel.setGovtServant(model.isGovtServant());
		soapModel.setCityOfHospital(model.getCityOfHospital());
		soapModel.setDeseaseDetails(model.getDeseaseDetails());
		soapModel.setHospitalName(model.getHospitalName());
		soapModel.setUnderTreatment(model.isUnderTreatment());
		soapModel.setDiseaseTypeId(model.getDiseaseTypeId());

		return soapModel;
	}

	public static FamilyServiceDetailSoap[] toSoapModels(
		FamilyServiceDetail[] models) {

		FamilyServiceDetailSoap[] soapModels =
			new FamilyServiceDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FamilyServiceDetailSoap[][] toSoapModels(
		FamilyServiceDetail[][] models) {

		FamilyServiceDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new FamilyServiceDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FamilyServiceDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FamilyServiceDetailSoap[] toSoapModels(
		List<FamilyServiceDetail> models) {

		List<FamilyServiceDetailSoap> soapModels =
			new ArrayList<FamilyServiceDetailSoap>(models.size());

		for (FamilyServiceDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new FamilyServiceDetailSoap[soapModels.size()]);
	}

	public FamilyServiceDetailSoap() {
	}

	public long getPrimaryKey() {
		return _familyServiceDetailId;
	}

	public void setPrimaryKey(long pk) {
		setFamilyServiceDetailId(pk);
	}

	public long getFamilyServiceDetailId() {
		return _familyServiceDetailId;
	}

	public void setFamilyServiceDetailId(long familyServiceDetailId) {
		_familyServiceDetailId = familyServiceDetailId;
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

	public String getCityOfStudy() {
		return _cityOfStudy;
	}

	public void setCityOfStudy(String cityOfStudy) {
		_cityOfStudy = cityOfStudy;
	}

	public String getInstitutionName() {
		return _institutionName;
	}

	public void setInstitutionName(String institutionName) {
		_institutionName = institutionName;
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	public String getCityOfWork() {
		return _cityOfWork;
	}

	public void setCityOfWork(String cityOfWork) {
		_cityOfWork = cityOfWork;
	}

	public String getDesignation() {
		return _designation;
	}

	public void setDesignation(String designation) {
		_designation = designation;
	}

	public boolean getGovtServant() {
		return _govtServant;
	}

	public boolean isGovtServant() {
		return _govtServant;
	}

	public void setGovtServant(boolean govtServant) {
		_govtServant = govtServant;
	}

	public String getCityOfHospital() {
		return _cityOfHospital;
	}

	public void setCityOfHospital(String cityOfHospital) {
		_cityOfHospital = cityOfHospital;
	}

	public String getDeseaseDetails() {
		return _deseaseDetails;
	}

	public void setDeseaseDetails(String deseaseDetails) {
		_deseaseDetails = deseaseDetails;
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

	public long getDiseaseTypeId() {
		return _diseaseTypeId;
	}

	public void setDiseaseTypeId(long diseaseTypeId) {
		_diseaseTypeId = diseaseTypeId;
	}

	private long _familyServiceDetailId;
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
	private String _cityOfStudy;
	private String _institutionName;
	private long _stateId;
	private String _cityOfWork;
	private String _designation;
	private boolean _govtServant;
	private String _cityOfHospital;
	private String _deseaseDetails;
	private String _hospitalName;
	private boolean _underTreatment;
	private long _diseaseTypeId;

}