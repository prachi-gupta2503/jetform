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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeFamilyServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeFamilySoap implements Serializable {

	public static EmployeeFamilySoap toSoapModel(EmployeeFamily model) {
		EmployeeFamilySoap soapModel = new EmployeeFamilySoap();

		soapModel.setEmployeeFamilyId(model.getEmployeeFamilyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAlive(model.isAlive());
		soapModel.setDateOfBirth(model.getDateOfBirth());
		soapModel.setDateOfDemise(model.getDateOfDemise());
		soapModel.setDependant(model.isDependant());
		soapModel.setName(model.getName());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGenderId(model.getGenderId());
		soapModel.setOccupationId(model.getOccupationId());
		soapModel.setRelationId(model.getRelationId());
		soapModel.setCgegisPercentage(model.getCgegisPercentage());
		soapModel.setDcrcPercentage(model.getDcrcPercentage());
		soapModel.setHealthProblem(model.getHealthProblem());
		soapModel.setNominee(model.isNominee());
		soapModel.setPfPercentage(model.getPfPercentage());
		soapModel.setDocumentProofId(model.getDocumentProofId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeFamilySoap[] toSoapModels(EmployeeFamily[] models) {
		EmployeeFamilySoap[] soapModels = new EmployeeFamilySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeFamilySoap[][] toSoapModels(
		EmployeeFamily[][] models) {

		EmployeeFamilySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeFamilySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeFamilySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeFamilySoap[] toSoapModels(
		List<EmployeeFamily> models) {

		List<EmployeeFamilySoap> soapModels = new ArrayList<EmployeeFamilySoap>(
			models.size());

		for (EmployeeFamily model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeFamilySoap[soapModels.size()]);
	}

	public EmployeeFamilySoap() {
	}

	public long getPrimaryKey() {
		return _employeeFamilyId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeFamilyId(pk);
	}

	public long getEmployeeFamilyId() {
		return _employeeFamilyId;
	}

	public void setEmployeeFamilyId(long employeeFamilyId) {
		_employeeFamilyId = employeeFamilyId;
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

	public boolean getAlive() {
		return _alive;
	}

	public boolean isAlive() {
		return _alive;
	}

	public void setAlive(boolean alive) {
		_alive = alive;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public Date getDateOfDemise() {
		return _dateOfDemise;
	}

	public void setDateOfDemise(Date dateOfDemise) {
		_dateOfDemise = dateOfDemise;
	}

	public boolean getDependant() {
		return _dependant;
	}

	public boolean isDependant() {
		return _dependant;
	}

	public void setDependant(boolean dependant) {
		_dependant = dependant;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getGenderId() {
		return _genderId;
	}

	public void setGenderId(long genderId) {
		_genderId = genderId;
	}

	public long getOccupationId() {
		return _occupationId;
	}

	public void setOccupationId(long occupationId) {
		_occupationId = occupationId;
	}

	public long getRelationId() {
		return _relationId;
	}

	public void setRelationId(long relationId) {
		_relationId = relationId;
	}

	public float getCgegisPercentage() {
		return _cgegisPercentage;
	}

	public void setCgegisPercentage(float cgegisPercentage) {
		_cgegisPercentage = cgegisPercentage;
	}

	public float getDcrcPercentage() {
		return _dcrcPercentage;
	}

	public void setDcrcPercentage(float dcrcPercentage) {
		_dcrcPercentage = dcrcPercentage;
	}

	public String getHealthProblem() {
		return _healthProblem;
	}

	public void setHealthProblem(String healthProblem) {
		_healthProblem = healthProblem;
	}

	public boolean getNominee() {
		return _nominee;
	}

	public boolean isNominee() {
		return _nominee;
	}

	public void setNominee(boolean nominee) {
		_nominee = nominee;
	}

	public float getPfPercentage() {
		return _pfPercentage;
	}

	public void setPfPercentage(float pfPercentage) {
		_pfPercentage = pfPercentage;
	}

	public long getDocumentProofId() {
		return _documentProofId;
	}

	public void setDocumentProofId(long documentProofId) {
		_documentProofId = documentProofId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeeFamilyId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _alive;
	private Date _dateOfBirth;
	private Date _dateOfDemise;
	private boolean _dependant;
	private String _name;
	private long _employeeId;
	private long _genderId;
	private long _occupationId;
	private long _relationId;
	private float _cgegisPercentage;
	private float _dcrcPercentage;
	private String _healthProblem;
	private boolean _nominee;
	private float _pfPercentage;
	private long _documentProofId;
	private int _status;

}