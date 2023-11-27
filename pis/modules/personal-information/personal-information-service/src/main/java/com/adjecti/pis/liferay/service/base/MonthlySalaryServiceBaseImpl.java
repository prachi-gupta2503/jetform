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

import com.adjecti.pis.liferay.model.MonthlySalary;
import com.adjecti.pis.liferay.service.MonthlySalaryService;
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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the monthly salary remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.adjecti.pis.liferay.service.impl.MonthlySalaryServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.adjecti.pis.liferay.service.impl.MonthlySalaryServiceImpl
 * @generated
 */
public abstract class MonthlySalaryServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, MonthlySalaryService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>MonthlySalaryService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.pis.liferay.service.MonthlySalaryServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			MonthlySalaryService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		monthlySalaryService = (MonthlySalaryService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return MonthlySalaryService.class.getName();
	}

	protected Class<?> getModelClass() {
		return MonthlySalary.class;
	}

	protected String getModelClassName() {
		return MonthlySalary.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = monthlySalaryPersistence.getDataSource();

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
	protected com.adjecti.pis.liferay.service.MonthlySalaryLocalService
		monthlySalaryLocalService;

	protected MonthlySalaryService monthlySalaryService;

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