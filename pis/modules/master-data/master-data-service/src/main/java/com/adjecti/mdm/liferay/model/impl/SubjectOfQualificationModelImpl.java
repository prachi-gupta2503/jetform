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

import com.adjecti.mdm.liferay.model.SubjectOfQualification;
import com.adjecti.mdm.liferay.model.SubjectOfQualificationModel;
import com.adjecti.mdm.liferay.model.SubjectOfQualificationSoap;

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
 * The base model implementation for the SubjectOfQualification service. Represents a row in the &quot;mdm_SubjectOfQualification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SubjectOfQualificationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SubjectOfQualificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubjectOfQualificationImpl
 * @generated
 */
@JSON(strict = true)
public class SubjectOfQualificationModelImpl
	extends BaseModelImpl<SubjectOfQualification>
	implements SubjectOfQualificationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a subject of qualification model instance should use the <code>SubjectOfQualification</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_SubjectOfQualification";

	public static final Object[][] TABLE_COLUMNS = {
		{"subjectOfQualificationId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"description", Types.VARCHAR},
		{"code_", Types.VARCHAR}, {"subjectOfQualification", Types.VARCHAR},
		{"deleted", Types.BOOLEAN}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("subjectOfQualificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subjectOfQualification", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_SubjectOfQualification (subjectOfQualificationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,description VARCHAR(75) null,code_ VARCHAR(75) null,subjectOfQualification VARCHAR(75) null,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table mdm_SubjectOfQualification";

	public static final String ORDER_BY_JPQL =
		" ORDER BY subjectOfQualification.subjectOfQualificationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_SubjectOfQualification.subjectOfQualificationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long SUBJECTOFQUALIFICATIONID_COLUMN_BITMASK = 1L;

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
	public static SubjectOfQualification toModel(
		SubjectOfQualificationSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		SubjectOfQualification model = new SubjectOfQualificationImpl();

		model.setSubjectOfQualificationId(
			soapModel.getSubjectOfQualificationId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDescription(soapModel.getDescription());
		model.setCode(soapModel.getCode());
		model.setSubjectOfQualification(soapModel.getSubjectOfQualification());
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
	public static List<SubjectOfQualification> toModels(
		SubjectOfQualificationSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<SubjectOfQualification> models =
			new ArrayList<SubjectOfQualification>(soapModels.length);

		for (SubjectOfQualificationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public SubjectOfQualificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _subjectOfQualificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubjectOfQualificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subjectOfQualificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SubjectOfQualification.class;
	}

	@Override
	public String getModelClassName() {
		return SubjectOfQualification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SubjectOfQualification, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SubjectOfQualification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SubjectOfQualification, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SubjectOfQualification)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SubjectOfQualification, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SubjectOfQualification, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SubjectOfQualification)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SubjectOfQualification, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SubjectOfQualification, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SubjectOfQualification>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SubjectOfQualification.class.getClassLoader(),
			SubjectOfQualification.class, ModelWrapper.class);

		try {
			Constructor<SubjectOfQualification> constructor =
				(Constructor<SubjectOfQualification>)proxyClass.getConstructor(
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

	private static final Map<String, Function<SubjectOfQualification, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SubjectOfQualification, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SubjectOfQualification, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<SubjectOfQualification, Object>>();
		Map<String, BiConsumer<SubjectOfQualification, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<SubjectOfQualification, ?>>();

		attributeGetterFunctions.put(
			"subjectOfQualificationId",
			SubjectOfQualification::getSubjectOfQualificationId);
		attributeSetterBiConsumers.put(
			"subjectOfQualificationId",
			(BiConsumer<SubjectOfQualification, Long>)
				SubjectOfQualification::setSubjectOfQualificationId);
		attributeGetterFunctions.put(
			"groupId", SubjectOfQualification::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<SubjectOfQualification, Long>)
				SubjectOfQualification::setGroupId);
		attributeGetterFunctions.put(
			"companyId", SubjectOfQualification::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SubjectOfQualification, Long>)
				SubjectOfQualification::setCompanyId);
		attributeGetterFunctions.put(
			"userId", SubjectOfQualification::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<SubjectOfQualification, Long>)
				SubjectOfQualification::setUserId);
		attributeGetterFunctions.put(
			"userName", SubjectOfQualification::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<SubjectOfQualification, String>)
				SubjectOfQualification::setUserName);
		attributeGetterFunctions.put(
			"createDate", SubjectOfQualification::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SubjectOfQualification, Date>)
				SubjectOfQualification::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", SubjectOfQualification::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<SubjectOfQualification, Date>)
				SubjectOfQualification::setModifiedDate);
		attributeGetterFunctions.put(
			"description", SubjectOfQualification::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<SubjectOfQualification, String>)
				SubjectOfQualification::setDescription);
		attributeGetterFunctions.put("code", SubjectOfQualification::getCode);
		attributeSetterBiConsumers.put(
			"code",
			(BiConsumer<SubjectOfQualification, String>)
				SubjectOfQualification::setCode);
		attributeGetterFunctions.put(
			"subjectOfQualification",
			SubjectOfQualification::getSubjectOfQualification);
		attributeSetterBiConsumers.put(
			"subjectOfQualification",
			(BiConsumer<SubjectOfQualification, String>)
				SubjectOfQualification::setSubjectOfQualification);
		attributeGetterFunctions.put(
			"deleted", SubjectOfQualification::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<SubjectOfQualification, Boolean>)
				SubjectOfQualification::setDeleted);
		attributeGetterFunctions.put(
			"status", SubjectOfQualification::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<SubjectOfQualification, Integer>)
				SubjectOfQualification::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getSubjectOfQualificationId() {
		return _subjectOfQualificationId;
	}

	@Override
	public void setSubjectOfQualificationId(long subjectOfQualificationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subjectOfQualificationId = subjectOfQualificationId;
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
	public String getSubjectOfQualification() {
		if (_subjectOfQualification == null) {
			return "";
		}
		else {
			return _subjectOfQualification;
		}
	}

	@Override
	public void setSubjectOfQualification(String subjectOfQualification) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subjectOfQualification = subjectOfQualification;
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
			getCompanyId(), SubjectOfQualification.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SubjectOfQualification toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SubjectOfQualification>
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
		SubjectOfQualificationImpl subjectOfQualificationImpl =
			new SubjectOfQualificationImpl();

		subjectOfQualificationImpl.setSubjectOfQualificationId(
			getSubjectOfQualificationId());
		subjectOfQualificationImpl.setGroupId(getGroupId());
		subjectOfQualificationImpl.setCompanyId(getCompanyId());
		subjectOfQualificationImpl.setUserId(getUserId());
		subjectOfQualificationImpl.setUserName(getUserName());
		subjectOfQualificationImpl.setCreateDate(getCreateDate());
		subjectOfQualificationImpl.setModifiedDate(getModifiedDate());
		subjectOfQualificationImpl.setDescription(getDescription());
		subjectOfQualificationImpl.setCode(getCode());
		subjectOfQualificationImpl.setSubjectOfQualification(
			getSubjectOfQualification());
		subjectOfQualificationImpl.setDeleted(isDeleted());
		subjectOfQualificationImpl.setStatus(getStatus());

		subjectOfQualificationImpl.resetOriginalValues();

		return subjectOfQualificationImpl;
	}

	@Override
	public int compareTo(SubjectOfQualification subjectOfQualification) {
		long primaryKey = subjectOfQualification.getPrimaryKey();

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

		if (!(object instanceof SubjectOfQualification)) {
			return false;
		}

		SubjectOfQualification subjectOfQualification =
			(SubjectOfQualification)object;

		long primaryKey = subjectOfQualification.getPrimaryKey();

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
	public CacheModel<SubjectOfQualification> toCacheModel() {
		SubjectOfQualificationCacheModel subjectOfQualificationCacheModel =
			new SubjectOfQualificationCacheModel();

		subjectOfQualificationCacheModel.subjectOfQualificationId =
			getSubjectOfQualificationId();

		subjectOfQualificationCacheModel.groupId = getGroupId();

		subjectOfQualificationCacheModel.companyId = getCompanyId();

		subjectOfQualificationCacheModel.userId = getUserId();

		subjectOfQualificationCacheModel.userName = getUserName();

		String userName = subjectOfQualificationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			subjectOfQualificationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			subjectOfQualificationCacheModel.createDate = createDate.getTime();
		}
		else {
			subjectOfQualificationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			subjectOfQualificationCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			subjectOfQualificationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		subjectOfQualificationCacheModel.description = getDescription();

		String description = subjectOfQualificationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			subjectOfQualificationCacheModel.description = null;
		}

		subjectOfQualificationCacheModel.code = getCode();

		String code = subjectOfQualificationCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			subjectOfQualificationCacheModel.code = null;
		}

		subjectOfQualificationCacheModel.subjectOfQualification =
			getSubjectOfQualification();

		String subjectOfQualification =
			subjectOfQualificationCacheModel.subjectOfQualification;

		if ((subjectOfQualification != null) &&
			(subjectOfQualification.length() == 0)) {

			subjectOfQualificationCacheModel.subjectOfQualification = null;
		}

		subjectOfQualificationCacheModel.deleted = isDeleted();

		subjectOfQualificationCacheModel.status = getStatus();

		return subjectOfQualificationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SubjectOfQualification, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SubjectOfQualification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SubjectOfQualification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((SubjectOfQualification)this));
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
		Map<String, Function<SubjectOfQualification, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SubjectOfQualification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SubjectOfQualification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((SubjectOfQualification)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SubjectOfQualification>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _subjectOfQualificationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _description;
	private String _code;
	private String _subjectOfQualification;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<SubjectOfQualification, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((SubjectOfQualification)this);
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
			"subjectOfQualificationId", _subjectOfQualificationId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("code_", _code);
		_columnOriginalValues.put(
			"subjectOfQualification", _subjectOfQualification);
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

		columnBitmasks.put("subjectOfQualificationId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("description", 128L);

		columnBitmasks.put("code_", 256L);

		columnBitmasks.put("subjectOfQualification", 512L);

		columnBitmasks.put("deleted", 1024L);

		columnBitmasks.put("status", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private SubjectOfQualification _escapedModel;

}