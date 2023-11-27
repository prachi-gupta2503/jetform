package com.adjecti.common.util;



import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.nio.intraband.proxy.annotation.Id;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class ReflectionUtil {
	private static final Log LOGGER = LogFactoryUtil.getLog(ReflectionUtil.class.getName());
	// final static DateFormat SOURCE_DATE_FORMAT = new
	// SimpleDateFormat("yyyy-MM-dd");
	final static DateFormat TARGET_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	// final static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	final static NumberFormat DECIMAL_NUMBER_FORMAT = new DecimalFormat("###,###,##0.00");
	final static NumberFormat INTEGER_NUMBER_FORMAT = new DecimalFormat("###,###,##0");

	public static Class loadClass(String className) {
		try {
			return Class.forName(className);

		} catch (Exception e) {
			//// LOGGER.info(e.getMessage());
		}
		return null;
	}

	public static Object newInstance(Class clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			//// LOGGER.info(e.getMessage());
		}
		return null;
	}

	public static Object newInstance(String clazz) {
		return newInstance(loadClass(clazz));
	}

	public static Object getProperty(Object bean, String property) {
		return invokeGet(bean, property);
	}

	public static Object getPrimaryKey(Object entity) {
		return invokeGet(entity, "primaryKey");
	}
	
	public static Object invokeGet(Object bean, String property) {
		if (bean == null) {
			return null;
		}
		try {
			// return bean.getClass().getMethod("get" + StringUtils.capitalize(property),
			// new Class[] {}).invoke(bean, new Object[] {});
			return getAccessorMethodByFieldName(bean.getClass(), property).invoke(bean, new Object[] {});
		} catch (Exception e1) {
			// LOGGER.warn(e1.getMessage());
		}
		return null;
	}

	public static boolean setProperty(Object bean, String property, Object value) {
		return invokeSet(bean, property, value);
	}

	public static boolean invokeSet(Object bean, String property, Object value) {
		if (bean == null) {
			return false;
		}
		try {
			Class clazz = getFieldType(bean.getClass(), property);
			if (clazz == null) {
				return false;
			}
			Method m = getSetterMethod(bean.getClass(), property);
			if (m == null) {
				return false;
			}
			m.invoke(bean, new Object[] { value });
			return true;
		} catch (Exception e1) {

//			try {
//				bean.getClass().getMethod("set" + StringUtils.capitalize(property), new Class[] { value.getClass() })
//				.invoke(bean, new Object[] { value });
//			} catch (Exception e) {
//				//LOGGER.info(e.getMessage());
//			}
			// System.out.println(e1.getMessage());
		}
		return false;
	}

	public static Map<String, Method> getMethodsByAnnotation(Class entityClass, Class annotation) {
		if (entityClass == null) {
			return null;
		}
		Map<String, Method> result = new HashMap<String, Method>();
		Method[] entityMethods = entityClass.getDeclaredMethods();
		for (Method method : entityMethods) {
			if (method.isAnnotationPresent(annotation)) {
				result.put(method.getName(), method);
			}
		}
		return result;
	}

	public static Map<String, Method> getMethodsByAnnotation(String entityClassName, Class annotation) {
		try {
			Class entityClass = Class.forName(entityClassName);
			return getMethodsByAnnotation(entityClass, annotation);
		} catch (Exception e) {
			// LOGGER.info(e.getMessage());
		}
		return null;
	}

	public static Map<String, Field> getFieldsByAnnotation(String entityClassName, Class annotation) {
		try {
			Class entityClass = Class.forName(entityClassName);
			return getFieldsByAnnotation(entityClass, annotation);
		} catch (Exception e) {
			// LOGGER.info(e.getMessage());
		}
		return null;
	}

	public static Map<String, Field> getFieldsByAnnotation(Class entityClass, Class annotation) {
		if (entityClass == null) {
			return null;
		}
		Map<String, Field> result = new HashMap<String, Field>();
		Field[] fields = entityClass.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(annotation)) {
				result.put(field.getName(), field);
			}
		}
		return result;
	}

	public static String getAccessorFieldNameByReturnType(String beanClass, String returnType) {
		return getAccessorFieldNameByReturnType(beanClass, loadClass(returnType));
	}

	public static String getAccessorFieldNameByReturnType(String beanClass, Class returnType) {
		return getAccessorFieldNameByReturnType(loadClass(beanClass), returnType);
	}

	public static String getAccessorFieldNameByReturnType(Class beanClass, Class returnType) {
		String field = null;
		try {
			Method[] methods = beanClass.getDeclaredMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("get") && m.getReturnType() == returnType) {
					field = StringUtils.uncapitalize(m.getName().substring("get".length()));
					break;
				}
			}
		} catch (Exception e) {
			//LOGGER.warn("No field found in " + beanClass.getName() + " for " + returnType.getName());
		}
		return field;
	}

	public static Method getAccessorMethodByReturnType(String beanClass, String returnType) {
		Method method = null;
		try {
			Class clazz = Class.forName(beanClass);
			Class returnClazz = Class.forName(returnType);
			Method[] methods = clazz.getDeclaredMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("get") && m.getReturnType().getName().equals(returnType)) {
					method = m;
					break;
				}
			}
		} catch (Exception e) {
			//LOGGER.warn("No method found in " + beanClass + " for " + returnType);
		}
		return method;
	}

	public static Method getAccessorMethodByFieldName(String beanClass, String fieldName) {
		try {
			Class clazz = Class.forName(beanClass);
			return getGetterMethod(clazz, fieldName);
		} catch (Exception e) {
			//LOGGER.warn("No method found in " + beanClass + " for " + fieldName);
		}
		return null;
	}

	public static Method getAccessorMethodByFieldName(Class beanClass, String fieldName) {
		try {
			return getGetterMethod(beanClass, fieldName);
		} catch (Exception e) {
			//LOGGER.warn("No method found in " + beanClass + " for " + fieldName);
		}
		return null;
	}

	public static Method getGetterMethod(Class beanClass, String fieldName) {
		try {
			return beanClass.getMethod("get" + StringUtils.capitalize(fieldName), new Class[] {});
		} catch (Exception e) {
			//LOGGER.warn("No method found in " + beanClass + " for " + fieldName);
		}
		return null;
	}

	public static Method getSetterMethod(Class beanClass, String fieldName) {
		try {
			Method getterMethod = getGetterMethod(beanClass, fieldName);
			return beanClass.getMethod("set" + StringUtils.capitalize(fieldName),
					new Class[] { getterMethod.getReturnType() });
		} catch (Exception e) {
			//LOGGER.warn("No method found in " + beanClass + " for " + fieldName);
		}
		return null;
	}

	public static Class getAccessorMethodReturnType(String beanClass, String fieldName) {
		try {
			Class clazz = Class.forName(beanClass);
			return getGetterMethod(clazz, fieldName).getReturnType();
		} catch (Exception e) {
		}
		return null;
	}

	public static Class getAccessorMethodReturnType(Class beanClass, String fieldName) {
		try {
			return getGetterMethod(beanClass, fieldName).getReturnType();
		} catch (Exception e) {
		}
		return null;
	}

	public static Class getFieldType(String beanClass, String fieldName) {
		try {
			Class clazz = Class.forName(beanClass);
			return clazz.getDeclaredField(fieldName).getType();
		} catch (Exception e) {
		}
		return null;
	}

	public static Class getFieldType(Class beanClass, String fieldName) {
		try {
			return beanClass.getDeclaredField(fieldName).getType();
		} catch (Exception e) {
		}
		return null;
	}

	/*
	 * 
	 * public static Serializable getEntityId(Object entity) { if (entity == null) {
	 * return null; } try { String
	 * idFieldName=getEntityIdFieldName(entity.getClass().getName()); Method method
	 * = entity.getClass().getMethod("get" + StringUtils.capitalize(idFieldName));
	 * return (Serializable) method.invoke(entity, new Object[] {}); } catch
	 * (Exception e) { //LOGGER.info(e.getMessage()); } return null; }
	 */
	public static Class getEntityIdClass(Class entityClass) {
		if (entityClass == null) {
			return null;
		}

		Class entityIdClass = getEntityIdFieldType(entityClass.getName());

		return entityIdClass;
	}

	public static String getEntityIdFieldName(String className) {
		try {
			Method method = (Method) (getMethodsByAnnotation(className, Id.class).values().toArray()[0]);
			return StringUtils.uncapitalize(method.getName().substring("get".length()));
		} catch (Exception e) {

		}
		try {
			Field field = (Field) (getFieldsByAnnotation(className, Id.class).values().toArray()[0]);
			return field.getName();
		} catch (Exception e) {

		}
		return null;
	}

	public static String getEntityIdFieldName(Class clazz) {
		try {
			Method method = (Method) (getMethodsByAnnotation(clazz, Id.class).values().toArray()[0]);
			return StringUtils.uncapitalize(method.getName().substring("get".length()));
		} catch (Exception e) {

		}
		try {
			Field field = (Field) (getFieldsByAnnotation(clazz, Id.class).values().toArray()[0]);
			return field.getName();
		} catch (Exception e) {

		}
		return null;
	}

	public static Field getEntityIdField(String className) {
		try {
			Method method = (Method) (getMethodsByAnnotation(className, Id.class).values().toArray()[0]);
			return getField(className, StringUtils.uncapitalize(method.getName().substring("get".length())));
		} catch (Exception e) {

		}
		try {
			Field field = (Field) (getFieldsByAnnotation(className, Id.class).values().toArray()[0]);
			return field;
		} catch (Exception e) {

		}
		return null;
	}

	public static Field getEntityIdField(Class clazz) {
		try {
			Method method = (Method) (getMethodsByAnnotation(clazz, Id.class).values().toArray()[0]);
			return getField(clazz, StringUtils.uncapitalize(method.getName().substring("get".length())));
		} catch (Exception e) {

		}
		try {
			Field field = (Field) (getFieldsByAnnotation(clazz, Id.class).values().toArray()[0]);
			return field;
		} catch (Exception e) {

		}
		return null;
	}

	public static Class<?> getEntityIdFieldType(String className) {
		try {
			Method method = (Method) (getMethodsByAnnotation(className, Id.class).values().toArray()[0]);
			return method.getReturnType();
		} catch (Exception e) {

		}
		try {
			Field field = (Field) (getFieldsByAnnotation(className, Id.class).values().toArray()[0]);
			return field.getType();
		} catch (Exception e) {

		}
		return null;
	}

	public static Class<?> getEntityIdFieldType(Class clazz) {
		try {
			Method method = (Method) (getMethodsByAnnotation(clazz, Id.class).values().toArray()[0]);
			return method.getReturnType();
		} catch (Exception e) {

		}
		try {
			Field field = (Field) (getFieldsByAnnotation(clazz, Id.class).values().toArray()[0]);
			return field.getType();
		} catch (Exception e) {

		}
		return null;
	}

	/*
	 * public static boolean isIdField(String entityClass, String fieldName) { try{
	 * return getEntityIdFieldName(loadClass(entityClass)).equals(fieldName);
	 * }catch(Exception e){} return false; }
	 * 
	 * public static boolean isIdField(Class entityClass, String fieldName) { try{
	 * return getEntityIdFieldName(entityClass).equals(fieldName); }catch(Exception
	 * e){} return false; }
	 */
	public static Field getField(String className, String fieldName) {
		Class<?> clazz = loadClass(className);
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (Exception e) {
			//LOGGER.warn(e.getMessage());
		}
		return null;
	}

	public static Field getField(Class clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (Exception e) {
			//LOGGER.warn(e.getMessage());
		}
		return null;
	}

	public static Type getFieldGenericType(Class<? extends Object> clazz, String fieldName, int index) {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			ParameterizedType pType = (ParameterizedType) field.getGenericType();
			Type[] types = pType.getActualTypeArguments();
			if (types != null && types.length > index) {
				return (Class) types[index];
			}
		} catch (Exception e) {
			//LOGGER.warn(e.getMessage());
		}
		return null;
	}

	public static List<Type> getFieldGenericTypes(Class<? extends Object> clazz, String fieldName) {
		List<Type> typeList = new ArrayList<Type>();
		try {
			Field field = clazz.getDeclaredField(fieldName);
			ParameterizedType pType = (ParameterizedType) field.getGenericType();
			Type[] types = pType.getActualTypeArguments();
			for (Type type : types) {
				typeList.add(type);
			}
		} catch (Exception e) {
			//LOGGER.warn(e.getMessage());
		}
		return typeList;
	}

	public static Type getMethodGenericType(Class<? extends Object> clazz, String methodName, int index) {
		try {
			Method method = clazz.getDeclaredMethod(methodName);
			ParameterizedType pType = (ParameterizedType) method.getGenericReturnType();
			Type[] types = pType.getActualTypeArguments();
			if (types != null && types.length > index) {
				return (Class) types[index];
			}
		} catch (Exception e) {
			//LOGGER.warn(e.getMessage());
		}
		return null;
	}

	public static List<Type> getMethodGenericTypes(Class<? extends Object> clazz, String methodName) {
		List<Type> typeList = new ArrayList<Type>();
		try {
			Method method = clazz.getDeclaredMethod(methodName);
			ParameterizedType pType = (ParameterizedType) method.getGenericReturnType();
			Type[] types = pType.getActualTypeArguments();
			for (Type type : types) {
				typeList.add(type);
			}
		} catch (Exception e) {
			//LOGGER.warn(e.getMessage());
		}
		return typeList;
	}

	public static Object invokeMethod(Object bean, String name, Object[] values) {
		try {
			Class<?>[] types = new Class[values.length];
			int i = 0;
			for (Object value : values) {
				types[i++] = value.getClass();
			}
			Method method = bean.getClass().getDeclaredMethod(name, types);
			return method.invoke(bean, values);
		} catch (Exception e) {
			// LOGGER.info(e.getMessage());
		}
		return null;
	}

	public static Object invokeUtilMethod(Class utilClass, String name, Class[] paramTypes, Object[] values) {
		try {
			// LOGGER.info(utilClass+", "+name);
			Method method = utilClass.getMethod(name, paramTypes);
			return method.invoke(utilClass, values);
		} catch (Exception e) {
			//LOGGER.warn(e.getMessage() + ", error invoking method " + utilClass + "." + name);
		}
		return null;
	}

	public static boolean hasMethod(Class utilClass, String name, Class[] paramTypes) {
		try {
			return utilClass.getMethod(name, paramTypes) != null;
		} catch (Exception e) {
			//LOGGER.info(e.getMessage() + ", error getting method " + utilClass + "." + name);
		}
		return false;
	}

	public static Method getMethod(Class utilClass, String name, Class[] paramTypes) {
		try {
			// LOGGER.info(utilClass+", "+name);
			return utilClass.getMethod(name, paramTypes);
		} catch (Exception e) {
			//LOGGER.info(e.getMessage() + ", error getting method " + name);
		}
		return null;
	}

	public static Object invokeMethod(Method method, Object object, Object[] values) {
		try {
			return method.invoke(object, values);
		} catch (Exception e) {
			//LOGGER.info(e.getMessage() + " - error invoking method " + method.getName());
		}
		return null;
	}

	public static String getParameterizedString(String text, Object obj) {
		int start = text.indexOf("{");
		int end = text.indexOf("}");
		while (start >= 0 && end >= 0) {
			String property = text.substring(start + 1, end);
			String value = String.valueOf(invokeGet(obj, property));
			// System.out.println("value : "+value);
			text = text.substring(0, start) + value + text.substring(end + 1);
			start = text.indexOf("{");
			end = text.indexOf("}");
		}
		return text;
		/*
		 * var eventAction=ctrl.eventAction;
		 * 
		 * $(ctrl.params).each(function(p,param){ var paramValue=param;
		 * if(param.indexOf("{")>=0 && param.indexOf("}")<=param.length){
		 * paramValue=$(full).attr(param.substring("{".length, param.length-1)); }
		 * eventAction=eventAction.replace("{"+p+"}", paramValue); });
		 */
	}

	public static boolean evaluateToBoolean(String expr, Object item, boolean defaultValue) {
		if (StringUtils.isEmpty(expr)) {
			return defaultValue;
		}
		int start = expr.indexOf("{");
		int end = expr.indexOf("}");
		while (start >= 0 && end >= 0) {
			String property = expr.substring(start + 1, end);
			String value = String.valueOf(invokeGet(item, property));
			// System.out.println("value : "+value);
			expr = expr.substring(0, start) + value + expr.substring(end + 1);
			start = expr.indexOf("{");
			end = expr.indexOf("}");
		}
		if (expr.contains("==")) {
			String[] arr = StringUtils.split(expr, "==");
			if (arr.length == 2) {
				return StringUtils.equalsIgnoreCase(StringUtils.trim(arr[0]), StringUtils.trim(arr[1]));
			} else if (arr.length == 1) {
				try {
					return Boolean.parseBoolean(StringUtils.trim(arr[0]));
				} catch (Exception e) {
					return defaultValue;
				}
			}
		}
		return defaultValue;
	}

	public static String getAttributeFromAccessorMethod(Method method) {
		String methodName = method.getName();
		if (methodName.startsWith("get") || methodName.startsWith("set")) {
			return StringUtils.uncapitalize(methodName.substring("get".length()));
		}
		return null;
	}

	public static boolean isNumericType(Class type) {
		return (type == int.class || type == Integer.class || type == long.class || type == Long.class
				|| type == float.class || type == Float.class || type == double.class || type == Double.class);
	}

	public static boolean isNumericValue(Object value) {
		Class type = value.getClass();
		return (type == int.class || type == Integer.class || type == long.class || type == Long.class
				|| type == float.class || type == Float.class || type == double.class || type == Double.class);
	}

	public static boolean isBooleanType(Class type) {
		return (type == boolean.class || type == Boolean.class);
	}

	public static Object parseToNumericValue(Class type, String value) {
		if (type == int.class || type == Integer.class) {
			return Integer.parseInt(value);
		} else if (type == long.class || type == Long.class) {
			return Long.parseLong(value);
		} else if (type == float.class || type == Float.class) {
			return Float.parseFloat(value);
		} else if (type == double.class || type == Double.class) {
			return Double.parseDouble(value);
		}
		return null;
	}

	public static Object parseToBooleanValue(Class type, String value) {
		if (type == boolean.class || type == Boolean.class) {
			return Boolean.parseBoolean(value);
		}
		return null;
	}

	public static Object parseStringToDataType(String value, Class<?> returnType) {
		// LOGGER.info("parseStringToDataType : "+returnType);
		Object parsedValue = null;

		if (value != null) {

			if (isNumericType(returnType)) {
				if (value.equals("")) {
					value = "0";
				}
				try {
					parsedValue = parseToNumericValue(returnType, value);
				} catch (Exception e) {
				}
			} else if (isBooleanType(returnType)) {
				try {
					parsedValue = parseToBooleanValue(returnType, value);
				} catch (Exception e) {
				}

			} else if (returnType == Date.class) {
				try {
					parsedValue = DateUtils.toDate(value);
				} catch (Exception e) {
				}
			} else {
				parsedValue = value;
			}
		}
		return parsedValue;
	}

	public static String getPluralModelName(String simpleClassName) {
		String pluralName = simpleClassName.concat("s");
		if (simpleClassName.endsWith("y")) {
			pluralName = simpleClassName.substring(0, simpleClassName.length() - 1).concat("ies");
		} else if (simpleClassName.endsWith("s")) {
			pluralName = simpleClassName.concat("es");
		}
		return pluralName;
	}

	public static String formatValue(Object value, Class type) {
		String result = "";
		if (value == null) {
			return result;
		}
		try {
			if (ReflectionUtil.isNumericType(type)) {
				if (type == long.class || type == Long.class || type == int.class || type == Integer.class) {
					//result = INTEGER_NUMBER_FORMAT.format(value);
					result = String.valueOf(value);
				} else if (type == float.class || type == Float.class || type == double.class || type == Double.class) {
					result = DECIMAL_NUMBER_FORMAT.format(value);
				}
			} else if (type == boolean.class || type == Boolean.class) {
				Boolean bool = (Boolean) value;
				result = (bool.booleanValue() ? "Yes" : "No");
			} else if (type == Date.class) {
				result = TARGET_DATE_FORMAT.format((Date) value);
			} else if (type == String.class) {
				result = (String) value;
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return result;
	}
	
	public static String formatValue(Object value, Class type, String format) {
		String result = "";
		if (value == null) {
			return result;
		}
		try {
			if (ReflectionUtil.isNumericType(type)) {
				if (type == long.class || type == Long.class || type == int.class || type == Integer.class) {
					if(StringUtils.isBlank(format)) {
						//result = INTEGER_NUMBER_FORMAT.format(value);
						result = String.valueOf(value);
					}else {
						result = new DecimalFormat(format).format(value);
					}
				} else if (type == float.class || type == Float.class || type == double.class || type == Double.class) {
					if(StringUtils.isBlank(format)) {
						result = DECIMAL_NUMBER_FORMAT.format(value);
					}else {
						result = new DecimalFormat(format).format(value);
					}
				}
			} else if (type == boolean.class || type == Boolean.class) {
				Boolean bool = (Boolean) value;
				result = (bool.booleanValue() ? "Yes" : "No");
			} else if (type == Date.class) {
				if(StringUtils.isBlank(format)) {
					result = TARGET_DATE_FORMAT.format((Date) value);
				}else {
					result = new SimpleDateFormat(format).format(value);
				}
			} else if (type == String.class) {
				result = (String) value;
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return result;
	}

	public static Object parse(String value, Class type) {
		Object result = null;
		if (value == null) {
			return type.cast(null);
		}
		try {
			if (ReflectionUtil.isNumericType(type)) {
				if(StringUtils.isEmpty(value)) {
					value="0";
				}
				if (type == long.class || type == Long.class) {
					result = Long.parseLong(value);
				} else if (type == int.class || type == Integer.class) {
					result = Integer.parseInt(value);
				} else if (type == float.class || type == Float.class) {
					result = Float.parseFloat(value);
				} else if (type == double.class || type == Double.class) {
					result = Double.parseDouble(value);
				}
			} else if (type == boolean.class || type == Boolean.class) {
				if(StringUtils.isEmpty(value)) {
					value="0";
				}
				if (value.equals("1") || value.equalsIgnoreCase("on") || value.equalsIgnoreCase("yes")) {
					result = true;
				} else if (value.equals("0") || value.equalsIgnoreCase("off") || value.equalsIgnoreCase("no") || value.equalsIgnoreCase("")) {
					result = false;
				} else {
					result = Boolean.parseBoolean(value);
				}
			} else if (type == Date.class) {
				result = DateUtils.toDate(value, DateUtils.YYYY_MM_DD);
			} else if (type == String.class) {
				result = value;
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return result;
	}

	public static List<Method> getMethodsByName(Class utilClass, String methodName) {
		List<Method> result = new ArrayList<Method>();
		Method[] methods = utilClass.getMethods();
		for (Method m : methods) {
			if (m.getName().equalsIgnoreCase(methodName)) {
				result.add(m);
			}
		}
		return result;
	}
	
	
	public static Map<String, Method> getGetterMethods(Class entityClass,List<String>excludeAttributeList) {
		Map<String, Method> getMethodMap = new HashMap<String, Method>();
		Method[] methods = null;
		try {
			methods = entityClass.getMethods();
		} catch (Exception e) {
			// LOGGER.info(e.getMessage());
		}

		for (Method method : methods) {
			String name = method.getName();
			if (!name.startsWith("get")) {
				continue;
			}

			name = StringUtils.uncapitalize(name.substring("get".length()));
			if (excludeAttributeList.contains(name)) {
				continue;
			}

			getMethodMap.put(name, method);
		}

		return getMethodMap;
	}
	
	public static Map<String, Method> getSetterMethods(Class entityClass,List<String> excludeAttributeList) {
		Map<String, Method> setMethodMap = new HashMap<String, Method>();
		Method[] methods = null;
		try {
			methods = entityClass.getMethods();
		} catch (Exception e) {
			// LOGGER.info(e.getMessage());
		}

		for (Method method : methods) {
			String name = method.getName();

			if (!name.startsWith("set")) {
				continue;
			}

			name = StringUtils.uncapitalize(name.substring("get".length()));

			if (excludeAttributeList.contains(name)) {
				continue;
			}
			setMethodMap.put(name, method);
		}

		return setMethodMap;
	}
}
