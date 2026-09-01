package controller;

import com.mycompany.sunrisedentalserviceapp.dao.PatientDAO;
import com.mycompany.sunrisedentalserviceapp.model.Patient;

import java.util.List;

public class PatientController {

    private PatientDAO patientDAO;

    public PatientController() {
        this.patientDAO = new PatientDAO();
    }

    public boolean addPatient(int patientId, String name, int age, String gender, String contactNo, String address) {
        Patient p = new Patient(patientId, name, age, gender, contactNo, address);
        return patientDAO.addPatient(p);
    }

    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
}
