package com.adjecti.pis.joining.liferay.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.adjecti.pis.joining.liferay.constants.EmployeeJoiningWebPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Objects;

import com.liferay.portal.kernel.portlet.PortalPreferences;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class EmployeesManagementToolbarDisplayContext {
	public EmployeesManagementToolbarDisplayContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			HttpServletRequest request
			) {

			
			_liferayPortletRequest = liferayPortletRequest;
			_liferayPortletResponse = liferayPortletResponse;
			_request = request;
			_currentURLObj = PortletURLUtil.getCurrent(
				liferayPortletRequest, _liferayPortletResponse);

			_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
				liferayPortletRequest);
		}
	
	public CreationMenu getCreationMenu() {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);

		// Check if user has permissions to add assignments.

		

		// Create the menu.

		CreationMenu creationMenu = new CreationMenu();

		creationMenu.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(
				_liferayPortletResponse.createRenderURL(),
				
				"redirect", _currentURLObj.toString());
			dropdownItem.setLabel(LanguageUtil.get(_request, "add-assignment"));
		});

		return creationMenu;
	}
	
	public String getDisplayStyle() {

		String displayStyle = ParamUtil.getString(_request, "displayStyle");

		if (Validator.isNull(displayStyle)) {
			displayStyle = _portalPreferences.getValue(
					EmployeeJoiningWebPortletKeys.EMPLOYEEJOININGWEB, "employees-display-style",
				"icon");
		}
		else {
			_portalPreferences.setValue(
				EmployeeJoiningWebPortletKeys.EMPLOYEEJOININGWEB, "employees-display-style",
				displayStyle);

			_request.setAttribute(
				WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
		}

		return displayStyle;
	}

	
//	public List<DropdownItem> getFilterDropdownItems() {
//
//		return new DropdownItemList() {
//
//			{
//				addGroup(dropdownGroupItem -> {
//					dropdownGroupItem.setDropdownItems(
//						_getOrderByDropdownItems());
//					dropdownGroupItem.setLabel(
//						LanguageUtil.get(_request, "order-by"));
//				});
//			}
//		};
//	}
	
	public String getOrderByCol() {

		return ParamUtil.getString(_request, "orderByCol", "name");
	}

	public String getOrderByType() {

		return ParamUtil.getString(_request, "orderByType", "desc");
	}

	public String getSearchActionURL() {

		PortletURL searchURL = _liferayPortletResponse.createRenderURL();

		
		searchURL.setParameter("orderByCol", getOrderByCol());
		searchURL.setParameter("orderByType", getOrderByType());

		return searchURL.toString();
	}
	
	public PortletURL getSortingURL()
			throws PortletException {

			PortletURL sortingURL = _getCurrentSortingURL();

			sortingURL.setParameter(
				"orderByType",
				Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");

			return sortingURL;
		}

	
	
	private PortletURL _getCurrentSortingURL()
			throws PortletException {

			PortletURL sortingURL =
				PortletURLUtil.clone(_currentURLObj, _liferayPortletResponse);
			
			sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");

			String keywords = ParamUtil.getString(_request, "keywords");

			if (Validator.isNotNull(keywords)) {
				sortingURL.setParameter("keywords", keywords);
			}

			return sortingURL;
		}
	
//	private List<DropdownItem> _getOrderByDropdownItems() {
//
//		return new DropdownItemList() {
//
//			{
//				add(SafeConsumer.ignore(dropdownItem -> {
//					dropdownItem.setActive("title".equals(getOrderByCol()));
//					dropdownItem.setHref(
//						_getCurrentSortingURL(), "orderByCol", "name");
//					dropdownItem.setLabel(LanguageUtil.get(_request, "name"));
//				}));
//
//				add(SafeConsumer.ignore(dropdownItem -> {
//					dropdownItem.setActive(
//						"createDate".equals(getOrderByCol()));
//					dropdownItem.setHref(
//						_getCurrentSortingURL(), "orderByCol", "name");
//					dropdownItem.setLabel(
//						LanguageUtil.get(_request, "name"));
//				}));
//			}
//		};
//	}
	private final PortletURL _currentURLObj;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;
	private final HttpServletRequest _request;
}
