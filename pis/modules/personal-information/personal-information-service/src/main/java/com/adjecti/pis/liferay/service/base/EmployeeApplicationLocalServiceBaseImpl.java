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

package com.adjecti.pis.liferay.service.base;

import com.adjecti.pis.liferay.model.EmployeeApplication;
import com.adjecti.pis.liferay.service.EmployeeApplicationLocalService;
import com.adjecti.pis.liferay.service.persistence.AddressPersistence;
import com.adjecti.pis.liferay.service.persistence.ContactPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeAddressPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeApplicationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeBenefitSchemePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeBiodataPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeConfirmationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeContactPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeDelegationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeDeputationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeDesignationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeDocumentPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeDscPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeEmailPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeExperiencePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeFamilyPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeFinder;
import com.adjecti.pis.liferay.service.persistence.EmployeeGradePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeJoiningPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeMessagePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeOrganizationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePastExperiencePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePayStructurePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePermissionPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePostPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeProfilePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePromotionPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeQualificationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeReportingPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeSavingSchemePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeTradePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeTrainingPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeTransferPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeVerificationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeWorkAreaPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeWorkstationPersistence;
import com.adjecti.pis.liferay.service.persistence.FamilyBenefitSchemePersistence;
import com.adjecti.pis.liferay.service.persistence.FamilyEducationDetailPersistence;
import com.adjecti.pis.liferay.service.persistence.FamilyHealthDetailPersistence;
import com.adjecti.pis.liferay.service.persistence.FamilyMemberServiceDetailPersistence;
import com.adjecti.pis.liferay.service.persistence.FamilyServiceDetailPersistence;
import com.adjecti.pis.liferay.service.persistence.IDAMFailedTransactionPersistence;
import com.adjecti.pis.liferay.service.persistence.JoiningProcessPersistence;
import com.adjecti.pis.liferay.service.persistence.JoiningProcessRequestPersistence;
import com.adjecti.pis.liferay.service.persistence.MonthlySalaryComponentPersistence;
import com.adjecti.pis.liferay.service.persistence.MonthlySalaryPersistence;
import com.adjecti.pis.liferay.service.persistence.PeopleFinder;
import com.adjecti.pis.liferay.service.persistence.PeoplePersistence;
import com.adjecti.pis.liferay.service.persistence.ProcessFilePersistence;
import com.adjecti.pis.liferay.service.persistence.SampleProcessPersistence;
import com.adjecti.pis.liferay.service.persistence.SampleProcessRequestPersistence;
import com.adjecti.pis.liferay.service.persistence.ServiceRequestPersistence;
import com.adjecti.pis.liferay.service.persistence.ServiceRequestTypePersistence;
import com.adjecti.pis.liferay.service.persistence.ServiceRequestWfStatusTypePersistence;
import com.adjecti.pis.liferay.service.persistence.ServiceRequestWorkflowPersistence;
import com.adjecti.pis.liferay.service.persistence.SingleUserOnboardingPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the employee application local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.adjecti.pis.liferay.service.impl.EmployeeApplicationLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.adjecti.pis.liferay.service.impl.EmployeeApplicationLocalServiceImpl
 * @generated
 */
