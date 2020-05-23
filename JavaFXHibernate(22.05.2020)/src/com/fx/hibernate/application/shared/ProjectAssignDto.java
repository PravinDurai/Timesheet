package com.fx.hibernate.application.shared;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fx.hibernate.application.entity.UsersEntity;
import com.fx.hibernate.application.entity.ProjectAssignEntity;

public class ProjectAssignDto { 

	private int id;
	
	private String department;
	
	private float proportion;
	
	private UsersDto usersDto;
	
	private String projectName;
	
	private String projectCode;
	
	public ProjectAssignDto() {
		super();
	}
	
	public ProjectAssignDto(String department, float proportion, String projectName, String projectCode) {
		super();
		this.department = department;
		this.proportion = proportion;
		this.projectName = projectName;
		this.projectCode = projectCode;
	}

	public ProjectAssignDto(String department, float proportion, UsersDto usersDto, String projectName,
			String projectCode) {
		super();
		this.department = department;
		this.proportion = proportion;
		this.usersDto = usersDto;
		this.projectName = projectName;
		this.projectCode = projectCode;
	}

	public ProjectAssignDto(int id, String department, float proportion, UsersDto usersDto, String projectName,
			String projectCode) {
		super();
		this.id = id;
		this.department = department;
		this.proportion = proportion;
		this.usersDto = usersDto;
		this.projectName = projectName;
		this.projectCode = projectCode;
	}
        
        public ProjectAssignDto(ProjectAssignEntity projectAssignEntity) {
		super();
		this.id = projectAssignEntity.getId();
		this.department = projectAssignEntity.getDepartment();
		this.proportion = projectAssignEntity.getProportion();
                this.usersDto = new UsersDto(projectAssignEntity.getUsersEntity().getUserId(),projectAssignEntity.getUsersEntity().getUserName(),projectAssignEntity.getUsersEntity().getEncUserName(),projectAssignEntity.getUsersEntity().getPassword(),projectAssignEntity.getUsersEntity().getEncPassword(),projectAssignEntity.getUsersEntity().getAccessLevel(),projectAssignEntity.getUsersEntity().getCompanyName());
		this.projectName = projectName;
		this.projectCode = projectCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getProportion() {
		return proportion;
	}

	public void setProportion(float proportion) {
		this.proportion = proportion;
	}

	public UsersDto getUsersDto() {
		return usersDto;
	}

	public void setUsersDto(UsersDto usersDto) {
		this.usersDto = usersDto;
	}
        
        public void setUsersDto(UsersEntity userEntity) {
		this.usersDto=new UsersDto(userEntity);
                //this.usersDto.setUsersDto(userEntity);
	}
        
        public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@Override
	public String toString() {
		return "ProjectAssignDto [id=" + id + ", department=" + department + ", proportion=" + proportion
				+ ", usersDto=" + usersDto + ", projectName=" + projectName + ", projectCode=" + projectCode
				+ "]";
	}	
}
