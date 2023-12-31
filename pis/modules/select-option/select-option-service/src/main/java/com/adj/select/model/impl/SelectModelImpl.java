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

package com.adj.select.model.impl;

import com.adj.select.model.Select;
import com.adj.select.model.SelectModel;
import com.adj.select.model.SelectSoap;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Select service. Represents a row in the &quot;select_option_Select&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SelectModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SelectImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SelectImpl
 * @generated
 */
@JSON(strict = true)
public class SelectModelImpl
	extends BaseModelImpl<Select> implements SelectModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a select model instance should use the <code>Select</code> interface instead.
	 */
	public static final String TABLE_NAME = "select_option_Select";

	public static final Object[][] TABLE_COLUMNS = {
		{"idFieldName", Types.VARCHAR}, {"valueFieldName", Types.VARCHAR},
		{"tableName", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("idFieldName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("valueFieldName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tableName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table select_option_Select (idFieldName VARCHAR(75) not null primary key,valueFieldName VARCHAR(75) null,tableName VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table select_option_Select";

	public static final String ORDER_BY_JPQL =
		" ORDER BY select_.idFieldName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY select_option_Select.idFieldName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Select toModel(SelectSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Select model = new SelectImpl();

		model.setIdFieldName(soapModel.getIdFieldName());
		model.setValueFieldName(soapModel.getValueFieldName());
		model.setTableName(soapModel.getTableName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Select> toModels(SelectSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Select> models = new ArrayList<Select>(soapModels.length);

		for (SelectSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public SelectModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _idFieldName;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setIdFieldName(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idFieldName;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Select.class;
	}

	@Override
	public String getModelClassName() {
		return Select.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Select, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Select, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Select, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Select)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Select, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Select, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Select)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Select, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Select, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Select>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Select.class.getClassLoader(), Select.class, ModelWrapper.class);

		try {
			Constructor<Select> constructor =
				(Constructor<Select>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Select, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Select, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Select, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Select, Object>>();
		Map<String, BiConsumer<Select, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Select, ?>>();

		attributeGetterFunctions.put("idFieldName", Select::getIdFieldName);
		attributeSetterBiConsumers.put(
			"idFieldName", (BiConsumer<Select, String>)Select::setIdFieldName);
		attributeGetterFunctions.put(
			"valueFieldName", Select::getValueFieldName);
		attributeSetterBiConsumers.put(
			"valueFieldName",
			(BiConsumer<Select, String>)Select::setValueFieldName);
		attributeGetterFunctions.put("tableName", Select::getTableName);
		attributeSetterBiConsumers.put(
			"tableName", (BiConsumer<Select, String>)Select::setTableName);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getIdFieldName() {
		if (_idFieldName == null) {
			return "";
		}
		else {
			return _idFieldName;
		}
	}

	@Override
	public void setIdFieldName(String idFieldName) {
		_idFieldName = idFieldName;
	}

	@JSON
	@Override
	public String getValueFieldName() {
		if (_valueFieldName == null) {
			return "";
		}
		else {
			return _valueFieldName;
		}
	}

	@Override
	public void setValueFieldName(String valueFieldName) {
		_valueFieldName = valueFieldName;
	}

	@JSON
	@Override
	public String getTableName() {
		if (_tableName == null) {
			return "";
		}
		else {
			return _tableName;
		}
	}

	@Override
	public void setTableName(String tableName) {
		_tableName = tableName;
	}

	@Override
	public Select toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Select>
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
		SelectImpl selectImpl = new SelectImpl();

		selectImpl.setIdFieldName(getIdFieldName());
		selectImpl.setValueFieldName(getValueFieldName());
		selectImpl.setTableName(getTableName());

		selectImpl.resetOriginalValues();

		return selectImpl;
	}

	@Override
	public int compareTo(Select select) {
		String primaryKey = select.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Select)) {
			return false;
		}

		Select select = (Select)object;

		String primaryKey = select.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Select> toCacheModel() {
		SelectCacheModel selectCacheModel = new SelectCacheModel();

		selectCacheModel.idFieldName = getIdFieldName();

		String idFieldName = selectCacheModel.idFieldName;

		if ((idFieldName != null) && (idFieldName.length() == 0)) {
			selectCacheModel.idFieldName = null;
		}

		selectCacheModel.valueFieldName = getValueFieldName();

		String valueFieldName = selectCacheModel.valueFieldName;

		if ((valueFieldName != null) && (valueFieldName.length() == 0)) {
			selectCacheModel.valueFieldName = null;
		}

		selectCacheModel.tableName = getTableName();

		String tableName = selectCacheModel.tableName;

		if ((tableName != null) && (tableName.length() == 0)) {
			selectCacheModel.tableName = null;
		}

		return selectCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Select, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Select, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Select, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Select)this));
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
		Map<String, Function<Select, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Select, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Select, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Select)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Select>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _idFieldName;
	private String _valueFieldName;
	private String _tableName;
	private Select _escapedModel;

}