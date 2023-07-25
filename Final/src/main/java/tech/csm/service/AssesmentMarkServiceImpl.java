package tech.csm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.bean.AsesmentMark;
import tech.csm.entity.BatchDetailsBean;
import tech.csm.repo.AssesmentMarkRepo;

@Service
public class AssesmentMarkServiceImpl implements AssesmentMarkService {
	
	@Autowired
	private AssesmentMarkRepo assesmentMarkRepo;

	@Override
	public List<BatchDetailsBean> getAllBatchDetails() {
		
		List<BatchDetailsBean> batchDetailsList = new ArrayList<>();
		List<Object[]> objList = null;
		try {
			objList = assesmentMarkRepo.getAllBatchDetails();
			for (Object[] obj : objList) {
				BatchDetailsBean batch = new BatchDetailsBean();
//				batch.setSlNo(obj[0].toString());
				batch.setBatchName(obj[0].toString());
				batch.setBatchStartDate(obj[1].toString());
				batch.setTechnologyName(obj[2].toString());
				batch.setEmployeeName(obj[3].toString());
				batch.setEmployeePhone(obj[4].toString());
				batch.setMark(obj[5].toString());
				
				batch.setGrade(getGrade(batch.getMark()));
				batch.setStatus(getStatus(batch.getMark()));
				batchDetailsList.add(batch);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return batchDetailsList;
	}

	private String getStatus(String mark) {
		Integer markNo = Integer.valueOf(mark);
		String ststus="";
		try {
			
			if(markNo >= 70) { 
				ststus = "Eligible";
			}else {
				ststus = "Not Eligible";	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return ststus;
	}

	private String getGrade(String mark) {
		Integer markNo = Integer.valueOf(mark);
		String garde="";
		try {
			
			if(markNo<60) { 
				garde = "F";
			}else if(markNo>=60 && markNo <= 79) {
				garde = "A";
			}else if(markNo>=80 && markNo <= 89) {
				garde = "E";
			}else if(markNo>=90 && markNo <= 100) {
				garde = "O";
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return garde;
	}

	@Override
	public List<BatchDetailsBean> getAllBatchDetails(Integer batchId) {
		
		List<BatchDetailsBean> batchDetailsList = new ArrayList<>();
		List<Object[]> objList = null;
		try {
			objList = assesmentMarkRepo.getAllBatchDetails(batchId);
			for (Object[] obj : objList) {
				BatchDetailsBean batch = new BatchDetailsBean();
//				batch.setSlNo(obj[0].toString());
				batch.setBatchName(obj[0].toString());
				batch.setBatchStartDate(obj[1].toString());
				batch.setTechnologyName(obj[2].toString());
				batch.setEmployeeName(obj[3].toString());
				batch.setEmployeePhone(obj[4].toString());
				batch.setMark(obj[5].toString());
				batch.setUBatchId(Integer.valueOf(obj[6].toString()));
				batch.setGrade(getGrade(batch.getMark()));
				batch.setStatus(getStatus(batch.getMark()));
				batchDetailsList.add(batch);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return batchDetailsList;
	}

	@Override
	public AsesmentMark getMarkDetailsByEmpId(BatchDetailsBean batchDetailsBean) {
		
		AsesmentMark asesmentMark = null;
		try {
			Integer empId = batchDetailsBean.getEmpId();
			asesmentMark = assesmentMarkRepo.findByEmpId(batchDetailsBean.getEmpId());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return asesmentMark;
	}

	@Override
	public AsesmentMark saveEmployeeMark(BatchDetailsBean batchDetailsBean) {
		AsesmentMark asessment = null;
		try {
			AsesmentMark asessmentDto = new AsesmentMark();
			asessmentDto.setEmpId(batchDetailsBean.getEmpId());
			asessmentDto.setMarks(Integer.valueOf(batchDetailsBean.getMark()));
			
			asessment = assesmentMarkRepo.save(asessmentDto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return asessment;
		
	}

}
