package tech.csm.service;

import java.util.List;

import tech.csm.entity.BatchDetailsBean;

public interface EmployeeMasterService {

	List<BatchDetailsBean> fetchEmployeeListByTechIdAndBatchId(String techId, String batchId);

}
