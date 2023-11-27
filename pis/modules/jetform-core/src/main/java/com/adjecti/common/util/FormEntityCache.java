package com.adjecti.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FormEntityCache {
	private static final Log LOGGER = LogFactoryUtil.getLog(FormEntityCache.class.getName());

	private static Map<String, Class> formClassCache=new HashMap<String, Class>();
	
	public static void registerPackages(String packageNames) {
		//LOGGER.info("registerFormClass(entityClass.getName()):"+entityClass.getName());
		Set<Class> classes=scanPackages(packageNames);
		for(Class c:classes) {
			formClassCache.put(c.getName(),c);
		}
	}
	
	public static void registerFormClass(Class entityClass) {
		//LOGGER.info("registerFormClass(entityClass.getName()):"+entityClass.getName());
		formClassCache.put(entityClass.getName(),entityClass);
	}
	public static Class getFormClass(String className) {
		//LOGGER.info("getFormClass(className):"+className);
		return formClassCache.get(className);
	}
	public static Class getFormClassBySimpleName(String classSimpleName) {
		//LOGGER.info("getFormClass(className):"+className);
		Class clazz=null;
		
		for(Map.Entry<String, Class> entry: formClassCache.entrySet()) {
			String key=entry.getKey();
			if (key.toLowerCase().endsWith("."+classSimpleName.toLowerCase())) {
				clazz=entry.getValue();
				break;
			}
		}
		return clazz;
	}
	
	public static Set<Class> scanPackages(String packageNames) {
		String packageNamesArray[]=packageNames.split(",");
		Set<Class> classes=new HashSet<Class>();
		for(String packageName:packageNamesArray) {
			classes.addAll(scanPackage(packageName));
		}
		return classes;
	}
	
	public static Set<Class> scanPackage(String packageName) {
		InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		return reader.lines().filter(line -> line.endsWith(".class")).map(line -> getClass(line, packageName))
				.collect(Collectors.toSet());
	}

	private static Class getClass(String className, String packageName) {
		try {
			return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
		} catch (ClassNotFoundException e) {
		}
		return null;
	}
}
