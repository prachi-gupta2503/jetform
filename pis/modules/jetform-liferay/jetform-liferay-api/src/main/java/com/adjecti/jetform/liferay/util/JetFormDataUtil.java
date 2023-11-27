package com.adjecti.jetform.liferay.util;

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.common.util.ReflectionUtil;
import com.adjecti.jetform.annotation.HtmlFormWrapper;
import com.adjecti.jetform.annotation.RelationWrapper;
import com.adjecti.jetform.model.KeyValue;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public class JetFormDataUtil {

	final static Log LOGGER = LogFactoryUtil.getLog(JetFormDataUtil.class.getName());

	public static Object createNewEntity(Class entityClass) {
		Class<?> utilClass =JetFormUtil.getServiceUtilClass(entityClass);
		try {
			String methodName = "create".concat(entityClass.getSimpleName());
			Method method = utilClass.getMethod(methodName, new Class[] { Long.TYPE });
			if (method == null) {
				throw new Exception("No method found with name [" + methodName + "]");
			}
			return method.invoke(utilClass, new Object[] { 0l });
		} catch (Exception e) {
			LOGGER.error("New entity can not be created for " + entityClass + ". Reason: " + e.getMessage());
		}
		return null;
	}
	
	public static Object getEntity(HtmlFormWrapper form, String formClassPK) {
		Object model=null;
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());
		
		if (StringUtils.isNotBlank(formClassPK) && !formClassPK.trim().equals("0") && !formClassPK.trim().equals("-1")
				&& !formClassPK.trim().equals("null")) {
			model = readObject(entClass, formClassPK);
			
		}
		return model;
	
	}
	
	public static Object readObject(Class objectClass, String classPK) {
		Object result = null;
		if (objectClass == null || classPK == null || StringUtils.equalsIgnoreCase("null", classPK)
				|| StringUtils.isEmpty(classPK) || StringUtils.equalsIgnoreCase("0", classPK)) {
			return result;
		}
		try {

			Class<?> utilClass = JetFormUtil.getServiceUtilClass(objectClass);
			String methodName = "get".concat(objectClass.getSimpleName());
			Method method = utilClass.getMethod(methodName, new Class[] { Long.TYPE });
			if (method == null) {
				throw new Exception("No method found with name [" + methodName + "]");
			}
			result = method.invoke(utilClass, Long.parseLong(classPK));

		} catch (Exception e) {
			LOGGER.info(e);
		}
		return result;
	}
	

	public static Map<String, Object> getRelationObjects(Map<String, Object> relationEntities, String baseAttribute,
			Class entityClass, Object model, boolean recursive) {

		if (model == null || entityClass == null) {
			return relationEntities;
		}

		Map<String, Method> relationMethods = ReflectionUtil.getGetterMethods(entityClass,JetFormUtil.excludeAttributeList);

		String packageName = entityClass.getPackage().getName();

		if (relationEntities == null) {
			relationEntities = new HashMap<String, Object>();
		}

		for (Map.Entry<String, Method> entry : relationMethods.entrySet()) {
			try {
				if (!entry.getKey().toLowerCase().endsWith("id")) {
					continue;
				}
				Method method = entry.getValue();

				if (method.getParameterCount() > 0) {
					continue;
				}
				// LOGGER.info("method.getName() : "+method.getName());
				// LOGGER.info("model.toString() : "+model.toString());
				String relationPK = String.valueOf(method.invoke(model, new Object[] {}));

				// To get the class simple name after removing "id"
				String simpleClassName = entry.getKey().substring(0, entry.getKey().length() - ("id".length()));
				String fullClassName = packageName.concat(".").concat(StringUtils.capitalize(simpleClassName));
				Class relationClass = FormEntityCache.getFormClass(fullClassName);
				if (relationClass != null) {
					Object relationObject = JetFormDataUtil.readObject(relationClass, relationPK);
					if (relationObject != null) {
						String relationKey = simpleClassName;
						if (StringUtils.isNotEmpty(baseAttribute)) {
							relationKey = baseAttribute.concat(".").concat(relationKey);
						}

						relationEntities.put(relationKey, relationObject);
						/*
						 * if(recursive) { getRelationObjects(relationEntities, relationKey,
						 * relationClass, relationObject, true); }
						 */
					}
				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}
		return relationEntities;
	}
	
	public  static List<KeyValue> getListOptions(RelationWrapper relation) {
		List<KeyValue> result = new ArrayList();
		Class relationClass = FormEntityCache.getFormClass(relation.getModelClass());
		try {
			if (relation.getFilter().size() == 0) {
				result = getListOptions(relationClass, relation.getValueField(), relation.getLabelField());
			} else {
				result = getListOptions(relationClass, relation.getFilter(), relation.getValueField(),
						relation.getLabelField());
			}
		} catch (Exception e) {
			// LOGGER.info(e);
		}
		return result;
	}
	
	public static List<KeyValue> getListOptions(Class entityClass, Map<String, String> filter, String valueField,
			String labelField) {
		List<KeyValue> result = new ArrayList();
		try {
			Class utilClass = JetFormUtil.getServiceUtilClass(entityClass);
			String methodName = "get".concat(ReflectionUtil.getPluralModelName(entityClass.getSimpleName()));

			List list = (List) ReflectionUtil.invokeUtilMethod(utilClass, methodName,
					new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { QueryUtil.ALL_POS, QueryUtil.ALL_POS });
			Map<String, Method> methods = new HashMap<String, Method>();
			for (String key : filter.keySet()) {
				methods.put(key, ReflectionUtil.getGetterMethod(entityClass, key));
			}

			Method keyMethod = ReflectionUtil.getAccessorMethodByFieldName(entityClass, valueField);
			Method valueMethod = ReflectionUtil.getAccessorMethodByFieldName(entityClass, labelField);

			Object[] blankParam = new Object[] {};
			if (filter != null && filter.size() > 0) {

				for (Object o : list) {
					boolean matched = true;
					for (Map.Entry<String, Method> mEntry : methods.entrySet()) {
						Method method = mEntry.getValue();
						if (method != null) {
							String attrValue = String.valueOf(method.invoke(o));
							String searchValue = filter.get(mEntry.getKey());
							if (!attrValue.equalsIgnoreCase(searchValue)) {
								matched = false;
								break;
							}
						}
					}
					if (!matched) {
						continue;
					}
					String key = String.valueOf(keyMethod.invoke(o));
					String value = String.valueOf(valueMethod.invoke(o));
					KeyValue kv = new KeyValue(key, value);
					result.add(kv);
				}
			} else {
				for (Object o : list) {
					String key = String.valueOf(keyMethod.invoke(o));
					String value = String.valueOf(valueMethod.invoke(o));
					KeyValue kv = new KeyValue(key, value);
					result.add(kv);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	
	public static List<KeyValue>  getListOptions(Class modelClass, String valueField, String labelField) {
		List<KeyValue> result = new ArrayList();
		try {

			Class<?> utilClass = JetFormUtil.getServiceUtilClass(modelClass);

			String methodName = "get".concat(ReflectionUtil.getPluralModelName(modelClass.getSimpleName()));

			List list = new ArrayList();
			Method finderMethod = ReflectionUtil.getMethod(utilClass, methodName,
					new Class[] { Integer.TYPE, Integer.TYPE });
			if (finderMethod != null) {
				list = (List) ReflectionUtil.invokeMethod(finderMethod, utilClass,
						new Object[] { QueryUtil.ALL_POS, QueryUtil.ALL_POS });
			} else {
				finderMethod = ReflectionUtil.getMethod(utilClass, methodName, new Class[] {});
				list = (List) ReflectionUtil.invokeMethod(finderMethod, utilClass, new Object[] {});
			}

			if (!CollectionUtils.isEmpty(list)) {

				Method deleteMethod = ReflectionUtil.getAccessorMethodByFieldName(modelClass, "deleted");
				Method statusMethod = ReflectionUtil.getAccessorMethodByFieldName(modelClass, "status");

				Method keyMethod = ReflectionUtil.getAccessorMethodByFieldName(modelClass, valueField);
				Method valueMethod = ReflectionUtil.getAccessorMethodByFieldName(modelClass, labelField);
				Method idMethod = ReflectionUtil.getAccessorMethodByFieldName(modelClass, "id");
				Method nameMethod = ReflectionUtil.getAccessorMethodByFieldName(modelClass, "name");
				Method nameEnMethod = ReflectionUtil.getAccessorMethodByFieldName(modelClass, "name_En");

				for (Object object : list) {

					try {
						/*
						 * This is to restrict deleted entries
						 */
						if (deleteMethod != null) {
							Object deleted = deleteMethod.invoke(object);
							if (deleted != null) {
								String strDeleted = String.valueOf(deleted);
								if ("true".equals(strDeleted) || "1".equals(strDeleted)) {
									continue;
								}
							}
						}

					} catch (Exception dx) {
					}

					try {
						/*
						 * This is to restrict un-approved entries
						 */
						if (statusMethod != null) {
							Object status = ReflectionUtil.invokeGet(object, "status");

							if (status != null) {
								String strStatus = String.valueOf(status);
								if (!("true".equals(strStatus) || "1".equals(strStatus))) {
									continue;
								}
							}
						}
					} catch (Exception dx) {
					}

					String key = String.valueOf(keyMethod.invoke(object));

					if (StringUtils.isEmpty(key) && !valueField.equals("id")) {
						key = String.valueOf(idMethod.invoke(object));
					}
					String value = String.valueOf(valueMethod.invoke(object));
					if ((value == null || value.equals("") || value.equals("null")) && !labelField.equals("name")) {
						value = String.valueOf(nameMethod.invoke(object));
					}

					// This is for multi-language name fields
					if ((value == null || value.equals("")) && labelField.equals("name")) {
						value = String.valueOf(nameEnMethod.invoke(object));
					}

					KeyValue kv = new KeyValue(key, value);
					result.add(kv);
				}
			}

		} catch (Exception e) {
			// LOGGER.info(e.getMessage());
		}
		return result;
	}
	
	public static long getPrimaryKeyValue(Class entityClass, Object entity) {
		try {
			Method pkMethod = getPKGetMethod(entityClass);
			return (long) (pkMethod.invoke(entity, new Object[] {}));
		} catch (Exception e) {
			LOGGER.info(e);
		}
		return -1;
	}

	public static Method getPKGetMethod(Class entityClass) {
		try {
			return entityClass.getMethod("getPrimaryKey", new Class[] {});
		} catch (Exception e) {
			LOGGER.info(e);
		}
		return null;
	}
	
	public static Object readObject(String objectClassName, String classPK) {
		if (objectClassName == null || classPK == null || StringUtils.equalsIgnoreCase("null", classPK)
				|| StringUtils.isEmpty(classPK) || StringUtils.equalsIgnoreCase("0", classPK)) {
			return null;
		}
		try {
			Class objectClass = FormEntityCache.getFormClass(objectClassName);
			return readObject(objectClass, classPK);
		} catch (Exception e) {
		}
		return null;
	}

	


}
