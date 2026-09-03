package controller;

import com.mycompany.sunrisedentalserviceapp.dao.DentistDAO;
import com.mycompany.sunrisedentalserviceapp.model.Dentist;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DentistController {

    private final DentistDAO dentistDAO = new DentistDAO();

    public boolean saveDentist(String dentistId, String name, String specialization, String phone, String email, String qualification) {
        Dentist d = new Dentist();
        d.setDentistId(dentistId);
        d.setName(name);
        d.setSpecialization(specialization);
        d.setPhone(phone);
        d.setEmail(email);
        d.setQualification(qualification);

        return dentistDAO.addDentist(d);
    }

    public boolean updateDentist(String dentistId, String name, String specialization, String phone, String email, String qualification) {
        Dentist d = new Dentist();
        d.setDentistId(dentistId);
        d.setName(name);
        d.setSpecialization(specialization);
        d.setPhone(phone);
        d.setEmail(email);
        d.setQualification(qualification);

        return dentistDAO.updateDentist(d);
    }

    public boolean deleteDentist(String dentistId) {
        return dentistDAO.deleteDentist(dentistId);
    }

    public void loadTableData(DefaultTableModel model) {
        model.setRowCount(0);
        List<Dentist> list = dentistDAO.getAllDentists();
        for (Dentist d : list) {
            model.addRow(new Object[]{
                d.getDentistId(),
                d.getName(),
                d.getSpecialization(),
                d.getPhone(),
                d.getEmail(),
                d.getQualification()
            });
        }
    }

    public void searchDentist(String keyword, DefaultTableModel model) {
        model.setRowCount(0);
        List<Dentist> list = dentistDAO.getAllDentists();
        for (Dentist d : list) {
            if (d.getName().toLowerCase().contains(keyword.toLowerCase()) || 
                d.getDentistId().toLowerCase().contains(keyword.toLowerCase()) ||
                d.getSpecialization().toLowerCase().contains(keyword.toLowerCase())) {
                model.addRow(new Object[]{
                    d.getDentistId(),
                    d.getName(),
                    d.getSpecialization(),
                    d.getPhone(),
                    d.getEmail(),
                    d.getQualification()
                });
            }
        }
    }
}