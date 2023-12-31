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

import com.adjecti.pis.liferay.model.EmployeeWorkArea;
import com.adjecti.pis.liferay.model.EmployeeWorkAreaModel;
import com.adjecti.pis.liferay.model.EmployeeWorkAreaSoap;

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
 * The base model implementation for the EmployeeWorkArea service. Represents a row in the &quot;pis_EmployeeWorkArea&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeWorkAreaModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeWorkAreaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkAreaImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeWorkAreaModelImpl
	extends BaseModelImpl<EmployeeWorkArea> implements EmployeeWorkAreaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee work area model instance should use the <code>EmployeeWorkArea</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_EmployeeWorkArea";

	public static final Object[][] TABLE_COLUMNS = {
		{"employeeWorkAreaId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"employeeId", Types.BIGINT},
		{"workAreaMajorId", Types.BIGINT}, {"active_", Types.BOOLEAN},
		{"fromDate", Types.TIMESTAMP}, {"toDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeeWorkAreaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workAreaMajorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("fromDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("toDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_EmployeeWorkArea (employeeWorkAreaId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,employeeId LONG,workAreaMajorId LONG,active_ BOOLEAN,fromDate DATE null,toDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table pis_EmployeeWorkArea";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeeWorkArea.employeeWorkAreaId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_EmployeeWorkArea.employeeWorkAreaId ASC";

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
	public static final long WORKAREAMAJORID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEWORKAREAID_COLUMN_BITMASK = 4L;

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
	public static EmployeeWorkArea toModel(EmployeeWorkAreaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EmployeeWorkArea model = new EmployeeWorkAreaImpl();

		model.setEmployeeWorkAreaId(soapModel.getEmployeeWorkAreaId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setWorkAreaMajorId(soapModel.getWorkAreaMajorId());
		model.setActive(soapModel.isActive());
		model.setFromDate(soapModel.getFromDate());
		model.setToDate(soapModel.getToDate());

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
	public static List<EmployeeWorkArea> toModels(
		EmployeeWorkAreaSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<EmployeeWorkArea> models = new ArrayList<EmployeeWorkArea>(
			soapModels.length);

		for (EmployeeWorkAreaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeeWorkAreaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeWorkAreaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeWorkAreaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeWorkAreaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeWorkArea.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeWorkArea.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeeWorkArea, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeeWorkArea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeWorkArea, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeeWorkArea)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeeWorkArea, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeeWorkArea, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeeWorkArea)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeeWorkArea, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeeWorkArea, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmployeeWorkArea>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmployeeWorkArea.class.getClassLoader(), EmployeeWorkArea.class,
			ModelWrapper.class);

		try {
			Constructor<EmployeeWorkArea> constructor =
				(Constructor<EmployeeWorkArea>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EmployeeWorkArea, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmployeeWorkArea, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmployeeWorkArea, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<EmployeeWorkArea, Object>>();
		Map<String, BiConsumer<EmployeeWorkArea, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<EmployeeWorkArea, ?>>();

		attributeGetterFunctions.put(
			"employeeWorkAreaId", EmployeeWorkArea::getEmployeeWorkAreaId);
		attributeSetterBiConsumers.put(
			"employeeWorkAreaId",
			(BiConsumer<EmployeeWorkArea, Long>)
				EmployeeWorkArea::setEmployeeWorkAreaId);
		attributeGetterFunctions.put("groupId", EmployeeWorkArea::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EmployeeWorkArea, Long>)EmployeeWorkArea::setGroupId);
		attributeGetterFunctions.put(
			"companyId", EmployeeWorkArea::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmployeeWorkArea, Long>)EmployeeWorkArea::setCompanyId);
		attributeGetterFunctions.put("userId", EmployeeWorkArea::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EmployeeWorkArea, Long>)EmployeeWorkArea::setUserId);
		attributeGetterFunctions.put("userName", EmployeeWorkArea::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmployeeWorkArea, String>)
				EmployeeWorkArea::setUserName);
		attributeGetterFunctions.put(
			"createDate", EmployeeWorkArea::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmployeeWorkArea, Date>)
				EmployeeWorkArea::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmployeeWorkArea::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmployeeWorkArea, Date>)
				EmployeeWorkArea::setModifiedDate);
		attributeGetterFunctions.put(
			"employeeId", EmployeeWorkArea::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<EmployeeWorkArea, Long>)
				EmployeeWorkArea::setEmployeeId);
		attributeGetterFunctions.put(
			"workAreaMajorId", EmployeeWorkArea::getWorkAreaMajorId);
		attributeSetterBiConsumers.put(
			"workAreaMajorId",
			(BiConsumer<EmployeeWorkArea, Long>)
				EmployeeWorkArea::setWorkAreaMajorId);
		attributeGetterFunctions.put("active", EmployeeWorkArea::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<EmployeeWorkArea, Boolean>)EmployeeWorkArea::setActive);
		attributeGetterFunctions.put("fromDate", EmployeeWorkArea::getFromDate);
		attributeSetterBiConsumers.put(
			"fromDate",
			(BiConsumer<EmployeeWorkArea, Date>)EmployeeWorkArea::setFromDate);
		attributeGetterFunctions.put("toDate", EmployeeWorkArea::getToDate);
		attributeSetterBiConsumers.put(
			"toDate",
			(BiConsumer<EmployeeWorkArea, Date>)EmployeeWorkArea::setToDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getEmployeeWorkAreaId() {
		return _employeeWorkAreaId;
	}

	@Override
	public void setEmployeeWorkAreaId(long employeeWorkAreaId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeWorkAreaId = employeeWorkAreaId;
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
	public long getWorkAreaMajorId() {
		return _workAreaMajorId;
	}

	@Override
	public void setWorkAreaMajorId(long workAreaMajorId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_workAreaMajorId = workAreaMajorId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalWorkAreaMajorId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("workAreaMajorId"));
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
			getCompanyId(), EmployeeWorkArea.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeWorkArea toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeeWorkArea>
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
		EmployeeWorkAreaImpl employeeWorkAreaImpl = new EmployeeWorkAreaImpl();

		employeeWorkAreaImpl.setEmployeeWorkAreaId(getEmployeeWorkAreaId());
		employeeWorkAreaImpl.setGroupId(getGroupId());
		employeeWorkAreaImpl.setCompanyId(getCompanyId());
		employeeWorkAreaImpl.setUserId(getUserId());
		employeeWorkAreaImpl.setUserName(getUserName());
		employeeWorkAreaImpl.setCreateDate(getCreateDate());
		employeeWorkAreaImpl.setModifiedDate(getModifiedDate());
		employeeWorkAreaImpl.setEmployeeId(getEmployeeId());
		employeeWorkAreaImpl.setWorkAreaMajorId(getWorkAreaMajorId());
		employeeWorkAreaImpl.setActive(isActive());
		employeeWorkAreaImpl.setFromDate(getFromDate());
		employeeWorkAreaImpl.setToDate(getToDate());

		employeeWorkAreaImpl.resetOriginalValues();

		return employeeWorkAreaImpl;
	}

	@Override
	public int compareTo(EmployeeWorkArea employeeWorkArea) {
		long primaryKey = employeeWorkArea.getPrimaryKey();

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

		if (!(object instanceof EmployeeWorkArea)) {
			return false;
		}

		EmployeeWorkArea employeeWorkArea = (EmployeeWorkArea)object;

		long primaryKey = employeeWorkArea.getPrimaryKey();

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
	public CacheModel<EmployeeWorkArea> toCacheModel() {
		EmployeeWorkAreaCacheModel employeeWorkAreaCacheModel =
			new EmployeeWorkAreaCacheModel();

		employeeWorkAreaCacheModel.employeeWorkAreaId = getEmployeeWorkAreaId();

		employeeWorkAreaCacheModel.groupId = getGroupId();

		employeeWorkAreaCacheModel.companyId = getCompanyId();

		employeeWorkAreaCacheModel.userId = getUserId();

		employeeWorkAreaCacheModel.userName = getUserName();

		String userName = employeeWorkAreaCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeeWorkAreaCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeWorkAreaCacheModel.createDate = createDate.getTime();
		}
		else {
			employeeWorkAreaCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeWorkAreaCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			employeeWorkAreaCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeeWorkAreaCacheModel.employeeId = getEmployeeId();

		employeeWorkAreaCacheModel.workAreaMajorId = getWorkAreaMajorId();

		employeeWorkAreaCacheModel.active = isActive();

		Date fromDate = getFromDate();

		if (fromDate != null) {
			employeeWorkAreaCacheModel.fromDate = fromDate.getTime();
		}
		else {
			employeeWorkAreaCacheModel.fromDate = Long.MIN_VALUE;
		}

		Date toDate = getToDate();

		if (toDate != null) {
			employeeWorkAreaCacheModel.toDate = toDate.getTime();
		}
		else {
			employeeWorkAreaCacheModel.toDate = Long.MIN_VALUE;
		}

		return employeeWorkAreaCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeeWorkArea, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeeWorkArea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeWorkArea, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EmployeeWorkArea)this));
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
		Map<String, Function<EmployeeWorkArea, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeeWorkArea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeWorkArea, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmployeeWorkArea)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmployeeWorkArea>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _employeeWorkAreaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _employeeId;
	private long _workAreaMajorId;
	private boolean _active;
	private Date _fromDate;
	private Date _toDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<EmployeeWorkArea, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeeWorkArea)this);
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

		_columnOriginalValues.put("employeeWorkAreaId", _employeeWorkAreaId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("workAreaMajorId", _workAreaMajorId);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("fromDate", _fromDate);
		_columnOriginalValues.put("toDate", _toDate);
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

		columnBitmasks.put("employeeWorkAreaId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("employeeId", 128L);

		columnBitmasks.put("workAreaMajorId", 256L);

		columnBitmasks.put("active_", 512L);

		columnBitmasks.put("fromDate", 1024L);

		columnBitmasks.put("toDate", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeeWorkArea _escapedModel;

}