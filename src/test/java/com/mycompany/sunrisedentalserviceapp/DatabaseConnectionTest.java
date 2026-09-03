package com.mycompany.sunrisedentalserviceapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.DriverManager;
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

    // TC_02: Verify Singleton behavior (calling getInstance() twice returns the exact same object reference)
    @Test
    public void testTC02_SingletonBehavior() {
        try {
            DatabaseConnection instance1 = DatabaseConnection.getInstance();
            DatabaseConnection instance2 = DatabaseConnection.getInstance();
            
            assertSame(instance1, instance2, "TC_02 Failed: getInstance() did not return a Singleton instance");
        } catch (SQLException e) {
            fail("TC_02 Failed due to exception: " + e.getMessage());
        }
    }

    // TC_03: Verify database connection closes and handles exceptions gracefully
    @Test
    public void testTC03_ConnectionClose() {
        try {
            DatabaseConnection dbInstance = DatabaseConnection.getInstance();
            Connection conn = dbInstance.getConnection();
            
            assertNotNull(conn, "Connection should not be null before closing");
            
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            
            assertTrue(conn.isClosed(), "TC_03 Failed: Database connection should be closed successfully");
            
        } catch (SQLException e) {
            fail("TC_03 Failed due to exception: " + e.getMessage());
        }
    }

    // TC_04: Test connection error handling with invalid database URL/credentials
    @Test
    public void testTC04_InvalidConnectionErrorHandling() {
        String invalidUrl = "jdbc:mysql://localhost:3306/invalid_dental_db";
        String invalidUser = "wrong_user";
        String invalidPassword = "wrong_password";
        
        assertThrows(SQLException.class, () -> {
            DriverManager.getConnection(invalidUrl, invalidUser, invalidPassword);
        }, "TC_04 Failed: Expected SQLException due to invalid database credentials/URL");
    }
}