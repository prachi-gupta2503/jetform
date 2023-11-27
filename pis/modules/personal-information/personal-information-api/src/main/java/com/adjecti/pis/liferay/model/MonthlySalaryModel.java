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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the MonthlySalary service. Represents a row in the &quot;pis_MonthlySalary&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlySalary
 * @generated
 */
@ProviderType
public interface MonthlySalaryModel
	extends BaseModel<MonthlySalary>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a monthly salary model instance should use the {@link MonthlySalary} interface instead.
	 */

	/**
	 * Returns the primary key of this monthly salary.
	 *
	 * @return the primary key of this monthly salary
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this monthly salary.
	 *
	 * @param primaryKey the primary key of this monthly salary
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the monthly salary ID of this monthly salary.
	 *
	 * @return the monthly salary ID of this monthly salary
	 */
	public long getMonthlySalaryId();

	/**
	 * Sets the monthly salary ID of this monthly salary.
	 *
	 * @param monthlySalaryId the monthly salary ID of this monthly salary
	 */
	public void setMonthlySalaryId(long monthlySalaryId);

	/**
	 * Returns the group ID of this monthly salary.
	 *
	 * @return the group ID of this monthly salary
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this monthly salary.
	 *
	 * @param groupId the group ID of this monthly salary
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this monthly salary.
	 *
	 * @return the company ID of this monthly salary
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this monthly salary.
	 *
	 * @param companyId the company ID of this monthly salary
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this monthly salary.
	 *
	 * @return the user ID of this monthly salary
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this monthly salary.
	 *
	 * @param userId the user ID of this monthly salary
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this monthly salary.
	 *
	 * @return the user uuid of this monthly salary
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this monthly salary.
	 *
	 * @param userUuid the user uuid of this monthly salary
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this monthly salary.
	 *
	 * @return the user name of this monthly salary
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this monthly salary.
	 *
	 * @param userName the user name of this monthly salary
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this monthly salary.
	 *
	 * @return the create date of this monthly salary
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this monthly salary.
	 *
	 * @param createDate the create date of this monthly salary
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this monthly salary.
	 *
	 * @return the modified date of this monthly salary
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this monthly salary.
	 *
	 * @param modifiedDate the modified date of this monthly salary
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the gross deduction of this monthly salary.
	 *
	 * @return the gross deduction of this monthly salary
	 */
	public float getGrossDeduction();

	/**
	 * Sets the gross deduction of this monthly salary.
	 *
	 * @param grossDeduction the gross deduction of this monthly salary
	 */
	public void setGrossDeduction(float grossDeduction);

	/**
	 * Returns the gross income of this monthly salary.
	 *
	 * @return the gross income of this monthly salary
	 */
	public float getGrossIncome();

	/**
	 * Sets the gross income of this monthly salary.
	 *
	 * @param grossIncome the gross income of this monthly salary
	 */
	public void setGrossIncome(float grossIncome);

	/**
	 * Returns the net payble of this monthly salary.
	 *
	 * @return the net payble of this monthly salary
	 */
	public float getNetPayble();

	/**
	 * Sets the net payble of this monthly salary.
	 *
	 * @param netPayble the net payble of this monthly salary
	 */
	public void setNetPayble(float netPayble);

	/**
	 * Returns the process month of this monthly salary.
	 *
	 * @return the process month of this monthly salary
	 */
	public Date getProcessMonth();

	/**
	 * Sets the process month of this monthly salary.
	 *
	 * @param processMonth the process month of this monthly salary
	 */
	public void setProcessMonth(Date processMonth);

	/**
	 * Returns the employee ID of this monthly salary.
	 *
	 * @return the employee ID of this monthly salary
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this monthly salary.
	 *
	 * @param employeeId the employee ID of this monthly salary
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the structure ID of this monthly salary.
	 *
	 * @return the structure ID of this monthly salary
	 */
	public long getStructureId();

	/**
	 * Sets the structure ID of this monthly salary.
	 *
	 * @param structureId the structure ID of this monthly salary
	 */
	public void setStructureId(long structureId);

}