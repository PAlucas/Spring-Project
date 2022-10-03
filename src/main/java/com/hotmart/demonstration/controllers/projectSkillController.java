package com.hotmart.demonstration.controllers;

import com.hotmart.demonstration.dtos.ProjectSkillDto;
import com.hotmart.demonstration.models.ProjectSkillModel;
import com.hotmart.demonstration.services.ProjectSkillService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping
    public ResponseEntity<List<ProjectSkillModel>> getAllProjectSkills(){
        return ResponseEntity.status(HttpStatus.OK).body(projectSkillService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") Integer id){
        Optional<ProjectSkillModel> projectSkillModelOptional = projectSkillService.findById(id);
        if (!projectSkillModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        return ResponseEntity.status(HttpStatus.OK).body(projectSkillModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") Integer id){
        Optional<ProjectSkillModel> projectSkillModelOptional = projectSkillService.findById(id);
        if (!projectSkillModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        StringBuilder SucessfullMessage = new StringBuilder();
        String skill = projectSkillService.delete(projectSkillModelOptional.get());
        SucessfullMessage.append("Skill ").append(skill).append(" deleted successfully.");
        
         
        return ResponseEntity.status(HttpStatus.OK).body(SucessfullMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSkill(@PathVariable(value = "id") Integer id, @RequestBody @Valid ProjectSkillDto projectSkillDto){
        Optional<ProjectSkillModel> projectSkillModelOptional = projectSkillService.findById(id);
        if (!projectSkillModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        var projectSkillModel = new ProjectSkillModel();
        BeanUtils.copyProperties(projectSkillDto, projectSkillModel);
        projectSkillModel.setId(projectSkillModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(projectSkillService.save(projectSkillModel));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchSkill(@PathVariable(value = "id") Integer id, @RequestBody @Valid Map<Object, Object> projectSkillDto){
        Optional<ProjectSkillModel> projectSkillModelOptional = projectSkillService.findById(id);
        if(!projectSkillModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        projectSkillDto.forEach((key, value) ->{
            String keyName = (String) key;
            Field field = org.springframework.util.ReflectionUtils.findField(ProjectSkillModel.class,  keyName.toLowerCase());
            ReflectionUtils.setField(field, projectSkillModelOptional.get(), value);
        });
        var projectSkillModel = new ProjectSkillModel();
        BeanUtils.copyProperties(projectSkillModelOptional.get(), projectSkillModel);
        return ResponseEntity.status(HttpStatus.OK).body(projectSkillService.save(projectSkillModel));
        
    }
}
