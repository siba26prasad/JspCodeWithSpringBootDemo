package tech.csm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.bean.BatchAllocate;
import tech.csm.bean.BatchMaster;
import tech.csm.entity.BatchDetailsBean;
import tech.csm.repo.BatchMasterRepo;

@Service
public class BatchMasterServiceImpl implements BatchMasterService {

	@Autowired
	private BatchMasterRepo batchMasterRepo;

	@Override
	public List<BatchDetailsBean> getAllBatch() {

		List<BatchMaster> batchListDto = null;
		List<BatchDetailsBean> batchDetailsList = new ArrayList<>();
		try {
			batchListDto = batchMasterRepo.findAll();
			if (batchListDto != null) {
				for (BatchMaster batchMaster : batchListDto) {
					BatchDetailsBean bean = new BatchDetailsBean();
					bean.setBatchId(batchMaster.getBatchId());
					bean.setBatchName(batchMaster.getBatchName());
					bean.setStartDate(batchMaster.getBatchStartDate().toString());
					bean.setBatchStrength(batchMaster.getBatchStrength());
					batchDetailsList.add(bean);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return batchDetailsList;
	}

}
