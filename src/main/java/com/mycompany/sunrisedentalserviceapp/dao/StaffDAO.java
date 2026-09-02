package com.mycompany.sunrisedentalserviceapp.dao;

import com.mycompany.sunrisedentalserviceapp.DatabaseConnection;
import com.mycompany.sunrisedentalserviceapp.model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {

    public boolean addStaff(Staff staff) {
        String query = "INSERT INTO staff (staff_id, staff_name, user_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, staff.getStaffId());
            pstmt.setString(2, staff.getStaffName());
            pstmt.setInt(3, staff.getUserId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Staff> getAllStaff() {
        List<Staff> list = new ArrayList<>();
        String query = "SELECT s.staff_id, s.staff_name, u.user_id, u.username, u.role " +
                       "FROM staff s JOIN users u ON s.user_id = u.user_id";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Staff s = new Staff();
                s.setStaffId(rs.getString("staff_id"));
                s.setStaffName(rs.getString("staff_name"));
                s.setUserId(rs.getInt("user_id"));
                s.setUsername(rs.getString("username"));
                s.setRole(rs.getString("role"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}