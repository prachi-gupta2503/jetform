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

import com.adjecti.pis.liferay.model.SampleProcess;
import com.adjecti.pis.liferay.model.SampleProcessModel;
import com.adjecti.pis.liferay.model.SampleProcessSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
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
 * The base model implementation for the SampleProcess service. Represents a row in the &quot;pis_SampleProcess&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SampleProcessModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SampleProcessImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SampleProcessImpl
 * @generated
 */
@JSON(strict = true)
public class SampleProcessModelImpl
	extends BaseModelImpl<SampleProcess> implements SampleProcessModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sample process model instance should use the <code>SampleProcess</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_SampleProcess";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"sampleProcessId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"processFileId", Types.BIGINT}, {"processFileNo", Types.BIGINT},
		{"notingContent", Types.VARCHAR},
		{"notingSubmittedDate", Types.TIMESTAMP},
		{"notingApprovedDate", Types.TIMESTAMP},
		{"processStatus", Types.INTEGER},
		{"processCompletedDate", Types.TIMESTAMP},
		{"reviewDate", Types.TIMESTAMP}, {"reviewerUserId", Types.BIGINT},
		{"approveDate", Types.TIMESTAMP}, {"approverUserId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sampleProcessId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("processFileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("processFileNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("notingContent", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("notingSubmittedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("notingApprovedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("processStatus", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("processCompletedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("reviewDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("reviewerUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("approveDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("approverUserId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_SampleProcess (uuid_ VARCHAR(75) null,sampleProcessId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,description VARCHAR(75) null,processFileId LONG,processFileNo LONG,notingContent VARCHAR(75) null,notingSubmittedDate DATE null,notingApprovedDate DATE null,processStatus INTEGER,processCompletedDate DATE null,reviewDate DATE null,reviewerUserId LONG,approveDate DATE null,approverUserId LONG)";

	public static final String TABLE_SQL_DROP = "drop table pis_SampleProcess";

	public static final String ORDER_BY_JPQL =
		" ORDER BY sampleProcess.createDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_SampleProcess.createDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long APPROVERUSERID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long REVIEWERUSERID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 32L;

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
	public static SampleProcess toModel(SampleProcessSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SampleProcess model = new SampleProcessImpl();

		model.setUuid(soapModel.getUuid());
		model.setSampleProcessId(soapModel.getSampleProcessId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setProcessFileId(soapModel.getProcessFileId());
		model.setProcessFileNo(soapModel.getProcessFileNo());
		model.setNotingContent(soapModel.getNotingContent());
		model.setNotingSubmittedDate(soapModel.getNotingSubmittedDate());
		model.setNotingApprovedDate(soapModel.getNotingApprovedDate());
		model.setProcessStatus(soapModel.getProcessStatus());
		model.setProcessCompletedDate(soapModel.getProcessCompletedDate());
		model.setReviewDate(soapModel.getReviewDate());
		model.setReviewerUserId(soapModel.getReviewerUserId());
		model.setApproveDate(soapModel.getApproveDate());
		model.setApproverUserId(soapModel.getApproverUserId());

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
	public static List<SampleProcess> toModels(SampleProcessSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SampleProcess> models = new ArrayList<SampleProcess>(
			soapModels.length);

		for (SampleProcessSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public SampleProcessModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _sampleProcessId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSampleProcessId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sampleProcessId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SampleProcess.class;
	}

	@Override
	public String getModelClassName() {
		return SampleProcess.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SampleProcess, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SampleProcess, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SampleProcess, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SampleProcess)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SampleProcess, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SampleProcess, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SampleProcess)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SampleProcess, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SampleProcess, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SampleProcess>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SampleProcess.class.getClassLoader(), SampleProcess.class,
			ModelWrapper.class);

		try {
			Constructor<SampleProcess> constructor =
				(Constructor<SampleProcess>)proxyClass.getConstructor(
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

	private static final Map<String, Function<SampleProcess, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SampleProcess, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SampleProcess, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SampleProcess, Object>>();
		Map<String, BiConsumer<SampleProcess, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SampleProcess, ?>>();

		attributeGetterFunctions.put("uuid", SampleProcess::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<SampleProcess, String>)SampleProcess::setUuid);
		attributeGetterFunctions.put(
			"sampleProcessId", SampleProcess::getSampleProcessId);
		attributeSetterBiConsumers.put(
			"sampleProcessId",
			(BiConsumer<SampleProcess, Long>)SampleProcess::setSampleProcessId);
		attributeGetterFunctions.put("groupId", SampleProcess::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<SampleProcess, Long>)SampleProcess::setGroupId);
		attributeGetterFunctions.put("companyId", SampleProcess::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SampleProcess, Long>)SampleProcess::setCompanyId);
		attributeGetterFunctions.put("userId", SampleProcess::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<SampleProcess, Long>)SampleProcess::setUserId);
		attributeGetterFunctions.put("userName", SampleProcess::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<SampleProcess, String>)SampleProcess::setUserName);
		attributeGetterFunctions.put(
			"createDate", SampleProcess::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SampleProcess, Date>)SampleProcess::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", SampleProcess::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<SampleProcess, Date>)SampleProcess::setModifiedDate);
		attributeGetterFunctions.put("name", SampleProcess::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<SampleProcess, String>)SampleProcess::setName);
		attributeGetterFunctions.put(
			"description", SampleProcess::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<SampleProcess, String>)SampleProcess::setDescription);
		attributeGetterFunctions.put(
			"processFileId", SampleProcess::getProcessFileId);
		attributeSetterBiConsumers.put(
			"processFileId",
			(BiConsumer<SampleProcess, Long>)SampleProcess::setProcessFileId);
		attributeGetterFunctions.put(
			"processFileNo", SampleProcess::getProcessFileNo);
		attributeSetterBiConsumers.put(
			"processFileNo",
			(BiConsumer<SampleProcess, Long>)SampleProcess::setProcessFileNo);
		attributeGetterFunctions.put(
			"notingContent", SampleProcess::getNotingContent);
		attributeSetterBiConsumers.put(
			"notingContent",
			(BiConsumer<SampleProcess, String>)SampleProcess::setNotingContent);
		attributeGetterFunctions.put(
			"notingSubmittedDate", SampleProcess::getNotingSubmittedDate);
		attributeSetterBiConsumers.put(
			"notingSubmittedDate",
			(BiConsumer<SampleProcess, Date>)
				SampleProcess::setNotingSubmittedDate);
		attributeGetterFunctions.put(
			"notingApprovedDate", SampleProcess::getNotingApprovedDate);
		attributeSetterBiConsumers.put(
			"notingApprovedDate",
			(BiConsumer<SampleProcess, Date>)
				SampleProcess::setNotingApprovedDate);
		attributeGetterFunctions.put(
			"processStatus", SampleProcess::getProcessStatus);
		attributeSetterBiConsumers.put(
			"processStatus",
			(BiConsumer<SampleProcess, Integer>)
				SampleProcess::setProcessStatus);
		attributeGetterFunctions.put(
			"processCompletedDate", SampleProcess::getProcessCompletedDate);
		attributeSetterBiConsumers.put(
			"processCompletedDate",
			(BiConsumer<SampleProcess, Date>)
				SampleProcess::setProcessCompletedDate);
		attributeGetterFunctions.put(
			"reviewDate", SampleProcess::getReviewDate);
		attributeSetterBiConsumers.put(
			"reviewDate",
			(BiConsumer<SampleProcess, Date>)SampleProcess::setReviewDate);
		attributeGetterFunctions.put(
			"reviewerUserId", SampleProcess::getReviewerUserId);
		attributeSetterBiConsumers.put(
			"reviewerUserId",
			(BiConsumer<SampleProcess, Long>)SampleProcess::setReviewerUserId);
		attributeGetterFunctions.put(
			"approveDate", SampleProcess::getApproveDate);
		attributeSetterBiConsumers.put(
			"approveDate",
			(BiConsumer<SampleProcess, Date>)SampleProcess::setApproveDate);
		attributeGetterFunctions.put(
			"approverUserId", SampleProcess::getApproverUserId);
		attributeSetterBiConsumers.put(
			"approverUserId",
			(BiConsumer<SampleProcess, Long>)SampleProcess::setApproverUserId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getSampleProcessId() {
		return _sampleProcessId;
	}

	@Override
	public void setSampleProcessId(long sampleProcessId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sampleProcessId = sampleProcessId;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
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
	public long getProcessFileId() {
		return _processFileId;
	}

	@Override
	public void setProcessFileId(long processFileId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_processFileId = processFileId;
	}

	@JSON
	@Override
	public long getProcessFileNo() {
		return _processFileNo;
	}

	@Override
	public void setProcessFileNo(long processFileNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_processFileNo = processFileNo;
	}

	@JSON
	@Override
	public String getNotingContent() {
		if (_notingContent == null) {
			return "";
		}
		else {
			return _notingContent;
		}
	}

	@Override
	public void setNotingContent(String notingContent) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_notingContent = notingContent;
	}

	@JSON
	@Override
	public Date getNotingSubmittedDate() {
		return _notingSubmittedDate;
	}

	@Override
	public void setNotingSubmittedDate(Date notingSubmittedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_notingSubmittedDate = notingSubmittedDate;
	}

	@JSON
	@Override
	public Date getNotingApprovedDate() {
		return _notingApprovedDate;
	}

	@Override
	public void setNotingApprovedDate(Date notingApprovedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_notingApprovedDate = notingApprovedDate;
	}

	@JSON
	@Override
	public int getProcessStatus() {
		return _processStatus;
	}

	@Override
	public void setProcessStatus(int processStatus) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_processStatus = processStatus;
	}

	@JSON
	@Override
	public Date getProcessCompletedDate() {
		return _processCompletedDate;
	}

	@Override
	public void setProcessCompletedDate(Date processCompletedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_processCompletedDate = processCompletedDate;
	}

	@JSON
	@Override
	public Date getReviewDate() {
		return _reviewDate;
	}

	@Override
	public void setReviewDate(Date reviewDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reviewDate = reviewDate;
	}

	@JSON
	@Override
	public long getReviewerUserId() {
		return _reviewerUserId;
	}

	@Override
	public void setReviewerUserId(long reviewerUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reviewerUserId = reviewerUserId;
	}

	@Override
	public String getReviewerUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getReviewerUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setReviewerUserUuid(String reviewerUserUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalReviewerUserId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("reviewerUserId"));
	}

	@JSON
	@Override
	public Date getApproveDate() {
		return _approveDate;
	}

	@Override
	public void setApproveDate(Date approveDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_approveDate = approveDate;
	}

	@JSON
	@Override
	public long getApproverUserId() {
		return _approverUserId;
	}

	@Override
	public void setApproverUserId(long approverUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_approverUserId = approverUserId;
	}

	@Override
	public String getApproverUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getApproverUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setApproverUserUuid(String approverUserUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalApproverUserId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("approverUserId"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(SampleProcess.class.getName()));
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
			getCompanyId(), SampleProcess.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SampleProcess toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SampleProcess>
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
		SampleProcessImpl sampleProcessImpl = new SampleProcessImpl();

		sampleProcessImpl.setUuid(getUuid());
		sampleProcessImpl.setSampleProcessId(getSampleProcessId());
		sampleProcessImpl.setGroupId(getGroupId());
		sampleProcessImpl.setCompanyId(getCompanyId());
		sampleProcessImpl.setUserId(getUserId());
		sampleProcessImpl.setUserName(getUserName());
		sampleProcessImpl.setCreateDate(getCreateDate());
		sampleProcessImpl.setModifiedDate(getModifiedDate());
		sampleProcessImpl.setName(getName());
		sampleProcessImpl.setDescription(getDescription());
		sampleProcessImpl.setProcessFileId(getProcessFileId());
		sampleProcessImpl.setProcessFileNo(getProcessFileNo());
		sampleProcessImpl.setNotingContent(getNotingContent());
		sampleProcessImpl.setNotingSubmittedDate(getNotingSubmittedDate());
		sampleProcessImpl.setNotingApprovedDate(getNotingApprovedDate());
		sampleProcessImpl.setProcessStatus(getProcessStatus());
		sampleProcessImpl.setProcessCompletedDate(getProcessCompletedDate());
		sampleProcessImpl.setReviewDate(getReviewDate());
		sampleProcessImpl.setReviewerUserId(getReviewerUserId());
		sampleProcessImpl.setApproveDate(getApproveDate());
		sampleProcessImpl.setApproverUserId(getApproverUserId());

		sampleProcessImpl.resetOriginalValues();

		return sampleProcessImpl;
	}

	@Override
	public int compareTo(SampleProcess sampleProcess) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), sampleProcess.getCreateDate());

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

		if (!(object instanceof SampleProcess)) {
			return false;
		}

		SampleProcess sampleProcess = (SampleProcess)object;

		long primaryKey = sampleProcess.getPrimaryKey();

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
	public CacheModel<SampleProcess> toCacheModel() {
		SampleProcessCacheModel sampleProcessCacheModel =
			new SampleProcessCacheModel();

		sampleProcessCacheModel.uuid = getUuid();

		String uuid = sampleProcessCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			sampleProcessCacheModel.uuid = null;
		}

		sampleProcessCacheModel.sampleProcessId = getSampleProcessId();

		sampleProcessCacheModel.groupId = getGroupId();

		sampleProcessCacheModel.companyId = getCompanyId();

		sampleProcessCacheModel.userId = getUserId();

		sampleProcessCacheModel.userName = getUserName();

		String userName = sampleProcessCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			sampleProcessCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			sampleProcessCacheModel.createDate = createDate.getTime();
		}
		else {
			sampleProcessCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			sampleProcessCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			sampleProcessCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		sampleProcessCacheModel.name = getName();

		String name = sampleProcessCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			sampleProcessCacheModel.name = null;
		}

		sampleProcessCacheModel.description = getDescription();

		String description = sampleProcessCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			sampleProcessCacheModel.description = null;
		}

		sampleProcessCacheModel.processFileId = getProcessFileId();

		sampleProcessCacheModel.processFileNo = getProcessFileNo();

		sampleProcessCacheModel.notingContent = getNotingContent();

		String notingContent = sampleProcessCacheModel.notingContent;

		if ((notingContent != null) && (notingContent.length() == 0)) {
			sampleProcessCacheModel.notingContent = null;
		}

		Date notingSubmittedDate = getNotingSubmittedDate();

		if (notingSubmittedDate != null) {
			sampleProcessCacheModel.notingSubmittedDate =
				notingSubmittedDate.getTime();
		}
		else {
			sampleProcessCacheModel.notingSubmittedDate = Long.MIN_VALUE;
		}

		Date notingApprovedDate = getNotingApprovedDate();

		if (notingApprovedDate != null) {
			sampleProcessCacheModel.notingApprovedDate =
				notingApprovedDate.getTime();
		}
		else {
			sampleProcessCacheModel.notingApprovedDate = Long.MIN_VALUE;
		}

		sampleProcessCacheModel.processStatus = getProcessStatus();

		Date processCompletedDate = getProcessCompletedDate();

		if (processCompletedDate != null) {
			sampleProcessCacheModel.processCompletedDate =
				processCompletedDate.getTime();
		}
		else {
			sampleProcessCacheModel.processCompletedDate = Long.MIN_VALUE;
		}

		Date reviewDate = getReviewDate();

		if (reviewDate != null) {
			sampleProcessCacheModel.reviewDate = reviewDate.getTime();
		}
		else {
			sampleProcessCacheModel.reviewDate = Long.MIN_VALUE;
		}

		sampleProcessCacheModel.reviewerUserId = getReviewerUserId();

		Date approveDate = getApproveDate();

		if (approveDate != null) {
			sampleProcessCacheModel.approveDate = approveDate.getTime();
		}
		else {
			sampleProcessCacheModel.approveDate = Long.MIN_VALUE;
		}

		sampleProcessCacheModel.approverUserId = getApproverUserId();

		return sampleProcessCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SampleProcess, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SampleProcess, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SampleProcess, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((SampleProcess)this));
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
		Map<String, Function<SampleProcess, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SampleProcess, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SampleProcess, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SampleProcess)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SampleProcess>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _sampleProcessId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _description;
	private long _processFileId;
	private long _processFileNo;
	private String _notingContent;
	private Date _notingSubmittedDate;
	private Date _notingApprovedDate;
	private int _processStatus;
	private Date _processCompletedDate;
	private Date _reviewDate;
	private long _reviewerUserId;
	private Date _approveDate;
	private long _approverUserId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<SampleProcess, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((SampleProcess)this);
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

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("sampleProcessId", _sampleProcessId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("processFileId", _processFileId);
		_columnOriginalValues.put("processFileNo", _processFileNo);
		_columnOriginalValues.put("notingContent", _notingContent);
		_columnOriginalValues.put("notingSubmittedDate", _notingSubmittedDate);
		_columnOriginalValues.put("notingApprovedDate", _notingApprovedDate);
		_columnOriginalValues.put("processStatus", _processStatus);
		_columnOriginalValues.put(
			"processCompletedDate", _processCompletedDate);
		_columnOriginalValues.put("reviewDate", _reviewDate);
		_columnOriginalValues.put("reviewerUserId", _reviewerUserId);
		_columnOriginalValues.put("approveDate", _approveDate);
		_columnOriginalValues.put("approverUserId", _approverUserId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("sampleProcessId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("name", 256L);

		columnBitmasks.put("description", 512L);

		columnBitmasks.put("processFileId", 1024L);

		columnBitmasks.put("processFileNo", 2048L);

		columnBitmasks.put("notingContent", 4096L);

		columnBitmasks.put("notingSubmittedDate", 8192L);

		columnBitmasks.put("notingApprovedDate", 16384L);

		columnBitmasks.put("processStatus", 32768L);

		columnBitmasks.put("processCompletedDate", 65536L);

		columnBitmasks.put("reviewDate", 131072L);

		columnBitmasks.put("reviewerUserId", 262144L);

		columnBitmasks.put("approveDate", 524288L);

		columnBitmasks.put("approverUserId", 1048576L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private SampleProcess _escapedModel;

}