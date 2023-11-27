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

package com.adjecti.mdm.liferay.service.impl;

import com.adjecti.mdm.liferay.exception.NoSuchDocumentTypeException;
import com.adjecti.mdm.liferay.model.DocumentType;
import com.adjecti.mdm.liferay.service.base.DocumentTypeLocalServiceBaseImpl;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the document type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.DocumentTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.mdm.liferay.model.DocumentType",
	service = AopService.class
)
public class DocumentTypeLocalServiceImpl
	extends DocumentTypeLocalServiceBaseImpl {
	
	private final static Log _logger = LogFactoryUtil.getLog(DocumentTypeLocalServiceImpl.class.getName());

	public long getDocumentTypeIdByName(String name) {
		DocumentType documentType=null;
		try {
			documentType=documentTypePersistence.findByDocumentTypeName(name);
		} catch (NoSuchDocumentTypeException e) {
			_logger.error(e);
		}
		return documentType.getDocumentTypeId();
	}
}