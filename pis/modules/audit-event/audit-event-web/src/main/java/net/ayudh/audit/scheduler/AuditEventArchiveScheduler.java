package net.ayudh.audit.scheduler;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalServiceUtil;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import net.ayudh.audit.model.AuditEventArchive;
import net.ayudh.audit.service.AuditEventArchiveLocalServiceUtil;

@Component(
		immediate = true,
		property = {
			"cron.expression= 5 0 1 * * "  
		},
		service = AuditEventArchiveScheduler.class
	)
public class AuditEventArchiveScheduler  extends BaseMessageListener{
	private static final Log LOGGER = LogFactoryUtil.getLog(AuditEventArchiveScheduler.class.getName());

	@Override
	protected void doReceive(Message message) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("doReceive ***********"+message );
		
		
		  List<AuditEvent> auditEvent = AuditEventLocalServiceUtil.getAuditEvents(-1,
		  -1);
		 try {
		  LocalDate date=LocalDate.now();
		  date.minusMonths(1); 
		  Date LastMonthDate =Date.from(date.atStartOfDay() .atZone(ZoneId.systemDefault()) .toInstant());
		  
		  
		  DynamicQuery AuditEventQuery = DynamicQueryFactoryUtil.forClass(
		  AuditEvent.class, PortalClassLoaderUtil.getClassLoader());
		  
		  AuditEventQuery.add(RestrictionsFactoryUtil.lt("createDate",
		  LastMonthDate));
		  
		  List<Object> dynamicQuery =
		  AuditEventLocalServiceUtil.dynamicQuery(AuditEventQuery);
		  LOGGER.info("dynamicQuery.size()**********"+dynamicQuery.size());
		  
		  AuditEventArchive auditEventArchive =
		  AuditEventArchiveLocalServiceUtil.createAuditEventArchive(
		  CounterLocalServiceUtil.increment());
		  
		  auditEventArchive.setAuditEventArchiveId(auditEvent.get(0).getAuditEventId())
		  ; auditEventArchive.setEventType(auditEvent.get(0).getEventType());
		  auditEventArchive.setClassName(auditEvent.get(0).getClassName());
		  auditEventArchive.setClassPK(auditEvent.get(0).getClassPK());
		  auditEventArchive.setMessage(auditEvent.get(0).getMessage());
		  auditEventArchive.setClientHost(auditEvent.get(0).getClientHost());
		  
		  auditEventArchive.setClientIP(auditEvent.get(0).getClientIP());
		  auditEventArchive.setServerName(auditEvent.get(0).getServerName());
		  auditEventArchive.setServerPort(auditEvent.get(0).getServerPort());
		  auditEventArchive.setSessionId(auditEvent.get(0).getSessionID());
		  auditEventArchive.setAdditionalInfo(auditEvent.get(0).getAdditionalInfo());
		  auditEventArchive.setCompanyId(auditEvent.get(0).getCompanyId());
		  auditEventArchive.setUserId(auditEvent.get(0).getUserId());
		  auditEventArchive.setCreateDate(auditEvent.get(0).getCreateDate());
		  auditEventArchive.setUserName(auditEvent.get(0).getUserName());
		 
		
		AuditEventArchiveLocalServiceUtil.addAuditEventArchive(auditEventArchive);
		
		AuditEvent deleteAuditEvent = AuditEventLocalServiceUtil.deleteAuditEvent(auditEvent.get(0));
		LOGGER.info("deleteAuditEvent"+ deleteAuditEvent.getAuditEventId());
	}
	catch(Exception E) {
		
		}
	}
	
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {
	 
	    try {
	        String cronExpression = GetterUtil.getString(properties.get("cron.expression"), "cronExpression");
	       
	        String listenerClass = getClass().getName();
	        Trigger jobTrigger = TriggerFactoryUtil.createTrigger(listenerClass, listenerClass, new Date(), null, cronExpression);
	 
	        SchedulerEntryImpl schedulerEntryImpl = new SchedulerEntryImpl(listenerClass,jobTrigger);
	        
	 
	       SchedulerEngineHelperUtil.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	 
	    } catch (Exception e) {
	      
	    }
	}

	@Deactivate
	protected void deactive() {
	    SchedulerEngineHelperUtil.unregister(this);
	}
}
