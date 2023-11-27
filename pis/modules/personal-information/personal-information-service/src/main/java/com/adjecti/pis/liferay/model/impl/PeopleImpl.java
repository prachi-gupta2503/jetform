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

/**
 * The extended model implementation for the People service. Represents a row in the &quot;pis_People&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.model.People</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class PeopleImpl extends PeopleBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a people model instance should use the {@link com.adjecti.pis.liferay.model.People} interface instead.
	 */
	public PeopleImpl() {
	}

	public String getName() {
		return getName_En();
	}
	
	public String getName_En() {
		return getFirstName_En().concat(
				(getMiddleName_En()!=null && !getMiddleName_En().isEmpty())?" "+getMiddleName_En():"").concat(
						(getLastName_En()!=null && !getLastName_En().isEmpty())?" "+getLastName_En():"");
	}
	
	public String getName_Hi() {
		return getFirstName_Hi().concat(
				(getMiddleName_Hi()!=null && !getMiddleName_Hi().isEmpty())?" "+getMiddleName_Hi():"").concat(
						(getLastName_Hi()!=null && !getLastName_Hi().isEmpty())?" "+getLastName_Hi():"");
	}
}