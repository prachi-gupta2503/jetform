package com.adjecti.jetform.liferay.helper;

import com.adjecti.jetform.annotation.HtmlFormWrapper;
import com.liferay.portal.kernel.json.JSONException;

import java.lang.reflect.Method;
import java.util.Map;

public interface JetFormRendererHelper {

	HtmlFormWrapper rendererForm(String className) throws JSONException;

	HtmlFormWrapper rendererForm(Class<?> className) throws JSONException;

	HtmlFormWrapper rendererForm(String className, String formClassPK) throws JSONException;

	HtmlFormWrapper rendererFormByFormFlowProcessId(String className, String formFlowProcessId) throws JSONException;

	
	
}
