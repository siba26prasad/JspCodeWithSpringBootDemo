package tech.csm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.csm.bean.TechnologyMaster;

public interface TechnologyMasterRepo extends JpaRepository<TechnologyMaster,Integer> {

}
