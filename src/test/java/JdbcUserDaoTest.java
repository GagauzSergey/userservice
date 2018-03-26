import dao.jdbc.JdbcUserDao;
import entity.User;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JdbcUserDaoTest {

    @Test
    public void getAllTest () throws SQLException {
        JdbcUserDao jdbcUserDao = new JdbcUserDao();
        List <User> userList = jdbcUserDao.getAll();

        for (User user : userList) {
            System.out.println(user.toString());
        }
        assertNotNull(userList);
        assertEquals(userList.size(), 2);
    }

    @Test
    public void addUser () throws SQLException {
        JdbcUserDao jdbcUserDao = new JdbcUserDao();
        User testUser = new User(100, "Ben", "Gold", 30);
        jdbcUserDao.addUser(testUser);

        List <User> userList = jdbcUserDao.getAll();
        assertNotNull(userList);
        assertEquals( 3, userList.size());
        assertEquals(100, userList.get(2).getId() );
        assertEquals(testUser.getFirstName(), userList.get(2).getFirstName());
        assertEquals(testUser.getLastName(), userList.get(2).getLastName());
        assertEquals(testUser.getAge(), userList.get(2).getAge());

        jdbcUserDao.deleteUser(testUser.getId());
    }

    @Test
    public void deleteUser () throws SQLException {
        JdbcUserDao jdbcUserDao = new JdbcUserDao();
        User testUser = new User(101, "Ben", "Silver", 32);
        int sizeBefore = jdbcUserDao.getAll().size();
        System.out.println(sizeBefore);

        jdbcUserDao.addUser(testUser);
        jdbcUserDao.deleteUser(testUser.getId());

        int sizeAfter = jdbcUserDao.getAll().size();
        System.out.println(sizeAfter);

        assertEquals(sizeBefore, sizeAfter);
    }

    @Test
    public void updateUser () throws SQLException {
        JdbcUserDao jdbcUserDao = new JdbcUserDao();
        User testUser = new User(100, "Ben", "Gold", 30);
        jdbcUserDao.addUser(testUser);
        User testTempUser = new User(100, "Morten", "Silver", 35);
        jdbcUserDao.updateUser(testTempUser);

        User user = jdbcUserDao.getUser(testTempUser.getId());
        assertNotNull(user);
        assertEquals(testTempUser.getId(), user.getId());
        assertEquals(testTempUser.getFirstName(), user.getFirstName());
        assertEquals(testTempUser.getLastName(), user.getLastName());
        assertEquals(testTempUser.getAge(), user.getAge());

        jdbcUserDao.deleteUser(testTempUser.getId());
    }
}
