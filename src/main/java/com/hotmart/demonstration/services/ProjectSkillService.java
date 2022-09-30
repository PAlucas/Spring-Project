package com.hotmart.demonstration.services;

import org.springframework.stereotype.Service;

import com.hotmart.demonstration.repositories.ProjectSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectSkillService {
    //to make dependency injection
    final ProjectSkillRepository projectSkillRepository;

    public ProjectSkillService(ProjectSkillRepository projectSkillRepository){
        this.projectSkillRepository = projectSkillRepository;
    }
}