public abstract class EmployeeApplicationLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, EmployeeApplicationLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EmployeeApplicationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.pis.liferay.service.EmployeeApplicationLocalServiceUtil</code>.
	 */

	/**
	 * Adds the employee application to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeApplication the employee application
	 * @return the employee application that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmployeeApplication addEmployeeApplication(
		EmployeeApplication employeeApplication) {

		employeeApplication.setNew(true);

		return employeeApplicationPersistence.update(employeeApplication);
	}

	/**
	 * Creates a new employee application with the primary key. Does not add the employee application to the database.
	 *
	 * @param employeeApplicationId the primary key for the new employee application
	 * @return the new employee application
	 */
	@Override
	@Transactional(enabled = false)
	public EmployeeApplication createEmployeeApplication(
		long employeeApplicationId) {

		return employeeApplicationPersistence.create(employeeApplicationId);
	}

	/**
	 * Deletes the employee application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application that was removed
	 * @throws PortalException if a employee application with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmployeeApplication deleteEmployeeApplication(
			long employeeApplicationId)
		throws PortalException {

		return employeeApplicationPersistence.remove(employeeApplicationId);
	}

	/**
	 * Deletes the employee application from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeApplication the employee application
	 * @return the employee application that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmployeeApplication deleteEmployeeApplication(
		EmployeeApplication employeeApplication) {

		return employeeApplicationPersistence.remove(employeeApplication);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			EmployeeApplication.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return employeeApplicationPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return employeeApplicationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return employeeApplicationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return employeeApplicationPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return employeeApplicationPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public EmployeeApplication fetchEmployeeApplication(
		long employeeApplicationId) {

		return employeeApplicationPersistence.fetchByPrimaryKey(
			employeeApplicationId);
	}

	/**
	 * Returns the employee application with the primary key.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application
	 * @throws PortalException if a employee application with the primary key could not be found
	 */
	@Override
	public EmployeeApplication getEmployeeApplication(
			long employeeApplicationId)
		throws PortalException {

		return employeeApplicationPersistence.findByPrimaryKey(
			employeeApplicationId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			employeeApplicationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EmployeeApplication.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"employeeApplicationId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			employeeApplicationLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			EmployeeApplication.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"employeeApplicationId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			employeeApplicationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EmployeeApplication.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"employeeApplicationId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return employeeApplicationPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return employeeApplicationLocalService.deleteEmployeeApplication(
			(EmployeeApplication)persistedModel);
	}

	public BasePersistence<EmployeeApplication> getBasePersistence() {
		return employeeApplicationPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return employeeApplicationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @return the range of employee applications
	 */
	@Override
	public List<EmployeeApplication> getEmployeeApplications(
		int start, int end) {

		return employeeApplicationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of employee applications.
	 *
	 * @return the number of employee applications
	 */
	@Override
	public int getEmployeeApplicationsCount() {
		return employeeApplicationPersistence.countAll();
	}

	/**
	 * Updates the employee application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeApplication the employee application
	 * @return the employee application that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmployeeApplication updateEmployeeApplication(
		EmployeeApplication employeeApplication) {

		return employeeApplicationPersistence.update(employeeApplication);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EmployeeApplicationLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		employeeApplicationLocalService =
			(EmployeeApplicationLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmployeeApplicationLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EmployeeApplication.class;
	}

	protected String getModelClassName() {
		return EmployeeApplication.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				employeeApplicationPersistence.getDataSource();

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
	protected AddressPersistence addressPersistence;

	@Reference
	protected ContactPersistence contactPersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected EmployeeFinder employeeFinder;

	@Reference
	protected EmployeeAddressPersistence employeeAddressPersistence;

	protected EmployeeApplicationLocalService employeeApplicationLocalService;

	@Reference
	protected EmployeeApplicationPersistence employeeApplicationPersistence;

	@Reference
	protected EmployeeBenefitSchemePersistence employeeBenefitSchemePersistence;

	@Reference
	protected EmployeeBiodataPersistence employeeBiodataPersistence;

	@Reference
	protected EmployeeConfirmationPersistence employeeConfirmationPersistence;

	@Reference
	protected EmployeeContactPersistence employeeContactPersistence;

	@Reference
	protected EmployeeDelegationPersistence employeeDelegationPersistence;

	@Reference
	protected EmployeeDeputationPersistence employeeDeputationPersistence;

	@Reference
	protected EmployeeDesignationPersistence employeeDesignationPersistence;

	@Reference
	protected EmployeeDocumentPersistence employeeDocumentPersistence;

	@Reference
	protected EmployeeDscPersistence employeeDscPersistence;

	@Reference
	protected EmployeeEmailPersistence employeeEmailPersistence;

	@Reference
	protected EmployeeExperiencePersistence employeeExperiencePersistence;

	@Reference
	protected EmployeeFamilyPersistence employeeFamilyPersistence;

	@Reference
	protected EmployeeGradePersistence employeeGradePersistence;

	@Reference
	protected EmployeeJoiningPersistence employeeJoiningPersistence;

	@Reference
	protected EmployeeMessagePersistence employeeMessagePersistence;

	@Reference
	protected EmployeeOrganizationPersistence employeeOrganizationPersistence;

	@Reference
	protected EmployeePastExperiencePersistence
		employeePastExperiencePersistence;

	@Reference
	protected EmployeePayStructurePersistence employeePayStructurePersistence;

	@Reference
	protected EmployeePermissionPersistence employeePermissionPersistence;

	@Reference
	protected EmployeePostPersistence employeePostPersistence;

	@Reference
	protected EmployeeProfilePersistence employeeProfilePersistence;

	@Reference
	protected EmployeePromotionPersistence employeePromotionPersistence;

	@Reference
	protected EmployeeQualificationPersistence employeeQualificationPersistence;

	@Reference
	protected EmployeeReportingPersistence employeeReportingPersistence;

	@Reference
	protected EmployeeSavingSchemePersistence employeeSavingSchemePersistence;

	@Reference
	protected EmployeeTradePersistence employeeTradePersistence;

	@Reference
	protected EmployeeTrainingPersistence employeeTrainingPersistence;

	@Reference
	protected EmployeeTransferPersistence employeeTransferPersistence;

	@Reference
	protected EmployeeVerificationPersistence employeeVerificationPersistence;

	@Reference
	protected EmployeeWorkAreaPersistence employeeWorkAreaPersistence;

	@Reference
	protected EmployeeWorkstationPersistence employeeWorkstationPersistence;

	@Reference
	protected FamilyBenefitSchemePersistence familyBenefitSchemePersistence;

	@Reference
	protected FamilyEducationDetailPersistence familyEducationDetailPersistence;

	@Reference
	protected FamilyHealthDetailPersistence familyHealthDetailPersistence;

	@Reference
	protected FamilyMemberServiceDetailPersistence
		familyMemberServiceDetailPersistence;

	@Reference
	protected FamilyServiceDetailPersistence familyServiceDetailPersistence;

	@Reference
	protected IDAMFailedTransactionPersistence idamFailedTransactionPersistence;

	@Reference
	protected JoiningProcessPersistence joiningProcessPersistence;

	@Reference
	protected JoiningProcessRequestPersistence joiningProcessRequestPersistence;

	@Reference
	protected MonthlySalaryPersistence monthlySalaryPersistence;

	@Reference
	protected MonthlySalaryComponentPersistence
		monthlySalaryComponentPersistence;

	@Reference
	protected PeoplePersistence peoplePersistence;

	@Reference
	protected PeopleFinder peopleFinder;

	@Reference
	protected ProcessFilePersistence processFilePersistence;

	@Reference
	protected SampleProcessPersistence sampleProcessPersistence;

	@Reference
	protected SampleProcessRequestPersistence sampleProcessRequestPersistence;

	@Reference
	protected ServiceRequestPersistence serviceRequestPersistence;

	@Reference
	protected ServiceRequestTypePersistence serviceRequestTypePersistence;

	@Reference
	protected ServiceRequestWfStatusTypePersistence
		serviceRequestWfStatusTypePersistence;

	@Reference
	protected ServiceRequestWorkflowPersistence
		serviceRequestWorkflowPersistence;

	@Reference
	protected SingleUserOnboardingPersistence singleUserOnboardingPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}