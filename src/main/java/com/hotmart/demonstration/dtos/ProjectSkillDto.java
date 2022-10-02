package com.hotmart.demonstration.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProjectSkillDto {
    @NotBlank
    @Size(max = 255)
    private String skillname;
    @NotBlank
    @Size(max = 280)
    private String skilldescription;

    public String getSkillName(){
        return skillname;
    } 

    public String getSkillDescription(){
        return skilldescription;
    } 

    public void setSkillName(String skillName){
        this.skillname = skillName;
    } 

    public void setSkillDescription(String skillDescription){
        this.skilldescription = skillDescription;
    } 
}
