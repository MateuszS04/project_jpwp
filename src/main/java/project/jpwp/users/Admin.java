package project.jpwp.users;

import project.jpwp.Role;

public class Admin extends User {
    public Admin(int id, String name, String email, String password, Role role) {
        super(id,name,email,password,role);
    }
}
