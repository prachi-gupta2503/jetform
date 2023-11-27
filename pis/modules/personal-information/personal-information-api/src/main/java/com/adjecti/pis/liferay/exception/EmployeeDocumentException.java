package com.adjecti.pis.liferay.exception;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

import javax.portlet.PortletException;

public class EmployeeDocumentException extends PortletException {
	public EmployeeDocumentException() {
	}

	public EmployeeDocumentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EmployeeDocumentException(Throwable cause) {
		super(cause);
	}
	
	public EmployeeDocumentException(String...errors) {
		this(ListUtil.toList(errors));
	}
	
	/**
	 * Custom constructor for validation
	 * @param errors
	 */
	public EmployeeDocumentException(List<String> errors) {
		super(String.join(",", errors));
		_errors = errors;
	}
	
	public List<String> getErrors() {
		return _errors;
	}
	
	private List<String> _errors;
}
