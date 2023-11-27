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
 * This class is a wrapper for {@link EmployeeTrade}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTrade
 * @generated
 */
public class EmployeeTradeWrapper
	extends BaseModelWrapper<EmployeeTrade>
	implements EmployeeTrade, ModelWrapper<EmployeeTrade> {

	public EmployeeTradeWrapper(EmployeeTrade employeeTrade) {
		super(employeeTrade);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeTradeId", getEmployeeTradeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("tradeId", getTradeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeTradeId = (Long)attributes.get("employeeTradeId");

		if (employeeTradeId != null) {
			setEmployeeTradeId(employeeTradeId);
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

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long tradeId = (Long)attributes.get("tradeId");

		if (tradeId != null) {
			setTradeId(tradeId);
		}
	}

	/**
	 * Returns the active of this employee trade.
	 *
	 * @return the active of this employee trade
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee trade.
	 *
	 * @return the company ID of this employee trade
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee trade.
	 *
	 * @return the create date of this employee trade
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this employee trade.
	 *
	 * @return the employee ID of this employee trade
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee trade ID of this employee trade.
	 *
	 * @return the employee trade ID of this employee trade
	 */
	@Override
	public long getEmployeeTradeId() {
		return model.getEmployeeTradeId();
	}

	/**
	 * Returns the from date of this employee trade.
	 *
	 * @return the from date of this employee trade
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this employee trade.
	 *
	 * @return the group ID of this employee trade
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee trade.
	 *
	 * @return the modified date of this employee trade
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee trade.
	 *
	 * @return the primary key of this employee trade
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the to date of this employee trade.
	 *
	 * @return the to date of this employee trade
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the trade ID of this employee trade.
	 *
	 * @return the trade ID of this employee trade
	 */
	@Override
	public long getTradeId() {
		return model.getTradeId();
	}

	/**
	 * Returns the user ID of this employee trade.
	 *
	 * @return the user ID of this employee trade
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee trade.
	 *
	 * @return the user name of this employee trade
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee trade.
	 *
	 * @return the user uuid of this employee trade
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee trade is active.
	 *
	 * @return <code>true</code> if this employee trade is active; <code>false</code> otherwise
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
	 * Sets whether this employee trade is active.
	 *
	 * @param active the active of this employee trade
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee trade.
	 *
	 * @param companyId the company ID of this employee trade
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee trade.
	 *
	 * @param createDate the create date of this employee trade
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this employee trade.
	 *
	 * @param employeeId the employee ID of this employee trade
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee trade ID of this employee trade.
	 *
	 * @param employeeTradeId the employee trade ID of this employee trade
	 */
	@Override
	public void setEmployeeTradeId(long employeeTradeId) {
		model.setEmployeeTradeId(employeeTradeId);
	}

	/**
	 * Sets the from date of this employee trade.
	 *
	 * @param fromDate the from date of this employee trade
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this employee trade.
	 *
	 * @param groupId the group ID of this employee trade
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee trade.
	 *
	 * @param modifiedDate the modified date of this employee trade
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee trade.
	 *
	 * @param primaryKey the primary key of this employee trade
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the to date of this employee trade.
	 *
	 * @param toDate the to date of this employee trade
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the trade ID of this employee trade.
	 *
	 * @param tradeId the trade ID of this employee trade
	 */
	@Override
	public void setTradeId(long tradeId) {
		model.setTradeId(tradeId);
	}

	/**
	 * Sets the user ID of this employee trade.
	 *
	 * @param userId the user ID of this employee trade
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee trade.
	 *
	 * @param userName the user name of this employee trade
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee trade.
	 *
	 * @param userUuid the user uuid of this employee trade
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeTradeWrapper wrap(EmployeeTrade employeeTrade) {
		return new EmployeeTradeWrapper(employeeTrade);
	}

}