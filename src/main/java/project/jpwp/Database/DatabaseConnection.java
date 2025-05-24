package project.jpwp.Database;

import project.jpwp.Role;
import project.jpwp.users.Admin;
import project.jpwp.users.Normal_user;
import project.jpwp.users.PasswordUtils;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:identifier.sqlite";
    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URL);
        if(connection == null) {
            throw new SQLException("Could not connect to the database");
        }
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public void addUser(String name, String email, String password, Role role) throws SQLException {
        String hashedPassword = PasswordUtils.hashPassword(password);
        String sql = "INSERT INTO users(name, email, password, role) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, hashedPassword);
            ps.setString(4, role.name());
            ps.executeUpdate();
        }
    }
    public Object login(String email, String password) throws SQLException {
        String hashedPassword = PasswordUtils.hashPassword(password);

        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, hashedPassword);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String role = rs.getString("role");
                    Role roleEnum = Role.valueOf(role.toUpperCase());
                    if (roleEnum == Role.ADMIN) {
                        return new Admin(id,name,email,password,roleEnum);
                    } else {
                        return new Normal_user(id, name, email, password, roleEnum);
                    }
                }
            }
        }
        return null;
    }
}
