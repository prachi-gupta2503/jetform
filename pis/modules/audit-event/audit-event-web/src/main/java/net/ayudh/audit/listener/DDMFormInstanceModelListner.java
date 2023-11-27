package net.ayudh.audit.listener;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceReport;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceReportLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMStructureLinkLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMStructureServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalServiceUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import net.ayudh.audit.util.AuditEventUtil;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class DDMFormInstanceModelListner extends BaseModelListener<DDMFormInstance>{

	final static Log LOGGER = LogFactoryUtil.getLog(DDMFormInstanceModelListner.class.getName());
	/* @Reference */
	/* AuditEventUtil auditEventUtil; */
	
	String className=DDMFormInstance.class.getName();
	
	
	@Override
	public void onAfterCreate(DDMFormInstance model) throws ModelListenerException {
		LOGGER.info("Audit Event On After Create Call  ");
		AuditEventUtil.logEvent("ADD", String.valueOf(model.getFormInstanceId()),className,getAdditionalInfo( model),model.getName(Locale.US));
		
	}

	@Override
	public void onAfterRemove(DDMFormInstance model) throws ModelListenerException {
		LOGGER.info("Audit Event On After Remove Call  ");
		AuditEventUtil.logEvent("DELETE", String.valueOf(model.getFormInstanceId()),className,getAdditionalInfo( model),model.getName(Locale.US));
	}

	@Override
	public void onAfterUpdate(DDMFormInstance model) throws ModelListenerException {
		LOGGER.info("Audit Event On After Update Call  ");
		AuditEventUtil.logEvent("UPDATE", String.valueOf(model.getFormInstanceId()),className,getAdditionalInfo( model),model.getName(Locale.US));
	}

	@Override
	public void onBeforeCreate(DDMFormInstance model) throws ModelListenerException {
		
	}

	@Override
	public void onBeforeRemove(DDMFormInstance model) throws ModelListenerException {
		
	}

	@Override
	public void onBeforeUpdate(DDMFormInstance model) throws ModelListenerException {
		
	}
	
	private String getAdditionalInfo(DDMFormInstance model) {
		 try {
			
			return DDMStructureServiceUtil.getStructure(model.getStructureId()).getDefinition();
		} catch (PortalException e) {
			return "";
		} 
		
		
	}

	private void getStructure(long structureId) {
		// TODO Auto-generated method stub
		
	}
	

}
