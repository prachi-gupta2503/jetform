package com.adjecti.pis.liferay.service.validator;

import com.adjecti.pis.liferay.exception.PeopleException;
import com.adjecti.pis.liferay.model.People;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleValidator {

	
	public static void validate(
			 final People people)
			throws PeopleException {

			List<String> errors = new ArrayList<>();
			if (!isPeopleValid(people,errors)) {
				throw new PeopleException(errors);
			}
		}
	
	private static boolean isPeopleValid( final People people,final List<String> errors) {
			
			
		
			boolean result = true;
			
			result &=isDateOfBirthValid(people.getDateOfBirth(),errors);
			result &=isCitizenIdValid(people.getCitizenshipId(),errors);
			result &=isPhTypeIdValid(people.getPhTypeId(),errors);
			result &=isReligionIdValid(people.getReligionId(),errors);
			
			result &=isAadhaarNoValid(people.getAadhaarNo(),errors);
			result &=isAadhaarNoValid(people.getPanNo(),errors);
			result &=isFirstName_EnValid(people.getFirstName_En(),errors);
			result &=isFirstName_HiValid(people.getFirstName_Hi(),errors);
			result &=isLastName_HiValid(people.getLastName_Hi(),errors);
			result &=isLastName_EnValid(people.getLastName_En(),errors);
			
			result &=isAppellationValid(people.getAppellationId(),errors);
			result &=isBloodGroupValid(people.getBloodGroupId(),errors);
			result &=isGenderValid(people.getGenderId(),errors);
			result &=isCastCategoryValid(people.getCasteCategoryId(),errors);
			result &=isMaritalStatusValid(people.getMaritalStatusId(),errors);
			return result;
		}


	

	private static boolean isFirstName_HiValid(String firstName_Hi, List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(firstName_Hi))) {
			errors.add("error.lastName_Hi-empty");
			result = false;
		}

		return result;

	}

	private static boolean isMaritalStatusValid(final long maritalStatus,final List<String> errors) {

		boolean result = true;
		if (maritalStatus==0) {
			errors.add("error.maritalStatus-empty");
			result = false;
		}

		return result;
	}

	private static boolean isCastCategoryValid(final long castCategory, final List<String> errors) {
		boolean result = true;
		if (castCategory==0) {
			errors.add("error.castCategory-empty");
			result = false;
		}

		return result;
	}

	private static boolean isGenderValid(final long gender,final  List<String> errors) {
		boolean result = true;
		if (gender==0) {
			errors.add("error.gender-empty");
			result = false;
		}

		return result;
	}

	private static boolean isBloodGroupValid(final long bloodGroup, final List<String> errors) {
		boolean result = true;
		if (bloodGroup==0) {
			errors.add("error.bloodGroup-empty");
			result = false;
		}

		return result;
	}

	private static boolean isAppellationValid(final long appellation, final List<String> errors) {
		boolean result = true;
		if (appellation==0) {
			errors.add("error.appellation-empty");
			result = false;
		}

		return result;
	}

	private static boolean isLastName_EnValid(final String lastName_En, final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(lastName_En))) {
			errors.add("error.lastName_En-empty");
			result = false;
		}

		return result;
	}

	private static boolean isFirstName_EnValid(final String firstName_En, final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(firstName_En))) {
			errors.add("error.firstName_En-empty");
			result = false;
		}

		return result;
	}

	
	private static boolean isLastName_HiValid(final String lastName_Hi,final  List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(lastName_Hi))) {
			errors.add("error.lastName_Hi-empty");
			result = false;
		}

		return result;
	}

	private static boolean isAadhaarNoValid(final String aadhaarNo, final List<String> errors) {
		boolean result = true;

		if ((Validator.isBlank(aadhaarNo))) {
			errors.add("error.aadhaarNo-empty");
			result = false;
		}

		return result;
	}

	private static boolean isReligionIdValid(final long religionId,final  List<String> errors) {
		boolean result = true;
		if (religionId==0) {
			errors.add("error.religionId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isPhTypeIdValid(final long phTypeId, final List<String> errors) {
		boolean result = true;
		if (phTypeId==0) {
			errors.add("error.phTypeId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isCitizenIdValid(final long citizenId, final List<String> errors) {
		boolean result = true;
		if (citizenId==0) {
			errors.add("error.citizenId-empty");
			result = false;
		}

		return result;
	}

	private static boolean isDateOfBirthValid(final Date dateOfBirth, final List<String> errors) {
		boolean result = true;
		if ((Validator.isNull(dateOfBirth))) {
			errors.add("error.dateOfBirth-empty");
			result = false;
		}

		return result;
	}
}
