package project.jpwp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.jpwp.Database.DatabaseConnection;
import project.jpwp.Role;


import java.sql.SQLException;

public class RegisterController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ChoiceBox<String> roleChoiceBox;
    @FXML
    private Label errorLabel;


    @FXML
    public void onRegisterButtonClick(ActionEvent event) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String role = roleChoiceBox.getValue();
        Role roleEnum = Role.valueOf(role.toUpperCase());

        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
            errorLabel.setText("Fill out all the fields");
            errorLabel.setVisible(true);
            return;
        }
        try {
            DatabaseConnection db = new DatabaseConnection();
            db.connect();
            db.addUser(name,email,password,roleEnum);
            db.close();
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            errorLabel.setText(e.getMessage());
            errorLabel.setVisible(true);
            throw new RuntimeException(e);
        }
    }
}
