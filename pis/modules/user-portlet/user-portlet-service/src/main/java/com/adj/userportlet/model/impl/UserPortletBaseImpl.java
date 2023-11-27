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

package com.adj.userportlet.model.impl;

import com.adj.userportlet.model.UserPortlet;
import com.adj.userportlet.service.UserPortletLocalServiceUtil;

/**
 * The extended model base implementation for the UserPortlet service. Represents a row in the &quot;UP_UserPortlet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserPortletImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPortletImpl
 * @see UserPortlet
 * @generated
 */
public abstract class UserPortletBaseImpl
	extends UserPortletModelImpl implements UserPortlet {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user portlet model instance should use the <code>UserPortlet</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			UserPortletLocalServiceUtil.addUserPortlet(this);
		}
		else {
			UserPortletLocalServiceUtil.updateUserPortlet(this);
		}
	}

}