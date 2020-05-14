package com.fx.hibernate.application.service.impl;

import com.fx.hibernate.application.entity.DepartmentEntity;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.apache.poi.util.Removal;

import com.fx.hibernate.application.entity.ProjectAssignEntity;
import com.fx.hibernate.application.entity.ProjectInfoEntity;
import com.fx.hibernate.application.entity.TimeSheetEntity;
import com.fx.hibernate.application.entity.UsersEntity;
import com.fx.hibernate.application.security.Security;
import com.fx.hibernate.application.service.SandhataDao;
import com.fx.hibernate.application.shared.DepartmentDto;
import com.fx.hibernate.application.shared.ProjectAssignDto;
import com.fx.hibernate.application.shared.ProjectInfoDto;
import com.fx.hibernate.application.shared.TimeSheetDto;
import com.fx.hibernate.application.shared.UsersDto;
import java.util.HashSet;
import java.util.Set;

import javafx.stage.Modality;

public class SandhataDaoImpl implements SandhataDao {

    private Security security = new Security();

    SessionFactory factory = new Configuration().configure("/resources/hibernate.cfg.xml")
            .addAnnotatedClass(ProjectAssignEntity.class)
            .addAnnotatedClass(UsersEntity.class)
            .addAnnotatedClass(ProjectInfoEntity.class)
            .addAnnotatedClass(DepartmentEntity.class)
            .addAnnotatedClass(TimeSheetEntity.class)
            .buildSessionFactory();

    /*
	 * @Override public void insertIntoUser(UsersDto userDto) { Session session =
	 * factory.getCurrentSession(); Logger logger =
	 * Logger.getLogger(SandhataDaoImpl.class); ModelMapper modelMapper = new
	 * ModelMapper();
	 * modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
	 * ; boolean op = false; try {
	 * 
	 * userDto.setEncPassword(security.encryptOrDecrypt(userDto.getPassword(), 1));
	 * userDto.getUserDetailsDto().setUserId(security.encryptOrDecrypt(userDto.
	 * getUserName(), 1));
	 * 
	 * session.beginTransaction();
	 * 
	 * UsersEntity usersEntity=new UsersEntity(userDto);
	 * session.saveOrUpdate(usersEntity); UsersDto usersDto = new
	 * UsersDto(usersEntity); logger.info("\nThe New Customer Info is \nid :\t" +
	 * usersDto.toString());
	 * System.out.println("\nThe New Customer Info is \nid :\t" +
	 * usersDto.toString()); session.getTransaction().commit(); } catch (Exception
	 * exc) { op = true; logger.error(
	 * "Caught in Exception inside Class :\tCustomerDaoImpl\tMethod :\tcreateCustomer\nAnd the Exception is :\t"
	 * + exc, exc); exc.printStackTrace(); } }
	 * 
	 * @Override public List<UsersDto> getAllUsersInfo() { Session
	 * session=factory.getCurrentSession(); List<UsersDto> userDtoList=new
	 * ArrayList<UsersDto>(); try { session.beginTransaction(); List<UsersEntity>
	 * usersEntityList=(List<UsersEntity>)
	 * session.createQuery(" from UsersEntity").list();
	 * 
	 * for(UsersEntity temp:usersEntityList) { UsersDto usersDto=new UsersDto(temp);
	 * userDtoList.add(usersDto);
	 * //System.out.println("Decrypted User Name is :\t"+security.encryptOrDecrypt(
	 * usersDto.getUserDetailsDto().getUserId(), 2));
	 * //System.out.println("Decrypted Password is :\t"+security.encryptOrDecrypt(
	 * usersDto.getEncPassword(), 2)); } session.getTransaction().commit();
	 * }catch(Exception exc) { exc.printStackTrace(); }finally {
	 * return(userDtoList); } }
     */
    @Override
    public void createNewUser(UsersDto userDto) {

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            userDto.setEncUserName(security.encryptOrDecrypt(userDto.getUserName(), 1));
            userDto.setEncPassword(security.encryptOrDecrypt(userDto.getPassword(), 1));
            UsersEntity usersEntity = new UsersEntity(userDto);
            session.saveOrUpdate(usersEntity);
            System.out.println("\n\nUsers Entity\n\n");
            System.out.println(usersEntity.toString());
            session.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void getAllDepartment(Set<DepartmentDto> departmentDtoList) {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Set<DepartmentEntity> departmentSet = new HashSet<DepartmentEntity>();

            List<DepartmentEntity> departmentList = session.createQuery(" from DepartmentEntity").list();
            for (DepartmentEntity temp : departmentList) {
                DepartmentDto obj = new DepartmentDto(temp);
                departmentDtoList.add(obj);
            }
            session.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void getAllProjects(Set<ProjectInfoDto> projectInfoDto) {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<ProjectInfoEntity> projectInfoList = session.createQuery(" from ProjectInfoEntity").list();
            for (ProjectInfoEntity temp : projectInfoList) {
                ProjectInfoDto obj = new ProjectInfoDto(temp);
                projectInfoDto.add(obj);
            }
            session.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void getUser(String companyName, String department, String projectName, Set<String> consultantNames) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        //usersEntity
        Query query = session.createQuery(" from ProjectAssignEntity where department=:department and projectName=:projectName and usersEntity.companyName=:companyName");
        //Query query = session.createQuery(" from ProjectAssignEntity where department=:department and projectName=:projectName");
        query.setString("department", department);
        query.setString("projectName", projectName);
        query.setString("companyName", companyName);
        List<ProjectAssignEntity> projectAssignEntityList = query.list();
        for (ProjectAssignEntity temp : projectAssignEntityList) {
            System.out.println("Name :\t" + temp.getUsersEntity().getUserName());
            consultantNames.add(temp.getUsersEntity().getUserName());
        }
        session.getTransaction().commit();
    }

    @Override
    public void insertMyTimeSheet(TimeSheetDto timeSheetDto) {
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        TimeSheetEntity timeSheetEntity=new TimeSheetEntity(timeSheetDto);
        session.saveOrUpdate(timeSheetEntity);
        session.getTransaction().commit();
    }

    @Override
    public void getTSReqInfo(String userName, String companyName, String department, String projectName, ProjectAssignDto projectAssignDto) {
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        //from ProjectAssignEntity where department=:department and projectName=:projectName and usersEntity.companyName=:companyName
        Query query=session.createQuery(" from ProjectAssignEntity where department=:department and projectName=:projectName and usersEntity.companyName=:companyName and usersEntity.userName=:userName");
        query.setString("userName", userName);
        query.setString("companyName", companyName);
        query.setString("projectName", projectName);
        query.setString("department", department);
        List<ProjectAssignEntity> usersEntityList=query.list();
        for(ProjectAssignEntity temp:usersEntityList){
            projectAssignDto.setId(temp.getId());
            projectAssignDto.setDepartment(temp.getDepartment());
            projectAssignDto.setProjectCode(temp.getProjectCode());
            projectAssignDto.setProjectName(temp.getProjectName());
            projectAssignDto.setProportion(temp.getProportion());
            projectAssignDto.setUsersDto(temp.getUsersEntity());
            System.out.println(temp.toString());
            break;
        }
        
        session.getTransaction().commit();
    }
}
