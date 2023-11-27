package com.adjecti.dashboard.widget.model.listner;

import com.adjecti.dashboard.widget.model.DashboardWidget;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ModelListener.class)
public class DashboardWidgetModelListener extends BaseModelListener<DashboardWidget> {
	final static Log LOGGER = LogFactoryUtil.getLog(DashboardWidgetModelListener.class.getName());

	@Override
	public void onAfterCreate(DashboardWidget model) throws ModelListenerException {
		long thumbnailId = Long.parseLong(model.getThumbnail());
		try {
			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(thumbnailId);
			setFilePermissions(fileEntry);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static void setFilePermissions(DLFileEntry fileEntry) throws Exception {
		ResourcePermission resourcePermission = null;
		final Role siteMemberRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(), RoleConstants.USER);
		ResourceAction resourceAction = ResourceActionLocalServiceUtil.getResourceAction(DLFileEntry.class.getName(),
				ActionKeys.VIEW);
		try {
			resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(fileEntry.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(fileEntry.getPrimaryKey()), siteMemberRole.getRoleId());

			if (Validator.isNotNull(resourcePermission)) {
				resourcePermission.setActionIds(resourceAction.getBitwiseValue());
				ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
			}
		} catch (NoSuchResourcePermissionException e) {

			resourcePermission = ResourcePermissionLocalServiceUtil
					.createResourcePermission(CounterLocalServiceUtil.increment());
			resourcePermission.setCompanyId(fileEntry.getCompanyId());
			resourcePermission.setName(DLFileEntry.class.getName());
			resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
			resourcePermission.setPrimKey(String.valueOf(fileEntry.getPrimaryKey()));
			resourcePermission.setRoleId(siteMemberRole.getRoleId());
			resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
			ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
		}
	}

}
