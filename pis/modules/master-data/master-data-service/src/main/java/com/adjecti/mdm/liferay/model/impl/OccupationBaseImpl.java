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

import com.adjecti.mdm.liferay.model.Occupation;
import com.adjecti.mdm.liferay.service.OccupationLocalServiceUtil;

/**
 * The extended model base implementation for the Occupation service. Represents a row in the &quot;mdm_Occupation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OccupationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OccupationImpl
 * @see Occupation
 * @generated
 */
public abstract class OccupationBaseImpl
	extends OccupationModelImpl implements Occupation {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a occupation model instance should use the <code>Occupation</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			OccupationLocalServiceUtil.addOccupation(this);
		}
		else {
			OccupationLocalServiceUtil.updateOccupation(this);
		}
	}

}