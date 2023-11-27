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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.BenefitSchemeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class BenefitSchemeSoap implements Serializable {

	public static BenefitSchemeSoap toSoapModel(BenefitScheme model) {
		BenefitSchemeSoap soapModel = new BenefitSchemeSoap();

		soapModel.setBenefitSchemeId(model.getBenefitSchemeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setCode(model.getCode());
		soapModel.setDescription(model.getDescription());
		soapModel.setEffectiveFrom(model.getEffectiveFrom());
		soapModel.setEffectiveRate(model.getEffectiveRate());
		soapModel.setEffectiveUpto(model.getEffectiveUpto());
		soapModel.setName(model.getName());
		soapModel.setFrequencyId(model.getFrequencyId());
		soapModel.setRateTypeId(model.getRateTypeId());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static BenefitSchemeSoap[] toSoapModels(BenefitScheme[] models) {
		BenefitSchemeSoap[] soapModels = new BenefitSchemeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BenefitSchemeSoap[][] toSoapModels(BenefitScheme[][] models) {
		BenefitSchemeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BenefitSchemeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BenefitSchemeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BenefitSchemeSoap[] toSoapModels(List<BenefitScheme> models) {
		List<BenefitSchemeSoap> soapModels = new ArrayList<BenefitSchemeSoap>(
			models.size());

		for (BenefitScheme model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BenefitSchemeSoap[soapModels.size()]);
	}

	public BenefitSchemeSoap() {
	}

	public long getPrimaryKey() {
		return _benefitSchemeId;
	}

	public void setPrimaryKey(long pk) {
		setBenefitSchemeId(pk);
	}

	public long getBenefitSchemeId() {
		return _benefitSchemeId;
	}

	public void setBenefitSchemeId(long benefitSchemeId) {
		_benefitSchemeId = benefitSchemeId;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getEffectiveFrom() {
		return _effectiveFrom;
	}

	public void setEffectiveFrom(Date effectiveFrom) {
		_effectiveFrom = effectiveFrom;
	}

	public float getEffectiveRate() {
		return _effectiveRate;
	}

	public void setEffectiveRate(float effectiveRate) {
		_effectiveRate = effectiveRate;
	}

	public Date getEffectiveUpto() {
		return _effectiveUpto;
	}

	public void setEffectiveUpto(Date effectiveUpto) {
		_effectiveUpto = effectiveUpto;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getFrequencyId() {
		return _frequencyId;
	}

	public void setFrequencyId(int frequencyId) {
		_frequencyId = frequencyId;
	}

	public int getRateTypeId() {
		return _rateTypeId;
	}

	public void setRateTypeId(int rateTypeId) {
		_rateTypeId = rateTypeId;
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

	private long _benefitSchemeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private String _code;
	private String _description;
	private Date _effectiveFrom;
	private float _effectiveRate;
	private Date _effectiveUpto;
	private String _name;
	private int _frequencyId;
	private int _rateTypeId;
	private boolean _deleted;
	private int _status;

}