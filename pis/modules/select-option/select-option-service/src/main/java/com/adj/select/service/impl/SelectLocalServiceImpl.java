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

package com.adj.select.service.impl;

import com.adj.select.dto.SelectOptionsDTO;
import com.adj.select.exception.NoSuchSelectException;
import com.adj.select.service.base.SelectLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the select local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adj.select.service.SelectLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SelectLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adj.select.model.Select",
	service = AopService.class
)
public class SelectLocalServiceImpl extends SelectLocalServiceBaseImpl {

	public List<SelectOptionsDTO> getSelectOptionsData(String idFieldName, String valueFieldName, String tableName)
			throws NoSuchSelectException {
		return selectFinder.getSelectOptionsData(idFieldName, valueFieldName, tableName);
	}
}