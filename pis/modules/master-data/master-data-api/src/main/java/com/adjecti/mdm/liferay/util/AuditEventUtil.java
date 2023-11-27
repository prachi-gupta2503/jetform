package com.adjecti.mdm.liferay.util;

import com.adjecti.mdm.liferay.model.OrganizationHistory;
import com.adjecti.mdm.liferay.service.OrganizationHistoryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalServiceUtil;

import java.util.Date;
import java.util.List;



public class AuditEventUtil {
	final static Log LOGGER = LogFactoryUtil.getLog(AuditEventUtil.class.getName());
	
	public static void logEvent(ThemeDisplay themeDisplay,ServiceContext serviceContext,String eventType,String classPk,String className) {
		
		
		List<OrganizationHistory> organizationHistories=OrganizationHistoryLocalServiceUtil.getByPreviousOrganizationId(Long.parseLong(classPk));
		JSONArray createJSONArray = JSONFactoryUtil.createJSONArray();
		for(OrganizationHistory organizationHistory: organizationHistories) {
			JSONObject createJSONObject = JSONFactoryUtil.createJSONObject();
			createJSONObject.put("New Organization", organizationHistory.getOrganizationName());
			createJSONObject.put("Unit", organizationHistory.getPreviousParentOrganizationName());
			createJSONObject.put("New Unit", organizationHistory.getPreviousParentOrganizationName());
			createJSONArray.put(createJSONObject);
		}
		createJSONArray.toString();
		LOGGER.info(serviceContext);
		LOGGER.info(serviceContext.getUserId());
		User user=null;
		try {
			user=UserLocalServiceUtil.getUser(serviceContext.getUserId());
			LOGGER.info(user);
		AuditEvent auditEvent = AuditEventLocalServiceUtil.createAuditEvent(CounterLocalServiceUtil.increment());
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setAdditionalInfo("");
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setClassName(className);
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setClassPK(classPk);
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setClientHost(serviceContext.getRemoteHost());
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setClientIP(serviceContext.getRemoteAddr());
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setCompanyId(serviceContext.getCompanyId());
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setCreateDate(new Date());
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setEventType(eventType);
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setMessage("");
		auditEvent.setAdditionalInfo(createJSONArray.toString());
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setServerName(themeDisplay.getServerName());
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setServerPort(themeDisplay.getServerPort());
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setSessionID(themeDisplay.getSessionId());
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setUserId(user.getUserId());
		LOGGER.info("Audit Event created Successfully  ");
		auditEvent.setUserName(user.getFullName());
		LOGGER.info("Audit Event created Successfully  ");
		
		AuditEventLocalServiceUtil.addAuditEvent(auditEvent);
		LOGGER.info("Audit Event created Successfully  ");
		}catch(Exception e) {
			LOGGER.info("Audit Event creation failed  ");
	}
}

}
