package net.ayudh.audit.listener;

import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import net.ayudh.audit.util.AuditEventUtil;



@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class DDMFormInstanceRecordModelListener extends BaseModelListener<DDMFormInstanceRecord> {

	final static Log LOGGER = LogFactoryUtil.getLog(DDMFormInstanceRecordModelListener.class.getName());
	
	
	String className=DDMFormInstanceRecord.class.getName();
	
	@Override
	public void onAfterCreate(DDMFormInstanceRecord model) throws ModelListenerException {
		LOGGER.info("DDMFormInstanceRecord On After Create ");
		try {
			AuditEventUtil.logEvent("ADD", String.valueOf(model.getFormInstanceRecordId()),className,"",model.getFormInstance().getName(Locale.US));
		} catch (PortalException e) {
			
		}
			
		
	}

	@Override
	public void onAfterRemove(DDMFormInstanceRecord model) throws ModelListenerException {
		LOGGER.info("DDMFormInstanceRecord On After Remove   ");
		try {
			AuditEventUtil.logEvent("DELETE", String.valueOf(model.getFormInstanceRecordId()),className,"",model.getFormInstance().getName(Locale.US));
		} catch (PortalException e) {
			
		}
		
	}

	@Override
	public void onAfterUpdate(DDMFormInstanceRecord model) throws ModelListenerException {
		LOGGER.info("DDMFormInstanceRecord On After Update  ");
		try {
			AuditEventUtil.logEvent("UPDATE", String.valueOf(model.getFormInstanceRecordId()),className,"",model.getFormInstance().getName(Locale.US));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onBeforeCreate(DDMFormInstanceRecord model) throws ModelListenerException {
		
	}

	@Override
	public void onBeforeRemove(DDMFormInstanceRecord model) throws ModelListenerException {
		
	}

	@Override
	public void onBeforeUpdate(DDMFormInstanceRecord model) throws ModelListenerException {
		
	}
	
	
	
}
