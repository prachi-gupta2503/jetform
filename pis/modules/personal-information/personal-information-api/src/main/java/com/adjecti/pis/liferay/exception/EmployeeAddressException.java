package com.adjecti.pis.liferay.exception;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

import javax.portlet.PortletException;

public class EmployeeAddressException extends PortletException {
	public EmployeeAddressException() {
	}

	public EmployeeAddressException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EmployeeAddressException(Throwable cause) {
		super(cause);
	}
	
	public EmployeeAddressException(String...errors) {
		this(ListUtil.toList(errors));
	}
	
	/**
	 * Custom constructor for validation
	 * @param errors
	 */
	public EmployeeAddressException(List<String> errors) {
		super(String.join(",", errors));
		_errors = errors;
	}
	
	public List<String> getErrors() {
		return _errors;
	}
	
	private List<String> _errors;

}
