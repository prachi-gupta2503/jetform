package com.adjecti.jetform.annotation;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.liferay.portal.kernel.json.JSON;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;

public class RelationWrapper implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER= Logger.getLogger(RelationWrapper.class.getName());
	
	private String type;
	//private String modelClass;
	private String modelClass;
	private String valueField;
	private String labelField;
	private String mappingClass;
	private String mappingField;
	boolean lazyLoad=true;
	Map<String, String> filter=new HashMap<String, String>();
	
	public RelationWrapper() {
		super();
	}
	
	public RelationWrapper(Relation relation) {
		super();
			
		if(!isNon(relation)) {
			setType(relation.type().name());
			
			setModelClass(relation.modelClass().getName());
			if(StringUtils.isEmpty(relation.valueField())) {
				setValueField(getIdentityOrNameField(relation.modelClass(),"id"));
			}else {
				setValueField(relation.valueField());
			}
			
			if(StringUtils.isEmpty(relation.labelField())) {
				setLabelField(getIdentityOrNameField(relation.modelClass(),"name"));
			}else {
				setLabelField(relation.labelField());
			}
			setMappingClass(relation.mappingClass().getName());
			setLazyLoad(relation.lazyLoad());
			setMappingField(relation.mappingField());
			setFilter(relation.filter());
		}
	}
	
	public RelationWrapper(Class formEntityClazz, String relationAttributeName) {
		super();
		String formEntityClass=formEntityClazz.getName();
		setType(Relation.RelationType.One.name());
		String relationModelName=relationAttributeName.substring(0,relationAttributeName.length()-2);
		if(relationModelName.toLowerCase().equals("section")) {
			relationModelName="organization";
		}else if(relationModelName.toLowerCase().equals("maincategory")) {
			relationModelName="category";
		}
		String strRelationClass=formEntityClass.substring(0, formEntityClass.lastIndexOf(".")+1).concat(StringUtils.capitalize(relationModelName));
		
		Class relationClass = null;
		try {
			//LOGGER.info("Loading relation class - "+strRelationClass);
			relationClass = Class.forName(strRelationClass);
		} catch (ClassNotFoundException e) {
			//LOGGER.info("Not found in default class loader - "+strRelationClass);
			try {
				relationClass=Class.forName(strRelationClass, true, formEntityClazz.getClassLoader());
			} catch (ClassNotFoundException e1) {
				//LOGGER.info("Not found relation - "+strRelationClass);
			}
		} catch (NullPointerException e) {
			//LOGGER.info("Null relation class - "+strRelationClass);
		}
		
		setModelClass(strRelationClass);
		//if(StringUtils.isEmpty(relation.valueField())) {
		setValueField(relationAttributeName);
		setLabelField(StringUtils.uncapitalize(relationModelName).concat("Name"));
		
		//setMappingClass(relation.mappingClass());
		setLazyLoad(true);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModelClass() {
		return modelClass;
	}

	public void setModelClass(String modelClass) {
		this.modelClass = modelClass;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getLabelField() {
		return labelField;
	}

	public void setLabelField(String labelField) {
		this.labelField = labelField;
	}

	public String getMappingClass() {
		return mappingClass;
	}

	public void setMappingClass(String mappingClass) {
		this.mappingClass = mappingClass;
	}

	public String getMappingField() {
		return mappingField;
	}

	public void setMappingField(String mappingField) {
		this.mappingField = mappingField;
	}

	public boolean isLazyLoad() {
		return lazyLoad;
	}

	public void setLazyLoad(boolean lazyLoad) {
		this.lazyLoad = lazyLoad;
	}
	
	public Map<String, String> getFilter() {
		return filter;
	}

	@JsonSetter
	public void setFilter(Map<String, String> filter) {
		this.filter = filter;
	}
	
	
	public void setFilter(String[] arrFilter) {
		if(arrFilter!=null) {
			for(String strFilter:arrFilter) {
				if(strFilter==null || strFilter.trim().equals("")) {
					continue;
				}
				String[] keyVal=strFilter.split(":");
				if(keyVal!=null && keyVal.length>1) {
					filter.put(keyVal[0].trim(), keyVal[1].trim());
				}
			}
		}
	}

	@JSON(include=false)
	public boolean isValidModelClass() {
		if(!(modelClass==null || modelClass.equals(Object.class.getName()))){ 
			return true;
		}
		return false;
	}
	@JSON(include=false)
	public boolean isValidMappingClass() {
		if(!(mappingClass==null || mappingClass.equals(Object.class.getName()))){ 
			return true;
		}
		return false;
	}
	
	@JSON(include=false)
	public static boolean isNon(Relation relation) {
		if(relation.modelClass().getName().equals(Object.class.getName())){ 
			return true;
		}
		return false;
	}
	@JSON(include=false)
	public boolean isNon() {
		if((modelClass==null || modelClass.equals(Object.class.getName()))){ 
			return true;
		}
		return false;
	}
	
	private String getIdentityOrNameField(Class<?> modelClass, String idOrName) {
		try {
			modelClass.getMethod("get".concat(StringUtils.capitalize(idOrName)));
			return idOrName;
		}catch(Exception e) {
			//LOGGER.info(e.getMessage());
			try {
				String fieldName=modelClass.getSimpleName().concat(StringUtils.capitalize(idOrName));
				modelClass.getMethod("get".concat(fieldName));
				return StringUtils.uncapitalize(fieldName);
			}catch(Exception e1) {
				//LOGGER.info(e1.getMessage());
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "RelationWrapper [type=" + type + ", modelClass=" + modelClass + ", valueField=" + valueField
				+ ", labelField=" + labelField + ", mappingClass=" + mappingClass + ", lazyLoad=" + lazyLoad + "]";
	}
}
