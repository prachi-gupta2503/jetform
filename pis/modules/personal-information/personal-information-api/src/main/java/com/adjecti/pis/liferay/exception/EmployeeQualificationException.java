package com.adjecti.pis.liferay.exception;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

import javax.portlet.PortletException;

public class EmployeeQualificationException extends PortletException {

	public EmployeeQualificationException() {
	}

	public EmployeeQualificationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EmployeeQualificationException(Throwable cause) {
		super(cause);
	}
	
	public EmployeeQualificationException(String...errors) {
		this(ListUtil.toList(errors));
	}
	
	/**
	 * Custom constructor for validation
	 * @param errors
	 */
	public EmployeeQualificationException(List<String> errors) {
		super(String.join(",", errors));
		_errors = errors;
	}
	
	public List<String> getErrors() {
		return _errors;
	}
	
	private List<String> _errors;
}
