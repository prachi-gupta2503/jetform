package com.adjecti.pis.liferay.service.persistence.impl;

import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.model.impl.EmployeeImpl;
import com.adjecti.pis.liferay.model.impl.PeopleImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = EmployeeFinder.class)
public class EmployeeFinderImpl  extends EmployeeFinderBaseImpl implements EmployeeFinder{

	@Reference
	private CustomSQL customSQL;
	
	public List<Employee> findEmployeeByDesignationGroupAndEmployeeStatus(String designationGroup,int date,int month){
		
		Session session=null;
		try {
			session=openSession();
			String sql=customSQL.get(getClass(), "com.adjecti.pis.liferay.service.persistence.EmployeeFinder.findEmployeeByDesignationGroupAndEmployeeStatus");
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("pis_employee", EmployeeImpl.class);
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(designationGroup);
	        qPos.add(date);
	        qPos.add(month);
	        
	        List<Employee> list= (List<Employee>) q.list();
	        System.out.println(list);
	        
	        return list;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
		
	}

}
