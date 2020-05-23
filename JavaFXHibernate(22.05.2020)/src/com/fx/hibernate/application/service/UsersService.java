package com.fx.hibernate.application.service;

import com.fx.hibernate.application.model.TimeSheetModel;
import com.fx.hibernate.application.shared.DepartmentDto;
import java.util.List;

import com.fx.hibernate.application.shared.ProjectAssignDto;
import com.fx.hibernate.application.shared.ProjectInfoDto;
import com.fx.hibernate.application.shared.TimeSheetDto;
import com.fx.hibernate.application.shared.UsersDto;
import java.util.Date;
import java.util.Set;

public interface UsersService {
	
	//public void insertIntoUser(UsersDto userDto);
	
	//public List<UsersDto> getAllUsersInfo();
	
	public void createNewUser(UsersDto userDto);
        
        public void getAllDepartment(Set<DepartmentDto> departmentDto);
        
        public void getAllProjects(Set<ProjectInfoDto> projectInfoDto);

        public void getUser(String companyName, String department, String projectName, Set<String> consultantNames);
        
        public void insertMyTimeSheet(TimeSheetModel timeSheetModel);
        
        public void getMyTimeSheet(List<TimeSheetModel> timeSheetModelList, String companyName, String department, String project, String consultantName, Date startDate, Date endDate);       
        
        public void getTSReqInfo(String userName, String company, String department, String projectName, ProjectAssignDto projectAssignDto);
        
}
