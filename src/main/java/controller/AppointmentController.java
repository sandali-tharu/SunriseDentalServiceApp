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

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }
}