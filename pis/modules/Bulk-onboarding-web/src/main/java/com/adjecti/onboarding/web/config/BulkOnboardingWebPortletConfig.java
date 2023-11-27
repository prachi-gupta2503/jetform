package com.adjecti.onboarding.web.config;

import java.io.File;

import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id="com.adjecti.onboarding.web.config.BulkOnboardingWebPortletConfig")
public interface BulkOnboardingWebPortletConfig {

	@Meta.AD(required=false)
	public File uploadFile();
}
