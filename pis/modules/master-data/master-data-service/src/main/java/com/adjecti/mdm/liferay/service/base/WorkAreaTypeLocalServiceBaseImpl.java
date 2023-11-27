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

package com.adjecti.mdm.liferay.service.base;

import com.adjecti.mdm.liferay.model.WorkAreaType;
import com.adjecti.mdm.liferay.service.WorkAreaTypeLocalService;
import com.adjecti.mdm.liferay.service.persistence.AccomodationTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.AmountTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.AppellationPersistence;
import com.adjecti.mdm.liferay.service.persistence.ApplicationPersistence;
import com.adjecti.mdm.liferay.service.persistence.BenefitSchemePersistence;
import com.adjecti.mdm.liferay.service.persistence.BloodGroupPersistence;
import com.adjecti.mdm.liferay.service.persistence.CadreDesignationPersistence;
import com.adjecti.mdm.liferay.service.persistence.CadrePersistence;
import com.adjecti.mdm.liferay.service.persistence.CasteCategoryPersistence;
import com.adjecti.mdm.liferay.service.persistence.CourseCategoryPersistence;
import com.adjecti.mdm.liferay.service.persistence.CoursePersistence;
import com.adjecti.mdm.liferay.service.persistence.DeputationTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.DesignationClassPersistence;
import com.adjecti.mdm.liferay.service.persistence.DesignationGradePersistence;
import com.adjecti.mdm.liferay.service.persistence.DesignationGroupPersistence;
import com.adjecti.mdm.liferay.service.persistence.DesignationModePersistence;
import com.adjecti.mdm.liferay.service.persistence.DesignationPersistence;
import com.adjecti.mdm.liferay.service.persistence.DesignationScopePersistence;
import com.adjecti.mdm.liferay.service.persistence.DiseasePersistence;
import com.adjecti.mdm.liferay.service.persistence.DiseaseTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.DistrictPersistence;
import com.adjecti.mdm.liferay.service.persistence.DocumentPersistence;
import com.adjecti.mdm.liferay.service.persistence.DocumentTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.ExperiencePersistence;
import com.adjecti.mdm.liferay.service.persistence.FamilyRelationPersistence;
import com.adjecti.mdm.liferay.service.persistence.GenderPersistence;
import com.adjecti.mdm.liferay.service.persistence.GradeModePersistence;
import com.adjecti.mdm.liferay.service.persistence.GradePersistence;
import com.adjecti.mdm.liferay.service.persistence.JoiningModePersistence;
import com.adjecti.mdm.liferay.service.persistence.LevelWisePayStructurePersistence;
import com.adjecti.mdm.liferay.service.persistence.LocationPersistence;
import com.adjecti.mdm.liferay.service.persistence.MaritalStatusPersistence;
import com.adjecti.mdm.liferay.service.persistence.MasterEntityPersistence;
import com.adjecti.mdm.liferay.service.persistence.OEMPersistence;
import com.adjecti.mdm.liferay.service.persistence.OccupationPersistence;
import com.adjecti.mdm.liferay.service.persistence.OccupationServiceTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.OrganizationDetailPersistence;
import com.adjecti.mdm.liferay.service.persistence.OrganizationHistoryPersistence;
import com.adjecti.mdm.liferay.service.persistence.OrganizationPayStructurePersistence;
import com.adjecti.mdm.liferay.service.persistence.OrganizationStationPersistence;
import com.adjecti.mdm.liferay.service.persistence.OrganizationTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.PayComponentPersistence;
import com.adjecti.mdm.liferay.service.persistence.PayHeadPersistence;
import com.adjecti.mdm.liferay.service.persistence.PayHeadTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.PayLevelPersistence;
import com.adjecti.mdm.liferay.service.persistence.PayStructurePersistence;
import com.adjecti.mdm.liferay.service.persistence.PersonalNoPrefixPersistence;
import com.adjecti.mdm.liferay.service.persistence.PhTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.PostDelegationPersistence;
import com.adjecti.mdm.liferay.service.persistence.PostHierarchyPersistence;
import com.adjecti.mdm.liferay.service.persistence.PostOrganizationPersistence;
import com.adjecti.mdm.liferay.service.persistence.PostPersistence;
import com.adjecti.mdm.liferay.service.persistence.PostReportingPersistence;
import com.adjecti.mdm.liferay.service.persistence.QualificationGradePersistence;
import com.adjecti.mdm.liferay.service.persistence.QualificationLevelPersistence;
import com.adjecti.mdm.liferay.service.persistence.QualificationPersistence;
import com.adjecti.mdm.liferay.service.persistence.QualificationSubjectPersistence;
import com.adjecti.mdm.liferay.service.persistence.ReligionPersistence;
import com.adjecti.mdm.liferay.service.persistence.ServiceRequestTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.SpecializationPersistence;
import com.adjecti.mdm.liferay.service.persistence.StatePersistence;
import com.adjecti.mdm.liferay.service.persistence.SubjectOfQualificationPersistence;
import com.adjecti.mdm.liferay.service.persistence.SubjectOfTrainingPersistence;
import com.adjecti.mdm.liferay.service.persistence.TimeFrequencyPersistence;
import com.adjecti.mdm.liferay.service.persistence.TradePersistence;
import com.adjecti.mdm.liferay.service.persistence.TrainingCoursePersistence;
import com.adjecti.mdm.liferay.service.persistence.TrainingInstitutePersistence;
import com.adjecti.mdm.liferay.service.persistence.TrainingSubjectPersistence;
import com.adjecti.mdm.liferay.service.persistence.UnitTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.VerificationTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.WorkAreaMajorPersistence;
import com.adjecti.mdm.liferay.service.persistence.WorkAreaMinorPersistence;
import com.adjecti.mdm.liferay.service.persistence.WorkAreaPersistence;
import com.adjecti.mdm.liferay.service.persistence.WorkAreaTypePersistence;
import com.adjecti.mdm.liferay.service.persistence.WorkStationPersistence;

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
 * Provides the base implementation for the work area type local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.adjecti.mdm.liferay.service.impl.WorkAreaTypeLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.adjecti.mdm.liferay.service.impl.WorkAreaTypeLocalServiceImpl
 * @generated
 */
