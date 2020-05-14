package com.fx.hibernate.application.service.impl;

import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.fx.hibernate.application.entity.ProjectAssignEntity;
import com.fx.hibernate.application.entity.UsersEntity;
import com.fx.hibernate.application.security.Security;
import com.fx.hibernate.application.service.SandhataDao;
import com.fx.hibernate.application.service.UsersService;
import com.fx.hibernate.application.shared.DepartmentDto;
import com.fx.hibernate.application.shared.ProjectAssignDto;
import com.fx.hibernate.application.shared.ProjectInfoDto;
import com.fx.hibernate.application.shared.TimeSheetDto;
import com.fx.hibernate.application.shared.UsersDto;
import java.util.Set;

public class UsersImpl implements UsersService {

	private SandhataDao sandhataDao=new SandhataDaoImpl();

	@Override
	public void createNewUser(UsersDto userDto) {
		sandhataDao.createNewUser(userDto);
	}

/*
	@Override
	public void insertIntoUser(UsersDto userDto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		sandhataDao.insertIntoUser(userDto);
	}

	@Override
	public List<UsersDto> getAllUsersInfo() {
		List<UsersDto> usersDtoList=sandhataDao.getAllUsersInfo();
		return(usersDtoList);
	}
*/

    @Override
    public void getAllDepartment(Set<DepartmentDto> departmentDto) {
        sandhataDao.getAllDepartment(departmentDto);
    }

    @Override
    public void getAllProjects(Set<ProjectInfoDto> projectInfoDto) {
        sandhataDao.getAllProjects(projectInfoDto);
    }

    @Override
    public void getUser(String companyName, String department, String projectName, Set<String> consultantNames) {
        sandhataDao.getUser(companyName, department, projectName, consultantNames);
    }

    @Override
    public void insertMyTimeSheet(TimeSheetDto timeSheetDto) {
        sandhataDao.insertMyTimeSheet(timeSheetDto);
    }

    @Override
    public void getTSReqInfo(String userName, UsersDto usersDto) {
        sandhataDao.getTSReqInfo(userName, usersDto);
    }
	
}
