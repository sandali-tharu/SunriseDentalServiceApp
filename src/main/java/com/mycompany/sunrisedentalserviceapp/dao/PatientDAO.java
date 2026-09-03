package com.mycompany.sunrisedentalserviceapp.dao;

import com.mycompany.sunrisedentalserviceapp.DatabaseConnection;
import com.mycompany.sunrisedentalserviceapp.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public boolean addPatient(Patient patient) {
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            
            // 1. Check if Patient ID already exists in the database
            String checkSql = "SELECT COUNT(*) FROM patient WHERE patient_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, patient.getPatientId());
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                // Duplicate ID found!
                rs.close();
                checkStmt.close();
                return false; 
            }
            rs.close();
            checkStmt.close();

            // 2. Insert with the explicit Patient ID
            String sql = "INSERT INTO patient (patient_id, name, age, contact_no, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, patient.getPatientId());
            stmt.setString(2, patient.getName());
            stmt.setInt(3, patient.getAge());
            stmt.setString(4, patient.getContactNo());
            stmt.setString(5, patient.getAddress());

            int rows = stmt.executeUpdate();
            stmt.close();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String sql = "SELECT * FROM patient ORDER BY patient_id DESC";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Patient p = new Patient(
                    rs.getInt("patient_id"),
                    rs.getString("name"),
                    rs.getInt("age"), 
                    rs.getString("contact_no"),
                    rs.getString("address")
                );
                list.add(p);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updatePatient(Patient patient) {
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String sql = "UPDATE patient SET name = ?, age = ?, contact_no = ?, address = ? WHERE patient_id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getContactNo());
            stmt.setString(4, patient.getAddress());
            stmt.setInt(5, patient.getPatientId());

            int rows = stmt.executeUpdate();
            stmt.close();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePatient(int patientId) {
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String sql = "DELETE FROM patient WHERE patient_id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, patientId);

            int rows = stmt.executeUpdate();
            stmt.close();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}