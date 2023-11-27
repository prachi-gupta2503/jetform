package com.adjecti.mdm.liferay.enumeration;

public enum AppellationEnum {
	MR (1),
	MRS (2),
	MS (3),
	SHRI (4); 

	private final int appellationCode;

	AppellationEnum(int appellationCode){
		this.appellationCode = appellationCode;
	}

	 public int getAppellation() {
	        return this.appellationCode;
	    }
}
