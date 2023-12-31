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

import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.mdm.liferay.model.GradeModeModel;
import com.adjecti.mdm.liferay.model.GradeModeSoap;

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
 * The base model implementation for the GradeMode service. Represents a row in the &quot;mdm_GradeMode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>GradeModeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GradeModeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GradeModeImpl
 * @generated
 */
@JSON(strict = true)
public class GradeModeModelImpl
	extends BaseModelImpl<GradeMode> implements GradeModeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a grade mode model instance should use the <code>GradeMode</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_GradeMode";

	public static final Object[][] TABLE_COLUMNS = {
		{"gradeModeId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"code_", Types.VARCHAR}, {"deleted", Types.BOOLEAN},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("gradeModeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_GradeMode (gradeModeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,code_ VARCHAR(75) null,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table mdm_GradeMode";

	public static final String ORDER_BY_JPQL =
		" ORDER BY gradeMode.gradeModeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_GradeMode.gradeModeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long GRADEMODEID_COLUMN_BITMASK = 1L;

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
	public static GradeMode toModel(GradeModeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		GradeMode model = new GradeModeImpl();

		model.setGradeModeId(soapModel.getGradeModeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setCode(soapModel.getCode());
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
	public static List<GradeMode> toModels(GradeModeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<GradeMode> models = new ArrayList<GradeMode>(soapModels.length);

		for (GradeModeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public GradeModeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _gradeModeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGradeModeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _gradeModeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return GradeMode.class;
	}

	@Override
	public String getModelClassName() {
		return GradeMode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<GradeMode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<GradeMode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<GradeMode, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((GradeMode)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<GradeMode, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<GradeMode, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(GradeMode)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<GradeMode, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<GradeMode, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, GradeMode>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			GradeMode.class.getClassLoader(), GradeMode.class,
			ModelWrapper.class);

		try {
			Constructor<GradeMode> constructor =
				(Constructor<GradeMode>)proxyClass.getConstructor(
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

	private static final Map<String, Function<GradeMode, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<GradeMode, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<GradeMode, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<GradeMode, Object>>();
		Map<String, BiConsumer<GradeMode, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<GradeMode, ?>>();

		attributeGetterFunctions.put("gradeModeId", GradeMode::getGradeModeId);
		attributeSetterBiConsumers.put(
			"gradeModeId",
			(BiConsumer<GradeMode, Long>)GradeMode::setGradeModeId);
		attributeGetterFunctions.put("groupId", GradeMode::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<GradeMode, Long>)GradeMode::setGroupId);
		attributeGetterFunctions.put("companyId", GradeMode::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<GradeMode, Long>)GradeMode::setCompanyId);
		attributeGetterFunctions.put("userId", GradeMode::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<GradeMode, Long>)GradeMode::setUserId);
		attributeGetterFunctions.put("userName", GradeMode::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<GradeMode, String>)GradeMode::setUserName);
		attributeGetterFunctions.put("createDate", GradeMode::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<GradeMode, Date>)GradeMode::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", GradeMode::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<GradeMode, Date>)GradeMode::setModifiedDate);
		attributeGetterFunctions.put("name", GradeMode::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<GradeMode, String>)GradeMode::setName);
		attributeGetterFunctions.put("code", GradeMode::getCode);
		attributeSetterBiConsumers.put(
			"code", (BiConsumer<GradeMode, String>)GradeMode::setCode);
		attributeGetterFunctions.put("deleted", GradeMode::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted", (BiConsumer<GradeMode, Boolean>)GradeMode::setDeleted);
		attributeGetterFunctions.put("status", GradeMode::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<GradeMode, Integer>)GradeMode::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getGradeModeId() {
		return _gradeModeId;
	}

	@Override
	public void setGradeModeId(long gradeModeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_gradeModeId = gradeModeId;
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
			getCompanyId(), GradeMode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public GradeMode toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, GradeMode>
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
		GradeModeImpl gradeModeImpl = new GradeModeImpl();

		gradeModeImpl.setGradeModeId(getGradeModeId());
		gradeModeImpl.setGroupId(getGroupId());
		gradeModeImpl.setCompanyId(getCompanyId());
		gradeModeImpl.setUserId(getUserId());
		gradeModeImpl.setUserName(getUserName());
		gradeModeImpl.setCreateDate(getCreateDate());
		gradeModeImpl.setModifiedDate(getModifiedDate());
		gradeModeImpl.setName(getName());
		gradeModeImpl.setCode(getCode());
		gradeModeImpl.setDeleted(isDeleted());
		gradeModeImpl.setStatus(getStatus());

		gradeModeImpl.resetOriginalValues();

		return gradeModeImpl;
	}

	@Override
	public int compareTo(GradeMode gradeMode) {
		long primaryKey = gradeMode.getPrimaryKey();

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

		if (!(object instanceof GradeMode)) {
			return false;
		}

		GradeMode gradeMode = (GradeMode)object;

		long primaryKey = gradeMode.getPrimaryKey();

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
	public CacheModel<GradeMode> toCacheModel() {
		GradeModeCacheModel gradeModeCacheModel = new GradeModeCacheModel();

		gradeModeCacheModel.gradeModeId = getGradeModeId();

		gradeModeCacheModel.groupId = getGroupId();

		gradeModeCacheModel.companyId = getCompanyId();

		gradeModeCacheModel.userId = getUserId();

		gradeModeCacheModel.userName = getUserName();

		String userName = gradeModeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			gradeModeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			gradeModeCacheModel.createDate = createDate.getTime();
		}
		else {
			gradeModeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			gradeModeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			gradeModeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		gradeModeCacheModel.name = getName();

		String name = gradeModeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			gradeModeCacheModel.name = null;
		}

		gradeModeCacheModel.code = getCode();

		String code = gradeModeCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			gradeModeCacheModel.code = null;
		}

		gradeModeCacheModel.deleted = isDeleted();

		gradeModeCacheModel.status = getStatus();

		return gradeModeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<GradeMode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<GradeMode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<GradeMode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((GradeMode)this));
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
		Map<String, Function<GradeMode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<GradeMode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<GradeMode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((GradeMode)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, GradeMode>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _gradeModeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _code;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<GradeMode, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((GradeMode)this);
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

		_columnOriginalValues.put("gradeModeId", _gradeModeId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("code_", _code);
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

		columnBitmasks.put("gradeModeId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("name", 128L);

		columnBitmasks.put("code_", 256L);

		columnBitmasks.put("deleted", 512L);

		columnBitmasks.put("status", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private GradeMode _escapedModel;

}