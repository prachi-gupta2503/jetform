package com.adjecti.mdm.taglib;

import com.adjecti.mdm.liferay.model.CourseCategory;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CourseCategoryTagHandler extends TagSupport {
	private final static Log LOGGER = LogFactoryUtil.getLog(CourseCategoryTagHandler.class.getName());

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
		List<CourseCategory> courseCategories = MDMUtils.getAllCourseCategories();
		if(courseCategories != null)
			{
		try {
			if(name==null)
			{
			name = id;
			}
			out.print("<select class='form-control' id=" +id+ " name=" +name+ " style="+cssStyle+"; onchange="+onChange+ ">");
			out.println("<option value=" + 0 + ">Please Choose a DesignationClass.</option>");
			for (CourseCategory courseCategory : courseCategories) {
				if(String.valueOf(courseCategory.getCourseCategoryId()).equalsIgnoreCase(selectedId) || courseCategory.getName().equalsIgnoreCase(selectedValue))
				{
					out.println("<option selected value=" + courseCategory.getCourseCategoryId() + ">" + courseCategory.getName() + "</option>");
				}
				else {
	    			out.println("<option value=" + courseCategory.getCourseCategoryId() + ">" + courseCategory.getName() + "</option>");
				}
				}
			out.print("</select>");
		} catch (Exception e) {
			LOGGER.error(e);
		}	  
		}
		return SKIP_BODY;// will not evaluate the body content of the tag
	}
	
}
