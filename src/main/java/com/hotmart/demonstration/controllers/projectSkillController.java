package com.hotmart.demonstration.controllers;

import com.hotmart.demonstration.services.ProjectSkillService;

import javax.validation.Valid;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("")
public class projectSkillController {
    
    final ProjectSkillService projectSkillService; 

    public projectSkillController(ProjectSkillService projectSkillService){
        this.projectSkillService = projectSkillService;
    }

    @PostMapping
    
}
