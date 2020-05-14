package com.fx.hibernate.application.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fx.hibernate.application.shared.ProjectAssignDto;


@Entity
@Table(name = "project_assign", schema = "sandhata")
public class ProjectAssignEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3853616493448323678L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="department")
	private String department;
	
	@Column(name="proportion")
	private float proportion;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private UsersEntity usersEntity;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_code")
	private String projectCode;
	
	public ProjectAssignEntity() {
		super();
	}

	public ProjectAssignEntity(String department, float proportion, String projectName, String projectCode) {
		super();
		this.department = department;
		this.proportion = proportion;
		this.projectName = projectName;
		this.projectCode = projectCode;
	}

	public ProjectAssignEntity(String department, float proportion, UsersEntity usersEntity, String projectName,
			String projectCode) {
		super();
		this.department = department;
		this.proportion = proportion;
		this.usersEntity = usersEntity;
		this.projectName = projectName;
		this.projectCode = projectCode;
	}
	
	public ProjectAssignEntity(int id, String department, float proportion, UsersEntity usersEntity, String projectName,
			String projectCode) {
		super();
		this.id = id;
		this.department = department;
		this.proportion = proportion;
		this.usersEntity = usersEntity;
		this.projectName = projectName;
		this.projectCode = projectCode;
	}
	
	public ProjectAssignEntity(ProjectAssignDto projectAssignDto) {
		super();
		this.department = projectAssignDto.getDepartment();
		this.proportion = projectAssignDto.getProportion();
		this.projectName = projectAssignDto.getProjectName();
		this.projectCode = projectAssignDto.getProjectCode();
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

	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
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
		return "ProjectAssignEntity [id=" + id + ", department=" + department + ", proportion=" + proportion
				+ ", usersEntity=" + usersEntity + ", projectName=" + projectName + ", projectCode=" + projectCode
				+ "]";
	}
}
