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

import com.adjecti.pis.liferay.model.SingleUserOnboarding;
import com.adjecti.pis.liferay.service.SingleUserOnboardingLocalService;
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

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the single user onboarding local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.adjecti.pis.liferay.service.impl.SingleUserOnboardingLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.adjecti.pis.liferay.service.impl.SingleUserOnboardingLocalServiceImpl
 * @generated
 */
public abstract class SingleUserOnboardingLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   SingleUserOnboardingLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>SingleUserOnboardingLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.pis.liferay.service.SingleUserOnboardingLocalServiceUtil</code>.
	 */

	/**
	 * Adds the single user onboarding to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SingleUserOnboardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param singleUserOnboarding the single user onboarding
	 * @return the single user onboarding that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SingleUserOnboarding addSingleUserOnboarding(
		SingleUserOnboarding singleUserOnboarding) {

		singleUserOnboarding.setNew(true);

		return singleUserOnboardingPersistence.update(singleUserOnboarding);
	}

	/**
	 * Creates a new single user onboarding with the primary key. Does not add the single user onboarding to the database.
	 *
	 * @param singleUserRegistrationId the primary key for the new single user onboarding
	 * @return the new single user onboarding
	 */
	@Override
	@Transactional(enabled = false)
	public SingleUserOnboarding createSingleUserOnboarding(
		long singleUserRegistrationId) {

		return singleUserOnboardingPersistence.create(singleUserRegistrationId);
	}

	/**
	 * Deletes the single user onboarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SingleUserOnboardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding that was removed
	 * @throws PortalException if a single user onboarding with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SingleUserOnboarding deleteSingleUserOnboarding(
			long singleUserRegistrationId)
		throws PortalException {

		return singleUserOnboardingPersistence.remove(singleUserRegistrationId);
	}

	/**
	 * Deletes the single user onboarding from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SingleUserOnboardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param singleUserOnboarding the single user onboarding
	 * @return the single user onboarding that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SingleUserOnboarding deleteSingleUserOnboarding(
		SingleUserOnboarding singleUserOnboarding) {

		return singleUserOnboardingPersistence.remove(singleUserOnboarding);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			SingleUserOnboarding.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return singleUserOnboardingPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SingleUserOnboardingModelImpl</code>.
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

		return singleUserOnboardingPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SingleUserOnboardingModelImpl</code>.
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

		return singleUserOnboardingPersistence.findWithDynamicQuery(
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
		return singleUserOnboardingPersistence.countWithDynamicQuery(
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

		return singleUserOnboardingPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public SingleUserOnboarding fetchSingleUserOnboarding(
		long singleUserRegistrationId) {

		return singleUserOnboardingPersistence.fetchByPrimaryKey(
			singleUserRegistrationId);
	}

	/**
	 * Returns the single user onboarding matching the UUID and group.
	 *
	 * @param uuid the single user onboarding's UUID
	 * @param groupId the primary key of the group
	 * @return the matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchSingleUserOnboardingByUuidAndGroupId(
		String uuid, long groupId) {

		return singleUserOnboardingPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the single user onboarding with the primary key.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding
	 * @throws PortalException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding getSingleUserOnboarding(
			long singleUserRegistrationId)
		throws PortalException {

		return singleUserOnboardingPersistence.findByPrimaryKey(
			singleUserRegistrationId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			singleUserOnboardingLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SingleUserOnboarding.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"singleUserRegistrationId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			singleUserOnboardingLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			SingleUserOnboarding.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"singleUserRegistrationId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			singleUserOnboardingLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SingleUserOnboarding.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"singleUserRegistrationId");
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
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									SingleUserOnboarding.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<SingleUserOnboarding>() {

				@Override
				public void performAction(
						SingleUserOnboarding singleUserOnboarding)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, singleUserOnboarding);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					SingleUserOnboarding.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return singleUserOnboardingPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return singleUserOnboardingLocalService.deleteSingleUserOnboarding(
			(SingleUserOnboarding)persistedModel);
	}

	public BasePersistence<SingleUserOnboarding> getBasePersistence() {
		return singleUserOnboardingPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return singleUserOnboardingPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the single user onboardings matching the UUID and company.
	 *
	 * @param uuid the UUID of the single user onboardings
	 * @param companyId the primary key of the company
	 * @return the matching single user onboardings, or an empty list if no matches were found
	 */
	@Override
	public List<SingleUserOnboarding>
		getSingleUserOnboardingsByUuidAndCompanyId(
			String uuid, long companyId) {

		return singleUserOnboardingPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of single user onboardings matching the UUID and company.
	 *
	 * @param uuid the UUID of the single user onboardings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching single user onboardings, or an empty list if no matches were found
	 */
	@Override
	public List<SingleUserOnboarding>
		getSingleUserOnboardingsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return singleUserOnboardingPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the single user onboarding matching the UUID and group.
	 *
	 * @param uuid the single user onboarding's UUID
	 * @param groupId the primary key of the group
	 * @return the matching single user onboarding
	 * @throws PortalException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding getSingleUserOnboardingByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return singleUserOnboardingPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the single user onboardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> getSingleUserOnboardings(
		int start, int end) {

		return singleUserOnboardingPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of single user onboardings.
	 *
	 * @return the number of single user onboardings
	 */
	@Override
	public int getSingleUserOnboardingsCount() {
		return singleUserOnboardingPersistence.countAll();
	}

	/**
	 * Updates the single user onboarding in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SingleUserOnboardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param singleUserOnboarding the single user onboarding
	 * @return the single user onboarding that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SingleUserOnboarding updateSingleUserOnboarding(
		SingleUserOnboarding singleUserOnboarding) {

		return singleUserOnboardingPersistence.update(singleUserOnboarding);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			SingleUserOnboardingLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		singleUserOnboardingLocalService =
			(SingleUserOnboardingLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SingleUserOnboardingLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return SingleUserOnboarding.class;
	}

	protected String getModelClassName() {
		return SingleUserOnboarding.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				singleUserOnboardingPersistence.getDataSource();

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

	protected SingleUserOnboardingLocalService singleUserOnboardingLocalService;

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

	@Reference
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

}