package service;

import dao.jdbc.JdbcUserDao;
import entity.User;

import java.util.List;

public class UserService {

    private JdbcUserDao jdbcUserDao;

    public List<User> getAll() {
        return jdbcUserDao.getAll();
    }

    public void addUser(User user) {
        jdbcUserDao.addUser(user);
    }

    public void updateUser(User user) {
        jdbcUserDao.updateUser(user);
    }

    public void deleteUser(long id) {
        jdbcUserDao.deleteUser(id);
    }

    public User getOneUser(long id) {
        return jdbcUserDao.getUser(id);
    }

    public void setJdbcUserDao(JdbcUserDao jdbcUserDao) {
        this.jdbcUserDao = jdbcUserDao;
    }
}
