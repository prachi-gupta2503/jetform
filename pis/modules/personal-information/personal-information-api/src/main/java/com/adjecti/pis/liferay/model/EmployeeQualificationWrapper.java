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
 * This class is a wrapper for {@link EmployeeQualification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeQualification
 * @generated
 */
public class EmployeeQualificationWrapper
	extends BaseModelWrapper<EmployeeQualification>
	implements EmployeeQualification, ModelWrapper<EmployeeQualification> {

	public EmployeeQualificationWrapper(
		EmployeeQualification employeeQualification) {

		super(employeeQualification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeQualificationId", getEmployeeQualificationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("foreignDegree", isForeignDegree());
		attributes.put("foreignInstitution", getForeignInstitution());
		attributes.put("fromYear", getFromYear());
		attributes.put("marksSecured", getMarksSecured());
		attributes.put("toYear", getToYear());
		attributes.put("documentProofId", getDocumentProofId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("gradeId", getGradeId());
		attributes.put("levelId", getLevelId());
		attributes.put("qualificationId", getQualificationId());
		attributes.put("specializationId", getSpecializationId());
		attributes.put("marksPercentage", getMarksPercentage());
		attributes.put("passedDate", getPassedDate());
		attributes.put("certificateId", getCertificateId());
		attributes.put("qualificationDate", getQualificationDate());
		attributes.put("institution", getInstitution());
		attributes.put("joiningProcessId", getJoiningProcessId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeQualificationId = (Long)attributes.get(
			"employeeQualificationId");

		if (employeeQualificationId != null) {
			setEmployeeQualificationId(employeeQualificationId);
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

		Boolean foreignDegree = (Boolean)attributes.get("foreignDegree");

		if (foreignDegree != null) {
			setForeignDegree(foreignDegree);
		}

		String foreignInstitution = (String)attributes.get(
			"foreignInstitution");

		if (foreignInstitution != null) {
			setForeignInstitution(foreignInstitution);
		}

		Integer fromYear = (Integer)attributes.get("fromYear");

		if (fromYear != null) {
			setFromYear(fromYear);
		}

		Float marksSecured = (Float)attributes.get("marksSecured");

		if (marksSecured != null) {
			setMarksSecured(marksSecured);
		}

		Integer toYear = (Integer)attributes.get("toYear");

		if (toYear != null) {
			setToYear(toYear);
		}

		Long documentProofId = (Long)attributes.get("documentProofId");

		if (documentProofId != null) {
			setDocumentProofId(documentProofId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long gradeId = (Long)attributes.get("gradeId");

		if (gradeId != null) {
			setGradeId(gradeId);
		}

		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		Long qualificationId = (Long)attributes.get("qualificationId");

		if (qualificationId != null) {
			setQualificationId(qualificationId);
		}

		Long specializationId = (Long)attributes.get("specializationId");

		if (specializationId != null) {
			setSpecializationId(specializationId);
		}

		Long marksPercentage = (Long)attributes.get("marksPercentage");

		if (marksPercentage != null) {
			setMarksPercentage(marksPercentage);
		}

		Date passedDate = (Date)attributes.get("passedDate");

		if (passedDate != null) {
			setPassedDate(passedDate);
		}

		Long certificateId = (Long)attributes.get("certificateId");

		if (certificateId != null) {
			setCertificateId(certificateId);
		}

		Date qualificationDate = (Date)attributes.get("qualificationDate");

		if (qualificationDate != null) {
			setQualificationDate(qualificationDate);
		}

		String institution = (String)attributes.get("institution");

		if (institution != null) {
			setInstitution(institution);
		}

		Long joiningProcessId = (Long)attributes.get("joiningProcessId");

		if (joiningProcessId != null) {
			setJoiningProcessId(joiningProcessId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the certificate ID of this employee qualification.
	 *
	 * @return the certificate ID of this employee qualification
	 */
	@Override
	public long getCertificateId() {
		return model.getCertificateId();
	}

	/**
	 * Returns the company ID of this employee qualification.
	 *
	 * @return the company ID of this employee qualification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee qualification.
	 *
	 * @return the create date of this employee qualification
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the document proof ID of this employee qualification.
	 *
	 * @return the document proof ID of this employee qualification
	 */
	@Override
	public long getDocumentProofId() {
		return model.getDocumentProofId();
	}

	/**
	 * Returns the employee ID of this employee qualification.
	 *
	 * @return the employee ID of this employee qualification
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee qualification ID of this employee qualification.
	 *
	 * @return the employee qualification ID of this employee qualification
	 */
	@Override
	public long getEmployeeQualificationId() {
		return model.getEmployeeQualificationId();
	}

	/**
	 * Returns the foreign degree of this employee qualification.
	 *
	 * @return the foreign degree of this employee qualification
	 */
	@Override
	public boolean getForeignDegree() {
		return model.getForeignDegree();
	}

	/**
	 * Returns the foreign institution of this employee qualification.
	 *
	 * @return the foreign institution of this employee qualification
	 */
	@Override
	public String getForeignInstitution() {
		return model.getForeignInstitution();
	}

	/**
	 * Returns the from year of this employee qualification.
	 *
	 * @return the from year of this employee qualification
	 */
	@Override
	public int getFromYear() {
		return model.getFromYear();
	}

	/**
	 * Returns the grade ID of this employee qualification.
	 *
	 * @return the grade ID of this employee qualification
	 */
	@Override
	public long getGradeId() {
		return model.getGradeId();
	}

	/**
	 * Returns the group ID of this employee qualification.
	 *
	 * @return the group ID of this employee qualification
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the institution of this employee qualification.
	 *
	 * @return the institution of this employee qualification
	 */
	@Override
	public String getInstitution() {
		return model.getInstitution();
	}

	/**
	 * Returns the joining process ID of this employee qualification.
	 *
	 * @return the joining process ID of this employee qualification
	 */
	@Override
	public long getJoiningProcessId() {
		return model.getJoiningProcessId();
	}

	/**
	 * Returns the level ID of this employee qualification.
	 *
	 * @return the level ID of this employee qualification
	 */
	@Override
	public long getLevelId() {
		return model.getLevelId();
	}

	/**
	 * Returns the marks percentage of this employee qualification.
	 *
	 * @return the marks percentage of this employee qualification
	 */
	@Override
	public long getMarksPercentage() {
		return model.getMarksPercentage();
	}

	/**
	 * Returns the marks secured of this employee qualification.
	 *
	 * @return the marks secured of this employee qualification
	 */
	@Override
	public float getMarksSecured() {
		return model.getMarksSecured();
	}

	/**
	 * Returns the modified date of this employee qualification.
	 *
	 * @return the modified date of this employee qualification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the passed date of this employee qualification.
	 *
	 * @return the passed date of this employee qualification
	 */
	@Override
	public Date getPassedDate() {
		return model.getPassedDate();
	}

	/**
	 * Returns the primary key of this employee qualification.
	 *
	 * @return the primary key of this employee qualification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public java.util.List<EmployeeQualification> getQualificationByEmployeeId(
			long employeeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return model.getQualificationByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<EmployeeQualification> getQualificationByPersonalNo(
			String personalNo)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException,
			   com.adjecti.pis.liferay.exception.
				   NoSuchEmployeeQualificationException {

		return model.getQualificationByPersonalNo(personalNo);
	}

	/**
	 * Returns the qualification date of this employee qualification.
	 *
	 * @return the qualification date of this employee qualification
	 */
	@Override
	public Date getQualificationDate() {
		return model.getQualificationDate();
	}

	/**
	 * Returns the qualification ID of this employee qualification.
	 *
	 * @return the qualification ID of this employee qualification
	 */
	@Override
	public long getQualificationId() {
		return model.getQualificationId();
	}

	/**
	 * Returns the specialization ID of this employee qualification.
	 *
	 * @return the specialization ID of this employee qualification
	 */
	@Override
	public long getSpecializationId() {
		return model.getSpecializationId();
	}

	/**
	 * Returns the status of this employee qualification.
	 *
	 * @return the status of this employee qualification
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to year of this employee qualification.
	 *
	 * @return the to year of this employee qualification
	 */
	@Override
	public int getToYear() {
		return model.getToYear();
	}

	/**
	 * Returns the user ID of this employee qualification.
	 *
	 * @return the user ID of this employee qualification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee qualification.
	 *
	 * @return the user name of this employee qualification
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee qualification.
	 *
	 * @return the user uuid of this employee qualification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee qualification is foreign degree.
	 *
	 * @return <code>true</code> if this employee qualification is foreign degree; <code>false</code> otherwise
	 */
	@Override
	public boolean isForeignDegree() {
		return model.isForeignDegree();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the certificate ID of this employee qualification.
	 *
	 * @param certificateId the certificate ID of this employee qualification
	 */
	@Override
	public void setCertificateId(long certificateId) {
		model.setCertificateId(certificateId);
	}

	/**
	 * Sets the company ID of this employee qualification.
	 *
	 * @param companyId the company ID of this employee qualification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee qualification.
	 *
	 * @param createDate the create date of this employee qualification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the document proof ID of this employee qualification.
	 *
	 * @param documentProofId the document proof ID of this employee qualification
	 */
	@Override
	public void setDocumentProofId(long documentProofId) {
		model.setDocumentProofId(documentProofId);
	}

	/**
	 * Sets the employee ID of this employee qualification.
	 *
	 * @param employeeId the employee ID of this employee qualification
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee qualification ID of this employee qualification.
	 *
	 * @param employeeQualificationId the employee qualification ID of this employee qualification
	 */
	@Override
	public void setEmployeeQualificationId(long employeeQualificationId) {
		model.setEmployeeQualificationId(employeeQualificationId);
	}

	/**
	 * Sets whether this employee qualification is foreign degree.
	 *
	 * @param foreignDegree the foreign degree of this employee qualification
	 */
	@Override
	public void setForeignDegree(boolean foreignDegree) {
		model.setForeignDegree(foreignDegree);
	}

	/**
	 * Sets the foreign institution of this employee qualification.
	 *
	 * @param foreignInstitution the foreign institution of this employee qualification
	 */
	@Override
	public void setForeignInstitution(String foreignInstitution) {
		model.setForeignInstitution(foreignInstitution);
	}

	/**
	 * Sets the from year of this employee qualification.
	 *
	 * @param fromYear the from year of this employee qualification
	 */
	@Override
	public void setFromYear(int fromYear) {
		model.setFromYear(fromYear);
	}

	/**
	 * Sets the grade ID of this employee qualification.
	 *
	 * @param gradeId the grade ID of this employee qualification
	 */
	@Override
	public void setGradeId(long gradeId) {
		model.setGradeId(gradeId);
	}

	/**
	 * Sets the group ID of this employee qualification.
	 *
	 * @param groupId the group ID of this employee qualification
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the institution of this employee qualification.
	 *
	 * @param institution the institution of this employee qualification
	 */
	@Override
	public void setInstitution(String institution) {
		model.setInstitution(institution);
	}

	/**
	 * Sets the joining process ID of this employee qualification.
	 *
	 * @param joiningProcessId the joining process ID of this employee qualification
	 */
	@Override
	public void setJoiningProcessId(long joiningProcessId) {
		model.setJoiningProcessId(joiningProcessId);
	}

	/**
	 * Sets the level ID of this employee qualification.
	 *
	 * @param levelId the level ID of this employee qualification
	 */
	@Override
	public void setLevelId(long levelId) {
		model.setLevelId(levelId);
	}

	/**
	 * Sets the marks percentage of this employee qualification.
	 *
	 * @param marksPercentage the marks percentage of this employee qualification
	 */
	@Override
	public void setMarksPercentage(long marksPercentage) {
		model.setMarksPercentage(marksPercentage);
	}

	/**
	 * Sets the marks secured of this employee qualification.
	 *
	 * @param marksSecured the marks secured of this employee qualification
	 */
	@Override
	public void setMarksSecured(float marksSecured) {
		model.setMarksSecured(marksSecured);
	}

	/**
	 * Sets the modified date of this employee qualification.
	 *
	 * @param modifiedDate the modified date of this employee qualification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the passed date of this employee qualification.
	 *
	 * @param passedDate the passed date of this employee qualification
	 */
	@Override
	public void setPassedDate(Date passedDate) {
		model.setPassedDate(passedDate);
	}

	/**
	 * Sets the primary key of this employee qualification.
	 *
	 * @param primaryKey the primary key of this employee qualification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the qualification date of this employee qualification.
	 *
	 * @param qualificationDate the qualification date of this employee qualification
	 */
	@Override
	public void setQualificationDate(Date qualificationDate) {
		model.setQualificationDate(qualificationDate);
	}

	/**
	 * Sets the qualification ID of this employee qualification.
	 *
	 * @param qualificationId the qualification ID of this employee qualification
	 */
	@Override
	public void setQualificationId(long qualificationId) {
		model.setQualificationId(qualificationId);
	}

	/**
	 * Sets the specialization ID of this employee qualification.
	 *
	 * @param specializationId the specialization ID of this employee qualification
	 */
	@Override
	public void setSpecializationId(long specializationId) {
		model.setSpecializationId(specializationId);
	}

	/**
	 * Sets the status of this employee qualification.
	 *
	 * @param status the status of this employee qualification
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to year of this employee qualification.
	 *
	 * @param toYear the to year of this employee qualification
	 */
	@Override
	public void setToYear(int toYear) {
		model.setToYear(toYear);
	}

	/**
	 * Sets the user ID of this employee qualification.
	 *
	 * @param userId the user ID of this employee qualification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee qualification.
	 *
	 * @param userName the user name of this employee qualification
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee qualification.
	 *
	 * @param userUuid the user uuid of this employee qualification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeQualificationWrapper wrap(
		EmployeeQualification employeeQualification) {

		return new EmployeeQualificationWrapper(employeeQualification);
	}

}