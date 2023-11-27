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

import com.adjecti.pis.liferay.model.EmployeePromotionRequest;
import com.adjecti.pis.liferay.service.EmployeePromotionRequestLocalService;
import com.adjecti.pis.liferay.service.persistence.ContactPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeAddressPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeBenefitSchemePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeConfirmationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeContactPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeDelegationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeDeputationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeDeputationRequestPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeDesignationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeDocumentPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeExperiencePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeFamilyPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeGradePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeJoiningPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePastExperiencePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePayStructurePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePostPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePromotionPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeePromotionRequestPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeQualificationPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeReportingPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeSavingSchemePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeSeparationRequestPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeTradePersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeTrainingPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeTransferPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeTransferRequestPersistence;
import com.adjecti.pis.liferay.service.persistence.EmployeeVerificationPersistence;
import com.adjecti.pis.liferay.service.persistence.FamilyBenefitSchemePersistence;
import com.adjecti.pis.liferay.service.persistence.FamilyEducationDetailPersistence;
import com.adjecti.pis.liferay.service.persistence.FamilyHealthDetailPersistence;
import com.adjecti.pis.liferay.service.persistence.FamilyMemberServiceDetailPersistence;
import com.adjecti.pis.liferay.service.persistence.FamilyServiceDetailPersistence;
import com.adjecti.pis.liferay.service.persistence.JoiningProcessPersistence;
import com.adjecti.pis.liferay.service.persistence.MonthlySalaryComponentPersistence;
import com.adjecti.pis.liferay.service.persistence.MonthlySalaryPersistence;
import com.adjecti.pis.liferay.service.persistence.PeoplePersistence;
import com.adjecti.pis.liferay.service.persistence.SampleProcessPersistence;
import com.adjecti.pis.liferay.service.persistence.SampleProcessRequestPersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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
 * Provides the base implementation for the employee promotion request local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.adjecti.pis.liferay.service.impl.EmployeePromotionRequestLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.adjecti.pis.liferay.service.impl.EmployeePromotionRequestLocalServiceImpl
 * @generated
 */
