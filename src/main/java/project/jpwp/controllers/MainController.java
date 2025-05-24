package project.jpwp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import project.jpwp.Role;
import project.jpwp.User;
import project.jpwp.users.Normal_user;


public class MainController {
    private Normal_user user;

    @FXML
    private Button adminButton;
    @FXML
    private Button userButton;

    public void setUser(Normal_user user) {
        this.user=user;
        if(user.getRole()== Role.USER){
            adminButton.setDisable(true);
        }
    }


}
