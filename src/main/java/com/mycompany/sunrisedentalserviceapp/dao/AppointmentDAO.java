package com.mycompany.sunrisedentalserviceapp.dao;

import com.mycompany.sunrisedentalserviceapp.model.Appointment;
import com.mycompany.sunrisedentalserviceapp.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public boolean addAppointment(Appointment app) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "{CALL AddAppointment(?, ?, ?, ?, ?, ?)}";

            CallableStatement stmt = conn.prepareCall(sql);
            stmt.setInt(1, app.getPatientId());
            stmt.setString(2, app.getDentistName());
            stmt.setString(3, app.getTreatmentType());
            stmt.setString(4, app.getAppointmentDate());
            stmt.setString(5, app.getAppointmentTime());
            stmt.registerOutParameter(6, Types.VARCHAR);

            stmt.execute();

            String generatedNo = stmt.getString(6);
            app.setAppointmentNo(generatedNo);

            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM appointments ORDER BY appointment_id DESC";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Appointment app = new Appointment(
                    rs.getInt("appointment_id"),
                    rs.getString("appointment_no"),
                    rs.getInt("patient_id"),
                    rs.getString("dentist_name"),
                    rs.getString("treatment_type"),
                    rs.getString("appointment_date"),
                    rs.getString("appointment_time"),
                    rs.getString("status")
                );
                list.add(app);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}