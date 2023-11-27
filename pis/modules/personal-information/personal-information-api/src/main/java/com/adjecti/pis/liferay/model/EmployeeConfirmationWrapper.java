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
 * This class is a wrapper for {@link EmployeeConfirmation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeConfirmation
 * @generated
 */
public class EmployeeConfirmationWrapper
	extends BaseModelWrapper<EmployeeConfirmation>
	implements EmployeeConfirmation, ModelWrapper<EmployeeConfirmation> {

	public EmployeeConfirmationWrapper(
		EmployeeConfirmation employeeConfirmation) {

		super(employeeConfirmation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeConfirmationId", getEmployeeConfirmationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("confirmationDate", getConfirmationDate());
		attributes.put("confirmationLetterId", getConfirmationLetterId());
		attributes.put("designationId", getDesignationId());
		attributes.put("gradeId", getGradeId());
		attributes.put("gradeModeId", getGradeModeId());
		attributes.put("joiningId", getJoiningId());
		attributes.put("promotionId", getPromotionId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("confirmationPostId", getConfirmationPostId());
		attributes.put("status", getStatus());
		attributes.put("employeeId", getEmployeeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeConfirmationId = (Long)attributes.get(
			"employeeConfirmationId");

		if (employeeConfirmationId != null) {
			setEmployeeConfirmationId(employeeConfirmationId);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date confirmationDate = (Date)attributes.get("confirmationDate");

		if (confirmationDate != null) {
			setConfirmationDate(confirmationDate);
		}

		Long confirmationLetterId = (Long)attributes.get(
			"confirmationLetterId");

		if (confirmationLetterId != null) {
			setConfirmationLetterId(confirmationLetterId);
		}

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		Long gradeId = (Long)attributes.get("gradeId");

		if (gradeId != null) {
			setGradeId(gradeId);
		}

		Long gradeModeId = (Long)attributes.get("gradeModeId");

		if (gradeModeId != null) {
			setGradeModeId(gradeModeId);
		}

		Long joiningId = (Long)attributes.get("joiningId");

		if (joiningId != null) {
			setJoiningId(joiningId);
		}

		Long promotionId = (Long)attributes.get("promotionId");

		if (promotionId != null) {
			setPromotionId(promotionId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long confirmationPostId = (Long)attributes.get("confirmationPostId");

		if (confirmationPostId != null) {
			setConfirmationPostId(confirmationPostId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	/**
	 * Returns the active of this employee confirmation.
	 *
	 * @return the active of this employee confirmation
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee confirmation.
	 *
	 * @return the company ID of this employee confirmation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the confirmation date of this employee confirmation.
	 *
	 * @return the confirmation date of this employee confirmation
	 */
	@Override
	public Date getConfirmationDate() {
		return model.getConfirmationDate();
	}

	/**
	 * Returns the confirmation letter ID of this employee confirmation.
	 *
	 * @return the confirmation letter ID of this employee confirmation
	 */
	@Override
	public long getConfirmationLetterId() {
		return model.getConfirmationLetterId();
	}

	/**
	 * Returns the confirmation post ID of this employee confirmation.
	 *
	 * @return the confirmation post ID of this employee confirmation
	 */
	@Override
	public long getConfirmationPostId() {
		return model.getConfirmationPostId();
	}

	/**
	 * Returns the create date of this employee confirmation.
	 *
	 * @return the create date of this employee confirmation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the designation ID of this employee confirmation.
	 *
	 * @return the designation ID of this employee confirmation
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the employee confirmation ID of this employee confirmation.
	 *
	 * @return the employee confirmation ID of this employee confirmation
	 */
	@Override
	public long getEmployeeConfirmationId() {
		return model.getEmployeeConfirmationId();
	}

	/**
	 * Returns the employee ID of this employee confirmation.
	 *
	 * @return the employee ID of this employee confirmation
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the grade ID of this employee confirmation.
	 *
	 * @return the grade ID of this employee confirmation
	 */
	@Override
	public long getGradeId() {
		return model.getGradeId();
	}

	/**
	 * Returns the grade mode ID of this employee confirmation.
	 *
	 * @return the grade mode ID of this employee confirmation
	 */
	@Override
	public long getGradeModeId() {
		return model.getGradeModeId();
	}

	/**
	 * Returns the group ID of this employee confirmation.
	 *
	 * @return the group ID of this employee confirmation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the joining ID of this employee confirmation.
	 *
	 * @return the joining ID of this employee confirmation
	 */
	@Override
	public long getJoiningId() {
		return model.getJoiningId();
	}

	/**
	 * Returns the modified date of this employee confirmation.
	 *
	 * @return the modified date of this employee confirmation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this employee confirmation.
	 *
	 * @return the organization ID of this employee confirmation
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this employee confirmation.
	 *
	 * @return the primary key of this employee confirmation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the promotion ID of this employee confirmation.
	 *
	 * @return the promotion ID of this employee confirmation
	 */
	@Override
	public long getPromotionId() {
		return model.getPromotionId();
	}

	/**
	 * Returns the status of this employee confirmation.
	 *
	 * @return the status of this employee confirmation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this employee confirmation.
	 *
	 * @return the user ID of this employee confirmation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee confirmation.
	 *
	 * @return the user name of this employee confirmation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee confirmation.
	 *
	 * @return the user uuid of this employee confirmation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee confirmation is active.
	 *
	 * @return <code>true</code> if this employee confirmation is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this employee confirmation is active.
	 *
	 * @param active the active of this employee confirmation
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee confirmation.
	 *
	 * @param companyId the company ID of this employee confirmation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the confirmation date of this employee confirmation.
	 *
	 * @param confirmationDate the confirmation date of this employee confirmation
	 */
	@Override
	public void setConfirmationDate(Date confirmationDate) {
		model.setConfirmationDate(confirmationDate);
	}

	/**
	 * Sets the confirmation letter ID of this employee confirmation.
	 *
	 * @param confirmationLetterId the confirmation letter ID of this employee confirmation
	 */
	@Override
	public void setConfirmationLetterId(long confirmationLetterId) {
		model.setConfirmationLetterId(confirmationLetterId);
	}

	/**
	 * Sets the confirmation post ID of this employee confirmation.
	 *
	 * @param confirmationPostId the confirmation post ID of this employee confirmation
	 */
	@Override
	public void setConfirmationPostId(long confirmationPostId) {
		model.setConfirmationPostId(confirmationPostId);
	}

	/**
	 * Sets the create date of this employee confirmation.
	 *
	 * @param createDate the create date of this employee confirmation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the designation ID of this employee confirmation.
	 *
	 * @param designationId the designation ID of this employee confirmation
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the employee confirmation ID of this employee confirmation.
	 *
	 * @param employeeConfirmationId the employee confirmation ID of this employee confirmation
	 */
	@Override
	public void setEmployeeConfirmationId(long employeeConfirmationId) {
		model.setEmployeeConfirmationId(employeeConfirmationId);
	}

	/**
	 * Sets the employee ID of this employee confirmation.
	 *
	 * @param employeeId the employee ID of this employee confirmation
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the grade ID of this employee confirmation.
	 *
	 * @param gradeId the grade ID of this employee confirmation
	 */
	@Override
	public void setGradeId(long gradeId) {
		model.setGradeId(gradeId);
	}

	/**
	 * Sets the grade mode ID of this employee confirmation.
	 *
	 * @param gradeModeId the grade mode ID of this employee confirmation
	 */
	@Override
	public void setGradeModeId(long gradeModeId) {
		model.setGradeModeId(gradeModeId);
	}

	/**
	 * Sets the group ID of this employee confirmation.
	 *
	 * @param groupId the group ID of this employee confirmation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the joining ID of this employee confirmation.
	 *
	 * @param joiningId the joining ID of this employee confirmation
	 */
	@Override
	public void setJoiningId(long joiningId) {
		model.setJoiningId(joiningId);
	}

	/**
	 * Sets the modified date of this employee confirmation.
	 *
	 * @param modifiedDate the modified date of this employee confirmation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this employee confirmation.
	 *
	 * @param organizationId the organization ID of this employee confirmation
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this employee confirmation.
	 *
	 * @param primaryKey the primary key of this employee confirmation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the promotion ID of this employee confirmation.
	 *
	 * @param promotionId the promotion ID of this employee confirmation
	 */
	@Override
	public void setPromotionId(long promotionId) {
		model.setPromotionId(promotionId);
	}

	/**
	 * Sets the status of this employee confirmation.
	 *
	 * @param status the status of this employee confirmation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this employee confirmation.
	 *
	 * @param userId the user ID of this employee confirmation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee confirmation.
	 *
	 * @param userName the user name of this employee confirmation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee confirmation.
	 *
	 * @param userUuid the user uuid of this employee confirmation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeConfirmationWrapper wrap(
		EmployeeConfirmation employeeConfirmation) {

		return new EmployeeConfirmationWrapper(employeeConfirmation);
	}

}