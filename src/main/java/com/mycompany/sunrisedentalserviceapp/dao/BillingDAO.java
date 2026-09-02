package com.mycompany.sunrisedentalserviceapp.dao;

import com.mycompany.sunrisedentalserviceapp.DatabaseConnection;
import com.mycompany.sunrisedentalserviceapp.model.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {

    public boolean addBill(Bill bill) {
        String query = "INSERT INTO bills (bill_id, appointment_id, patient_name, total_amount, discount, net_amount, payment_status, bill_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, bill.getBillId());
            pstmt.setString(2, bill.getAppointmentId());
            pstmt.setString(3, bill.getPatientName());
            pstmt.setDouble(4, bill.getTotalAmount());
            pstmt.setDouble(5, bill.getDiscount());
            pstmt.setDouble(6, bill.getNetAmount());
            pstmt.setString(7, bill.getPaymentStatus());
            pstmt.setDate(8, new java.sql.Date(bill.getBillDate().getTime()));

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Bill> getAllBills() {
        List<Bill> list = new ArrayList<>();
        String query = "SELECT * FROM bills";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Bill b = new Bill();
                b.setBillId(rs.getString("bill_id"));
                b.setAppointmentId(rs.getString("appointment_id"));
                b.setPatientName(rs.getString("patient_name"));
                b.setTotalAmount(rs.getDouble("total_amount"));
                b.setDiscount(rs.getDouble("discount"));
                b.setNetAmount(rs.getDouble("net_amount"));
                b.setPaymentStatus(rs.getString("payment_status"));
                b.setBillDate(rs.getDate("bill_date"));
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}