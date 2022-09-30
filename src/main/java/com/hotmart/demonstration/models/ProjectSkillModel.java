package com.hotmart.demonstration.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PROJECTSKILLS")
public class ProjectSkillModel {
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true, length = 255)
    private String skillName;
    @Column(nullable = false, length = 280)
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
