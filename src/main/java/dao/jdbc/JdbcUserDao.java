package dao.jdbc;

import dao.jdbc.mapper.UserMapper;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao {

    private String GET_ALL_SQL = "SELECT id, first_name, last_name, age FROM user;";
    private String ADD_USER = "INSERT INTO user (id, first_name, last_name, age) VALUES (?, ?, ?, ?);";
    private String UPDATE_USER = "UPDATE user SET first_name=?, last_name=?, age=? WHERE id=?;";
    private String GET_USER = "SELECT id, first_name, last_name, age FROM user WHERE id=?;";
    private String DELETE_USER = "DELETE FROM user WHERE id = ?;";

    //-------- Add User -----------
    public void addUser(User user) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_USER)) {

            statement.setLong(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setInt(4, user.getAge());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-------- Get All -----------
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);

            UserMapper userMapper = new UserMapper();

            while (resultSet.next()) {
                User user = userMapper.mapRaw(resultSet);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    //-------- Update User -----------
    public void updateUser(User user) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setLong(4, user.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //--------Get One User ---------
    public User getUser(long id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USER)) {
            statement.setLong(1, id);

            UserMapper userMapper = new UserMapper();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = userMapper.mapRaw(resultSet);
                String firstName = user.getFirstName();
                String lastName = user.getLastName();
                int age = user.getAge();
                user = new User(id, firstName, lastName, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //------------ Delete User ------------
    public void deleteUser(long id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {

            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Connection
    private Connection getConnection() {
        String dbUrl = "jdbc:mysql://localhost:3306/jva_users";
        String user = "root";
        String password = "vanbuuren";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}