package com.anshuman.springbootmongo.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "jobs")
public class Job {


    //Model package stores POJO (Plain Old Java object)
    private String id;
    private String name;
    private String desc;
    private String exp;
    private String[] skills;

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }

    public String getExp(){
        return exp;
    }
    public String[] getSkills(){
        return skills;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public void setExp(String exp){
        this.exp = exp;
    }
    public void setSkills(String[] skills){
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", exp='" + exp + '\'' +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }
}
