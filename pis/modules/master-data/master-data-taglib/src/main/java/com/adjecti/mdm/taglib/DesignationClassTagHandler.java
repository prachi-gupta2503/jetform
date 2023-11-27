package com.adjecti.mdm.taglib;

import com.adjecti.mdm.liferay.model.DesignationClass;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
public class DesignationClassTagHandler extends TagSupport {
	private final static Log LOGGER = LogFactoryUtil.getLog(DesignationClassTagHandler.class.getName());

	private String id;
	private String name;
	private String selectedId;
	private String selectedValue;
	private String cssStyle;
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
		LOGGER.error("++++++++++++"+id);
		LOGGER.error("***********"+name);

		List<DesignationClass> designationClasses = MDMUtils.getAllDesignationClasss();
		if(designationClasses != null)
			{
		try {
			
			out.print("<select class='form-control' style="+cssStyle+";onchange="+onChange+">");
			
			out.println("<option value=" + 0 + ">Please Choose a DesignationClass.</option>");
			for (DesignationClass designation : designationClasses) {
				if(String.valueOf(designation.getDesignationClassId()).equalsIgnoreCase(selectedId) || designation.getName().equalsIgnoreCase(selectedValue))
				{
					out.println("<option selected value=" + designation.getDesignationClassId() + ">" + designation.getName() + "</option>");
				}
				else {
	    			out.println("<option value=" + designation.getDesignationClassId() + ">" + designation.getName() + "</option>");
				}
				}
			out.print("</select>");
		} catch (Exception e) {
			LOGGER.error(e);
		}	  
		}
		return SKIP_BODY;// will not evaluate the body content of the tag
	}
	
	@Override
	public int doAfterBody() throws JspException {
	
		return super.doAfterBody();
	}
	
	
}
