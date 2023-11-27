package com.adjecti.mdm.liferay.enumeration;

public enum CasteCategoryEnum {
	GENERAL(1),
	OBC(2),
	SC(3),
	ST(4) ;

	private final int casteCategoryCode;

	CasteCategoryEnum(int casteCategoryCode){
		this.casteCategoryCode = casteCategoryCode;
	}


	public int getCasteCategoryCode() {
		return this.casteCategoryCode;
	}
}
