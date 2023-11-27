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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.PeopleServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PeopleSoap implements Serializable {

	public static PeopleSoap toSoapModel(People model) {
		PeopleSoap soapModel = new PeopleSoap();

		soapModel.setPeopleId(model.getPeopleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAppellationId(model.getAppellationId());
		soapModel.setFirstName_Hi(model.getFirstName_Hi());
		soapModel.setFirstName_En(model.getFirstName_En());
		soapModel.setLastName_Hi(model.getLastName_Hi());
		soapModel.setLastName_En(model.getLastName_En());
		soapModel.setMiddleName_Hi(model.getMiddleName_Hi());
		soapModel.setMiddleName_En(model.getMiddleName_En());
		soapModel.setFatherName_Hi(model.getFatherName_Hi());
		soapModel.setFatherName_En(model.getFatherName_En());
		soapModel.setDateOfBirth(model.getDateOfBirth());
		soapModel.setGenderId(model.getGenderId());
		soapModel.setMaritalStatusId(model.getMaritalStatusId());
		soapModel.setCasteCategoryId(model.getCasteCategoryId());
		soapModel.setIdentityProofId(model.getIdentityProofId());
		soapModel.setBloodGroupId(model.getBloodGroupId());
		soapModel.setCitizenshipId(model.getCitizenshipId());
		soapModel.setPhTypeId(model.getPhTypeId());
		soapModel.setReligionId(model.getReligionId());
		soapModel.setAadhaarNo(model.getAadhaarNo());
		soapModel.setPanNo(model.getPanNo());
		soapModel.setColor(model.getColor());
		soapModel.setHeight(model.getHeight());
		soapModel.setIdentificationMark(model.getIdentificationMark());
		soapModel.setExServiceMan(model.isExServiceMan());
		soapModel.setProfileImageId(model.getProfileImageId());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());

		return soapModel;
	}

	public static PeopleSoap[] toSoapModels(People[] models) {
		PeopleSoap[] soapModels = new PeopleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PeopleSoap[][] toSoapModels(People[][] models) {
		PeopleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PeopleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PeopleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PeopleSoap[] toSoapModels(List<People> models) {
		List<PeopleSoap> soapModels = new ArrayList<PeopleSoap>(models.size());

		for (People model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PeopleSoap[soapModels.size()]);
	}

	public PeopleSoap() {
	}

	public long getPrimaryKey() {
		return _peopleId;
	}

	public void setPrimaryKey(long pk) {
		setPeopleId(pk);
	}

	public long getPeopleId() {
		return _peopleId;
	}

	public void setPeopleId(long peopleId) {
		_peopleId = peopleId;
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

	public long getAppellationId() {
		return _appellationId;
	}

	public void setAppellationId(long appellationId) {
		_appellationId = appellationId;
	}

	public String getFirstName_Hi() {
		return _firstName_Hi;
	}

	public void setFirstName_Hi(String firstName_Hi) {
		_firstName_Hi = firstName_Hi;
	}

	public String getFirstName_En() {
		return _firstName_En;
	}

	public void setFirstName_En(String firstName_En) {
		_firstName_En = firstName_En;
	}

	public String getLastName_Hi() {
		return _lastName_Hi;
	}

	public void setLastName_Hi(String lastName_Hi) {
		_lastName_Hi = lastName_Hi;
	}

	public String getLastName_En() {
		return _lastName_En;
	}

	public void setLastName_En(String lastName_En) {
		_lastName_En = lastName_En;
	}

	public String getMiddleName_Hi() {
		return _middleName_Hi;
	}

	public void setMiddleName_Hi(String middleName_Hi) {
		_middleName_Hi = middleName_Hi;
	}

	public String getMiddleName_En() {
		return _middleName_En;
	}

	public void setMiddleName_En(String middleName_En) {
		_middleName_En = middleName_En;
	}

	public String getFatherName_Hi() {
		return _fatherName_Hi;
	}

	public void setFatherName_Hi(String fatherName_Hi) {
		_fatherName_Hi = fatherName_Hi;
	}

	public String getFatherName_En() {
		return _fatherName_En;
	}

	public void setFatherName_En(String fatherName_En) {
		_fatherName_En = fatherName_En;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public long getGenderId() {
		return _genderId;
	}

	public void setGenderId(long genderId) {
		_genderId = genderId;
	}

	public long getMaritalStatusId() {
		return _maritalStatusId;
	}

	public void setMaritalStatusId(long maritalStatusId) {
		_maritalStatusId = maritalStatusId;
	}

	public long getCasteCategoryId() {
		return _casteCategoryId;
	}

	public void setCasteCategoryId(long casteCategoryId) {
		_casteCategoryId = casteCategoryId;
	}

	public long getIdentityProofId() {
		return _identityProofId;
	}

	public void setIdentityProofId(long identityProofId) {
		_identityProofId = identityProofId;
	}

	public long getBloodGroupId() {
		return _bloodGroupId;
	}

	public void setBloodGroupId(long bloodGroupId) {
		_bloodGroupId = bloodGroupId;
	}

	public long getCitizenshipId() {
		return _citizenshipId;
	}

	public void setCitizenshipId(long citizenshipId) {
		_citizenshipId = citizenshipId;
	}

	public long getPhTypeId() {
		return _phTypeId;
	}

	public void setPhTypeId(long phTypeId) {
		_phTypeId = phTypeId;
	}

	public long getReligionId() {
		return _religionId;
	}

	public void setReligionId(long religionId) {
		_religionId = religionId;
	}

	public String getAadhaarNo() {
		return _aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		_aadhaarNo = aadhaarNo;
	}

	public String getPanNo() {
		return _panNo;
	}

	public void setPanNo(String panNo) {
		_panNo = panNo;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	public float getHeight() {
		return _height;
	}

	public void setHeight(float height) {
		_height = height;
	}

	public String getIdentificationMark() {
		return _identificationMark;
	}

	public void setIdentificationMark(String identificationMark) {
		_identificationMark = identificationMark;
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

	public long getProfileImageId() {
		return _profileImageId;
	}

	public void setProfileImageId(long profileImageId) {
		_profileImageId = profileImageId;
	}

	public long getJoiningProcessId() {
		return _joiningProcessId;
	}

	public void setJoiningProcessId(long joiningProcessId) {
		_joiningProcessId = joiningProcessId;
	}

	private long _peopleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _appellationId;
	private String _firstName_Hi;
	private String _firstName_En;
	private String _lastName_Hi;
	private String _lastName_En;
	private String _middleName_Hi;
	private String _middleName_En;
	private String _fatherName_Hi;
	private String _fatherName_En;
	private Date _dateOfBirth;
	private long _genderId;
	private long _maritalStatusId;
	private long _casteCategoryId;
	private long _identityProofId;
	private long _bloodGroupId;
	private long _citizenshipId;
	private long _phTypeId;
	private long _religionId;
	private String _aadhaarNo;
	private String _panNo;
	private String _color;
	private float _height;
	private String _identificationMark;
	private boolean _exServiceMan;
	private long _profileImageId;
	private long _joiningProcessId;

}