public abstract class EmployeePromotionRequestLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, EmployeePromotionRequestLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EmployeePromotionRequestLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.pis.liferay.service.EmployeePromotionRequestLocalServiceUtil</code>.
	 */

	/**
	 * Adds the employee promotion request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePromotionRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePromotionRequest the employee promotion request
	 * @return the employee promotion request that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmployeePromotionRequest addEmployeePromotionRequest(
		EmployeePromotionRequest employeePromotionRequest) {

		employeePromotionRequest.setNew(true);

		return employeePromotionRequestPersistence.update(
			employeePromotionRequest);
	}

	/**
	 * Creates a new employee promotion request with the primary key. Does not add the employee promotion request to the database.
	 *
	 * @param employeePromotionRequestId the primary key for the new employee promotion request
	 * @return the new employee promotion request
	 */
	@Override
	@Transactional(enabled = false)
	public EmployeePromotionRequest createEmployeePromotionRequest(
		long employeePromotionRequestId) {

		return employeePromotionRequestPersistence.create(
			employeePromotionRequestId);
	}

	/**
	 * Deletes the employee promotion request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePromotionRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request that was removed
	 * @throws PortalException if a employee promotion request with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmployeePromotionRequest deleteEmployeePromotionRequest(
			long employeePromotionRequestId)
		throws PortalException {

		return employeePromotionRequestPersistence.remove(
			employeePromotionRequestId);
	}

	/**
	 * Deletes the employee promotion request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePromotionRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePromotionRequest the employee promotion request
	 * @return the employee promotion request that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmployeePromotionRequest deleteEmployeePromotionRequest(
		EmployeePromotionRequest employeePromotionRequest) {

		return employeePromotionRequestPersistence.remove(
			employeePromotionRequest);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			EmployeePromotionRequest.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return employeePromotionRequestPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePromotionRequestModelImpl</code>.
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

		return employeePromotionRequestPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePromotionRequestModelImpl</code>.
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

		return employeePromotionRequestPersistence.findWithDynamicQuery(
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
		return employeePromotionRequestPersistence.countWithDynamicQuery(
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

		return employeePromotionRequestPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public EmployeePromotionRequest fetchEmployeePromotionRequest(
		long employeePromotionRequestId) {

		return employeePromotionRequestPersistence.fetchByPrimaryKey(
			employeePromotionRequestId);
	}

	/**
	 * Returns the employee promotion request matching the UUID and group.
	 *
	 * @param uuid the employee promotion request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest
		fetchEmployeePromotionRequestByUuidAndGroupId(
			String uuid, long groupId) {

		return employeePromotionRequestPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee promotion request with the primary key.
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request
	 * @throws PortalException if a employee promotion request with the primary key could not be found
	 */
	@Override
	public EmployeePromotionRequest getEmployeePromotionRequest(
			long employeePromotionRequestId)
		throws PortalException {

		return employeePromotionRequestPersistence.findByPrimaryKey(
			employeePromotionRequestId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			employeePromotionRequestLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EmployeePromotionRequest.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"employeePromotionRequestId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			employeePromotionRequestLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			EmployeePromotionRequest.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"employeePromotionRequestId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			employeePromotionRequestLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EmployeePromotionRequest.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"employeePromotionRequestId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<EmployeePromotionRequest>() {

				@Override
				public void performAction(
						EmployeePromotionRequest employeePromotionRequest)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, employeePromotionRequest);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					EmployeePromotionRequest.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return employeePromotionRequestPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return employeePromotionRequestLocalService.
			deleteEmployeePromotionRequest(
				(EmployeePromotionRequest)persistedModel);
	}

	public BasePersistence<EmployeePromotionRequest> getBasePersistence() {
		return employeePromotionRequestPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return employeePromotionRequestPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns all the employee promotion requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee promotion requests
	 * @param companyId the primary key of the company
	 * @return the matching employee promotion requests, or an empty list if no matches were found
	 */
	@Override
	public List<EmployeePromotionRequest>
		getEmployeePromotionRequestsByUuidAndCompanyId(
			String uuid, long companyId) {

		return employeePromotionRequestPersistence.findByUuid_C(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee promotion requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee promotion requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee promotion requests, or an empty list if no matches were found
	 */
	@Override
	public List<EmployeePromotionRequest>
		getEmployeePromotionRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return employeePromotionRequestPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the employee promotion request matching the UUID and group.
	 *
	 * @param uuid the employee promotion request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee promotion request
	 * @throws PortalException if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest getEmployeePromotionRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return employeePromotionRequestPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee promotion requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @return the range of employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> getEmployeePromotionRequests(
		int start, int end) {

		return employeePromotionRequestPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of employee promotion requests.
	 *
	 * @return the number of employee promotion requests
	 */
	@Override
	public int getEmployeePromotionRequestsCount() {
		return employeePromotionRequestPersistence.countAll();
	}

	/**
	 * Updates the employee promotion request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePromotionRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePromotionRequest the employee promotion request
	 * @return the employee promotion request that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmployeePromotionRequest updateEmployeePromotionRequest(
		EmployeePromotionRequest employeePromotionRequest) {

		return employeePromotionRequestPersistence.update(
			employeePromotionRequest);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EmployeePromotionRequestLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		employeePromotionRequestLocalService =
			(EmployeePromotionRequestLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmployeePromotionRequestLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EmployeePromotionRequest.class;
	}

	protected String getModelClassName() {
		return EmployeePromotionRequest.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				employeePromotionRequestPersistence.getDataSource();

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
	protected ContactPersistence contactPersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected EmployeeAddressPersistence employeeAddressPersistence;

	@Reference
	protected EmployeeBenefitSchemePersistence employeeBenefitSchemePersistence;

	@Reference
	protected EmployeeConfirmationPersistence employeeConfirmationPersistence;

	@Reference
	protected EmployeeContactPersistence employeeContactPersistence;

	@Reference
	protected EmployeeDelegationPersistence employeeDelegationPersistence;

	@Reference
	protected EmployeeDeputationPersistence employeeDeputationPersistence;

	@Reference
	protected EmployeeDeputationRequestPersistence
		employeeDeputationRequestPersistence;

	@Reference
	protected EmployeeDesignationPersistence employeeDesignationPersistence;

	@Reference
	protected EmployeeDocumentPersistence employeeDocumentPersistence;

	@Reference
	protected EmployeeExperiencePersistence employeeExperiencePersistence;

	@Reference
	protected EmployeeFamilyPersistence employeeFamilyPersistence;

	@Reference
	protected EmployeeGradePersistence employeeGradePersistence;

	@Reference
	protected EmployeeJoiningPersistence employeeJoiningPersistence;

	@Reference
	protected EmployeePastExperiencePersistence
		employeePastExperiencePersistence;

	@Reference
	protected EmployeePayStructurePersistence employeePayStructurePersistence;

	@Reference
	protected EmployeePostPersistence employeePostPersistence;

	@Reference
	protected EmployeePromotionPersistence employeePromotionPersistence;

	protected EmployeePromotionRequestLocalService
		employeePromotionRequestLocalService;

	@Reference
	protected EmployeePromotionRequestPersistence
		employeePromotionRequestPersistence;

	@Reference
	protected EmployeeQualificationPersistence employeeQualificationPersistence;

	@Reference
	protected EmployeeReportingPersistence employeeReportingPersistence;

	@Reference
	protected EmployeeSavingSchemePersistence employeeSavingSchemePersistence;

	@Reference
	protected EmployeeSeparationRequestPersistence
		employeeSeparationRequestPersistence;

	@Reference
	protected EmployeeTradePersistence employeeTradePersistence;

	@Reference
	protected EmployeeTrainingPersistence employeeTrainingPersistence;

	@Reference
	protected EmployeeTransferPersistence employeeTransferPersistence;

	@Reference
	protected EmployeeTransferRequestPersistence
		employeeTransferRequestPersistence;

	@Reference
	protected EmployeeVerificationPersistence employeeVerificationPersistence;

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
	protected JoiningProcessPersistence joiningProcessPersistence;

	@Reference
	protected MonthlySalaryPersistence monthlySalaryPersistence;

	@Reference
	protected MonthlySalaryComponentPersistence
		monthlySalaryComponentPersistence;

	@Reference
	protected PeoplePersistence peoplePersistence;

	@Reference
	protected SampleProcessPersistence sampleProcessPersistence;

	@Reference
	protected SampleProcessRequestPersistence sampleProcessRequestPersistence;

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