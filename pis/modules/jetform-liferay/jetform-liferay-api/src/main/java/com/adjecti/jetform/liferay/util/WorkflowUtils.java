package com.adjecti.jetform.liferay.util;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.WorkflowDefinitionLink;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalServiceUtil;

import java.util.List;

public class WorkflowUtils {
	public static <T> void startWorkflow(long userId, long companyId, long groupId, T model, long classPK,
			String workflowDefinitionName, ServiceContext serviceContext) throws PortalException {

		KaleoDefinition workflowDefinition = null;

		// find workflow definition
		List<KaleoDefinition> kaleoDefinitions = KaleoDefinitionLocalServiceUtil.getKaleoDefinitions(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		for (KaleoDefinition kaleoDefinition : kaleoDefinitions) {

			if (kaleoDefinition.getTitle("en_US").equalsIgnoreCase(workflowDefinitionName)) {
				workflowDefinition = kaleoDefinition;
				break;
			}
		}

		if (workflowDefinition == null)
			throw new PortalException("No workflow exists by name - " + workflowDefinitionName);

		WorkflowDefinitionLink  workflowDefinitionLink  = WorkflowDefinitionLinkLocalServiceUtil.addWorkflowDefinitionLink(userId, companyId, groupId,
				model.getClass().getName(), 0, 0, workflowDefinition.getName(), workflowDefinition.getVersion()); 

		WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId, userId, model.getClass().getName(), classPK, model, serviceContext);
		
		WorkflowDefinitionLinkLocalServiceUtil.deleteWorkflowDefinitionLink(workflowDefinitionLink);

	}
}
