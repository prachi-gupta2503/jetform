package com.adjecti.jetform.annotation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HtmlElementRuleGroupWrapper implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	List<HtmlElementRuleWrapper> rules=new ArrayList<HtmlElementRuleWrapper>();
	String effect;
	public HtmlElementRuleGroupWrapper() {
		super();
	}
	public HtmlElementRuleGroupWrapper(String name,List<HtmlElementRuleWrapper> rules, String effect) {
		super();
		this.name = name;
		this.rules = rules;
		this.effect = effect;
	}
	
	public HtmlElementRuleGroupWrapper(HtmlElementRuleGroup ruleGroup) {
		this.name=ruleGroup.name();
		if(ruleGroup.value().length>0){
			int i=0;
			for(HtmlElementRule rule:ruleGroup.value()){
				this.rules.add(new HtmlElementRuleWrapper(rule));
				i++;
			}
		}
		this.effect=ruleGroup.effect();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<HtmlElementRuleWrapper>  getRules() {
		return rules;
	}
	public void setRules(List<HtmlElementRuleWrapper>  rules) {
		this.rules = rules;
	}
	
	public void addRule(HtmlElementRuleWrapper rule){
		this.rules.add(rule);
	}
	
	public void addRule(HtmlElementRule rule){
		this.rules.add(new HtmlElementRuleWrapper(rule));
	}
	
	public String getEffect() {
		return effect;
	}
	
	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	@Override
	public String toString() {
		return "HtmlElementRuleGroupWrapper [name=" + name + ", rules=" + rules + ", effect=" + effect + "]";
	}
}
