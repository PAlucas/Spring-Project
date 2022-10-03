package com.hotmart.demonstration.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SKILLS")
public class ProjectSkillModel implements Serializable{
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true, length = 255)
    private String skillname;
    @Column(nullable = false, length = 280)
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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    } 
     
    
}
