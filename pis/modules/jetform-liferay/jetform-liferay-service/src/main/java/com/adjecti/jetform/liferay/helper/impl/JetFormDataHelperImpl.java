package com.adjecti.jetform.liferay.helper.impl;

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.common.util.ReflectionUtil;
import com.adjecti.common.util.XLSUtils;
import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlElementGroupWrapper;
import com.adjecti.jetform.annotation.HtmlElementWrapper;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.HtmlFormActionWrapper;
import com.adjecti.jetform.annotation.HtmlFormWrapper;
import com.adjecti.jetform.annotation.RelationWrapper;
import com.adjecti.jetform.liferay.helper.JetFormDataHelper;
import com.adjecti.jetform.liferay.model.EntityWorkflow;
import com.adjecti.jetform.liferay.service.EntityWorkflowLocalServiceUtil;
import com.adjecti.jetform.liferay.util.JetFormDataUtil;
import com.adjecti.jetform.liferay.util.JetFormUtil;
import com.adjecti.jetform.model.KeyValue;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourceLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = JetFormDataHelper.class)

public class JetFormDataHelperImpl implements JetFormDataHelper {

	final static Log LOGGER = LogFactoryUtil.getLog(JetFormDataHelperImpl.class.getName());

	@Override
	public String saveForm(Map<String, Object> params, HtmlFormWrapper form) {

		if (!JetFormUtil.chzlcs) {
			return "successfull";
		}
		String namespace = (String) params.get("namespace");

		String formClassName = (String) params.get(namespace + "formClass");
		String mappingField = (String) params.get(namespace + "mappingField");
		Map<String, String[]> dataMap = new HashMap<String, String[]>();
		List<String> childForms = new ArrayList<String>();
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());
		try {
			for (Map.Entry<String, Object> e : params.entrySet()) {
				String key = e.getKey();
				if (StringUtils.equalsIgnoreCase(key, "namespace")) {
					continue;
				}
				/*
				 * if (StringUtils.equalsIgnoreCase(key, namespace + "formClass")) { continue; }
				 */
				if (key.startsWith(namespace)) {

					if (key.startsWith(namespace + "childForm")) {
						LOGGER.info("childForm : " + key);
						childForms.add(String.valueOf(e.getValue()));
					} else {
						key = key.substring(namespace.length());
						dataMap.put(key, new String[] { String.valueOf(e.getValue()) });
					}
				}
			}
		} catch (Exception e) {
			// LOGGER.info(e.getMessage());
		}

		// LOGGER.info("childForms.size() : "+childForms.size());
		String mappingMultiValue = String.valueOf(dataMap.get(mappingField));

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		String message = "";
		long id = 0;

