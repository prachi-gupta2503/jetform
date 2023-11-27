package net.ayudh.audit.listener;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;

import net.ayudh.audit.util.AuditEventUtil;



@Component(
		
	    immediate = true,
	    service = ModelListener.class
	)
public class DLFileEntryModelListener extends BaseModelListener<DLFileEntry> {

	final static Log LOGGER = LogFactoryUtil.getLog(DLFileEntryModelListener.class.getName());
	/*
	 * @Reference AuditEventUtil auditEventUtil;
	 */
	
	String className=DLFileEntry.class.getName();
	
	
	@Override
	public void onAfterCreate(DLFileEntry model) throws ModelListenerException {
		LOGGER.info("DLFileEntry On After Create  ");
		
		AuditEventUtil.logEvent("ADD", String.valueOf(model.getFileEntryId()),className,"",model.getFileName());
	}

	@Override
	public void onAfterRemove(DLFileEntry model) throws ModelListenerException {
		LOGGER.info("DLFileEntry On After Remove  ");
		AuditEventUtil.logEvent("DELETE", String.valueOf(model.getFileEntryId()),className,"",model.getFileName());
		
	}

	@Override
	public void onAfterUpdate(DLFileEntry model) throws ModelListenerException {
		LOGGER.info("DLFileEntry On After Update  ");
		AuditEventUtil.logEvent("UPDATE", String.valueOf(model.getFileEntryId()),className,"",model.getFileName());
		
	}

	@Override
	public void onBeforeCreate(DLFileEntry model) throws ModelListenerException {
		
	}

	@Override
	public void onBeforeRemove(DLFileEntry model) throws ModelListenerException {
		
	}

	@Override
	public void onBeforeUpdate(DLFileEntry model) throws ModelListenerException {
		
	}
	
}
