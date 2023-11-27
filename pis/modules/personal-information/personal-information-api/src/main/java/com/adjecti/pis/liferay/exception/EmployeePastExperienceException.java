package com.adjecti.pis.liferay.exception;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

import javax.portlet.PortletException;

public class EmployeePastExperienceException extends PortletException{

	public EmployeePastExperienceException() {
	}

	public EmployeePastExperienceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EmployeePastExperienceException(Throwable cause) {
		super(cause);
	}
	
	public EmployeePastExperienceException(String...errors) {
		this(ListUtil.toList(errors));
	}
	
	/**
	 * Custom constructor for validation
	 * @param errors
	 */
	public EmployeePastExperienceException(List<String> errors) {
		super(String.join(",", errors));
		_errors = errors;
	}
	
	public List<String> getErrors() {
		return _errors;
	}
	
	private List<String> _errors;
}
