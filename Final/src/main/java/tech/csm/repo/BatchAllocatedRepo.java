package tech.csm.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tech.csm.bean.BatchAllocate;
import tech.csm.bean.EmployeeMaster;


public interface BatchAllocatedRepo extends JpaRepository<BatchAllocate, Integer> {

	List<BatchAllocate> findByBatchIdAndTechnologyId(Integer batchId, Integer technologyId);

	@Transactional
	@Modifying
	@Query(value = "select e.employee_id,e.employee_name from batch_allocate b\r\n"
			+ "inner join employee_master e on b.employee_id = e.employee_id\r\n"
			+ "where b.batch_id = ?1 and b.technology_id= ?2", nativeQuery = true)
	List<Object[]> findEmpByBatchIdAndTechnologyId(Integer batchId, Integer technologyId);

//	@Query("From EmployeeMaster e inner join BatchAllocated b on e.employeeID = b.technologyId "
//			+ "where b.batchId =:batchId and b.technologyId =:technologyId")
//	List<EmployeeMaster> findEmpByBatchIdAndTechnologyId(Integer batchId, Integer technologyId);

//	@Query(name="select e.employeeID,e.employeeName,e.employeePhone,e.employeeEmail  From EmployeeMaster e inner join BatchAllocated b on e.employeeID = b.employeeId "
//			+ "where b.batchId =:batchId and b.technologyId =:technologyId")
//	List<EmployeeMaster> findEmpByBatchIdAndTechnologyId(Integer batchId, Integer technologyId);
}
