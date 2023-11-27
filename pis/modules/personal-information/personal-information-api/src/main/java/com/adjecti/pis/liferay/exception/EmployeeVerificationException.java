package com.adjecti.pis.liferay.exception;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

import javax.portlet.PortletException;

public class EmployeeVerificationException extends PortletException {

	public EmployeeVerificationException() {
	}

	public EmployeeVerificationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EmployeeVerificationException(Throwable cause) {
		super(cause);
	}
	
	public EmployeeVerificationException(String...errors) {
		this(ListUtil.toList(errors));
	}
	
	/**
	 * Custom constructor for validation
	 * @param errors
	 */
	public EmployeeVerificationException(List<String> errors) {
		super(String.join(",", errors));
		_errors = errors;
	}
	
	public List<String> getErrors() {
		return _errors;
	}
	
	private List<String> _errors;
}
