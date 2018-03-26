package dao.jdbc.mapper;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public User mapRaw(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setAge(resultSet.getInt("age"));

        return user;
    }
}
