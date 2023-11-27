package com.adjecti.mdm.liferay.enumeration;

public enum GenderEnum {
	MALE(1),
	FEMALE(2),
	TRANSGENDER(3) ;

	private final int genderCode;

	GenderEnum(int genderCode){
		this.genderCode = genderCode;
	}


	public int getGenderCode() {
		return this.genderCode;
	}
}
