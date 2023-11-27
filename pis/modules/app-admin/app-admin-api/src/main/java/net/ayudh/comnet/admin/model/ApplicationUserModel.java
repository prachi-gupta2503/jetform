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

package net.ayudh.comnet.admin.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ApplicationUser service. Represents a row in the &quot;comnet_ApplicationUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>net.ayudh.comnet.admin.model.impl.ApplicationUserModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>net.ayudh.comnet.admin.model.impl.ApplicationUserImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationUser
 * @generated
 */
@ProviderType
public interface ApplicationUserModel
	extends BaseModel<ApplicationUser>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a application user model instance should use the {@link ApplicationUser} interface instead.
	 */

	/**
	 * Returns the primary key of this application user.
	 *
	 * @return the primary key of this application user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this application user.
	 *
	 * @param primaryKey the primary key of this application user
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the application user ID of this application user.
	 *
	 * @return the application user ID of this application user
	 */
	public long getApplicationUserId();

	/**
	 * Sets the application user ID of this application user.
	 *
	 * @param applicationUserId the application user ID of this application user
	 */
	public void setApplicationUserId(long applicationUserId);

	/**
	 * Returns the application user uuid of this application user.
	 *
	 * @return the application user uuid of this application user
	 */
	public String getApplicationUserUuid();

	/**
	 * Sets the application user uuid of this application user.
	 *
	 * @param applicationUserUuid the application user uuid of this application user
	 */
	public void setApplicationUserUuid(String applicationUserUuid);

	/**
	 * Returns the group ID of this application user.
	 *
	 * @return the group ID of this application user
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this application user.
	 *
	 * @param groupId the group ID of this application user
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this application user.
	 *
	 * @return the company ID of this application user
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this application user.
	 *
	 * @param companyId the company ID of this application user
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this application user.
	 *
	 * @return the user ID of this application user
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this application user.
	 *
	 * @param userId the user ID of this application user
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this application user.
	 *
	 * @return the user uuid of this application user
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this application user.
	 *
	 * @param userUuid the user uuid of this application user
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this application user.
	 *
	 * @return the user name of this application user
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this application user.
	 *
	 * @param userName the user name of this application user
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this application user.
	 *
	 * @return the create date of this application user
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this application user.
	 *
	 * @param createDate the create date of this application user
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this application user.
	 *
	 * @return the modified date of this application user
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this application user.
	 *
	 * @param modifiedDate the modified date of this application user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the employee ID of this application user.
	 *
	 * @return the employee ID of this application user
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this application user.
	 *
	 * @param employeeId the employee ID of this application user
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the login ID of this application user.
	 *
	 * @return the login ID of this application user
	 */
	@AutoEscape
	public String getLoginId();

	/**
	 * Sets the login ID of this application user.
	 *
	 * @param loginId the login ID of this application user
	 */
	public void setLoginId(String loginId);

	/**
	 * Returns the status of this application user.
	 *
	 * @return the status of this application user
	 */
	public int getStatus();

	/**
	 * Sets the status of this application user.
	 *
	 * @param status the status of this application user
	 */
	public void setStatus(int status);

	/**
	 * Returns the deleted of this application user.
	 *
	 * @return the deleted of this application user
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this application user is deleted.
	 *
	 * @return <code>true</code> if this application user is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this application user is deleted.
	 *
	 * @param deleted the deleted of this application user
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the idam user of this application user.
	 *
	 * @return the idam user of this application user
	 */
	public boolean getIdamUser();

	/**
	 * Returns <code>true</code> if this application user is idam user.
	 *
	 * @return <code>true</code> if this application user is idam user; <code>false</code> otherwise
	 */
	public boolean isIdamUser();

	/**
	 * Sets whether this application user is idam user.
	 *
	 * @param idamUser the idam user of this application user
	 */
	public void setIdamUser(boolean idamUser);

	/**
	 * Returns the email access of this application user.
	 *
	 * @return the email access of this application user
	 */
	public boolean getEmailAccess();

	/**
	 * Returns <code>true</code> if this application user is email access.
	 *
	 * @return <code>true</code> if this application user is email access; <code>false</code> otherwise
	 */
	public boolean isEmailAccess();

	/**
	 * Sets whether this application user is email access.
	 *
	 * @param emailAccess the email access of this application user
	 */
	public void setEmailAccess(boolean emailAccess);

	/**
	 * Returns the digital signing of this application user.
	 *
	 * @return the digital signing of this application user
	 */
	public boolean getDigitalSigning();

	/**
	 * Returns <code>true</code> if this application user is digital signing.
	 *
	 * @return <code>true</code> if this application user is digital signing; <code>false</code> otherwise
	 */
	public boolean isDigitalSigning();

	/**
	 * Sets whether this application user is digital signing.
	 *
	 * @param digitalSigning the digital signing of this application user
	 */
	public void setDigitalSigning(boolean digitalSigning);

	/**
	 * Returns the e gov access of this application user.
	 *
	 * @return the e gov access of this application user
	 */
	public boolean getEGovAccess();

	/**
	 * Returns <code>true</code> if this application user is e gov access.
	 *
	 * @return <code>true</code> if this application user is e gov access; <code>false</code> otherwise
	 */
	public boolean isEGovAccess();

	/**
	 * Sets whether this application user is e gov access.
	 *
	 * @param eGovAccess the e gov access of this application user
	 */
	public void setEGovAccess(boolean eGovAccess);

	/**
	 * Returns the pis access of this application user.
	 *
	 * @return the pis access of this application user
	 */
	public boolean getPisAccess();

	/**
	 * Returns <code>true</code> if this application user is pis access.
	 *
	 * @return <code>true</code> if this application user is pis access; <code>false</code> otherwise
	 */
	public boolean isPisAccess();

	/**
	 * Sets whether this application user is pis access.
	 *
	 * @param pisAccess the pis access of this application user
	 */
	public void setPisAccess(boolean pisAccess);

	/**
	 * Returns the last idam user of this application user.
	 *
	 * @return the last idam user of this application user
	 */
	public boolean getLastIdamUser();

	/**
	 * Returns <code>true</code> if this application user is last idam user.
	 *
	 * @return <code>true</code> if this application user is last idam user; <code>false</code> otherwise
	 */
	public boolean isLastIdamUser();

	/**
	 * Sets whether this application user is last idam user.
	 *
	 * @param lastIdamUser the last idam user of this application user
	 */
	public void setLastIdamUser(boolean lastIdamUser);

	/**
	 * Returns the last email access of this application user.
	 *
	 * @return the last email access of this application user
	 */
	public boolean getLastEmailAccess();

	/**
	 * Returns <code>true</code> if this application user is last email access.
	 *
	 * @return <code>true</code> if this application user is last email access; <code>false</code> otherwise
	 */
	public boolean isLastEmailAccess();

	/**
	 * Sets whether this application user is last email access.
	 *
	 * @param lastEmailAccess the last email access of this application user
	 */
	public void setLastEmailAccess(boolean lastEmailAccess);

	/**
	 * Returns the last digital signing of this application user.
	 *
	 * @return the last digital signing of this application user
	 */
	public boolean getLastDigitalSigning();

	/**
	 * Returns <code>true</code> if this application user is last digital signing.
	 *
	 * @return <code>true</code> if this application user is last digital signing; <code>false</code> otherwise
	 */
	public boolean isLastDigitalSigning();

	/**
	 * Sets whether this application user is last digital signing.
	 *
	 * @param lastDigitalSigning the last digital signing of this application user
	 */
	public void setLastDigitalSigning(boolean lastDigitalSigning);

	/**
	 * Returns the last e gov access of this application user.
	 *
	 * @return the last e gov access of this application user
	 */
	public boolean getLastEGovAccess();

	/**
	 * Returns <code>true</code> if this application user is last e gov access.
	 *
	 * @return <code>true</code> if this application user is last e gov access; <code>false</code> otherwise
	 */
	public boolean isLastEGovAccess();

	/**
	 * Sets whether this application user is last e gov access.
	 *
	 * @param lastEGovAccess the last e gov access of this application user
	 */
	public void setLastEGovAccess(boolean lastEGovAccess);

	/**
	 * Returns the last pis access of this application user.
	 *
	 * @return the last pis access of this application user
	 */
	public boolean getLastPisAccess();

	/**
	 * Returns <code>true</code> if this application user is last pis access.
	 *
	 * @return <code>true</code> if this application user is last pis access; <code>false</code> otherwise
	 */
	public boolean isLastPisAccess();

	/**
	 * Sets whether this application user is last pis access.
	 *
	 * @param lastPisAccess the last pis access of this application user
	 */
	public void setLastPisAccess(boolean lastPisAccess);

	/**
	 * Returns the idam service status of this application user.
	 *
	 * @return the idam service status of this application user
	 */
	public boolean getIdamServiceStatus();

	/**
	 * Returns <code>true</code> if this application user is idam service status.
	 *
	 * @return <code>true</code> if this application user is idam service status; <code>false</code> otherwise
	 */
	public boolean isIdamServiceStatus();

	/**
	 * Sets whether this application user is idam service status.
	 *
	 * @param idamServiceStatus the idam service status of this application user
	 */
	public void setIdamServiceStatus(boolean idamServiceStatus);

	/**
	 * Returns the idam service message of this application user.
	 *
	 * @return the idam service message of this application user
	 */
	@AutoEscape
	public String getIdamServiceMessage();

	/**
	 * Sets the idam service message of this application user.
	 *
	 * @param idamServiceMessage the idam service message of this application user
	 */
	public void setIdamServiceMessage(String idamServiceMessage);

	/**
	 * Returns the idam user created of this application user.
	 *
	 * @return the idam user created of this application user
	 */
	public boolean getIdamUserCreated();

	/**
	 * Returns <code>true</code> if this application user is idam user created.
	 *
	 * @return <code>true</code> if this application user is idam user created; <code>false</code> otherwise
	 */
	public boolean isIdamUserCreated();

	/**
	 * Sets whether this application user is idam user created.
	 *
	 * @param idamUserCreated the idam user created of this application user
	 */
	public void setIdamUserCreated(boolean idamUserCreated);

}