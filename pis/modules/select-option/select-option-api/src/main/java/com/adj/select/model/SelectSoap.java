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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adj.select.service.http.SelectServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SelectSoap implements Serializable {

	public static SelectSoap toSoapModel(Select model) {
		SelectSoap soapModel = new SelectSoap();

		soapModel.setIdFieldName(model.getIdFieldName());
		soapModel.setValueFieldName(model.getValueFieldName());
		soapModel.setTableName(model.getTableName());

		return soapModel;
	}

	public static SelectSoap[] toSoapModels(Select[] models) {
		SelectSoap[] soapModels = new SelectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SelectSoap[][] toSoapModels(Select[][] models) {
		SelectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SelectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SelectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SelectSoap[] toSoapModels(List<Select> models) {
		List<SelectSoap> soapModels = new ArrayList<SelectSoap>(models.size());

		for (Select model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SelectSoap[soapModels.size()]);
	}

	public SelectSoap() {
	}

	public String getPrimaryKey() {
		return _idFieldName;
	}

	public void setPrimaryKey(String pk) {
		setIdFieldName(pk);
	}

	public String getIdFieldName() {
		return _idFieldName;
	}

	public void setIdFieldName(String idFieldName) {
		_idFieldName = idFieldName;
	}

	public String getValueFieldName() {
		return _valueFieldName;
	}

	public void setValueFieldName(String valueFieldName) {
		_valueFieldName = valueFieldName;
	}

	public String getTableName() {
		return _tableName;
	}

	public void setTableName(String tableName) {
		_tableName = tableName;
	}

	private String _idFieldName;
	private String _valueFieldName;
	private String _tableName;

}