package com.adjecti.mdm.liferay.constants;


import java.util.HashMap;
import java.util.Map;

public enum ScopeType {

	ORGANIZATION(1),ORGANIZATION_TYPE(2);
	public final int scopeType;

	
	private static final Map<ScopeType, Integer> BY_TYPE = new HashMap<>();
    
    static {
        for (ScopeType type: values()) {
        	BY_TYPE.put(type, type.scopeType);
        }
    }

    public static int valueOf(ScopeType scopeType) {
        return BY_TYPE.get(scopeType);
    }
    
	private ScopeType(int scopeType){
		this.scopeType=scopeType;
	}
	
}
