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

package net.ayudh.comnet.admin.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.sql.DataSource;

import net.ayudh.comnet.admin.model.ApplicationAccess;
import net.ayudh.comnet.admin.service.ApplicationAccessService;
import net.ayudh.comnet.admin.service.persistence.ApplicationAccessPersistence;
import net.ayudh.comnet.admin.service.persistence.ApplicationUserPersistence;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the application access remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link net.ayudh.comnet.admin.service.impl.ApplicationAccessServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see net.ayudh.comnet.admin.service.impl.ApplicationAccessServiceImpl
 * @generated
 */
public abstract class ApplicationAccessServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, ApplicationAccessService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ApplicationAccessService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>net.ayudh.comnet.admin.service.ApplicationAccessServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ApplicationAccessService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		applicationAccessService = (ApplicationAccessService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ApplicationAccessService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ApplicationAccess.class;
	}

	protected String getModelClassName() {
		return ApplicationAccess.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				applicationAccessPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected net.ayudh.comnet.admin.service.ApplicationAccessLocalService
		applicationAccessLocalService;

	protected ApplicationAccessService applicationAccessService;

	@Reference
	protected ApplicationAccessPersistence applicationAccessPersistence;

	@Reference
	protected ApplicationUserPersistence applicationUserPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}