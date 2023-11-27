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

import com.adjecti.mdm.liferay.model.TrainingInstitute;
import com.adjecti.mdm.liferay.service.TrainingInstituteLocalServiceUtil;

/**
 * The extended model base implementation for the TrainingInstitute service. Represents a row in the &quot;mdm_TrainingInstitute&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TrainingInstituteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingInstituteImpl
 * @see TrainingInstitute
 * @generated
 */
public abstract class TrainingInstituteBaseImpl
	extends TrainingInstituteModelImpl implements TrainingInstitute {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a training institute model instance should use the <code>TrainingInstitute</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			TrainingInstituteLocalServiceUtil.addTrainingInstitute(this);
		}
		else {
			TrainingInstituteLocalServiceUtil.updateTrainingInstitute(this);
		}
	}

}