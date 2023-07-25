package tech.csm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.csm.bean.EmployeeMaster;

public interface EmployeeMasterRepo extends JpaRepository<EmployeeMaster, Integer> {

	EmployeeMaster findByEmployeeID(Integer employeeId);

}
