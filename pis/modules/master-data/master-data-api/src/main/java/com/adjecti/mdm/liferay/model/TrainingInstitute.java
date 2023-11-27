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

package com.adjecti.mdm.liferay.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the TrainingInstitute service. Represents a row in the &quot;mdm_TrainingInstitute&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingInstituteModel
 * @generated
 */
@ImplementationClassName(
	"com.adjecti.mdm.liferay.model.impl.TrainingInstituteImpl"
)
@ProviderType
public interface TrainingInstitute
	extends PersistedModel, TrainingInstituteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.adjecti.mdm.liferay.model.impl.TrainingInstituteImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TrainingInstitute, Long>
		TRAINING_INSTITUTE_ID_ACCESSOR =
			new Accessor<TrainingInstitute, Long>() {

				@Override
				public Long get(TrainingInstitute trainingInstitute) {
					return trainingInstitute.getTrainingInstituteId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<TrainingInstitute> getTypeClass() {
					return TrainingInstitute.class;
				}

			};

}