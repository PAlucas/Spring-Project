package com.hotmart.demonstration.controllers;

import com.hotmart.demonstration.dtos.ProjectSkillDto;
import com.hotmart.demonstration.models.ProjectSkillModel;
import com.hotmart.demonstration.services.ProjectSkillService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
        projectSkillService.delete(projectSkillModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Skill deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") Integer id, @RequestBody @Valid ProjectSkillDto projectSkillDto){
        Optional<ProjectSkillModel> projectSkillModelOptional = projectSkillService.findById(id);
        if (!projectSkillModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        var projectSkillModel = new ProjectSkillModel();
        BeanUtils.copyProperties(projectSkillDto, projectSkillModel);
        projectSkillModel.setId(projectSkillModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(projectSkillService.save(projectSkillModel));
    }
}
