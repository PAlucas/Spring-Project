package com.hotmart.demonstration.repositories;

import com.hotmart.demonstration.models.ProjectSkillModel;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for decouple purpose
public interface ProjectSkillRepository extends JpaRepository<ProjectSkillModel, Id>{
    
}
