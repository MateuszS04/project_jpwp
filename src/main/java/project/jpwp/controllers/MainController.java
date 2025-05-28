package project.jpwp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.jpwp.Database.DatabaseConnection;
import project.jpwp.RequireRole;
import project.jpwp.Role;
import project.jpwp.users.Normal_user;
import project.jpwp.users.User;

import java.sql.SQLException;


public class MainController {
    private User user;

    @FXML
    private Button adminButton;
    @FXML
    private Button userButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private TextField idField;
    @FXML
    private Label errorLabel;

    public void setUser(User user) {
        this.user=user;
        if(user.getRole()== Role.USER){
            adminButton.setDisable(true);
        } else if (user.getRole()== Role.ADMIN) {
            adminButton.setDisable(false);
        }
    }
    @RequireRole(Role.ADMIN)
    public void onDeleteButtonClick(ActionEvent actionEvent) {
        String id_text = idField.getText();
        int id = Integer.parseInt(id_text);
        DatabaseConnection db = new DatabaseConnection();
        try{
                db.connect();
                db.deleteUser(id);
                db.close();
                errorLabel.setText("User has been deleted");
                errorLabel.setVisible(true);
                if(user.getRole()== Role.USER){
                errorLabel.setText("You are not allowed to delete user");
                errorLabel.setVisible(true);
            }
        }catch (SQLException e){
            errorLabel.setText(e.getMessage());
            errorLabel.setVisible(true);
        }
    }
    @RequireRole(Role.ADMIN)
    public void onAdminButtonClick(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/jpwp/UsersListView.fxml"));
            Parent root= loader.load();
            Stage stage = new Stage();
            stage.setTitle("User List");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            errorLabel.setText(e.getMessage());
            errorLabel.setVisible(true);
        }
    }

}
