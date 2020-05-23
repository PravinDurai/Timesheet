/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fx.hibernate.application.entity;

import com.fx.hibernate.application.shared.TimeSheetDto;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author admin
 */

@Entity
@Table(name="my_timesheet",schema="sandhata")
public class TimeSheetEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Column(name="user_name")
    private String name; //neConsultantNameCB
    
    @Column(name="enc_user_name")
    private String encUserName;
    
    @Column(name="company_name")
    private String companyName; //neCompanyNameTF
    
    @Column(name="department")
    private String department; //neDepartmentCB
    
    @Column(name="date")
    private Date date; //neDate
    
    @Column(name="proportion")
    private float proportion; //usersDto
    
    @Column(name="project_name")
    private String projectName; //neProjectSelectionNameCB
    
    @Column(name="project_code")
    private String projectCode; //neProjectSelectionCodeCB
    
    @Column(name="comments")
    private String comments; //neCommentsTA

    public TimeSheetEntity() {
        super();
    }

    public TimeSheetEntity(String name, String encUserName, String companyName, String department, Date date, float proportion, String projectName, String projectCode, String comments) {
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

    public TimeSheetEntity(Integer id, String name, String encUserName, String companyName, String department, Date date, float proportion, String projectName, String projectCode, String comments) {
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
    
    public TimeSheetEntity(TimeSheetDto timeSheetDto) {
        super();
        this.name = timeSheetDto.getName();
        this.encUserName = timeSheetDto.getEncUserName();
        this.companyName = timeSheetDto.getCompanyName();
        this.department = timeSheetDto.getDepartment();
        this.date=timeSheetDto.getDate();
        this.proportion = timeSheetDto.getProportion();
        this.projectName = timeSheetDto.getProjectName();
        this.projectCode = timeSheetDto.getProjectCode();
        this.comments = timeSheetDto.getComments();
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

}
