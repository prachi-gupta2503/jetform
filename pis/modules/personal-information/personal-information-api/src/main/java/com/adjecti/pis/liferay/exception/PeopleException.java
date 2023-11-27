package com.adjecti.pis.liferay.exception;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

import javax.portlet.PortletException;

public class PeopleException extends PortletException {

	
	public PeopleException() {
	}

	public PeopleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PeopleException(Throwable cause) {
		super(cause);
	}
	
	public PeopleException(String...errors) {
		this(ListUtil.toList(errors));
	}
	
	/**
	 * Custom constructor for validation
	 * @param errors
	 */
	public PeopleException(List<String> errors) {
		super(String.join(",", errors));
		_errors = errors;
	}
	
	public List<String> getErrors() {
		return _errors;
	}
	
	private List<String> _errors;
	
}
