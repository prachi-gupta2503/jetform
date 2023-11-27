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

import com.adjecti.mdm.liferay.model.CadreDesignation;
import com.adjecti.mdm.liferay.model.CadreDesignationModel;
import com.adjecti.mdm.liferay.model.CadreDesignationSoap;

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
 * The base model implementation for the CadreDesignation service. Represents a row in the &quot;mdm_CadreDesignation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CadreDesignationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CadreDesignationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CadreDesignationImpl
 * @generated
 */
@JSON(strict = true)
public class CadreDesignationModelImpl
	extends BaseModelImpl<CadreDesignation> implements CadreDesignationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cadre designation model instance should use the <code>CadreDesignation</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_CadreDesignation";

	public static final Object[][] TABLE_COLUMNS = {
		{"cadreDesignationId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"cadreId", Types.BIGINT},
		{"designationId", Types.BIGINT}, {"rank_", Types.INTEGER},
		{"deleted", Types.BOOLEAN}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("cadreDesignationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("cadreId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("designationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rank_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_CadreDesignation (cadreDesignationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,cadreId LONG,designationId LONG,rank_ INTEGER,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table mdm_CadreDesignation";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cadreDesignation.cadreDesignationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_CadreDesignation.cadreDesignationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CADREID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long DESIGNATIONID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CADREDESIGNATIONID_COLUMN_BITMASK = 4L;

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
	public static CadreDesignation toModel(CadreDesignationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CadreDesignation model = new CadreDesignationImpl();

		model.setCadreDesignationId(soapModel.getCadreDesignationId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCadreId(soapModel.getCadreId());
		model.setDesignationId(soapModel.getDesignationId());
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
	public static List<CadreDesignation> toModels(
		CadreDesignationSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CadreDesignation> models = new ArrayList<CadreDesignation>(
			soapModels.length);

		for (CadreDesignationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CadreDesignationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cadreDesignationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCadreDesignationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cadreDesignationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CadreDesignation.class;
	}

	@Override
	public String getModelClassName() {
		return CadreDesignation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CadreDesignation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CadreDesignation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CadreDesignation, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CadreDesignation)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CadreDesignation, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CadreDesignation, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CadreDesignation)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CadreDesignation, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CadreDesignation, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CadreDesignation>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CadreDesignation.class.getClassLoader(), CadreDesignation.class,
			ModelWrapper.class);

		try {
			Constructor<CadreDesignation> constructor =
				(Constructor<CadreDesignation>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CadreDesignation, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CadreDesignation, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CadreDesignation, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CadreDesignation, Object>>();
		Map<String, BiConsumer<CadreDesignation, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CadreDesignation, ?>>();

		attributeGetterFunctions.put(
			"cadreDesignationId", CadreDesignation::getCadreDesignationId);
		attributeSetterBiConsumers.put(
			"cadreDesignationId",
			(BiConsumer<CadreDesignation, Long>)
				CadreDesignation::setCadreDesignationId);
		attributeGetterFunctions.put("groupId", CadreDesignation::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CadreDesignation, Long>)CadreDesignation::setGroupId);
		attributeGetterFunctions.put(
			"companyId", CadreDesignation::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CadreDesignation, Long>)CadreDesignation::setCompanyId);
		attributeGetterFunctions.put("userId", CadreDesignation::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CadreDesignation, Long>)CadreDesignation::setUserId);
		attributeGetterFunctions.put("userName", CadreDesignation::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CadreDesignation, String>)
				CadreDesignation::setUserName);
		attributeGetterFunctions.put(
			"createDate", CadreDesignation::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CadreDesignation, Date>)
				CadreDesignation::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CadreDesignation::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CadreDesignation, Date>)
				CadreDesignation::setModifiedDate);
		attributeGetterFunctions.put("cadreId", CadreDesignation::getCadreId);
		attributeSetterBiConsumers.put(
			"cadreId",
			(BiConsumer<CadreDesignation, Long>)CadreDesignation::setCadreId);
		attributeGetterFunctions.put(
			"designationId", CadreDesignation::getDesignationId);
		attributeSetterBiConsumers.put(
			"designationId",
			(BiConsumer<CadreDesignation, Long>)
				CadreDesignation::setDesignationId);
		attributeGetterFunctions.put("rank", CadreDesignation::getRank);
		attributeSetterBiConsumers.put(
			"rank",
			(BiConsumer<CadreDesignation, Integer>)CadreDesignation::setRank);
		attributeGetterFunctions.put("deleted", CadreDesignation::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<CadreDesignation, Boolean>)
				CadreDesignation::setDeleted);
		attributeGetterFunctions.put("status", CadreDesignation::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<CadreDesignation, Integer>)CadreDesignation::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCadreDesignationId() {
		return _cadreDesignationId;
	}

	@Override
	public void setCadreDesignationId(long cadreDesignationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cadreDesignationId = cadreDesignationId;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCadreId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("cadreId"));
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
			getCompanyId(), CadreDesignation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CadreDesignation toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CadreDesignation>
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
		CadreDesignationImpl cadreDesignationImpl = new CadreDesignationImpl();

		cadreDesignationImpl.setCadreDesignationId(getCadreDesignationId());
		cadreDesignationImpl.setGroupId(getGroupId());
		cadreDesignationImpl.setCompanyId(getCompanyId());
		cadreDesignationImpl.setUserId(getUserId());
		cadreDesignationImpl.setUserName(getUserName());
		cadreDesignationImpl.setCreateDate(getCreateDate());
		cadreDesignationImpl.setModifiedDate(getModifiedDate());
		cadreDesignationImpl.setCadreId(getCadreId());
		cadreDesignationImpl.setDesignationId(getDesignationId());
		cadreDesignationImpl.setRank(getRank());
		cadreDesignationImpl.setDeleted(isDeleted());
		cadreDesignationImpl.setStatus(getStatus());

		cadreDesignationImpl.resetOriginalValues();

		return cadreDesignationImpl;
	}

	@Override
	public int compareTo(CadreDesignation cadreDesignation) {
		long primaryKey = cadreDesignation.getPrimaryKey();

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

		if (!(object instanceof CadreDesignation)) {
			return false;
		}

		CadreDesignation cadreDesignation = (CadreDesignation)object;

		long primaryKey = cadreDesignation.getPrimaryKey();

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
	public CacheModel<CadreDesignation> toCacheModel() {
		CadreDesignationCacheModel cadreDesignationCacheModel =
			new CadreDesignationCacheModel();

		cadreDesignationCacheModel.cadreDesignationId = getCadreDesignationId();

		cadreDesignationCacheModel.groupId = getGroupId();

		cadreDesignationCacheModel.companyId = getCompanyId();

		cadreDesignationCacheModel.userId = getUserId();

		cadreDesignationCacheModel.userName = getUserName();

		String userName = cadreDesignationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cadreDesignationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cadreDesignationCacheModel.createDate = createDate.getTime();
		}
		else {
			cadreDesignationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cadreDesignationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cadreDesignationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cadreDesignationCacheModel.cadreId = getCadreId();

		cadreDesignationCacheModel.designationId = getDesignationId();

		cadreDesignationCacheModel.rank = getRank();

		cadreDesignationCacheModel.deleted = isDeleted();

		cadreDesignationCacheModel.status = getStatus();

		return cadreDesignationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CadreDesignation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CadreDesignation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CadreDesignation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CadreDesignation)this));
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
		Map<String, Function<CadreDesignation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CadreDesignation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CadreDesignation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CadreDesignation)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CadreDesignation>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _cadreDesignationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _cadreId;
	private long _designationId;
	private int _rank;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CadreDesignation, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CadreDesignation)this);
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

		_columnOriginalValues.put("cadreDesignationId", _cadreDesignationId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("cadreId", _cadreId);
		_columnOriginalValues.put("designationId", _designationId);
		_columnOriginalValues.put("rank_", _rank);
		_columnOriginalValues.put("deleted", _deleted);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

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

		columnBitmasks.put("cadreDesignationId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("cadreId", 128L);

		columnBitmasks.put("designationId", 256L);

		columnBitmasks.put("rank_", 512L);

		columnBitmasks.put("deleted", 1024L);

		columnBitmasks.put("status", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CadreDesignation _escapedModel;

}