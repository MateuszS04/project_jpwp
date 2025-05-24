package project.jpwp.admin;

import project.jpwp.Role;

public class Admin {
    private String loginName;
    private String password;
    private Role role;

    public Admin(String loginName, String password, Role roleEnum) {
        this.loginName = loginName;
        this.password = password;
        this.role = Role.ADMIN;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
