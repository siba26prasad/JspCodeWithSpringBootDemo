package tech.csm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.csm.bean.BatchMaster;

@Repository
public interface BatchMasterRepo extends JpaRepository<BatchMaster, Integer> {

}