public abstract class WorkAreaTypeLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, WorkAreaTypeLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>WorkAreaTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.mdm.liferay.service.WorkAreaTypeLocalServiceUtil</code>.
	 */

	/**
	 * Adds the work area type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaType the work area type
	 * @return the work area type that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public WorkAreaType addWorkAreaType(WorkAreaType workAreaType) {
		workAreaType.setNew(true);

		return workAreaTypePersistence.update(workAreaType);
	}

	/**
	 * Creates a new work area type with the primary key. Does not add the work area type to the database.
	 *
	 * @param workAreaTypeId the primary key for the new work area type
	 * @return the new work area type
	 */
	@Override
	@Transactional(enabled = false)
	public WorkAreaType createWorkAreaType(long workAreaTypeId) {
		return workAreaTypePersistence.create(workAreaTypeId);
	}

	/**
	 * Deletes the work area type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type that was removed
	 * @throws PortalException if a work area type with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public WorkAreaType deleteWorkAreaType(long workAreaTypeId)
		throws PortalException {

		return workAreaTypePersistence.remove(workAreaTypeId);
	}

	/**
	 * Deletes the work area type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaType the work area type
	 * @return the work area type that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public WorkAreaType deleteWorkAreaType(WorkAreaType workAreaType) {
		return workAreaTypePersistence.remove(workAreaType);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			WorkAreaType.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return workAreaTypePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaTypeModelImpl</code>.
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

		return workAreaTypePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaTypeModelImpl</code>.
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

		return workAreaTypePersistence.findWithDynamicQuery(
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
		return workAreaTypePersistence.countWithDynamicQuery(dynamicQuery);
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

		return workAreaTypePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public WorkAreaType fetchWorkAreaType(long workAreaTypeId) {
		return workAreaTypePersistence.fetchByPrimaryKey(workAreaTypeId);
	}

	/**
	 * Returns the work area type with the primary key.
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type
	 * @throws PortalException if a work area type with the primary key could not be found
	 */
	@Override
	public WorkAreaType getWorkAreaType(long workAreaTypeId)
		throws PortalException {

		return workAreaTypePersistence.findByPrimaryKey(workAreaTypeId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(workAreaTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(WorkAreaType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("workAreaTypeId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			workAreaTypeLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(WorkAreaType.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"workAreaTypeId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(workAreaTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(WorkAreaType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("workAreaTypeId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return workAreaTypePersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return workAreaTypeLocalService.deleteWorkAreaType(
			(WorkAreaType)persistedModel);
	}

	public BasePersistence<WorkAreaType> getBasePersistence() {
		return workAreaTypePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return workAreaTypePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the work area types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @return the range of work area types
	 */
	@Override
	public List<WorkAreaType> getWorkAreaTypes(int start, int end) {
		return workAreaTypePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of work area types.
	 *
	 * @return the number of work area types
	 */
	@Override
	public int getWorkAreaTypesCount() {
		return workAreaTypePersistence.countAll();
	}

	/**
	 * Updates the work area type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaType the work area type
	 * @return the work area type that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public WorkAreaType updateWorkAreaType(WorkAreaType workAreaType) {
		return workAreaTypePersistence.update(workAreaType);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			WorkAreaTypeLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		workAreaTypeLocalService = (WorkAreaTypeLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return WorkAreaTypeLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return WorkAreaType.class;
	}

	protected String getModelClassName() {
		return WorkAreaType.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = workAreaTypePersistence.getDataSource();

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
	protected AccomodationTypePersistence accomodationTypePersistence;

	@Reference
	protected AmountTypePersistence amountTypePersistence;

	@Reference
	protected AppellationPersistence appellationPersistence;

	@Reference
	protected ApplicationPersistence applicationPersistence;

	@Reference
	protected BenefitSchemePersistence benefitSchemePersistence;

	@Reference
	protected BloodGroupPersistence bloodGroupPersistence;

	@Reference
	protected CadrePersistence cadrePersistence;

	@Reference
	protected CadreDesignationPersistence cadreDesignationPersistence;

	@Reference
	protected CasteCategoryPersistence casteCategoryPersistence;

	@Reference
	protected CoursePersistence coursePersistence;

	@Reference
	protected CourseCategoryPersistence courseCategoryPersistence;

	@Reference
	protected DeputationTypePersistence deputationTypePersistence;

	@Reference
	protected DesignationPersistence designationPersistence;

	@Reference
	protected DesignationClassPersistence designationClassPersistence;

	@Reference
	protected DesignationGradePersistence designationGradePersistence;

	@Reference
	protected DesignationGroupPersistence designationGroupPersistence;

	@Reference
	protected DesignationModePersistence designationModePersistence;

	@Reference
	protected DesignationScopePersistence designationScopePersistence;

	@Reference
	protected DiseasePersistence diseasePersistence;

	@Reference
	protected DiseaseTypePersistence diseaseTypePersistence;

	@Reference
	protected DistrictPersistence districtPersistence;

	@Reference
	protected DocumentPersistence documentPersistence;

	@Reference
	protected DocumentTypePersistence documentTypePersistence;

	@Reference
	protected ExperiencePersistence experiencePersistence;

	@Reference
	protected FamilyRelationPersistence familyRelationPersistence;

	@Reference
	protected GenderPersistence genderPersistence;

	@Reference
	protected GradePersistence gradePersistence;

	@Reference
	protected GradeModePersistence gradeModePersistence;

	@Reference
	protected JoiningModePersistence joiningModePersistence;

	@Reference
	protected LevelWisePayStructurePersistence levelWisePayStructurePersistence;

	@Reference
	protected LocationPersistence locationPersistence;

	@Reference
	protected MaritalStatusPersistence maritalStatusPersistence;

	@Reference
	protected MasterEntityPersistence masterEntityPersistence;

	@Reference
	protected OccupationPersistence occupationPersistence;

	@Reference
	protected OccupationServiceTypePersistence occupationServiceTypePersistence;

	@Reference
	protected OEMPersistence oemPersistence;

	@Reference
	protected OrganizationDetailPersistence organizationDetailPersistence;

	@Reference
	protected OrganizationHistoryPersistence organizationHistoryPersistence;

	@Reference
	protected OrganizationPayStructurePersistence
		organizationPayStructurePersistence;

	@Reference
	protected OrganizationStationPersistence organizationStationPersistence;

	@Reference
	protected OrganizationTypePersistence organizationTypePersistence;

	@Reference
	protected PayComponentPersistence payComponentPersistence;

	@Reference
	protected PayHeadPersistence payHeadPersistence;

	@Reference
	protected PayHeadTypePersistence payHeadTypePersistence;

	@Reference
	protected PayLevelPersistence payLevelPersistence;

	@Reference
	protected PayStructurePersistence payStructurePersistence;

	@Reference
	protected PersonalNoPrefixPersistence personalNoPrefixPersistence;

	@Reference
	protected PhTypePersistence phTypePersistence;

	@Reference
	protected PostPersistence postPersistence;

	@Reference
	protected PostDelegationPersistence postDelegationPersistence;

	@Reference
	protected PostHierarchyPersistence postHierarchyPersistence;

	@Reference
	protected PostOrganizationPersistence postOrganizationPersistence;

	@Reference
	protected PostReportingPersistence postReportingPersistence;

	@Reference
	protected QualificationPersistence qualificationPersistence;

	@Reference
	protected QualificationGradePersistence qualificationGradePersistence;

	@Reference
	protected QualificationLevelPersistence qualificationLevelPersistence;

	@Reference
	protected QualificationSubjectPersistence qualificationSubjectPersistence;

	@Reference
	protected ReligionPersistence religionPersistence;

	@Reference
	protected ServiceRequestTypePersistence serviceRequestTypePersistence;

	@Reference
	protected SpecializationPersistence specializationPersistence;

	@Reference
	protected StatePersistence statePersistence;

	@Reference
	protected SubjectOfQualificationPersistence
		subjectOfQualificationPersistence;

	@Reference
	protected SubjectOfTrainingPersistence subjectOfTrainingPersistence;

	@Reference
	protected TimeFrequencyPersistence timeFrequencyPersistence;

	@Reference
	protected TradePersistence tradePersistence;

	@Reference
	protected TrainingCoursePersistence trainingCoursePersistence;

	@Reference
	protected TrainingInstitutePersistence trainingInstitutePersistence;

	@Reference
	protected TrainingSubjectPersistence trainingSubjectPersistence;

	@Reference
	protected UnitTypePersistence unitTypePersistence;

	@Reference
	protected VerificationTypePersistence verificationTypePersistence;

	@Reference
	protected WorkAreaPersistence workAreaPersistence;

	@Reference
	protected WorkAreaMajorPersistence workAreaMajorPersistence;

	@Reference
	protected WorkAreaMinorPersistence workAreaMinorPersistence;

	protected WorkAreaTypeLocalService workAreaTypeLocalService;

	@Reference
	protected WorkAreaTypePersistence workAreaTypePersistence;

	@Reference
	protected WorkStationPersistence workStationPersistence;

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