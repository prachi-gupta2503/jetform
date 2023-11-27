package com.adjecti.pis.liferay.service.search;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import com.adjecti.pis.liferay.model.Employee;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

@Component(
        immediate = true,
        property = "indexer.class.name=com.adjecti.pis.liferay.model.Employee",
        service = ModelDocumentContributor.class
)
public class EmployeeModelDocumentContributor implements ModelDocumentContributor<Employee>  {
	 @Override
	    public void contribute(Document document, Employee employee) {
	        try {
	            document.addDate(Field.MODIFIED_DATE, employee.getModifiedDate());

	            Locale defaultLocale = PortalUtil.getSiteDefaultLocale(
	    employee.getGroupId());

	            String localizedTitle = LocalizationUtil.getLocalizedName(
	    Field.TITLE, defaultLocale.toString());

	            document.addText("email", employee.getEmailId());
	            document.addText("name", employee.getUserName());
	            
	        } catch (PortalException pe) {
	            if (_log.isWarnEnabled()) {
	                _log.warn(
	    "Unable to index guestbook " + employee.getEmployeeId(), pe);
	            }
	        }
	    }

	    private static final Log _log = LogFactoryUtil.getLog(
	    EmployeeModelDocumentContributor.class);

	}
