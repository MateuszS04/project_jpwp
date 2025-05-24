package project.jpwp.users;

import project.jpwp.Role;

public class Normal_user {
    private String name;;
    private String email;
    private String password;
    private Role role;

    public Normal_user(int id, String name, String email, String password) {
        this.name = name;
        this.password = password;
        this.role= Role.USER;
    }

    public Normal_user(String name, Role roleEnum) {
        this.name = name;
        this.role = roleEnum;
    }

    public Normal_user(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Normal_user(int id, String name, String email, String password, Role roleEnum) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
