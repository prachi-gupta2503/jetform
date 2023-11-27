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

import com.adjecti.pis.liferay.model.EmployeeDigitalSignature;
import com.adjecti.pis.liferay.model.EmployeeDigitalSignatureModel;
import com.adjecti.pis.liferay.model.EmployeeDigitalSignatureSoap;

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
 * The base model implementation for the EmployeeDigitalSignature service. Represents a row in the &quot;pis_EmployeeDigitalSignature&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeDigitalSignatureModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeDigitalSignatureImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDigitalSignatureImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeDigitalSignatureModelImpl
	extends BaseModelImpl<EmployeeDigitalSignature>
	implements EmployeeDigitalSignatureModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee digital signature model instance should use the <code>EmployeeDigitalSignature</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_EmployeeDigitalSignature";

	public static final Object[][] TABLE_COLUMNS = {
		{"employeeDigitalSignatureId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"employeeId", Types.BIGINT},
		{"cid", Types.VARCHAR}, {"details", Types.VARCHAR},
		{"issueDate", Types.TIMESTAMP}, {"revokeDate", Types.TIMESTAMP},
		{"revoked", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeeDigitalSignatureId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("details", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("issueDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("revokeDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("revoked", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_EmployeeDigitalSignature (employeeDigitalSignatureId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,employeeId LONG,cid VARCHAR(75) null,details VARCHAR(75) null,issueDate DATE null,revokeDate DATE null,revoked BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table pis_EmployeeDigitalSignature";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeeDigitalSignature.employeeDigitalSignatureId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_EmployeeDigitalSignature.employeeDigitalSignatureId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEDIGITALSIGNATUREID_COLUMN_BITMASK = 4L;

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
	public static EmployeeDigitalSignature toModel(
		EmployeeDigitalSignatureSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		EmployeeDigitalSignature model = new EmployeeDigitalSignatureImpl();

		model.setEmployeeDigitalSignatureId(
			soapModel.getEmployeeDigitalSignatureId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setCid(soapModel.getCid());
		model.setDetails(soapModel.getDetails());
		model.setIssueDate(soapModel.getIssueDate());
		model.setRevokeDate(soapModel.getRevokeDate());
		model.setRevoked(soapModel.isRevoked());

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
	public static List<EmployeeDigitalSignature> toModels(
		EmployeeDigitalSignatureSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<EmployeeDigitalSignature> models =
			new ArrayList<EmployeeDigitalSignature>(soapModels.length);

		for (EmployeeDigitalSignatureSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeeDigitalSignatureModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeDigitalSignatureId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeDigitalSignatureId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeDigitalSignatureId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeDigitalSignature.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeDigitalSignature.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeeDigitalSignature, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeeDigitalSignature, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeDigitalSignature, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeeDigitalSignature)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeeDigitalSignature, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeeDigitalSignature, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeeDigitalSignature)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeeDigitalSignature, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeeDigitalSignature, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmployeeDigitalSignature>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmployeeDigitalSignature.class.getClassLoader(),
			EmployeeDigitalSignature.class, ModelWrapper.class);

		try {
			Constructor<EmployeeDigitalSignature> constructor =
				(Constructor<EmployeeDigitalSignature>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map<String, Function<EmployeeDigitalSignature, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<EmployeeDigitalSignature, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmployeeDigitalSignature, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<EmployeeDigitalSignature, Object>>();
		Map<String, BiConsumer<EmployeeDigitalSignature, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<EmployeeDigitalSignature, ?>>();

		attributeGetterFunctions.put(
			"employeeDigitalSignatureId",
			EmployeeDigitalSignature::getEmployeeDigitalSignatureId);
		attributeSetterBiConsumers.put(
			"employeeDigitalSignatureId",
			(BiConsumer<EmployeeDigitalSignature, Long>)
				EmployeeDigitalSignature::setEmployeeDigitalSignatureId);
		attributeGetterFunctions.put(
			"groupId", EmployeeDigitalSignature::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EmployeeDigitalSignature, Long>)
				EmployeeDigitalSignature::setGroupId);
		attributeGetterFunctions.put(
			"companyId", EmployeeDigitalSignature::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmployeeDigitalSignature, Long>)
				EmployeeDigitalSignature::setCompanyId);
		attributeGetterFunctions.put(
			"userId", EmployeeDigitalSignature::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EmployeeDigitalSignature, Long>)
				EmployeeDigitalSignature::setUserId);
		attributeGetterFunctions.put(
			"userName", EmployeeDigitalSignature::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmployeeDigitalSignature, String>)
				EmployeeDigitalSignature::setUserName);
		attributeGetterFunctions.put(
			"createDate", EmployeeDigitalSignature::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmployeeDigitalSignature, Date>)
				EmployeeDigitalSignature::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmployeeDigitalSignature::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmployeeDigitalSignature, Date>)
				EmployeeDigitalSignature::setModifiedDate);
		attributeGetterFunctions.put(
			"employeeId", EmployeeDigitalSignature::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<EmployeeDigitalSignature, Long>)
				EmployeeDigitalSignature::setEmployeeId);
		attributeGetterFunctions.put("cid", EmployeeDigitalSignature::getCid);
		attributeSetterBiConsumers.put(
			"cid",
			(BiConsumer<EmployeeDigitalSignature, String>)
				EmployeeDigitalSignature::setCid);
		attributeGetterFunctions.put(
			"details", EmployeeDigitalSignature::getDetails);
		attributeSetterBiConsumers.put(
			"details",
			(BiConsumer<EmployeeDigitalSignature, String>)
				EmployeeDigitalSignature::setDetails);
		attributeGetterFunctions.put(
			"issueDate", EmployeeDigitalSignature::getIssueDate);
		attributeSetterBiConsumers.put(
			"issueDate",
			(BiConsumer<EmployeeDigitalSignature, Date>)
				EmployeeDigitalSignature::setIssueDate);
		attributeGetterFunctions.put(
			"revokeDate", EmployeeDigitalSignature::getRevokeDate);
		attributeSetterBiConsumers.put(
			"revokeDate",
			(BiConsumer<EmployeeDigitalSignature, Date>)
				EmployeeDigitalSignature::setRevokeDate);
		attributeGetterFunctions.put(
			"revoked", EmployeeDigitalSignature::getRevoked);
		attributeSetterBiConsumers.put(
			"revoked",
			(BiConsumer<EmployeeDigitalSignature, Boolean>)
				EmployeeDigitalSignature::setRevoked);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getEmployeeDigitalSignatureId() {
		return _employeeDigitalSignatureId;
	}

	@Override
	public void setEmployeeDigitalSignatureId(long employeeDigitalSignatureId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeDigitalSignatureId = employeeDigitalSignatureId;
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
	public String getCid() {
		if (_cid == null) {
			return "";
		}
		else {
			return _cid;
		}
	}

	@Override
	public void setCid(String cid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cid = cid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalCid() {
		return getColumnOriginalValue("cid");
	}

	@JSON
	@Override
	public String getDetails() {
		if (_details == null) {
			return "";
		}
		else {
			return _details;
		}
	}

	@Override
	public void setDetails(String details) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_details = details;
	}

	@JSON
	@Override
	public Date getIssueDate() {
		return _issueDate;
	}

	@Override
	public void setIssueDate(Date issueDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_issueDate = issueDate;
	}

	@JSON
	@Override
	public Date getRevokeDate() {
		return _revokeDate;
	}

	@Override
	public void setRevokeDate(Date revokeDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_revokeDate = revokeDate;
	}

	@JSON
	@Override
	public boolean getRevoked() {
		return _revoked;
	}

	@JSON
	@Override
	public boolean isRevoked() {
		return _revoked;
	}

	@Override
	public void setRevoked(boolean revoked) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_revoked = revoked;
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
			getCompanyId(), EmployeeDigitalSignature.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeDigitalSignature toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeeDigitalSignature>
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
		EmployeeDigitalSignatureImpl employeeDigitalSignatureImpl =
			new EmployeeDigitalSignatureImpl();

		employeeDigitalSignatureImpl.setEmployeeDigitalSignatureId(
			getEmployeeDigitalSignatureId());
		employeeDigitalSignatureImpl.setGroupId(getGroupId());
		employeeDigitalSignatureImpl.setCompanyId(getCompanyId());
		employeeDigitalSignatureImpl.setUserId(getUserId());
		employeeDigitalSignatureImpl.setUserName(getUserName());
		employeeDigitalSignatureImpl.setCreateDate(getCreateDate());
		employeeDigitalSignatureImpl.setModifiedDate(getModifiedDate());
		employeeDigitalSignatureImpl.setEmployeeId(getEmployeeId());
		employeeDigitalSignatureImpl.setCid(getCid());
		employeeDigitalSignatureImpl.setDetails(getDetails());
		employeeDigitalSignatureImpl.setIssueDate(getIssueDate());
		employeeDigitalSignatureImpl.setRevokeDate(getRevokeDate());
		employeeDigitalSignatureImpl.setRevoked(isRevoked());

		employeeDigitalSignatureImpl.resetOriginalValues();

		return employeeDigitalSignatureImpl;
	}

	@Override
	public int compareTo(EmployeeDigitalSignature employeeDigitalSignature) {
		long primaryKey = employeeDigitalSignature.getPrimaryKey();

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

		if (!(object instanceof EmployeeDigitalSignature)) {
			return false;
		}

		EmployeeDigitalSignature employeeDigitalSignature =
			(EmployeeDigitalSignature)object;

		long primaryKey = employeeDigitalSignature.getPrimaryKey();

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
	public CacheModel<EmployeeDigitalSignature> toCacheModel() {
		EmployeeDigitalSignatureCacheModel employeeDigitalSignatureCacheModel =
			new EmployeeDigitalSignatureCacheModel();

		employeeDigitalSignatureCacheModel.employeeDigitalSignatureId =
			getEmployeeDigitalSignatureId();

		employeeDigitalSignatureCacheModel.groupId = getGroupId();

		employeeDigitalSignatureCacheModel.companyId = getCompanyId();

		employeeDigitalSignatureCacheModel.userId = getUserId();

		employeeDigitalSignatureCacheModel.userName = getUserName();

		String userName = employeeDigitalSignatureCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeeDigitalSignatureCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeDigitalSignatureCacheModel.createDate =
				createDate.getTime();
		}
		else {
			employeeDigitalSignatureCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeDigitalSignatureCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			employeeDigitalSignatureCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeeDigitalSignatureCacheModel.employeeId = getEmployeeId();

		employeeDigitalSignatureCacheModel.cid = getCid();

		String cid = employeeDigitalSignatureCacheModel.cid;

		if ((cid != null) && (cid.length() == 0)) {
			employeeDigitalSignatureCacheModel.cid = null;
		}

		employeeDigitalSignatureCacheModel.details = getDetails();

		String details = employeeDigitalSignatureCacheModel.details;

		if ((details != null) && (details.length() == 0)) {
			employeeDigitalSignatureCacheModel.details = null;
		}

		Date issueDate = getIssueDate();

		if (issueDate != null) {
			employeeDigitalSignatureCacheModel.issueDate = issueDate.getTime();
		}
		else {
			employeeDigitalSignatureCacheModel.issueDate = Long.MIN_VALUE;
		}

		Date revokeDate = getRevokeDate();

		if (revokeDate != null) {
			employeeDigitalSignatureCacheModel.revokeDate =
				revokeDate.getTime();
		}
		else {
			employeeDigitalSignatureCacheModel.revokeDate = Long.MIN_VALUE;
		}

		employeeDigitalSignatureCacheModel.revoked = isRevoked();

		return employeeDigitalSignatureCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeeDigitalSignature, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeeDigitalSignature, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeDigitalSignature, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((EmployeeDigitalSignature)this));
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
		Map<String, Function<EmployeeDigitalSignature, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeeDigitalSignature, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeDigitalSignature, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((EmployeeDigitalSignature)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, EmployeeDigitalSignature>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _employeeDigitalSignatureId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _employeeId;
	private String _cid;
	private String _details;
	private Date _issueDate;
	private Date _revokeDate;
	private boolean _revoked;

	public <T> T getColumnValue(String columnName) {
		Function<EmployeeDigitalSignature, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeeDigitalSignature)this);
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
			"employeeDigitalSignatureId", _employeeDigitalSignatureId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("cid", _cid);
		_columnOriginalValues.put("details", _details);
		_columnOriginalValues.put("issueDate", _issueDate);
		_columnOriginalValues.put("revokeDate", _revokeDate);
		_columnOriginalValues.put("revoked", _revoked);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("employeeDigitalSignatureId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("employeeId", 128L);

		columnBitmasks.put("cid", 256L);

		columnBitmasks.put("details", 512L);

		columnBitmasks.put("issueDate", 1024L);

		columnBitmasks.put("revokeDate", 2048L);

		columnBitmasks.put("revoked", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeeDigitalSignature _escapedModel;

}