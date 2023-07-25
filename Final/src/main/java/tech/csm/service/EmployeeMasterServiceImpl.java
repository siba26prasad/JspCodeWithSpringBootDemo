package tech.csm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.bean.BatchAllocate;
import tech.csm.bean.EmployeeMaster;
import tech.csm.entity.BatchDetailsBean;
import tech.csm.repo.BatchAllocatedRepo;
import tech.csm.repo.EmployeeMasterRepo;

@Service
public class EmployeeMasterServiceImpl implements EmployeeMasterService {

	@Autowired
	private BatchAllocatedRepo batchAllocatedRepo;

	@Autowired
	private EmployeeMasterRepo employeeMasterRepo;

	@Override
	public List<BatchDetailsBean> fetchEmployeeListByTechIdAndBatchId(String techId, String batchId) {

		List<BatchAllocate> batchAllocatedList = null;
		EmployeeMaster empDetails = null;
		List<EmployeeMaster> empDetailsList = null;
		List<BatchDetailsBean> fetchAllEmpList = new ArrayList<>();
		List<Object[]> objList = null;
		try {

//			batchAllocatedList = batchAllocatedRepo.findByBatchIdAndTechnologyId(Integer.valueOf(batchId),
//					Integer.valueOf(techId));
//			for (BatchAllocate bList : batchAllocatedList) {
//
//				empDetails = employeeMasterRepo.findByEmployeeID(bList.getEmployeeId());
//				BatchDetailsBean bean = new BatchDetailsBean();
//				bean.setEmpId(empDetails.getEmployeeID());
//				bean.setEmployeeName(empDetails.getEmployeeName());
//				fetchAllEmpList.add(bean);
//			}
			objList = batchAllocatedRepo.findEmpByBatchIdAndTechnologyId(Integer.valueOf(batchId),
					Integer.valueOf(techId));
//			for (Object[] obj : objList) {
//
//				BatchDetailsBean bean = new BatchDetailsBean();
//				bean.setEmpId(obj[0]));
//				bean.setEmployeeName(emp.getEmployeeName());
//				fetchAllEmpList.add(bean);
//			}
			for (Object[] obj : objList) {
				
				BatchDetailsBean bean = new BatchDetailsBean();
				bean.setEmpId(Integer.valueOf(obj[0].toString()));
				bean.setEmployeeName(obj[1].toString());
				fetchAllEmpList.add(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fetchAllEmpList;
	}

}
