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
 * This class is a wrapper for {@link EmployeePromotion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePromotion
 * @generated
 */
public class EmployeePromotionWrapper
	extends BaseModelWrapper<EmployeePromotion>
	implements EmployeePromotion, ModelWrapper<EmployeePromotion> {

	public EmployeePromotionWrapper(EmployeePromotion employeePromotion) {
		super(employeePromotion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeePromotionId", getEmployeePromotionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("promotionDate", getPromotionDate());
		attributes.put("designationId", getDesignationId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("gradeId", getGradeId());
		attributes.put("gradeModeId", getGradeModeId());
		attributes.put("promotionLetterId", getPromotionLetterId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("personalNo", getPersonalNo());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeePromotionId = (Long)attributes.get("employeePromotionId");

		if (employeePromotionId != null) {
			setEmployeePromotionId(employeePromotionId);
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

		Date promotionDate = (Date)attributes.get("promotionDate");

		if (promotionDate != null) {
			setPromotionDate(promotionDate);
		}

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long gradeId = (Long)attributes.get("gradeId");

		if (gradeId != null) {
			setGradeId(gradeId);
		}

		Long gradeModeId = (Long)attributes.get("gradeModeId");

		if (gradeModeId != null) {
			setGradeModeId(gradeModeId);
		}

		Long promotionLetterId = (Long)attributes.get("promotionLetterId");

		if (promotionLetterId != null) {
			setPromotionLetterId(promotionLetterId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long personalNo = (Long)attributes.get("personalNo");

		if (personalNo != null) {
			setPersonalNo(personalNo);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee promotion.
	 *
	 * @return the active of this employee promotion
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee promotion.
	 *
	 * @return the company ID of this employee promotion
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee promotion.
	 *
	 * @return the create date of this employee promotion
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the designation ID of this employee promotion.
	 *
	 * @return the designation ID of this employee promotion
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the employee ID of this employee promotion.
	 *
	 * @return the employee ID of this employee promotion
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee promotion ID of this employee promotion.
	 *
	 * @return the employee promotion ID of this employee promotion
	 */
	@Override
	public long getEmployeePromotionId() {
		return model.getEmployeePromotionId();
	}

	/**
	 * Returns the grade ID of this employee promotion.
	 *
	 * @return the grade ID of this employee promotion
	 */
	@Override
	public long getGradeId() {
		return model.getGradeId();
	}

	/**
	 * Returns the grade mode ID of this employee promotion.
	 *
	 * @return the grade mode ID of this employee promotion
	 */
	@Override
	public long getGradeModeId() {
		return model.getGradeModeId();
	}

	/**
	 * Returns the group ID of this employee promotion.
	 *
	 * @return the group ID of this employee promotion
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee promotion.
	 *
	 * @return the modified date of this employee promotion
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this employee promotion.
	 *
	 * @return the organization ID of this employee promotion
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the personal no of this employee promotion.
	 *
	 * @return the personal no of this employee promotion
	 */
	@Override
	public long getPersonalNo() {
		return model.getPersonalNo();
	}

	/**
	 * Returns the primary key of this employee promotion.
	 *
	 * @return the primary key of this employee promotion
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the promotion date of this employee promotion.
	 *
	 * @return the promotion date of this employee promotion
	 */
	@Override
	public Date getPromotionDate() {
		return model.getPromotionDate();
	}

	/**
	 * Returns the promotion letter ID of this employee promotion.
	 *
	 * @return the promotion letter ID of this employee promotion
	 */
	@Override
	public long getPromotionLetterId() {
		return model.getPromotionLetterId();
	}

	/**
	 * Returns the status of this employee promotion.
	 *
	 * @return the status of this employee promotion
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this employee promotion.
	 *
	 * @return the user ID of this employee promotion
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee promotion.
	 *
	 * @return the user name of this employee promotion
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee promotion.
	 *
	 * @return the user uuid of this employee promotion
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee promotion is active.
	 *
	 * @return <code>true</code> if this employee promotion is active; <code>false</code> otherwise
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
	 * Sets whether this employee promotion is active.
	 *
	 * @param active the active of this employee promotion
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee promotion.
	 *
	 * @param companyId the company ID of this employee promotion
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee promotion.
	 *
	 * @param createDate the create date of this employee promotion
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the designation ID of this employee promotion.
	 *
	 * @param designationId the designation ID of this employee promotion
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the employee ID of this employee promotion.
	 *
	 * @param employeeId the employee ID of this employee promotion
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee promotion ID of this employee promotion.
	 *
	 * @param employeePromotionId the employee promotion ID of this employee promotion
	 */
	@Override
	public void setEmployeePromotionId(long employeePromotionId) {
		model.setEmployeePromotionId(employeePromotionId);
	}

	/**
	 * Sets the grade ID of this employee promotion.
	 *
	 * @param gradeId the grade ID of this employee promotion
	 */
	@Override
	public void setGradeId(long gradeId) {
		model.setGradeId(gradeId);
	}

	/**
	 * Sets the grade mode ID of this employee promotion.
	 *
	 * @param gradeModeId the grade mode ID of this employee promotion
	 */
	@Override
	public void setGradeModeId(long gradeModeId) {
		model.setGradeModeId(gradeModeId);
	}

	/**
	 * Sets the group ID of this employee promotion.
	 *
	 * @param groupId the group ID of this employee promotion
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee promotion.
	 *
	 * @param modifiedDate the modified date of this employee promotion
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this employee promotion.
	 *
	 * @param organizationId the organization ID of this employee promotion
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the personal no of this employee promotion.
	 *
	 * @param personalNo the personal no of this employee promotion
	 */
	@Override
	public void setPersonalNo(long personalNo) {
		model.setPersonalNo(personalNo);
	}

	/**
	 * Sets the primary key of this employee promotion.
	 *
	 * @param primaryKey the primary key of this employee promotion
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the promotion date of this employee promotion.
	 *
	 * @param promotionDate the promotion date of this employee promotion
	 */
	@Override
	public void setPromotionDate(Date promotionDate) {
		model.setPromotionDate(promotionDate);
	}

	/**
	 * Sets the promotion letter ID of this employee promotion.
	 *
	 * @param promotionLetterId the promotion letter ID of this employee promotion
	 */
	@Override
	public void setPromotionLetterId(long promotionLetterId) {
		model.setPromotionLetterId(promotionLetterId);
	}

	/**
	 * Sets the status of this employee promotion.
	 *
	 * @param status the status of this employee promotion
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this employee promotion.
	 *
	 * @param userId the user ID of this employee promotion
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee promotion.
	 *
	 * @param userName the user name of this employee promotion
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee promotion.
	 *
	 * @param userUuid the user uuid of this employee promotion
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeePromotionWrapper wrap(
		EmployeePromotion employeePromotion) {

		return new EmployeePromotionWrapper(employeePromotion);
	}

}