package com.adjecti.form.adapter.persistence.impl;

import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.db.DBType;
import com.liferay.portal.kernel.dao.orm.Dialect;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

public class BaseDBStoragePersistenceImpl implements SessionFactory {
	public static final String COUNT_COLUMN_NAME = "COUNT_VALUE";
	private static final Log _log = LogFactoryUtil.getLog(BasePersistenceImpl.class);

	private static final Map<Class<?>, Type> _typeMap = HashMapBuilder
			.<Class<?>, Type>put(BigDecimal.class, Type.BIG_DECIMAL).put(Boolean.class, Type.BOOLEAN)
			.put(Date.class, Type.DATE).put(Double.class, Type.DOUBLE).put(Float.class, Type.FLOAT)
			.put(Integer.class, Type.INTEGER).put(Long.class, Type.LONG).put(Short.class, Type.SHORT)
			.put(String.class, Type.STRING).put(Timestamp.class, Type.TIMESTAMP).build();

	
	private DataSource _dataSource;
	private DB _db;
	private Dialect _dialect;
	private SessionFactory _sessionFactory;
	private int _databaseOrderByMaxColumns;
	
	protected int databaseInMaxParameters;

	@Override
	public Session getCurrentSession() throws ORMException {
		return _sessionFactory.getCurrentSession();
	}
	
	@Override
	public Session openNewSession(Connection connection) throws ORMException {
		return _sessionFactory.openNewSession(connection);
	}

	@Override
	public Session openSession() throws ORMException {
		return _sessionFactory.openSession();
	}
	
	@Override
	public void closeSession(Session session) {
		_sessionFactory.closeSession(session);
	}
	
	@Override
	public Dialect getDialect() {
		return _dialect;
	}


	public DataSource getDataSource() {
		return _dataSource;
	}

	
	public void setDataSource(DataSource dataSource) {
		_dataSource = dataSource;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		_sessionFactory = sessionFactory;

		_dialect = _sessionFactory.getDialect();

		DBType dbType = DBManagerUtil.getDBType(_dialect);

		_databaseOrderByMaxColumns = GetterUtil
				.getInteger(PropsUtil.get(PropsKeys.DATABASE_ORDER_BY_MAX_COLUMNS, new Filter(dbType.getName())));

		databaseInMaxParameters = GetterUtil
				.getInteger(PropsUtil.get(PropsKeys.DATABASE_IN_MAX_PARAMETERS, new Filter(dbType.getName())));
	}

	public DB getDB() {
		if (_db == null) {
			_db = DBManagerUtil.getDB(_dialect, _dataSource);
		}

		return _db;
	}

	public void flush() {
		try {
			Session session = _sessionFactory.getCurrentSession();

			if (session != null) {
				session.flush();
			}
		} catch (Exception exception) {
			throw processException(exception);
		}
	}
	
	
	//@Override
	public SystemException processException(Exception exception) {
		if (!(exception instanceof ORMException)) {
			_log.error("Caught unexpected exception", exception);
		} else if (_log.isDebugEnabled()) {
			_log.debug(exception, exception);
		}

		return new SystemException(exception);
	}


	//@Override
		
	protected ClassLoader getClassLoader() {
		Class<?> clazz = getClass();

		return clazz.getClassLoader();
	}

}