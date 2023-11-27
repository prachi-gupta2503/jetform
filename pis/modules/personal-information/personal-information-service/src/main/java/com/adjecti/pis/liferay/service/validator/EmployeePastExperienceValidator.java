package com.adjecti.pis.liferay.service.validator;


import com.adjecti.pis.liferay.exception.EmployeePastExperienceException;
import com.adjecti.pis.liferay.model.EmployeePastExperience;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeePastExperienceValidator {
	
	public static void validate(List<EmployeePastExperience> pastExperienceDetails)
			throws  EmployeePastExperienceException {

			List<String> errors = new ArrayList<>();
			if (!isEmployeePastExperienceValid(pastExperienceDetails,errors)) {
				throw new EmployeePastExperienceException(errors);
			}
		}
	
	private static boolean isEmployeePastExperienceValid(final List<EmployeePastExperience> pastExperienceDetails ,final List<String> errors) {
			
			boolean result = true;
			
			for(EmployeePastExperience pastExperienceDetail: pastExperienceDetails) {
				result &=isDesignationValid(pastExperienceDetail.getDesignation(),errors);
				result &=isFromDateValid(pastExperienceDetail.getFromDate(),errors);
				result &=isToDateValid(pastExperienceDetail.getToDate(),errors);
				result &=isOrganizationValid(pastExperienceDetail.getOrganization(),errors);
				result &=isWorkAreaIdValid(pastExperienceDetail.getWorkAreaId(),errors);
				result &=isEmployeeIdValid(pastExperienceDetail.getEmployeeId(),errors);
			
			}
			
			return result;
		}


	

	private static boolean isEmployeeIdValid(final long employeeId,final  List<String> errors) {
		boolean result = true;
		if (employeeId==0) {
			errors.add("error.employeeId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isWorkAreaIdValid(final long workAreaId,final  List<String> errors) {
		boolean result = true;
		if (workAreaId==0) {
			errors.add("error.workAreaId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isOrganizationValid(final String organization, final List<String> errors) {
		boolean result = true;
		if ((Validator.isNull(organization))) {
			errors.add("error.organization-empty");
			result = false;
		}

		return result;
	}

	private static boolean isToDateValid(final Date toDate, final List<String> errors) {
		boolean result = true;
		if ((Validator.isNull(toDate))) {
			errors.add("error.toDate-empty");
			result = false;
		}

		return result;
	}

	private static boolean isFromDateValid(final Date fromDate,final  List<String> errors) {
		boolean result = true;
		if ((Validator.isNull(fromDate))) {
			errors.add("error.fromDate-empty");
			result = false;
		}

		return result;
	}


	private static boolean isDesignationValid(final String designation, final List<String> errors) {
		boolean result = true;
		if ((Validator.isNull(designation))) {
			errors.add("error.designation-empty");
			result = false;
		}

		return result;
	}

}
