package com.hotmart.demonstration.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProjectSkillDto {
    @NotBlank
    @Size(max = 255)
    private String skillName;
    @NotBlank
    @Size(max = 280)
    private String skillDescription;

    public String getSkillName(){
        return skillName;
    } 

    public String getSkillDescription(){
        return skillDescription;
    } 

    public void setSkillName(String skillName){
        this.skillName = skillName;
    } 

    public void setSkillDescription(String skillDescription){
        this.skillDescription = skillDescription;
    } 
}
