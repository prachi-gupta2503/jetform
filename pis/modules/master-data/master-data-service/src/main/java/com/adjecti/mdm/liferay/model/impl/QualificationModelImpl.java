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

import com.adjecti.mdm.liferay.model.Qualification;
import com.adjecti.mdm.liferay.model.QualificationModel;
import com.adjecti.mdm.liferay.model.QualificationSoap;

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
 * The base model implementation for the Qualification service. Represents a row in the &quot;mdm_Qualification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>QualificationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QualificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationImpl
 * @generated
 */
@JSON(strict = true)
public class QualificationModelImpl
	extends BaseModelImpl<Qualification> implements QualificationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a qualification model instance should use the <code>Qualification</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_Qualification";

	public static final Object[][] TABLE_COLUMNS = {
		{"qualificationId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"code_", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"name", Types.VARCHAR},
		{"shortName", Types.VARCHAR}, {"fullName", Types.VARCHAR},
		{"deleted", Types.BOOLEAN}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("qualificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shortName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fullName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_Qualification (qualificationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,code_ VARCHAR(75) null,description VARCHAR(75) null,name VARCHAR(75) null,shortName VARCHAR(75) null,fullName VARCHAR(75) null,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table mdm_Qualification";

	public static final String ORDER_BY_JPQL =
		" ORDER BY qualification.qualificationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_Qualification.qualificationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long QUALIFICATIONID_COLUMN_BITMASK = 1L;

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
	public static Qualification toModel(QualificationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Qualification model = new QualificationImpl();

		model.setQualificationId(soapModel.getQualificationId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCode(soapModel.getCode());
		model.setDescription(soapModel.getDescription());
		model.setName(soapModel.getName());
		model.setShortName(soapModel.getShortName());
		model.setFullName(soapModel.getFullName());
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
	public static List<Qualification> toModels(QualificationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Qualification> models = new ArrayList<Qualification>(
			soapModels.length);

		for (QualificationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public QualificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _qualificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setQualificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _qualificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Qualification.class;
	}

	@Override
	public String getModelClassName() {
		return Qualification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Qualification, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Qualification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Qualification, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Qualification)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Qualification, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Qualification, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Qualification)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Qualification, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Qualification, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Qualification>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Qualification.class.getClassLoader(), Qualification.class,
			ModelWrapper.class);

		try {
			Constructor<Qualification> constructor =
				(Constructor<Qualification>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Qualification, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Qualification, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Qualification, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Qualification, Object>>();
		Map<String, BiConsumer<Qualification, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Qualification, ?>>();

		attributeGetterFunctions.put(
			"qualificationId", Qualification::getQualificationId);
		attributeSetterBiConsumers.put(
			"qualificationId",
			(BiConsumer<Qualification, Long>)Qualification::setQualificationId);
		attributeGetterFunctions.put("groupId", Qualification::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<Qualification, Long>)Qualification::setGroupId);
		attributeGetterFunctions.put("companyId", Qualification::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<Qualification, Long>)Qualification::setCompanyId);
		attributeGetterFunctions.put("userId", Qualification::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<Qualification, Long>)Qualification::setUserId);
		attributeGetterFunctions.put("userName", Qualification::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<Qualification, String>)Qualification::setUserName);
		attributeGetterFunctions.put(
			"createDate", Qualification::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<Qualification, Date>)Qualification::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", Qualification::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Qualification, Date>)Qualification::setModifiedDate);
		attributeGetterFunctions.put("code", Qualification::getCode);
		attributeSetterBiConsumers.put(
			"code", (BiConsumer<Qualification, String>)Qualification::setCode);
		attributeGetterFunctions.put(
			"description", Qualification::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<Qualification, String>)Qualification::setDescription);
		attributeGetterFunctions.put("name", Qualification::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Qualification, String>)Qualification::setName);
		attributeGetterFunctions.put("shortName", Qualification::getShortName);
		attributeSetterBiConsumers.put(
			"shortName",
			(BiConsumer<Qualification, String>)Qualification::setShortName);
		attributeGetterFunctions.put("fullName", Qualification::getFullName);
		attributeSetterBiConsumers.put(
			"fullName",
			(BiConsumer<Qualification, String>)Qualification::setFullName);
		attributeGetterFunctions.put("deleted", Qualification::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<Qualification, Boolean>)Qualification::setDeleted);
		attributeGetterFunctions.put("status", Qualification::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<Qualification, Integer>)Qualification::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getQualificationId() {
		return _qualificationId;
	}

	@Override
	public void setQualificationId(long qualificationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_qualificationId = qualificationId;
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

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
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
	public String getShortName() {
		if (_shortName == null) {
			return "";
		}
		else {
			return _shortName;
		}
	}

	@Override
	public void setShortName(String shortName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_shortName = shortName;
	}

	@JSON
	@Override
	public String getFullName() {
		if (_fullName == null) {
			return "";
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fullName = fullName;
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
			getCompanyId(), Qualification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Qualification toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Qualification>
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
		QualificationImpl qualificationImpl = new QualificationImpl();

		qualificationImpl.setQualificationId(getQualificationId());
		qualificationImpl.setGroupId(getGroupId());
		qualificationImpl.setCompanyId(getCompanyId());
		qualificationImpl.setUserId(getUserId());
		qualificationImpl.setUserName(getUserName());
		qualificationImpl.setCreateDate(getCreateDate());
		qualificationImpl.setModifiedDate(getModifiedDate());
		qualificationImpl.setCode(getCode());
		qualificationImpl.setDescription(getDescription());
		qualificationImpl.setName(getName());
		qualificationImpl.setShortName(getShortName());
		qualificationImpl.setFullName(getFullName());
		qualificationImpl.setDeleted(isDeleted());
		qualificationImpl.setStatus(getStatus());

		qualificationImpl.resetOriginalValues();

		return qualificationImpl;
	}

	@Override
	public int compareTo(Qualification qualification) {
		long primaryKey = qualification.getPrimaryKey();

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

		if (!(object instanceof Qualification)) {
			return false;
		}

		Qualification qualification = (Qualification)object;

		long primaryKey = qualification.getPrimaryKey();

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
	public CacheModel<Qualification> toCacheModel() {
		QualificationCacheModel qualificationCacheModel =
			new QualificationCacheModel();

		qualificationCacheModel.qualificationId = getQualificationId();

		qualificationCacheModel.groupId = getGroupId();

		qualificationCacheModel.companyId = getCompanyId();

		qualificationCacheModel.userId = getUserId();

		qualificationCacheModel.userName = getUserName();

		String userName = qualificationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			qualificationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			qualificationCacheModel.createDate = createDate.getTime();
		}
		else {
			qualificationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			qualificationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			qualificationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		qualificationCacheModel.code = getCode();

		String code = qualificationCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			qualificationCacheModel.code = null;
		}

		qualificationCacheModel.description = getDescription();

		String description = qualificationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			qualificationCacheModel.description = null;
		}

		qualificationCacheModel.name = getName();

		String name = qualificationCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			qualificationCacheModel.name = null;
		}

		qualificationCacheModel.shortName = getShortName();

		String shortName = qualificationCacheModel.shortName;

		if ((shortName != null) && (shortName.length() == 0)) {
			qualificationCacheModel.shortName = null;
		}

		qualificationCacheModel.fullName = getFullName();

		String fullName = qualificationCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			qualificationCacheModel.fullName = null;
		}

		qualificationCacheModel.deleted = isDeleted();

		qualificationCacheModel.status = getStatus();

		return qualificationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Qualification, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Qualification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Qualification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Qualification)this));
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
		Map<String, Function<Qualification, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Qualification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Qualification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Qualification)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Qualification>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _qualificationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _code;
	private String _description;
	private String _name;
	private String _shortName;
	private String _fullName;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Qualification, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Qualification)this);
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

		_columnOriginalValues.put("qualificationId", _qualificationId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("code_", _code);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("shortName", _shortName);
		_columnOriginalValues.put("fullName", _fullName);
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

		columnBitmasks.put("qualificationId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("code_", 128L);

		columnBitmasks.put("description", 256L);

		columnBitmasks.put("name", 512L);

		columnBitmasks.put("shortName", 1024L);

		columnBitmasks.put("fullName", 2048L);

		columnBitmasks.put("deleted", 4096L);

		columnBitmasks.put("status", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Qualification _escapedModel;

}