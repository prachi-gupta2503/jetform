/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.adjecti.jetform.liferay.command;

import com.adjecti.jetform.liferay.constants.JetFormMVCPortletKeys;
import com.adjecti.jetform.liferay.service.JetFormBuilderLocalService;
import com.adjecti.jetform.model.KeyValue;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = { "javax.portlet.name=" + JetFormMVCPortletKeys.JETFORMMVC,
		"mvc.command.name=/form-factory/listOptions" }, service = MVCResourceCommand.class)
public class JetFormResourceCommand extends BaseMVCResourceCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(JetFormResourceCommand.class.getName());

	@Reference
	JetFormBuilderLocalService jetFormBuilderLocalService;

	@Override
	protected void doServeResource(ResourceRequest request, ResourceResponse response) throws Exception {
		LOGGER.info("doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) called.");
		String formClass = ParamUtil.getString(request, "formClass");
		String elementName = ParamUtil.getString(request, "elementName");
		String dependantValue = ParamUtil.getString(request, "dependantValue");
		try {
			List<KeyValue> list = null;
			if (StringUtils.isNotEmpty(dependantValue)) {
				//list = jetFormBuilderLocalService.getDependantListOptions(formClass, elementName, dependantValue);
			} else {
				list = jetFormBuilderLocalService.getListOptions(formClass, elementName);
			}
			String data = JSONFactoryUtil.looseSerializeDeep(list);
			LOGGER.info("list : " + data);
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
		} catch (IOException e) {
			LOGGER.error(e);
		}

	}

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) called.");
		return super.serveResource(resourceRequest, resourceResponse);
	}
}