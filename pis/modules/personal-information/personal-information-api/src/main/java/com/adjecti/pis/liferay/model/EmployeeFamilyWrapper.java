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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeFamily}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeFamily
 * @generated
 */
public class EmployeeFamilyWrapper
	extends BaseModelWrapper<EmployeeFamily>
	implements EmployeeFamily, ModelWrapper<EmployeeFamily> {

	public EmployeeFamilyWrapper(EmployeeFamily employeeFamily) {
		super(employeeFamily);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeFamilyId", getEmployeeFamilyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("alive", isAlive());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("dateOfDemise", getDateOfDemise());
		attributes.put("dependant", isDependant());
		attributes.put("name", getName());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("genderId", getGenderId());
		attributes.put("occupationId", getOccupationId());
		attributes.put("relationId", getRelationId());
		attributes.put("cgegisPercentage", getCgegisPercentage());
		attributes.put("dcrcPercentage", getDcrcPercentage());
		attributes.put("healthProblem", getHealthProblem());
		attributes.put("nominee", isNominee());
		attributes.put("pfPercentage", getPfPercentage());
		attributes.put("documentProofId", getDocumentProofId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeFamilyId = (Long)attributes.get("employeeFamilyId");

		if (employeeFamilyId != null) {
			setEmployeeFamilyId(employeeFamilyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean alive = (Boolean)attributes.get("alive");

		if (alive != null) {
			setAlive(alive);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		Date dateOfDemise = (Date)attributes.get("dateOfDemise");

		if (dateOfDemise != null) {
			setDateOfDemise(dateOfDemise);
		}

		Boolean dependant = (Boolean)attributes.get("dependant");

		if (dependant != null) {
			setDependant(dependant);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long genderId = (Long)attributes.get("genderId");

		if (genderId != null) {
			setGenderId(genderId);
		}

		Long occupationId = (Long)attributes.get("occupationId");

		if (occupationId != null) {
			setOccupationId(occupationId);
		}

		Long relationId = (Long)attributes.get("relationId");

		if (relationId != null) {
			setRelationId(relationId);
		}

		Float cgegisPercentage = (Float)attributes.get("cgegisPercentage");

		if (cgegisPercentage != null) {
			setCgegisPercentage(cgegisPercentage);
		}

		Float dcrcPercentage = (Float)attributes.get("dcrcPercentage");

		if (dcrcPercentage != null) {
			setDcrcPercentage(dcrcPercentage);
		}

		String healthProblem = (String)attributes.get("healthProblem");

		if (healthProblem != null) {
			setHealthProblem(healthProblem);
		}

		Boolean nominee = (Boolean)attributes.get("nominee");

		if (nominee != null) {
			setNominee(nominee);
		}

		Float pfPercentage = (Float)attributes.get("pfPercentage");

		if (pfPercentage != null) {
			setPfPercentage(pfPercentage);
		}

		Long documentProofId = (Long)attributes.get("documentProofId");

		if (documentProofId != null) {
			setDocumentProofId(documentProofId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the alive of this employee family.
	 *
	 * @return the alive of this employee family
	 */
	@Override
	public boolean getAlive() {
		return model.getAlive();
	}

	/**
	 * Returns the cgegis percentage of this employee family.
	 *
	 * @return the cgegis percentage of this employee family
	 */
	@Override
	public float getCgegisPercentage() {
		return model.getCgegisPercentage();
	}

	/**
	 * Returns the company ID of this employee family.
	 *
	 * @return the company ID of this employee family
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee family.
	 *
	 * @return the create date of this employee family
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date of birth of this employee family.
	 *
	 * @return the date of birth of this employee family
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the date of demise of this employee family.
	 *
	 * @return the date of demise of this employee family
	 */
	@Override
	public Date getDateOfDemise() {
		return model.getDateOfDemise();
	}

	/**
	 * Returns the dcrc percentage of this employee family.
	 *
	 * @return the dcrc percentage of this employee family
	 */
	@Override
	public float getDcrcPercentage() {
		return model.getDcrcPercentage();
	}

	/**
	 * Returns the dependant of this employee family.
	 *
	 * @return the dependant of this employee family
	 */
	@Override
	public boolean getDependant() {
		return model.getDependant();
	}

	/**
	 * Returns the document proof ID of this employee family.
	 *
	 * @return the document proof ID of this employee family
	 */
	@Override
	public long getDocumentProofId() {
		return model.getDocumentProofId();
	}

	/**
	 * Returns the employee family ID of this employee family.
	 *
	 * @return the employee family ID of this employee family
	 */
	@Override
	public long getEmployeeFamilyId() {
		return model.getEmployeeFamilyId();
	}

	/**
	 * Returns the employee ID of this employee family.
	 *
	 * @return the employee ID of this employee family
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the gender ID of this employee family.
	 *
	 * @return the gender ID of this employee family
	 */
	@Override
	public long getGenderId() {
		return model.getGenderId();
	}

	/**
	 * Returns the group ID of this employee family.
	 *
	 * @return the group ID of this employee family
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the health problem of this employee family.
	 *
	 * @return the health problem of this employee family
	 */
	@Override
	public String getHealthProblem() {
		return model.getHealthProblem();
	}

	/**
	 * Returns the modified date of this employee family.
	 *
	 * @return the modified date of this employee family
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this employee family.
	 *
	 * @return the name of this employee family
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the nominee of this employee family.
	 *
	 * @return the nominee of this employee family
	 */
	@Override
	public boolean getNominee() {
		return model.getNominee();
	}

	/**
	 * Returns the occupation ID of this employee family.
	 *
	 * @return the occupation ID of this employee family
	 */
	@Override
	public long getOccupationId() {
		return model.getOccupationId();
	}

	/**
	 * Returns the pf percentage of this employee family.
	 *
	 * @return the pf percentage of this employee family
	 */
	@Override
	public float getPfPercentage() {
		return model.getPfPercentage();
	}

	/**
	 * Returns the primary key of this employee family.
	 *
	 * @return the primary key of this employee family
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the relation ID of this employee family.
	 *
	 * @return the relation ID of this employee family
	 */
	@Override
	public long getRelationId() {
		return model.getRelationId();
	}

	/**
	 * Returns the status of this employee family.
	 *
	 * @return the status of this employee family
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this employee family.
	 *
	 * @return the user ID of this employee family
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee family.
	 *
	 * @return the user name of this employee family
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee family.
	 *
	 * @return the user uuid of this employee family
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee family is alive.
	 *
	 * @return <code>true</code> if this employee family is alive; <code>false</code> otherwise
	 */
	@Override
	public boolean isAlive() {
		return model.isAlive();
	}

	/**
	 * Returns <code>true</code> if this employee family is dependant.
	 *
	 * @return <code>true</code> if this employee family is dependant; <code>false</code> otherwise
	 */
	@Override
	public boolean isDependant() {
		return model.isDependant();
	}

	/**
	 * Returns <code>true</code> if this employee family is nominee.
	 *
	 * @return <code>true</code> if this employee family is nominee; <code>false</code> otherwise
	 */
	@Override
	public boolean isNominee() {
		return model.isNominee();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this employee family is alive.
	 *
	 * @param alive the alive of this employee family
	 */
	@Override
	public void setAlive(boolean alive) {
		model.setAlive(alive);
	}

	/**
	 * Sets the cgegis percentage of this employee family.
	 *
	 * @param cgegisPercentage the cgegis percentage of this employee family
	 */
	@Override
	public void setCgegisPercentage(float cgegisPercentage) {
		model.setCgegisPercentage(cgegisPercentage);
	}

	/**
	 * Sets the company ID of this employee family.
	 *
	 * @param companyId the company ID of this employee family
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee family.
	 *
	 * @param createDate the create date of this employee family
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date of birth of this employee family.
	 *
	 * @param dateOfBirth the date of birth of this employee family
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the date of demise of this employee family.
	 *
	 * @param dateOfDemise the date of demise of this employee family
	 */
	@Override
	public void setDateOfDemise(Date dateOfDemise) {
		model.setDateOfDemise(dateOfDemise);
	}

	/**
	 * Sets the dcrc percentage of this employee family.
	 *
	 * @param dcrcPercentage the dcrc percentage of this employee family
	 */
	@Override
	public void setDcrcPercentage(float dcrcPercentage) {
		model.setDcrcPercentage(dcrcPercentage);
	}

	/**
	 * Sets whether this employee family is dependant.
	 *
	 * @param dependant the dependant of this employee family
	 */
	@Override
	public void setDependant(boolean dependant) {
		model.setDependant(dependant);
	}

	/**
	 * Sets the document proof ID of this employee family.
	 *
	 * @param documentProofId the document proof ID of this employee family
	 */
	@Override
	public void setDocumentProofId(long documentProofId) {
		model.setDocumentProofId(documentProofId);
	}

	/**
	 * Sets the employee family ID of this employee family.
	 *
	 * @param employeeFamilyId the employee family ID of this employee family
	 */
	@Override
	public void setEmployeeFamilyId(long employeeFamilyId) {
		model.setEmployeeFamilyId(employeeFamilyId);
	}

	/**
	 * Sets the employee ID of this employee family.
	 *
	 * @param employeeId the employee ID of this employee family
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the gender ID of this employee family.
	 *
	 * @param genderId the gender ID of this employee family
	 */
	@Override
	public void setGenderId(long genderId) {
		model.setGenderId(genderId);
	}

	/**
	 * Sets the group ID of this employee family.
	 *
	 * @param groupId the group ID of this employee family
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the health problem of this employee family.
	 *
	 * @param healthProblem the health problem of this employee family
	 */
	@Override
	public void setHealthProblem(String healthProblem) {
		model.setHealthProblem(healthProblem);
	}

	/**
	 * Sets the modified date of this employee family.
	 *
	 * @param modifiedDate the modified date of this employee family
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this employee family.
	 *
	 * @param name the name of this employee family
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets whether this employee family is nominee.
	 *
	 * @param nominee the nominee of this employee family
	 */
	@Override
	public void setNominee(boolean nominee) {
		model.setNominee(nominee);
	}

	/**
	 * Sets the occupation ID of this employee family.
	 *
	 * @param occupationId the occupation ID of this employee family
	 */
	@Override
	public void setOccupationId(long occupationId) {
		model.setOccupationId(occupationId);
	}

	/**
	 * Sets the pf percentage of this employee family.
	 *
	 * @param pfPercentage the pf percentage of this employee family
	 */
	@Override
	public void setPfPercentage(float pfPercentage) {
		model.setPfPercentage(pfPercentage);
	}

	/**
	 * Sets the primary key of this employee family.
	 *
	 * @param primaryKey the primary key of this employee family
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the relation ID of this employee family.
	 *
	 * @param relationId the relation ID of this employee family
	 */
	@Override
	public void setRelationId(long relationId) {
		model.setRelationId(relationId);
	}

	/**
	 * Sets the status of this employee family.
	 *
	 * @param status the status of this employee family
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this employee family.
	 *
	 * @param userId the user ID of this employee family
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee family.
	 *
	 * @param userName the user name of this employee family
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee family.
	 *
	 * @param userUuid the user uuid of this employee family
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeFamilyWrapper wrap(EmployeeFamily employeeFamily) {
		return new EmployeeFamilyWrapper(employeeFamily);
	}

}