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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputMethodEvent;
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
    private TableColumn<TimeSheetModel, Date> neDateTC;
    @FXML
    private TableColumn<TimeSheetModel, String> neDepartmentTC;
    @FXML
    private TableColumn<TimeSheetModel, String> neCompanyTC;
    @FXML
    private TableColumn<TimeSheetModel, String> neProjectNameTC;
    @FXML
    private TableColumn<TimeSheetModel, String> neProjectCodeTC;
    @FXML
    private TableColumn<TimeSheetModel, Float> neProportionTC;
    @FXML
    private TableColumn<TimeSheetModel, String> Comment;
    @FXML
    private TableView<TimeSheetModel> udEntryTableView1;
    @FXML
    private TableColumn<TimeSheetModel, Integer> udIdTC;
    @FXML
    private TableColumn<TimeSheetModel, String> udNameTC;
    @FXML
    private TableColumn<TimeSheetModel, Date> udDateTC;
    @FXML
    private TableColumn<TimeSheetModel, String> udCompanyTC;
    @FXML
    private TableColumn<TimeSheetModel, String> udDepartmentTC;
    @FXML
    private TableColumn<TimeSheetModel, String> udProjectNameTC;
    @FXML
    private TableColumn<TimeSheetModel, String> udProjectCodeTC;
    @FXML
    private TableColumn<TimeSheetModel, Float> udProportionTC;
    @FXML
    private TableColumn<TimeSheetModel, String> udComment;
    @FXML
    private Button udDeleteButton;
    @FXML
    private DatePicker udStartDate;
    @FXML
    private DatePicker udEndDate;
    @FXML
    private Button udUpdateButton;
    @FXML
    private Button udSearchButton;
    @FXML
    private TextField udCompanyNameTF;
    @FXML
    private ChoiceBox<String> udDepartmentCB;
    @FXML
    private RadioButton udProjectSelectionNameRB;
    @FXML
    private ToggleGroup projectSelection1;
    @FXML
    private RadioButton udProjectSelectionCodeRB1;
    @FXML
    private ComboBox<String> udProjectSelectionNameCB;
    @FXML
    private ComboBox<String> udProjectSelectionCodeCB;
    @FXML
    private ComboBox<String> udConsultantNameCB;

    private Map<String, String> projectNameMap = new HashMap<String, String>();
    private Map<String, String> projectCodeMap = new HashMap<String, String>();
    private Set companyName = new HashSet<String>();

    private Set<String> consultanNameList = new HashSet<String>();
    private Set<DepartmentDto> departmentList = new HashSet<DepartmentDto>();
    private Set<ProjectInfoDto> projectInfoList = new HashSet<ProjectInfoDto>();
    private ObservableList<TimeSheetModel> neTimeSheetModelList = FXCollections.observableArrayList();
    private ObservableList<TimeSheetModel> udTimeSheetModelList = FXCollections.observableArrayList();
    private TimeSheetDto timeSheetDto;
    private ProjectAssignDto projectAssignDto = new ProjectAssignDto();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private UsersService usersService = new UsersImpl();

    Date finalStartDate;
    Date finalEndDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int i = 0;

        usersService.getAllDepartment(departmentList);

        usersService.getAllProjects(projectInfoList);

        for (DepartmentDto temp : departmentList) {
            neDepartmentCB.getItems().add(i, temp.getDepartmentName());
            udDepartmentCB.getItems().add(i++, temp.getDepartmentName());
        }
        i = 0;
        for (ProjectInfoDto temp : projectInfoList) {
            projectNameMap.put(temp.getProjectCode(), temp.getProjectName());
            projectCodeMap.put(temp.getProjectName(), temp.getProjectCode());
            neProjectSelectionNameCB.getItems().add(i, temp.getProjectName());
            neProjectSelectionCodeCB.getItems().add(i, temp.getProjectCode());

            udProjectSelectionNameCB.getItems().add(i, temp.getProjectName());
            udProjectSelectionCodeCB.getItems().add(i++, temp.getProjectCode());
        }
        //Disiabling the combo box based on the radio button that is been selected
        neProjectSelectionNameCB.setDisable(false);
        neProjectSelectionCodeCB.setDisable(true);

        udProjectSelectionNameCB.setDisable(false);
        udProjectSelectionCodeCB.setDisable(true);

        //Initializing the Table view
        neIdTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, Integer>("id"));
        neNameTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("name"));
        neDateTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, Date>("date"));
        neCompanyTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("companyName"));
        neDepartmentTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("department"));
        neProjectNameTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("projectName"));
        neProjectCodeTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("projectCode"));
        neProportionTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, Float>("proportion"));
        Comment.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("comments"));
        TableViewSelectionModel<TimeSheetModel> neTimeSheetModelList = addEntryTableView.getSelectionModel();

        udIdTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, Integer>("id"));
        udNameTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("name"));
        udDateTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, Date>("date"));
        udCompanyTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("companyName"));
        udDepartmentTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("department"));
        udProjectNameTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("projectName"));
        udProjectCodeTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("projectCode"));
        udProportionTC.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, Float>("proportion"));
        udComment.setCellValueFactory(new PropertyValueFactory<TimeSheetModel, String>("comments"));
        TableViewSelectionModel<TimeSheetModel> udTimeSheetModelList = addEntryTableView.getSelectionModel();
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
            try {
                //insert the values to mytimesheet table
                Date date1 = new Date();//neDate.getValue();
                date1.setDate(neDate.getValue().getDayOfMonth());
                date1.setMonth(neDate.getValue().getMonthValue() - 1);
                date1.setYear(neDate.getValue().getYear() - 1900);
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                String dat = sdf.format(date1);
                System.out.println("Date in String Format :\t" + dat + "\nDate :\t" + sdf.parse(dat));
                TimeSheetModel timeSheetModel = new TimeSheetModel(projectAssignDto, dat, neCommentsTA.getText());
                neTimeSheetModelList.add(timeSheetModel);
                addEntryTableView.setItems(neTimeSheetModelList);
                usersService.insertMyTimeSheet(timeSheetModel);
            } catch (Exception exc) {
                exc.printStackTrace();
                System.out.println("Caught in exception inside Class :TimeSheetController\tMethod :\taddData\nAnd the Exception is :\t" + exc);
            }
        }
    }

    @FXML
    private void addEntryTableViewSort(SortEvent<TimeSheetModel> event) {
    }

    @FXML
    private void udEntryTableViewSort(SortEvent<TimeSheetModel> event) {
    }

    @FXML
    private void udDeleteButtonAction(ActionEvent event) {
    }

    @FXML
    private void udStartDateSelection(ActionEvent event) {
    }

    @FXML
    private void udEndDateSelection(ActionEvent event) throws ParseException {
//      validate if the end date is after the start date
//      Also validate if the end date is just 1 month difference from the start date

        Date date1 = new Date();
        date1.setDate(udStartDate.getValue().getDayOfMonth());
        date1.setMonth(udStartDate.getValue().getMonthValue() - 1);
        date1.setYear(udStartDate.getValue().getYear() - 1900);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dat1 = sdf.format(date1);
        finalStartDate=sdf.parse(dat1);
        
        Date date2 = new Date();
        date2.setDate(udEndDate.getValue().getDayOfMonth());
        date2.setMonth(udEndDate.getValue().getMonthValue() - 1);
        date2.setYear(udEndDate.getValue().getYear() - 1900);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dat2 = sdf.format(date2);
        finalEndDate=sdf.parse(dat2);
        
        System.out.println("Final Start Date :\t"+finalStartDate+"\nFinal End Date :\t"+finalEndDate);

        if (finalEndDate.after(finalStartDate)) {
            if (finalEndDate.getTime() - finalStartDate.getTime() / 3600000 <= 30) {
                udSearchButton.setDisable(true);
                udUpdateButton.setDisable(true);
                udDeleteButton.setDisable(true);
                JOptionPane.showMessageDialog(null, "The difference between start and end date can be 1 month\nPlease select a valid date to continue", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                udSearchButton.setDisable(false);
                udUpdateButton.setDisable(false);
                udDeleteButton.setDisable(false);
            }
        }
    }

    @FXML
    private void udUpdateButtonAction(ActionEvent event) {
    }

    @FXML
    private void udSearchButtonAction(ActionEvent event) {

        //validate the following
        //1. consultant name is selected
        //2. start date
        //3. end date
        //If everything is present then execute else display error message
        if (udConsultantNameCB == null || udConsultantNameCB.getValue().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Consultant Name is missing...\nPlease select a consultant name and then proceed...", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (finalStartDate == null || finalEndDate == null) {
                JOptionPane.showMessageDialog(null, "Start Date or End Date is missing\n Please make sure you enter the start and end date", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                usersService.getMyTimeSheet(udTimeSheetModelList, udCompanyNameTF.getText(), udDepartmentCB.getValue(), udProjectSelectionNameCB.getValue(), udConsultantNameCB.getValue(), finalStartDate, finalEndDate);
                udEntryTableView1.setItems(udTimeSheetModelList);
            }
        }
    }

    @FXML
    private void udEnableNameCB(ActionEvent event) {
        udProjectSelectionNameCB.setDisable(false);
        udProjectSelectionCodeCB.setDisable(true);
    }

    @FXML
    private void udEnableCodeCB(ActionEvent event) {
        udProjectSelectionNameCB.setDisable(true);
        udProjectSelectionCodeCB.setDisable(false);
    }

    @FXML
    private void udProjectSelectionComboBoxName(ActionEvent event) {
        udProjectSelectionCodeCB.setValue(projectCodeMap.get(udProjectSelectionNameCB.getValue()));
        consultanNameList.clear();
        udConsultantNameCB.getItems().clear();
        System.out.println("\nName ComboBox\nCompany Name :\t" + udCompanyNameTF.getText() + "\nDepartment :\t" + udDepartmentCB.getValue() + "\nProject Name :\t" + udProjectSelectionNameCB.getValue());
        boolean error = false;
        String errorMessage = "";
        //validation
        //System.out.println("TF Content(Object) :\t"+neCompanyNameTF+"\nTF Content(Object To String) :\t"+neCompanyNameTF.toString()+"\nTF String Value :"+neCompanyNameTF.getText().equalsIgnoreCase("")+"value");
        if (udCompanyNameTF == null || udCompanyNameTF.getText().equalsIgnoreCase("")) {
            errorMessage = "Company name is missing\nPlease Enter the company name and try again...\nSorry for the in-convienence";
            error = true;
        }
        if (!error) {
            getAllConsultant(udCompanyNameTF.getText(), udDepartmentCB.getValue(), udProjectSelectionNameCB.getValue(), consultanNameList);
            udConsultantNameCB.getItems().addAll(consultanNameList);
        } else {
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void udProjectSelectionChoiceBoxCode(ActionEvent event) {
        udProjectSelectionNameCB.setValue(projectNameMap.get(udProjectSelectionCodeCB.getValue()));
    }

    @FXML
    private void udConsultantNameChoiceBoxAction(ActionEvent event) {
        usersService.getTSReqInfo(udConsultantNameCB.getValue(), udCompanyNameTF.getText(), udDepartmentCB.getValue(), udProjectSelectionNameCB.getValue(), projectAssignDto);
        System.out.println("Project Assign Dto\n" + projectAssignDto);
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
