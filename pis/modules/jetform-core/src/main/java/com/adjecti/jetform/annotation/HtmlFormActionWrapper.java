package com.adjecti.jetform.annotation;

import com.adjecti.common.util.AnnotationUtil;
import com.adjecti.common.util.ReflectionUtil;
import com.adjecti.jetform.model.KeyValue;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class HtmlFormActionWrapper implements Serializable{
	final static Log LOGGER = LogFactoryUtil.getLog(HtmlFormActionWrapper.class.getName());
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT="default";
	private String name;
	private String action;
	private String title;
	private String label;
	private String controlType;
	private String applyOn;
	private String cssClass;
	private List<KeyValue> criterias=new ArrayList<KeyValue>();
	private List<KeyValue> visible=new ArrayList<KeyValue>();
	private List<KeyValue> enable=new ArrayList<KeyValue>();
	
	public HtmlFormActionWrapper() {
		super();
	}
	
	public HtmlFormActionWrapper(String name, String action, String label, String controlType, String applyOn) {
		super();
		this.name = name;
		this.action = (StringUtils.isEmpty(action)?DEFAULT:action);
		this.label=(StringUtils.isEmpty(label)?DEFAULT:label);
		this.controlType=(StringUtils.isEmpty(controlType)?"button":controlType);
		this.applyOn=(StringUtils.isEmpty(applyOn)?"table":applyOn);
		setTitle(AnnotationUtil.getItemLabel(name));
	}

	public HtmlFormActionWrapper(HtmlFormAction action) {
		this(action.name(), action.action(), action.label(), action.controlType(), action.applyOn());
		this.cssClass=action.cssClass();
		setCriterias(action.criterias());
		setVisible(action.visible());
		setEnable(action.enable());
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getControlType() {
		return controlType;
	}

	public void setType(String controlType) {
		this.controlType = controlType;
	}

	public String getApplyOn() {
		return applyOn;
	}

	public void setApplyOn(String applyOn) {
		this.applyOn = applyOn;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public List<KeyValue> getCriterias() {
		return criterias;
	}

	@JsonSetter
	public void setCriterias(List<KeyValue> criterias) {
		this.criterias = criterias;
	}
	
	public void setCriterias(String[] criteriasArray) {
		if(criteriasArray==null || criteriasArray.length==0) {
			return;
		}
		for(String strCriteria:criteriasArray) {
			String[] parts=strCriteria.split(":");
			if(parts==null ||  parts.length<2) {
				continue;
			}
			KeyValue crit=new KeyValue();
			crit.setKey(parts[0].trim());
			crit.setValue(parts[1].trim());
			this.criterias.add(crit);
		}
	}

	public void addCriteria(String criteria) {
		if(criteria==null || criteria.isEmpty()) {
			return;
		}
		
		
		String[] parts=criteria.split(":");
		if(parts==null ||  parts.length<2) {
			return;
		}
		KeyValue crit=new KeyValue();
		crit.setKey(parts[0].trim());
		crit.setValue(parts[1].trim());
		this.criterias.add(crit);
	}
	
	public void addCriteria(KeyValue criteria) {
		this.criterias.add(criteria);
	}
	
	public KeyValue getCriteria(String field) {
		KeyValue criteria=null;
		for(KeyValue kv:criterias) {
			if (kv.getKey().equalsIgnoreCase(field)) {
				criteria=kv;
				break;
			}
		}
		return criteria;
	}
	
	public String getCriteriaValue(String field) {
		KeyValue criteria=null;
		for(KeyValue kv:criterias) {
			if (kv.getKey().equalsIgnoreCase(field)) {
				criteria=kv;
				break;
			}
		}
		return criteria!=null?criteria.getValue():null;
	}
	
	
	public List<KeyValue> getVisible() {
		return visible;
	}
	@JsonSetter
	public void setVisible(List<KeyValue> visible) {
		this.visible = visible;
	}
	
	
	public void setVisible(String[] visibleArray) {
		if(visibleArray==null || visibleArray.length==0) {
			return;
		}
		for(String strVisible:visibleArray) {
			String[] parts=strVisible.split(":");
			if(parts==null ||  parts.length<2) {
				continue;
			}
			KeyValue vis=new KeyValue();
			vis.setKey(parts[0].trim());
			vis.setValue(parts[1].trim());
			this.visible.add(vis);
		}
	}

	public void addVisible(String visible) {
		if(visible==null || visible.isEmpty()) {
			return;
		}
		
		
		String[] parts=visible.split(":");
		if(parts==null ||  parts.length<2) {
			return;
		}
		KeyValue vis=new KeyValue();
		vis.setKey(parts[0].trim());
		vis.setValue(parts[1].trim());
		this.visible.add(vis);
	}
	
	public void addVisible(KeyValue visible) {
		this.visible.add(visible);
	}
	
	public KeyValue getVisible(String field) {
		KeyValue vis=null;
		for(KeyValue kv:visible) {
			if (kv.getKey().equalsIgnoreCase(field)) {
				vis=kv;
				break;
			}
		}
		return vis;
	}
	
	public String getVisibleValue(String field) {
		KeyValue vis=null;
		for(KeyValue kv:visible) {
			if (kv.getKey().equalsIgnoreCase(field)) {
				vis=kv;
				break;
			}
		}
		return vis!=null?vis.getValue():null;
	}
	
	public List<KeyValue> getEnable() {
		return enable;
	}

	@JsonSetter
	public void setEnable(List<KeyValue> enable) {
		this.enable = enable;
	}
	
	
	public void setEnable(String[] enableArray) {
		if(enableArray==null || enableArray.length==0) {
			return;
		}
		for(String strEnable:enableArray) {
			String[] parts=strEnable.split(":");
			if(parts==null ||  parts.length<2) {
				continue;
			}
			KeyValue ena=new KeyValue();
			ena.setKey(parts[0].trim());
			ena.setValue(parts[1].trim());
			this.enable.add(ena);
		}
	}

	public void addEnable(String enable) {
		if(enable==null || enable.isEmpty()) {
			return;
		}
		
		
		String[] parts=enable.split(":");
		if(parts==null ||  parts.length<2) {
			return;
		}
		KeyValue ena=new KeyValue();
		ena.setKey(parts[0].trim());
		ena.setValue(parts[1].trim());
		this.enable.add(ena);
	}
	
	public void addEnable(KeyValue enable) {
		this.enable.add(enable);
	}
	
	public KeyValue getEnable(String field) {
		KeyValue ena=null;
		for(KeyValue kv:enable) {
			if (kv.getKey().equalsIgnoreCase(field)) {
				ena=kv;
				break;
			}
		}
		return ena;
	}
	
	public String getEnableValue(String field) {
		KeyValue ena=null;
		for(KeyValue kv:enable) {
			if (kv.getKey().equalsIgnoreCase(field)) {
				ena=kv;
				break;
			}
		}
		return ena!=null?ena.getValue():null;
	}
	
	@Override
	public String toString() {
		return "HtmlFormActionWrapper [name=" + name + ", action=" + action + ", label=" + label + ", controlType="
				+ controlType + ", applyOn=" + applyOn + "]";
	}
}
