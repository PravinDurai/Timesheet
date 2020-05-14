/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fx.hibernate.application.shared;

import com.fx.hibernate.application.entity.ProjectInfoEntity;

/**
 *
 * @author admin
 */
public class ProjectInfoDto {
    
    private int id;
    
    private String projectName;
    
    private String projectCode;
    
    private String description;

    public ProjectInfoDto() {
        super();
    }

    public ProjectInfoDto(ProjectInfoEntity projectInfoEntity) {
        super();
        this.id=projectInfoEntity.getId();
        this.projectName=projectInfoEntity.getProjectName();
        this.projectCode=projectInfoEntity.getProjectCode();
        this.description=projectInfoEntity.getDescription();
    }    
    
    public int getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProjectInfoDto{" + "id=" + id + ", projectName=" + projectName + ", projectCode=" + projectCode + ", description=" + description + '}';
    }
    
}
