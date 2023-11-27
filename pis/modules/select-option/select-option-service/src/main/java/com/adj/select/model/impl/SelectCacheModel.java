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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Select in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SelectCacheModel implements CacheModel<Select>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SelectCacheModel)) {
			return false;
		}

		SelectCacheModel selectCacheModel = (SelectCacheModel)object;

		if (idFieldName.equals(selectCacheModel.idFieldName)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, idFieldName);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{idFieldName=");
		sb.append(idFieldName);
		sb.append(", valueFieldName=");
		sb.append(valueFieldName);
		sb.append(", tableName=");
		sb.append(tableName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Select toEntityModel() {
		SelectImpl selectImpl = new SelectImpl();

		if (idFieldName == null) {
			selectImpl.setIdFieldName("");
		}
		else {
			selectImpl.setIdFieldName(idFieldName);
		}

		if (valueFieldName == null) {
			selectImpl.setValueFieldName("");
		}
		else {
			selectImpl.setValueFieldName(valueFieldName);
		}

		if (tableName == null) {
			selectImpl.setTableName("");
		}
		else {
			selectImpl.setTableName(tableName);
		}

		selectImpl.resetOriginalValues();

		return selectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idFieldName = objectInput.readUTF();
		valueFieldName = objectInput.readUTF();
		tableName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (idFieldName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idFieldName);
		}

		if (valueFieldName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(valueFieldName);
		}

		if (tableName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tableName);
		}
	}

	public String idFieldName;
	public String valueFieldName;
	public String tableName;

}