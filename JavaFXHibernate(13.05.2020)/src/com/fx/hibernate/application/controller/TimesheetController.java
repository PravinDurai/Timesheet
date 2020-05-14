/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fx.hibernate.application.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.fx.hibernate.application.model.TimeSheetModel;
import com.fx.hibernate.application.service.UsersService;
import com.fx.hibernate.application.service.impl.UsersImpl;
import com.fx.hibernate.application.shared.DepartmentDto;
import com.fx.hibernate.application.shared.ProjectAssignDto;
import com.fx.hibernate.application.shared.ProjectInfoDto;
import com.fx.hibernate.application.shared.UsersDto;
import com.fx.hibernate.application.model.TimeSheetModel;
import com.fx.hibernate.application.shared.TimeSheetDto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class TimesheetController implements Initializable {

    @FXML
    private ComboBox<String> neConsultantNameCB;
    @FXML
    private TextField neCompanyNameTF;
    @FXML
    private ChoiceBox<String> neDepartmentCB;
    @FXML
    private RadioButton neProjectSelectionNameRB;
    @FXML
    private ToggleGroup projectSelection;
    @FXML
    private RadioButton neProjectSelectionCodeRB;
    @FXML
    private ComboBox<String> neProjectSelectionNameCB;
    @FXML
    private ComboBox<String> neProjectSelectionCodeCB;
    @FXML
    private DatePicker neDate;
    @FXML
    private TextArea neCommentsTA;
    @FXML
    private Button neAddDataB;
    @FXML
    private TableView<TimeSheetModel> addEntryTableView;
    @FXML
    private TableColumn<TimeSheetModel, Integer> neIdTC;
    @FXML
    private TableColumn<TimeSheetModel, String> neNameTC;
    @FXML
    private TableColumn<TimeSheetModel, String> neCompanyTC;
    @FXML
    private TableColumn<TimeSheetModel, String> neDepartmentTC;
    @FXML
    private TableColumn<TimeSheetModel, String> neProjectNameTC;
    @FXML
    private TableColumn<TimeSheetModel, String> neProjectCodeTC;
    @FXML
    private TableColumn<TimeSheetModel, Float> neProportionTC;
    @FXML
    private TableColumn<TimeSheetModel, String> Comment;

    private Map<String, String> projectNameMap = new HashMap<String, String>();
    private Map<String, String> projectCodeMap = new HashMap<String, String>();
    private Set companyName = new HashSet<String>();

    private Set<String> consultanNameList = new HashSet<String>();
    private Set<DepartmentDto> departmentList = new HashSet<DepartmentDto>();
    private Set<ProjectInfoDto> projectInfoList = new HashSet<ProjectInfoDto>();
    private ObservableList<TimeSheetModel> timeSheetModelList = FXCollections.observableArrayList();
    private TimeSheetDto timeSheetDto;
    private ProjectAssignDto projectAssignDto = new ProjectAssignDto();

    private UsersService usersService = new UsersImpl();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int i = 0;

        usersService.getAllDepartment(departmentList);

        usersService.getAllProjects(projectInfoList);

        for (DepartmentDto temp : departmentList) {
            neDepartmentCB.getItems().add(i++, temp.getDepartmentName());
        }
        i = 0;
        for (ProjectInfoDto temp : projectInfoList) {
            projectNameMap.put(temp.getProjectCode(), temp.getProjectName());
            projectCodeMap.put(temp.getProjectName(), temp.getProjectCode());
            neProjectSelectionNameCB.getItems().add(i, temp.getProjectName());
            neProjectSelectionCodeCB.getItems().add(i++, temp.getProjectCode());
        }

        //Disiabling the combo box based on the radio button that is been selected
        neProjectSelectionNameCB.setDisable(false);
        neProjectSelectionCodeCB.setDisable(true);

        //Initializing the Table view
        neIdTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, Integer>("id"));
        neNameTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("name"));
        neCompanyTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("companyName"));
        neDepartmentTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("department"));
        neProjectNameTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("projectName"));
        neProjectCodeTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("projectCode"));
        neProportionTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, Float>("proportion"));
        Comment.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("comments"));

    }

    @FXML
    private void neConsultantNameChoiceBoxAction(ActionEvent event) {
        usersService.getTSReqInfo(neConsultantNameCB.getValue(), neCompanyNameTF.getText(), neDepartmentCB.getValue(), neProjectSelectionNameCB.getValue(), projectAssignDto);
        System.out.println("Project Assign Dto\n" + projectAssignDto);
    }

    @FXML
    private void neDepartmentSelectionChoiceBox(InputMethodEvent event) {
    }

    @FXML
    private void enableNameCB(ActionEvent event) {
        neProjectSelectionNameCB.setDisable(false);
        neProjectSelectionCodeCB.setDisable(true);
    }

    @FXML
    private void enableCodeCB(ActionEvent event) {
        neProjectSelectionNameCB.setDisable(true);
        neProjectSelectionCodeCB.setDisable(false);
    }

    @FXML
    private void neProjectSelectionComboBoxName(ActionEvent event) {
        neProjectSelectionCodeCB.setValue(projectCodeMap.get(neProjectSelectionNameCB.getValue()));
        consultanNameList.clear();
        neConsultantNameCB.getItems().clear();
        System.out.println("\nName ComboBox\nCompany Name :\t" + neCompanyNameTF.getText() + "\nDepartment :\t" + neDepartmentCB.getValue() + "\nProject Name :\t" + neProjectSelectionNameCB.getValue());
        boolean error = false;
        String errorMessage = "";
        //validation
        //System.out.println("TF Content(Object) :\t"+neCompanyNameTF+"\nTF Content(Object To String) :\t"+neCompanyNameTF.toString()+"\nTF String Value :"+neCompanyNameTF.getText().equalsIgnoreCase("")+"value");
        if (neCompanyNameTF == null || neCompanyNameTF.getText().equalsIgnoreCase("")) {
            errorMessage = "Company name is missing\nPlease Enter the company name and try again...\nSorry for the in-convienence";
            error = true;
        }
        if (!error) {
            getAllConsultant(neCompanyNameTF.getText(), neDepartmentCB.getValue(), neProjectSelectionNameCB.getValue(), consultanNameList);
            neConsultantNameCB.getItems().addAll(consultanNameList);
        } else {
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void neProjectSelectionChoiceBoxCode(ActionEvent event) {
        neProjectSelectionNameCB.setValue(projectNameMap.get(neProjectSelectionCodeCB.getValue()));
    }

    @FXML
    private void dateSelection(ActionEvent event) {
    }

    @FXML
    private void addData(ActionEvent event) {
        String errorMessage = "";
        boolean error = false;
        //Check if consultant name and date is there if yes then go ahead else throw error message
        if (neConsultantNameCB == null || neConsultantNameCB.getValue().equalsIgnoreCase("")) {
            errorMessage += "Consultant name is missing";
            error = true;
        }
        if (neDate == null || neDate.getValue().equals(null)) {
            if (error) {
                errorMessage += "\nDate is missing";
            } else {
                errorMessage += "Date is missing";
            }
        }
        if (error) {
            errorMessage += "\nPlease correct the above errors and then proceed...";
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //insert the values to mytimesheet table
            TimeSheetModel timeSheetModel = new TimeSheetModel(projectAssignDto, neDate.getValue().toString(), neCommentsTA.getText());
            timeSheetModelList.add(timeSheetModel);
            addEntryTableView.setItems(timeSheetModelList);//getItems().add(timeSheetModel);
        }
    }

    @FXML
    private void addEntryTableViewSort(SortEvent<TimeSheetModel> event) {

    }

    public void getAllConsultant(String companyName, String department, String projectName, Set<String> consultanNameList) {
        usersService.getUser(companyName, department, projectName, consultanNameList);
    }

//        Creating New User and mapping them against the project all done in a single Query
//        UsersDto userDto = new UsersDto("Navin", "", "Password@1234", "", 1, "Sandhata");
//        List<ProjectAssignDto> projectAssignDtoList = new ArrayList<ProjectAssignDto>();
//        ProjectAssignDto projectAssignDto1 = new ProjectAssignDto("Development", 0.5F, "EMC-PPMG-AO", "ECS1234");
//        ProjectAssignDto projectAssignDto2 = new ProjectAssignDto("DevOps", 0.5F, "Coty", "Cot234");
//        userDto.addUsersDto(projectAssignDto1);
//        userDto.addUsersDto(projectAssignDto2);
//        usersService.createNewUser(userDto);
}
