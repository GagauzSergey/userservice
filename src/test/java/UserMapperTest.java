import dao.jdbc.mapper.UserMapper;
import entity.User;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserMapperTest {

    @Test
    public void userMapperTest() throws SQLException {
        UserMapper userMapper = new UserMapper();
        ResultSet mockResultSet = mock(ResultSet.class);

        when (mockResultSet.getLong("id")).thenReturn(1L);
        when(mockResultSet.getString("first_name")).thenReturn("test_first_name");
        when(mockResultSet.getString("last_name")).thenReturn("test_last_name");
        when(mockResultSet.getInt("age")).thenReturn(25);

        User currentUser = userMapper.mapRaw(mockResultSet);

        assertNotNull(currentUser);
        assertEquals(1, currentUser.getId());
        assertEquals("test_first_name", currentUser.getFirstName());
        assertEquals("test_last_name", currentUser.getLastName());
        assertEquals(25, currentUser.getAge());
    }
}
