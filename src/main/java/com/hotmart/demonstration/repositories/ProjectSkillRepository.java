package com.hotmart.demonstration.repositories;

import com.hotmart.demonstration.models.ProjectSkillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interface for decouple purpose
@Repository
public interface ProjectSkillRepository extends JpaRepository<ProjectSkillModel, Integer>{

    boolean existsBySkillname(String SkillName);
}
