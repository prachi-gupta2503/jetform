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
 * The base model interface for the EmployeeJoining service. Represents a row in the &quot;pis_EmployeeJoining&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.EmployeeJoiningModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.EmployeeJoiningImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeJoining
 * @generated
 */
@ProviderType
public interface EmployeeJoiningModel
	extends BaseModel<EmployeeJoining>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee joining model instance should use the {@link EmployeeJoining} interface instead.
	 */

	/**
	 * Returns the primary key of this employee joining.
	 *
	 * @return the primary key of this employee joining
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee joining.
	 *
	 * @param primaryKey the primary key of this employee joining
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee joining ID of this employee joining.
	 *
	 * @return the employee joining ID of this employee joining
	 */
	public long getEmployeeJoiningId();

	/**
	 * Sets the employee joining ID of this employee joining.
	 *
	 * @param employeeJoiningId the employee joining ID of this employee joining
	 */
	public void setEmployeeJoiningId(long employeeJoiningId);

	/**
	 * Returns the group ID of this employee joining.
	 *
	 * @return the group ID of this employee joining
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee joining.
	 *
	 * @param groupId the group ID of this employee joining
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee joining.
	 *
	 * @return the company ID of this employee joining
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee joining.
	 *
	 * @param companyId the company ID of this employee joining
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee joining.
	 *
	 * @return the user ID of this employee joining
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee joining.
	 *
	 * @param userId the user ID of this employee joining
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee joining.
	 *
	 * @return the user uuid of this employee joining
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee joining.
	 *
	 * @param userUuid the user uuid of this employee joining
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee joining.
	 *
	 * @return the user name of this employee joining
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee joining.
	 *
	 * @param userName the user name of this employee joining
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee joining.
	 *
	 * @return the create date of this employee joining
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee joining.
	 *
	 * @param createDate the create date of this employee joining
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee joining.
	 *
	 * @return the modified date of this employee joining
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee joining.
	 *
	 * @param modifiedDate the modified date of this employee joining
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the aadhaar no of this employee joining.
	 *
	 * @return the aadhaar no of this employee joining
	 */
	@AutoEscape
	public String getAadhaarNo();

	/**
	 * Sets the aadhaar no of this employee joining.
	 *
	 * @param aadhaarNo the aadhaar no of this employee joining
	 */
	public void setAadhaarNo(String aadhaarNo);

	/**
	 * Returns the email address of this employee joining.
	 *
	 * @return the email address of this employee joining
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this employee joining.
	 *
	 * @param emailAddress the email address of this employee joining
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the ex service man of this employee joining.
	 *
	 * @return the ex service man of this employee joining
	 */
	public boolean getExServiceMan();

	/**
	 * Returns <code>true</code> if this employee joining is ex service man.
	 *
	 * @return <code>true</code> if this employee joining is ex service man; <code>false</code> otherwise
	 */
	public boolean isExServiceMan();

	/**
	 * Sets whether this employee joining is ex service man.
	 *
	 * @param exServiceMan the ex service man of this employee joining
	 */
	public void setExServiceMan(boolean exServiceMan);

	/**
	 * Returns the pan no of this employee joining.
	 *
	 * @return the pan no of this employee joining
	 */
	@AutoEscape
	public String getPanNo();

	/**
	 * Sets the pan no of this employee joining.
	 *
	 * @param panNo the pan no of this employee joining
	 */
	public void setPanNo(String panNo);

	/**
	 * Returns the personal no of this employee joining.
	 *
	 * @return the personal no of this employee joining
	 */
	@AutoEscape
	public String getPersonalNo();

	/**
	 * Sets the personal no of this employee joining.
	 *
	 * @param personalNo the personal no of this employee joining
	 */
	public void setPersonalNo(String personalNo);

	/**
	 * Returns the people ID of this employee joining.
	 *
	 * @return the people ID of this employee joining
	 */
	public long getPeopleId();

	/**
	 * Sets the people ID of this employee joining.
	 *
	 * @param peopleId the people ID of this employee joining
	 */
	public void setPeopleId(long peopleId);

	/**
	 * Returns the full name of this employee joining.
	 *
	 * @return the full name of this employee joining
	 */
	@AutoEscape
	public String getFullName();

	/**
	 * Sets the full name of this employee joining.
	 *
	 * @param fullName the full name of this employee joining
	 */
	public void setFullName(String fullName);

	/**
	 * Returns the designation ID of this employee joining.
	 *
	 * @return the designation ID of this employee joining
	 */
	public long getDesignationId();

	/**
	 * Sets the designation ID of this employee joining.
	 *
	 * @param designationId the designation ID of this employee joining
	 */
	public void setDesignationId(long designationId);

	/**
	 * Returns the grade ID of this employee joining.
	 *
	 * @return the grade ID of this employee joining
	 */
	public long getGradeId();

	/**
	 * Sets the grade ID of this employee joining.
	 *
	 * @param gradeId the grade ID of this employee joining
	 */
	public void setGradeId(long gradeId);

	/**
	 * Returns the pay level ID of this employee joining.
	 *
	 * @return the pay level ID of this employee joining
	 */
	public long getPayLevelId();

	/**
	 * Sets the pay level ID of this employee joining.
	 *
	 * @param payLevelId the pay level ID of this employee joining
	 */
	public void setPayLevelId(long payLevelId);

	/**
	 * Returns the post ID of this employee joining.
	 *
	 * @return the post ID of this employee joining
	 */
	public long getPostId();

	/**
	 * Sets the post ID of this employee joining.
	 *
	 * @param postId the post ID of this employee joining
	 */
	public void setPostId(long postId);

	/**
	 * Returns the trade ID of this employee joining.
	 *
	 * @return the trade ID of this employee joining
	 */
	public long getTradeId();

	/**
	 * Sets the trade ID of this employee joining.
	 *
	 * @param tradeId the trade ID of this employee joining
	 */
	public void setTradeId(long tradeId);

	/**
	 * Returns the organization ID of this employee joining.
	 *
	 * @return the organization ID of this employee joining
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this employee joining.
	 *
	 * @param organizationId the organization ID of this employee joining
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the sub organization ID of this employee joining.
	 *
	 * @return the sub organization ID of this employee joining
	 */
	public long getSubOrganizationId();

	/**
	 * Sets the sub organization ID of this employee joining.
	 *
	 * @param subOrganizationId the sub organization ID of this employee joining
	 */
	public void setSubOrganizationId(long subOrganizationId);

	/**
	 * Returns the designation class ID of this employee joining.
	 *
	 * @return the designation class ID of this employee joining
	 */
	public long getDesignationClassId();

	/**
	 * Sets the designation class ID of this employee joining.
	 *
	 * @param designationClassId the designation class ID of this employee joining
	 */
	public void setDesignationClassId(long designationClassId);

	/**
	 * Returns the designation group ID of this employee joining.
	 *
	 * @return the designation group ID of this employee joining
	 */
	public long getDesignationGroupId();

	/**
	 * Sets the designation group ID of this employee joining.
	 *
	 * @param designationGroupId the designation group ID of this employee joining
	 */
	public void setDesignationGroupId(long designationGroupId);

	/**
	 * Returns the joining mode ID of this employee joining.
	 *
	 * @return the joining mode ID of this employee joining
	 */
	public long getJoiningModeId();

	/**
	 * Sets the joining mode ID of this employee joining.
	 *
	 * @param joiningModeId the joining mode ID of this employee joining
	 */
	public void setJoiningModeId(long joiningModeId);

	/**
	 * Returns the joining letter ID of this employee joining.
	 *
	 * @return the joining letter ID of this employee joining
	 */
	public long getJoiningLetterId();

	/**
	 * Sets the joining letter ID of this employee joining.
	 *
	 * @param joiningLetterId the joining letter ID of this employee joining
	 */
	public void setJoiningLetterId(long joiningLetterId);

	/**
	 * Returns the grade mode ID of this employee joining.
	 *
	 * @return the grade mode ID of this employee joining
	 */
	public long getGradeModeId();

	/**
	 * Sets the grade mode ID of this employee joining.
	 *
	 * @param gradeModeId the grade mode ID of this employee joining
	 */
	public void setGradeModeId(long gradeModeId);

	/**
	 * Returns the from date of this employee joining.
	 *
	 * @return the from date of this employee joining
	 */
	public Date getFromDate();

	/**
	 * Sets the from date of this employee joining.
	 *
	 * @param fromDate the from date of this employee joining
	 */
	public void setFromDate(Date fromDate);

	/**
	 * Returns the to date of this employee joining.
	 *
	 * @return the to date of this employee joining
	 */
	public Date getToDate();

	/**
	 * Sets the to date of this employee joining.
	 *
	 * @param toDate the to date of this employee joining
	 */
	public void setToDate(Date toDate);

	/**
	 * Returns the selection date of this employee joining.
	 *
	 * @return the selection date of this employee joining
	 */
	public Date getSelectionDate();

	/**
	 * Sets the selection date of this employee joining.
	 *
	 * @param selectionDate the selection date of this employee joining
	 */
	public void setSelectionDate(Date selectionDate);

	/**
	 * Returns the confirmation date of this employee joining.
	 *
	 * @return the confirmation date of this employee joining
	 */
	public Date getConfirmationDate();

	/**
	 * Sets the confirmation date of this employee joining.
	 *
	 * @param confirmationDate the confirmation date of this employee joining
	 */
	public void setConfirmationDate(Date confirmationDate);

	/**
	 * Returns the grade confirmation date of this employee joining.
	 *
	 * @return the grade confirmation date of this employee joining
	 */
	public Date getGradeConfirmationDate();

	/**
	 * Sets the grade confirmation date of this employee joining.
	 *
	 * @param gradeConfirmationDate the grade confirmation date of this employee joining
	 */
	public void setGradeConfirmationDate(Date gradeConfirmationDate);

	/**
	 * Returns the govt service date of this employee joining.
	 *
	 * @return the govt service date of this employee joining
	 */
	public Date getGovtServiceDate();

	/**
	 * Sets the govt service date of this employee joining.
	 *
	 * @param govtServiceDate the govt service date of this employee joining
	 */
	public void setGovtServiceDate(Date govtServiceDate);

	/**
	 * Returns the recruitment batch of this employee joining.
	 *
	 * @return the recruitment batch of this employee joining
	 */
	@AutoEscape
	public String getRecruitmentBatch();

	/**
	 * Sets the recruitment batch of this employee joining.
	 *
	 * @param recruitmentBatch the recruitment batch of this employee joining
	 */
	public void setRecruitmentBatch(String recruitmentBatch);

	/**
	 * Returns the employee ID of this employee joining.
	 *
	 * @return the employee ID of this employee joining
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee joining.
	 *
	 * @param employeeId the employee ID of this employee joining
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the email ID of this employee joining.
	 *
	 * @return the email ID of this employee joining
	 */
	@AutoEscape
	public String getEmailId();

	/**
	 * Sets the email ID of this employee joining.
	 *
	 * @param emailId the email ID of this employee joining
	 */
	public void setEmailId(String emailId);

	/**
	 * Returns the post box of this employee joining.
	 *
	 * @return the post box of this employee joining
	 */
	@AutoEscape
	public String getPostBox();

	/**
	 * Sets the post box of this employee joining.
	 *
	 * @param postBox the post box of this employee joining
	 */
	public void setPostBox(String postBox);

	/**
	 * Returns the date of joining of this employee joining.
	 *
	 * @return the date of joining of this employee joining
	 */
	public Date getDateOfJoining();

	/**
	 * Sets the date of joining of this employee joining.
	 *
	 * @param dateOfJoining the date of joining of this employee joining
	 */
	public void setDateOfJoining(Date dateOfJoining);

	/**
	 * Returns the date of joining organization of this employee joining.
	 *
	 * @return the date of joining organization of this employee joining
	 */
	public Date getDateOfJoiningOrganization();

	/**
	 * Sets the date of joining organization of this employee joining.
	 *
	 * @param dateOfJoiningOrganization the date of joining organization of this employee joining
	 */
	public void setDateOfJoiningOrganization(Date dateOfJoiningOrganization);

	/**
	 * Returns the rank of this employee joining.
	 *
	 * @return the rank of this employee joining
	 */
	public long getRank();

	/**
	 * Sets the rank of this employee joining.
	 *
	 * @param rank the rank of this employee joining
	 */
	public void setRank(long rank);

	/**
	 * Returns the joining process ID of this employee joining.
	 *
	 * @return the joining process ID of this employee joining
	 */
	public long getJoiningProcessId();

	/**
	 * Sets the joining process ID of this employee joining.
	 *
	 * @param joiningProcessId the joining process ID of this employee joining
	 */
	public void setJoiningProcessId(long joiningProcessId);

	/**
	 * Returns the status of this employee joining.
	 *
	 * @return the status of this employee joining
	 */
	public int getStatus();

	/**
	 * Sets the status of this employee joining.
	 *
	 * @param status the status of this employee joining
	 */
	public void setStatus(int status);

}