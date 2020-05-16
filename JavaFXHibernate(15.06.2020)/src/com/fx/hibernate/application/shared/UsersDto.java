package com.fx.hibernate.application.shared;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fx.hibernate.application.entity.ProjectAssignEntity;
import com.fx.hibernate.application.entity.UsersEntity;

public class UsersDto {

    private int userId;

    private String userName;

    private String encUserName;

    private String password;

    private String encPassword;

    private int accessLevel;

    private String companyName;

    private List<ProjectAssignDto> projectAssignList;

    public UsersDto() {
        super();
    }

    public UsersDto(String userName, String encUserName, String password, String encPassword, int accessLevel,
            String companyName) {
        super();
        this.userName = userName;
        this.encUserName = encUserName;
        this.password = password;
        this.encPassword = encPassword;
        this.accessLevel = accessLevel;
        this.companyName = companyName;
    }

    public UsersDto(String userName, String encUserName, String password, String encPassword, int accessLevel,
            String companyName, List<ProjectAssignDto> projectAssignList) {
        super();
        this.userName = userName;
        this.encUserName = encUserName;
        this.password = password;
        this.encPassword = encPassword;
        this.accessLevel = accessLevel;
        this.companyName = companyName;
        this.projectAssignList = projectAssignList;
    }

    public UsersDto(int userId, String userName, String encUserName, String password, String encPassword,
            int accessLevel, String companyName, List<ProjectAssignDto> projectAssignList) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.encUserName = encUserName;
        this.password = password;
        this.encPassword = encPassword;
        this.accessLevel = accessLevel;
        this.companyName = companyName;
        this.projectAssignList = projectAssignList;
    }

    public UsersDto(int userId, String userName, String encUserName, String password, String encPassword,
            int accessLevel, String companyName) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.encUserName = encUserName;
        this.password = password;
        this.encPassword = encPassword;
        this.accessLevel = accessLevel;
        this.companyName = companyName;
    }

    public UsersDto(UsersEntity usersEntity) {
        this.userId = usersEntity.getUserId();
        this.userName = usersEntity.getUserName();
        this.encUserName = usersEntity.getEncUserName();
        this.password = usersEntity.getPassword();
        this.encPassword = usersEntity.getEncPassword();
        this.accessLevel = usersEntity.getAccessLevel();
        this.companyName = usersEntity.getCompanyName();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncUserName() {
        return encUserName;
    }

    public void setEncUserName(String encUserName) {
        this.encUserName = encUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncPassword() {
        return encPassword;
    }

    public void setEncPassword(String encPassword) {
        this.encPassword = encPassword;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<ProjectAssignDto> getProjectAssignList() {
        return projectAssignList;
    }

    public void setProjectAssignList(List<ProjectAssignDto> projectAssignList) {
        this.projectAssignList = projectAssignList;
    }

    public void setUsersDto(UsersEntity usersEntity) {
        this.userId = usersEntity.getUserId();
        this.userName = usersEntity.getUserName();
        this.encUserName = usersEntity.getEncUserName();
        this.password = usersEntity.getPassword();
        this.encPassword = usersEntity.getEncPassword();
        this.accessLevel = usersEntity.getAccessLevel();
        this.companyName = usersEntity.getCompanyName();
    }

    @Override
    public String toString() {
        return "UsersDto [userId=" + userId + ", userName=" + userName + ", encUserName=" + encUserName + ", password="
                + password + ", encPassword=" + encPassword + ", accessLevel=" + accessLevel + ", companyName="
                + companyName + ", projectAssignList=" + projectAssignList + "]";
    }

    public void addUsersDto(ProjectAssignDto projectAssign) {
        if (projectAssignList == null) {
            projectAssignList = new ArrayList<ProjectAssignDto>();
        }
        projectAssignList.add(projectAssign);
        projectAssign.setUsersDto(this);
    }
}
