package com.adjecti.mdm.taglib;

import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class GenderTagHandler extends TagSupport {
	private final static Log LOGGER = LogFactoryUtil.getLog(GenderTagHandler.class.getName());

	private String id;
	private String name;
	private String selectedId;
	private String selectedValue;
	private String cssStyle;
	private String onChange;
    private String cssClass;
	
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
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
		JspWriter out = pageContext.getOut();// returns the instance of JspWriter
		List<Gender> genders = MDMUtils.getAllGenders();
		if(genders != null)
			{
		try {
			if(name==null)
			{
			name = id;
			}
	
            for (Gender gender : genders) {
				
				out.print("<div class='form-check form-check-inline'>");
				if(String.valueOf(gender.getGenderId()).equalsIgnoreCase(selectedId) || gender.getName().equalsIgnoreCase(selectedValue)) {
					out.print("<input class='" + cssClass + "' checked type='radio' name='" + name +"' id='"+ id +"' value='"+ gender.getGenderId() +"' style='" + cssStyle + "' onchange='" + onChange + "'/>");
					out.print("<label class='form-check-label'>"+ gender.getName() +"</label>");
				
				} else {
					out.print("<input class='" + cssClass + "' type='radio' name='" + name + "' id='"+ id +"' value='"+ gender.getGenderId() +"' style='" + cssStyle + "' onchange='" + onChange + "'/>");
					out.print("<label class='form-check-label'>"+ gender.getName() +"</label>");
				}
				out.print("</div>");
			}  
		} catch (Exception e) {
			LOGGER.error(e);
		}	  
		}
		return SKIP_BODY;// will not evaluate the body content of the tag
	}
	
}