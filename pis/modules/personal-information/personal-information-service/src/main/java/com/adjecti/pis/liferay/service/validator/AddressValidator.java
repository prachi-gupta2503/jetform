package com.adjecti.pis.liferay.service.validator;

import com.adjecti.pis.liferay.exception.EmployeeAddressException;
import com.adjecti.pis.liferay.model.Address;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class AddressValidator {

	
	
	public static void validate(List<Address> addressDetails,long employeeId)
			throws  EmployeeAddressException {

			List<String> errors = new ArrayList<>();
			if (!isAddressValid(addressDetails,employeeId,errors)) {
				throw new EmployeeAddressException(errors);
			}
		}
	
	private static boolean isAddressValid(final List<Address> addressDetails ,final long employeeId,final List<String> errors) {
			
			boolean result = true;
			
			result &=isEmployeeIdValid(employeeId,errors);
			
			for(Address addressDetail: addressDetails) {
				result &=isAddressLine1Valid(addressDetail.getAddressLine1(),errors);
				result &=isAddressLine2Valid(addressDetail.getAddressLine2(),errors);
				result &=isCityValid(addressDetail.getCity(),errors);
				result &=isPinCodeValid(addressDetail.getPinCode(),errors);
				result &=isStateIdValid(addressDetail.getStateId(),errors);
				result &=isCountryIdValid(addressDetail.getCountryId(),errors);
				result &=isDistrictIdValid(addressDetail.getDistrictId(),errors);
			}
			
			return result;
		}


	

	private static boolean isEmployeeIdValid(final long employeeId,final List<String> errors) {
		boolean result = true;
		if (employeeId==0) {
			errors.add("error.employeeId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isAddressLine3Valid(final String addressLine3,final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(addressLine3))) {
			errors.add("error.addressLine3-empty");
			result = false;
		}

		return result;
	}

	private static boolean isCityValid(final String city,final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(city))) {
			errors.add("error.city-empty");
			result = false;
		}

		return result;
	}

	private static boolean isPinCodeValid(final String pinCode,final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(pinCode))) {
			errors.add("error.pinCode-empty");
			result = false;
		}

		return result;
	}

	private static boolean isStateIdValid(final long stateId,final List<String> errors) {
		boolean result = true;
		if (stateId==0) {
			errors.add("error.stateId-empty");
			result = false;
		}

		return result;
	

	}

	private static boolean isCountryIdValid(final long countryId,final List<String> errors) {
		boolean result = true;
		if (countryId==0) {
			errors.add("error.countryId-empty");
			result = false;
		}

		return result;

	}

	private static boolean isDistrictIdValid(final long districtId,final List<String> errors) {
		boolean result = true;
		if (districtId==0) {
			errors.add("error.districtId-empty");
			result = false;
		}

		return result;
	}


	private static boolean isAddressLine2Valid(final String addressLine2,final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(addressLine2))) {
			errors.add("error.addressLine2-empty");
			result = false;
		}

		return result;
	}

	private static boolean isAddressLine1Valid(final String addressLine1,final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(addressLine1))) {
			errors.add("error.addressLine1-empty");
			result = false;
		}

		return result;
	}



	
}
