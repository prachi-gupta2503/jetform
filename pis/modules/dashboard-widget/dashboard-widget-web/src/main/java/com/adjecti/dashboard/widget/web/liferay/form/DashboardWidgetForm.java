package com.adjecti.dashboard.widget.web.liferay.form;

import com.adjecti.dashboard.widget.model.DashboardWidget;
import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;

@HtmlForm(formId = "DashboardWidgetForm_123456", entityClass = DashboardWidget.class, elementsPerRow = 1, elements = {

		@HtmlElement(name = "dashboardWidgetId", controlType = ControlType.hidden, key = true),
		@HtmlElement(name = "portletName", controlType = ControlType.select, options = {
				"net_ofb_comnet2_dashboard_approval_DashboardApprovalPortlet=Approvals",
				"net_ofb_comnet2_dashboard_approval_DashboardBirthdayPortlet=Birthday",
				"net_ofb_comnet2_dashboard_CalendarDashboardPortlet=Calendar",
				"com_adjecti_liferay_chart_ChartViewPortlet:Chart",
				"net_ofb_comnet2_dashboard_approval_DashboardKmsPortlet=KMS",
				"net_ofb_dashboard_egov_portlet_EgovDashboardPortlet=eGov",
				"net_ofb_dashboard_mail_MailDashboardPortlet=Mail" }, required = true),
		@HtmlElement(name = "thumbnail", controlType = ControlType.fileUpload, required = false ) 
		}

)
public class DashboardWidgetForm {
	DashboardWidget dashboardWidget;

	public DashboardWidgetForm(DashboardWidget dashboardWidget) {
		super();
		this.dashboardWidget = dashboardWidget;
	}

}