		try {

		} catch (Exception e) {
			jsonObject.put(form.getKeyElement().getName(), String.valueOf(-1));
			jsonObject.put("status", "failure");
			jsonObject.put("message", e.getMessage());
			return jsonObject.toString();
		}
		if (!form.isAssociationEntity()) {
			try {

				/*
				 * if (childForms.size() > 0) { for (String childForm : childForms) { long
				 * childFormPK = saveChildForm(form, params, dataMap, childForm);
				 * HtmlElementWrapper childFormElement = form.getElementByName(childForm);
				 * dataMap.put(childFormElement.getMappingField(), new String[] {
				 * String.valueOf(childFormPK) }); } }
				 */

				if (StringUtils.isNotEmpty(mappingField) && StringUtils.isNotEmpty(mappingMultiValue)) {
					// This will be changed later
					HtmlElementWrapper formFlowKeyElement = form.getFormFlowKeyElement();
					if (formFlowKeyElement == null) {
						throw new Exception("No form flow key element found.");
					}
					id = saveOnetoManyObject(dataMap, entClass, formFlowKeyElement.getName(), mappingField);
				} else {
					if (childForms.size() > 0) {
						id = saveObject(form, params, dataMap, childForms);
					} else {
						id = saveObject(dataMap, entClass, form.getKeyElement().getName());
					}
				}
				if (id > 0) {
					message = "Data saved successfully";
				} else {
					throw new Exception("Data saving failed.");
				}

			} catch (Exception e1) {
				LOGGER.error(e1);
				message = "Data saving failed.";
				id = -1;
			}
			jsonObject.put(form.getKeyElement().getName(), String.valueOf(id));
			jsonObject.put("status", (id > 0 ? "success" : "failure"));
			jsonObject.put("message", message);
		} else {
			long result = 0;
			long assocationCount = dataMap.get(form.getAssociationManyKey())[0].split(",").length;
			try {
				result = saveAssocationObjects(form, dataMap, entClass, form.getKeyElement().getName());
				message = "Data saved successfully.";
				if (result <= 0) {
					message = "Data saving failed.";
				} else if (result < assocationCount) {
					message = result + " out of " + assocationCount + " record(s) are saved.";
				}

			} catch (Exception e) {
				LOGGER.error(e);
				message = "Data saving failed. Error: " + e.getMessage();
			}
			jsonObject.put(form.getKeyElement().getName(), String.valueOf(result));
			jsonObject.put("status", (result > 0 ? "success" : "failure"));
			jsonObject.put("message", message);

		}
		return jsonObject.toJSONString();

	}

	private long saveAssocationObjects(HtmlFormWrapper form, Map<String, String[]> paramMap, Class entityClass,
			String primaryKeyName) throws PortalException {
		boolean isNew = false;
		boolean isAsset = false;

		Object entity = null;
		long primaryKey = 0;

		long result = 0;

		Method entityMethod = null;
		Class<?> utilClass = JetFormUtil.getServiceUtilClass(entityClass);
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());

		try {
			primaryKey = Long.parseLong(paramMap.get(primaryKeyName)[0].trim());
		} catch (Exception e) {
		}

		if (primaryKey == 0) {
			try {
				primaryKey = Long.parseLong(paramMap.get("primaryKey")[0].trim());
			} catch (Exception e) {
			}
		}

		// If primary key>0, then call update for one entity.

		if (primaryKey > 0) {
			return saveObject(paramMap, entClass, form.getKeyElement().getName());
		}

		/*
		 * This is commented on 20-May-2022
		 *
		 * if (primaryKey >= 1) { try { entityMethod =
		 * utilClass.getMethod("get".concat(entityClass.getSimpleName()), long.class);
		 * entity = entityMethod.invoke(utilClass, primaryKey); isNew = false; } catch
		 * (Exception e) { LOGGER.error(e.getMessage()); throw new
		 * PortalException(e.getMessage()); } }
		 * 
		 * if (primaryKey <= 0) { try { // This is commented after implementation of
		 * beforeUpdate method primaryKey =
		 * CounterLocalServiceUtil.increment(entityClass.getName());
		 * 
		 * entityMethod =
		 * utilClass.getMethod("create".concat(entityClass.getSimpleName()), new Class[]
		 * { Long.TYPE }); entity = entityMethod.invoke(utilClass, primaryKey); isNew =
		 * true; } catch (Exception e) { LOGGER.error(e); throw new
		 * PortalException(e.getMessage()); } }
		 *
		 */
		Map<String, Method> setMethodMap = ReflectionUtil.getSetterMethods(entityClass,
				JetFormUtil.excludeAttributeList);

		String manyKeys = paramMap.get(form.getAssociationManyKey())[0];
		if (manyKeys.indexOf('[') != -1) {
			manyKeys = manyKeys.substring(1, manyKeys.length() - 1);
		}
		String[] manyKeysarr = manyKeys.split(",");

		for (String manyKey : manyKeysarr) {
			try {

				Map<String, String[]> tempParamMap = new HashMap<String, String[]>();
				// paramMap.putAll(tempParamMap);
				tempParamMap.putAll(paramMap);
				tempParamMap.replace(form.getAssociationManyKey(), new String[] { manyKey.trim() });

				try {
					primaryKey = CounterLocalServiceUtil.increment(entityClass.getName());
					entityMethod = utilClass.getMethod("create".concat(entityClass.getSimpleName()),
							new Class[] { Long.TYPE });
					isNew = true;
					entity = entityMethod.invoke(utilClass, primaryKey);
				} catch (Exception e) {
					throw new PortalException("Error in creating new entity for " + entityClass.getSimpleName());
				}

				// Calling beforeupdate
				boolean beforeUpdateSuccess = true;
				Method beforeUpdate = null;
				try {

					List<Method> beforeUpdateMethods = ReflectionUtil.getMethodsByName(utilClass,
							"beforeUpdate".concat(entityClass.getSimpleName()));

					if (beforeUpdateMethods != null && beforeUpdateMethods.size() > 0) {
						beforeUpdate = beforeUpdateMethods.get(0);
						if (beforeUpdate != null) {
							beforeUpdateSuccess = (Boolean) beforeUpdate.invoke(utilClass,
									new Object[] { entity, tempParamMap });
						}
					}
				} catch (Exception e) {
					LOGGER.error(e.getMessage() + " - Error invoking beforeUpdate " + entityClass.getSimpleName());
					beforeUpdateSuccess = false;
					if (beforeUpdate != null) {
						LOGGER.error(e);
						if (e instanceof PortalException) {
							throw (PortalException) e;
						} else {
							throw new PortalException(e.getMessage());
						}
					}
				}

				if (!beforeUpdateSuccess) {
					LOGGER.error("beforeUpdateSuccess failure for " + entityClass.getSimpleName());
					throw new PortalException("Error occured before update.");
					// return -1;
				}

				setEntityAttributes(entity, entityClass, setMethodMap, tempParamMap, primaryKeyName);
				setExpandoAttributes(entity, entityClass, primaryKey, tempParamMap);
				setAuditAttributes(entity, entityClass, isNew);

				// This is added after implementation of beforeUpdate method

				/*
				 * Commented on 20-May-2022
				 * 
				 * try { Method getPkMethod = entityClass.getMethod("getPrimaryKey", new Class[]
				 * {}); primaryKey = (long) getPkMethod.invoke(entity, new Object[] {}); if
				 * (primaryKey <= 0) { primaryKey =
				 * CounterLocalServiceUtil.increment(entityClass.getName()); Method setPkMethod
				 * = entityClass.getMethod("setPrimaryKey", new Class[] { long.class });
				 * setPkMethod.invoke(entity, new Object[] { primaryKey }); } } catch (Exception
				 * e) { LOGGER.error(e); throw new
				 * PortalException("Error in generating the identifier during update."); }
				 */

				if (isNew) {
					try {
						entityMethod = entityClass.getMethod("setUuid", String.class);
						String uuid = UUID.randomUUID().toString();
						entityMethod.invoke(entity, uuid);
						isAsset = true;
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}
				}

				try {
					entityMethod = utilClass.getMethod("update".concat(entityClass.getSimpleName()), entityClass);
					entityMethod.invoke(utilClass, entity);
				} catch (Exception e) {
					LOGGER.error(e);
					throw new PortalException("Error in updating " + entityClass.getSimpleName());
				}

				Method afterUpdate = null;
				boolean afterUpdateSuccess = true;

				try {
					afterUpdate = utilClass.getMethod("afterUpdate".concat(entityClass.getSimpleName()),
							new Class[] { entityClass, Map.class });

					afterUpdateSuccess = (Boolean) afterUpdate.invoke(utilClass, new Object[] { entity, tempParamMap });
				} catch (Exception e) {
					if (afterUpdate != null) {
						LOGGER.error(e);
						afterUpdateSuccess = false;
					}
				}

				if (!afterUpdateSuccess) {
					LOGGER.error("afterUpdateSuccess failure");
					throw new PortalException("Error in afterUpdateSuccess for " + entityClass.getSimpleName());
				}
				/*
				 * boolean isPrimaryKeySet=false; try { //After error finding entity by primary
				 * key : " + primaryKey; if (primaryKey >= 1) { Method entityMethod1 =
				 * utilClass.getMethod("get".concat(entityClass.getSimpleName()), long.class);
				 * Object entity1 = entityMethod1.invoke(utilClass, primaryKey);
				 * isPrimaryKeySet=true; } } catch (Exception e) { isPrimaryKeySet=false;
				 * LOGGER.error(e); } if(!isPrimaryKeySet) {
				 * LOGGER.error("isPrimaryKeySet failure"); return -1; }
				 */
				try {
					if (isAsset) {
						updateAsset(entity, entityClass);
					}
				} catch (Exception aasetEx) {
					LOGGER.info(aasetEx.getMessage());
				}

				try {
					if (isNew) {
						updateResourcePermission(primaryKey, entityClass.getName(), tempParamMap);
					}
				} catch (Exception permEx) {
					LOGGER.info(permEx.getMessage());
				}

				// return primaryKey;
				result = result + 1;
			} catch (PortalException pe) {
				LOGGER.error("Key [" + manyKey + "] saving failed for " + entityClass.getSimpleName());
			}
		}

		// Moving to below
		// setEntityAttributes(entity, setMethodMap, paramMap, primaryKeyName);
		return result;

	}

	private long saveOnetoManyObject(Map<String, String[]> paramMap, Class entityClass, String oneMappingField,
			String manyMappingField) {
		boolean isNew = false;
		boolean isAsset = false;
		Object entity = null;
		long oneKey = 0;

		Method entityMethod = null;
		Class<?> utilClass = JetFormUtil.getServiceUtilClass(entityClass);

		try {
			oneKey = Long.parseLong(paramMap.get(oneMappingField)[0].trim());
		} catch (Exception e) {
			// LOGGER.error(e);
		}
		if (oneKey <= 0) {
			return 0;
		}

		String[] manyValues = paramMap.get(manyMappingField);

		if (manyValues == null && manyValues.length <= 0) {
			return 0;
		}

		Method setOneKeyMethod = null;
		Method setManyKeyMethod = null;

		try {
			setOneKeyMethod = entityClass.getMethod("set" + StringUtils.capitalize(oneMappingField), long.class);
			setManyKeyMethod = entityClass.getMethod("set" + StringUtils.capitalize(manyMappingField), long.class);
		} catch (Exception e) {
			// LOGGER.error(e);
			return 0;
		}

		int ctr = 0;
		manyValues = manyValues[0].split(",");
		for (String manyValue : manyValues) {
			try {
				long manyKey = Long.parseLong(manyValue.trim());
				if (manyKey <= 0) {
					throw new Exception("Mapping is 0 or nagative.");
				}

				long primaryKey = CounterLocalServiceUtil.increment(entityClass.getName());
				entityMethod = utilClass.getMethod("create".concat(entityClass.getSimpleName()),
						new Class[] { Long.TYPE });
				entity = entityMethod.invoke(utilClass, primaryKey);
				setOneKeyMethod.invoke(entity, oneKey);
				setManyKeyMethod.invoke(entity, manyKey);

				try {
					entityMethod = entityClass.getMethod("getUuid", String.class);
					entityMethod.invoke(entity, UUID.randomUUID());
				} catch (Exception e) {
					// LOGGER.error(e.getMessage());
				}

				try {
					Method beforeUpdate = utilClass.getMethod("beforeUpdate".concat(entityClass.getSimpleName()),
							entityClass, Map.class);
					if (beforeUpdate != null) {
						beforeUpdate.invoke(utilClass, entity, paramMap);
					}
				} catch (Exception e) {
					LOGGER.error(e.getMessage() + " - Error invoking beforeUpdate.");
				}
				try {

					entityMethod = utilClass.getMethod("update".concat(entityClass.getSimpleName()), entityClass);
					entityMethod.invoke(utilClass, entityClass.cast(entity));

				} catch (Exception e) {
					LOGGER.error(e.getMessage() + ", Error saving saveOnetoManyObject " + entityClass.getSimpleName());
					throw e;
				}

				try {
					Method afterUpdate = utilClass.getMethod("afterUpdate".concat(entityClass.getSimpleName()),
							entityClass, Map.class);
					if (afterUpdate != null) {
						afterUpdate.invoke(utilClass, entity, paramMap);
					}
				} catch (Exception e) {
					LOGGER.error(e.getMessage() + " - Error invoking afterUpdate.");
				}

				ctr++;
			} catch (Exception e) {
				// LOGGER.error(e);
			}
		}

		return ctr;
	}

	@Override
	public long saveObject(Map<String, String[]> paramMap, Class entityClass, String primaryKeyName)
			throws PortalException {
		boolean isNew = false;
		boolean isAsset = false;
		Object entity = null;
		long primaryKey = 0;

		Method entityMethod = null;
		Class<?> utilClass = JetFormUtil.getServiceUtilClass(entityClass);

		try {
			primaryKey = Long.parseLong(paramMap.get(primaryKeyName)[0].trim());
		} catch (Exception e) {
		}

		if (primaryKey == 0) {
			try {
				primaryKey = Long.parseLong(paramMap.get("primaryKey")[0].trim());
			} catch (Exception e) {
			}
		}
		/*
		 * This is commented on 20-May-2022
		 *
		 * if (primaryKey >= 1) { try { entityMethod =
		 * utilClass.getMethod("get".concat(entityClass.getSimpleName()), long.class);
		 * entity = entityMethod.invoke(utilClass, primaryKey); isNew = false; } catch
		 * (Exception e) { LOGGER.error(e.getMessage()); throw new
		 * PortalException(e.getMessage()); } }
		 * 
		 * if (primaryKey <= 0) { try { // This is commented after implementation of
		 * beforeUpdate method primaryKey =
		 * CounterLocalServiceUtil.increment(entityClass.getName());
		 * 
		 * entityMethod =
		 * utilClass.getMethod("create".concat(entityClass.getSimpleName()), new Class[]
		 * { Long.TYPE }); entity = entityMethod.invoke(utilClass, primaryKey); isNew =
		 * true; } catch (Exception e) { LOGGER.error(e); throw new
		 * PortalException(e.getMessage()); } }
		 *
		 */
		try {
			if (primaryKey >= 1) {
				entityMethod = utilClass.getMethod("get".concat(entityClass.getSimpleName()), long.class);
				isNew = false;
			} else {
				primaryKey = CounterLocalServiceUtil.increment(entityClass.getName());
				entityMethod = utilClass.getMethod("create".concat(entityClass.getSimpleName()),
						new Class[] { Long.TYPE });
				isNew = true;
			}
			entity = entityMethod.invoke(utilClass, primaryKey);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new PortalException(e.getMessage());
		}

		Map<String, Method> setMethodMap = ReflectionUtil.getSetterMethods(entityClass,
				JetFormUtil.excludeAttributeList);
		// Moving to below
		// setEntityAttributes(entity, setMethodMap, paramMap, primaryKeyName);

		boolean beforeUpdateSuccess = true;
		Method beforeUpdate = null;
		try {

			List<Method> beforeUpdateMethods = ReflectionUtil.getMethodsByName(utilClass,
					"beforeUpdate".concat(entityClass.getSimpleName()));

			if (beforeUpdateMethods != null && beforeUpdateMethods.size() > 0) {
				beforeUpdate = beforeUpdateMethods.get(0);
				if (beforeUpdate != null) {
					beforeUpdateSuccess = (Boolean) beforeUpdate.invoke(utilClass, new Object[] { entity, paramMap });
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage() + " - Error invoking beforeUpdate" + entityClass.getSimpleName());
			beforeUpdateSuccess = false;
			if (beforeUpdate != null) {
				LOGGER.error(e);
				if (e instanceof PortalException) {
					throw (PortalException) e;
				} else {
					throw new PortalException(e.getMessage());
				}
			}
		}

		if (!beforeUpdateSuccess) {
			LOGGER.error("beforeUpdateSuccess failure due to beforeUpdateSuccess =" + beforeUpdateSuccess);
			throw new PortalException("Error occured before update.");
			// return -1;
		}

		setEntityAttributes(entity, entityClass, setMethodMap, paramMap, primaryKeyName);
		setExpandoAttributes(entity, entityClass, primaryKey, paramMap);
		setAuditAttributes(entity, entityClass, isNew);

		boolean onUpdateSuccess = true;
		// This is added after implementation of beforeUpdate method

		/*
		 * Commented on 20-May-2022
		 * 
		 * try { Method getPkMethod = entityClass.getMethod("getPrimaryKey", new Class[]
		 * {}); primaryKey = (long) getPkMethod.invoke(entity, new Object[] {}); if
		 * (primaryKey <= 0) { primaryKey =
		 * CounterLocalServiceUtil.increment(entityClass.getName()); Method setPkMethod
		 * = entityClass.getMethod("setPrimaryKey", new Class[] { long.class });
		 * setPkMethod.invoke(entity, new Object[] { primaryKey }); } } catch (Exception
		 * e) { LOGGER.error(e); throw new
		 * PortalException("Error in generating the identifier during update."); }
		 */

		if (isNew) {
			try {
				entityMethod = entityClass.getMethod("setUuid", String.class);
				String uuid = UUID.randomUUID().toString();
				entityMethod.invoke(entity, uuid);
				isAsset = true;
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}

		try {
			entityMethod = utilClass.getMethod("update".concat(entityClass.getSimpleName()), entityClass);
			entityMethod.invoke(utilClass, entity);
		} catch (Exception e) {
			onUpdateSuccess = false;
			LOGGER.error(e);
			throw new PortalException("Error in updating " + entityClass.getSimpleName());
		}

		if (!onUpdateSuccess) {
			LOGGER.error("onUpdateSuccess failure");
			throw new PortalException("Error in updating " + entityClass.getSimpleName());
		}

		Method afterUpdate = null;
		try {
			afterUpdate = utilClass.getMethod("afterUpdate".concat(entityClass.getSimpleName()),
					new Class[] { entityClass, Map.class });

		} catch (NoSuchMethodException e) {
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(e);
		}

		boolean afterUpdateSuccess = true;
		if (afterUpdate != null) {
			try {
				afterUpdateSuccess = (Boolean) afterUpdate.invoke(utilClass, new Object[] { entity, paramMap });
			} catch (Exception e) {
				afterUpdateSuccess = false;
				LOGGER.error(e);
			}
		}

		if (!afterUpdateSuccess) {
			LOGGER.error("afterUpdateSuccess failure");
			return -1;
		}
		/*
		 * boolean isPrimaryKeySet=false; try { //After error finding entity by primary
		 * key : " + primaryKey; if (primaryKey >= 1) { Method entityMethod1 =
		 * utilClass.getMethod("get".concat(entityClass.getSimpleName()), long.class);
		 * Object entity1 = entityMethod1.invoke(utilClass, primaryKey);
		 * isPrimaryKeySet=true; } } catch (Exception e) { isPrimaryKeySet=false;
		 * LOGGER.error(e); } if(!isPrimaryKeySet) {
		 * LOGGER.error("isPrimaryKeySet failure"); return -1; }
		 */
		try {
			if (isAsset) {
				updateAsset(entity, entityClass);
			}
		} catch (Exception aasetEx) {
			LOGGER.info(aasetEx.getMessage());
		}

		try {
			if (isNew) {
				updateResourcePermission(primaryKey, entityClass.getName(), paramMap);
			}
		} catch (Exception permEx) {
			LOGGER.info(permEx.getMessage());
		}

		return primaryKey;
	}

	private long saveObject(HtmlFormWrapper form, Map<String, Object> params, Map<String, String[]> paramMap,
			List<String> childForms) throws PortalException {
		boolean isNew = false;
		boolean isAsset = false;
		Object entity = null;
		long primaryKey = 0;

		Method entityMethod = null;

		Class entityClass = FormEntityCache.getFormClass(form.getEntityClass());
		String primaryKeyName = form.getKeyElement().getName();
		Class<?> utilClass = JetFormUtil.getServiceUtilClass(entityClass);

		try {
			primaryKey = Long.parseLong(paramMap.get(primaryKeyName)[0].trim());
		} catch (Exception e) {
		}

		if (primaryKey == 0) {
			try {
				primaryKey = Long.parseLong(paramMap.get("primaryKey")[0].trim());
			} catch (Exception e) {
			}
		}

		try {
			if (primaryKey >= 1) {
				entityMethod = utilClass.getMethod("get".concat(entityClass.getSimpleName()), long.class);
				isNew = false;
			} else {
				primaryKey = CounterLocalServiceUtil.increment(entityClass.getName());
				entityMethod = utilClass.getMethod("create".concat(entityClass.getSimpleName()),
						new Class[] { Long.TYPE });
				isNew = true;
			}
			entity = entityMethod.invoke(utilClass, primaryKey);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new PortalException(e.getMessage());
		}

		Map<String, Method> setMethodMap = ReflectionUtil.getSetterMethods(entityClass,
				JetFormUtil.excludeAttributeList);
		// Moving to below
		// setEntityAttributes(entity, setMethodMap, paramMap, primaryKeyName);

		if (isNew) {
			try {
				entityMethod = entityClass.getMethod("setUuid", String.class);
				String uuid = UUID.randomUUID().toString();
				entityMethod.invoke(entity, uuid);
				isAsset = true;
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}

		boolean beforeUpdateSuccess = true;
		Method beforeUpdate = null;
		try {

			List<Method> beforeUpdateMethods = ReflectionUtil.getMethodsByName(utilClass,
					"beforeUpdate".concat(entityClass.getSimpleName()));

			if (beforeUpdateMethods != null && beforeUpdateMethods.size() > 0) {
				beforeUpdate = beforeUpdateMethods.get(0);
				if (beforeUpdate != null) {
					beforeUpdateSuccess = (Boolean) beforeUpdate.invoke(utilClass, new Object[] { entity, paramMap });
				}
			}
		} catch (Exception e) {
			if (beforeUpdate != null) {
				beforeUpdateSuccess = false;
			}
			LOGGER.error(e.getMessage() + " - Error invoking beforeUpdate" + entityClass.getSimpleName());
		}

		if (!beforeUpdateSuccess) {
			LOGGER.error("beforeUpdateSuccess failure");
			return -1;
		}

		/*
		 * This is added for preserving old values for the objects before calling update
		 * on master object
		 */
		if (childForms.size() > 0) {
			for (String childForm : childForms) {
				long childFormPK = saveChildForm(form, params, paramMap, childForm);
				HtmlElementWrapper childFormElement = form.getElementByName(childForm);
				paramMap.put(childFormElement.getMappingField(), new String[] { String.valueOf(childFormPK) });
			}
		}

		setEntityAttributes(entity, entityClass, setMethodMap, paramMap, primaryKeyName);
		// setExpandoAttributes(entity, entityClass, primaryKey, paramMap);
		setAuditAttributes(entity, entityClass, isNew);

		boolean onUpdateSuccess = true;
		// This is added after implementation of beforeUpdate method
		try {
			Method getPkMethod = JetFormDataUtil.getPKGetMethod(entityClass);
			primaryKey = (long) getPkMethod.invoke(entity, new Object[] {});
			if (primaryKey <= 0) {
				primaryKey = CounterLocalServiceUtil.increment(entityClass.getName());
				Method setPkMethod = getPKSetMethod(entityClass);
				setPkMethod.invoke(entity, new Object[] { primaryKey });
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage() + " - Error invoking get/setPrimaryKey" + entityClass.getSimpleName());
		}

		try {
			entityMethod = utilClass.getMethod("update".concat(entityClass.getSimpleName()), entityClass);
			entityMethod.invoke(utilClass, entity);
		} catch (Exception e) {
			onUpdateSuccess = false;
			LOGGER.error(e);
		}

		if (!onUpdateSuccess) {
			LOGGER.error("onUpdateSuccess failure");
			return -1;
		}

		boolean afterUpdateSuccess = true;
		Method afterUpdate = null;
		try {
			afterUpdate = utilClass.getMethod("afterUpdate".concat(entityClass.getSimpleName()),
					new Class[] { entityClass, Map.class });
			if (afterUpdate != null) {
				afterUpdateSuccess = (Boolean) afterUpdate.invoke(utilClass, new Object[] { entity, paramMap });
			}
		} catch (Exception e) {
			if (afterUpdate != null) {
				afterUpdateSuccess = false;
			}
			LOGGER.error(e.getMessage() + " - Error invoking afterUpdate" + entityClass.getSimpleName());
		}

		if (!afterUpdateSuccess) {
			LOGGER.error("afterUpdateSuccess failure");
			return -1;
		}
		/*
		 * boolean isPrimaryKeySet=false; try { //After error finding entity by primary
		 * key : " + primaryKey; if (primaryKey >= 1) { Method entityMethod1 =
		 * utilClass.getMethod("get".concat(entityClass.getSimpleName()), long.class);
		 * Object entity1 = entityMethod1.invoke(utilClass, primaryKey);
		 * isPrimaryKeySet=true; } } catch (Exception e) { isPrimaryKeySet=false;
		 * LOGGER.error(e); } if(!isPrimaryKeySet) {
		 * LOGGER.error("isPrimaryKeySet failure"); return -1; }
		 */
		try {
			if (isAsset) {
				updateAsset(entity, entityClass);
			}
		} catch (Exception aasetEx) {
			LOGGER.info(aasetEx.getMessage());
		}

		try {
			if (isNew) {
				updateResourcePermission(primaryKey, entityClass.getName(), paramMap);
			}
		} catch (Exception permEx) {
			LOGGER.info(permEx.getMessage());
		}

		return primaryKey;
	}

	private void setEntityAttributes(Object entity, Class entityClass, Map<String, Method> setMethodMap,
			Map<String, String[]> paramMap, String primaryKeyName) {

		for (Map.Entry<String, String[]> paramEntry : paramMap.entrySet()) {
			if (StringUtils.equalsIgnoreCase(paramEntry.getKey(), primaryKeyName)
					|| StringUtils.equalsIgnoreCase(paramEntry.getKey(), "primaryKey")) {
				continue;
			}

			if (StringUtils.startsWith(paramEntry.getKey(), "expando_")) {
				continue;
			}
			String k=paramEntry.getKey();
			Method method = setMethodMap.get(paramEntry.getKey());
			if (method != null) {
				try {
					String value = (paramEntry.getValue() != null && paramEntry.getValue().length >= 1
							? paramEntry.getValue()[0]
							: null);

					if (value != null) {

						Class[] paramType = method.getParameterTypes();
						if (paramType.length > 0) {
							// LOGGER.info(paramEntry.getKey()+" - "+value+" - "+paramType[0]);
							Object obj = ReflectionUtil.parse(value, paramType[0]);
							if (obj != null) {
								method.invoke(entity, ReflectionUtil.parse(value, paramType[0]));
							}
						}
					}

				} catch (Exception e) {
					LOGGER.info(e);
				}
			}
			
		}
	}

	private void setExpandoAttributes(Object entity, Class entityClass, long classPK, Map<String, String[]> paramMap) {

		long companyId = 0;
		int expandoCounter = 0;
		ExpandoBridge expandoBridge = null;

		try {
			companyId = Long.parseLong(paramMap.get("companyId")[0]);
		} catch (Exception e) {
			LOGGER.error("CompanyId is not sent though parameter");
		}

		if (companyId == 0) {
			companyId = CompanyThreadLocal.getCompanyId();
		}

		try {
			expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(companyId, entityClass.getName(), classPK);

			for (Map.Entry<String, String[]> paramEntry : paramMap.entrySet()) {

				if (!StringUtils.startsWith(paramEntry.getKey(), "expando_")) {
					continue;
				}

				String attrName = paramEntry.getKey().substring("expando_".length());
				String attrValue = paramEntry.getValue()[0];
				expandoBridge.setAttribute(attrName, attrValue);
				expandoCounter++;
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}
		if (expandoCounter > 0) {
			try {
				Method expBridge = entityClass.getMethod("getExpandoBridge", new Class[] {});
				expBridge.invoke(entity, expandoBridge);
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
	}

	private void setAuditAttributes(Object entity, Class<?> entityClass, boolean isNew) {

		try {
			if (isNew) {
				ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

				Method entityMethod = entityClass.getMethod("setGroupId", long.class);
				entityMethod.invoke(entity, serviceContext.getScopeGroupId());

				entityMethod = entityClass.getMethod("setCompanyId", long.class);
				entityMethod.invoke(entity, serviceContext.getCompanyId());

				entityMethod = entityClass.getMethod("setUserId", long.class);
				entityMethod.invoke(entity, serviceContext.getUserId());

				entityMethod = entityClass.getMethod("setUserName", String.class);
				entityMethod.invoke(entity, PrincipalThreadLocal.getName());

				entityMethod = entityClass.getMethod("setCreateDate", Date.class);
				entityMethod.invoke(entity, new Date());
			} else {
				Method entityMethod = entityClass.getMethod("setModifiedDate", Date.class);
				entityMethod.invoke(entity, new Date());
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

	}

	private void updateAsset(Object model, Class objectClass) throws PortalException {
		try {
			long classPK = ((Long) (ReflectionUtil.getProperty(model, "primaryKey"))).longValue();
			String uuid = (String) (ReflectionUtil.getProperty(model, "uuid"));
			updateAsset(model, objectClass.getName(), classPK, uuid);

		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
	}

	private void updateAsset(Object model, String className, long classPk, String uuid) throws PortalException {
		if (model == null || StringUtils.isEmpty(className) || classPk == 0) {
			return;
		}
		try {

			ServiceContext context = ServiceContextThreadLocal.getServiceContext();

			User owner = null;
			try {
				owner = UserLocalServiceUtil.getUser(context.getUserId());
			} catch (Exception e) {
			}

			if (owner == null) {
				try {
					owner = UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
				} catch (Exception e) {
				}
			}

			if (owner != null) {
				Company company = CompanyLocalServiceUtil.getCompany(owner.getCompanyId());
				Group companyGroup = company.getGroup();
				String title = (String) ReflectionUtil.getProperty(model, "title");
				if (title == null) {
					title = (String) ReflectionUtil.getProperty(model, "name");
				}
				String description = (String) ReflectionUtil.getProperty(model, "description");
				if (description == null) {
					description = model.getClass().getName();
				}

				AuditedModel auditedModel = (AuditedModel) model;
				AssetEntryLocalServiceUtil.updateEntry(owner.getUserId(), companyGroup.getGroupId(),
						auditedModel.getCreateDate(), auditedModel.getModifiedDate(), className, classPk, uuid, 0, null,
						null, true, false, null, null, null, null, null, title, description, description, null, null, 0,
						0, null);

				Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(FormEntityCache.getFormClass(className));
				indexer.reindex(model);
			}
		} catch (Exception e) {
			LOGGER.info("Asset updatation failed." + e.getMessage());
		}
	}

	private void updateResourcePermission(long classPK, String className, Map<String, String[]> paramMap) {
		long companyId = 0;
		long userId = 0;

		try {
			companyId = Long.parseLong(paramMap.get("companyId")[0]);
		} catch (Exception e) {
			// LOGGER.error("CompanyId is not sent though parameter");
		}

		try {
			userId = Long.parseLong(paramMap.get("userId")[0]);
		} catch (Exception e) {
			// LOGGER.error("UserId is not sent though parameter");
		}

		if (companyId == 0) {
			companyId = CompanyThreadLocal.getCompanyId();
		}

		if (userId == 0) {
			userId = PrincipalThreadLocal.getUserId();
		}
		updateResourcePermission(companyId, 0, userId, className, classPK);
	}

	private void updateResourcePermission(long companyId, long groupId, long userId, String className, long classPK) {
		try {
			ResourceLocalServiceUtil.addResources(companyId, groupId, userId, className, String.valueOf(classPK), false,
					false, false);
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
	}

	private long saveChildForm(HtmlFormWrapper formMain, Map<String, Object> params, Map<String, String[]> dataMap,
			String childFormElementName) {

		if (!JetFormUtil.chzlcs) {
			return -1;
		}
		long classPK = -1;
		HtmlElementWrapper childFormElement = formMain.getElementByName(childFormElementName);
		HtmlFormWrapper childForm = null;
		childForm = childFormElement.getChildForm();

		if (childForm == null) {
			return -1;
		}

		try {
			String[] values = dataMap.get(childFormElementName + "_" + childForm.getKeyElement().getName());
			if (values != null && values.length > 0) {
				classPK = Long.parseLong(values[0]);
			}
		} catch (Exception e) {
		}

		Class entityClass = FormEntityCache.getFormClass(childForm.getEntityClass());
		Map<String, Method> setMethodMap = ReflectionUtil.getSetterMethods(entityClass,
				JetFormUtil.excludeAttributeList);

		Object entity = null;
		if (classPK > 0) {
			entity = JetFormDataUtil.readObject(entityClass, String.valueOf(classPK));
		} else {
			entity = JetFormDataUtil.createNewEntity(entityClass);
			classPK = CounterLocalServiceUtil.increment(entityClass.getName());
			try {
				setMethodMap.get(childForm.getKeyElement().getName()).invoke(entity, classPK);
			} catch (Exception e) {
				LOGGER.info(e);
			}
		}
		Map<String, String[]> childDataMap = new HashMap<String, String[]>();

		for (Map.Entry<String, String[]> data : dataMap.entrySet()) {
			String key = data.getKey();
			if (key.startsWith(childFormElementName + "_")) {
				// LOGGER.info(key.substring((childFormElementName + ".").length())+" -
				// "+data.getValue());
				childDataMap.put(key.substring((childFormElementName + "_").length()), data.getValue());
			}
		}

		setEntityAttributes(entity, entityClass, setMethodMap, childDataMap, childForm.getKeyElement().getName());
		updateEntity(entityClass, entity);

		return classPK;
	}

	private Method getPKSetMethod(Class entityClass) {
		try {
			return entityClass.getMethod("setPrimaryKey", new Class[] { long.class });
		} catch (Exception e) {
			LOGGER.info(e);
		}
		return null;
	}

	private long updateEntity(Class entityClass, Object entity) {
		Class serviceUtilClass = JetFormUtil.getServiceUtilClass(entityClass);
		try {
			Method updateMethod = serviceUtilClass.getMethod("update" + entityClass.getSimpleName(),
					new Class[] { entityClass });
			updateMethod.invoke(serviceUtilClass, entity);

			return JetFormDataUtil.getPrimaryKeyValue(entityClass, entity);
		} catch (Exception e) {
			LOGGER.info(e);
		}
		return -1;
	}

	@Override
	public Map<String, String> importData(String formClass, File file, HtmlFormWrapper form) {
		Map<String, String> results = new HashMap<String, String>();

		Map<String, String> attributeColumnMap = new HashMap<String, String>();
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());
		List<HtmlElementWrapper> elements = form.getElements();
		if (elements != null && !elements.isEmpty()) {
			for (HtmlElementWrapper e : elements) {
				attributeColumnMap.put(e.getLabel(), e.getAttribute());
			}
		}

		List<HtmlElementGroupWrapper> groups = form.getElementGroups();
		if (groups != null && !groups.isEmpty()) {
			for (HtmlElementGroupWrapper g : groups) {
				List<HtmlElementWrapper> groupElements = g.getElements();
				if (groupElements != null && !groupElements.isEmpty()) {
					for (HtmlElementWrapper e : groupElements) {
						attributeColumnMap.put(e.getLabel(), e.getAttribute());
					}
				}
			}
		}
		String[] xlsHeaders = new String[attributeColumnMap.size()];
		attributeColumnMap.keySet().toArray(xlsHeaders);

		int[] sheetIndex = new int[] { 0 };

		List<Map<String, Object>> xlsData = XLSUtils.getColumnData(file.getAbsolutePath(), 0, 0, xlsHeaders,
				sheetIndex);

		Map<String, String[]> rowData = new HashMap<String, String[]>();
		int i = 0;
		for (Map<String, Object> row : xlsData) {
			rowData.clear();
			// Object[] cols = (Object[]) row;

			try {
				for (Map.Entry<String, Object> col : row.entrySet()) {
					String colName = col.getKey();
					String colValue = String.valueOf(col.getValue());
					rowData.put(colName, (new String[] { colValue }));
				}
				saveObject(rowData, entClass, form.getKeyElement().getName());

				results.put(String.valueOf(i), "{\"status\":\"success\"}");
			} catch (Exception e) {
				results.put(String.valueOf(i), "{\"status\":\"fail\",\"error\":\"" + e.getMessage() + "\"}");
			}
		}
		return results;
	}

	@Override
	public Map<String, String> importExcel(String formClass, long fileEntryId, HtmlFormWrapper form) {
		LOGGER.info("Before invoking  importExcel for " + formClass);
		Map<String, String> importResult = null;
		int sheetNo = 0, headerRow = 0;
		int importCtr = 0, failedCtr = 0;
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());

		Map<String, HtmlElementWrapper> columnsMap = new HashMap<String, HtmlElementWrapper>();
		Map<String, String[]> defaultValuesMap = new HashMap<String, String[]>();
		for (HtmlElementWrapper element : form.getElements()) {
			if (!element.isKey() && !element.isHidden()) {
				columnsMap.put(element.getLabel().trim(), element);
			} else if (!StringUtils.isEmpty(element.getValue())) {
				defaultValuesMap.put(element.getName(), new String[] { StringUtils.trim(element.getValue()) });
			}
		}

		Class utilClass = JetFormUtil.getServiceUtilClass(entClass);

		String[] excelColumns = new String[columnsMap.size()];
		columnsMap.keySet().toArray(excelColumns);
		try {
			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
			List result = XLSUtils.getColumnData(fileEntry.getContentStream(), XLSUtils.TYPE_XLSX, 0, 0, excelColumns,
					new int[] { 0 });

			String hr = "";

			int r = 0;

			Map<String, Method> setterMethods = ReflectionUtil.getSetterMethods(entClass,
					JetFormUtil.excludeAttributeList);
			Map<Class, Map<String, Long>> relations = new HashMap<Class, Map<String, Long>>();
			Map<Class, Class> relationUtils = new HashMap<Class, Class>();
			List<Map<String, String[]>> records = new ArrayList<Map<String, String[]>>();
			for (Object o : result) {
				try {
					Map<String, String[]> valuesMap = new HashMap<String, String[]>();
					Object[] values = (Object[]) o;

					for (int i = 0; i < excelColumns.length; i++) {
						String value = String.valueOf(values[i]);
						HtmlElementWrapper element = columnsMap.get(excelColumns[i]);

						RelationWrapper relation = element.getRelation();

						if (relation != null && element.getRelationModelClass() != null) {
							Object relationEntity = getRelationEntityByLabel(relation, value);

							if (relationEntity != null) {
								value = String.valueOf(JetFormDataUtil.getPrimaryKeyValue(
										FormEntityCache.getFormClass(element.getRelationModelClass()), relationEntity));
							}
						}
						valuesMap.put(element.getName(), new String[] { value });
					}
					// Adding detault values set from the form
					valuesMap.putAll(defaultValuesMap);
					records.add(valuesMap);

					LOGGER.info("Total records to import : " + records.size());
				} catch (Throwable e1) {
					LOGGER.error(e1.getMessage());
				}
			}

			Method importMethod = null;
			try {
				LOGGER.info("Before Getting importMethods : " + "import" + entClass.getSimpleName());
				List<Method> importMethods = ReflectionUtil.getMethodsByName(utilClass,
						"import" + entClass.getSimpleName());
				if (importMethods != null && importMethods.size() > 0) {
					importMethod = importMethods.get(0);
				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}

			try {
				if (importMethod != null) {
					LOGGER.info("Before calling importMethods (total records) : " + records.size());
					importResult = (Map<String, String>) importMethod.invoke(utilClass, new Object[] { records });
				} else {
					for (Map<String, String[]> valuesMap : records) {
						long pk = saveObject(valuesMap, entClass, form.getKeyElement().getName());

						if (pk > 0) {
							importCtr++;
						} else {
							failedCtr++;
						}
					}

					importResult = new HashMap<String, String>();
					importResult.put("importCtr", String.valueOf(importCtr));
					importResult.put("failedCtr", String.valueOf(failedCtr));
					importResult.put("totalCtr", String.valueOf(records.size()));
				}
			} catch (Exception e2) {
				LOGGER.error(e2.getMessage());
			}
		} catch (Throwable e) {
			LOGGER.error(e.getMessage());
		}
		return importResult;
	}

	private Object getRelationEntityByLabel(RelationWrapper relation, String labelValue) {
		Class relationClass = FormEntityCache.getFormClass(relation.getModelClass());
		return getUniqueEntityByFieldValue(relationClass, relation.getLabelField(), labelValue);
	}

	private Object getUniqueEntityByFieldValue(Class entityClass, String field, String value) {
		String methodName = "get" + entityClass.getSimpleName().concat("By").concat(StringUtils.capitalize(field));
		try {
			Class relationUtil = JetFormUtil.getServiceUtilClass(entityClass);
			Method method = ReflectionUtil.getMethodsByName(relationUtil, methodName).get(0);
			Object[] paramValues = new Object[] { ReflectionUtil.parseStringToDataType(value, method.getReturnType()) };
			Object entity = ReflectionUtil.invokeMethod(method, relationUtil, paramValues);
			return entity;
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return null;
	}

	@Override
	public String deleteEntity(String className, long id, boolean logical) {
		// LOGGER.info("deleteEntity(" + className + ", " + id + ", " + logical + ")");
		Class entityClass = FormEntityCache.getFormClass(className);
		Class utilClass = JetFormUtil.getServiceUtilClass(entityClass);
		String deleteResult = "Record deleted successfully";
		/* updated by prachi gupta on 14-07-2022 */
		Method deleted = ReflectionUtil.getGetterMethod(entityClass, "deleted");
		if (deleted != null) {
			logical = true;
		}
		/************/
		try {
			Method getEntityMethod = utilClass.getMethod("get" + entityClass.getSimpleName(),
					new Class[] { long.class });
			Object entity = getEntityMethod.invoke(utilClass, new Object[] { id });

			if (!logical) {
				List<Method> beforeDeleteMethods = null;
				try {

					beforeDeleteMethods = ReflectionUtil.getMethodsByName(utilClass,
							"beforeDelete".concat(entityClass.getSimpleName()));
				} catch (Exception e) {
					LOGGER.error(
							e.getMessage() + " - Error finding beforeDeleteMethods in " + entityClass.getSimpleName());
				}

				boolean beforeDeleteResult = true;
				if (beforeDeleteMethods != null && beforeDeleteMethods.size() > 0) {
					Method beforeDelete = beforeDeleteMethods.get(0);
					if (beforeDelete != null) {
						beforeDeleteResult = (Boolean) beforeDelete.invoke(utilClass, new Object[] { entity, logical });
					}
				}
				if (beforeDeleteResult) {
					Method method = utilClass.getMethod("delete" + entityClass.getSimpleName(),
							new Class[] { long.class });
					method.invoke(utilClass, new Object[] { id });
					deleteAsset(entityClass, entity);
				} else {
					deleteResult = "Error: Record deletion failed!";
				}
			} else {

				Method logicalDeleteMethod = entityClass.getMethod("setDeleted", new Class[] { boolean.class });
				logicalDeleteMethod.invoke(entity, new Object[] { true });

				Method updateEntityMethod = utilClass.getMethod("update" + entityClass.getSimpleName(),
						new Class[] { entityClass });
				updateEntityMethod.invoke(utilClass, new Object[] { entity });
			}
		} catch (Exception e) {
			LOGGER.error(e);
			deleteResult = "Error: Record deletion failed. ";
			/*
			 * if(e instanceof PortalException) {
			 * deleteResult=deleteResult+((PortalException)e).getMessage(); }else {
			 * deleteResult=deleteResult+e.getMessage(); }
			 */
			// deleteResult="Record deletion failed. "+ e.getMessage();
		}
		return deleteResult;
	}

	@Override
	public String unDeleteEntity(String className, long id) {

		Class entityClass = FormEntityCache.getFormClass(className);
		Class utilClass = JetFormUtil.getServiceUtilClass(entityClass);
		String activeResult = "Record actived successfully";
		try {
			Method getEntityMethod = utilClass.getMethod("get" + entityClass.getSimpleName(),
					new Class[] { long.class });
			Object entity = getEntityMethod.invoke(utilClass, new Object[] { id });

			Method logicalDeleteMethod = entityClass.getMethod("setDeleted", new Class[] { boolean.class });
			logicalDeleteMethod.invoke(entity, new Object[] { false });

			Method updateEntityMethod = utilClass.getMethod("update" + entityClass.getSimpleName(),
					new Class[] { entityClass });
			updateEntityMethod.invoke(utilClass, new Object[] { entity });
		} catch (Exception e) {
			LOGGER.error(e);
			activeResult = "Error: Record activation failed. ";
		}
		return activeResult;
	}

	private void deleteAsset(Class entityClass, Object entity) {
		try {
			long entityId = ((Long) (ReflectionUtil.getProperty(entity, "primaryKey"))).longValue();
			AssetEntryLocalServiceUtil.deleteEntry(entityClass.getName(), entityId);
			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(entityClass);
			indexer.delete(entity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public JSONArray readObjectsAsJson(Map<String, String> searchFilter, HtmlFormWrapper form) {
		// LOGGER.info("Calling readObjectsAsJson(Map<String, String> searchFilter) : "
		// + searchFilter);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());

		if (!JetFormUtil.chzlcs) {
			return jsonArray;
		}

		try {
			String objectClass = searchFilter.get("objectClass");

			if (form == null) {
				return jsonArray;
			}
			Map<String, Map<String, String>> relationMaps = new HashMap<String, Map<String, String>>();
			Map<String, Map<String, String>> optionMaps = new HashMap<String, Map<String, String>>();
			Map<String, HtmlFormWrapper> childFormMaps = new HashMap<String, HtmlFormWrapper>();
			Map<String, Map<String, Object>> childFormEntityMaps = new HashMap<String, Map<String, Object>>();

			Map<String, List<String>> childFormListFieldMaps = new HashMap<String, List<String>>();
			Map<String, Map<String, Method>> childFormGetterMethodMaps = new HashMap<String, Map<String, Method>>();

			List<HtmlElementWrapper> elements = form.getAllElements();

			for (HtmlElementWrapper element : elements) {

				RelationWrapper relation = element.getRelation();
				if (relation != null && relation.getModelClass() != null) {
					Class relationClass = FormEntityCache.getFormClass(relation.getModelClass());
					List relationList = readObjects(relationClass);
					Method deleteMethod = ReflectionUtil.getAccessorMethodByFieldName(relation.getModelClass(),
							"deleted");
					Method statusMethod = ReflectionUtil.getAccessorMethodByFieldName(relation.getModelClass(),
							"status");
					if (CollectionUtils.isNotEmpty(relationList)) {

						Map<String, String> relationMap = new HashMap<String, String>();
						for (Object object : relationList) {
							if (object == null) {
								continue;
							}

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

							String key = String.valueOf(ReflectionUtil.getProperty(object, relation.getValueField()));
							String value = String.valueOf(ReflectionUtil.getProperty(object, relation.getLabelField()));
							relationMap.put(key, value);
							/*
							 * if(!"designationId,organizationId,subOrganizationId,gradeId,cadreId,tradeId".
							 * contains(element.getName())) { if(key.length()<5 && key.startsWith("35")) {
							 * LOGGER.info("While storing : "+element.getName()+" - "+relation.getValueField
							 * ()+" - "+relation.getLabelField()+", key: "+key+", value: "+value); } }
							 */
						}
						relationMaps.put(element.getName(), relationMap);
					}
				} else if (element.isControlType(ControlType.form)) {
					Class childClass = FormEntityCache.getFormClass(element.getChildForm().getEntityClass());

					childFormMaps.put(element.getName(), element.getChildForm());
					/*
					 * Adding the list fields to Map
					 */
					List<String> listFields = new LinkedList<String>();

					if (StringUtils.isNotBlank(element.getListField())) {
						String fields[] = StringUtils.split(element.getListField(), ",");
						for (String f : fields) {
							listFields.add(StringUtils.trim(f));
						}
					} else {
						for (HtmlElementWrapper cfe : element.getChildForm().getElements()) {
							listFields.add(cfe.getName());
						}
					}

					childFormListFieldMaps.put(element.getName(), listFields);

					/*
					 * Adding the child form entity getter methods to Map
					 */
					Map<String, Method> childFormGetterMethods = ReflectionUtil.getGetterMethods(childClass,
							JetFormUtil.excludeAttributeList);
					childFormGetterMethodMaps.put(element.getName(), childFormGetterMethods);

					List relationList = readObjects(childClass);
					Method method = JetFormDataUtil.getPKGetMethod(childClass);
					Map<String, Object> childFormEntityMap = new HashMap<String, Object>();

					for (Object object : relationList) {
						if (object == null) {
							continue;
						}
						String key = String.valueOf(method.invoke(object));
						childFormEntityMap.put(key, object);
					}
					childFormEntityMaps.put(element.getName(), childFormEntityMap);

					/*
					 * Adding the child form relation elements to Map
					 */

					for (HtmlElementWrapper cfeElement : element.getChildForm().getAllElements()) {
						if (!listFields.contains(cfeElement.getName())) {
							continue;
						}
						RelationWrapper cfeRelation = cfeElement.getRelation();
						if (cfeRelation != null && cfeRelation.isValidModelClass()) {
							Class cfeRelationClass = FormEntityCache.getFormClass(cfeRelation.getModelClass());
							List cfeRelationList = readObjects(cfeRelationClass);
							if (CollectionUtils.isNotEmpty(cfeRelationList)) {
								Method deleteMethod = ReflectionUtil
										.getAccessorMethodByFieldName(cfeRelation.getModelClass(), "deleted");
								Method statusMethod = ReflectionUtil
										.getAccessorMethodByFieldName(cfeRelation.getModelClass(), "status");

								Map<String, String> relationMap = new HashMap<String, String>();
								for (Object object : cfeRelationList) {
									if (object == null) {
										continue;
									}
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

									String key = String
											.valueOf(ReflectionUtil.getProperty(object, cfeRelation.getValueField()));
									String value = String
											.valueOf(ReflectionUtil.getProperty(object, cfeRelation.getLabelField()));
									relationMap.put(key, value);
								}
								relationMaps.put(cfeElement.getName(), relationMap);
							}
						}
					}
				}
				/* updated by prachi on 11-07-2022 */
				else if (CollectionUtils.isNotEmpty(element.getListOptions())) {
					Map<String, String> optionMap = new HashMap<String, String>();
					List<KeyValue> options = element.getListOptions();
					for (KeyValue keyValue : options) {
						if (keyValue == null) {
							continue;
						}
						String key = keyValue.getKey();
						String value = keyValue.getValue();
						optionMap.put(key, value);
					}
					optionMaps.put(element.getName(), optionMap);
				}
			}

			/*
			 * Reading the object list and putting into JSON
			 */

			Map<String, Method> methodsMap = ReflectionUtil.getGetterMethods(entClass,
					JetFormUtil.excludeAttributeList);

			List<?> list = readObjects(entClass, searchFilter);
			boolean liferayCoreEntity = form.getEntityClass().startsWith("com.liferay.portal.kernel.");
			Method expandoMethod = methodsMap.get("expandoBridge");

			if (list != null) {
				for (Object object : list) {

					ExpandoBridge expandoBridge = null;
					long classPK = 0;
					if (expandoMethod != null) {
						try {
							classPK = JetFormDataUtil.getPrimaryKeyValue(entClass, object);
							if (classPK > 0) {
								expandoBridge = (ExpandoBridge) expandoMethod.invoke(object, new Object[] {});
							}
						} catch (Exception exp) {
							LOGGER.warn(exp.getMessage());
						}
					}

					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					for (HtmlElementWrapper element : elements) {

						Object value = null;

						if (!element.getName().startsWith("expando_")) {

							Method method = methodsMap.get(element.getName());
							try {
								value = method.invoke(object, new Object[] {});
							} catch (Exception e1) {
								// LOGGER.info(e1.getMessage());
							}

							if (value == null && element.getName().equalsIgnoreCase("name") && liferayCoreEntity) {
								try {
									value = method.invoke(object, new Object[] { Locale.getDefault() });
								} catch (Exception e1) {
									// LOGGER.info(e1.getMessage());
								}
							}
							RelationWrapper relation = element.getRelation();
							if (value != null && relation != null && relation.isValidModelClass()) {
								String relationValue = "";
								Map<String, String> relationMap = relationMaps.get(element.getName());
								String key = String.valueOf(value);
								if (relationMap != null) {
									relationValue = relationMap.get(key);
								}

								/*
								 * if(!"designationId,organizationId,subOrganizationId,gradeId,cadreId,tradeId".
								 * contains(element.getName())) {
								 * 
								 * if(key.length()<5 && key.startsWith("35")) {
								 * LOGGER.info("While reading : "+element.getName()+" - "+relation.getValueField
								 * ()+" - "+relation.getLabelField()+", key: "+key+", value: "+relationValue); }
								 * }
								 */

								if (element.isThumbnail() && StringUtils.isNotBlank(relationValue)) {
									try {
										long fileEntryId = Long.parseLong(relationValue);
										DLFileEntry file = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
										String url = "/documents/" + file.getRepositoryId() + "/" + file.getFolderId()
												+ "/" + URLEncoder.encode(file.getFileName(), "UTF-8");
										jsonObject.put(element.getName(), StringUtils.trim(url));
										// LOGGER.info("While reading : "+element.getName()+" - url : "+url);
									} catch (Exception e) {
										jsonObject.put(element.getName(), StringPool.BLANK);
									}
								} else {
									jsonObject.put(element.getName(), StringUtils.trim(relationValue));
								}
							} else if (element.isControlType(ControlType.form)) {
								HtmlFormWrapper formChild = childFormMaps.get(element.getName());

								Map<String, Object> childFormEntityMap = childFormEntityMaps.get(element.getName());
								Map<String, Method> childFormGetterMethod = childFormGetterMethodMaps
										.get(element.getName());
								List<String> listFields = childFormListFieldMaps.get(element.getName());

								Method mappingFieldMethod = methodsMap.get(element.getMappingField());
								String mappingFieldValue = String.valueOf(mappingFieldMethod.invoke(object));
								Object mappingObject = childFormEntityMap.get(mappingFieldValue);

								if (mappingObject != null && listFields != null) {
									try {

										for (String key : listFields) {

											Method valueMethod = childFormGetterMethod.get(key);
											try {
												value = valueMethod.invoke(mappingObject);
												if (value != null) {
													HtmlElementWrapper cfe = formChild.getElementByName(key);
													if (cfe != null) {
														if (cfe.isControlType(HtmlElement.ControlType.fileUpload)
																&& cfe.isThumbnail()) {
															try {
																long fileEntryId = Long
																		.parseLong(String.valueOf(value));
																DLFileEntry file = DLFileEntryLocalServiceUtil
																		.getFileEntry(fileEntryId);
																String url = "/documents/" + file.getRepositoryId()
																		+ "/" + file.getFolderId() + "/" + URLEncoder
																				.encode(file.getFileName(), "UTF-8");
																jsonObject.put(key, StringUtils.trim(url));
															} catch (Exception ecfe) {
																jsonObject.put(key,
																		StringUtils.trim(String.valueOf(value)));
															}
														} else {
															jsonObject.put(key,
																	StringUtils.trim(String.valueOf(value)));
														}
													} else {
														// Assign to the form element if does not match
														jsonObject.put(element.getName(),
																StringUtils.trim(String.valueOf(value)));
													}
												}
											} catch (Exception exe) {
												LOGGER.error(exe);
											}
										}
									} catch (Exception e) {
									}
								}

								/*
								 * Populating child for relations
								 */

								if (mappingObject != null && listFields != null) {
									for (HtmlElementWrapper cfeElement : formChild.getAllElements()) {
										if (!listFields.contains(cfeElement.getName())) {
											continue;
										}
										RelationWrapper cfeRelation = cfeElement.getRelation();
										if (cfeRelation != null && cfeRelation.isValidModelClass()) {
											String relationValue = "";
											String key = "";
											Map<String, String> relationMap = relationMaps.get(cfeElement.getName());

											if (relationMap != null) {
												key = String.valueOf(
														ReflectionUtil.invokeGet(mappingObject, cfeElement.getName()));
												relationValue = relationMap.get(key);
											}
											jsonObject.put(cfeElement.getName(), StringUtils.trim(relationValue));
										}
									}
								}
							} else if (value != null && element.isControlType(HtmlElement.ControlType.fileUpload)
									&& element.isThumbnail()) {
								try {
									long fileEntryId = Long.parseLong(String.valueOf(value));
									DLFileEntry file = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
									String url = "/documents/" + file.getRepositoryId() + "/" + file.getFolderId() + "/"
											+ URLEncoder.encode(file.getFileName(), "UTF-8");
									jsonObject.put(element.getName(), StringUtils.trim(url));
								} catch (Exception e) {
									jsonObject.put(element.getName(), StringUtils.trim(String.valueOf(value)));
								}
							} else if (value != null && CollectionUtils.isNotEmpty(element.getListOptions())) {
								/* updated by prachi gupta 0n 11-07-2022 */
								String optionValue = "";
								Map<String, String> optionMap = optionMaps.get(element.getName());
								if (optionMap != null) {
									optionValue = optionMap.get(String.valueOf(value));
								}
								jsonObject.put(element.getName(), StringUtils.trim(optionValue));
								/* update end */
							} else {
								String formattedValue = String.valueOf(value);
								if (method != null && !method.getName().toLowerCase().endsWith("id")) {
									formattedValue = ReflectionUtil.formatValue(value, method.getReturnType(),
											element.getFormat());
								}

								jsonObject.put(element.getName(), StringUtils.trim(formattedValue));
							}
						} else {
							if (expandoBridge != null) {
								String expName = element.getName().substring("expando_".length());
								value = String.valueOf(expandoBridge.getAttribute(expName));
								RelationWrapper relation = element.getRelation();
								if (value != null && relation != null && relation.isValidModelClass()) {
									String relationValue = "";
									Map<String, String> relationMap = relationMaps.get(element.getName());
									String key = String.valueOf(value);
									if (relationMap != null) {
										relationValue = relationMap.get(key);
										value = relationValue;
									} else {
										value = StringPool.BLANK;
									}
								}
							} else {
								value = "";
							}

							jsonObject.put(element.getName(), String.valueOf(value));
						}
					}

					try {
						// List<HtmlFormActionWrapper> actions=form.getActions();
						String actions = "";

						for (HtmlFormActionWrapper action : form.getActions()) {
							String visible = "";
							String enable = "";
							if (!action.getApplyOn().equalsIgnoreCase(HtmlFormAction.ApplyOn.row.name())) {
								continue;
							}

							boolean matched = true;
							String val = StringUtils.trim(jsonObject.getString("deleted"));
							if ("true".equals(val) || "1".equals(val)
									|| "Yes".equals(val) && action.getVisible().isEmpty()) {
								enable = "false";

							}
							for (KeyValue kv : action.getCriterias()) {
								if (StringUtils.isBlank(kv.getKey())) {
									continue;
								}
								String value = StringUtils.trim(jsonObject.getString(kv.getKey()));

								if (!StringUtils.equalsIgnoreCase(value, StringUtils.trim(kv.getValue()))) {
									matched = false;
									break;
								}
							}

							for (KeyValue kv : action.getVisible()) {
								if (StringUtils.isBlank(kv.getKey())) {
									continue;
								}
								String value = StringUtils.trim(jsonObject.getString(kv.getKey()));

								if (!StringUtils.equalsIgnoreCase(value, StringUtils.trim(kv.getValue()))) {
									visible = "false";
									break;
								}
							}
							for (KeyValue kv : action.getEnable()) {
								if (StringUtils.isBlank(kv.getKey())) {
									continue;
								}
								String value = StringUtils.trim(jsonObject.getString(kv.getKey()));

								if (!StringUtils.equalsIgnoreCase(value, StringUtils.trim(kv.getValue()))) {
									enable = "false";
									break;
								}
							}
							if (matched) {
								actions += action.getName() + ":" + visible + ":" + enable + ",";
							}
						}

						jsonObject.put("actions", actions);
					} catch (Exception ex) {
						LOGGER.info(ex);
					}
					;
					//
					jsonArray.put(jsonObject);
				}
			}

		} catch (Exception e) {
			LOGGER.info(e);
		}
		return jsonArray;
	}

	public List<?> readObjects(Class<?> objectClass, Map<String, String> searchFilter) {
		// LOGGER.info("readObjects(Class<?> objectClass, Map<String, String>
		// searchFilter) : " + objectClass+" , "+searchFilter);
		List<?> list = new ArrayList<Object>();
		Class<?> utilClass = JetFormUtil.getServiceUtilClass(objectClass);

		try {
			/*
			 * LOGGER.info("(searchFilter != null && searchFilter.size() > 1) : " +
			 * (searchFilter != null && searchFilter.size() > 1));
			 */
			String modelClassSimpleName = objectClass.getSimpleName();
			if (searchFilter != null && searchFilter.size() > 1) {
				String methodName = "search"
						+ StringUtils.capitalize(ReflectionUtil.getPluralModelName(modelClassSimpleName));
				// methodName+="By"+finderParams;
				Method finderMethod = ReflectionUtil.getMethod(utilClass, methodName, new Class[] { Map.class });
				if (finderMethod != null) {
					return (List) ReflectionUtil.invokeMethod(finderMethod, utilClass, new Object[] { searchFilter });
				} else {
					methodName = "get" + ReflectionUtil.getPluralModelName(modelClassSimpleName);
					finderMethod = ReflectionUtil.getMethod(utilClass, methodName,
							new Class[] { Integer.TYPE, Integer.TYPE });
					if (finderMethod != null) {
						list = (List) ReflectionUtil.invokeMethod(finderMethod, utilClass,
								new Object[] { QueryUtil.ALL_POS, QueryUtil.ALL_POS });
					} else {
						finderMethod = ReflectionUtil.getMethod(utilClass, methodName, new Class[] {});
						list = (List) ReflectionUtil.invokeMethod(finderMethod, utilClass, new Object[] {});
					}
					List result = new ArrayList();
					for (Object o : list) {
						boolean match = true;
						for (Map.Entry<String, String> sf : searchFilter.entrySet()) {
							if (StringUtils.equalsIgnoreCase(sf.getKey(), "objectclass")
									|| StringUtils.equalsIgnoreCase(sf.getKey(), "entityclass")) {
								continue;
							}

							Object objVal = ReflectionUtil.getProperty(o, sf.getKey());
							String propValue = String.valueOf(objVal);

							/*
							 * if(!(("false".equalsIgnoreCase(propValue) &&
							 * (propValue.equalsIgnoreCase("false") || propValue.equals("0"))) ||
							 * ("true".equalsIgnoreCase(propValue) && (propValue.equalsIgnoreCase("true") ||
							 * propValue.equals("1"))))) { match=false; }
							 */

							/* updated by prachi gupta on 14-07-2022 */
							String sfValue = sf.getValue().trim();
							if (sfValue.contains(",")) {
								String[] sfValues = sfValue.split(",");
								boolean matchAny = false;
								for (String sfVal : sfValues) {
									if (StringUtils.equalsIgnoreCase(sfVal, propValue)) {
										if (match) {

											matchAny = true;
										}
									}

								}
								match = matchAny;
							} /***********/
							else if (!StringUtils.equalsIgnoreCase(sf.getValue(), propValue)) {
								match = false;
							}

						}
						if (match) {
							result.add(o);
						}
					}
					return result;
				}

			} else {
				String methodName = "get" + ReflectionUtil.getPluralModelName(modelClassSimpleName);
				Method finderMethod = ReflectionUtil.getMethod(utilClass, methodName,
						new Class[] { Integer.TYPE, Integer.TYPE });
				if (finderMethod != null) {
					list = (List) ReflectionUtil.invokeMethod(finderMethod, utilClass,
							new Object[] { QueryUtil.ALL_POS, QueryUtil.ALL_POS });

				} else {
					finderMethod = ReflectionUtil.getMethod(utilClass, methodName, new Class[] {});
					list = (List) ReflectionUtil.invokeMethod(finderMethod, utilClass, new Object[] {});
				}
				return list;

			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public List<?> readObjects(String objectClass) {
		try {
			Class objectClazz = FormEntityCache.getFormClass(objectClass);
			return readObjects(objectClazz);
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<?> readObjects(Class<?> objectClass) {
		List<?> list = new ArrayList<Object>();

		try {
			Class<?> utilClass = JetFormUtil.getServiceUtilClass(objectClass);
			String methodName = "get" + ReflectionUtil.getPluralModelName(objectClass.getSimpleName());

			Method finderMethod = ReflectionUtil.getMethod(utilClass, methodName,
					new Class[] { Integer.TYPE, Integer.TYPE });
			if (finderMethod != null) {
				list = (List) ReflectionUtil.invokeMethod(finderMethod, utilClass,
						new Object[] { QueryUtil.ALL_POS, QueryUtil.ALL_POS });
			} else {
				finderMethod = ReflectionUtil.getMethod(utilClass, methodName, new Class[] {});
				list = (List) ReflectionUtil.invokeMethod(finderMethod, utilClass, new Object[] {});
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return list;
	}

	@Override
	public Object readObject(String objectClassName, String classPK) {
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

	private Object readObject(Class objectClass, String classPK) {
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

	@Override
	public Map<String, Object> getRelationObjects(Map<String, Object> relationEntities, String baseAttribute,
			Class entityClass, Object model, boolean recursive) {

		if (model == null || entityClass == null) {
			return relationEntities;
		}

		Map<String, Method> relationMethods = ReflectionUtil.getGetterMethods(entityClass,
				JetFormUtil.excludeAttributeList);

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
					Object relationObject = readObject(relationClass, relationPK);
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

	@Override
	public Object findFirst(String objectClass, String attributeName, String attributeValue) {

		LOGGER.info("In findObject(Class objectClass, String attributeName, String attributeValue)");
		if (objectClass == null) {
			return null;
		}
		try {

			List list = findAll(objectClass, attributeName, attributeValue);
			if (list.size() > 0) {
				return list.get(0);
			}

		} catch (Exception e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public List<Object> findAll(String objectClass, String attributeName, String attributeValue) {
		Class objectClazz = FormEntityCache.getFormClass(objectClass);
		List<Object> list = new ArrayList<Object>();
		// LOGGER.info("In
		// findObject("+objectClass+","+attributeName+","+attributeValue+")");
		if (objectClass == null) {
			return list;
		}
		try {

			Class<?> utilClass = JetFormUtil.getServiceUtilClass(objectClazz);
			// LOGGER.info("utilClass.getName() : "+utilClass.getName());
			String methodNameSuffix = objectClazz.getSimpleName().concat("By")
					.concat(StringUtils.capitalize(attributeName));
			// LOGGER.info("methodNameSuffix : "+methodNameSuffix);
			Method[] methods = utilClass.getMethods();
			Method method = null;
			for (Method m : methods) {
				if (m.getName().equals("get".concat(methodNameSuffix))
						|| m.getName().equals("find".concat(methodNameSuffix))) {
					method = m;
					break;
				}
			}

			// LOGGER.info("method "+method);
			Object param = null;
			if (method != null) {
				param = ReflectionUtil.parse(attributeValue, method.getParameterTypes()[0]);
				list = (List) method.invoke(utilClass, param);
				// LOGGER.info("Calling "+method.getName());
			} else {
				// LOGGER.info("Calling readObjects");
				List objects = readObjects(objectClass);
				for (Object o : objects) {
					String prop = String.valueOf(ReflectionUtil.getProperty(o, attributeName));
					if (StringUtils.equals(prop, attributeValue)) {
						list.add(o);
					}
				}
			}

		} catch (Exception e) {
			LOGGER.info(e);
		}
		return list;
	}

	@Override
	public KeyValue getRelationObjectAsKeyValue(String objectClassName, String objectClassPK, String keyField,
			String valueField) {
		Class objectClass = FormEntityCache.getFormClass(objectClassName);
		return getRelationObjectAsKeyValue(objectClass, objectClassPK, keyField, valueField);
	}

	public KeyValue getRelationObjectAsKeyValue(Class objectClass, String objectClassPK, String keyField,
			String valueField) {

		try {
			if (objectClass == null) {
				return null;
			}
			return readObjectAsKeyValue(objectClass, objectClassPK, keyField, valueField);

		} catch (Exception e) {
		}

		return null;

	}

	@Override
	public KeyValue readObjectAsKeyValue(String objectClassName, String objectClassPK, String keyField,
			String valueField) {
		Class objectClass = FormEntityCache.getFormClass(objectClassName);
		return readObjectAsKeyValue(objectClass, objectClassPK, keyField, valueField);
	}

	private KeyValue readObjectAsKeyValue(Class objectClass, String objectClassPK, String keyField, String valueField) {
		KeyValue kv = new KeyValue();
		try {
			Object obj = readObject(objectClass, objectClassPK);
			if (obj == null) {
				return kv;
			}
			kv.setKey(String.valueOf(ReflectionUtil.getProperty(obj, keyField)));
			kv.setValue(String.valueOf(ReflectionUtil.getProperty(obj, valueField)));
		} catch (Exception e) {

		}
		return kv;
	}

	@Override
	public KeyValue getRelationObjectAsKeyValue(String formClassName, String objectClassName, String objectClassPK,
			String keyField, String valueField) {
		Class formClass = FormEntityCache.getFormClass(formClassName);
		Class objectClass = FormEntityCache.getFormClass(objectClassName);

		try {
			if (objectClass == null) {
				return null;
			}

			return readObjectAsKeyValue(objectClass, objectClassPK, keyField, valueField);
		} catch (Exception e) {
		}

		return null;

	}

	@Override
	public List<KeyValue> getListOptions(String entityClass, String searchField, String searchValue, String valueField,
			String labelField) {

		List<KeyValue> result = new ArrayList();

		if (!JetFormUtil.chzlcs) {
			return result;
		}
		try {
			Class entityClazz = FormEntityCache.getFormClass(entityClass);
			Class utilClass = JetFormUtil.getServiceUtilClass(entityClazz);
			String entityClassSimpleName = entityClass.substring(entityClass.lastIndexOf(".") + 1);
			String methodName = "get".concat(ReflectionUtil.getPluralModelName(entityClassSimpleName));
			LOGGER.info("getListOptions - methodName : " + methodName + ", utilClass : " + utilClass);
			List list = (List) ReflectionUtil.invokeUtilMethod(utilClass, methodName,
					new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { QueryUtil.ALL_POS, QueryUtil.ALL_POS });
			/*
			 * commented by prachi gupta 22-12-22 if(list!=null) { Method
			 * searchMethod=ReflectionUtil.getAccessorMethodByFieldName(entityClazz,
			 * searchField); Method
			 * keyMethod=ReflectionUtil.getAccessorMethodByFieldName(entityClazz,
			 * valueField); Method
			 * valueMethod=ReflectionUtil.getAccessorMethodByFieldName(entityClazz,
			 * labelField);
			 * 
			 * if (StringUtils.isNotEmpty(searchField) &&
			 * StringUtils.isNotEmpty(searchValue)) { for (Object o : list) { String v =
			 * String.valueOf(searchMethod.invoke(o)); if (!v.equalsIgnoreCase(searchValue))
			 * { continue; } String key = String.valueOf(keyMethod.invoke(o)); String value
			 * = String.valueOf(valueMethod.invoke(o)); KeyValue kv = new KeyValue(key,
			 * value); result.add(kv); } } else { for (Object o : list) { String key =
			 * String.valueOf(keyMethod.invoke(o)); String value =
			 * String.valueOf(valueMethod.invoke(o)); KeyValue kv = new KeyValue(key,
			 * value); result.add(kv); } } }
			 * 
			 */
			/* updated by prachi gupta 22-12-22 */

			if (list != null) {
				Method deleteMethod = ReflectionUtil.getAccessorMethodByFieldName(entityClazz, "deleted");
				Method statusMethod = ReflectionUtil.getAccessorMethodByFieldName(entityClazz, "status");

				Method searchMethod = ReflectionUtil.getAccessorMethodByFieldName(entityClazz, searchField);
				Method keyMethod = ReflectionUtil.getAccessorMethodByFieldName(entityClazz, valueField);
				Method valueMethod = ReflectionUtil.getAccessorMethodByFieldName(entityClazz, labelField);

				if (StringUtils.isNotEmpty(searchField) && StringUtils.isNotEmpty(searchValue)) {
					for (Object o : list) {

						try {
							/*
							 * This is to restrict deleted entries
							 */
							if (deleteMethod != null) {
								Object deleted = deleteMethod.invoke(o);
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
								Object status = ReflectionUtil.invokeGet(o, "status");

								if (status != null) {
									String strStatus = String.valueOf(status);
									if (!("true".equals(strStatus) || "1".equals(strStatus))) {
										continue;
									}
								}
							}
						} catch (Exception dx) {
						}

						String v = String.valueOf(searchMethod.invoke(o));
						if (!v.equalsIgnoreCase(searchValue)) {
							continue;
						}
						String key = String.valueOf(keyMethod.invoke(o));
						String value = String.valueOf(valueMethod.invoke(o));
						KeyValue kv = new KeyValue(key, value);
						result.add(kv);
					}
				} else {
					for (Object o : list) {

						try {
							/*
							 * This is to restrict deleted entries
							 */
							if (deleteMethod != null) {
								Object deleted = deleteMethod.invoke(o);
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
								Object status = ReflectionUtil.invokeGet(o, "status");

								if (status != null) {
									String strStatus = String.valueOf(status);
									if (!("true".equals(strStatus) || "1".equals(strStatus))) {
										continue;
									}
								}
							}
						} catch (Exception dx) {
						}

						String key = String.valueOf(keyMethod.invoke(o));
						String value = String.valueOf(valueMethod.invoke(o));
						KeyValue kv = new KeyValue(key, value);
						result.add(kv);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public List<KeyValue> getListOptions(Class entityClass, Map<String, String> filter, String valueField,
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

	@Override
	public List<KeyValue> getListOptions(String formClass, String elementName, HtmlFormWrapper form) {
		List<KeyValue> result = new ArrayList();
		try {
			Object[] blankParams = new Object[] {};

			HtmlElementWrapper element = form.getElementByName(elementName);
			RelationWrapper relation = element.getRelation();
			return getListOptions(relation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private List<KeyValue> getListOptions(RelationWrapper relation) {
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

	private List<KeyValue> getListOptions(Class modelClass, String valueField, String labelField) {
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

	@Override
	public long approveEntity(String className, long classPK, long userId, String remark) {
		try {
			// HtmlFormWrapper form=getHtmlForm(className);
			return approveRejectEntity(className, classPK, userId, remark, 1);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return 0;
	}

	@Override
	public long rejectEntity(String className, long classPK, long userId, String remark) {
		try {
			// HtmlFormWrapper form=getHtmlForm(className);
			return approveRejectEntity(className, classPK, userId, remark, -1);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return 0;
	}

	private long approveRejectEntity(String className, long classPK, long userId, String remark, int approveReject) {
		try {

			Class entityClass = FormEntityCache.getFormClass(className);
			Class utilClass = JetFormUtil.getServiceUtilClass(entityClass);

			Method getEntityMethod = utilClass.getMethod("get" + entityClass.getSimpleName(),
					new Class[] { long.class });
			Object entity = getEntityMethod.invoke(utilClass, new Object[] { classPK });

			Method statusMethod = entityClass.getMethod("setStatus", new Class[] { int.class });
			statusMethod.invoke(entity, new Object[] { approveReject });

			Method updateMethod = utilClass.getMethod("update" + entityClass.getSimpleName(),
					new Class[] { entityClass });
			updateMethod.invoke(utilClass, new Object[] { entity });

			User user = UserLocalServiceUtil.getUser(userId);
			EntityWorkflow w = EntityWorkflowLocalServiceUtil
					.createEntityWorkflow(CounterLocalServiceUtil.increment(EntityWorkflow.class.getName()));
			w.setClassName(className);
			w.setClassPK(classPK);
			w.setUserId(userId);
			w.setUserName(user.getFullName());
			w.setCreateDate(new Date());
			w.setRemark(remark);
			w.setStatus(approveReject);
			EntityWorkflowLocalServiceUtil.updateEntityWorkflow(w);
			return w.getEntityWorkflowId();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return 0;
	}

	@Override
	public boolean isUnique(String className, long id, String fieldName, String fieldValue) {
		// LOGGER.info("isUnique (" + className + ", " + id + ", " + fieldName + ", " +
		// fieldValue + ")");
		Class entityClazz = FormEntityCache.getFormClass(className);

		Class utilClass = JetFormUtil.getServiceUtilClass(entityClazz);
		try {

			String idFieldName = StringUtils.uncapitalize(entityClazz.getSimpleName()) + "Id";
			String finder = "get" + ReflectionUtil.getPluralModelName(entityClazz.getSimpleName()) + "By"
					+ StringUtils.capitalize(fieldName);

			Method idMethod = ReflectionUtil.getAccessorMethodByFieldName(entityClazz, idFieldName);
			Method accessorMethod = ReflectionUtil.getAccessorMethodByFieldName(entityClazz, fieldName);

			Method finderMethod = null;
			List finderResult = null;
			try {
				finderMethod = utilClass.getMethod(finder, new Class[] { accessorMethod.getReturnType() });
				finderResult = (List) finderMethod.invoke(utilClass,
						ReflectionUtil.parse(fieldValue, accessorMethod.getReturnType()));
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}

			if (finderMethod == null) {
				try {
					finder = "get" + ReflectionUtil.getPluralModelName(entityClazz.getSimpleName());
					finderMethod = utilClass.getMethod(finder, new Class[] { int.class, int.class });
					finderResult = (List) finderMethod.invoke(utilClass, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
				}
			}

			if (finderResult == null || finderResult.size() == 0) {
				return true;
			}

			boolean unique = true;
			Class[] blankParam = new Class[] {};
			for (Object o : finderResult) {
				Long idValue = (Long) idMethod.invoke(o);
				String matchFieldValue = String.valueOf(accessorMethod.invoke(o));

				if (StringUtils.equalsIgnoreCase(StringUtils.trim(fieldValue), StringUtils.trim(matchFieldValue))
						&& idValue.longValue() != id) {
					unique = false;
					break;
				}
			}

			return unique;
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return false;
	}

}
