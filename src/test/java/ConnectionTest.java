import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import static org.junit.Assert.*;

public class ConnectionTest {
    private Connection connection;

    @Before
    public void before() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Europe/Moscow&useSSL=false";
        String username = "root";
        String password = "root";
        connection = DriverManager.getConnection(url, username, password);
    }

    @Test
    public void connectionShouldNotBeNull() throws SQLException {
        connection.getMetaData().getDatabaseProductName();
        assertNotNull(connection);
    }

    @After
    public void after() throws SQLException {
        connection.close();
    }
}
