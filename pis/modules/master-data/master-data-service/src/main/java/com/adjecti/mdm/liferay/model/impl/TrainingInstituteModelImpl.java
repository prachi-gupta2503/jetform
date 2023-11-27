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

package com.adjecti.mdm.liferay.model.impl;

import com.adjecti.mdm.liferay.model.TrainingInstitute;
import com.adjecti.mdm.liferay.model.TrainingInstituteModel;
import com.adjecti.mdm.liferay.model.TrainingInstituteSoap;

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
 * The base model implementation for the TrainingInstitute service. Represents a row in the &quot;mdm_TrainingInstitute&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TrainingInstituteModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TrainingInstituteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingInstituteImpl
 * @generated
 */
@JSON(strict = true)
public class TrainingInstituteModelImpl
	extends BaseModelImpl<TrainingInstitute> implements TrainingInstituteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a training institute model instance should use the <code>TrainingInstitute</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_TrainingInstitute";

	public static final Object[][] TABLE_COLUMNS = {
		{"trainingInstituteId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"code_", Types.VARCHAR},
		{"name", Types.VARCHAR}, {"locationId", Types.BIGINT},
		{"stateId", Types.BIGINT}, {"deleted", Types.BOOLEAN},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("trainingInstituteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("locationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("stateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_TrainingInstitute (trainingInstituteId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,code_ VARCHAR(75) null,name VARCHAR(75) null,locationId LONG,stateId LONG,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table mdm_TrainingInstitute";

	public static final String ORDER_BY_JPQL =
		" ORDER BY trainingInstitute.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_TrainingInstitute.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CODE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 2L;

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
	public static TrainingInstitute toModel(TrainingInstituteSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TrainingInstitute model = new TrainingInstituteImpl();

		model.setTrainingInstituteId(soapModel.getTrainingInstituteId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCode(soapModel.getCode());
		model.setName(soapModel.getName());
		model.setLocationId(soapModel.getLocationId());
		model.setStateId(soapModel.getStateId());
		model.setDeleted(soapModel.isDeleted());
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
	public static List<TrainingInstitute> toModels(
		TrainingInstituteSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<TrainingInstitute> models = new ArrayList<TrainingInstitute>(
			soapModels.length);

		for (TrainingInstituteSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TrainingInstituteModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _trainingInstituteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTrainingInstituteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _trainingInstituteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TrainingInstitute.class;
	}

	@Override
	public String getModelClassName() {
		return TrainingInstitute.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TrainingInstitute, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TrainingInstitute, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TrainingInstitute, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TrainingInstitute)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TrainingInstitute, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TrainingInstitute, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TrainingInstitute)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TrainingInstitute, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TrainingInstitute, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TrainingInstitute>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TrainingInstitute.class.getClassLoader(), TrainingInstitute.class,
			ModelWrapper.class);

		try {
			Constructor<TrainingInstitute> constructor =
				(Constructor<TrainingInstitute>)proxyClass.getConstructor(
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

	private static final Map<String, Function<TrainingInstitute, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TrainingInstitute, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TrainingInstitute, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<TrainingInstitute, Object>>();
		Map<String, BiConsumer<TrainingInstitute, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<TrainingInstitute, ?>>();

		attributeGetterFunctions.put(
			"trainingInstituteId", TrainingInstitute::getTrainingInstituteId);
		attributeSetterBiConsumers.put(
			"trainingInstituteId",
			(BiConsumer<TrainingInstitute, Long>)
				TrainingInstitute::setTrainingInstituteId);
		attributeGetterFunctions.put("groupId", TrainingInstitute::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<TrainingInstitute, Long>)TrainingInstitute::setGroupId);
		attributeGetterFunctions.put(
			"companyId", TrainingInstitute::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TrainingInstitute, Long>)
				TrainingInstitute::setCompanyId);
		attributeGetterFunctions.put("userId", TrainingInstitute::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<TrainingInstitute, Long>)TrainingInstitute::setUserId);
		attributeGetterFunctions.put(
			"userName", TrainingInstitute::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<TrainingInstitute, String>)
				TrainingInstitute::setUserName);
		attributeGetterFunctions.put(
			"createDate", TrainingInstitute::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TrainingInstitute, Date>)
				TrainingInstitute::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TrainingInstitute::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TrainingInstitute, Date>)
				TrainingInstitute::setModifiedDate);
		attributeGetterFunctions.put("code", TrainingInstitute::getCode);
		attributeSetterBiConsumers.put(
			"code",
			(BiConsumer<TrainingInstitute, String>)TrainingInstitute::setCode);
		attributeGetterFunctions.put("name", TrainingInstitute::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<TrainingInstitute, String>)TrainingInstitute::setName);
		attributeGetterFunctions.put(
			"locationId", TrainingInstitute::getLocationId);
		attributeSetterBiConsumers.put(
			"locationId",
			(BiConsumer<TrainingInstitute, Long>)
				TrainingInstitute::setLocationId);
		attributeGetterFunctions.put("stateId", TrainingInstitute::getStateId);
		attributeSetterBiConsumers.put(
			"stateId",
			(BiConsumer<TrainingInstitute, Long>)TrainingInstitute::setStateId);
		attributeGetterFunctions.put("deleted", TrainingInstitute::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<TrainingInstitute, Boolean>)
				TrainingInstitute::setDeleted);
		attributeGetterFunctions.put("status", TrainingInstitute::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<TrainingInstitute, Integer>)
				TrainingInstitute::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTrainingInstituteId() {
		return _trainingInstituteId;
	}

	@Override
	public void setTrainingInstituteId(long trainingInstituteId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_trainingInstituteId = trainingInstituteId;
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
	public String getCode() {
		if (_code == null) {
			return "";
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_code = code;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalCode() {
		return getColumnOriginalValue("code_");
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
	}

	@JSON
	@Override
	public long getLocationId() {
		return _locationId;
	}

	@Override
	public void setLocationId(long locationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_locationId = locationId;
	}

	@JSON
	@Override
	public long getStateId() {
		return _stateId;
	}

	@Override
	public void setStateId(long stateId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_stateId = stateId;
	}

	@JSON
	@Override
	public boolean getDeleted() {
		return _deleted;
	}

	@JSON
	@Override
	public boolean isDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_deleted = deleted;
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
			getCompanyId(), TrainingInstitute.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TrainingInstitute toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TrainingInstitute>
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
		TrainingInstituteImpl trainingInstituteImpl =
			new TrainingInstituteImpl();

		trainingInstituteImpl.setTrainingInstituteId(getTrainingInstituteId());
		trainingInstituteImpl.setGroupId(getGroupId());
		trainingInstituteImpl.setCompanyId(getCompanyId());
		trainingInstituteImpl.setUserId(getUserId());
		trainingInstituteImpl.setUserName(getUserName());
		trainingInstituteImpl.setCreateDate(getCreateDate());
		trainingInstituteImpl.setModifiedDate(getModifiedDate());
		trainingInstituteImpl.setCode(getCode());
		trainingInstituteImpl.setName(getName());
		trainingInstituteImpl.setLocationId(getLocationId());
		trainingInstituteImpl.setStateId(getStateId());
		trainingInstituteImpl.setDeleted(isDeleted());
		trainingInstituteImpl.setStatus(getStatus());

		trainingInstituteImpl.resetOriginalValues();

		return trainingInstituteImpl;
	}

	@Override
	public int compareTo(TrainingInstitute trainingInstitute) {
		int value = 0;

		value = getName().compareTo(trainingInstitute.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TrainingInstitute)) {
			return false;
		}

		TrainingInstitute trainingInstitute = (TrainingInstitute)object;

		long primaryKey = trainingInstitute.getPrimaryKey();

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
	public CacheModel<TrainingInstitute> toCacheModel() {
		TrainingInstituteCacheModel trainingInstituteCacheModel =
			new TrainingInstituteCacheModel();

		trainingInstituteCacheModel.trainingInstituteId =
			getTrainingInstituteId();

		trainingInstituteCacheModel.groupId = getGroupId();

		trainingInstituteCacheModel.companyId = getCompanyId();

		trainingInstituteCacheModel.userId = getUserId();

		trainingInstituteCacheModel.userName = getUserName();

		String userName = trainingInstituteCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			trainingInstituteCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			trainingInstituteCacheModel.createDate = createDate.getTime();
		}
		else {
			trainingInstituteCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			trainingInstituteCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			trainingInstituteCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		trainingInstituteCacheModel.code = getCode();

		String code = trainingInstituteCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			trainingInstituteCacheModel.code = null;
		}

		trainingInstituteCacheModel.name = getName();

		String name = trainingInstituteCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			trainingInstituteCacheModel.name = null;
		}

		trainingInstituteCacheModel.locationId = getLocationId();

		trainingInstituteCacheModel.stateId = getStateId();

		trainingInstituteCacheModel.deleted = isDeleted();

		trainingInstituteCacheModel.status = getStatus();

		return trainingInstituteCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TrainingInstitute, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TrainingInstitute, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TrainingInstitute, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TrainingInstitute)this));
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
		Map<String, Function<TrainingInstitute, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TrainingInstitute, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TrainingInstitute, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TrainingInstitute)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TrainingInstitute>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _trainingInstituteId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _code;
	private String _name;
	private long _locationId;
	private long _stateId;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<TrainingInstitute, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((TrainingInstitute)this);
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

		_columnOriginalValues.put("trainingInstituteId", _trainingInstituteId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("code_", _code);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("locationId", _locationId);
		_columnOriginalValues.put("stateId", _stateId);
		_columnOriginalValues.put("deleted", _deleted);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("code_", "code");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("trainingInstituteId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("code_", 128L);

		columnBitmasks.put("name", 256L);

		columnBitmasks.put("locationId", 512L);

		columnBitmasks.put("stateId", 1024L);

		columnBitmasks.put("deleted", 2048L);

		columnBitmasks.put("status", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private TrainingInstitute _escapedModel;

}