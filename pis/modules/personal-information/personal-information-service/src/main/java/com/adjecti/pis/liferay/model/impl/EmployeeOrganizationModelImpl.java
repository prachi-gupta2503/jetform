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

import com.adjecti.pis.liferay.model.EmployeeOrganization;
import com.adjecti.pis.liferay.model.EmployeeOrganizationModel;
import com.adjecti.pis.liferay.model.EmployeeOrganizationSoap;

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
 * The base model implementation for the EmployeeOrganization service. Represents a row in the &quot;pis_EmployeeOrganization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeOrganizationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeOrganizationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganizationImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeOrganizationModelImpl
	extends BaseModelImpl<EmployeeOrganization>
	implements EmployeeOrganizationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee organization model instance should use the <code>EmployeeOrganization</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_EmployeeOrganization";

	public static final Object[][] TABLE_COLUMNS = {
		{"employeeOrganizationId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"employeeId", Types.BIGINT},
		{"personalNo", Types.VARCHAR}, {"organizationId", Types.BIGINT},
		{"organizationCode", Types.VARCHAR},
		{"subOrganizationId", Types.BIGINT},
		{"subOrganizationCode", Types.VARCHAR}, {"active_", Types.BOOLEAN},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeeOrganizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("personalNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("organizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("organizationCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subOrganizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("subOrganizationCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_EmployeeOrganization (employeeOrganizationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,employeeId LONG,personalNo VARCHAR(75) null,organizationId LONG,organizationCode VARCHAR(75) null,subOrganizationId LONG,subOrganizationCode VARCHAR(75) null,active_ BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table pis_EmployeeOrganization";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeeOrganization.employeeOrganizationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_EmployeeOrganization.employeeOrganizationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ACTIVE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ORGANIZATIONCODE_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ORGANIZATIONID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long PERSONALNO_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long SUBORGANIZATIONCODE_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long SUBORGANIZATIONID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEORGANIZATIONID_COLUMN_BITMASK = 128L;

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
	public static EmployeeOrganization toModel(
		EmployeeOrganizationSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		EmployeeOrganization model = new EmployeeOrganizationImpl();

		model.setEmployeeOrganizationId(soapModel.getEmployeeOrganizationId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setPersonalNo(soapModel.getPersonalNo());
		model.setOrganizationId(soapModel.getOrganizationId());
		model.setOrganizationCode(soapModel.getOrganizationCode());
		model.setSubOrganizationId(soapModel.getSubOrganizationId());
		model.setSubOrganizationCode(soapModel.getSubOrganizationCode());
		model.setActive(soapModel.isActive());
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
	public static List<EmployeeOrganization> toModels(
		EmployeeOrganizationSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<EmployeeOrganization> models = new ArrayList<EmployeeOrganization>(
			soapModels.length);

		for (EmployeeOrganizationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeeOrganizationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeOrganizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeOrganizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeOrganizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeOrganization.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeOrganization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeeOrganization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeeOrganization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeOrganization, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeeOrganization)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeeOrganization, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeeOrganization, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeeOrganization)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeeOrganization, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeeOrganization, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmployeeOrganization>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmployeeOrganization.class.getClassLoader(),
			EmployeeOrganization.class, ModelWrapper.class);

		try {
			Constructor<EmployeeOrganization> constructor =
				(Constructor<EmployeeOrganization>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EmployeeOrganization, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmployeeOrganization, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmployeeOrganization, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<EmployeeOrganization, Object>>();
		Map<String, BiConsumer<EmployeeOrganization, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<EmployeeOrganization, ?>>();

		attributeGetterFunctions.put(
			"employeeOrganizationId",
			EmployeeOrganization::getEmployeeOrganizationId);
		attributeSetterBiConsumers.put(
			"employeeOrganizationId",
			(BiConsumer<EmployeeOrganization, Long>)
				EmployeeOrganization::setEmployeeOrganizationId);
		attributeGetterFunctions.put(
			"groupId", EmployeeOrganization::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EmployeeOrganization, Long>)
				EmployeeOrganization::setGroupId);
		attributeGetterFunctions.put(
			"companyId", EmployeeOrganization::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmployeeOrganization, Long>)
				EmployeeOrganization::setCompanyId);
		attributeGetterFunctions.put("userId", EmployeeOrganization::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EmployeeOrganization, Long>)
				EmployeeOrganization::setUserId);
		attributeGetterFunctions.put(
			"userName", EmployeeOrganization::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmployeeOrganization, String>)
				EmployeeOrganization::setUserName);
		attributeGetterFunctions.put(
			"createDate", EmployeeOrganization::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmployeeOrganization, Date>)
				EmployeeOrganization::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmployeeOrganization::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmployeeOrganization, Date>)
				EmployeeOrganization::setModifiedDate);
		attributeGetterFunctions.put(
			"employeeId", EmployeeOrganization::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<EmployeeOrganization, Long>)
				EmployeeOrganization::setEmployeeId);
		attributeGetterFunctions.put(
			"personalNo", EmployeeOrganization::getPersonalNo);
		attributeSetterBiConsumers.put(
			"personalNo",
			(BiConsumer<EmployeeOrganization, String>)
				EmployeeOrganization::setPersonalNo);
		attributeGetterFunctions.put(
			"organizationId", EmployeeOrganization::getOrganizationId);
		attributeSetterBiConsumers.put(
			"organizationId",
			(BiConsumer<EmployeeOrganization, Long>)
				EmployeeOrganization::setOrganizationId);
		attributeGetterFunctions.put(
			"organizationCode", EmployeeOrganization::getOrganizationCode);
		attributeSetterBiConsumers.put(
			"organizationCode",
			(BiConsumer<EmployeeOrganization, String>)
				EmployeeOrganization::setOrganizationCode);
		attributeGetterFunctions.put(
			"subOrganizationId", EmployeeOrganization::getSubOrganizationId);
		attributeSetterBiConsumers.put(
			"subOrganizationId",
			(BiConsumer<EmployeeOrganization, Long>)
				EmployeeOrganization::setSubOrganizationId);
		attributeGetterFunctions.put(
			"subOrganizationCode",
			EmployeeOrganization::getSubOrganizationCode);
		attributeSetterBiConsumers.put(
			"subOrganizationCode",
			(BiConsumer<EmployeeOrganization, String>)
				EmployeeOrganization::setSubOrganizationCode);
		attributeGetterFunctions.put("active", EmployeeOrganization::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<EmployeeOrganization, Boolean>)
				EmployeeOrganization::setActive);
		attributeGetterFunctions.put("status", EmployeeOrganization::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<EmployeeOrganization, Integer>)
				EmployeeOrganization::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getEmployeeOrganizationId() {
		return _employeeOrganizationId;
	}

	@Override
	public void setEmployeeOrganizationId(long employeeOrganizationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeOrganizationId = employeeOrganizationId;
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
	public String getPersonalNo() {
		if (_personalNo == null) {
			return "";
		}
		else {
			return _personalNo;
		}
	}

	@Override
	public void setPersonalNo(String personalNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_personalNo = personalNo;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalPersonalNo() {
		return getColumnOriginalValue("personalNo");
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
	public String getOrganizationCode() {
		if (_organizationCode == null) {
			return "";
		}
		else {
			return _organizationCode;
		}
	}

	@Override
	public void setOrganizationCode(String organizationCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_organizationCode = organizationCode;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalOrganizationCode() {
		return getColumnOriginalValue("organizationCode");
	}

	@JSON
	@Override
	public long getSubOrganizationId() {
		return _subOrganizationId;
	}

	@Override
	public void setSubOrganizationId(long subOrganizationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subOrganizationId = subOrganizationId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalSubOrganizationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("subOrganizationId"));
	}

	@JSON
	@Override
	public String getSubOrganizationCode() {
		if (_subOrganizationCode == null) {
			return "";
		}
		else {
			return _subOrganizationCode;
		}
	}

	@Override
	public void setSubOrganizationCode(String subOrganizationCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subOrganizationCode = subOrganizationCode;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalSubOrganizationCode() {
		return getColumnOriginalValue("subOrganizationCode");
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalActive() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("active_"));
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
			getCompanyId(), EmployeeOrganization.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeOrganization toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeeOrganization>
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
		EmployeeOrganizationImpl employeeOrganizationImpl =
			new EmployeeOrganizationImpl();

		employeeOrganizationImpl.setEmployeeOrganizationId(
			getEmployeeOrganizationId());
		employeeOrganizationImpl.setGroupId(getGroupId());
		employeeOrganizationImpl.setCompanyId(getCompanyId());
		employeeOrganizationImpl.setUserId(getUserId());
		employeeOrganizationImpl.setUserName(getUserName());
		employeeOrganizationImpl.setCreateDate(getCreateDate());
		employeeOrganizationImpl.setModifiedDate(getModifiedDate());
		employeeOrganizationImpl.setEmployeeId(getEmployeeId());
		employeeOrganizationImpl.setPersonalNo(getPersonalNo());
		employeeOrganizationImpl.setOrganizationId(getOrganizationId());
		employeeOrganizationImpl.setOrganizationCode(getOrganizationCode());
		employeeOrganizationImpl.setSubOrganizationId(getSubOrganizationId());
		employeeOrganizationImpl.setSubOrganizationCode(
			getSubOrganizationCode());
		employeeOrganizationImpl.setActive(isActive());
		employeeOrganizationImpl.setStatus(getStatus());

		employeeOrganizationImpl.resetOriginalValues();

		return employeeOrganizationImpl;
	}

	@Override
	public int compareTo(EmployeeOrganization employeeOrganization) {
		long primaryKey = employeeOrganization.getPrimaryKey();

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

		if (!(object instanceof EmployeeOrganization)) {
			return false;
		}

		EmployeeOrganization employeeOrganization =
			(EmployeeOrganization)object;

		long primaryKey = employeeOrganization.getPrimaryKey();

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
	public CacheModel<EmployeeOrganization> toCacheModel() {
		EmployeeOrganizationCacheModel employeeOrganizationCacheModel =
			new EmployeeOrganizationCacheModel();

		employeeOrganizationCacheModel.employeeOrganizationId =
			getEmployeeOrganizationId();

		employeeOrganizationCacheModel.groupId = getGroupId();

		employeeOrganizationCacheModel.companyId = getCompanyId();

		employeeOrganizationCacheModel.userId = getUserId();

		employeeOrganizationCacheModel.userName = getUserName();

		String userName = employeeOrganizationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeeOrganizationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeOrganizationCacheModel.createDate = createDate.getTime();
		}
		else {
			employeeOrganizationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeOrganizationCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			employeeOrganizationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeeOrganizationCacheModel.employeeId = getEmployeeId();

		employeeOrganizationCacheModel.personalNo = getPersonalNo();

		String personalNo = employeeOrganizationCacheModel.personalNo;

		if ((personalNo != null) && (personalNo.length() == 0)) {
			employeeOrganizationCacheModel.personalNo = null;
		}

		employeeOrganizationCacheModel.organizationId = getOrganizationId();

		employeeOrganizationCacheModel.organizationCode = getOrganizationCode();

		String organizationCode =
			employeeOrganizationCacheModel.organizationCode;

		if ((organizationCode != null) && (organizationCode.length() == 0)) {
			employeeOrganizationCacheModel.organizationCode = null;
		}

		employeeOrganizationCacheModel.subOrganizationId =
			getSubOrganizationId();

		employeeOrganizationCacheModel.subOrganizationCode =
			getSubOrganizationCode();

		String subOrganizationCode =
			employeeOrganizationCacheModel.subOrganizationCode;

		if ((subOrganizationCode != null) &&
			(subOrganizationCode.length() == 0)) {

			employeeOrganizationCacheModel.subOrganizationCode = null;
		}

		employeeOrganizationCacheModel.active = isActive();

		employeeOrganizationCacheModel.status = getStatus();

		return employeeOrganizationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeeOrganization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeeOrganization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeOrganization, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((EmployeeOrganization)this));
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
		Map<String, Function<EmployeeOrganization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeeOrganization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeOrganization, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((EmployeeOrganization)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmployeeOrganization>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _employeeOrganizationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _employeeId;
	private String _personalNo;
	private long _organizationId;
	private String _organizationCode;
	private long _subOrganizationId;
	private String _subOrganizationCode;
	private boolean _active;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<EmployeeOrganization, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeeOrganization)this);
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
			"employeeOrganizationId", _employeeOrganizationId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("personalNo", _personalNo);
		_columnOriginalValues.put("organizationId", _organizationId);
		_columnOriginalValues.put("organizationCode", _organizationCode);
		_columnOriginalValues.put("subOrganizationId", _subOrganizationId);
		_columnOriginalValues.put("subOrganizationCode", _subOrganizationCode);
		_columnOriginalValues.put("active_", _active);
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

		columnBitmasks.put("employeeOrganizationId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("employeeId", 128L);

		columnBitmasks.put("personalNo", 256L);

		columnBitmasks.put("organizationId", 512L);

		columnBitmasks.put("organizationCode", 1024L);

		columnBitmasks.put("subOrganizationId", 2048L);

		columnBitmasks.put("subOrganizationCode", 4096L);

		columnBitmasks.put("active_", 8192L);

		columnBitmasks.put("status", 16384L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeeOrganization _escapedModel;

}