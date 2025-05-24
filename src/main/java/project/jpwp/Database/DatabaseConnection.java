package project.jpwp.Database;

import project.jpwp.Role;
import project.jpwp.admin.Admin;
import project.jpwp.users.Normal_user;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:identifier.sqlite";
    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URL);
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public void addUser(String name, String email, String password, Role role) throws SQLException {
        String sql = "INSERT INTO users(name, email, password, role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, role.name());
            ps.executeUpdate();
        }
    }

    public void addAdmin(String loginName, String password, Role role) throws SQLException {
        String sql = "INSERT INTO admins(loginName, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, loginName);
            ps.setString(2, password);
            ps.setString(3, role.name());
            ps.executeUpdate();
        }
    }
    public Object login(String email, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String role = rs.getString("role");
                    Role roleEnum = Role.valueOf(role.toUpperCase());

                    if (roleEnum == Role.ADMIN) {
                        return new Admin(name, password, roleEnum);
                    } else {
                        return new Normal_user(id, name, email, password, roleEnum);
                    }
                }
            }
        }
        return null;
    }



}
