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
 * The base model interface for the FamilyEducationDetail service. Represents a row in the &quot;pis_FamilyEducationDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.FamilyEducationDetailModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.FamilyEducationDetailImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyEducationDetail
 * @generated
 */
@ProviderType
public interface FamilyEducationDetailModel
	extends BaseModel<FamilyEducationDetail>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a family education detail model instance should use the {@link FamilyEducationDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this family education detail.
	 *
	 * @return the primary key of this family education detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this family education detail.
	 *
	 * @param primaryKey the primary key of this family education detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the family education detail ID of this family education detail.
	 *
	 * @return the family education detail ID of this family education detail
	 */
	public long getFamilyEducationDetailId();

	/**
	 * Sets the family education detail ID of this family education detail.
	 *
	 * @param familyEducationDetailId the family education detail ID of this family education detail
	 */
	public void setFamilyEducationDetailId(long familyEducationDetailId);

	/**
	 * Returns the group ID of this family education detail.
	 *
	 * @return the group ID of this family education detail
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this family education detail.
	 *
	 * @param groupId the group ID of this family education detail
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this family education detail.
	 *
	 * @return the company ID of this family education detail
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this family education detail.
	 *
	 * @param companyId the company ID of this family education detail
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this family education detail.
	 *
	 * @return the user ID of this family education detail
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this family education detail.
	 *
	 * @param userId the user ID of this family education detail
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this family education detail.
	 *
	 * @return the user uuid of this family education detail
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this family education detail.
	 *
	 * @param userUuid the user uuid of this family education detail
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this family education detail.
	 *
	 * @return the user name of this family education detail
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this family education detail.
	 *
	 * @param userName the user name of this family education detail
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this family education detail.
	 *
	 * @return the create date of this family education detail
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this family education detail.
	 *
	 * @param createDate the create date of this family education detail
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this family education detail.
	 *
	 * @return the modified date of this family education detail
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this family education detail.
	 *
	 * @param modifiedDate the modified date of this family education detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the board university of this family education detail.
	 *
	 * @return the board university of this family education detail
	 */
	@AutoEscape
	public String getBoardUniversity();

	/**
	 * Sets the board university of this family education detail.
	 *
	 * @param boardUniversity the board university of this family education detail
	 */
	public void setBoardUniversity(String boardUniversity);

	/**
	 * Returns the city of study of this family education detail.
	 *
	 * @return the city of study of this family education detail
	 */
	@AutoEscape
	public String getCityOfStudy();

	/**
	 * Sets the city of study of this family education detail.
	 *
	 * @param cityOfStudy the city of study of this family education detail
	 */
	public void setCityOfStudy(String cityOfStudy);

	/**
	 * Returns the from year of this family education detail.
	 *
	 * @return the from year of this family education detail
	 */
	public int getFromYear();

	/**
	 * Sets the from year of this family education detail.
	 *
	 * @param fromYear the from year of this family education detail
	 */
	public void setFromYear(int fromYear);

	/**
	 * Returns the institution name of this family education detail.
	 *
	 * @return the institution name of this family education detail
	 */
	@AutoEscape
	public String getInstitutionName();

	/**
	 * Sets the institution name of this family education detail.
	 *
	 * @param institutionName the institution name of this family education detail
	 */
	public void setInstitutionName(String institutionName);

	/**
	 * Returns the to year of this family education detail.
	 *
	 * @return the to year of this family education detail
	 */
	public int getToYear();

	/**
	 * Sets the to year of this family education detail.
	 *
	 * @param toYear the to year of this family education detail
	 */
	public void setToYear(int toYear);

	/**
	 * Returns the family member ID of this family education detail.
	 *
	 * @return the family member ID of this family education detail
	 */
	public long getFamilyMemberId();

	/**
	 * Sets the family member ID of this family education detail.
	 *
	 * @param familyMemberId the family member ID of this family education detail
	 */
	public void setFamilyMemberId(long familyMemberId);

	/**
	 * Returns the level ID of this family education detail.
	 *
	 * @return the level ID of this family education detail
	 */
	public long getLevelId();

	/**
	 * Sets the level ID of this family education detail.
	 *
	 * @param levelId the level ID of this family education detail
	 */
	public void setLevelId(long levelId);

	/**
	 * Returns the state ID of this family education detail.
	 *
	 * @return the state ID of this family education detail
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this family education detail.
	 *
	 * @param stateId the state ID of this family education detail
	 */
	public void setStateId(long stateId);

}