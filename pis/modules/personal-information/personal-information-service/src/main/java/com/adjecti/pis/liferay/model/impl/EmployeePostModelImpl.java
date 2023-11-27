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

import com.adjecti.pis.liferay.model.EmployeePost;
import com.adjecti.pis.liferay.model.EmployeePostModel;
import com.adjecti.pis.liferay.model.EmployeePostSoap;

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
 * The base model implementation for the EmployeePost service. Represents a row in the &quot;pis_EmployeePost&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeePostModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeePostImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePostImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeePostModelImpl
	extends BaseModelImpl<EmployeePost> implements EmployeePostModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee post model instance should use the <code>EmployeePost</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_EmployeePost";

	public static final Object[][] TABLE_COLUMNS = {
		{"employeePostId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"active_", Types.BOOLEAN},
		{"fromDate", Types.TIMESTAMP}, {"toDate", Types.TIMESTAMP},
		{"postId", Types.BIGINT}, {"delegatedPostId", Types.BIGINT},
		{"employeeId", Types.BIGINT}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeePostId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("fromDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("toDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("postId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("delegatedPostId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_EmployeePost (employeePostId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,active_ BOOLEAN,fromDate DATE null,toDate DATE null,postId LONG,delegatedPostId LONG,employeeId LONG,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table pis_EmployeePost";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeePost.employeePostId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_EmployeePost.employeePostId ASC";

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
	public static final long EMPLOYEEPOSTID_COLUMN_BITMASK = 2L;

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
	public static EmployeePost toModel(EmployeePostSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EmployeePost model = new EmployeePostImpl();

		model.setEmployeePostId(soapModel.getEmployeePostId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActive(soapModel.isActive());
		model.setFromDate(soapModel.getFromDate());
		model.setToDate(soapModel.getToDate());
		model.setPostId(soapModel.getPostId());
		model.setDelegatedPostId(soapModel.getDelegatedPostId());
		model.setEmployeeId(soapModel.getEmployeeId());
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
	public static List<EmployeePost> toModels(EmployeePostSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<EmployeePost> models = new ArrayList<EmployeePost>(
			soapModels.length);

		for (EmployeePostSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeePostModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeePostId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeePostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeePostId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeePost.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeePost.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeePost, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeePost, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeePost, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeePost)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeePost, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeePost, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeePost)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeePost, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeePost, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmployeePost>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmployeePost.class.getClassLoader(), EmployeePost.class,
			ModelWrapper.class);

		try {
			Constructor<EmployeePost> constructor =
				(Constructor<EmployeePost>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EmployeePost, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmployeePost, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmployeePost, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<EmployeePost, Object>>();
		Map<String, BiConsumer<EmployeePost, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<EmployeePost, ?>>();

		attributeGetterFunctions.put(
			"employeePostId", EmployeePost::getEmployeePostId);
		attributeSetterBiConsumers.put(
			"employeePostId",
			(BiConsumer<EmployeePost, Long>)EmployeePost::setEmployeePostId);
		attributeGetterFunctions.put("groupId", EmployeePost::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EmployeePost, Long>)EmployeePost::setGroupId);
		attributeGetterFunctions.put("companyId", EmployeePost::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmployeePost, Long>)EmployeePost::setCompanyId);
		attributeGetterFunctions.put("userId", EmployeePost::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<EmployeePost, Long>)EmployeePost::setUserId);
		attributeGetterFunctions.put("userName", EmployeePost::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmployeePost, String>)EmployeePost::setUserName);
		attributeGetterFunctions.put("createDate", EmployeePost::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmployeePost, Date>)EmployeePost::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmployeePost::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmployeePost, Date>)EmployeePost::setModifiedDate);
		attributeGetterFunctions.put("active", EmployeePost::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<EmployeePost, Boolean>)EmployeePost::setActive);
		attributeGetterFunctions.put("fromDate", EmployeePost::getFromDate);
		attributeSetterBiConsumers.put(
			"fromDate",
			(BiConsumer<EmployeePost, Date>)EmployeePost::setFromDate);
		attributeGetterFunctions.put("toDate", EmployeePost::getToDate);
		attributeSetterBiConsumers.put(
			"toDate", (BiConsumer<EmployeePost, Date>)EmployeePost::setToDate);
		attributeGetterFunctions.put("postId", EmployeePost::getPostId);
		attributeSetterBiConsumers.put(
			"postId", (BiConsumer<EmployeePost, Long>)EmployeePost::setPostId);
		attributeGetterFunctions.put(
			"delegatedPostId", EmployeePost::getDelegatedPostId);
		attributeSetterBiConsumers.put(
			"delegatedPostId",
			(BiConsumer<EmployeePost, Long>)EmployeePost::setDelegatedPostId);
		attributeGetterFunctions.put("employeeId", EmployeePost::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<EmployeePost, Long>)EmployeePost::setEmployeeId);
		attributeGetterFunctions.put("status", EmployeePost::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<EmployeePost, Integer>)EmployeePost::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getEmployeePostId() {
		return _employeePostId;
	}

	@Override
	public void setEmployeePostId(long employeePostId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeePostId = employeePostId;
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
	public long getPostId() {
		return _postId;
	}

	@Override
	public void setPostId(long postId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_postId = postId;
	}

	@JSON
	@Override
	public long getDelegatedPostId() {
		return _delegatedPostId;
	}

	@Override
	public void setDelegatedPostId(long delegatedPostId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_delegatedPostId = delegatedPostId;
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
			getCompanyId(), EmployeePost.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeePost toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeePost>
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
		EmployeePostImpl employeePostImpl = new EmployeePostImpl();

		employeePostImpl.setEmployeePostId(getEmployeePostId());
		employeePostImpl.setGroupId(getGroupId());
		employeePostImpl.setCompanyId(getCompanyId());
		employeePostImpl.setUserId(getUserId());
		employeePostImpl.setUserName(getUserName());
		employeePostImpl.setCreateDate(getCreateDate());
		employeePostImpl.setModifiedDate(getModifiedDate());
		employeePostImpl.setActive(isActive());
		employeePostImpl.setFromDate(getFromDate());
		employeePostImpl.setToDate(getToDate());
		employeePostImpl.setPostId(getPostId());
		employeePostImpl.setDelegatedPostId(getDelegatedPostId());
		employeePostImpl.setEmployeeId(getEmployeeId());
		employeePostImpl.setStatus(getStatus());

		employeePostImpl.resetOriginalValues();

		return employeePostImpl;
	}

	@Override
	public int compareTo(EmployeePost employeePost) {
		long primaryKey = employeePost.getPrimaryKey();

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

		if (!(object instanceof EmployeePost)) {
			return false;
		}

		EmployeePost employeePost = (EmployeePost)object;

		long primaryKey = employeePost.getPrimaryKey();

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
	public CacheModel<EmployeePost> toCacheModel() {
		EmployeePostCacheModel employeePostCacheModel =
			new EmployeePostCacheModel();

		employeePostCacheModel.employeePostId = getEmployeePostId();

		employeePostCacheModel.groupId = getGroupId();

		employeePostCacheModel.companyId = getCompanyId();

		employeePostCacheModel.userId = getUserId();

		employeePostCacheModel.userName = getUserName();

		String userName = employeePostCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeePostCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeePostCacheModel.createDate = createDate.getTime();
		}
		else {
			employeePostCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeePostCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			employeePostCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeePostCacheModel.active = isActive();

		Date fromDate = getFromDate();

		if (fromDate != null) {
			employeePostCacheModel.fromDate = fromDate.getTime();
		}
		else {
			employeePostCacheModel.fromDate = Long.MIN_VALUE;
		}

		Date toDate = getToDate();

		if (toDate != null) {
			employeePostCacheModel.toDate = toDate.getTime();
		}
		else {
			employeePostCacheModel.toDate = Long.MIN_VALUE;
		}

		employeePostCacheModel.postId = getPostId();

		employeePostCacheModel.delegatedPostId = getDelegatedPostId();

		employeePostCacheModel.employeeId = getEmployeeId();

		employeePostCacheModel.status = getStatus();

		return employeePostCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeePost, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeePost, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeePost, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EmployeePost)this));
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
		Map<String, Function<EmployeePost, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeePost, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeePost, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmployeePost)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmployeePost>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _employeePostId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _active;
	private Date _fromDate;
	private Date _toDate;
	private long _postId;
	private long _delegatedPostId;
	private long _employeeId;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<EmployeePost, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeePost)this);
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

		_columnOriginalValues.put("employeePostId", _employeePostId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("fromDate", _fromDate);
		_columnOriginalValues.put("toDate", _toDate);
		_columnOriginalValues.put("postId", _postId);
		_columnOriginalValues.put("delegatedPostId", _delegatedPostId);
		_columnOriginalValues.put("employeeId", _employeeId);
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

		columnBitmasks.put("employeePostId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("active_", 128L);

		columnBitmasks.put("fromDate", 256L);

		columnBitmasks.put("toDate", 512L);

		columnBitmasks.put("postId", 1024L);

		columnBitmasks.put("delegatedPostId", 2048L);

		columnBitmasks.put("employeeId", 4096L);

		columnBitmasks.put("status", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeePost _escapedModel;

}