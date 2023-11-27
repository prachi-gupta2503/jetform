package com.adjecti.liferay.organization.web.command;

import com.adjecti.liferay.organization.web.constants.MVCCommandNames;
import com.adjecti.liferay.organization.web.constants.OrgChartPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = { "javax.portlet.name=" + OrgChartPortletKeys.ORGCHART,
		"mvc.command.name=" + MVCCommandNames.SAVEORGANIZATION }, service = MVCActionCommand.class)
public class SaveOrganizationActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
		long parentOrganizationId = ParamUtil.getLong(actionRequest, "parentId");
		String name = ParamUtil.getString(actionRequest, "name");
		long imageId=ParamUtil.getLong(actionRequest, "imageId");
		String shortName = ParamUtil.getString(actionRequest, "shortName");
		long organizationTypeId = ParamUtil.getLong(actionRequest, "organizationTypeId");
		String type = "organization";
		long regionId = 0;
		long countryId = 0;
		long statusId = 12017;
		String comments = "";
		boolean site = true;
		/*try {
			Organization organization = null;
			OrganizationDetail organizationDetail = null;
			if (organizationId != 0) {
				organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
				organizationDetail = OrganizationDetailLocalServiceUtil
						.getAllOrganizationDetailByOrganizationId(organizationId).get(0);
				organization.setName(name);
				organization.setParentOrganizationId(parentOrganizationId);
				OrganizationLocalServiceUtil.updateOrganization(organization);
				organizationDetail.setOrganizationId(organization.getOrganizationId());
				organizationDetail.setShortName(shortName);
				organizationDetail.setOrganizationTypeId(organizationTypeId);
				organizationDetail.setImageId(imageId);
				organizationDetail.setGroupId(organization.getGroupId());
				OrganizationDetailLocalServiceUtil.updateOrganizationDetail(organizationDetail);

			} else {

				organization = OrganizationLocalServiceUtil.addOrganization(
						ServiceContextThreadLocal.getServiceContext().getUserId(), parentOrganizationId, name, type,
						regionId, countryId, statusId, comments, site, ServiceContextThreadLocal.getServiceContext());

				organizationDetail = OrganizationDetailLocalServiceUtil.createOrganizationDetail(
						CounterLocalServiceUtil.increment(OrganizationDetail.class.getName()));
				organizationDetail.setOrganizationId(organization.getOrganizationId());
				organizationDetail.setShortName(shortName);
				organizationDetail.setOrganizationTypeId(organizationTypeId);
				organizationDetail.setGroupId(organization.getGroupId());
				organizationDetail.setImageId(imageId);
				OrganizationDetailLocalServiceUtil.addOrganizationDetail(organizationDetail);

			}
		} catch (PortalException e) {
			e.printStackTrace();
		}*/
	}

}
