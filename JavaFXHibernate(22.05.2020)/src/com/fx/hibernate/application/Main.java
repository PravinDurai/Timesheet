package com.fx.hibernate.application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Timesheet.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Timesheet - Sandhata");
            stage.show();

//	        Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
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
