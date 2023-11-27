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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.FamilyBenefitSchemeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class FamilyBenefitSchemeSoap implements Serializable {

	public static FamilyBenefitSchemeSoap toSoapModel(
		FamilyBenefitScheme model) {

		FamilyBenefitSchemeSoap soapModel = new FamilyBenefitSchemeSoap();

		soapModel.setFamilyBenefitSchemeId(model.getFamilyBenefitSchemeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPercentage(model.getPercentage());
		soapModel.setFamilyMemberId(model.getFamilyMemberId());
		soapModel.setBenefitSchemeId(model.getBenefitSchemeId());

		return soapModel;
	}

	public static FamilyBenefitSchemeSoap[] toSoapModels(
		FamilyBenefitScheme[] models) {

		FamilyBenefitSchemeSoap[] soapModels =
			new FamilyBenefitSchemeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FamilyBenefitSchemeSoap[][] toSoapModels(
		FamilyBenefitScheme[][] models) {

		FamilyBenefitSchemeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new FamilyBenefitSchemeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FamilyBenefitSchemeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FamilyBenefitSchemeSoap[] toSoapModels(
		List<FamilyBenefitScheme> models) {

		List<FamilyBenefitSchemeSoap> soapModels =
			new ArrayList<FamilyBenefitSchemeSoap>(models.size());

		for (FamilyBenefitScheme model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new FamilyBenefitSchemeSoap[soapModels.size()]);
	}

	public FamilyBenefitSchemeSoap() {
	}

	public long getPrimaryKey() {
		return _familyBenefitSchemeId;
	}

	public void setPrimaryKey(long pk) {
		setFamilyBenefitSchemeId(pk);
	}

	public long getFamilyBenefitSchemeId() {
		return _familyBenefitSchemeId;
	}

	public void setFamilyBenefitSchemeId(long familyBenefitSchemeId) {
		_familyBenefitSchemeId = familyBenefitSchemeId;
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

	public float getPercentage() {
		return _percentage;
	}

	public void setPercentage(float percentage) {
		_percentage = percentage;
	}

	public long getFamilyMemberId() {
		return _familyMemberId;
	}

	public void setFamilyMemberId(long familyMemberId) {
		_familyMemberId = familyMemberId;
	}

	public long getBenefitSchemeId() {
		return _benefitSchemeId;
	}

	public void setBenefitSchemeId(long benefitSchemeId) {
		_benefitSchemeId = benefitSchemeId;
	}

	private long _familyBenefitSchemeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private float _percentage;
	private long _familyMemberId;
	private long _benefitSchemeId;

}