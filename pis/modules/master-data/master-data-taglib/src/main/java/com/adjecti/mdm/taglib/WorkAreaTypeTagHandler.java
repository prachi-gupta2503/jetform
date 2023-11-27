package com.adjecti.mdm.taglib;

import com.adjecti.mdm.liferay.model.WorkAreaType;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class WorkAreaTypeTagHandler extends TagSupport {
	private final static Log LOGGER = LogFactoryUtil.getLog(WorkAreaTypeTagHandler.class.getName());

	private String id;
	private String name;
	private String selectedId;
	private String selectedValue;
	private String cssStyle;
	private String cssClass;
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	private String onChange;
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}

	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();// returns the instance of JspWriter
		LOGGER.info("++++++++++++"+id);
		LOGGER.info("***********"+name);
		if(name==null) {
			name = id;
		}
		if(cssStyle==null) {
			cssStyle = "";
		}
		
		if(cssClass==null) {
			cssClass = "form-control";
		}
		
		if(selectedValue==null) {
			selectedValue = "";
		}
		if(selectedId==null) {
			selectedId = "";
		}
		
		if(id==null) {
			id = "";
		}
		
		if(onChange==null) {
			onChange = "";
		}
		
		List<WorkAreaType> allWorkAreaTypes = MDMUtils.getAllWorkAreaTypes();
		
		if(allWorkAreaTypes != null)
			{
		try {
			
			out.print("<select id='"+id+"' name='"+name+"' class='"+cssClass+"' style='"+cssStyle+"' onchange='"+onChange+"'>");
			
			out.println("<option value=" + 0 + ">Please Choose a WorkAreaType.</option>");
			for (WorkAreaType workAreaType : allWorkAreaTypes) {
				if(String.valueOf(workAreaType.getWorkAreaTypeId()).equalsIgnoreCase(selectedId) || workAreaType.getName().equalsIgnoreCase(selectedValue)) {
					out.println("<option selected value=" + workAreaType.getWorkAreaTypeId() + ">" + workAreaType.getName() + "</option>");
				}else {
					out.println("<option value=" + workAreaType.getWorkAreaTypeId() + ">" + workAreaType.getName() + "</option>");
				}
			}
			out.print("</select>");
		} catch (Exception e) {
			LOGGER.error(e);
		}	  
		}
		return SKIP_BODY;
	}
    
    @Override
	public int doAfterBody() throws JspException {
	
		return super.doAfterBody();
	}

}
