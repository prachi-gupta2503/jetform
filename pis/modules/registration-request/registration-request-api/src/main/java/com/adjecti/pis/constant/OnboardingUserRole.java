package com.adjecti.pis.constant;

import java.util.HashMap;
import java.util.Map;

public enum OnboardingUserRole {

	ADMIN_ROLE("PIS ADMIN"), APPROVER_ROLE("PIS APPROVER"), CREATER_ROLE("PIS UPLOADER");
	
	public final String name;

	private static final Map<OnboardingUserRole, String> BY_NAME = new HashMap<>();
    
    static {
        for (OnboardingUserRole e: values()) {
        	BY_NAME.put(e, e.name);
        }
    }

    public static String valueOf(OnboardingUserRole role) {
        return BY_NAME.get(role);
    }
	
    private OnboardingUserRole(String name) {
        this.name = name;
    }

}
