package com.adj.select.service.persistence.impl;

import com.adj.select.dto.SelectOptionsDTO;
import com.adj.select.exception.NoSuchSelectException;
import com.adj.select.service.persistence.SelectFinder;
import com.liferay.portal.kernel.dao.orm.SQLQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = SelectFinder.class)
public class SelectFinderImpl extends SelectFinderBaseImpl implements SelectFinder {

	@Reference
	private FormDBStoragePersistence formDBStoragePersistence;

	@SuppressWarnings("unchecked")
	public List<SelectOptionsDTO> getSelectOptionsData(String idFieldName, String valueFieldName, String tableName)
			throws NoSuchSelectException {
		List<Object[]> selectsList = Collections.emptyList();
		List<SelectOptionsDTO> selectOptionsDTOList = new ArrayList<SelectOptionsDTO>();
		if (!isTableExists(tableName)) {
			throw new NoSuchSelectException("Invalid" + tableName + "name");
		} else {
			String sql = "SELECT " + idFieldName + "," + valueFieldName + " FROM " + tableName + "";
			SQLQuery query = selectPersistence.getCurrentSession().createSQLQuery(sql);
			query.setCacheable(false);
			selectsList = query.list();

			if (selectsList.size() == 0 && selectsList.isEmpty()) {
				return null;
			} else {

				for (Object[] object : selectsList) {
					SelectOptionsDTO selectOptionsDTO = new SelectOptionsDTO();
					selectOptionsDTO.setId(object[0].toString());
					selectOptionsDTO.setValue((String) object[1]);
					selectOptionsDTOList.add(selectOptionsDTO);
				}

				return selectOptionsDTOList;
			}
		}
	}

	@SuppressWarnings("unchecked")
	private boolean isTableExists(String tableName) {
		List<Object> tableList = Collections.emptyList();
		SQLQuery queryTable = selectPersistence.getCurrentSession().createSQLQuery("show TABLES");
		tableList = queryTable.list();
		return tableList.stream().anyMatch(obj -> obj.toString().equalsIgnoreCase(tableName));

	}
}
