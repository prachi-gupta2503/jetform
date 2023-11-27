package com.adjecti.pis.liferay.service.validator;


import com.adjecti.pis.liferay.exception.EmployeeQualificationException;
import com.adjecti.pis.liferay.model.EmployeeQualification;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeQualificationValidator {

	
	public static void validate(List<EmployeeQualification> empQualification)
			throws  EmployeeQualificationException {

			List<String> errors = new ArrayList<>();
			if (!isEmployeeQualificationValid(empQualification,errors)) {
				throw new EmployeeQualificationException(errors);
			}
		}
	
	private static boolean isEmployeeQualificationValid(final List<EmployeeQualification> empQualifications ,final List<String> errors) {
			
			boolean result = true;
			
			for(EmployeeQualification employeeQualification: empQualifications) {
				result &=isQualificationIdValid(employeeQualification.getQualificationId(),errors);
				result &=isLevelIdValid(employeeQualification.getLevelId(),errors);
				result &=isSpecializationIdValid(employeeQualification.getSpecializationId(),errors);
				result &=isGradeIdValid(employeeQualification.getGradeId(),errors);
				result &=isForeignInstitutionValid(employeeQualification.getForeignInstitution(),errors);
				result &=isFromYearValid(employeeQualification.getFromYear(),errors);
				result &=isToYearValid(employeeQualification.getToYear(),errors);
				result &=isQualificationDateValid(employeeQualification.getQualificationDate(),errors);
				result &=isEmployeeIdValid(employeeQualification.getEmployeeId(),errors);
				
			
			}
			
			return result;
		}


	

	private static boolean isLevelIdValid(final long levelId, final List<String> errors) {
		boolean result = true;
		if (levelId==0) {
			errors.add("error.levelId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isSpecializationIdValid(final long specializationId,final  List<String> errors) {
		boolean result = true;
		if (specializationId==0) {
			errors.add("error.specializationId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isGradeIdValid(final long gradeId, final List<String> errors) {
		boolean result = true;
		if (gradeId==0) {
			errors.add("error.gradeId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isForeignInstitutionValid(final String foreignInstitution, final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(foreignInstitution))) {
			errors.add("error.foreignInstitution-empty");
			result = false;
		}

		return result;
	}

	private static boolean isFromYearValid(final int fromYear, final List<String> errors) {
		boolean result = true;

		if (fromYear==0) {
			errors.add("error.fromYear-empty");
			result = false;
		}

		return result;
	}

	private static boolean isToYearValid(final int toYear, final List<String> errors) {
		boolean result = true;

		if (toYear==0) {
			errors.add("error.toYear-empty");
			result = false;
		}

		return result;
	}

	private static boolean isQualificationDateValid(final Date qualificationDate, final List<String> errors) {
		boolean result = true;

		if ((Validator.isNull(qualificationDate))) {
			errors.add("error.qualificationDate-empty");
			result = false;
		}

		return result;
	}

	private static boolean isQualificationIdValid(final long qualificationId,final  List<String> errors) {
		boolean result = true;
		if (qualificationId==0) {
			errors.add("error.qualificationId-empty");
			result = false;
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

	
	
}
