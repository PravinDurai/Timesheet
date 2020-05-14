package com.fx.hibernate.application.model;

import com.fx.hibernate.application.shared.ProjectAssignDto;

public class TimeSheetModel {
	
    private Integer id;
    private String name;
    private String encUserName;
    private String companyName;
    private String department;
    private String date;
    private float proportion;
    private String projectName;
    private String projectCode;
    private String comments;

    private static int sn=1;
    
    public TimeSheetModel() {
        super();
    }

    public TimeSheetModel(ProjectAssignDto projectAssignDto,String date, String comments) {
        this.id = sn++;
        this.name = projectAssignDto.getUsersDto().getUserName();
        this.encUserName = projectAssignDto.getUsersDto().getEncUserName();
        this.companyName = projectAssignDto.getUsersDto().getCompanyName();
        this.department = projectAssignDto.getDepartment();
        this.date = date;
        this.proportion = projectAssignDto.getProportion();
        this.projectName = projectAssignDto.getProjectName();
        this.projectCode = projectAssignDto.getProjectCode();
        this.comments = comments;
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

    public String getDate() {
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

    public void setDate(String date) {
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
        return "TimeSheetModel{" + "id=" + id + ", name=" + name + ", encUserName=" + encUserName + ", companyName=" + companyName + ", department=" + department + ", date=" + date + ", proportion=" + proportion + ", projectName=" + projectName + ", projectCode=" + projectCode + ", comments=" + comments + '}';
    }
}
