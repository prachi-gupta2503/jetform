package com.adjecti.mdm.taglib;

import com.adjecti.mdm.liferay.model.OEM;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class OEMTagHandler extends TagSupport {
	private final static Log LOGGER = LogFactoryUtil.getLog(OEMTagHandler.class.getName());

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
		System.out.println("++++++++++++"+id);
		System.out.println("***********"+name);
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
	
		
		List<OEM> allOEMs = MDMUtils.getAllOEMs();
		
		if(allOEMs != null)
			{
		try {
			
			out.print("<select id='"+id+"' name='"+name+"' class='"+cssClass+"' style='"+cssStyle+"' onchange='"+onChange+"'>");
			
			out.println("<option value=" + 0 + ">Please Choose a OEM.</option>");
			for (OEM oem : allOEMs) {
				if(String.valueOf(oem.getOemId()).equalsIgnoreCase(selectedId) || oem.getName().equalsIgnoreCase(selectedValue)) {
					out.println("<option selected value=" + oem.getOemId() + ">" + oem.getName() + "</option>");
				}else {
					out.println("<option value=" + oem.getOemId() + ">" + oem.getName() + "</option>");
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
