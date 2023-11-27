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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.MonthlySalaryComponentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MonthlySalaryComponentSoap implements Serializable {

	public static MonthlySalaryComponentSoap toSoapModel(
		MonthlySalaryComponent model) {

		MonthlySalaryComponentSoap soapModel = new MonthlySalaryComponentSoap();

		soapModel.setMonthlySalaryComponentId(
			model.getMonthlySalaryComponentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAmount(model.getAmount());
		soapModel.setComponentId(model.getComponentId());
		soapModel.setSalaryId(model.getSalaryId());

		return soapModel;
	}

	public static MonthlySalaryComponentSoap[] toSoapModels(
		MonthlySalaryComponent[] models) {

		MonthlySalaryComponentSoap[] soapModels =
			new MonthlySalaryComponentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MonthlySalaryComponentSoap[][] toSoapModels(
		MonthlySalaryComponent[][] models) {

		MonthlySalaryComponentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MonthlySalaryComponentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MonthlySalaryComponentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MonthlySalaryComponentSoap[] toSoapModels(
		List<MonthlySalaryComponent> models) {

		List<MonthlySalaryComponentSoap> soapModels =
			new ArrayList<MonthlySalaryComponentSoap>(models.size());

		for (MonthlySalaryComponent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new MonthlySalaryComponentSoap[soapModels.size()]);
	}

	public MonthlySalaryComponentSoap() {
	}

	public long getPrimaryKey() {
		return _monthlySalaryComponentId;
	}

	public void setPrimaryKey(long pk) {
		setMonthlySalaryComponentId(pk);
	}

	public long getMonthlySalaryComponentId() {
		return _monthlySalaryComponentId;
	}

	public void setMonthlySalaryComponentId(long monthlySalaryComponentId) {
		_monthlySalaryComponentId = monthlySalaryComponentId;
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

	public float getAmount() {
		return _amount;
	}

	public void setAmount(float amount) {
		_amount = amount;
	}

	public long getComponentId() {
		return _componentId;
	}

	public void setComponentId(long componentId) {
		_componentId = componentId;
	}

	public long getSalaryId() {
		return _salaryId;
	}

	public void setSalaryId(long salaryId) {
		_salaryId = salaryId;
	}

	private long _monthlySalaryComponentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private float _amount;
	private long _componentId;
	private long _salaryId;

}