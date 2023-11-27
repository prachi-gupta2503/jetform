package com.adjecti.pis.workflow;

import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.service.RegistrationRequestLocalServiceUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.constants.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplayFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = "background.task.executor.class.name=com.adjecti.pis.workflow.OnboardingWorkflowStarter", 
				service = BackgroundTaskExecutor.class)
public class OnboardingWorkflowStarter extends BaseBackgroundTaskExecutor {
	final static Log LOGGER = LogFactoryUtil.getLog(OnboardingWorkflowStarter.class.getName());
	
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		
		long registrationRequestId = 0;
		try {
			registrationRequestId=((Long) backgroundTask.getTaskContextMap().get("registrationRequestId")).longValue();
		}catch(Exception e) {
			LOGGER.info("Failed to read registrationRequestId as long value. Reason : "+e.getMessage());
		}
		
		if(registrationRequestId<=0) {
			try {
				registrationRequestId=((Integer) backgroundTask.getTaskContextMap().get("registrationRequestId")).longValue();
			}catch(Exception e) {
				LOGGER.info("Failed to read registrationRequestId as Integer value. Reason : "+e.getMessage());
			}
		}
		
		LOGGER.info("Read the registrationRequestId value : "+registrationRequestId);
		
		RegistrationRequest registrationRequest= RegistrationRequestLocalServiceUtil.getRegistrationRequest(registrationRequestId);
		
		ServiceContext serviceContext  = (ServiceContext) backgroundTask.getTaskContextMap().get("serviceContext");

		WorkflowHandlerRegistryUtil.startWorkflowInstance(registrationRequest.getCompanyId(),
				registrationRequest.getGroupId(), registrationRequest.getUserId(), RegistrationRequest.class.getName(),
				registrationRequest.getPrimaryKey(), registrationRequest, serviceContext);

		return BackgroundTaskResult.SUCCESS;
	}
	

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		return BackgroundTaskDisplayFactoryUtil.getBackgroundTaskDisplay(backgroundTask);
	}

	@Override
	public int getIsolationLevel() {
		return BackgroundTaskConstants.ISOLATION_LEVEL_TASK_NAME;
	}

	@Override
	public BackgroundTaskExecutor clone() {
		return this;
	}
	

}
