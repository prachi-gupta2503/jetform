package com.adj.liferay.documentmedia.portlet;

import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;

public class DocumentMediaExpando {
	public static void addCustomField(ActionRequest actionRequest,ThemeDisplay themeDisplay,ServiceContext serviceContext,String columnName,String className) throws PortalException {
		long companyId=themeDisplay.getCompanyId();
		//String className = DLFileEntry.class.getName();
		//String columnName = "OrganizationId";
		System.out.println(ParamUtil.getLong(actionRequest,"documentId")+" : fileId+++");
		long documentId=ParamUtil.getLong(actionRequest,"documentId");
		ExpandoTable expandoTable;
		try { 
			expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, className);
		} catch (NoSuchTableException e) {
			expandoTable = ExpandoTableLocalServiceUtil.addDefaultTable(companyId, className);
		}
		ExpandoColumn expandoColumn;
		expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), columnName);
		if (expandoColumn==null){
			expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(
					expandoTable.getTableId(), 
					columnName, 
					ExpandoColumnConstants.BOOLEAN);
		}
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(className);
		System.out.println(classNameId+" : classNameId");
	    ExpandoValueLocalServiceUtil.addValue(classNameId, expandoTable.getTableId(), ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), columnName).getColumnId(),documentId,ParamUtil.getString(actionRequest, "radioOptions") );	
	}
}
