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

import com.adjecti.mdm.liferay.model.PostReporting;
import com.adjecti.mdm.liferay.model.PostReportingModel;
import com.adjecti.mdm.liferay.model.PostReportingSoap;

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
 * The base model implementation for the PostReporting service. Represents a row in the &quot;mdm_PostReporting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PostReportingModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PostReportingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostReportingImpl
 * @generated
 */
@JSON(strict = true)
public class PostReportingModelImpl
	extends BaseModelImpl<PostReporting> implements PostReportingModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a post reporting model instance should use the <code>PostReporting</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_PostReporting";

	public static final Object[][] TABLE_COLUMNS = {
		{"postReportingId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"reporteePostId", Types.BIGINT},
		{"reporterPostId", Types.BIGINT}, {"deleted", Types.BOOLEAN},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("postReportingId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("reporteePostId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("reporterPostId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_PostReporting (postReportingId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,reporteePostId LONG,reporterPostId LONG,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table mdm_PostReporting";

	public static final String ORDER_BY_JPQL =
		" ORDER BY postReporting.postReportingId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_PostReporting.postReportingId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long POSTREPORTINGID_COLUMN_BITMASK = 1L;

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
	public static PostReporting toModel(PostReportingSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PostReporting model = new PostReportingImpl();

		model.setPostReportingId(soapModel.getPostReportingId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setReporteePostId(soapModel.getReporteePostId());
		model.setReporterPostId(soapModel.getReporterPostId());
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
	public static List<PostReporting> toModels(PostReportingSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PostReporting> models = new ArrayList<PostReporting>(
			soapModels.length);

		for (PostReportingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PostReportingModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _postReportingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPostReportingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _postReportingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PostReporting.class;
	}

	@Override
	public String getModelClassName() {
		return PostReporting.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PostReporting, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PostReporting, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PostReporting, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((PostReporting)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PostReporting, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PostReporting, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PostReporting)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PostReporting, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PostReporting, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PostReporting>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PostReporting.class.getClassLoader(), PostReporting.class,
			ModelWrapper.class);

		try {
			Constructor<PostReporting> constructor =
				(Constructor<PostReporting>)proxyClass.getConstructor(
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

	private static final Map<String, Function<PostReporting, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PostReporting, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PostReporting, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<PostReporting, Object>>();
		Map<String, BiConsumer<PostReporting, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<PostReporting, ?>>();

		attributeGetterFunctions.put(
			"postReportingId", PostReporting::getPostReportingId);
		attributeSetterBiConsumers.put(
			"postReportingId",
			(BiConsumer<PostReporting, Long>)PostReporting::setPostReportingId);
		attributeGetterFunctions.put("groupId", PostReporting::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<PostReporting, Long>)PostReporting::setGroupId);
		attributeGetterFunctions.put("companyId", PostReporting::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<PostReporting, Long>)PostReporting::setCompanyId);
		attributeGetterFunctions.put("userId", PostReporting::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<PostReporting, Long>)PostReporting::setUserId);
		attributeGetterFunctions.put("userName", PostReporting::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<PostReporting, String>)PostReporting::setUserName);
		attributeGetterFunctions.put(
			"createDate", PostReporting::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<PostReporting, Date>)PostReporting::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", PostReporting::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<PostReporting, Date>)PostReporting::setModifiedDate);
		attributeGetterFunctions.put(
			"reporteePostId", PostReporting::getReporteePostId);
		attributeSetterBiConsumers.put(
			"reporteePostId",
			(BiConsumer<PostReporting, Long>)PostReporting::setReporteePostId);
		attributeGetterFunctions.put(
			"reporterPostId", PostReporting::getReporterPostId);
		attributeSetterBiConsumers.put(
			"reporterPostId",
			(BiConsumer<PostReporting, Long>)PostReporting::setReporterPostId);
		attributeGetterFunctions.put("deleted", PostReporting::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<PostReporting, Boolean>)PostReporting::setDeleted);
		attributeGetterFunctions.put("status", PostReporting::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<PostReporting, Integer>)PostReporting::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getPostReportingId() {
		return _postReportingId;
	}

	@Override
	public void setPostReportingId(long postReportingId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_postReportingId = postReportingId;
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
	public long getReporteePostId() {
		return _reporteePostId;
	}

	@Override
	public void setReporteePostId(long reporteePostId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reporteePostId = reporteePostId;
	}

	@JSON
	@Override
	public long getReporterPostId() {
		return _reporterPostId;
	}

	@Override
	public void setReporterPostId(long reporterPostId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reporterPostId = reporterPostId;
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
			getCompanyId(), PostReporting.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PostReporting toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PostReporting>
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
		PostReportingImpl postReportingImpl = new PostReportingImpl();

		postReportingImpl.setPostReportingId(getPostReportingId());
		postReportingImpl.setGroupId(getGroupId());
		postReportingImpl.setCompanyId(getCompanyId());
		postReportingImpl.setUserId(getUserId());
		postReportingImpl.setUserName(getUserName());
		postReportingImpl.setCreateDate(getCreateDate());
		postReportingImpl.setModifiedDate(getModifiedDate());
		postReportingImpl.setReporteePostId(getReporteePostId());
		postReportingImpl.setReporterPostId(getReporterPostId());
		postReportingImpl.setDeleted(isDeleted());
		postReportingImpl.setStatus(getStatus());

		postReportingImpl.resetOriginalValues();

		return postReportingImpl;
	}

	@Override
	public int compareTo(PostReporting postReporting) {
		long primaryKey = postReporting.getPrimaryKey();

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

		if (!(object instanceof PostReporting)) {
			return false;
		}

		PostReporting postReporting = (PostReporting)object;

		long primaryKey = postReporting.getPrimaryKey();

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
	public CacheModel<PostReporting> toCacheModel() {
		PostReportingCacheModel postReportingCacheModel =
			new PostReportingCacheModel();

		postReportingCacheModel.postReportingId = getPostReportingId();

		postReportingCacheModel.groupId = getGroupId();

		postReportingCacheModel.companyId = getCompanyId();

		postReportingCacheModel.userId = getUserId();

		postReportingCacheModel.userName = getUserName();

		String userName = postReportingCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			postReportingCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			postReportingCacheModel.createDate = createDate.getTime();
		}
		else {
			postReportingCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			postReportingCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			postReportingCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		postReportingCacheModel.reporteePostId = getReporteePostId();

		postReportingCacheModel.reporterPostId = getReporterPostId();

		postReportingCacheModel.deleted = isDeleted();

		postReportingCacheModel.status = getStatus();

		return postReportingCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PostReporting, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PostReporting, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PostReporting, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PostReporting)this));
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
		Map<String, Function<PostReporting, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PostReporting, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PostReporting, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PostReporting)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PostReporting>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _postReportingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _reporteePostId;
	private long _reporterPostId;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		Function<PostReporting, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((PostReporting)this);
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

		_columnOriginalValues.put("postReportingId", _postReportingId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("reporteePostId", _reporteePostId);
		_columnOriginalValues.put("reporterPostId", _reporterPostId);
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

		columnBitmasks.put("postReportingId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("reporteePostId", 128L);

		columnBitmasks.put("reporterPostId", 256L);

		columnBitmasks.put("deleted", 512L);

		columnBitmasks.put("status", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private PostReporting _escapedModel;

}