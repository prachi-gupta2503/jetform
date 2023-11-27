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

import com.adjecti.mdm.liferay.model.Post;
import com.adjecti.mdm.liferay.service.PostLocalServiceUtil;

/**
 * The extended model base implementation for the Post service. Represents a row in the &quot;mdm_Post&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PostImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostImpl
 * @see Post
 * @generated
 */
public abstract class PostBaseImpl extends PostModelImpl implements Post {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a post model instance should use the <code>Post</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			PostLocalServiceUtil.addPost(this);
		}
		else {
			PostLocalServiceUtil.updatePost(this);
		}
	}

}