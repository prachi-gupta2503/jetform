package com.adjecti.pis.liferay.service.validator;

import com.adjecti.pis.liferay.exception.EmployeeDocumentException;
import com.adjecti.pis.liferay.model.EmployeeDocument;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDocumentValidator {

	
	public static void validate(List<EmployeeDocument> employeeDocuments)
			throws EmployeeDocumentException {

			List<String> errors = new ArrayList<>();
			if (!isEmployeeDocumentValid(employeeDocuments,errors)) {
				throw new EmployeeDocumentException(errors);
			}
		}
	
	private static boolean isEmployeeDocumentValid(final List<EmployeeDocument> employeeDocuments ,final List<String> errors) {
			
			boolean result = true;
			
			
			
			for(EmployeeDocument employeeDocument: employeeDocuments) {
				
				result &=isDocumentIdValid(employeeDocument.getDocumentId(),errors);
				result &=isDocumentTypeIdValid(employeeDocument.getDocumentTypeId(),errors);
				result &=isTitleValid(employeeDocument.getTitle(),errors);
				result &=isEmployeeIdValid(employeeDocument.getEmployeeId(),errors);
				
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

	private static boolean isTitleValid(final String title,final  List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(title))) {
			errors.add("error.title-empty");
			result = false;
		}

		return result;
	}

	private static boolean isDocumentTypeIdValid(final long documentTypeId,final  List<String> errors) {
		boolean result = true;

		if (documentTypeId==0) {
			errors.add("error.documentTypeId-empty");
			result = false;
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


	
}
