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
 * This class is a wrapper for {@link MonthlySalary}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlySalary
 * @generated
 */
public class MonthlySalaryWrapper
	extends BaseModelWrapper<MonthlySalary>
	implements ModelWrapper<MonthlySalary>, MonthlySalary {

	public MonthlySalaryWrapper(MonthlySalary monthlySalary) {
		super(monthlySalary);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("monthlySalaryId", getMonthlySalaryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("grossDeduction", getGrossDeduction());
		attributes.put("grossIncome", getGrossIncome());
		attributes.put("netPayble", getNetPayble());
		attributes.put("processMonth", getProcessMonth());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("structureId", getStructureId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long monthlySalaryId = (Long)attributes.get("monthlySalaryId");

		if (monthlySalaryId != null) {
			setMonthlySalaryId(monthlySalaryId);
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

		Float grossDeduction = (Float)attributes.get("grossDeduction");

		if (grossDeduction != null) {
			setGrossDeduction(grossDeduction);
		}

		Float grossIncome = (Float)attributes.get("grossIncome");

		if (grossIncome != null) {
			setGrossIncome(grossIncome);
		}

		Float netPayble = (Float)attributes.get("netPayble");

		if (netPayble != null) {
			setNetPayble(netPayble);
		}

		Date processMonth = (Date)attributes.get("processMonth");

		if (processMonth != null) {
			setProcessMonth(processMonth);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long structureId = (Long)attributes.get("structureId");

		if (structureId != null) {
			setStructureId(structureId);
		}
	}

	/**
	 * Returns the company ID of this monthly salary.
	 *
	 * @return the company ID of this monthly salary
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this monthly salary.
	 *
	 * @return the create date of this monthly salary
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this monthly salary.
	 *
	 * @return the employee ID of this monthly salary
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the gross deduction of this monthly salary.
	 *
	 * @return the gross deduction of this monthly salary
	 */
	@Override
	public float getGrossDeduction() {
		return model.getGrossDeduction();
	}

	/**
	 * Returns the gross income of this monthly salary.
	 *
	 * @return the gross income of this monthly salary
	 */
	@Override
	public float getGrossIncome() {
		return model.getGrossIncome();
	}

	/**
	 * Returns the group ID of this monthly salary.
	 *
	 * @return the group ID of this monthly salary
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this monthly salary.
	 *
	 * @return the modified date of this monthly salary
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the monthly salary ID of this monthly salary.
	 *
	 * @return the monthly salary ID of this monthly salary
	 */
	@Override
	public long getMonthlySalaryId() {
		return model.getMonthlySalaryId();
	}

	/**
	 * Returns the net payble of this monthly salary.
	 *
	 * @return the net payble of this monthly salary
	 */
	@Override
	public float getNetPayble() {
		return model.getNetPayble();
	}

	/**
	 * Returns the primary key of this monthly salary.
	 *
	 * @return the primary key of this monthly salary
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process month of this monthly salary.
	 *
	 * @return the process month of this monthly salary
	 */
	@Override
	public Date getProcessMonth() {
		return model.getProcessMonth();
	}

	/**
	 * Returns the structure ID of this monthly salary.
	 *
	 * @return the structure ID of this monthly salary
	 */
	@Override
	public long getStructureId() {
		return model.getStructureId();
	}

	/**
	 * Returns the user ID of this monthly salary.
	 *
	 * @return the user ID of this monthly salary
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this monthly salary.
	 *
	 * @return the user name of this monthly salary
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this monthly salary.
	 *
	 * @return the user uuid of this monthly salary
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this monthly salary.
	 *
	 * @param companyId the company ID of this monthly salary
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this monthly salary.
	 *
	 * @param createDate the create date of this monthly salary
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this monthly salary.
	 *
	 * @param employeeId the employee ID of this monthly salary
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the gross deduction of this monthly salary.
	 *
	 * @param grossDeduction the gross deduction of this monthly salary
	 */
	@Override
	public void setGrossDeduction(float grossDeduction) {
		model.setGrossDeduction(grossDeduction);
	}

	/**
	 * Sets the gross income of this monthly salary.
	 *
	 * @param grossIncome the gross income of this monthly salary
	 */
	@Override
	public void setGrossIncome(float grossIncome) {
		model.setGrossIncome(grossIncome);
	}

	/**
	 * Sets the group ID of this monthly salary.
	 *
	 * @param groupId the group ID of this monthly salary
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this monthly salary.
	 *
	 * @param modifiedDate the modified date of this monthly salary
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the monthly salary ID of this monthly salary.
	 *
	 * @param monthlySalaryId the monthly salary ID of this monthly salary
	 */
	@Override
	public void setMonthlySalaryId(long monthlySalaryId) {
		model.setMonthlySalaryId(monthlySalaryId);
	}

	/**
	 * Sets the net payble of this monthly salary.
	 *
	 * @param netPayble the net payble of this monthly salary
	 */
	@Override
	public void setNetPayble(float netPayble) {
		model.setNetPayble(netPayble);
	}

	/**
	 * Sets the primary key of this monthly salary.
	 *
	 * @param primaryKey the primary key of this monthly salary
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process month of this monthly salary.
	 *
	 * @param processMonth the process month of this monthly salary
	 */
	@Override
	public void setProcessMonth(Date processMonth) {
		model.setProcessMonth(processMonth);
	}

	/**
	 * Sets the structure ID of this monthly salary.
	 *
	 * @param structureId the structure ID of this monthly salary
	 */
	@Override
	public void setStructureId(long structureId) {
		model.setStructureId(structureId);
	}

	/**
	 * Sets the user ID of this monthly salary.
	 *
	 * @param userId the user ID of this monthly salary
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this monthly salary.
	 *
	 * @param userName the user name of this monthly salary
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this monthly salary.
	 *
	 * @param userUuid the user uuid of this monthly salary
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MonthlySalaryWrapper wrap(MonthlySalary monthlySalary) {
		return new MonthlySalaryWrapper(monthlySalary);
	}

}