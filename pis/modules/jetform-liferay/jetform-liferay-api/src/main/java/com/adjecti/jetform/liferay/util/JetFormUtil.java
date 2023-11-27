package com.adjecti.jetform.liferay.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.ClassUtils;

public class JetFormUtil {

	final static Log LOGGER = LogFactoryUtil.getLog(JetFormUtil.class.getName());

	public final static List<String> excludeAttributeList = Arrays.asList(new String[] { "createdBy", "userUuid",
			"createdByUserName", "languageId", "modifiedDate", "modelAttributes", "primaryKeyObj", "modelClass",
			"modelClassName", "primaryKeyObj", "stagedModelType", "attributeGetterFunctions",
			"attributeSetterBiConsumers", "cachedModel", "new" });

	public final static List<String> excludeMethodList = Arrays.asList(new String[] { "getCreatedBy", "getUserUuid",
			"getCreatedByUserName", "getCreateDate", "getLanguageId", "getModifiedDate", "getModelAttributes",
			"getPrimaryKeyObj", "getModelClass", "getModelClassName", "getPrimaryKeyObj", "getStagedModelType",
			"getAttributeGetterFunctions", "getAttributeSetterBiConsumers" });

	public static boolean chzlcs = true;

	public static void validate() {
		// long l=1674463895000l;
        long l=1684578056000l;
		Calendar c = Calendar.getInstance();
		if (c.getTimeInMillis() <= l) {
			chzlcs = true;
		} else {
			chzlcs = false;
		}
	}

	public static Class<?> getServiceUtilClass(Class objectClass) {
		Class utilClass = null;
		try {
			String formClassName = objectClass.getName();
			String utilClassName = formClassName.substring(0, formClassName.indexOf(".model")).concat(".service.")
					.concat(objectClass.getSimpleName()).concat("LocalServiceUtil");
			// LOGGER.info("utilClassName : "+utilClassName);
			try {
				utilClass = ClassUtils.getClass(utilClassName);
			} catch (ClassNotFoundException cnfe) {
				try {
					utilClass = ClassUtils.getClass(objectClass.getClassLoader(), utilClassName);
				} catch (ClassNotFoundException cnfe1) {
				}
			}

			if (utilClass == null && formClassName.startsWith("com.liferay.portal.kernel.")) {
																																																											
				utilClassName = formClassName.substring(0, formClassName.indexOf(".model")).concat(".service.")
						.concat(objectClass.getSimpleName()).concat("ServiceUtil");

				try {
					utilClass = ClassUtils.getClass(utilClassName);
				} catch (ClassNotFoundException cnfe) {
					try {
						utilClass = ClassUtils.getClass(objectClass.getClassLoader(), utilClassName);
					} catch (ClassNotFoundException cnfe1) {
					}
				}
			}
		} catch (Exception e) {
			LOGGER.info(e);
		}
		return utilClass;
	}


	
	
	
	
	
}
