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
 * The base model interface for the FamilyMemberServiceDetail service. Represents a row in the &quot;pis_FamilyMemberServiceDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.FamilyMemberServiceDetailModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.FamilyMemberServiceDetailImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyMemberServiceDetail
 * @generated
 */
@ProviderType
public interface FamilyMemberServiceDetailModel
	extends BaseModel<FamilyMemberServiceDetail>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a family member service detail model instance should use the {@link FamilyMemberServiceDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this family member service detail.
	 *
	 * @return the primary key of this family member service detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this family member service detail.
	 *
	 * @param primaryKey the primary key of this family member service detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the family member service detail ID of this family member service detail.
	 *
	 * @return the family member service detail ID of this family member service detail
	 */
	public long getFamilyMemberServiceDetailId();

	/**
	 * Sets the family member service detail ID of this family member service detail.
	 *
	 * @param familyMemberServiceDetailId the family member service detail ID of this family member service detail
	 */
	public void setFamilyMemberServiceDetailId(
		long familyMemberServiceDetailId);

	/**
	 * Returns the group ID of this family member service detail.
	 *
	 * @return the group ID of this family member service detail
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this family member service detail.
	 *
	 * @param groupId the group ID of this family member service detail
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this family member service detail.
	 *
	 * @return the company ID of this family member service detail
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this family member service detail.
	 *
	 * @param companyId the company ID of this family member service detail
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this family member service detail.
	 *
	 * @return the user ID of this family member service detail
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this family member service detail.
	 *
	 * @param userId the user ID of this family member service detail
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this family member service detail.
	 *
	 * @return the user uuid of this family member service detail
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this family member service detail.
	 *
	 * @param userUuid the user uuid of this family member service detail
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this family member service detail.
	 *
	 * @return the user name of this family member service detail
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this family member service detail.
	 *
	 * @param userName the user name of this family member service detail
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this family member service detail.
	 *
	 * @return the create date of this family member service detail
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this family member service detail.
	 *
	 * @param createDate the create date of this family member service detail
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this family member service detail.
	 *
	 * @return the modified date of this family member service detail
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this family member service detail.
	 *
	 * @param modifiedDate the modified date of this family member service detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the board university of this family member service detail.
	 *
	 * @return the board university of this family member service detail
	 */
	@AutoEscape
	public String getBoardUniversity();

	/**
	 * Sets the board university of this family member service detail.
	 *
	 * @param boardUniversity the board university of this family member service detail
	 */
	public void setBoardUniversity(String boardUniversity);

	/**
	 * Returns the from year of this family member service detail.
	 *
	 * @return the from year of this family member service detail
	 */
	public int getFromYear();

	/**
	 * Sets the from year of this family member service detail.
	 *
	 * @param fromYear the from year of this family member service detail
	 */
	public void setFromYear(int fromYear);

	/**
	 * Returns the to year of this family member service detail.
	 *
	 * @return the to year of this family member service detail
	 */
	public int getToYear();

	/**
	 * Sets the to year of this family member service detail.
	 *
	 * @param toYear the to year of this family member service detail
	 */
	public void setToYear(int toYear);

	/**
	 * Returns the description of this family member service detail.
	 *
	 * @return the description of this family member service detail
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this family member service detail.
	 *
	 * @param description the description of this family member service detail
	 */
	public void setDescription(String description);

	/**
	 * Returns the end date of this family member service detail.
	 *
	 * @return the end date of this family member service detail
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this family member service detail.
	 *
	 * @param endDate the end date of this family member service detail
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the organization of this family member service detail.
	 *
	 * @return the organization of this family member service detail
	 */
	@AutoEscape
	public String getOrganization();

	/**
	 * Sets the organization of this family member service detail.
	 *
	 * @param organization the organization of this family member service detail
	 */
	public void setOrganization(String organization);

	/**
	 * Returns the start date of this family member service detail.
	 *
	 * @return the start date of this family member service detail
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this family member service detail.
	 *
	 * @param startDate the start date of this family member service detail
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the family member ID of this family member service detail.
	 *
	 * @return the family member ID of this family member service detail
	 */
	public long getFamilyMemberId();

	/**
	 * Sets the family member ID of this family member service detail.
	 *
	 * @param familyMemberId the family member ID of this family member service detail
	 */
	public void setFamilyMemberId(long familyMemberId);

	/**
	 * Returns the level ID of this family member service detail.
	 *
	 * @return the level ID of this family member service detail
	 */
	public long getLevelId();

	/**
	 * Sets the level ID of this family member service detail.
	 *
	 * @param levelId the level ID of this family member service detail
	 */
	public void setLevelId(long levelId);

	/**
	 * Returns the service type ID of this family member service detail.
	 *
	 * @return the service type ID of this family member service detail
	 */
	public long getServiceTypeId();

	/**
	 * Sets the service type ID of this family member service detail.
	 *
	 * @param serviceTypeId the service type ID of this family member service detail
	 */
	public void setServiceTypeId(long serviceTypeId);

}