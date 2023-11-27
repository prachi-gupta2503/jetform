package com.adjecti.mdm.liferay.enumeration;

public enum BloodGroupEnum {
	APOS(1),
	ANEG(2),
	BPOS(3),
	BNEG(4),
	ABPOS(5),
	ABNEG(6),
	OPOS(7),
	ONEG(8) ;

	private final int bloodGroupCode;

	BloodGroupEnum(int bloodGroupCode){
		this.bloodGroupCode = bloodGroupCode;
	}


	public int getBloodGroupCodeeCode() {
		return this.bloodGroupCode;
	}



}
