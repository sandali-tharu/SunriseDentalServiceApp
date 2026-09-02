package com.mycompany.sunrisedentalserviceapp.dao;

import com.mycompany.sunrisedentalserviceapp.DatabaseConnection;
import com.mycompany.sunrisedentalserviceapp.model.Dentist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DentistDAO {

    public boolean addDentist(Dentist dentist) {
        String query = "INSERT INTO dentists (dentist_id, name, specialization, phone, email, qualification) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, dentist.getDentistId());
            pstmt.setString(2, dentist.getName());
            pstmt.setString(3, dentist.getSpecialization());
            pstmt.setString(4, dentist.getPhone());
            pstmt.setString(5, dentist.getEmail());
            pstmt.setString(6, dentist.getQualification());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Dentist> getAllDentists() {
        List<Dentist> list = new ArrayList<>();
        String query = "SELECT * FROM dentists";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Dentist d = new Dentist();
                d.setDentistId(rs.getString("dentist_id"));
                d.setName(rs.getString("name"));
                d.setSpecialization(rs.getString("specialization"));
                d.setPhone(rs.getString("phone"));
                d.setEmail(rs.getString("email"));
                d.setQualification(rs.getString("qualification"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}