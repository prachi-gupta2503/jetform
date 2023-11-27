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

package com.adjecti.pis.liferay.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for People. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.PeopleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PeopleLocalService
 * @generated
 */
public class PeopleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.PeopleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.adjecti.pis.liferay.model.People addPeople(
			long peopleId, long appellationId, String firstName_En,
			String middleName_En, String lastName_En, String firstName_Hi,
			String middleName_Hi, String lastName_Hi, String fatherName_En,
			String fatherName_Hi, java.util.Date dateOfBirth, long genderId,
			long casteCategoryId, long maritalStatusId, String panNo,
			String aadhaarNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPeople(
			peopleId, appellationId, firstName_En, middleName_En, lastName_En,
			firstName_Hi, middleName_Hi, lastName_Hi, fatherName_En,
			fatherName_Hi, dateOfBirth, genderId, casteCategoryId,
			maritalStatusId, panNo, aadhaarNo);
	}

	/**
	 * Adds the people to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PeopleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param people the people
	 * @return the people that was added
	 */
	public static com.adjecti.pis.liferay.model.People addPeople(
		com.adjecti.pis.liferay.model.People people) {

		return getService().addPeople(people);
	}

	public static long addPeople(
			com.adjecti.pis.liferay.model.People person, long employeeId)
		throws com.adjecti.pis.liferay.exception.PeopleException,
			   com.liferay.portal.kernel.exception.PortalException {

		return getService().addPeople(person, employeeId);
	}

	public static boolean beforeUpdateEmployee(
		Object entity, java.util.Map<String, String[]> fieldValues) {

		return getService().beforeUpdateEmployee(entity, fieldValues);
	}

	/**
	 * Creates a new people with the primary key. Does not add the people to the database.
	 *
	 * @param peopleId the primary key for the new people
	 * @return the new people
	 */
	public static com.adjecti.pis.liferay.model.People createPeople(
		long peopleId) {

		return getService().createPeople(peopleId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the people with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PeopleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param peopleId the primary key of the people
	 * @return the people that was removed
	 * @throws PortalException if a people with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.People deletePeople(
			long peopleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePeople(peopleId);
	}

	/**
	 * Deletes the people from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PeopleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param people the people
	 * @return the people that was removed
	 */
	public static com.adjecti.pis.liferay.model.People deletePeople(
		com.adjecti.pis.liferay.model.People people) {

		return getService().deletePeople(people);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.adjecti.pis.liferay.model.People fetchPeople(
		long peopleId) {

		return getService().fetchPeople(peopleId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.adjecti.pis.liferay.model.People>
			getByDateOfBirth()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getByDateOfBirth();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Returns the people with the primary key.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people
	 * @throws PortalException if a people with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.People getPeople(long peopleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPeople(peopleId);
	}

	public static int getPeopleCountByAppellationId(long appellationId) {
		return getService().getPeopleCountByAppellationId(appellationId);
	}

	public static int getPeopleCountByBloodGroupId(long bloodGroupId) {
		return getService().getPeopleCountByBloodGroupId(bloodGroupId);
	}

	public static int getPeopleCountByCasteCategoryId(long casteCategoryId) {
		return getService().getPeopleCountByCasteCategoryId(casteCategoryId);
	}

	public static int getPeopleCountByCitizenshipId(long citizenshipId) {
		return getService().getPeopleCountByCitizenshipId(citizenshipId);
	}

	public static int getPeopleCountByGenderId(long genderId) {
		return getService().getPeopleCountByGenderId(genderId);
	}

	public static int getPeopleCountByMaritalStatusId(long maritalStatusId) {
		return getService().getPeopleCountByMaritalStatusId(maritalStatusId);
	}

	public static int getPeopleCountByPhTypeId(long phTypeId) {
		return getService().getPeopleCountByPhTypeId(phTypeId);
	}

	public static int getPeopleCountByReligionId(long religionId) {
		return getService().getPeopleCountByReligionId(religionId);
	}

	/**
	 * Returns a range of all the peoples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of peoples
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.People>
		getPeoples(int start, int end) {

		return getService().getPeoples(start, end);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.People>
		getPeoplesByJoiningProcessId(long joiningProcessId) {

		return getService().getPeoplesByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of peoples.
	 *
	 * @return the number of peoples
	 */
	public static int getPeoplesCount() {
		return getService().getPeoplesCount();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.People>
		searchPeople(String keywords) {

		return getService().searchPeople(keywords);
	}

	/**
	 * Updates the people in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PeopleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param people the people
	 * @return the people that was updated
	 */
	public static com.adjecti.pis.liferay.model.People updatePeople(
		com.adjecti.pis.liferay.model.People people) {

		return getService().updatePeople(people);
	}

	public static PeopleLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PeopleLocalService, PeopleLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PeopleLocalService.class);

		ServiceTracker<PeopleLocalService, PeopleLocalService> serviceTracker =
			new ServiceTracker<PeopleLocalService, PeopleLocalService>(
				bundle.getBundleContext(), PeopleLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}