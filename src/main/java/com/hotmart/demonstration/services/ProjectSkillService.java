package com.hotmart.demonstration.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotmart.demonstration.models.ProjectSkillModel;
import com.hotmart.demonstration.repositories.ProjectSkillRepository;
import org.springframework.stereotype.Service;

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

}
