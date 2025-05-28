package project.jpwp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import project.jpwp.Database.DatabaseConnection;
import project.jpwp.users.User;

import java.sql.SQLException;
import java.util.List;

public class UsersListViewController {
    @FXML
    private ListView<User> userListView;
    @FXML
    private Label errorLabel;
    @FXML
    private Button LoadUsers;

    @FXML
    public void onButtonLoadUsers() {
        try {
            DatabaseConnection db = new DatabaseConnection();
            db.connect();
            List<User> users=db.userList();
            db.close();
            ObservableList<User> observableList= FXCollections.observableList(users);
            userListView.setItems(observableList);
        } catch (SQLException e) {
            errorLabel.setText("Problem with connection to database"+e.getMessage());
            errorLabel.setVisible(true);
        }

    }
}
