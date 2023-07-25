package tech.csm.service;

import java.util.List;

import tech.csm.bean.AsesmentMark;
import tech.csm.entity.BatchDetailsBean;

public interface AssesmentMarkService {

	List<BatchDetailsBean> getAllBatchDetails();

	List<BatchDetailsBean> getAllBatchDetails(Integer valueOf);

	AsesmentMark getMarkDetailsByEmpId(BatchDetailsBean batchDetailsBean);

	AsesmentMark saveEmployeeMark(BatchDetailsBean batchDetailsBean);

}
