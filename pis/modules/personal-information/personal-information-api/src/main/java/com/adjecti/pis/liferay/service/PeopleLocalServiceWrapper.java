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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PeopleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PeopleLocalService
 * @generated
 */
public class PeopleLocalServiceWrapper
	implements PeopleLocalService, ServiceWrapper<PeopleLocalService> {

	public PeopleLocalServiceWrapper(PeopleLocalService peopleLocalService) {
		_peopleLocalService = peopleLocalService;
	}

	@Override
	public com.adjecti.pis.liferay.model.People addPeople(
			long peopleId, long appellationId, String firstName_En,
			String middleName_En, String lastName_En, String firstName_Hi,
			String middleName_Hi, String lastName_Hi, String fatherName_En,
			String fatherName_Hi, java.util.Date dateOfBirth, long genderId,
			long casteCategoryId, long maritalStatusId, String panNo,
			String aadhaarNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _peopleLocalService.addPeople(
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
	@Override
	public com.adjecti.pis.liferay.model.People addPeople(
		com.adjecti.pis.liferay.model.People people) {

		return _peopleLocalService.addPeople(people);
	}

	@Override
	public long addPeople(
			com.adjecti.pis.liferay.model.People person, long employeeId)
		throws com.adjecti.pis.liferay.exception.PeopleException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _peopleLocalService.addPeople(person, employeeId);
	}

	@Override
	public boolean beforeUpdateEmployee(
		Object entity, java.util.Map<String, String[]> fieldValues) {

		return _peopleLocalService.beforeUpdateEmployee(entity, fieldValues);
	}

	/**
	 * Creates a new people with the primary key. Does not add the people to the database.
	 *
	 * @param peopleId the primary key for the new people
	 * @return the new people
	 */
	@Override
	public com.adjecti.pis.liferay.model.People createPeople(long peopleId) {
		return _peopleLocalService.createPeople(peopleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _peopleLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.adjecti.pis.liferay.model.People deletePeople(long peopleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _peopleLocalService.deletePeople(peopleId);
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
	@Override
	public com.adjecti.pis.liferay.model.People deletePeople(
		com.adjecti.pis.liferay.model.People people) {

		return _peopleLocalService.deletePeople(people);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _peopleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _peopleLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _peopleLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _peopleLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _peopleLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _peopleLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _peopleLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.People fetchPeople(long peopleId) {
		return _peopleLocalService.fetchPeople(peopleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _peopleLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.People>
			getByDateOfBirth()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _peopleLocalService.getByDateOfBirth();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _peopleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _peopleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the people with the primary key.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people
	 * @throws PortalException if a people with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.People getPeople(long peopleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _peopleLocalService.getPeople(peopleId);
	}

	@Override
	public int getPeopleCountByAppellationId(long appellationId) {
		return _peopleLocalService.getPeopleCountByAppellationId(appellationId);
	}

	@Override
	public int getPeopleCountByBloodGroupId(long bloodGroupId) {
		return _peopleLocalService.getPeopleCountByBloodGroupId(bloodGroupId);
	}

	@Override
	public int getPeopleCountByCasteCategoryId(long casteCategoryId) {
		return _peopleLocalService.getPeopleCountByCasteCategoryId(
			casteCategoryId);
	}

	@Override
	public int getPeopleCountByCitizenshipId(long citizenshipId) {
		return _peopleLocalService.getPeopleCountByCitizenshipId(citizenshipId);
	}

	@Override
	public int getPeopleCountByGenderId(long genderId) {
		return _peopleLocalService.getPeopleCountByGenderId(genderId);
	}

	@Override
	public int getPeopleCountByMaritalStatusId(long maritalStatusId) {
		return _peopleLocalService.getPeopleCountByMaritalStatusId(
			maritalStatusId);
	}

	@Override
	public int getPeopleCountByPhTypeId(long phTypeId) {
		return _peopleLocalService.getPeopleCountByPhTypeId(phTypeId);
	}

	@Override
	public int getPeopleCountByReligionId(long religionId) {
		return _peopleLocalService.getPeopleCountByReligionId(religionId);
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
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.People> getPeoples(
		int start, int end) {

		return _peopleLocalService.getPeoples(start, end);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.People>
		getPeoplesByJoiningProcessId(long joiningProcessId) {

		return _peopleLocalService.getPeoplesByJoiningProcessId(
			joiningProcessId);
	}

	/**
	 * Returns the number of peoples.
	 *
	 * @return the number of peoples
	 */
	@Override
	public int getPeoplesCount() {
		return _peopleLocalService.getPeoplesCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _peopleLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.People> searchPeople(
		String keywords) {

		return _peopleLocalService.searchPeople(keywords);
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
	@Override
	public com.adjecti.pis.liferay.model.People updatePeople(
		com.adjecti.pis.liferay.model.People people) {

		return _peopleLocalService.updatePeople(people);
	}

	@Override
	public PeopleLocalService getWrappedService() {
		return _peopleLocalService;
	}

	@Override
	public void setWrappedService(PeopleLocalService peopleLocalService) {
		_peopleLocalService = peopleLocalService;
	}

	private PeopleLocalService _peopleLocalService;

}