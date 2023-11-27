package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.UnitType;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoRowLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class UnitTypeModelListener extends BaseModelListener<UnitType>  {
	final static Log LOGGER = LogFactoryUtil.getLog(UnitTypeModelListener.class.getName());
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("onAfterAddAssociation");
	}

	@Override
	public void onAfterCreate(UnitType model) throws ModelListenerException {
		LOGGER.info("onAfterCreate");
		/*long classNameId = ClassNameLocalServiceUtil.getClassNameId(Organization.class.getName());
		ExpandoTable expandoTable;
		String shortDiscription = model.getShortDiscription();
		try {
			expandoTable = ExpandoTableLocalServiceUtil.getTable(ServiceContextThreadLocal.getServiceContext().getCompanyId(), classNameId, "CUSTOM_FIELDS");
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), "UnitType");
			String defaultDataValue = column.getDefaultData().concat(","+shortDiscription);
			column.setDefaultData(defaultDataValue);
			ExpandoColumnLocalServiceUtil.updateExpandoColumn(column);
			System.out.println("Unit  Updated Successfully ");
		
		} catch (PortalException e) {
				e.printStackTrace();
		}
		*/
	}

	@Override
	public void onAfterRemove(UnitType model) throws ModelListenerException {
		LOGGER.info("onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("onAfterRemoveAssociation");
	}

	@Override
	public void onAfterUpdate(UnitType model) throws ModelListenerException {
		LOGGER.info("onAfterUpdate");
	}

	@Override
	public void onBeforeAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("onBeforeAddAssociation");
	}

	@Override
	public void onBeforeCreate(UnitType model) throws ModelListenerException {
		LOGGER.info("onBeforeCreate");	}

	@Override
	public void onBeforeRemove(UnitType model) throws ModelListenerException {
		LOGGER.info("onBeforeRemove");
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("onBeforeRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(UnitType model) throws ModelListenerException {
		LOGGER.info("onBeforeUpdate");
		
		if(model.getDeleted()==true)
		{ 
			String unitType = String.valueOf(model.getUnitTypeId());
			 List<OrganizationDetail> byUnitType =
			 OrganizationDetailLocalServiceUtil.getByUnitType(unitType);
			 LOGGER.info("onBeforeUpdate inside if "+byUnitType+"  count "+byUnitType.size
			 ()); 
			 if(byUnitType.size()>0) {
			 LOGGER.info("onBeforeUpdate inside count>0 "+byUnitType+"  count "+byUnitType
			 .size()); 
			 throw new ModelListenerException("One or more employee exists for this Unit Type id ["
			 +model.getUnitTypeId()+"]."); 
			 }
			
		}
		
		/*
		long userId = ServiceContextThreadLocal.getServiceContext().getUserId();

		long classNameId = ClassNameLocalServiceUtil.getClassNameId(Organization.class.getName());
		ExpandoTable expandoTable;
		int indexOf;
		try {
			expandoTable = ExpandoTableLocalServiceUtil.getTable(ServiceContextThreadLocal.getServiceContext().getCompanyId(), classNameId, "CUSTOM_FIELDS");
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), "UnitType");
			//ExpandoRowLocalServiceUtil.get
			ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(expandoTable.getTableId(), column.getColumnId(), 41392);
			LOGGER.info("EXPANDO VALUE "+expandoValue.getData());
		}catch(Exception e) {
			
		} 
	      */
		
	        
	        
	        
		/*	System.out.println("onBeforeUpdate : UnitType ModelListener :");
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(Organization.class.getName());
		ExpandoTable expandoTable;
		int indexOf;
		String defaultDataValue = null;
		try {
			expandoTable = ExpandoTableLocalServiceUtil.getTable(ServiceContextThreadLocal.getServiceContext().getCompanyId(), classNameId, "CUSTOM_FIELDS");
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), "UnitType");
	        defaultDataValue = column.getDefaultData();
		
		UnitType fetchUnitType = UnitTypeLocalServiceUtil.fetchUnitType(model.getUnitTypeId());
		if(fetchUnitType.getShortDiscription().equalsIgnoreCase(model.getShortDiscription())) {
			 defaultDataValue=defaultDataValue.replace(fetchUnitType.getShortDiscription(),model.getShortDiscription());
		}else if(fetchUnitType.getLongDiscription().equalsIgnoreCase(model.getLongDiscription())){
			 defaultDataValue=defaultDataValue.replace(fetchUnitType.getLongDiscription(),model.getLongDiscription());	
		}
		column.setDefaultData(defaultDataValue);
		ExpandoColumnLocalServiceUtil.updateExpandoColumn(column);
		System.out.println("Unit Updated ");
		}catch(PortalException e) {
			e.printStackTrace();
		}
		
			long classNameId = ClassNameLocalServiceUtil.getClassNameId(Organization.class.getName());
		ExpandoTable expandoTable;
			
		try {
			expandoTable = ExpandoTableLocalServiceUtil.getTable(ServiceContextThreadLocal.getServiceContext().getCompanyId(), classNameId, "CUSTOM_FIELDS");
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), "UnitType");
			String defaultDataValue = column.getDefaultData().concat(",Unit Nine");
			column.setDefaultData(defaultDataValue);
			ExpandoColumnLocalServiceUtil.updateExpandoColumn(column);
			System.out.println("Unit Eight Updated ");
		
		} catch (PortalException e) {
				e.printStackTrace();
		}*/
		
	}

}
