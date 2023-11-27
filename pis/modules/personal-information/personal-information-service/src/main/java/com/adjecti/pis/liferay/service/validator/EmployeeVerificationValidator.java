package com.adjecti.pis.liferay.service.validator;

import com.adjecti.pis.liferay.exception.EmployeeAddressException;
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.EmployeeVerification;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeVerificationValidator {
	public static void validate(List<EmployeeVerification> addressDetails)
			throws  EmployeeAddressException {

			List<String> errors = new ArrayList<>();
			if (!isEmployeeVerificationValid(addressDetails,errors)) {
				throw new EmployeeAddressException(errors);
			}
		}
	
	private static boolean isEmployeeVerificationValid(final List<EmployeeVerification> employeeVerifications ,final List<String> errors) {
			
			boolean result = true;
			
			for(EmployeeVerification employeeVerification: employeeVerifications) {
				result &=isDocumentNoValid(employeeVerification.getDocumentNo(),errors);
				result &=isDocumentIdValid(employeeVerification.getDocumentId(),errors);
				
				

			}
			
			return result;
		}


	

	private static boolean isDocumentIdValid(final long documentId, final List<String> errors) {
		boolean result = true;
		if (documentId==0) {
			errors.add("error.documentId-empty");
			result = false;
		}

		return result;
	}



	private static boolean isDocumentNoValid(final String documentNo, final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(documentNo))) {
			errors.add("error.documentNo-empty");
			result = false;
		}

		return result;
	}



}
