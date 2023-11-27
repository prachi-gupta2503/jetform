package com.adjecti.form.adapter.persistence;

import com.adjecti.form.adapter.model.TableModel;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.Date;
import java.util.List;

public interface FormDBStoragePersistence {

	public Session getSession();
	
	public void saveData(String tableName, long recordId, long formInstanceId, long groupId, long companyId, long userId, String userName, Date creationDate,
			List<TableModel> modelList);
}
