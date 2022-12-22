package com.anshuman.springbootmongo.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "jobs")
public class Job {


    //Model package stores POJO (Plain Old Java object)
    private String name;
    private String des;
    private String exp;
    private String[] skills;

    public String getName(){
        return name;
    }

    public String getDes(){
        return des;
    }

    public String getYearsOfExp(){
        return exp;
    }
    public String[] getSkills(){
        return skills;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String des){
        this.des = des;
    }
    public void setYearsOfExperience(String exp){
        this.exp = exp;
    }
    public void setSkills(String[] skills){
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", description='" + des + '\'' +
                ", yearsOfExperience='" + exp + '\'' +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }
}
