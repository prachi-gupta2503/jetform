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

package com.adjecti.pis.liferay.model.impl;

import com.adjecti.pis.liferay.model.EmployeeExperience;
import com.adjecti.pis.liferay.model.EmployeeExperienceModel;
import com.adjecti.pis.liferay.model.EmployeeExperienceSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the EmployeeExperience service. Represents a row in the &quot;pis_EmployeeExperience&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeExperienceModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeExperienceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperienceImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeExperienceModelImpl
	extends BaseModelImpl<EmployeeExperience>
	implements EmployeeExperienceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee experience model instance should use the <code>EmployeeExperience</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_EmployeeExperience";

	public static final Object[][] TABLE_COLUMNS = {
		{"employeeExperienceId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"active_", Types.BOOLEAN},
		{"fromDate", Types.TIMESTAMP}, {"toDate", Types.TIMESTAMP},
		{"designationId", Types.BIGINT}, {"employeeId", Types.BIGINT},
		{"postId", Types.BIGINT}, {"tradeId", Types.BIGINT},
		{"experienceId", Types.BIGINT}, {"organizationId", Types.BIGINT},
		{"workAreaId", Types.BIGINT}, {"workAreaMinorId", Types.BIGINT},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeeExperienceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("fromDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("toDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("designationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("postId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("tradeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("experienceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("organizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workAreaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workAreaMinorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_EmployeeExperience (employeeExperienceId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,active_ BOOLEAN,fromDate DATE null,toDate DATE null,designationId LONG,employeeId LONG,postId LONG,tradeId LONG,experienceId LONG,organizationId LONG,workAreaId LONG,workAreaMinorId LONG,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table pis_EmployeeExperience";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeeExperience.employeeExperienceId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_EmployeeExperience.employeeExperienceId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ORGANIZATIONID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long WORKAREAID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long WORKAREAMINORID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEEXPERIENCEID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static EmployeeExperience toModel(EmployeeExperienceSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EmployeeExperience model = new EmployeeExperienceImpl();

		model.setEmployeeExperienceId(soapModel.getEmployeeExperienceId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActive(soapModel.isActive());
		model.setFromDate(soapModel.getFromDate());
		model.setToDate(soapModel.getToDate());
		model.setDesignationId(soapModel.getDesignationId());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setPostId(soapModel.getPostId());
		model.setTradeId(soapModel.getTradeId());
		model.setExperienceId(soapModel.getExperienceId());
		model.setOrganizationId(soapModel.getOrganizationId());
		model.setWorkAreaId(soapModel.getWorkAreaId());
		model.setWorkAreaMinorId(soapModel.getWorkAreaMinorId());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<EmployeeExperience> toModels(
		EmployeeExperienceSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<EmployeeExperience> models = new ArrayList<EmployeeExperience>(
			soapModels.length);

		for (EmployeeExperienceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeeExperienceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeExperienceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeExperienceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeExperienceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeExperience.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeExperience.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeeExperience, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeeExperience, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeExperience, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeeExperience)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeeExperience, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeeExperience, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeeExperience)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeeExperience, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeeExperience, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmployeeExperience>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmployeeExperience.class.getClassLoader(), EmployeeExperience.class,
			ModelWrapper.class);

		try {
			Constructor<EmployeeExperience> constructor =
				(Constructor<EmployeeExperience>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<EmployeeExperience, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmployeeExperience, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmployeeExperience, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<EmployeeExperience, Object>>();
		Map<String, BiConsumer<EmployeeExperience, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<EmployeeExperience, ?>>();

		attributeGetterFunctions.put(
			"employeeExperienceId",
			EmployeeExperience::getEmployeeExperienceId);
		attributeSetterBiConsumers.put(
			"employeeExperienceId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setEmployeeExperienceId);
		attributeGetterFunctions.put("groupId", EmployeeExperience::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setGroupId);
		attributeGetterFunctions.put(
			"companyId", EmployeeExperience::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setCompanyId);
		attributeGetterFunctions.put("userId", EmployeeExperience::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setUserId);
		attributeGetterFunctions.put(
			"userName", EmployeeExperience::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmployeeExperience, String>)
				EmployeeExperience::setUserName);
		attributeGetterFunctions.put(
			"createDate", EmployeeExperience::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmployeeExperience, Date>)
				EmployeeExperience::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmployeeExperience::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmployeeExperience, Date>)
				EmployeeExperience::setModifiedDate);
		attributeGetterFunctions.put("active", EmployeeExperience::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<EmployeeExperience, Boolean>)
				EmployeeExperience::setActive);
		attributeGetterFunctions.put(
			"fromDate", EmployeeExperience::getFromDate);
		attributeSetterBiConsumers.put(
			"fromDate",
			(BiConsumer<EmployeeExperience, Date>)
				EmployeeExperience::setFromDate);
		attributeGetterFunctions.put("toDate", EmployeeExperience::getToDate);
		attributeSetterBiConsumers.put(
			"toDate",
			(BiConsumer<EmployeeExperience, Date>)
				EmployeeExperience::setToDate);
		attributeGetterFunctions.put(
			"designationId", EmployeeExperience::getDesignationId);
		attributeSetterBiConsumers.put(
			"designationId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setDesignationId);
		attributeGetterFunctions.put(
			"employeeId", EmployeeExperience::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setEmployeeId);
		attributeGetterFunctions.put("postId", EmployeeExperience::getPostId);
		attributeSetterBiConsumers.put(
			"postId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setPostId);
		attributeGetterFunctions.put("tradeId", EmployeeExperience::getTradeId);
		attributeSetterBiConsumers.put(
			"tradeId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setTradeId);
		attributeGetterFunctions.put(
			"experienceId", EmployeeExperience::getExperienceId);
		attributeSetterBiConsumers.put(
			"experienceId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setExperienceId);
		attributeGetterFunctions.put(
			"organizationId", EmployeeExperience::getOrganizationId);
		attributeSetterBiConsumers.put(
			"organizationId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setOrganizationId);
		attributeGetterFunctions.put(
			"workAreaId", EmployeeExperience::getWorkAreaId);
		attributeSetterBiConsumers.put(
			"workAreaId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setWorkAreaId);
		attributeGetterFunctions.put(
			"workAreaMinorId", EmployeeExperience::getWorkAreaMinorId);
		attributeSetterBiConsumers.put(
			"workAreaMinorId",
			(BiConsumer<EmployeeExperience, Long>)
				EmployeeExperience::setWorkAreaMinorId);
		attributeGetterFunctions.put("status", EmployeeExperience::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<EmployeeExperience, Integer>)
				EmployeeExperience::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getEmployeeExperienceId() {
		return _employeeExperienceId;
	}

	@Override
	public void setEmployeeExperienceId(long employeeExperienceId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeExperienceId = employeeExperienceId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_active = active;
	}

	@JSON
	@Override
	public Date getFromDate() {
		return _fromDate;
	}

	@Override
	public void setFromDate(Date fromDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fromDate = fromDate;
	}

	@JSON
	@Override
	public Date getToDate() {
		return _toDate;
	}

	@Override
	public void setToDate(Date toDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_toDate = toDate;
	}

	@JSON
	@Override
	public long getDesignationId() {
		return _designationId;
	}

	@Override
	public void setDesignationId(long designationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_designationId = designationId;
	}

	@JSON
	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeId = employeeId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEmployeeId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("employeeId"));
	}

	@JSON
	@Override
	public long getPostId() {
		return _postId;
	}

	@Override
	public void setPostId(long postId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_postId = postId;
	}

	@JSON
	@Override
	public long getTradeId() {
		return _tradeId;
	}

	@Override
	public void setTradeId(long tradeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tradeId = tradeId;
	}

	@JSON
	@Override
	public long getExperienceId() {
		return _experienceId;
	}

	@Override
	public void setExperienceId(long experienceId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_experienceId = experienceId;
	}

	@JSON
	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_organizationId = organizationId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalOrganizationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("organizationId"));
	}

	@JSON
	@Override
	public long getWorkAreaId() {
		return _workAreaId;
	}

	@Override
	public void setWorkAreaId(long workAreaId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_workAreaId = workAreaId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalWorkAreaId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("workAreaId"));
	}

	@JSON
	@Override
	public long getWorkAreaMinorId() {
		return _workAreaMinorId;
	}

	@Override
	public void setWorkAreaMinorId(long workAreaMinorId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_workAreaMinorId = workAreaMinorId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalWorkAreaMinorId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("workAreaMinorId"));
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), EmployeeExperience.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeExperience toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeeExperience>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmployeeExperienceImpl employeeExperienceImpl =
			new EmployeeExperienceImpl();

		employeeExperienceImpl.setEmployeeExperienceId(
			getEmployeeExperienceId());
		employeeExperienceImpl.setGroupId(getGroupId());
		employeeExperienceImpl.setCompanyId(getCompanyId());
		employeeExperienceImpl.setUserId(getUserId());
		employeeExperienceImpl.setUserName(getUserName());
		employeeExperienceImpl.setCreateDate(getCreateDate());
		employeeExperienceImpl.setModifiedDate(getModifiedDate());
		employeeExperienceImpl.setActive(isActive());
		employeeExperienceImpl.setFromDate(getFromDate());
		employeeExperienceImpl.setToDate(getToDate());
		employeeExperienceImpl.setDesignationId(getDesignationId());
		employeeExperienceImpl.setEmployeeId(getEmployeeId());
		employeeExperienceImpl.setPostId(getPostId());
		employeeExperienceImpl.setTradeId(getTradeId());
		employeeExperienceImpl.setExperienceId(getExperienceId());
		employeeExperienceImpl.setOrganizationId(getOrganizationId());
		employeeExperienceImpl.setWorkAreaId(getWorkAreaId());
		employeeExperienceImpl.setWorkAreaMinorId(getWorkAreaMinorId());
		employeeExperienceImpl.setStatus(getStatus());

		employeeExperienceImpl.resetOriginalValues();

		return employeeExperienceImpl;
	}

	@Override
	public int compareTo(EmployeeExperience employeeExperience) {
		long primaryKey = employeeExperience.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeExperience)) {
			return false;
		}

		EmployeeExperience employeeExperience = (EmployeeExperience)object;

		long primaryKey = employeeExperience.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<EmployeeExperience> toCacheModel() {
		EmployeeExperienceCacheModel employeeExperienceCacheModel =
			new EmployeeExperienceCacheModel();

		employeeExperienceCacheModel.employeeExperienceId =
			getEmployeeExperienceId();

		employeeExperienceCacheModel.groupId = getGroupId();

		employeeExperienceCacheModel.companyId = getCompanyId();

		employeeExperienceCacheModel.userId = getUserId();

		employeeExperienceCacheModel.userName = getUserName();

		String userName = employeeExperienceCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeeExperienceCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeExperienceCacheModel.createDate = createDate.getTime();
		}
		else {
			employeeExperienceCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeExperienceCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			employeeExperienceCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeeExperienceCacheModel.active = isActive();

		Date fromDate = getFromDate();

		if (fromDate != null) {
			employeeExperienceCacheModel.fromDate = fromDate.getTime();
		}
		else {
			employeeExperienceCacheModel.fromDate = Long.MIN_VALUE;
		}

		Date toDate = getToDate();

		if (toDate != null) {
			employeeExperienceCacheModel.toDate = toDate.getTime();
		}
		else {
			employeeExperienceCacheModel.toDate = Long.MIN_VALUE;
		}

		employeeExperienceCacheModel.designationId = getDesignationId();

		employeeExperienceCacheModel.employeeId = getEmployeeId();

		employeeExperienceCacheModel.postId = getPostId();

		employeeExperienceCacheModel.tradeId = getTradeId();

		employeeExperienceCacheModel.experienceId = getExperienceId();

		employeeExperienceCacheModel.organizationId = getOrganizationId();

		employeeExperienceCacheModel.workAreaId = getWorkAreaId();

		employeeExperienceCacheModel.workAreaMinorId = getWorkAreaMinorId();

		employeeExperienceCacheModel.status = getStatus();

		return employeeExperienceCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeeExperience, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeeExperience, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeExperience, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EmployeeExperience)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<EmployeeExperience, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeeExperience, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeExperience, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmployeeExperience)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmployeeExperience>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _employeeExperienceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _active;
	private Date _fromDate;
	private Date _toDate;
	private long _designationId;
	private long _employeeId;
	private long _postId;
	private long _tradeId;
	private long _experienceId;
	private long _organizationId;
	private long _workAreaId;
	private long _workAreaMinorId;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<EmployeeExperience, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeeExperience)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put(
			"employeeExperienceId", _employeeExperienceId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("fromDate", _fromDate);
		_columnOriginalValues.put("toDate", _toDate);
		_columnOriginalValues.put("designationId", _designationId);
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("postId", _postId);
		_columnOriginalValues.put("tradeId", _tradeId);
		_columnOriginalValues.put("experienceId", _experienceId);
		_columnOriginalValues.put("organizationId", _organizationId);
		_columnOriginalValues.put("workAreaId", _workAreaId);
		_columnOriginalValues.put("workAreaMinorId", _workAreaMinorId);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("active_", "active");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("employeeExperienceId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("active_", 128L);

		columnBitmasks.put("fromDate", 256L);

		columnBitmasks.put("toDate", 512L);

		columnBitmasks.put("designationId", 1024L);

		columnBitmasks.put("employeeId", 2048L);

		columnBitmasks.put("postId", 4096L);

		columnBitmasks.put("tradeId", 8192L);

		columnBitmasks.put("experienceId", 16384L);

		columnBitmasks.put("organizationId", 32768L);

		columnBitmasks.put("workAreaId", 65536L);

		columnBitmasks.put("workAreaMinorId", 131072L);

		columnBitmasks.put("status", 262144L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeeExperience _escapedModel;

}