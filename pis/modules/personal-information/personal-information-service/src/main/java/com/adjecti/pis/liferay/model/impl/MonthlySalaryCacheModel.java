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

import com.adjecti.pis.liferay.model.MonthlySalary;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MonthlySalary in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MonthlySalaryCacheModel
	implements CacheModel<MonthlySalary>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MonthlySalaryCacheModel)) {
			return false;
		}

		MonthlySalaryCacheModel monthlySalaryCacheModel =
			(MonthlySalaryCacheModel)object;

		if (monthlySalaryId == monthlySalaryCacheModel.monthlySalaryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, monthlySalaryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{monthlySalaryId=");
		sb.append(monthlySalaryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", grossDeduction=");
		sb.append(grossDeduction);
		sb.append(", grossIncome=");
		sb.append(grossIncome);
		sb.append(", netPayble=");
		sb.append(netPayble);
		sb.append(", processMonth=");
		sb.append(processMonth);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", structureId=");
		sb.append(structureId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MonthlySalary toEntityModel() {
		MonthlySalaryImpl monthlySalaryImpl = new MonthlySalaryImpl();

		monthlySalaryImpl.setMonthlySalaryId(monthlySalaryId);
		monthlySalaryImpl.setGroupId(groupId);
		monthlySalaryImpl.setCompanyId(companyId);
		monthlySalaryImpl.setUserId(userId);

		if (userName == null) {
			monthlySalaryImpl.setUserName("");
		}
		else {
			monthlySalaryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			monthlySalaryImpl.setCreateDate(null);
		}
		else {
			monthlySalaryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			monthlySalaryImpl.setModifiedDate(null);
		}
		else {
			monthlySalaryImpl.setModifiedDate(new Date(modifiedDate));
		}

		monthlySalaryImpl.setGrossDeduction(grossDeduction);
		monthlySalaryImpl.setGrossIncome(grossIncome);
		monthlySalaryImpl.setNetPayble(netPayble);

		if (processMonth == Long.MIN_VALUE) {
			monthlySalaryImpl.setProcessMonth(null);
		}
		else {
			monthlySalaryImpl.setProcessMonth(new Date(processMonth));
		}

		monthlySalaryImpl.setEmployeeId(employeeId);
		monthlySalaryImpl.setStructureId(structureId);

		monthlySalaryImpl.resetOriginalValues();

		return monthlySalaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		monthlySalaryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		grossDeduction = objectInput.readFloat();

		grossIncome = objectInput.readFloat();

		netPayble = objectInput.readFloat();
		processMonth = objectInput.readLong();

		employeeId = objectInput.readLong();

		structureId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(monthlySalaryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeFloat(grossDeduction);

		objectOutput.writeFloat(grossIncome);

		objectOutput.writeFloat(netPayble);
		objectOutput.writeLong(processMonth);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(structureId);
	}

	public long monthlySalaryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public float grossDeduction;
	public float grossIncome;
	public float netPayble;
	public long processMonth;
	public long employeeId;
	public long structureId;

}