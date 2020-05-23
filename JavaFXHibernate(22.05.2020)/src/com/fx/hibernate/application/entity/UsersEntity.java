package com.fx.hibernate.application.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fx.hibernate.application.shared.UsersDto;
import com.fx.hibernate.application.shared.ProjectAssignDto;

@Entity
@Table(name = "users", schema = "sandhata")
public class UsersEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7260193999675448112L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="enc_user_name")
	private String encUserName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enc_password")
	private String encPassword;
	
	@Column(name="access_level")
	private int accessLevel;
	
	@Column(name="company_name")
	private String companyName;

	@OneToMany(mappedBy="usersEntity",cascade=CascadeType.ALL)
	private List<ProjectAssignEntity> projectAssignList=new ArrayList<ProjectAssignEntity>();
	
	public UsersEntity() {
		super();
	}
	
	public UsersEntity(String userName, String encUserName, String password, String encPassword, int accessLevel,
			String companyName) {
		super();
		this.userName = userName;
		this.encUserName = encUserName;
		this.password = password;
		this.encPassword = encPassword;
		this.accessLevel = accessLevel;
		this.companyName = companyName;
	}
	
	public UsersEntity(String userName, String encUserName, String password, String encPassword, int accessLevel,
			String companyName, List<ProjectAssignEntity> projectAssignList) {
		super();
		this.userName = userName;
		this.encUserName = encUserName;
		this.password = password;
		this.encPassword = encPassword;
		this.accessLevel = accessLevel;
		this.companyName = companyName;
		this.projectAssignList = projectAssignList;
	}

	public UsersEntity(int userId, String userName, String encUserName, String password, String encPassword,
			int accessLevel, String companyName, List<ProjectAssignEntity> projectAssignList) {
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
	
	public UsersEntity(UsersDto usersDto ) {
		super();
		this.userName = usersDto.getUserName();
		this.encUserName = usersDto.getEncUserName();
		this.password = usersDto.getPassword();
		this.encPassword = usersDto.getEncPassword();
		this.accessLevel = usersDto.getAccessLevel();
		this.companyName = usersDto.getCompanyName();
		for(ProjectAssignDto temp:usersDto.getProjectAssignList()) {
			ProjectAssignEntity projectEntity=new ProjectAssignEntity(temp);
			addUserEntity(projectEntity);
		}
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

	public List<ProjectAssignEntity> getProjectAssignList() {
		return projectAssignList;
	}

	public void setProjectAssignList(List<ProjectAssignEntity> projectAssignList) {
		this.projectAssignList = projectAssignList;
	}

	@Override
	public String toString() {
		return "UsersEntity [userId=" + userId + ", userName=" + userName + ", encUserName=" + encUserName
				+ ", password=" + password + ", encPassword=" + encPassword + ", accessLevel=" + accessLevel
				+ ", companyName=" + companyName + "]";
	}
	
	public void addUserEntity(ProjectAssignEntity projectAssign) {
		if(projectAssignList==null) {
			projectAssignList=new ArrayList<ProjectAssignEntity>();
		}
		projectAssignList.add(projectAssign);
		projectAssign.setUsersEntity(this);
	}
}
