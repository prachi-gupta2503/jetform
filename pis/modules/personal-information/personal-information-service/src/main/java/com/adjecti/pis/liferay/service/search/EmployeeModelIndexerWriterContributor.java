package com.adjecti.pis.liferay.service.search;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

@Component(
        immediate = true,
        property = "indexer.class.name=com.adjecti.pis.liferay.model.Employee",
        service = ModelIndexerWriterContributor.class
)
public class EmployeeModelIndexerWriterContributor  implements ModelIndexerWriterContributor<Employee> {
	
	 @Override
	    public void customize(
	        BatchIndexingActionable batchIndexingActionable,
	        ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

	        batchIndexingActionable.setPerformActionMethod((Employee employee) -> {
	            Document document = modelIndexerWriterDocumentHelper.getDocument(
	            		employee);

	            batchIndexingActionable.addDocuments(document);
	            
	        });
	    }

	    @Override
	    public BatchIndexingActionable getBatchIndexingActionable() {
	        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
	        		employeeLocalService.getIndexableActionableDynamicQuery());
	    }

	    @Override
	    public long getCompanyId(Employee employee) {
	        return employee.getCompanyId();
	    }

	    @Reference
	    protected DynamicQueryBatchIndexingActionableFactory
	    dynamicQueryBatchIndexingActionableFactory;

	    @Reference
	    protected EmployeeLocalService employeeLocalService;

	}