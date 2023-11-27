package com.adjecti.mdm.liferay.enumeration;


public enum MaritalStatusEnum {
	MARRIED(1),
	UNMARRIED(2),
	DIVORCED(3),
	WIDOWED(4) ;

	private final int MaritalStatusCode;

	MaritalStatusEnum(int MaritalStatusCode){
		this.MaritalStatusCode = MaritalStatusCode;
	}


	public int getMaritalStatusCode() {
		return this.MaritalStatusCode;
	}
}
