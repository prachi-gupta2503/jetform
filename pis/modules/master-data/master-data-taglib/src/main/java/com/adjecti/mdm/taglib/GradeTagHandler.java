package com.adjecti.mdm.taglib;

import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class GradeTagHandler extends TagSupport {
	private final static Log LOGGER = LogFactoryUtil.getLog(GradeTagHandler.class.getName());

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
		List<Grade> grades = MDMUtils.getAllGrades();
		if(grades != null)
			{
		try {
			if(name==null)
			{
			name = id;
			}
			out.print("<select class='form-control' id=" +id+ " name=" +name+ " style="+cssStyle+"; onchange="+onChange+ ">");
			out.println("<option value=" + 0 + ">Please Choose a DesignationClass.</option>");
			for (Grade grade : grades) {
				if(String.valueOf(grade.getGradeId()).equalsIgnoreCase(selectedId) || grade.getName().equalsIgnoreCase(selectedValue))
				{
					out.println("<option selected value=" + grade.getGradeId() + ">" + grade.getName() + "</option>");
				}
				else {
	    			out.println("<option value=" + grade.getGradeId() + ">" + grade.getName() + "</option>");
				}
				}
			out.print("</select>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error(e);
		}	  
		}
		return SKIP_BODY;// will not evaluate the body content of the tag
	}
	
}