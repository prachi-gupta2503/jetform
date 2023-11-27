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

import com.adjecti.pis.liferay.model.EmployeeTraining;
import com.adjecti.pis.liferay.model.EmployeeTrainingModel;
import com.adjecti.pis.liferay.model.EmployeeTrainingSoap;

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
 * The base model implementation for the EmployeeTraining service. Represents a row in the &quot;pis_EmployeeTraining&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeTrainingModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeTrainingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTrainingImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeTrainingModelImpl
	extends BaseModelImpl<EmployeeTraining> implements EmployeeTrainingModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee training model instance should use the <code>EmployeeTraining</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_EmployeeTraining";

	public static final Object[][] TABLE_COLUMNS = {
		{"employeeTrainingId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"active_", Types.BOOLEAN},
		{"durationMonths", Types.INTEGER}, {"fromMonth", Types.TIMESTAMP},
		{"toMonth", Types.TIMESTAMP}, {"courseId", Types.BIGINT},
		{"employeeId", Types.BIGINT}, {"organizationId", Types.BIGINT},
		{"certificateId", Types.BIGINT}, {"endDate", Types.TIMESTAMP},
		{"startDate", Types.TIMESTAMP}, {"instituteId", Types.BIGINT},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeeTrainingId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("durationMonths", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("fromMonth", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("toMonth", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("courseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("organizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("certificateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("instituteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_EmployeeTraining (employeeTrainingId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,active_ BOOLEAN,durationMonths INTEGER,fromMonth DATE null,toMonth DATE null,courseId LONG,employeeId LONG,organizationId LONG,certificateId LONG,endDate DATE null,startDate DATE null,instituteId LONG,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table pis_EmployeeTraining";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeeTraining.employeeTrainingId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_EmployeeTraining.employeeTrainingId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long INSTITUTEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ORGANIZATIONID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEETRAININGID_COLUMN_BITMASK = 8L;

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
	public static EmployeeTraining toModel(EmployeeTrainingSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EmployeeTraining model = new EmployeeTrainingImpl();

		model.setEmployeeTrainingId(soapModel.getEmployeeTrainingId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActive(soapModel.isActive());
		model.setDurationMonths(soapModel.getDurationMonths());
		model.setFromMonth(soapModel.getFromMonth());
		model.setToMonth(soapModel.getToMonth());
		model.setCourseId(soapModel.getCourseId());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setOrganizationId(soapModel.getOrganizationId());
		model.setCertificateId(soapModel.getCertificateId());
		model.setEndDate(soapModel.getEndDate());
		model.setStartDate(soapModel.getStartDate());
		model.setInstituteId(soapModel.getInstituteId());
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
	public static List<EmployeeTraining> toModels(
		EmployeeTrainingSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<EmployeeTraining> models = new ArrayList<EmployeeTraining>(
			soapModels.length);

		for (EmployeeTrainingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeeTrainingModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeTrainingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeTrainingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeTrainingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeTraining.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeTraining.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeeTraining, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeeTraining, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeTraining, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeeTraining)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeeTraining, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeeTraining, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeeTraining)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeeTraining, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeeTraining, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmployeeTraining>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmployeeTraining.class.getClassLoader(), EmployeeTraining.class,
			ModelWrapper.class);

		try {
			Constructor<EmployeeTraining> constructor =
				(Constructor<EmployeeTraining>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EmployeeTraining, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmployeeTraining, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmployeeTraining, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<EmployeeTraining, Object>>();
		Map<String, BiConsumer<EmployeeTraining, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<EmployeeTraining, ?>>();

		attributeGetterFunctions.put(
			"employeeTrainingId", EmployeeTraining::getEmployeeTrainingId);
		attributeSetterBiConsumers.put(
			"employeeTrainingId",
			(BiConsumer<EmployeeTraining, Long>)
				EmployeeTraining::setEmployeeTrainingId);
		attributeGetterFunctions.put("groupId", EmployeeTraining::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EmployeeTraining, Long>)EmployeeTraining::setGroupId);
		attributeGetterFunctions.put(
			"companyId", EmployeeTraining::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmployeeTraining, Long>)EmployeeTraining::setCompanyId);
		attributeGetterFunctions.put("userId", EmployeeTraining::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EmployeeTraining, Long>)EmployeeTraining::setUserId);
		attributeGetterFunctions.put("userName", EmployeeTraining::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmployeeTraining, String>)
				EmployeeTraining::setUserName);
		attributeGetterFunctions.put(
			"createDate", EmployeeTraining::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmployeeTraining, Date>)
				EmployeeTraining::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmployeeTraining::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmployeeTraining, Date>)
				EmployeeTraining::setModifiedDate);
		attributeGetterFunctions.put("active", EmployeeTraining::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<EmployeeTraining, Boolean>)EmployeeTraining::setActive);
		attributeGetterFunctions.put(
			"durationMonths", EmployeeTraining::getDurationMonths);
		attributeSetterBiConsumers.put(
			"durationMonths",
			(BiConsumer<EmployeeTraining, Integer>)
				EmployeeTraining::setDurationMonths);
		attributeGetterFunctions.put(
			"fromMonth", EmployeeTraining::getFromMonth);
		attributeSetterBiConsumers.put(
			"fromMonth",
			(BiConsumer<EmployeeTraining, Date>)EmployeeTraining::setFromMonth);
		attributeGetterFunctions.put("toMonth", EmployeeTraining::getToMonth);
		attributeSetterBiConsumers.put(
			"toMonth",
			(BiConsumer<EmployeeTraining, Date>)EmployeeTraining::setToMonth);
		attributeGetterFunctions.put("courseId", EmployeeTraining::getCourseId);
		attributeSetterBiConsumers.put(
			"courseId",
			(BiConsumer<EmployeeTraining, Long>)EmployeeTraining::setCourseId);
		attributeGetterFunctions.put(
			"employeeId", EmployeeTraining::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<EmployeeTraining, Long>)
				EmployeeTraining::setEmployeeId);
		attributeGetterFunctions.put(
			"organizationId", EmployeeTraining::getOrganizationId);
		attributeSetterBiConsumers.put(
			"organizationId",
			(BiConsumer<EmployeeTraining, Long>)
				EmployeeTraining::setOrganizationId);
		attributeGetterFunctions.put(
			"certificateId", EmployeeTraining::getCertificateId);
		attributeSetterBiConsumers.put(
			"certificateId",
			(BiConsumer<EmployeeTraining, Long>)
				EmployeeTraining::setCertificateId);
		attributeGetterFunctions.put("endDate", EmployeeTraining::getEndDate);
		attributeSetterBiConsumers.put(
			"endDate",
			(BiConsumer<EmployeeTraining, Date>)EmployeeTraining::setEndDate);
		attributeGetterFunctions.put(
			"startDate", EmployeeTraining::getStartDate);
		attributeSetterBiConsumers.put(
			"startDate",
			(BiConsumer<EmployeeTraining, Date>)EmployeeTraining::setStartDate);
		attributeGetterFunctions.put(
			"instituteId", EmployeeTraining::getInstituteId);
		attributeSetterBiConsumers.put(
			"instituteId",
			(BiConsumer<EmployeeTraining, Long>)
				EmployeeTraining::setInstituteId);
		attributeGetterFunctions.put("status", EmployeeTraining::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<EmployeeTraining, Integer>)EmployeeTraining::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getEmployeeTrainingId() {
		return _employeeTrainingId;
	}

	@Override
	public void setEmployeeTrainingId(long employeeTrainingId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeTrainingId = employeeTrainingId;
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
	public int getDurationMonths() {
		return _durationMonths;
	}

	@Override
	public void setDurationMonths(int durationMonths) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_durationMonths = durationMonths;
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
	public long getCourseId() {
		return _courseId;
	}

	@Override
	public void setCourseId(long courseId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_courseId = courseId;
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
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_organizationId = organizationId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalOrganizationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("organizationId"));
	}

	@JSON
	@Override
	public long getCertificateId() {
		return _certificateId;
	}

	@Override
	public void setCertificateId(long certificateId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_certificateId = certificateId;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_endDate = endDate;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_startDate = startDate;
	}

	@JSON
	@Override
	public long getInstituteId() {
		return _instituteId;
	}

	@Override
	public void setInstituteId(long instituteId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_instituteId = instituteId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalInstituteId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("instituteId"));
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
			getCompanyId(), EmployeeTraining.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeTraining toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeeTraining>
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
		EmployeeTrainingImpl employeeTrainingImpl = new EmployeeTrainingImpl();

		employeeTrainingImpl.setEmployeeTrainingId(getEmployeeTrainingId());
		employeeTrainingImpl.setGroupId(getGroupId());
		employeeTrainingImpl.setCompanyId(getCompanyId());
		employeeTrainingImpl.setUserId(getUserId());
		employeeTrainingImpl.setUserName(getUserName());
		employeeTrainingImpl.setCreateDate(getCreateDate());
		employeeTrainingImpl.setModifiedDate(getModifiedDate());
		employeeTrainingImpl.setActive(isActive());
		employeeTrainingImpl.setDurationMonths(getDurationMonths());
		employeeTrainingImpl.setFromMonth(getFromMonth());
		employeeTrainingImpl.setToMonth(getToMonth());
		employeeTrainingImpl.setCourseId(getCourseId());
		employeeTrainingImpl.setEmployeeId(getEmployeeId());
		employeeTrainingImpl.setOrganizationId(getOrganizationId());
		employeeTrainingImpl.setCertificateId(getCertificateId());
		employeeTrainingImpl.setEndDate(getEndDate());
		employeeTrainingImpl.setStartDate(getStartDate());
		employeeTrainingImpl.setInstituteId(getInstituteId());
		employeeTrainingImpl.setStatus(getStatus());

		employeeTrainingImpl.resetOriginalValues();

		return employeeTrainingImpl;
	}

	@Override
	public int compareTo(EmployeeTraining employeeTraining) {
		long primaryKey = employeeTraining.getPrimaryKey();

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

		if (!(object instanceof EmployeeTraining)) {
			return false;
		}

		EmployeeTraining employeeTraining = (EmployeeTraining)object;

		long primaryKey = employeeTraining.getPrimaryKey();

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
	public CacheModel<EmployeeTraining> toCacheModel() {
		EmployeeTrainingCacheModel employeeTrainingCacheModel =
			new EmployeeTrainingCacheModel();

		employeeTrainingCacheModel.employeeTrainingId = getEmployeeTrainingId();

		employeeTrainingCacheModel.groupId = getGroupId();

		employeeTrainingCacheModel.companyId = getCompanyId();

		employeeTrainingCacheModel.userId = getUserId();

		employeeTrainingCacheModel.userName = getUserName();

		String userName = employeeTrainingCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeeTrainingCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeTrainingCacheModel.createDate = createDate.getTime();
		}
		else {
			employeeTrainingCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeTrainingCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			employeeTrainingCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeeTrainingCacheModel.active = isActive();

		employeeTrainingCacheModel.durationMonths = getDurationMonths();

		Date fromMonth = getFromMonth();

		if (fromMonth != null) {
			employeeTrainingCacheModel.fromMonth = fromMonth.getTime();
		}
		else {
			employeeTrainingCacheModel.fromMonth = Long.MIN_VALUE;
		}

		Date toMonth = getToMonth();

		if (toMonth != null) {
			employeeTrainingCacheModel.toMonth = toMonth.getTime();
		}
		else {
			employeeTrainingCacheModel.toMonth = Long.MIN_VALUE;
		}

		employeeTrainingCacheModel.courseId = getCourseId();

		employeeTrainingCacheModel.employeeId = getEmployeeId();

		employeeTrainingCacheModel.organizationId = getOrganizationId();

		employeeTrainingCacheModel.certificateId = getCertificateId();

		Date endDate = getEndDate();

		if (endDate != null) {
			employeeTrainingCacheModel.endDate = endDate.getTime();
		}
		else {
			employeeTrainingCacheModel.endDate = Long.MIN_VALUE;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			employeeTrainingCacheModel.startDate = startDate.getTime();
		}
		else {
			employeeTrainingCacheModel.startDate = Long.MIN_VALUE;
		}

		employeeTrainingCacheModel.instituteId = getInstituteId();

		employeeTrainingCacheModel.status = getStatus();

		return employeeTrainingCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeeTraining, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeeTraining, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeTraining, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EmployeeTraining)this));
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
		Map<String, Function<EmployeeTraining, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeeTraining, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeTraining, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmployeeTraining)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmployeeTraining>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _employeeTrainingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _active;
	private int _durationMonths;
	private Date _fromMonth;
	private Date _toMonth;
	private long _courseId;
	private long _employeeId;
	private long _organizationId;
	private long _certificateId;
	private Date _endDate;
	private Date _startDate;
	private long _instituteId;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<EmployeeTraining, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeeTraining)this);
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

		_columnOriginalValues.put("employeeTrainingId", _employeeTrainingId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("durationMonths", _durationMonths);
		_columnOriginalValues.put("fromMonth", _fromMonth);
		_columnOriginalValues.put("toMonth", _toMonth);
		_columnOriginalValues.put("courseId", _courseId);
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("organizationId", _organizationId);
		_columnOriginalValues.put("certificateId", _certificateId);
		_columnOriginalValues.put("endDate", _endDate);
		_columnOriginalValues.put("startDate", _startDate);
		_columnOriginalValues.put("instituteId", _instituteId);
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

		columnBitmasks.put("employeeTrainingId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("active_", 128L);

		columnBitmasks.put("durationMonths", 256L);

		columnBitmasks.put("fromMonth", 512L);

		columnBitmasks.put("toMonth", 1024L);

		columnBitmasks.put("courseId", 2048L);

		columnBitmasks.put("employeeId", 4096L);

		columnBitmasks.put("organizationId", 8192L);

		columnBitmasks.put("certificateId", 16384L);

		columnBitmasks.put("endDate", 32768L);

		columnBitmasks.put("startDate", 65536L);

		columnBitmasks.put("instituteId", 131072L);

		columnBitmasks.put("status", 262144L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeeTraining _escapedModel;

}