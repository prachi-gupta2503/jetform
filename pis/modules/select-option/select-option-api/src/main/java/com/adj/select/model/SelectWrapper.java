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

package com.adj.select.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Select}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Select
 * @generated
 */
public class SelectWrapper
	extends BaseModelWrapper<Select> implements ModelWrapper<Select>, Select {

	public SelectWrapper(Select select) {
		super(select);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idFieldName", getIdFieldName());
		attributes.put("valueFieldName", getValueFieldName());
		attributes.put("tableName", getTableName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String idFieldName = (String)attributes.get("idFieldName");

		if (idFieldName != null) {
			setIdFieldName(idFieldName);
		}

		String valueFieldName = (String)attributes.get("valueFieldName");

		if (valueFieldName != null) {
			setValueFieldName(valueFieldName);
		}

		String tableName = (String)attributes.get("tableName");

		if (tableName != null) {
			setTableName(tableName);
		}
	}

	/**
	 * Returns the id field name of this select.
	 *
	 * @return the id field name of this select
	 */
	@Override
	public String getIdFieldName() {
		return model.getIdFieldName();
	}

	/**
	 * Returns the primary key of this select.
	 *
	 * @return the primary key of this select
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the table name of this select.
	 *
	 * @return the table name of this select
	 */
	@Override
	public String getTableName() {
		return model.getTableName();
	}

	/**
	 * Returns the value field name of this select.
	 *
	 * @return the value field name of this select
	 */
	@Override
	public String getValueFieldName() {
		return model.getValueFieldName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the id field name of this select.
	 *
	 * @param idFieldName the id field name of this select
	 */
	@Override
	public void setIdFieldName(String idFieldName) {
		model.setIdFieldName(idFieldName);
	}

	/**
	 * Sets the primary key of this select.
	 *
	 * @param primaryKey the primary key of this select
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the table name of this select.
	 *
	 * @param tableName the table name of this select
	 */
	@Override
	public void setTableName(String tableName) {
		model.setTableName(tableName);
	}

	/**
	 * Sets the value field name of this select.
	 *
	 * @param valueFieldName the value field name of this select
	 */
	@Override
	public void setValueFieldName(String valueFieldName) {
		model.setValueFieldName(valueFieldName);
	}

	@Override
	protected SelectWrapper wrap(Select select) {
		return new SelectWrapper(select);
	}

}