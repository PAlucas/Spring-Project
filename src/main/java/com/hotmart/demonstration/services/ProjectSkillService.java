package com.hotmart.demonstration.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotmart.demonstration.models.ProjectSkillModel;
import com.hotmart.demonstration.repositories.ProjectSkillRepository;

@Service
public class ProjectSkillService {
    //to make dependency injection
    @Autowired
    private ProjectSkillRepository projectSkillRepository;

    @Transactional
    public ProjectSkillModel save(ProjectSkillModel projectSkillModel) {
        return projectSkillRepository.save(projectSkillModel);
    }

    public boolean existsBySkillName(String skillName) {
        return projectSkillRepository.existsBySkillname(skillName);
    }

    public List<ProjectSkillModel> findAll(){
        return projectSkillRepository.findAll();
    }

    public Optional<ProjectSkillModel> findById(Integer id) {
        return projectSkillRepository.findById(id);
    }

    @Transactional
    public String delete(ProjectSkillModel projectSkillModel) {
        String name = projectSkillModel.getSkillName();
        projectSkillRepository.delete(projectSkillModel);
        return name;
    }
    

}
