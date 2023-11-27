package net.ayudh.audit.util;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalServiceUtil;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



public class AuditEventUtil {
	final static Log LOGGER = LogFactoryUtil.getLog(AuditEventUtil.class.getName());
	
	public static void logEvent(String eventType,String classPk,String className,String additionalInfo,String modelName) {
		
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		HttpServletRequest request = serviceContext.getRequest();
		LOGGER.info("Hello :-  ");
		LOGGER.info(themeDisplay);
		LOGGER.info("request :-  "+request);
		String ipAddress = request.getHeader("X-FORWARDED-FOR");  
		if (ipAddress == null) {  
		    ipAddress = request.getRemoteAddr();  
		    LOGGER.info("ipAddress if :-  "+ipAddress);
		}
        LOGGER.info("ipAddress :-  "+ipAddress);
		try {
		User user;
			if(themeDisplay!=null) {
				LOGGER.info("Inside IF");
				user=themeDisplay.getUser();
		
		}else {
		user= UserLocalServiceUtil.getUser(serviceContext.getUserId());
		LOGGER.info("Inside Else");
		}
			
			List<AuditEvent> auditEvents = AuditEventLocalServiceUtil.getAuditEvents(-1, -1);
			int i=0;
		for(AuditEvent auditEvent:auditEvents) {
			String className2 = auditEvent.getClassName();
			if(auditEvent.getClassName().equalsIgnoreCase("com.liferay.journal.model.JournalArticle") ||
					auditEvent.getClassName().equalsIgnoreCase("com.liferay.document.library.kernel.model.DLFileEntry") ||
					auditEvent.getClassName().equalsIgnoreCase("com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord") ||
					auditEvent.getClassName().equalsIgnoreCase("com.liferay.dynamic.data.mapping.model.DDMFormInstance") 	) {
				i++;
			}
		}
		LOGGER.info("Inside i "+i);
		AuditEvent auditEvent = AuditEventLocalServiceUtil.createAuditEvent(CounterLocalServiceUtil.increment());
		auditEvent.setAdditionalInfo(additionalInfo);
		auditEvent.setClassName(className);
		auditEvent.setClassPK(classPk);
		auditEvent.setClientHost(serviceContext.getRemoteHost());
		auditEvent.setClientIP(ipAddress);
		auditEvent.setCompanyId(serviceContext.getCompanyId());
		auditEvent.setCreateDate(new Date());
		auditEvent.setEventType(eventType);
		auditEvent.setMessage(modelName);
		auditEvent.setServerName(themeDisplay.getServerName());
		auditEvent.setServerPort(themeDisplay.getServerPort());
		auditEvent.setSessionID(themeDisplay.getSessionId());
		auditEvent.setUserId(user.getUserId());
		auditEvent.setUserName(user.getFullName());
		
		AuditEventLocalServiceUtil.addAuditEvent(auditEvent);
		LOGGER.info("Audit Event created Successfully  ");
		}catch(Exception e) {
			LOGGER.info("Audit Event creation failed  ");
	}
}

}
