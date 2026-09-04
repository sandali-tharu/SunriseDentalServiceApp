package com.mycompany.sunrisedentalserviceapp.dao;

import com.mycompany.sunrisedentalserviceapp.model.Appointment;
import com.mycompany.sunrisedentalserviceapp.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AppointmentDAO {

    // === Add Appointment ===
    public boolean addAppointment(Appointment app) {
        try {
            // Validate that the appointment date is not in the past
            LocalDate selectedDate = LocalDate.parse(app.getAppointmentDate());
            if (selectedDate.isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, "Cannot book appointments for past dates!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid date format! Please use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sql = "INSERT INTO appointment (patient_id, dentist_name, treatment_type, appointment_date, appointment_time) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, app.getPatientId());
            stmt.setString(2, app.getDentistName());
            stmt.setString(3, app.getTreatmentType());
            stmt.setString(4, app.getAppointmentDate());

            String timeStr = app.getAppointmentTime();
            if (timeStr != null && timeStr.length() == 5) {
                timeStr += ":00";
            }
            stmt.setString(5, timeStr);

            int rowsAffected = stmt.executeUpdate();
            stmt.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // === Get All Appointments ===
    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT appointment_id, patient_id, dentist_name, treatment_type, appointment_date, appointment_time FROM appointment ORDER BY appointment_id DESC";

        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Appointment app = new Appointment(
                    rs.getInt("appointment_id"),
                    rs.getInt("patient_id"),
                    rs.getString("dentist_name"),
                    rs.getString("treatment_type"),
                    rs.getString("appointment_date"),
                    rs.getString("appointment_time")
                );
                list.add(app);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // === Update Appointment ===
    public boolean updateAppointment(Appointment app) {
        try {
            // Validate that the appointment date is not in the past
            LocalDate selectedDate = LocalDate.parse(app.getAppointmentDate());
            if (selectedDate.isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, "Cannot update appointments to past dates!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid date format! Please use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sql = "UPDATE appointment SET patient_id = ?, dentist_name = ?, treatment_type = ?, appointment_date = ?, appointment_time = ? WHERE appointment_id = ?";
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, app.getPatientId());
            stmt.setString(2, app.getDentistName());
            stmt.setString(3, app.getTreatmentType());
            stmt.setString(4, app.getAppointmentDate());

            String timeStr = app.getAppointmentTime();
            if (timeStr != null && timeStr.length() == 5) {
                timeStr += ":00";
            }
            stmt.setString(5, timeStr);

            stmt.setInt(6, app.getAppointmentId());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // === Delete Appointment ===
    public boolean deleteAppointment(int appointmentId) {
        String sql = "DELETE FROM appointment WHERE appointment_id = ?";
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, appointmentId);

            int rowsAffected = stmt.executeUpdate();
            stmt.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}