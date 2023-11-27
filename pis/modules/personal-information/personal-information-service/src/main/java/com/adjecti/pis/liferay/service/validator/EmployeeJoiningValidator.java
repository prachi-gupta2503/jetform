package com.adjecti.pis.liferay.service.validator;

import com.adjecti.pis.liferay.exception.EmployeeJoiningException;

import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeJoiningValidator {

	public static void validate(EmployeeJoining employeeJoining)
			throws EmployeeJoiningException {

			List<String> errors = new ArrayList<>();
			if (!isPeopleValid(employeeJoining,errors)) {
				throw new EmployeeJoiningException(errors);
			}
		}
	
	private static boolean isPeopleValid(EmployeeJoining employeeJoining,final List<String> errors) {
			
			boolean result = true;
			
			result &=isOrganizationIdValid(employeeJoining.getOrganizationId(),errors);
			result &=isDesignationIdValid(employeeJoining.getDesignationId(),errors);
			result &=isGradeIdValid(employeeJoining.getGradeId(),errors);
			result &=isGradeModeIdValid(employeeJoining.getGradeModeId(),errors);
			result &=isJoiningModeIdValid(employeeJoining.getJoiningModeId(),errors);
			result &=isTradeIdValid(employeeJoining.getTradeId(),errors);
			
			result &=isFromDateValid(employeeJoining.getFromDate(),errors);
			result &=isToDateValid(employeeJoining.getToDate(),errors);
			
			result &=isEmailAddressValid(employeeJoining.getEmailAddress(),errors);
			
			result &=isPayLevelIdValid(employeeJoining.getPayLevelId(),errors);
			
			result &=isEmployeeIdValid(employeeJoining.getEmployeeId(),errors);
		
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

	private static boolean isToDateValid(final Date toDate,final List<String> errors) {
		
		boolean result = true;

		if ((Validator.isNull(toDate))) {
			errors.add("error.toDate-empty");
			result = false;
		}

		return result;
	}

	

private static boolean isEmployeeIdValid(final long employeeId, final List<String> errors) {
		
		boolean result = true;
		if (employeeId==0) {
			errors.add("error.employeeId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isGradeModeIdValid(final long gradeModeId, final List<String> errors) {
		
		boolean result = true;
		if (gradeModeId==0) {
			errors.add("error.gradeModeId-empty");
			result = false;
		}

		return result;
	}



	private static boolean isJoiningModeIdValid(final long joiningModeId, final List<String> errors) {
		
		boolean result = true;
		if (joiningModeId==0) {
			errors.add("error.joiningModeId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isOrganizationIdValid(final long organizationId, final List<String> errors) {
		
		boolean result = true;
		if (organizationId==0) {
			errors.add("error.organizationId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isTradeIdValid(final long tradeId, final List<String> errors) {
		
		boolean result = true;
		if (tradeId==0) {
			errors.add("error.tradeId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isPayLevelIdValid(final long payLevelId, final List<String> errors) {
		
		boolean result = true;
		if (payLevelId==0) {
			errors.add("error.payLevelId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isDesignationIdValid(final long designationId, final List<String> errors) {
		
		boolean result = true;
		if (designationId==0) {
			errors.add("error.designationId-empty");
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

	private static boolean isEmailAddressValid(final String emailAddress, final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(emailAddress))) {
			errors.add("error.emailAddress-empty");
			result = false;
		}

		return result;	}


	
}
