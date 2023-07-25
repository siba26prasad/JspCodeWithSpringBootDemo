package tech.csm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.bean.TechnologyMaster;
import tech.csm.entity.BatchDetailsBean;
import tech.csm.repo.TechnologyMasterRepo;

@Service
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	private TechnologyMasterRepo technologyMatserRepo;
	@Override
	public List<BatchDetailsBean> getAllTechnology() {
		
		List<BatchDetailsBean> technologyList = new ArrayList<>();
		List<TechnologyMaster> techDtoList = null;
		try {
			techDtoList = technologyMatserRepo.findAll();
			for (TechnologyMaster tm : techDtoList) {
				BatchDetailsBean bean = new BatchDetailsBean();
				bean.setTechnologyId(tm.getTechnologyId());
				bean.setTechnologyName(tm.getTechnologyName());
				technologyList.add(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return technologyList;
	}

}
