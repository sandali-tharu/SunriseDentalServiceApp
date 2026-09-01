package com.mycompany.sunrisedentalserviceapp.dao;

import com.mycompany.sunrisedentalserviceapp.DatabaseConnection;
import com.mycompany.sunrisedentalserviceapp.model.Patient;
import com.mycompany.sunrisedentalserviceapp.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public boolean addPatient(Patient patient) {
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String sql = "INSERT INTO patient (patient_id, name, age, gender, contact_no, address) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(patient.getPatientId()));
            stmt.setString(2, patient.getName());
            stmt.setString(3, String.valueOf(patient.getAge()));
            stmt.setString(4, patient.getGender());
            stmt.setString(5, patient.getContactNo());
            stmt.setString(6, patient.getAddress());

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
                    rs.getString("gender"),
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
}