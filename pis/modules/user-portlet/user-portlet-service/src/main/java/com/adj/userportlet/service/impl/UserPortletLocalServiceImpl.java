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

package com.adj.userportlet.service.impl;

import com.adj.userportlet.exception.NoSuchUserPortletException;
import com.adj.userportlet.model.UserPortlet;
import com.adj.userportlet.service.base.UserPortletLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the user portlet local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adj.userportlet.service.UserPortletLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPortletLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adj.userportlet.model.UserPortlet", service = AopService.class)
public class UserPortletLocalServiceImpl extends UserPortletLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.adj.userportlet.service.UserPortletLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.adj.userportlet.service.UserPortletLocalServiceUtil</code>.
	 */

	public UserPortlet getuserPortletByPortletId(String portletId) throws NoSuchUserPortletException {

		return userPortletPersistence.findByPortletId(portletId);
	}

	public List<Organization> getAllOrganizations() {
		List<Organization> organizations = null;

		organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
		List<Organization> org = new ArrayList<Organization>(organizations);

		Comparator<Organization> compareById = (Organization organization1,
				Organization organization2) -> (int) (organization1.getOrganizationId()
						- organization2.getOrganizationId());

		Collections.sort(org, compareById);

		return org;

	}

}