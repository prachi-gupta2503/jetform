package com.adjecti.mdm.taglib;

import com.adjecti.mdm.liferay.model.MaritalStatus;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MaritalStatusTagHandler extends TagSupport {
	private final static Log LOGGER = LogFactoryUtil.getLog(MaritalStatusTagHandler.class.getName());

	private String id;
	private String name;
	private String selectedId;
	private String selectedValue;
	private String cssStyle;
	private String cssClass;
	private String onChange;

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
		JspWriter out = pageContext.getOut();// returns the instance of JspWriter
		LOGGER.info("++++++++++++" + id);
		LOGGER.info("***********" + name);
		if (name == null) {
			name = id;
		}
		if (cssStyle == null) {
			cssStyle = "";
		}

		if (cssClass == null) {
			cssClass = "form-check-input";
		}

		if (selectedValue == null) {
			selectedValue = "";
		}
		if (selectedId == null) {
			selectedId = "";
		}

		if (id == null) {
			id = "";
		}

		if (onChange == null) {
			onChange = "";
		}

		List<MaritalStatus> allMaritalStatuses = MDMUtils.getAllMaritalStatuses();
		if (allMaritalStatuses != null) {
			try {

				

				for (MaritalStatus maritalStatus : allMaritalStatuses) {
					
					out.print("<div class='form-check form-check-inline'>");
					if (String.valueOf(maritalStatus.getMaritalStatusId()).equalsIgnoreCase(selectedId)
							|| maritalStatus.getName().equalsIgnoreCase(selectedValue)) {
						out.print("<input class='" + cssClass + "' checked type='radio' name='" + name +"' id='"+ id +"' value='"+ maritalStatus.getMaritalStatusId() +"' style='" + cssStyle + "' onchange='" + onChange + "'/>");
						out.print("<label class='form-check-label'>"+maritalStatus.getName()+"</label>");
					
					} else {
						out.print("<input class='" + cssClass + "' type='radio' name='" + name + "' id='"+ id +"' value='"+ maritalStatus.getMaritalStatusId() +"' style='" + cssStyle + "' onchange='" + onChange + "'/>");
						out.print("<label class='form-check-label'>"+ maritalStatus.getName() +"</label>");
					}
					out.print("</div>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
