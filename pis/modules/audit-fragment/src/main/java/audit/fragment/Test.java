package audit.fragment;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalServiceUtil;

import java.util.List;

public class Test {

	final static Log LOGGER = LogFactoryUtil.getLog(Test.class.getName());
	public  Integer getCustomAuditCount() {
		
		 List<com.liferay.portal.security.audit.storage.model.AuditEvent> auditEvents = AuditEventLocalServiceUtil.getAuditEvents(-1, -1);
			Integer count=0;
			for(AuditEvent auditEvent:auditEvents) {
				String className2 = auditEvent.getClassName();
				if(auditEvent.getClassName().equalsIgnoreCase("com.liferay.journal.model.JournalArticle") ||
						auditEvent.getClassName().equalsIgnoreCase("com.liferay.document.library.kernel.model.DLFileEntry") ||
						auditEvent.getClassName().equalsIgnoreCase("com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord") ||
						auditEvent.getClassName().equalsIgnoreCase("com.liferay.dynamic.data.mapping.model.DDMFormInstance") 	) {
					count++;
				}
			}
			
			LOGGER.info("Count  "+count);
		return count;
		
	}
}
