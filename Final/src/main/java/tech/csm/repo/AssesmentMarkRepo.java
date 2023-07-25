package tech.csm.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.csm.bean.AsesmentMark;

@Repository
public interface AssesmentMarkRepo extends JpaRepository<AsesmentMark, Integer> {

	@Transactional
	@Modifying
	@Query(value="select BM.batch_name,BM.batch_start_date,TM.technology_name,EM.employee_name,EM.employee_phone,AM.mark from batch_master BM \r\n"
			+ "inner join Batch_Allocate BA on BM.batch_id = BA.batch_id \r\n"
			+ "inner join technology_mater TM on TM.technology_id = BA.technology_id \r\n"
			+ "inner join employee_master EM on EM.employee_id = BA.employee_id \r\n"
			+ "inner join asesment_mark AM on AM.emp_id = EM.employee_id ",nativeQuery = true)

	List<Object[]> getAllBatchDetails();
	
	@Transactional
	@Modifying
	@Query(value="select BM.batch_name,BM.batch_start_date,TM.technology_name,EM.employee_name,EM.employee_phone,AM.mark,BM.batch_id from batch_master BM \r\n"
			+ "inner join Batch_Allocate BA on BM.batch_id = BA.batch_id \r\n"
			+ "inner join technology_mater TM on TM.technology_id = BA.technology_id \r\n"
			+ "inner join employee_master EM on EM.employee_id = BA.employee_id \r\n"
			+ "inner join asesment_mark AM on AM.emp_id = EM.employee_id where BM.batch_id= ?1 ",nativeQuery = true)


	List<Object[]> getAllBatchDetails(Integer batchId);

	AsesmentMark findByEmpId(Integer empId);

}
