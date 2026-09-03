package com.mycompany.sunrisedentalserviceapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    // TC_01: Verify DatabaseConnection returns a non-null connection instance
    @Test
    public void testTC01_NotNullConnection() {
        try {
            DatabaseConnection dbInstance = DatabaseConnection.getInstance();
            Connection conn = dbInstance.getConnection();
            assertNotNull(conn, "TC_01 Failed: Connection instance should not be null");
        } catch (SQLException e) {
            fail("TC_01 Failed due to exception: " + e.getMessage());
        }
    }
}