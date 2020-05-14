/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fx.hibernate.application.shared;

import com.fx.hibernate.application.entity.DepartmentEntity;

/**
 *
 * @author admin
 */
public class DepartmentDto {
    
    private int id;
    
    private String departmentName;
    
    private String description;

    public DepartmentDto() {
        super();
    }
    
    public DepartmentDto(DepartmentEntity departmentEntity) {
        super();
        this.id=departmentEntity.getId();
        this.departmentName=departmentEntity.getDepartmentName();
        this.description=departmentEntity.getDescription();
    }
    
    public int getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" + "id=" + id + ", departmentName=" + departmentName + ", description=" + description + '}';
    }
    
}
