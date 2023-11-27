package com.adjecti.pis.liferay.service.persistence.impl;

import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.model.impl.PeopleImpl;
import com.adjecti.pis.liferay.service.persistence.PeopleFinder;
import com.liferay.chat.model.Entry;
import com.liferay.chat.service.persistence.EntryFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = PeopleFinder.class)
public class PeopleFinderImpl extends PeopleFinderBaseImpl implements PeopleFinder{

@Reference
private CustomSQL customSQL;

public List<People>  getByDateOfBirth(int date,int month){
	Session session=null;
	try {
		session=openSession();
		String sql=customSQL.get(getClass(), "com.adjecti.pis.liferay.service.persistence.PeopleFinder.findByDateOfBirth");
		SQLQuery q = session.createSQLQuery(sql);
        q.setCacheable(false);
        q.addEntity("pis_people", PeopleImpl.class);

        QueryPos qPos = QueryPos.getInstance(q);
        qPos.add(date);
        qPos.add(month);
        List<People> list= (List<People>) q.list();
        System.out.println(list);
        
        return list;
	}catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	
}
	
	
	

}
