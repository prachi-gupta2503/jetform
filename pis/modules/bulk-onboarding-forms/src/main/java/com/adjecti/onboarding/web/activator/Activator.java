package com.adjecti.onboarding.web.activator;

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.onboarding.web.form.SectionImportForm;
import com.adjecti.onboarding.web.form.SectionMappingImportForm;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		
		FormEntityCache.registerFormClass(SectionImportForm.class);
		FormEntityCache.registerFormClass(SectionMappingImportForm.class);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		

	}

}
