package project.jpwp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import project.jpwp.Role;
import project.jpwp.users.Normal_user;
import project.jpwp.users.User;


public class MainController {
    private User user;

    @FXML
    private Button adminButton;
    @FXML
    private Button userButton;

    public void setUser(User user) {
        this.user=user;
        if(user.getRole()== Role.USER){
            adminButton.setDisable(true);
        }
    }

}
