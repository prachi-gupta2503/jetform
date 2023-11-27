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

import com.adjecti.pis.liferay.model.EmployeeWorkstation;
import com.adjecti.pis.liferay.model.EmployeeWorkstationModel;
import com.adjecti.pis.liferay.model.EmployeeWorkstationSoap;

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
 * The base model implementation for the EmployeeWorkstation service. Represents a row in the &quot;pis_EmployeeWorkstation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeWorkstationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeWorkstationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkstationImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeWorkstationModelImpl
	extends BaseModelImpl<EmployeeWorkstation>
	implements EmployeeWorkstationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee workstation model instance should use the <code>EmployeeWorkstation</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_EmployeeWorkstation";

	public static final Object[][] TABLE_COLUMNS = {
		{"employeeWorkstationId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"active_", Types.BOOLEAN},
		{"fromMonth", Types.TIMESTAMP}, {"toMonth", Types.TIMESTAMP},
		{"employeeId", Types.BIGINT}, {"workStationId", Types.BIGINT},
		{"deskNo", Types.VARCHAR}, {"extnNo", Types.VARCHAR},
		{"directNo", Types.VARCHAR}, {"phoneNo", Types.VARCHAR},
		{"cabinNo", Types.VARCHAR}, {"floorNo", Types.VARCHAR},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeeWorkstationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("fromMonth", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("toMonth", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workStationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("deskNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("extnNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("directNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phoneNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cabinNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("floorNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_EmployeeWorkstation (employeeWorkstationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,active_ BOOLEAN,fromMonth DATE null,toMonth DATE null,employeeId LONG,workStationId LONG,deskNo VARCHAR(75) null,extnNo VARCHAR(75) null,directNo VARCHAR(75) null,phoneNo VARCHAR(75) null,cabinNo VARCHAR(75) null,floorNo VARCHAR(75) null,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table pis_EmployeeWorkstation";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeeWorkstation.employeeWorkstationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_EmployeeWorkstation.employeeWorkstationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEWORKSTATIONID_COLUMN_BITMASK = 2L;

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
	public static EmployeeWorkstation toModel(
		EmployeeWorkstationSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		EmployeeWorkstation model = new EmployeeWorkstationImpl();

		model.setEmployeeWorkstationId(soapModel.getEmployeeWorkstationId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActive(soapModel.isActive());
		model.setFromMonth(soapModel.getFromMonth());
		model.setToMonth(soapModel.getToMonth());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setWorkStationId(soapModel.getWorkStationId());
		model.setDeskNo(soapModel.getDeskNo());
		model.setExtnNo(soapModel.getExtnNo());
		model.setDirectNo(soapModel.getDirectNo());
		model.setPhoneNo(soapModel.getPhoneNo());
		model.setCabinNo(soapModel.getCabinNo());
		model.setFloorNo(soapModel.getFloorNo());
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
	public static List<EmployeeWorkstation> toModels(
		EmployeeWorkstationSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<EmployeeWorkstation> models = new ArrayList<EmployeeWorkstation>(
			soapModels.length);

		for (EmployeeWorkstationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeeWorkstationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeWorkstationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeWorkstationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeWorkstationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeWorkstation.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeWorkstation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeeWorkstation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeeWorkstation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeWorkstation, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeeWorkstation)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeeWorkstation, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeeWorkstation, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeeWorkstation)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeeWorkstation, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeeWorkstation, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmployeeWorkstation>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmployeeWorkstation.class.getClassLoader(),
			EmployeeWorkstation.class, ModelWrapper.class);

		try {
			Constructor<EmployeeWorkstation> constructor =
				(Constructor<EmployeeWorkstation>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EmployeeWorkstation, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmployeeWorkstation, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmployeeWorkstation, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<EmployeeWorkstation, Object>>();
		Map<String, BiConsumer<EmployeeWorkstation, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<EmployeeWorkstation, ?>>();

		attributeGetterFunctions.put(
			"employeeWorkstationId",
			EmployeeWorkstation::getEmployeeWorkstationId);
		attributeSetterBiConsumers.put(
			"employeeWorkstationId",
			(BiConsumer<EmployeeWorkstation, Long>)
				EmployeeWorkstation::setEmployeeWorkstationId);
		attributeGetterFunctions.put(
			"groupId", EmployeeWorkstation::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EmployeeWorkstation, Long>)
				EmployeeWorkstation::setGroupId);
		attributeGetterFunctions.put(
			"companyId", EmployeeWorkstation::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmployeeWorkstation, Long>)
				EmployeeWorkstation::setCompanyId);
		attributeGetterFunctions.put("userId", EmployeeWorkstation::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EmployeeWorkstation, Long>)
				EmployeeWorkstation::setUserId);
		attributeGetterFunctions.put(
			"userName", EmployeeWorkstation::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmployeeWorkstation, String>)
				EmployeeWorkstation::setUserName);
		attributeGetterFunctions.put(
			"createDate", EmployeeWorkstation::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmployeeWorkstation, Date>)
				EmployeeWorkstation::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmployeeWorkstation::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmployeeWorkstation, Date>)
				EmployeeWorkstation::setModifiedDate);
		attributeGetterFunctions.put("active", EmployeeWorkstation::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<EmployeeWorkstation, Boolean>)
				EmployeeWorkstation::setActive);
		attributeGetterFunctions.put(
			"fromMonth", EmployeeWorkstation::getFromMonth);
		attributeSetterBiConsumers.put(
			"fromMonth",
			(BiConsumer<EmployeeWorkstation, Date>)
				EmployeeWorkstation::setFromMonth);
		attributeGetterFunctions.put(
			"toMonth", EmployeeWorkstation::getToMonth);
		attributeSetterBiConsumers.put(
			"toMonth",
			(BiConsumer<EmployeeWorkstation, Date>)
				EmployeeWorkstation::setToMonth);
		attributeGetterFunctions.put(
			"employeeId", EmployeeWorkstation::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<EmployeeWorkstation, Long>)
				EmployeeWorkstation::setEmployeeId);
		attributeGetterFunctions.put(
			"workStationId", EmployeeWorkstation::getWorkStationId);
		attributeSetterBiConsumers.put(
			"workStationId",
			(BiConsumer<EmployeeWorkstation, Long>)
				EmployeeWorkstation::setWorkStationId);
		attributeGetterFunctions.put("deskNo", EmployeeWorkstation::getDeskNo);
		attributeSetterBiConsumers.put(
			"deskNo",
			(BiConsumer<EmployeeWorkstation, String>)
				EmployeeWorkstation::setDeskNo);
		attributeGetterFunctions.put("extnNo", EmployeeWorkstation::getExtnNo);
		attributeSetterBiConsumers.put(
			"extnNo",
			(BiConsumer<EmployeeWorkstation, String>)
				EmployeeWorkstation::setExtnNo);
		attributeGetterFunctions.put(
			"directNo", EmployeeWorkstation::getDirectNo);
		attributeSetterBiConsumers.put(
			"directNo",
			(BiConsumer<EmployeeWorkstation, String>)
				EmployeeWorkstation::setDirectNo);
		attributeGetterFunctions.put(
			"phoneNo", EmployeeWorkstation::getPhoneNo);
		attributeSetterBiConsumers.put(
			"phoneNo",
			(BiConsumer<EmployeeWorkstation, String>)
				EmployeeWorkstation::setPhoneNo);
		attributeGetterFunctions.put(
			"cabinNo", EmployeeWorkstation::getCabinNo);
		attributeSetterBiConsumers.put(
			"cabinNo",
			(BiConsumer<EmployeeWorkstation, String>)
				EmployeeWorkstation::setCabinNo);
		attributeGetterFunctions.put(
			"floorNo", EmployeeWorkstation::getFloorNo);
		attributeSetterBiConsumers.put(
			"floorNo",
			(BiConsumer<EmployeeWorkstation, String>)
				EmployeeWorkstation::setFloorNo);
		attributeGetterFunctions.put("status", EmployeeWorkstation::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<EmployeeWorkstation, Integer>)
				EmployeeWorkstation::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getEmployeeWorkstationId() {
		return _employeeWorkstationId;
	}

	@Override
	public void setEmployeeWorkstationId(long employeeWorkstationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeWorkstationId = employeeWorkstationId;
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
	public Date getFromMonth() {
		return _fromMonth;
	}

	@Override
	public void setFromMonth(Date fromMonth) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fromMonth = fromMonth;
	}

	@JSON
	@Override
	public Date getToMonth() {
		return _toMonth;
	}

	@Override
	public void setToMonth(Date toMonth) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_toMonth = toMonth;
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
	public long getWorkStationId() {
		return _workStationId;
	}

	@Override
	public void setWorkStationId(long workStationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_workStationId = workStationId;
	}

	@JSON
	@Override
	public String getDeskNo() {
		if (_deskNo == null) {
			return "";
		}
		else {
			return _deskNo;
		}
	}

	@Override
	public void setDeskNo(String deskNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_deskNo = deskNo;
	}

	@JSON
	@Override
	public String getExtnNo() {
		if (_extnNo == null) {
			return "";
		}
		else {
			return _extnNo;
		}
	}

	@Override
	public void setExtnNo(String extnNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_extnNo = extnNo;
	}

	@JSON
	@Override
	public String getDirectNo() {
		if (_directNo == null) {
			return "";
		}
		else {
			return _directNo;
		}
	}

	@Override
	public void setDirectNo(String directNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_directNo = directNo;
	}

	@JSON
	@Override
	public String getPhoneNo() {
		if (_phoneNo == null) {
			return "";
		}
		else {
			return _phoneNo;
		}
	}

	@Override
	public void setPhoneNo(String phoneNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_phoneNo = phoneNo;
	}

	@JSON
	@Override
	public String getCabinNo() {
		if (_cabinNo == null) {
			return "";
		}
		else {
			return _cabinNo;
		}
	}

	@Override
	public void setCabinNo(String cabinNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cabinNo = cabinNo;
	}

	@JSON
	@Override
	public String getFloorNo() {
		if (_floorNo == null) {
			return "";
		}
		else {
			return _floorNo;
		}
	}

	@Override
	public void setFloorNo(String floorNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_floorNo = floorNo;
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
			getCompanyId(), EmployeeWorkstation.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeWorkstation toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeeWorkstation>
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
		EmployeeWorkstationImpl employeeWorkstationImpl =
			new EmployeeWorkstationImpl();

		employeeWorkstationImpl.setEmployeeWorkstationId(
			getEmployeeWorkstationId());
		employeeWorkstationImpl.setGroupId(getGroupId());
		employeeWorkstationImpl.setCompanyId(getCompanyId());
		employeeWorkstationImpl.setUserId(getUserId());
		employeeWorkstationImpl.setUserName(getUserName());
		employeeWorkstationImpl.setCreateDate(getCreateDate());
		employeeWorkstationImpl.setModifiedDate(getModifiedDate());
		employeeWorkstationImpl.setActive(isActive());
		employeeWorkstationImpl.setFromMonth(getFromMonth());
		employeeWorkstationImpl.setToMonth(getToMonth());
		employeeWorkstationImpl.setEmployeeId(getEmployeeId());
		employeeWorkstationImpl.setWorkStationId(getWorkStationId());
		employeeWorkstationImpl.setDeskNo(getDeskNo());
		employeeWorkstationImpl.setExtnNo(getExtnNo());
		employeeWorkstationImpl.setDirectNo(getDirectNo());
		employeeWorkstationImpl.setPhoneNo(getPhoneNo());
		employeeWorkstationImpl.setCabinNo(getCabinNo());
		employeeWorkstationImpl.setFloorNo(getFloorNo());
		employeeWorkstationImpl.setStatus(getStatus());

		employeeWorkstationImpl.resetOriginalValues();

		return employeeWorkstationImpl;
	}

	@Override
	public int compareTo(EmployeeWorkstation employeeWorkstation) {
		long primaryKey = employeeWorkstation.getPrimaryKey();

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

		if (!(object instanceof EmployeeWorkstation)) {
			return false;
		}

		EmployeeWorkstation employeeWorkstation = (EmployeeWorkstation)object;

		long primaryKey = employeeWorkstation.getPrimaryKey();

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
	public CacheModel<EmployeeWorkstation> toCacheModel() {
		EmployeeWorkstationCacheModel employeeWorkstationCacheModel =
			new EmployeeWorkstationCacheModel();

		employeeWorkstationCacheModel.employeeWorkstationId =
			getEmployeeWorkstationId();

		employeeWorkstationCacheModel.groupId = getGroupId();

		employeeWorkstationCacheModel.companyId = getCompanyId();

		employeeWorkstationCacheModel.userId = getUserId();

		employeeWorkstationCacheModel.userName = getUserName();

		String userName = employeeWorkstationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeeWorkstationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeWorkstationCacheModel.createDate = createDate.getTime();
		}
		else {
			employeeWorkstationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeWorkstationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			employeeWorkstationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeeWorkstationCacheModel.active = isActive();

		Date fromMonth = getFromMonth();

		if (fromMonth != null) {
			employeeWorkstationCacheModel.fromMonth = fromMonth.getTime();
		}
		else {
			employeeWorkstationCacheModel.fromMonth = Long.MIN_VALUE;
		}

		Date toMonth = getToMonth();

		if (toMonth != null) {
			employeeWorkstationCacheModel.toMonth = toMonth.getTime();
		}
		else {
			employeeWorkstationCacheModel.toMonth = Long.MIN_VALUE;
		}

		employeeWorkstationCacheModel.employeeId = getEmployeeId();

		employeeWorkstationCacheModel.workStationId = getWorkStationId();

		employeeWorkstationCacheModel.deskNo = getDeskNo();

		String deskNo = employeeWorkstationCacheModel.deskNo;

		if ((deskNo != null) && (deskNo.length() == 0)) {
			employeeWorkstationCacheModel.deskNo = null;
		}

		employeeWorkstationCacheModel.extnNo = getExtnNo();

		String extnNo = employeeWorkstationCacheModel.extnNo;

		if ((extnNo != null) && (extnNo.length() == 0)) {
			employeeWorkstationCacheModel.extnNo = null;
		}

		employeeWorkstationCacheModel.directNo = getDirectNo();

		String directNo = employeeWorkstationCacheModel.directNo;

		if ((directNo != null) && (directNo.length() == 0)) {
			employeeWorkstationCacheModel.directNo = null;
		}

		employeeWorkstationCacheModel.phoneNo = getPhoneNo();

		String phoneNo = employeeWorkstationCacheModel.phoneNo;

		if ((phoneNo != null) && (phoneNo.length() == 0)) {
			employeeWorkstationCacheModel.phoneNo = null;
		}

		employeeWorkstationCacheModel.cabinNo = getCabinNo();

		String cabinNo = employeeWorkstationCacheModel.cabinNo;

		if ((cabinNo != null) && (cabinNo.length() == 0)) {
			employeeWorkstationCacheModel.cabinNo = null;
		}

		employeeWorkstationCacheModel.floorNo = getFloorNo();

		String floorNo = employeeWorkstationCacheModel.floorNo;

		if ((floorNo != null) && (floorNo.length() == 0)) {
			employeeWorkstationCacheModel.floorNo = null;
		}

		employeeWorkstationCacheModel.status = getStatus();

		return employeeWorkstationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeeWorkstation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeeWorkstation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeWorkstation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EmployeeWorkstation)this));
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
		Map<String, Function<EmployeeWorkstation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeeWorkstation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeWorkstation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmployeeWorkstation)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmployeeWorkstation>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _employeeWorkstationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _active;
	private Date _fromMonth;
	private Date _toMonth;
	private long _employeeId;
	private long _workStationId;
	private String _deskNo;
	private String _extnNo;
	private String _directNo;
	private String _phoneNo;
	private String _cabinNo;
	private String _floorNo;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<EmployeeWorkstation, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeeWorkstation)this);
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
			"employeeWorkstationId", _employeeWorkstationId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("fromMonth", _fromMonth);
		_columnOriginalValues.put("toMonth", _toMonth);
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("workStationId", _workStationId);
		_columnOriginalValues.put("deskNo", _deskNo);
		_columnOriginalValues.put("extnNo", _extnNo);
		_columnOriginalValues.put("directNo", _directNo);
		_columnOriginalValues.put("phoneNo", _phoneNo);
		_columnOriginalValues.put("cabinNo", _cabinNo);
		_columnOriginalValues.put("floorNo", _floorNo);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("active_", "active");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("employeeWorkstationId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("active_", 128L);

		columnBitmasks.put("fromMonth", 256L);

		columnBitmasks.put("toMonth", 512L);

		columnBitmasks.put("employeeId", 1024L);

		columnBitmasks.put("workStationId", 2048L);

		columnBitmasks.put("deskNo", 4096L);

		columnBitmasks.put("extnNo", 8192L);

		columnBitmasks.put("directNo", 16384L);

		columnBitmasks.put("phoneNo", 32768L);

		columnBitmasks.put("cabinNo", 65536L);

		columnBitmasks.put("floorNo", 131072L);

		columnBitmasks.put("status", 262144L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeeWorkstation _escapedModel;

}