package com.adjecti.pis.liferay.permission;

import java.util.HashMap;
import java.util.Map;

public class PermissionContants {
	public static final String GROUP_A="A";
	public static final String GROUP_B="B";
	public static final String GROUP_B_GO="B(GO)";
	public static final String GROUP_B_NGO="B(NGO)";
	public static final String GROUP_C="C";
	public static final String GROUP_IOFS="IOFS";
	public static final String GROUP_IOFHS="IOFHS";
	
	public static final String ADD_GROUP_A="ADD_GROUP_A";
	public static final String ADD_GROUP_ALL="ADD_GROUP_ALL";
	public static final String ADD_GROUP_B="ADD_GROUP_B";
	public static final String ADD_GROUP_B_GO="ADD_GROUP_B_GO";
	public static final String ADD_GROUP_B_NGO="ADD_GROUP_B_NGO";
	public static final String ADD_GROUP_C="ADD_GROUP_C";
	public static final String ADD_GROUP_IOFHS="ADD_GROUP_IOFHS";
	public static final String ADD_GROUP_IOFS="ADD_GROUP_IOFS";
	public static final String APPROVE_GROUP_A="APPROVE_GROUP_A";
	public static final String APPROVE_GROUP_ALL="APPROVE_GROUP_ALL";
	public static final String APPROVE_GROUP_B="APPROVE_GROUP_B";
	public static final String APPROVE_GROUP_B_GO="APPROVE_GROUP_B_GO";
	public static final String APPROVE_GROUP_B_NGO="APPROVE_GROUP_B_NGO";
	public static final String APPROVE_GROUP_C="APPROVE_GROUP_C";
	public static final String APPROVE_GROUP_IOFHS="APPROVE_GROUP_IOFHS";
	public static final String APPROVE_GROUP_IOFS="APPROVE_GROUP_IOFS";
	public static final String PERMISSIONS="PERMISSIONS";
	public static final String VIEW_PROFILE="VIEW_PROFILE";
	
	static Map<String, String> RESOURCE_ACTIONS = new HashMap<String, String>();
	
	static {
		RESOURCE_ACTIONS.put(ADD_GROUP_A,"A");
		RESOURCE_ACTIONS.put(ADD_GROUP_ALL,"ALL");
		RESOURCE_ACTIONS.put(ADD_GROUP_B,"B");
		RESOURCE_ACTIONS.put(ADD_GROUP_B_GO,"B(GO)");
		RESOURCE_ACTIONS.put(ADD_GROUP_B_NGO, "B(NGO)");
		RESOURCE_ACTIONS.put(ADD_GROUP_C, "C");
		RESOURCE_ACTIONS.put(ADD_GROUP_IOFHS, "IOFHS");
		RESOURCE_ACTIONS.put(ADD_GROUP_IOFS, "IOFS");
		RESOURCE_ACTIONS.put(APPROVE_GROUP_A, "A");
		RESOURCE_ACTIONS.put(APPROVE_GROUP_ALL,"ALL");
		RESOURCE_ACTIONS.put(APPROVE_GROUP_B,"B");
		RESOURCE_ACTIONS.put(APPROVE_GROUP_B_GO,"B(GO)");
		RESOURCE_ACTIONS.put(APPROVE_GROUP_B_NGO,"B(NGO)");
		RESOURCE_ACTIONS.put(APPROVE_GROUP_C, "C");
		RESOURCE_ACTIONS.put(APPROVE_GROUP_IOFHS,"IOFHS");
		RESOURCE_ACTIONS.put(APPROVE_GROUP_IOFS, "IOFS");
		RESOURCE_ACTIONS.put(VIEW_PROFILE, "VIEW");
	}
	
	public static String getAddPermission(String action) {
		return RESOURCE_ACTIONS.get(action);
	}
	
	public static String getApprovePermission(String action) {
		return RESOURCE_ACTIONS.get(action);
	}
}
