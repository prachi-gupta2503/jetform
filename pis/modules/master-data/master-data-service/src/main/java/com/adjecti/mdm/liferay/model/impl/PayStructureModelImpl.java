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

import com.adjecti.mdm.liferay.model.PayStructure;
import com.adjecti.mdm.liferay.model.PayStructureModel;
import com.adjecti.mdm.liferay.model.PayStructureSoap;

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
 * The base model implementation for the PayStructure service. Represents a row in the &quot;mdm_PayStructure&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PayStructureModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PayStructureImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayStructureImpl
 * @generated
 */
@JSON(strict = true)
public class PayStructureModelImpl
	extends BaseModelImpl<PayStructure> implements PayStructureModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a pay structure model instance should use the <code>PayStructure</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_PayStructure";

	public static final Object[][] TABLE_COLUMNS = {
		{"payStructureId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"active_", Types.BOOLEAN},
		{"currency_", Types.VARCHAR}, {"effectiveDate", Types.TIMESTAMP},
		{"expiryDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"deleted", Types.BOOLEAN}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("payStructureId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("currency_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("effectiveDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("expiryDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_PayStructure (payStructureId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,active_ BOOLEAN,currency_ VARCHAR(75) null,effectiveDate DATE null,expiryDate DATE null,name VARCHAR(75) null,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table mdm_PayStructure";

	public static final String ORDER_BY_JPQL =
		" ORDER BY payStructure.payStructureId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_PayStructure.payStructureId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long PAYSTRUCTUREID_COLUMN_BITMASK = 1L;

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
	public static PayStructure toModel(PayStructureSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PayStructure model = new PayStructureImpl();

		model.setPayStructureId(soapModel.getPayStructureId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActive(soapModel.isActive());
		model.setCurrency(soapModel.getCurrency());
		model.setEffectiveDate(soapModel.getEffectiveDate());
		model.setExpiryDate(soapModel.getExpiryDate());
		model.setName(soapModel.getName());
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
	public static List<PayStructure> toModels(PayStructureSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PayStructure> models = new ArrayList<PayStructure>(
			soapModels.length);

		for (PayStructureSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PayStructureModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _payStructureId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPayStructureId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _payStructureId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PayStructure.class;
	}

	@Override
	public String getModelClassName() {
		return PayStructure.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PayStructure, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PayStructure, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PayStructure, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((PayStructure)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PayStructure, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PayStructure, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PayStructure)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PayStructure, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PayStructure, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PayStructure>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PayStructure.class.getClassLoader(), PayStructure.class,
			ModelWrapper.class);

		try {
			Constructor<PayStructure> constructor =
				(Constructor<PayStructure>)proxyClass.getConstructor(
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

	private static final Map<String, Function<PayStructure, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PayStructure, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PayStructure, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<PayStructure, Object>>();
		Map<String, BiConsumer<PayStructure, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<PayStructure, ?>>();

		attributeGetterFunctions.put(
			"payStructureId", PayStructure::getPayStructureId);
		attributeSetterBiConsumers.put(
			"payStructureId",
			(BiConsumer<PayStructure, Long>)PayStructure::setPayStructureId);
		attributeGetterFunctions.put("groupId", PayStructure::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<PayStructure, Long>)PayStructure::setGroupId);
		attributeGetterFunctions.put("companyId", PayStructure::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<PayStructure, Long>)PayStructure::setCompanyId);
		attributeGetterFunctions.put("userId", PayStructure::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<PayStructure, Long>)PayStructure::setUserId);
		attributeGetterFunctions.put("userName", PayStructure::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<PayStructure, String>)PayStructure::setUserName);
		attributeGetterFunctions.put("createDate", PayStructure::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<PayStructure, Date>)PayStructure::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", PayStructure::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<PayStructure, Date>)PayStructure::setModifiedDate);
		attributeGetterFunctions.put("active", PayStructure::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<PayStructure, Boolean>)PayStructure::setActive);
		attributeGetterFunctions.put("currency", PayStructure::getCurrency);
		attributeSetterBiConsumers.put(
			"currency",
			(BiConsumer<PayStructure, String>)PayStructure::setCurrency);
		attributeGetterFunctions.put(
			"effectiveDate", PayStructure::getEffectiveDate);
		attributeSetterBiConsumers.put(
			"effectiveDate",
			(BiConsumer<PayStructure, Date>)PayStructure::setEffectiveDate);
		attributeGetterFunctions.put("expiryDate", PayStructure::getExpiryDate);
		attributeSetterBiConsumers.put(
			"expiryDate",
			(BiConsumer<PayStructure, Date>)PayStructure::setExpiryDate);
		attributeGetterFunctions.put("name", PayStructure::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<PayStructure, String>)PayStructure::setName);
		attributeGetterFunctions.put("deleted", PayStructure::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<PayStructure, Boolean>)PayStructure::setDeleted);
		attributeGetterFunctions.put("status", PayStructure::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<PayStructure, Integer>)PayStructure::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getPayStructureId() {
		return _payStructureId;
	}

	@Override
	public void setPayStructureId(long payStructureId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_payStructureId = payStructureId;
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
	public String getCurrency() {
		if (_currency == null) {
			return "";
		}
		else {
			return _currency;
		}
	}

	@Override
	public void setCurrency(String currency) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_currency = currency;
	}

	@JSON
	@Override
	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	@Override
	public void setEffectiveDate(Date effectiveDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_effectiveDate = effectiveDate;
	}

	@JSON
	@Override
	public Date getExpiryDate() {
		return _expiryDate;
	}

	@Override
	public void setExpiryDate(Date expiryDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_expiryDate = expiryDate;
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
			getCompanyId(), PayStructure.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PayStructure toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PayStructure>
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
		PayStructureImpl payStructureImpl = new PayStructureImpl();

		payStructureImpl.setPayStructureId(getPayStructureId());
		payStructureImpl.setGroupId(getGroupId());
		payStructureImpl.setCompanyId(getCompanyId());
		payStructureImpl.setUserId(getUserId());
		payStructureImpl.setUserName(getUserName());
		payStructureImpl.setCreateDate(getCreateDate());
		payStructureImpl.setModifiedDate(getModifiedDate());
		payStructureImpl.setActive(isActive());
		payStructureImpl.setCurrency(getCurrency());
		payStructureImpl.setEffectiveDate(getEffectiveDate());
		payStructureImpl.setExpiryDate(getExpiryDate());
		payStructureImpl.setName(getName());
		payStructureImpl.setDeleted(isDeleted());
		payStructureImpl.setStatus(getStatus());

		payStructureImpl.resetOriginalValues();

		return payStructureImpl;
	}

	@Override
	public int compareTo(PayStructure payStructure) {
		long primaryKey = payStructure.getPrimaryKey();

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

		if (!(object instanceof PayStructure)) {
			return false;
		}

		PayStructure payStructure = (PayStructure)object;

		long primaryKey = payStructure.getPrimaryKey();

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
	public CacheModel<PayStructure> toCacheModel() {
		PayStructureCacheModel payStructureCacheModel =
			new PayStructureCacheModel();

		payStructureCacheModel.payStructureId = getPayStructureId();

		payStructureCacheModel.groupId = getGroupId();

		payStructureCacheModel.companyId = getCompanyId();

		payStructureCacheModel.userId = getUserId();

		payStructureCacheModel.userName = getUserName();

		String userName = payStructureCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			payStructureCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			payStructureCacheModel.createDate = createDate.getTime();
		}
		else {
			payStructureCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			payStructureCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			payStructureCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		payStructureCacheModel.active = isActive();

		payStructureCacheModel.currency = getCurrency();

		String currency = payStructureCacheModel.currency;

		if ((currency != null) && (currency.length() == 0)) {
			payStructureCacheModel.currency = null;
		}

		Date effectiveDate = getEffectiveDate();

		if (effectiveDate != null) {
			payStructureCacheModel.effectiveDate = effectiveDate.getTime();
		}
		else {
			payStructureCacheModel.effectiveDate = Long.MIN_VALUE;
		}

		Date expiryDate = getExpiryDate();

		if (expiryDate != null) {
			payStructureCacheModel.expiryDate = expiryDate.getTime();
		}
		else {
			payStructureCacheModel.expiryDate = Long.MIN_VALUE;
		}

		payStructureCacheModel.name = getName();

		String name = payStructureCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			payStructureCacheModel.name = null;
		}

		payStructureCacheModel.deleted = isDeleted();

		payStructureCacheModel.status = getStatus();

		return payStructureCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PayStructure, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PayStructure, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PayStructure, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PayStructure)this));
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
		Map<String, Function<PayStructure, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PayStructure, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PayStructure, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PayStructure)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PayStructure>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _payStructureId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _active;
	private String _currency;
	private Date _effectiveDate;
	private Date _expiryDate;
	private String _name;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<PayStructure, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((PayStructure)this);
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

		_columnOriginalValues.put("payStructureId", _payStructureId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("currency_", _currency);
		_columnOriginalValues.put("effectiveDate", _effectiveDate);
		_columnOriginalValues.put("expiryDate", _expiryDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("deleted", _deleted);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("active_", "active");
		attributeNames.put("currency_", "currency");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("payStructureId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("active_", 128L);

		columnBitmasks.put("currency_", 256L);

		columnBitmasks.put("effectiveDate", 512L);

		columnBitmasks.put("expiryDate", 1024L);

		columnBitmasks.put("name", 2048L);

		columnBitmasks.put("deleted", 4096L);

		columnBitmasks.put("status", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private PayStructure _escapedModel;

}