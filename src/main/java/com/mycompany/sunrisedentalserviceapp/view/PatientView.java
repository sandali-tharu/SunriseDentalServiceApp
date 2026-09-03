package com.mycompany.sunrisedentalserviceapp.view;

import controller.PatientController;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import com.mycompany.sunrisedentalserviceapp.model.Patient;
import javax.swing.JOptionPane;

public class PatientView extends javax.swing.JFrame {

    private PatientController patientController;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PatientView.class.getName());

    public PatientView() {
        initComponents();
        patientController = new PatientController();
        loadPatientTable();
    }

    private void loadPatientTable() {
        DefaultTableModel model = (DefaultTableModel) tblPatients.getModel();
        model.setRowCount(0);

        List<Patient> list = patientController.getAllPatients();
        if (list != null) {
            for (Patient p : list) {
                model.addRow(new Object[]{
                    p.getPatientId(),
                    p.getName(),
                    p.getAge(),
                    p.getContactNo(),
                    p.getAddress()
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtPatientId = new javax.swing.JTextField();
        txtFullName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sunrise Dental Service - Patient Management");

        btnUpdate.setBackground(new java.awt.Color(102, 102, 102));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        jLabel3.setText("Full Name:");

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        jLabel4.setText("Age:");

        btnClear.setBackground(new java.awt.Color(204, 204, 204));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        jLabel5.setText("Contact No:");

        tblPatients.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Name", "Age", "Contact", "Address"
            }
        ));
        jScrollPane1.setViewportView(tblPatients);

        jLabel6.setText("Address:");

        jPanel2.setBackground(new java.awt.Color(26, 54, 93));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Patient Registration & Management");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SUNRISE DENTAL SERVICE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegister.setBackground(new java.awt.Color(26, 54, 93));
        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.addActionListener(this::btnRegisterActionPerformed);

        jLabel2.setText("Patient ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullName, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegister)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnClear)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            String patientIdStr = txtPatientId.getText().trim();
            String name = txtFullName.getText().trim();
            String ageText = txtAge.getText().trim();
            String contactNo = txtContact.getText().trim();
            String address = txtAddress.getText().trim();

            if (patientIdStr.isEmpty() || name.isEmpty() || ageText.isEmpty() || contactNo.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields (including Patient ID)!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int patientId = Integer.parseInt(patientIdStr);
            int age = Integer.parseInt(ageText);

            Patient patient = new Patient(patientId, name, age, contactNo, address);
            boolean isSuccess = patientController.addPatient(patient);

            if (isSuccess) {
                JOptionPane.showMessageDialog(this, "Patient Registered Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadPatientTable();
                btnClearActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(this, "Error: Patient ID already exists!", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Patient ID and Age!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
            String patientIdStr = txtPatientId.getText().trim();
            if (patientIdStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Patient ID to update!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id = Integer.parseInt(patientIdStr);
            String name = txtFullName.getText().trim();
            int age = Integer.parseInt(txtAge.getText().trim());
            String contact = txtContact.getText().trim();
            String address = txtAddress.getText().trim();

            Patient patient = new Patient(id, name, age, contact, address);

            boolean success = patientController.updatePatient(patient);

            if (success) {
                JOptionPane.showMessageDialog(this, "Patient Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadPatientTable();
                btnClearActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(this, "Patient ID Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for Patient ID and Age!", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                       

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
            String patientIdStr = txtPatientId.getText().trim();
            if (patientIdStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select/enter a Patient ID to delete!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int id = Integer.parseInt(patientIdStr);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this patient?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = patientController.deletePatient(id);

                if (success) {
                    JOptionPane.showMessageDialog(this, "Patient Deleted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadPatientTable();
                    btnClearActionPerformed(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to Delete Patient!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please select a valid Patient ID to delete!", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                       

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {                                       
        txtPatientId.setText("");
        txtFullName.setText("");
        txtAge.setText("");
        txtContact.setText("");
        txtAddress.setText("");
    }                                      

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new PatientView().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPatientId;
    // End of variables declaration                   
}