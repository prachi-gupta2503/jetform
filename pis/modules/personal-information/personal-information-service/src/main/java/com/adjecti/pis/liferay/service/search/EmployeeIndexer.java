package com.adjecti.pis.liferay.service.search;

import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
	    immediate = true,
	    service = Indexer.class
)
public class EmployeeIndexer extends BaseIndexer<Employee> {
	private final Log _logger = LogFactoryUtil.getLog(EmployeeIndexer.class.getName());
	@Reference
	private EmployeeLocalService employeeLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	
	 
	 
	public static final String CLASS_NAME = Employee.class.getName();
	public static final String MODEL_NAME = Employee.class.getSimpleName();
	

	public EmployeeIndexer() {

		setDefaultSelectedFieldNames(Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT, Field.ENTRY_CLASS_NAME,
				Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID,
				 "name");
		setPermissionAware(false);
	}

	@Override
	public String getClassName() {

		return CLASS_NAME;
	}
	
	@Override
	public void postProcessContextBooleanFilter(BooleanFilter contextBooleanFilter, SearchContext searchContext)
			throws Exception {
		addStatus(contextBooleanFilter, searchContext);
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext) throws Exception {
		if(Validator.isNotNull(searchContext.getAttribute("simpleSearch"))) {
			
			
			addSearchLocalizedTerm(searchQuery, searchContext, "email", false);
			addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
			addSearchLocalizedTerm(searchQuery, searchContext, "name", false);
		}
		
	}

	@Override
	protected void doDelete(Employee employee) throws Exception {

		deleteDocument(employee.getCompanyId(), employee.getEmployeeId());
	}

	@Override
	protected Document doGetDocument(Employee employee) throws Exception {

		Document document = getBaseModelDocument(CLASS_NAME, employee);
		document.addKeyword(Field.COMPANY_ID, employee.getCompanyId());
		document.addKeyword(Field.GROUP_ID, employee.getGroupId());
		document.addKeyword(Field.SCOPE_GROUP_ID, employee.getGroupId());
		document.addText("name", employee.getUserName());
		document.addKeyword("email", employee.getEmailId());
	
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(Employee employee) throws Exception {
		Document document = getDocument(employee);
		indexWriterHelper.updateDocument(
		getSearchEngineId(), employee.getCompanyId(), document,
		isCommitImmediately());

	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
	Employee employee = employeeLocalService.getEmployee(classPK);
	doReindex(employee);
	}


	protected void reindexEmployee(long companyId) throws PortalException {
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = employeeLocalService
				.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		indexableActionableDynamicQuery.setPerformActionMethod(

				new ActionableDynamicQuery.PerformActionMethod<Employee>() {

					@Override
					public void performAction(Employee employee) {
						try {
							Document document = getDocument(employee);
							indexableActionableDynamicQuery.addDocuments(document);
						} catch (PortalException pe) {
				        	_logger.error("EmployeeIndexer [" + new Date() + "] : [Message : Unable to index employeeId : employeeId : "+employee.getEmployeeId() +" : "+pe.getLocalizedMessage()+"]");
						}
					}

				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
	long companyId = GetterUtil.getLong(ids[0]);
	reindexEmployee(companyId);
	}

}
