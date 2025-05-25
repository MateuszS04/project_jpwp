package project.jpwp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import project.jpwp.Database.DatabaseConnection;
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
    public void onDeleteButtonClick(ActionEvent actionEvent) {
        String id_text = idField.getText();
        int id = Integer.parseInt(id_text);
        DatabaseConnection db = new DatabaseConnection();
        try{
            if(user.getRole()== Role.ADMIN){
                db.connect();
                db.deleteUser(id);
                db.close();
                errorLabel.setText("User has been deleted");
                errorLabel.setVisible(true);
            }else if(user.getRole()== Role.USER){
                errorLabel.setText("You are not allowed to delete user");
                errorLabel.setVisible(true);
            }
        }catch (SQLException e){
            errorLabel.setText(e.getMessage());
            errorLabel.setVisible(true);
        }

    }

}
