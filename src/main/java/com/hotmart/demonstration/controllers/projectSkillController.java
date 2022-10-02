package com.hotmart.demonstration.controllers;

import com.hotmart.demonstration.dtos.ProjectSkillDto;
import com.hotmart.demonstration.models.ProjectSkillModel;
import com.hotmart.demonstration.services.ProjectSkillService;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("")
public class projectSkillController { 

    
    @Autowired
    private ProjectSkillService projectSkillService;

    /*
     * Post method receive dto to pass info to model
     */
    @PostMapping()
    public @ResponseBody ResponseEntity<Object> addNewUser (@RequestBody @Valid ProjectSkillDto projectSkillDto) {
        // to grant that dont have that skill name in the database
        if(projectSkillService.existsBySkillName(projectSkillDto.getSkillName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already have this name in database !");
        }

        ProjectSkillModel projectSkillModel = new ProjectSkillModel();
        BeanUtils.copyProperties(projectSkillDto, projectSkillModel);
        projectSkillService.save(projectSkillModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(projectSkillService.save(projectSkillModel));
    }
    
}
