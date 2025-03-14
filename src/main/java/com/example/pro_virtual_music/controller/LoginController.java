package com.example.pro_virtual_music.controller;

import com.example.pro_virtual_music.DatabaseConection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    //LoginScene
    @FXML
    private Button cancelLoginButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private Label registerLabel;
    //RegisterScene
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField registerUsenameField;
    @FXML
    private PasswordField registerPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button registerButton;
    @FXML
    private Label registerMessageLabel;
    @FXML
    private Button cancelRegisterButton;

    //Actions
    public void onCancelButtonClick(ActionEvent event) {
        Stage stage = (Stage) cancelLoginButton.getScene().getWindow();
        stage.close();
    }

    public void onLoginButtonClick(ActionEvent event) {
        if(!usernameTextField.getText().isBlank() && !passwordField.getText().isBlank()){
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void onRegisterLabelClick(javafx.scene.input.MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loginregister/register-view.fxml"));
            Parent root = loader.load();

            Stage currentStage = (Stage) registerLabel.getScene().getWindow();
            currentStage.setScene(new Scene(root));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void onRegisterButtonClick(ActionEvent event) {
        if( firstnameTextField.getText().isBlank() ||
            lastnameTextField.getText().isBlank() ||
            registerUsenameField.getText().isBlank() ||
            registerPasswordField.getText().isBlank() ||
            confirmPasswordField.getText().isBlank()) {
            registerMessageLabel.setText("Please fill in all required information!");
            return;
        }

        DatabaseConection conectNow = new DatabaseConection();
        Connection connectDB = conectNow.getConnection();

        String checkIfExitedUser = "SELECT count(1) FROM user_data WHERE username = ?";
        String insertQuery = "INSERT INTO user_data (firstname, lastname, username, password) VALUES (?,?,?,?)";

        try {
            PreparedStatement checkStatement = connectDB.prepareStatement(checkIfExitedUser);
            checkStatement.setString(1, registerUsenameField.getText());
            ResultSet queryResult = checkStatement.executeQuery();
            while(queryResult.next()) {
                if(queryResult.getInt(1) > 0) {
                    registerMessageLabel.setText("This username is already taken!");
                    return;
                }
            }
            /*
                - kiểm tra password trùng với confirmpassword
                - thêm người dùng vào data base
             */
            registerMessageLabel.setText("You try to register!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelRegisterButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loginregister/login-view.fxml"));
            Parent root = loader.load();

            Stage currentStage = (Stage) cancelRegisterButton.getScene().getWindow();
            currentStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //SubFunctions
    public void validateLogin() {
        DatabaseConection connectNow = new DatabaseConection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_data WHERE username = ? AND password = ?";

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(verifyLogin);
            preparedStatement.setString(1, usernameTextField.getText());
            preparedStatement.setString(2, passwordField.getText());
            ResultSet queryResult = preparedStatement.executeQuery();

            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("You login!");
                    //Chuyển thành màn hình chính
                } else {
                    loginMessageLabel.setText("Invalid loin! Try again!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}