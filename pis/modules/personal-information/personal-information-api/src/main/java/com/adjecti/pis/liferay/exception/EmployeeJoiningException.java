package com.adjecti.pis.liferay.exception;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

import javax.portlet.PortletException;

public class EmployeeJoiningException extends PortletException {

	public EmployeeJoiningException() {
	}

	public EmployeeJoiningException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EmployeeJoiningException(Throwable cause) {
		super(cause);
	}
	
	public EmployeeJoiningException(String...errors) {
		this(ListUtil.toList(errors));
	}
	
	/**
	 * Custom constructor for validation
	 * @param errors
	 */
	public EmployeeJoiningException(List<String> errors) {
		super(String.join(",", errors));
		_errors = errors;
	}
	
	public List<String> getErrors() {
		return _errors;
	}
	
	private List<String> _errors;
}
