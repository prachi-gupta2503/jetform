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

import com.adjecti.mdm.liferay.model.DesignationScope;
import com.adjecti.mdm.liferay.model.DesignationScopeModel;
import com.adjecti.mdm.liferay.model.DesignationScopeSoap;
import com.adjecti.mdm.liferay.service.persistence.DesignationScopePK;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
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
 * The base model implementation for the DesignationScope service. Represents a row in the &quot;mdm_DesignationScope&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DesignationScopeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DesignationScopeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationScopeImpl
 * @generated
 */
@JSON(strict = true)
public class DesignationScopeModelImpl
	extends BaseModelImpl<DesignationScope> implements DesignationScopeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a designation scope model instance should use the <code>DesignationScope</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_DesignationScope";

	public static final Object[][] TABLE_COLUMNS = {
		{"designationScopeId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"designationId", Types.BIGINT},
		{"scopeType", Types.INTEGER}, {"scopeOrganizationId", Types.BIGINT},
		{"scopeOrganizationTypeId", Types.BIGINT},
		{"scopePostId", Types.BIGINT}, {"deleted", Types.BOOLEAN},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("designationScopeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("designationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("scopeType", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("scopeOrganizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("scopeOrganizationTypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("scopePostId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_DesignationScope (designationScopeId LONG not null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,designationId LONG not null,scopeType INTEGER,scopeOrganizationId LONG,scopeOrganizationTypeId LONG,scopePostId LONG,deleted BOOLEAN,status INTEGER,primary key (designationScopeId, designationId))";

	public static final String TABLE_SQL_DROP =
		"drop table mdm_DesignationScope";

	public static final String ORDER_BY_JPQL =
		" ORDER BY designationScope.id.designationScopeId ASC, designationScope.id.designationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_DesignationScope.designationScopeId ASC, mdm_DesignationScope.designationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long DESIGNATIONID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long DESIGNATIONSCOPEID_COLUMN_BITMASK = 2L;

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
	public static DesignationScope toModel(DesignationScopeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DesignationScope model = new DesignationScopeImpl();

		model.setDesignationScopeId(soapModel.getDesignationScopeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDesignationId(soapModel.getDesignationId());
		model.setScopeType(soapModel.getScopeType());
		model.setScopeOrganizationId(soapModel.getScopeOrganizationId());
		model.setScopeOrganizationTypeId(
			soapModel.getScopeOrganizationTypeId());
		model.setScopePostId(soapModel.getScopePostId());
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
	public static List<DesignationScope> toModels(
		DesignationScopeSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<DesignationScope> models = new ArrayList<DesignationScope>(
			soapModels.length);

		for (DesignationScopeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public DesignationScopeModelImpl() {
	}

	@Override
	public DesignationScopePK getPrimaryKey() {
		return new DesignationScopePK(_designationScopeId, _designationId);
	}

	@Override
	public void setPrimaryKey(DesignationScopePK primaryKey) {
		setDesignationScopeId(primaryKey.designationScopeId);
		setDesignationId(primaryKey.designationId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new DesignationScopePK(_designationScopeId, _designationId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((DesignationScopePK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return DesignationScope.class;
	}

	@Override
	public String getModelClassName() {
		return DesignationScope.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DesignationScope, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DesignationScope, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DesignationScope, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DesignationScope)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DesignationScope, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DesignationScope, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DesignationScope)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DesignationScope, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DesignationScope, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DesignationScope>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DesignationScope.class.getClassLoader(), DesignationScope.class,
			ModelWrapper.class);

		try {
			Constructor<DesignationScope> constructor =
				(Constructor<DesignationScope>)proxyClass.getConstructor(
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

	private static final Map<String, Function<DesignationScope, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DesignationScope, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DesignationScope, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<DesignationScope, Object>>();
		Map<String, BiConsumer<DesignationScope, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<DesignationScope, ?>>();

		attributeGetterFunctions.put(
			"designationScopeId", DesignationScope::getDesignationScopeId);
		attributeSetterBiConsumers.put(
			"designationScopeId",
			(BiConsumer<DesignationScope, Long>)
				DesignationScope::setDesignationScopeId);
		attributeGetterFunctions.put("groupId", DesignationScope::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DesignationScope, Long>)DesignationScope::setGroupId);
		attributeGetterFunctions.put(
			"companyId", DesignationScope::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DesignationScope, Long>)DesignationScope::setCompanyId);
		attributeGetterFunctions.put("userId", DesignationScope::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DesignationScope, Long>)DesignationScope::setUserId);
		attributeGetterFunctions.put("userName", DesignationScope::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DesignationScope, String>)
				DesignationScope::setUserName);
		attributeGetterFunctions.put(
			"createDate", DesignationScope::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DesignationScope, Date>)
				DesignationScope::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", DesignationScope::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DesignationScope, Date>)
				DesignationScope::setModifiedDate);
		attributeGetterFunctions.put(
			"designationId", DesignationScope::getDesignationId);
		attributeSetterBiConsumers.put(
			"designationId",
			(BiConsumer<DesignationScope, Long>)
				DesignationScope::setDesignationId);
		attributeGetterFunctions.put(
			"scopeType", DesignationScope::getScopeType);
		attributeSetterBiConsumers.put(
			"scopeType",
			(BiConsumer<DesignationScope, Integer>)
				DesignationScope::setScopeType);
		attributeGetterFunctions.put(
			"scopeOrganizationId", DesignationScope::getScopeOrganizationId);
		attributeSetterBiConsumers.put(
			"scopeOrganizationId",
			(BiConsumer<DesignationScope, Long>)
				DesignationScope::setScopeOrganizationId);
		attributeGetterFunctions.put(
			"scopeOrganizationTypeId",
			DesignationScope::getScopeOrganizationTypeId);
		attributeSetterBiConsumers.put(
			"scopeOrganizationTypeId",
			(BiConsumer<DesignationScope, Long>)
				DesignationScope::setScopeOrganizationTypeId);
		attributeGetterFunctions.put(
			"scopePostId", DesignationScope::getScopePostId);
		attributeSetterBiConsumers.put(
			"scopePostId",
			(BiConsumer<DesignationScope, Long>)
				DesignationScope::setScopePostId);
		attributeGetterFunctions.put("deleted", DesignationScope::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<DesignationScope, Boolean>)
				DesignationScope::setDeleted);
		attributeGetterFunctions.put("status", DesignationScope::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<DesignationScope, Integer>)DesignationScope::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getDesignationScopeId() {
		return _designationScopeId;
	}

	@Override
	public void setDesignationScopeId(long designationScopeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_designationScopeId = designationScopeId;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDesignationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("designationId"));
	}

	@JSON
	@Override
	public int getScopeType() {
		return _scopeType;
	}

	@Override
	public void setScopeType(int scopeType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_scopeType = scopeType;
	}

	@JSON
	@Override
	public long getScopeOrganizationId() {
		return _scopeOrganizationId;
	}

	@Override
	public void setScopeOrganizationId(long scopeOrganizationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_scopeOrganizationId = scopeOrganizationId;
	}

	@JSON
	@Override
	public long getScopeOrganizationTypeId() {
		return _scopeOrganizationTypeId;
	}

	@Override
	public void setScopeOrganizationTypeId(long scopeOrganizationTypeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_scopeOrganizationTypeId = scopeOrganizationTypeId;
	}

	@JSON
	@Override
	public long getScopePostId() {
		return _scopePostId;
	}

	@Override
	public void setScopePostId(long scopePostId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_scopePostId = scopePostId;
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
	public DesignationScope toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DesignationScope>
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
		DesignationScopeImpl designationScopeImpl = new DesignationScopeImpl();

		designationScopeImpl.setDesignationScopeId(getDesignationScopeId());
		designationScopeImpl.setGroupId(getGroupId());
		designationScopeImpl.setCompanyId(getCompanyId());
		designationScopeImpl.setUserId(getUserId());
		designationScopeImpl.setUserName(getUserName());
		designationScopeImpl.setCreateDate(getCreateDate());
		designationScopeImpl.setModifiedDate(getModifiedDate());
		designationScopeImpl.setDesignationId(getDesignationId());
		designationScopeImpl.setScopeType(getScopeType());
		designationScopeImpl.setScopeOrganizationId(getScopeOrganizationId());
		designationScopeImpl.setScopeOrganizationTypeId(
			getScopeOrganizationTypeId());
		designationScopeImpl.setScopePostId(getScopePostId());
		designationScopeImpl.setDeleted(isDeleted());
		designationScopeImpl.setStatus(getStatus());

		designationScopeImpl.resetOriginalValues();

		return designationScopeImpl;
	}

	@Override
	public int compareTo(DesignationScope designationScope) {
		DesignationScopePK primaryKey = designationScope.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DesignationScope)) {
			return false;
		}

		DesignationScope designationScope = (DesignationScope)object;

		DesignationScopePK primaryKey = designationScope.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
	public CacheModel<DesignationScope> toCacheModel() {
		DesignationScopeCacheModel designationScopeCacheModel =
			new DesignationScopeCacheModel();

		designationScopeCacheModel.designationScopePK = getPrimaryKey();

		designationScopeCacheModel.designationScopeId = getDesignationScopeId();

		designationScopeCacheModel.groupId = getGroupId();

		designationScopeCacheModel.companyId = getCompanyId();

		designationScopeCacheModel.userId = getUserId();

		designationScopeCacheModel.userName = getUserName();

		String userName = designationScopeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			designationScopeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			designationScopeCacheModel.createDate = createDate.getTime();
		}
		else {
			designationScopeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			designationScopeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			designationScopeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		designationScopeCacheModel.designationId = getDesignationId();

		designationScopeCacheModel.scopeType = getScopeType();

		designationScopeCacheModel.scopeOrganizationId =
			getScopeOrganizationId();

		designationScopeCacheModel.scopeOrganizationTypeId =
			getScopeOrganizationTypeId();

		designationScopeCacheModel.scopePostId = getScopePostId();

		designationScopeCacheModel.deleted = isDeleted();

		designationScopeCacheModel.status = getStatus();

		return designationScopeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DesignationScope, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DesignationScope, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DesignationScope, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DesignationScope)this));
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
		Map<String, Function<DesignationScope, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DesignationScope, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DesignationScope, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DesignationScope)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DesignationScope>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _designationScopeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _designationId;
	private int _scopeType;
	private long _scopeOrganizationId;
	private long _scopeOrganizationTypeId;
	private long _scopePostId;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		Function<DesignationScope, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DesignationScope)this);
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

		_columnOriginalValues.put("designationScopeId", _designationScopeId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("designationId", _designationId);
		_columnOriginalValues.put("scopeType", _scopeType);
		_columnOriginalValues.put("scopeOrganizationId", _scopeOrganizationId);
		_columnOriginalValues.put(
			"scopeOrganizationTypeId", _scopeOrganizationTypeId);
		_columnOriginalValues.put("scopePostId", _scopePostId);
		_columnOriginalValues.put("deleted", _deleted);
		_columnOriginalValues.put("status", _status);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("designationScopeId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("designationId", 128L);

		columnBitmasks.put("scopeType", 256L);

		columnBitmasks.put("scopeOrganizationId", 512L);

		columnBitmasks.put("scopeOrganizationTypeId", 1024L);

		columnBitmasks.put("scopePostId", 2048L);

		columnBitmasks.put("deleted", 4096L);

		columnBitmasks.put("status", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DesignationScope _escapedModel;

}