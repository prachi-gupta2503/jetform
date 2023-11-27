package com.adjecti.mdm.liferay.enumeration;

public enum AccomodationTypeEnum {

	PARMANENT (1),
	RESIDENCE (2);
	
	
	private final int accomodationTypeCode;
	
	AccomodationTypeEnum(int accomodationTypeCode){
		this.accomodationTypeCode = accomodationTypeCode;
	}
	
	
	public int getAccomodationTypeCode() {
        return this.accomodationTypeCode;
    }
}
