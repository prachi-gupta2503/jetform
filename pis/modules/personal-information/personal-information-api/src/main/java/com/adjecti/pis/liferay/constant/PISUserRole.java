package com.adjecti.pis.liferay.constant;

import java.util.HashMap;
import java.util.Map;

public enum PISUserRole {
	POWER_USER("power user"), ADMIN("PIS ADMIN"), APPROVER("PIS APPROVER"), CREATER("PIS UPLOADER");//, UPLOADER("PIS UPLOADER");
	public final String name;
	
private static final Map<PISUserRole, String> BY_NAME = new HashMap<>();
    
    static {
        for (PISUserRole e: values()) {
        	BY_NAME.put(e, e.name);
        }
    }

    public static String valueOf(PISUserRole role) {
        return BY_NAME.get(role);
    }
	
    private PISUserRole(String name) {
        this.name = name;
    }
}
