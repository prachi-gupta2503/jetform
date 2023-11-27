package net.ayudh.audit.listener;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import net.ayudh.audit.util.AuditEventUtil;



@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class JournalArticleModelListener extends BaseModelListener<JournalArticle> {

	final static Log LOGGER = LogFactoryUtil.getLog(JournalArticleModelListener.class.getName());
	
	
	String className=JournalArticle.class.getName();
	
	@Override
	public void onAfterCreate(JournalArticle model) throws ModelListenerException {
		LOGGER.info("Audit Event On After Create Call  ");
		AuditEventUtil.logEvent("ADD", String.valueOf(model.getId()),className,"",model.getTitle(Locale.US));
		
	}

	@Override
	public void onAfterRemove(JournalArticle model) throws ModelListenerException {
		LOGGER.info("Audit Event On After Remove Call  ");
		AuditEventUtil.logEvent("DELETE", String.valueOf(model.getId()),className,"",model.getTitle(Locale.US));
	}

	@Override
	public void onAfterUpdate(JournalArticle model) throws ModelListenerException {
		LOGGER.info("Audit Event On After Update Call  ");
		AuditEventUtil.logEvent("UPDATE", String.valueOf(model.getId()),className,"",model.getTitle(Locale.US));
	}

	@Override
	public void onBeforeCreate(JournalArticle model) throws ModelListenerException {
		
	}

	@Override
	public void onBeforeRemove(JournalArticle model) throws ModelListenerException {
		
	}

	@Override
	public void onBeforeUpdate(JournalArticle model) throws ModelListenerException {
		
	}
	
	
}
