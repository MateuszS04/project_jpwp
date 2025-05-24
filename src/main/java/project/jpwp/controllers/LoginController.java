package project.jpwp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.jpwp.Database.DatabaseConnection;
import project.jpwp.users.Normal_user;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passField;
    @FXML
    private Label error;

    private final DatabaseConnection db = new DatabaseConnection();

    @FXML
    public void onLoginClick(ActionEvent event) {
        String email = emailField.getText();
        String password = passField.getText();

        try {
            db.connect();
            Normal_user normal_user = (Normal_user) db.login(email, password);
            db.close();

            if (normal_user != null) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/jpwp/views/login.fxml"));
                Parent root = fxmlLoader.load();

                MainController controller = fxmlLoader.getController();
                controller.setUser(normal_user);

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
}
