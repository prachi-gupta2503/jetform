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

import com.adjecti.mdm.liferay.model.PayHead;
import com.adjecti.mdm.liferay.model.PayHeadModel;
import com.adjecti.mdm.liferay.model.PayHeadSoap;

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
 * The base model implementation for the PayHead service. Represents a row in the &quot;mdm_PayHead&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PayHeadModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PayHeadImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayHeadImpl
 * @generated
 */
@JSON(strict = true)
public class PayHeadModelImpl
	extends BaseModelImpl<PayHead> implements PayHeadModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a pay head model instance should use the <code>PayHead</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_PayHead";

	public static final Object[][] TABLE_COLUMNS = {
		{"payHeadId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"active_", Types.BOOLEAN},
		{"code_", Types.VARCHAR}, {"disbursePeriod", Types.INTEGER},
		{"fromDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"nonTaxable", Types.BOOLEAN}, {"toDate", Types.TIMESTAMP},
		{"headTypeId", Types.BIGINT}, {"deleted", Types.BOOLEAN},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("payHeadId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("disbursePeriod", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("fromDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nonTaxable", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("toDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("headTypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_PayHead (payHeadId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,active_ BOOLEAN,code_ VARCHAR(75) null,disbursePeriod INTEGER,fromDate DATE null,name VARCHAR(75) null,nonTaxable BOOLEAN,toDate DATE null,headTypeId LONG,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table mdm_PayHead";

	public static final String ORDER_BY_JPQL =
		" ORDER BY payHead.payHeadId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_PayHead.payHeadId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long PAYHEADID_COLUMN_BITMASK = 1L;

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
	public static PayHead toModel(PayHeadSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PayHead model = new PayHeadImpl();

		model.setPayHeadId(soapModel.getPayHeadId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActive(soapModel.isActive());
		model.setCode(soapModel.getCode());
		model.setDisbursePeriod(soapModel.getDisbursePeriod());
		model.setFromDate(soapModel.getFromDate());
		model.setName(soapModel.getName());
		model.setNonTaxable(soapModel.isNonTaxable());
		model.setToDate(soapModel.getToDate());
		model.setHeadTypeId(soapModel.getHeadTypeId());
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
	public static List<PayHead> toModels(PayHeadSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PayHead> models = new ArrayList<PayHead>(soapModels.length);

		for (PayHeadSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PayHeadModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _payHeadId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPayHeadId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _payHeadId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PayHead.class;
	}

	@Override
	public String getModelClassName() {
		return PayHead.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PayHead, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PayHead, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PayHead, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((PayHead)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PayHead, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PayHead, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PayHead)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PayHead, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PayHead, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PayHead>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PayHead.class.getClassLoader(), PayHead.class, ModelWrapper.class);

		try {
			Constructor<PayHead> constructor =
				(Constructor<PayHead>)proxyClass.getConstructor(
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

	private static final Map<String, Function<PayHead, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PayHead, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PayHead, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<PayHead, Object>>();
		Map<String, BiConsumer<PayHead, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<PayHead, ?>>();

		attributeGetterFunctions.put("payHeadId", PayHead::getPayHeadId);
		attributeSetterBiConsumers.put(
			"payHeadId", (BiConsumer<PayHead, Long>)PayHead::setPayHeadId);
		attributeGetterFunctions.put("groupId", PayHead::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<PayHead, Long>)PayHead::setGroupId);
		attributeGetterFunctions.put("companyId", PayHead::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<PayHead, Long>)PayHead::setCompanyId);
		attributeGetterFunctions.put("userId", PayHead::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<PayHead, Long>)PayHead::setUserId);
		attributeGetterFunctions.put("userName", PayHead::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<PayHead, String>)PayHead::setUserName);
		attributeGetterFunctions.put("createDate", PayHead::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<PayHead, Date>)PayHead::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", PayHead::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<PayHead, Date>)PayHead::setModifiedDate);
		attributeGetterFunctions.put("active", PayHead::getActive);
		attributeSetterBiConsumers.put(
			"active", (BiConsumer<PayHead, Boolean>)PayHead::setActive);
		attributeGetterFunctions.put("code", PayHead::getCode);
		attributeSetterBiConsumers.put(
			"code", (BiConsumer<PayHead, String>)PayHead::setCode);
		attributeGetterFunctions.put(
			"disbursePeriod", PayHead::getDisbursePeriod);
		attributeSetterBiConsumers.put(
			"disbursePeriod",
			(BiConsumer<PayHead, Integer>)PayHead::setDisbursePeriod);
		attributeGetterFunctions.put("fromDate", PayHead::getFromDate);
		attributeSetterBiConsumers.put(
			"fromDate", (BiConsumer<PayHead, Date>)PayHead::setFromDate);
		attributeGetterFunctions.put("name", PayHead::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<PayHead, String>)PayHead::setName);
		attributeGetterFunctions.put("nonTaxable", PayHead::getNonTaxable);
		attributeSetterBiConsumers.put(
			"nonTaxable", (BiConsumer<PayHead, Boolean>)PayHead::setNonTaxable);
		attributeGetterFunctions.put("toDate", PayHead::getToDate);
		attributeSetterBiConsumers.put(
			"toDate", (BiConsumer<PayHead, Date>)PayHead::setToDate);
		attributeGetterFunctions.put("headTypeId", PayHead::getHeadTypeId);
		attributeSetterBiConsumers.put(
			"headTypeId", (BiConsumer<PayHead, Long>)PayHead::setHeadTypeId);
		attributeGetterFunctions.put("deleted", PayHead::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted", (BiConsumer<PayHead, Boolean>)PayHead::setDeleted);
		attributeGetterFunctions.put("status", PayHead::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<PayHead, Integer>)PayHead::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getPayHeadId() {
		return _payHeadId;
	}

	@Override
	public void setPayHeadId(long payHeadId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_payHeadId = payHeadId;
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
	public int getDisbursePeriod() {
		return _disbursePeriod;
	}

	@Override
	public void setDisbursePeriod(int disbursePeriod) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_disbursePeriod = disbursePeriod;
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
	public boolean getNonTaxable() {
		return _nonTaxable;
	}

	@JSON
	@Override
	public boolean isNonTaxable() {
		return _nonTaxable;
	}

	@Override
	public void setNonTaxable(boolean nonTaxable) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nonTaxable = nonTaxable;
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

	@JSON
	@Override
	public long getHeadTypeId() {
		return _headTypeId;
	}

	@Override
	public void setHeadTypeId(long headTypeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_headTypeId = headTypeId;
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
			getCompanyId(), PayHead.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PayHead toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PayHead>
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
		PayHeadImpl payHeadImpl = new PayHeadImpl();

		payHeadImpl.setPayHeadId(getPayHeadId());
		payHeadImpl.setGroupId(getGroupId());
		payHeadImpl.setCompanyId(getCompanyId());
		payHeadImpl.setUserId(getUserId());
		payHeadImpl.setUserName(getUserName());
		payHeadImpl.setCreateDate(getCreateDate());
		payHeadImpl.setModifiedDate(getModifiedDate());
		payHeadImpl.setActive(isActive());
		payHeadImpl.setCode(getCode());
		payHeadImpl.setDisbursePeriod(getDisbursePeriod());
		payHeadImpl.setFromDate(getFromDate());
		payHeadImpl.setName(getName());
		payHeadImpl.setNonTaxable(isNonTaxable());
		payHeadImpl.setToDate(getToDate());
		payHeadImpl.setHeadTypeId(getHeadTypeId());
		payHeadImpl.setDeleted(isDeleted());
		payHeadImpl.setStatus(getStatus());

		payHeadImpl.resetOriginalValues();

		return payHeadImpl;
	}

	@Override
	public int compareTo(PayHead payHead) {
		long primaryKey = payHead.getPrimaryKey();

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

		if (!(object instanceof PayHead)) {
			return false;
		}

		PayHead payHead = (PayHead)object;

		long primaryKey = payHead.getPrimaryKey();

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
	public CacheModel<PayHead> toCacheModel() {
		PayHeadCacheModel payHeadCacheModel = new PayHeadCacheModel();

		payHeadCacheModel.payHeadId = getPayHeadId();

		payHeadCacheModel.groupId = getGroupId();

		payHeadCacheModel.companyId = getCompanyId();

		payHeadCacheModel.userId = getUserId();

		payHeadCacheModel.userName = getUserName();

		String userName = payHeadCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			payHeadCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			payHeadCacheModel.createDate = createDate.getTime();
		}
		else {
			payHeadCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			payHeadCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			payHeadCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		payHeadCacheModel.active = isActive();

		payHeadCacheModel.code = getCode();

		String code = payHeadCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			payHeadCacheModel.code = null;
		}

		payHeadCacheModel.disbursePeriod = getDisbursePeriod();

		Date fromDate = getFromDate();

		if (fromDate != null) {
			payHeadCacheModel.fromDate = fromDate.getTime();
		}
		else {
			payHeadCacheModel.fromDate = Long.MIN_VALUE;
		}

		payHeadCacheModel.name = getName();

		String name = payHeadCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			payHeadCacheModel.name = null;
		}

		payHeadCacheModel.nonTaxable = isNonTaxable();

		Date toDate = getToDate();

		if (toDate != null) {
			payHeadCacheModel.toDate = toDate.getTime();
		}
		else {
			payHeadCacheModel.toDate = Long.MIN_VALUE;
		}

		payHeadCacheModel.headTypeId = getHeadTypeId();

		payHeadCacheModel.deleted = isDeleted();

		payHeadCacheModel.status = getStatus();

		return payHeadCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PayHead, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PayHead, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PayHead, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PayHead)this));
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
		Map<String, Function<PayHead, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PayHead, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PayHead, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PayHead)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PayHead>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _payHeadId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _active;
	private String _code;
	private int _disbursePeriod;
	private Date _fromDate;
	private String _name;
	private boolean _nonTaxable;
	private Date _toDate;
	private long _headTypeId;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<PayHead, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((PayHead)this);
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

		_columnOriginalValues.put("payHeadId", _payHeadId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("code_", _code);
		_columnOriginalValues.put("disbursePeriod", _disbursePeriod);
		_columnOriginalValues.put("fromDate", _fromDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("nonTaxable", _nonTaxable);
		_columnOriginalValues.put("toDate", _toDate);
		_columnOriginalValues.put("headTypeId", _headTypeId);
		_columnOriginalValues.put("deleted", _deleted);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("active_", "active");
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

		columnBitmasks.put("payHeadId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("active_", 128L);

		columnBitmasks.put("code_", 256L);

		columnBitmasks.put("disbursePeriod", 512L);

		columnBitmasks.put("fromDate", 1024L);

		columnBitmasks.put("name", 2048L);

		columnBitmasks.put("nonTaxable", 4096L);

		columnBitmasks.put("toDate", 8192L);

		columnBitmasks.put("headTypeId", 16384L);

		columnBitmasks.put("deleted", 32768L);

		columnBitmasks.put("status", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private PayHead _escapedModel;

}