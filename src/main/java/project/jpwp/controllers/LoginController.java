package project.jpwp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.jpwp.Database.DatabaseConnection;
import project.jpwp.users.Normal_user;
import project.jpwp.users.User;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passField;
    @FXML
    private Label error;
    @FXML
    private Button Register;

    private final DatabaseConnection db = new DatabaseConnection();

    @FXML
    public void onLoginClick(ActionEvent event) {
        String email = emailField.getText();
        String password = passField.getText();

        try {
            db.connect();
            User user=db.login(email, password);
            db.close();

            if (user !=null) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/jpwp/MainView.fxml"));
                Parent root = fxmlLoader.load();

                MainController controller = fxmlLoader.getController();
                controller.setUser(user);

                Stage stage = (Stage) emailField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                error.setText("Nieprawidłowy email lub hasło.");
                error.setVisible(true);
            }
        } catch (SQLException | IOException e) {
            error.setText("Błąd logowania: " + e.getMessage());
            error.setVisible(true);
        }
    }
    @FXML
    public void onRegisterClick(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/jpwp/RegisterView.fxml"));
            Parent root=fxmlLoader.load();
            Stage stage=new Stage();
            stage.setTitle("Formularz rejestracji");
            stage.setScene(new Scene(root));
            stage.show();
        }catch(IOException e){
            error.setText("Błąd otiwerania: " + e.getMessage());
            error.setVisible(true);
        }
    }
}
