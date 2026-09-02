package controller;

import javax.swing.table.DefaultTableModel;

public class DentistController {

    public boolean saveDentist(String dentistId, String name, String specialization, String phone, String email, String qualification) {
        System.out.println("Saving Dentist: " + name);
        return true; 
    }

   
    public void loadTableData(DefaultTableModel model) {
       
        model.setRowCount(0); 
       
    }
}