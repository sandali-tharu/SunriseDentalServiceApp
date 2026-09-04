package controller;

import com.mycompany.sunrisedentalserviceapp.dao.AppointmentDAO;
import com.mycompany.sunrisedentalserviceapp.model.Appointment;

import java.util.List;

public class AppointmentController {

    private AppointmentDAO appointmentDAO;

    public AppointmentController() {
        this.appointmentDAO = new AppointmentDAO();
    }

    public boolean createAppointment(int patientId, String dentistName, String treatmentType, String date, String time) {
        Appointment app = new Appointment();
        app.setPatientId(patientId);
        app.setDentistName(dentistName);
        app.setTreatmentType(treatmentType);
        app.setAppointmentDate(date);
        app.setAppointmentTime(time);

        return appointmentDAO.addAppointment(app);
    }

    public boolean addAppointment(Appointment appointment) {
        return appointmentDAO.addAppointment(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

   

  
    public boolean updateAppointment(int appointmentId, int patientId, String dentistName, String treatmentType, String date, String time) {
        Appointment app = new Appointment();
        app.setAppointmentId(appointmentId);
        app.setPatientId(patientId);
        app.setDentistName(dentistName);
        app.setTreatmentType(treatmentType);
        app.setAppointmentDate(date);
        app.setAppointmentTime(time);

        return appointmentDAO.updateAppointment(app);
    }

    
    public boolean deleteAppointment(int appointmentId) {
        return appointmentDAO.deleteAppointment(appointmentId);
    }
}