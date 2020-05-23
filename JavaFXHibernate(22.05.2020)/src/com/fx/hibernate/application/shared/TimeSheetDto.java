/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fx.hibernate.application.shared;

import com.fx.hibernate.application.entity.TimeSheetEntity;
import com.fx.hibernate.application.model.TimeSheetModel;
import java.util.Date;

/**
 *
 * @author admin
 */
public class TimeSheetDto {
    
    private Integer id;
    private String name;
    private String encUserName;
    private String companyName;
    private String department;
    private Date date;
    private float proportion;
    private String projectName;
    private String projectCode;
    private String comments;
    private static int sn=1;

    public TimeSheetDto() {
        super();
    }

    public TimeSheetDto(String name, String encUserName, String companyName, String department, Date date, float proportion, String projectName, String projectCode, String comments) {
        super();
        this.name = name;
        this.encUserName = encUserName;
        this.companyName = companyName;
        this.department = department;
        this.date = date;
        this.proportion = proportion;
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.comments = comments;
    }

    public TimeSheetDto(Integer id, String name, String encUserName, String companyName, String department, Date date, float proportion, String projectName, String projectCode, String comments) {
        super();
        this.id = id;
        this.name = name;
        this.encUserName = encUserName;
        this.companyName = companyName;
        this.department = department;
        this.date = date;
        this.proportion = proportion;
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.comments = comments;
    }
    
    public TimeSheetDto(TimeSheetEntity timeSheetEntity) {
        super();
        this.id = timeSheetEntity.getId();
        this.name = timeSheetEntity.getName();
        this.encUserName = timeSheetEntity.getEncUserName();
        this.companyName = timeSheetEntity.getCompanyName();
        this.department = timeSheetEntity.getDepartment();
        this.date = timeSheetEntity.getDate();
        this.proportion = timeSheetEntity.getProportion();
        this.projectName = timeSheetEntity.getProjectName();
        this.projectCode = timeSheetEntity.getProjectCode();
        this.comments = timeSheetEntity.getComments();
    }
    
    public TimeSheetDto(TimeSheetModel timeSheetModel) {
        super();
        this.id = timeSheetModel.getId();
        this.name = timeSheetModel.getName();
        this.encUserName = timeSheetModel.getEncUserName();
        this.companyName = timeSheetModel.getCompanyName();
        this.department = timeSheetModel.getDepartment();
        this.date = timeSheetModel.getDate();
        this.proportion = timeSheetModel.getProportion();
        this.projectName = timeSheetModel.getProjectName();
        this.projectCode = timeSheetModel.getProjectCode();
        this.comments = timeSheetModel.getComments();
    }
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEncUserName() {
        return encUserName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDepartment() {
        return department;
    }

    public Date getDate() {
        return date;
    }

    public float getProportion() {
        return proportion;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getComments() {
        return comments;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEncUserName(String encUserName) {
        this.encUserName = encUserName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setProportion(float proportion) {
        this.proportion = proportion;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "TimeSheetDto{" + "id=" + id + ", name=" + name + ", encUserName=" + encUserName + ", companyName=" + companyName + ", department=" + department + ", date=" + date + ", proportion=" + proportion + ", projectName=" + projectName + ", projectCode=" + projectCode + ", comments=" + comments + '}';
    }
}
