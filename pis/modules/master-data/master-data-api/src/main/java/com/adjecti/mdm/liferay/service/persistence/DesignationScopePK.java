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

package com.adjecti.mdm.liferay.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DesignationScopePK
	implements Comparable<DesignationScopePK>, Serializable {

	public long designationScopeId;
	public long designationId;

	public DesignationScopePK() {
	}

	public DesignationScopePK(long designationScopeId, long designationId) {
		this.designationScopeId = designationScopeId;
		this.designationId = designationId;
	}

	public long getDesignationScopeId() {
		return designationScopeId;
	}

	public void setDesignationScopeId(long designationScopeId) {
		this.designationScopeId = designationScopeId;
	}

	public long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	@Override
	public int compareTo(DesignationScopePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (designationScopeId < pk.designationScopeId) {
			value = -1;
		}
		else if (designationScopeId > pk.designationScopeId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (designationId < pk.designationId) {
			value = -1;
		}
		else if (designationId > pk.designationId) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(object instanceof DesignationScopePK)) {
			return false;
		}

		DesignationScopePK pk = (DesignationScopePK)object;

		if ((designationScopeId == pk.designationScopeId) &&
			(designationId == pk.designationId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, designationScopeId);
		hashCode = HashUtil.hash(hashCode, designationId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("designationScopeId=");

		sb.append(designationScopeId);
		sb.append(", designationId=");

		sb.append(designationId);

		sb.append("}");

		return sb.toString();
	}

}