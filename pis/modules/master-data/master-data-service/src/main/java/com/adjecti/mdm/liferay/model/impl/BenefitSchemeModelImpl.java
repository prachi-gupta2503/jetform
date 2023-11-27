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

import com.adjecti.mdm.liferay.model.BenefitScheme;
import com.adjecti.mdm.liferay.model.BenefitSchemeModel;
import com.adjecti.mdm.liferay.model.BenefitSchemeSoap;

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
 * The base model implementation for the BenefitScheme service. Represents a row in the &quot;mdm_BenefitScheme&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>BenefitSchemeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BenefitSchemeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BenefitSchemeImpl
 * @generated
 */
@JSON(strict = true)
public class BenefitSchemeModelImpl
	extends BaseModelImpl<BenefitScheme> implements BenefitSchemeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a benefit scheme model instance should use the <code>BenefitScheme</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_BenefitScheme";

	public static final Object[][] TABLE_COLUMNS = {
		{"benefitSchemeId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"active_", Types.BOOLEAN},
		{"code_", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"effectiveFrom", Types.TIMESTAMP}, {"effectiveRate", Types.FLOAT},
		{"effectiveUpto", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"frequencyId", Types.INTEGER}, {"rateTypeId", Types.INTEGER},
		{"deleted", Types.BOOLEAN}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("benefitSchemeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("effectiveFrom", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("effectiveRate", Types.FLOAT);
		TABLE_COLUMNS_MAP.put("effectiveUpto", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("frequencyId", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("rateTypeId", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_BenefitScheme (benefitSchemeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,active_ BOOLEAN,code_ VARCHAR(75) null,description VARCHAR(75) null,effectiveFrom DATE null,effectiveRate DOUBLE,effectiveUpto DATE null,name VARCHAR(75) null,frequencyId INTEGER,rateTypeId INTEGER,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table mdm_BenefitScheme";

	public static final String ORDER_BY_JPQL =
		" ORDER BY benefitScheme.benefitSchemeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_BenefitScheme.benefitSchemeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long BENEFITSCHEMEID_COLUMN_BITMASK = 1L;

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
	public static BenefitScheme toModel(BenefitSchemeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		BenefitScheme model = new BenefitSchemeImpl();

		model.setBenefitSchemeId(soapModel.getBenefitSchemeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActive(soapModel.isActive());
		model.setCode(soapModel.getCode());
		model.setDescription(soapModel.getDescription());
		model.setEffectiveFrom(soapModel.getEffectiveFrom());
		model.setEffectiveRate(soapModel.getEffectiveRate());
		model.setEffectiveUpto(soapModel.getEffectiveUpto());
		model.setName(soapModel.getName());
		model.setFrequencyId(soapModel.getFrequencyId());
		model.setRateTypeId(soapModel.getRateTypeId());
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
	public static List<BenefitScheme> toModels(BenefitSchemeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<BenefitScheme> models = new ArrayList<BenefitScheme>(
			soapModels.length);

		for (BenefitSchemeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public BenefitSchemeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _benefitSchemeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBenefitSchemeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _benefitSchemeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BenefitScheme.class;
	}

	@Override
	public String getModelClassName() {
		return BenefitScheme.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BenefitScheme, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BenefitScheme, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BenefitScheme, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((BenefitScheme)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BenefitScheme, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BenefitScheme, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BenefitScheme)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BenefitScheme, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BenefitScheme, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, BenefitScheme>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			BenefitScheme.class.getClassLoader(), BenefitScheme.class,
			ModelWrapper.class);

		try {
			Constructor<BenefitScheme> constructor =
				(Constructor<BenefitScheme>)proxyClass.getConstructor(
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

	private static final Map<String, Function<BenefitScheme, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<BenefitScheme, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<BenefitScheme, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<BenefitScheme, Object>>();
		Map<String, BiConsumer<BenefitScheme, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<BenefitScheme, ?>>();

		attributeGetterFunctions.put(
			"benefitSchemeId", BenefitScheme::getBenefitSchemeId);
		attributeSetterBiConsumers.put(
			"benefitSchemeId",
			(BiConsumer<BenefitScheme, Long>)BenefitScheme::setBenefitSchemeId);
		attributeGetterFunctions.put("groupId", BenefitScheme::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<BenefitScheme, Long>)BenefitScheme::setGroupId);
		attributeGetterFunctions.put("companyId", BenefitScheme::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<BenefitScheme, Long>)BenefitScheme::setCompanyId);
		attributeGetterFunctions.put("userId", BenefitScheme::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<BenefitScheme, Long>)BenefitScheme::setUserId);
		attributeGetterFunctions.put("userName", BenefitScheme::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<BenefitScheme, String>)BenefitScheme::setUserName);
		attributeGetterFunctions.put(
			"createDate", BenefitScheme::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<BenefitScheme, Date>)BenefitScheme::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", BenefitScheme::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<BenefitScheme, Date>)BenefitScheme::setModifiedDate);
		attributeGetterFunctions.put("active", BenefitScheme::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<BenefitScheme, Boolean>)BenefitScheme::setActive);
		attributeGetterFunctions.put("code", BenefitScheme::getCode);
		attributeSetterBiConsumers.put(
			"code", (BiConsumer<BenefitScheme, String>)BenefitScheme::setCode);
		attributeGetterFunctions.put(
			"description", BenefitScheme::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<BenefitScheme, String>)BenefitScheme::setDescription);
		attributeGetterFunctions.put(
			"effectiveFrom", BenefitScheme::getEffectiveFrom);
		attributeSetterBiConsumers.put(
			"effectiveFrom",
			(BiConsumer<BenefitScheme, Date>)BenefitScheme::setEffectiveFrom);
		attributeGetterFunctions.put(
			"effectiveRate", BenefitScheme::getEffectiveRate);
		attributeSetterBiConsumers.put(
			"effectiveRate",
			(BiConsumer<BenefitScheme, Float>)BenefitScheme::setEffectiveRate);
		attributeGetterFunctions.put(
			"effectiveUpto", BenefitScheme::getEffectiveUpto);
		attributeSetterBiConsumers.put(
			"effectiveUpto",
			(BiConsumer<BenefitScheme, Date>)BenefitScheme::setEffectiveUpto);
		attributeGetterFunctions.put("name", BenefitScheme::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<BenefitScheme, String>)BenefitScheme::setName);
		attributeGetterFunctions.put(
			"frequencyId", BenefitScheme::getFrequencyId);
		attributeSetterBiConsumers.put(
			"frequencyId",
			(BiConsumer<BenefitScheme, Integer>)BenefitScheme::setFrequencyId);
		attributeGetterFunctions.put(
			"rateTypeId", BenefitScheme::getRateTypeId);
		attributeSetterBiConsumers.put(
			"rateTypeId",
			(BiConsumer<BenefitScheme, Integer>)BenefitScheme::setRateTypeId);
		attributeGetterFunctions.put("deleted", BenefitScheme::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<BenefitScheme, Boolean>)BenefitScheme::setDeleted);
		attributeGetterFunctions.put("status", BenefitScheme::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<BenefitScheme, Integer>)BenefitScheme::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getBenefitSchemeId() {
		return _benefitSchemeId;
	}

	@Override
	public void setBenefitSchemeId(long benefitSchemeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_benefitSchemeId = benefitSchemeId;
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
	public Date getEffectiveFrom() {
		return _effectiveFrom;
	}

	@Override
	public void setEffectiveFrom(Date effectiveFrom) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_effectiveFrom = effectiveFrom;
	}

	@JSON
	@Override
	public float getEffectiveRate() {
		return _effectiveRate;
	}

	@Override
	public void setEffectiveRate(float effectiveRate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_effectiveRate = effectiveRate;
	}

	@JSON
	@Override
	public Date getEffectiveUpto() {
		return _effectiveUpto;
	}

	@Override
	public void setEffectiveUpto(Date effectiveUpto) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_effectiveUpto = effectiveUpto;
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
	public int getFrequencyId() {
		return _frequencyId;
	}

	@Override
	public void setFrequencyId(int frequencyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_frequencyId = frequencyId;
	}

	@JSON
	@Override
	public int getRateTypeId() {
		return _rateTypeId;
	}

	@Override
	public void setRateTypeId(int rateTypeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_rateTypeId = rateTypeId;
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
			getCompanyId(), BenefitScheme.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BenefitScheme toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, BenefitScheme>
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
		BenefitSchemeImpl benefitSchemeImpl = new BenefitSchemeImpl();

		benefitSchemeImpl.setBenefitSchemeId(getBenefitSchemeId());
		benefitSchemeImpl.setGroupId(getGroupId());
		benefitSchemeImpl.setCompanyId(getCompanyId());
		benefitSchemeImpl.setUserId(getUserId());
		benefitSchemeImpl.setUserName(getUserName());
		benefitSchemeImpl.setCreateDate(getCreateDate());
		benefitSchemeImpl.setModifiedDate(getModifiedDate());
		benefitSchemeImpl.setActive(isActive());
		benefitSchemeImpl.setCode(getCode());
		benefitSchemeImpl.setDescription(getDescription());
		benefitSchemeImpl.setEffectiveFrom(getEffectiveFrom());
		benefitSchemeImpl.setEffectiveRate(getEffectiveRate());
		benefitSchemeImpl.setEffectiveUpto(getEffectiveUpto());
		benefitSchemeImpl.setName(getName());
		benefitSchemeImpl.setFrequencyId(getFrequencyId());
		benefitSchemeImpl.setRateTypeId(getRateTypeId());
		benefitSchemeImpl.setDeleted(isDeleted());
		benefitSchemeImpl.setStatus(getStatus());

		benefitSchemeImpl.resetOriginalValues();

		return benefitSchemeImpl;
	}

	@Override
	public int compareTo(BenefitScheme benefitScheme) {
		long primaryKey = benefitScheme.getPrimaryKey();

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

		if (!(object instanceof BenefitScheme)) {
			return false;
		}

		BenefitScheme benefitScheme = (BenefitScheme)object;

		long primaryKey = benefitScheme.getPrimaryKey();

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
	public CacheModel<BenefitScheme> toCacheModel() {
		BenefitSchemeCacheModel benefitSchemeCacheModel =
			new BenefitSchemeCacheModel();

		benefitSchemeCacheModel.benefitSchemeId = getBenefitSchemeId();

		benefitSchemeCacheModel.groupId = getGroupId();

		benefitSchemeCacheModel.companyId = getCompanyId();

		benefitSchemeCacheModel.userId = getUserId();

		benefitSchemeCacheModel.userName = getUserName();

		String userName = benefitSchemeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			benefitSchemeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			benefitSchemeCacheModel.createDate = createDate.getTime();
		}
		else {
			benefitSchemeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			benefitSchemeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			benefitSchemeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		benefitSchemeCacheModel.active = isActive();

		benefitSchemeCacheModel.code = getCode();

		String code = benefitSchemeCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			benefitSchemeCacheModel.code = null;
		}

		benefitSchemeCacheModel.description = getDescription();

		String description = benefitSchemeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			benefitSchemeCacheModel.description = null;
		}

		Date effectiveFrom = getEffectiveFrom();

		if (effectiveFrom != null) {
			benefitSchemeCacheModel.effectiveFrom = effectiveFrom.getTime();
		}
		else {
			benefitSchemeCacheModel.effectiveFrom = Long.MIN_VALUE;
		}

		benefitSchemeCacheModel.effectiveRate = getEffectiveRate();

		Date effectiveUpto = getEffectiveUpto();

		if (effectiveUpto != null) {
			benefitSchemeCacheModel.effectiveUpto = effectiveUpto.getTime();
		}
		else {
			benefitSchemeCacheModel.effectiveUpto = Long.MIN_VALUE;
		}

		benefitSchemeCacheModel.name = getName();

		String name = benefitSchemeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			benefitSchemeCacheModel.name = null;
		}

		benefitSchemeCacheModel.frequencyId = getFrequencyId();

		benefitSchemeCacheModel.rateTypeId = getRateTypeId();

		benefitSchemeCacheModel.deleted = isDeleted();

		benefitSchemeCacheModel.status = getStatus();

		return benefitSchemeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<BenefitScheme, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<BenefitScheme, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BenefitScheme, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((BenefitScheme)this));
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
		Map<String, Function<BenefitScheme, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<BenefitScheme, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BenefitScheme, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((BenefitScheme)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, BenefitScheme>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _benefitSchemeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _active;
	private String _code;
	private String _description;
	private Date _effectiveFrom;
	private float _effectiveRate;
	private Date _effectiveUpto;
	private String _name;
	private int _frequencyId;
	private int _rateTypeId;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<BenefitScheme, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((BenefitScheme)this);
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

		_columnOriginalValues.put("benefitSchemeId", _benefitSchemeId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("code_", _code);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("effectiveFrom", _effectiveFrom);
		_columnOriginalValues.put("effectiveRate", _effectiveRate);
		_columnOriginalValues.put("effectiveUpto", _effectiveUpto);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("frequencyId", _frequencyId);
		_columnOriginalValues.put("rateTypeId", _rateTypeId);
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

		columnBitmasks.put("benefitSchemeId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("active_", 128L);

		columnBitmasks.put("code_", 256L);

		columnBitmasks.put("description", 512L);

		columnBitmasks.put("effectiveFrom", 1024L);

		columnBitmasks.put("effectiveRate", 2048L);

		columnBitmasks.put("effectiveUpto", 4096L);

		columnBitmasks.put("name", 8192L);

		columnBitmasks.put("frequencyId", 16384L);

		columnBitmasks.put("rateTypeId", 32768L);

		columnBitmasks.put("deleted", 65536L);

		columnBitmasks.put("status", 131072L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private BenefitScheme _escapedModel;

}