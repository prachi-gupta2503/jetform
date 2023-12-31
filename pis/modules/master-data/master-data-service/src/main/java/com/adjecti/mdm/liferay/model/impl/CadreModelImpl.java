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

import com.adjecti.mdm.liferay.model.Cadre;
import com.adjecti.mdm.liferay.model.CadreModel;
import com.adjecti.mdm.liferay.model.CadreSoap;

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
 * The base model implementation for the Cadre service. Represents a row in the &quot;mdm_Cadre&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CadreModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CadreImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CadreImpl
 * @generated
 */
@JSON(strict = true)
public class CadreModelImpl extends BaseModelImpl<Cadre> implements CadreModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cadre model instance should use the <code>Cadre</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_Cadre";

	public static final Object[][] TABLE_COLUMNS = {
		{"cadreId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"code_", Types.VARCHAR},
		{"name", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"designationGroupId", Types.BIGINT}, {"rank_", Types.INTEGER},
		{"deleted", Types.BOOLEAN}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("cadreId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("designationGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rank_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_Cadre (cadreId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,code_ VARCHAR(75) null,name VARCHAR(75) null,description VARCHAR(75) null,designationGroupId LONG,rank_ INTEGER,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table mdm_Cadre";

	public static final String ORDER_BY_JPQL = " ORDER BY cadre.name ASC";

	public static final String ORDER_BY_SQL = " ORDER BY mdm_Cadre.name ASC";

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
	public static Cadre toModel(CadreSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Cadre model = new CadreImpl();

		model.setCadreId(soapModel.getCadreId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCode(soapModel.getCode());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setDesignationGroupId(soapModel.getDesignationGroupId());
		model.setRank(soapModel.getRank());
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
	public static List<Cadre> toModels(CadreSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Cadre> models = new ArrayList<Cadre>(soapModels.length);

		for (CadreSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CadreModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cadreId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCadreId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cadreId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Cadre.class;
	}

	@Override
	public String getModelClassName() {
		return Cadre.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Cadre, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Cadre, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Cadre, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Cadre)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Cadre, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Cadre, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Cadre)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Cadre, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Cadre, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Cadre>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Cadre.class.getClassLoader(), Cadre.class, ModelWrapper.class);

		try {
			Constructor<Cadre> constructor =
				(Constructor<Cadre>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Cadre, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Cadre, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Cadre, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Cadre, Object>>();
		Map<String, BiConsumer<Cadre, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Cadre, ?>>();

		attributeGetterFunctions.put("cadreId", Cadre::getCadreId);
		attributeSetterBiConsumers.put(
			"cadreId", (BiConsumer<Cadre, Long>)Cadre::setCadreId);
		attributeGetterFunctions.put("groupId", Cadre::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Cadre, Long>)Cadre::setGroupId);
		attributeGetterFunctions.put("companyId", Cadre::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Cadre, Long>)Cadre::setCompanyId);
		attributeGetterFunctions.put("userId", Cadre::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Cadre, Long>)Cadre::setUserId);
		attributeGetterFunctions.put("userName", Cadre::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Cadre, String>)Cadre::setUserName);
		attributeGetterFunctions.put("createDate", Cadre::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Cadre, Date>)Cadre::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Cadre::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Cadre, Date>)Cadre::setModifiedDate);
		attributeGetterFunctions.put("code", Cadre::getCode);
		attributeSetterBiConsumers.put(
			"code", (BiConsumer<Cadre, String>)Cadre::setCode);
		attributeGetterFunctions.put("name", Cadre::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Cadre, String>)Cadre::setName);
		attributeGetterFunctions.put("description", Cadre::getDescription);
		attributeSetterBiConsumers.put(
			"description", (BiConsumer<Cadre, String>)Cadre::setDescription);
		attributeGetterFunctions.put(
			"designationGroupId", Cadre::getDesignationGroupId);
		attributeSetterBiConsumers.put(
			"designationGroupId",
			(BiConsumer<Cadre, Long>)Cadre::setDesignationGroupId);
		attributeGetterFunctions.put("rank", Cadre::getRank);
		attributeSetterBiConsumers.put(
			"rank", (BiConsumer<Cadre, Integer>)Cadre::setRank);
		attributeGetterFunctions.put("deleted", Cadre::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted", (BiConsumer<Cadre, Boolean>)Cadre::setDeleted);
		attributeGetterFunctions.put("status", Cadre::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Cadre, Integer>)Cadre::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCadreId() {
		return _cadreId;
	}

	@Override
	public void setCadreId(long cadreId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cadreId = cadreId;
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
	public long getDesignationGroupId() {
		return _designationGroupId;
	}

	@Override
	public void setDesignationGroupId(long designationGroupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_designationGroupId = designationGroupId;
	}

	@JSON
	@Override
	public int getRank() {
		return _rank;
	}

	@Override
	public void setRank(int rank) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_rank = rank;
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
			getCompanyId(), Cadre.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Cadre toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Cadre>
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
		CadreImpl cadreImpl = new CadreImpl();

		cadreImpl.setCadreId(getCadreId());
		cadreImpl.setGroupId(getGroupId());
		cadreImpl.setCompanyId(getCompanyId());
		cadreImpl.setUserId(getUserId());
		cadreImpl.setUserName(getUserName());
		cadreImpl.setCreateDate(getCreateDate());
		cadreImpl.setModifiedDate(getModifiedDate());
		cadreImpl.setCode(getCode());
		cadreImpl.setName(getName());
		cadreImpl.setDescription(getDescription());
		cadreImpl.setDesignationGroupId(getDesignationGroupId());
		cadreImpl.setRank(getRank());
		cadreImpl.setDeleted(isDeleted());
		cadreImpl.setStatus(getStatus());

		cadreImpl.resetOriginalValues();

		return cadreImpl;
	}

	@Override
	public int compareTo(Cadre cadre) {
		int value = 0;

		value = getName().compareTo(cadre.getName());

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

		if (!(object instanceof Cadre)) {
			return false;
		}

		Cadre cadre = (Cadre)object;

		long primaryKey = cadre.getPrimaryKey();

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
	public CacheModel<Cadre> toCacheModel() {
		CadreCacheModel cadreCacheModel = new CadreCacheModel();

		cadreCacheModel.cadreId = getCadreId();

		cadreCacheModel.groupId = getGroupId();

		cadreCacheModel.companyId = getCompanyId();

		cadreCacheModel.userId = getUserId();

		cadreCacheModel.userName = getUserName();

		String userName = cadreCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cadreCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cadreCacheModel.createDate = createDate.getTime();
		}
		else {
			cadreCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cadreCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cadreCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cadreCacheModel.code = getCode();

		String code = cadreCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			cadreCacheModel.code = null;
		}

		cadreCacheModel.name = getName();

		String name = cadreCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			cadreCacheModel.name = null;
		}

		cadreCacheModel.description = getDescription();

		String description = cadreCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			cadreCacheModel.description = null;
		}

		cadreCacheModel.designationGroupId = getDesignationGroupId();

		cadreCacheModel.rank = getRank();

		cadreCacheModel.deleted = isDeleted();

		cadreCacheModel.status = getStatus();

		return cadreCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Cadre, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Cadre, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Cadre, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Cadre)this));
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
		Map<String, Function<Cadre, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Cadre, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Cadre, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Cadre)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Cadre>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _cadreId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _code;
	private String _name;
	private String _description;
	private long _designationGroupId;
	private int _rank;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Cadre, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Cadre)this);
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

		_columnOriginalValues.put("cadreId", _cadreId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("code_", _code);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("designationGroupId", _designationGroupId);
		_columnOriginalValues.put("rank_", _rank);
		_columnOriginalValues.put("deleted", _deleted);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("code_", "code");
		attributeNames.put("rank_", "rank");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("cadreId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("code_", 128L);

		columnBitmasks.put("name", 256L);

		columnBitmasks.put("description", 512L);

		columnBitmasks.put("designationGroupId", 1024L);

		columnBitmasks.put("rank_", 2048L);

		columnBitmasks.put("deleted", 4096L);

		columnBitmasks.put("status", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Cadre _escapedModel;

}