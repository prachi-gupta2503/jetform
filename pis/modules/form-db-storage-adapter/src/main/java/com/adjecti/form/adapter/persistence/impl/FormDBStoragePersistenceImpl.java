package com.adjecti.form.adapter.persistence.impl;

import com.adjecti.form.adapter.model.TableModel;
import com.adjecti.form.adapter.persistence.FormDBStoragePersistence;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = FormDBStoragePersistence.class)
public class FormDBStoragePersistenceImpl extends BaseDBStoragePersistenceImpl implements FormDBStoragePersistence{
	
	@Override
	@Reference(
	//	target = OFBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
	//	target = OFBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	


	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return super.getCurrentSession();
	}

	@Override
	public void saveData(String tableName, long recordId, long formInstanceId, long groupId, long companyId, long userId, String userName, Date creationDate, List<TableModel> modelList) {
		Session session = getSession();
		if(!isTableExists(tableName, session))
			this.createTable(tableName, modelList, session);
		
		String sql ="INSERT INTO "+tableName +" (contentId, formInstanceId, groupId, companyId, userId, username, createDate ";
			for(TableModel field : modelList) {
				sql = sql.concat(", "+field.getColumnName());
			}
			sql = sql.concat( " ) ");
				 
			sql = sql.concat(" VALUES ( ");
			sql = sql.concat( recordId + ", "+formInstanceId+ ", "+ groupId +", "+companyId +", "+userId+", '"+userName+"', " +new java.sql.Date(creationDate.getTime()));
			
			for(TableModel field : modelList) {
				if(field.getColumnType().equalsIgnoreCase("DATETIME")) {
					try {
						DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
						Date date = format.parse(field.getColumnValue());
						sql = sql.concat(", "+date);
					} catch (ParseException e) {
						
					}
				} else if (field.getColumnType().equalsIgnoreCase("varchar(150)")) {
					sql = sql.concat(", '"+field.getColumnValue()+"'");
				} else if (field.getColumnType().equalsIgnoreCase("numeric")) {
					sql = sql.concat(", "+field.getColumnValue());
				} else {
					sql = sql.concat(", '"+field.getColumnValue()+"'");
				}
			}
			 
			sql = sql.concat( " ) ");
			System.out.println(sql.toString());
		SQLQuery q = session.createSQLQuery(sql.toString());

		int result = q.executeUpdate();
	}
	
	
	private void createTable(String tableName, List<TableModel> modelList, Session session) {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE ");
		sql.append(tableName);
		sql.append(" ( contentId bigint, formInstanceId bigint, groupId bigint, companyId bigint, userId bigint, username varchar(75), createDate DATETIME ");  
		for(TableModel field : modelList) {
			sql.append(" , "+field.getColumnName() +" " + field.getColumnType());
		}

		sql.append(" ) "); 
		
		SQLQuery q = session.createSQLQuery(sql.toString());

		int result = q.executeUpdate();
	}
	
	private boolean isTableExists(String tableName, Session session) {
		List<Object> tableList = Collections.emptyList();
		SQLQuery queryTable = session.createSQLQuery("show TABLES");
		tableList = queryTable.list();
		return tableList.stream().anyMatch(obj -> obj.toString().equalsIgnoreCase(tableName));

	}
	
}
