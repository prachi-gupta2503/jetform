package com.adj.liferay.documentmedia.commands;

import com.adj.liferay.documentmedia.constants.DocumentMediaPortletKeys;
import com.adj.liferay.documentmedia.constants.MVCCommandName;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + DocumentMediaPortletKeys.DOCUMENTMEDIA,
		"mvc.command.name=" + MVCCommandName.SEARCHDOCUMENT }, service = MVCRenderCommand.class)
public class SearchRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		List<DLFileEntry> dlFileEntry = null;

		List<DLFileEntry> fileEntries = new ArrayList<DLFileEntry>();
		Map<String,String> paramMap = new HashMap<String,String>();
		
		String organization = ParamUtil.getString(renderRequest, "organization");
		String documentType = ParamUtil.getString(renderRequest, "documentType");
		String status = ParamUtil.getString(renderRequest, "status");
		String duration = ParamUtil.getString(renderRequest, "duration");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		/**
		 * key in the map should be the column name
		 */
		if(organization!=null && organization!="" && !organization.equals("-1"))
			paramMap.put("organization",organization);
		if(documentType!=null && documentType!="" && !documentType.equals("-1"))
			paramMap.put("fileEntryTypeId",documentType);
		if(status!=null && status!="" && !status.equals("-1"))
			paramMap.put("status",status);
		if(duration!=null && duration!="" && !duration.equals("-1"))
			paramMap.put("duration",duration);
		if(keywords!=null && !keywords.equals(""))
			paramMap.put("title",keywords);

		if ((documentType.equals("-1") || documentType.equals("")) && (organization.equals("-1") || organization.equals("")) 
				&& (status.equals("-1")||status.equals("")) && (duration.equals("-1")||duration.equals(""))
				&& keywords.equals("")) {
			fileEntries = getAllDLFileEntries();
		} else {
			fileEntries = searchDLFileEntries(paramMap);
		}
		renderRequest.setAttribute("dlFileEntries", fileEntries);
		return "/view.jsp";
	}

	private List<DLFileEntry> getAllDLFileEntries() {
		List<DLFileEntry> dlFileEntries = DLFileEntryLocalServiceUtil.getFileEntries(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		return dlFileEntries;
	}

	
	public List<DLFileEntry> searchDLFileEntries(Map<String,String> searchParam) {
		DynamicQuery dlFileEntryQuery = DynamicQueryFactoryUtil.forClass(DLFileEntry.class,
				PortalClassLoaderUtil.getClassLoader());

		for (Map.Entry<String,String> entry : searchParam.entrySet()) {
			if (Validator.isNotNull(entry.getKey())) {
				Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
				Object value=null;
				try {
					value = Long.parseLong(entry.getValue());
					disjunctionQuery.add(RestrictionsFactoryUtil.eq(entry.getKey(), value));
				}catch(Exception e) {
					value = entry.getValue();
					disjunctionQuery.add(RestrictionsFactoryUtil.ilike(entry.getKey(), "%"+value+"%"));
				}
				dlFileEntryQuery.add(disjunctionQuery);
			}
		}
		return DLFileEntryLocalServiceUtil.dynamicQuery(dlFileEntryQuery);
	}

}
