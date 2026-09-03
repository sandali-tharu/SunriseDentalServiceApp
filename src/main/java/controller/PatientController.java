package controller;

import com.mycompany.sunrisedentalserviceapp.dao.PatientDAO;
import com.mycompany.sunrisedentalserviceapp.model.Patient;
import java.util.List;

public class PatientController {

    private PatientDAO patientDAO;

    public PatientController() {
        this.patientDAO = new PatientDAO();
    }

    public boolean addPatient(Patient patient) {
        return patientDAO.addPatient(patient);
    }

    public boolean addPatient(String name, int age, String contactNo, String address) {
        Patient patient = new Patient(name, age, contactNo, address);
        return patientDAO.addPatient(patient);
    }

    public boolean updatePatient(Patient patient) {
        return patientDAO.updatePatient(patient);
    }

    public boolean deletePatient(int patientId) {
        return patientDAO.deletePatient(patientId);
    }

    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
}