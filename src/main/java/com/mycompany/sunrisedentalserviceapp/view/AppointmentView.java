package com.mycompany.sunrisedentalserviceapp.view;

import com.mycompany.sunrisedentalserviceapp.DatabaseConnection;
import controller.AppointmentController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AppointmentView extends javax.swing.JFrame {

    private AppointmentController appointmentController = new AppointmentController();

    public AppointmentView() {
        initComponents();
        loadAppointmentTable();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void loadAppointmentTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel();
            model.setRowCount(0);

            Connection con = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM appointment";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("appointment_id"),
                    rs.getString("patient_id"),
                    rs.getString("dentist_name"),
                    rs.getString("treatment_type"),
                    rs.getString("appointment_date"),
                    rs.getString("appointment_time")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading table: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPatientId = new javax.swing.JTextField();
        txtDentistName = new javax.swing.JTextField();
        cmbTreatment = new javax.swing.JComboBox<>();
        txtDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtAppointmentId = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));

        jPanel1.setBackground(new java.awt.Color(248, 249, 250));

        jLabel3.setText("Patient ID :");

        jLabel4.setText("Dentist Name :");

        jLabel5.setText("Treatment Type :");

        jLabel6.setText("Date (YYYY-MM-DD) :");

        txtPatientId.setPreferredSize(new java.awt.Dimension(200, 30));

        txtDentistName.setPreferredSize(new java.awt.Dimension(200, 30));

        cmbTreatment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cleaning", "Scaling", "Extraction", "Braces", "Root Canal" }));
        cmbTreatment.setPreferredSize(new java.awt.Dimension(200, 30));

        txtDate.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel7.setText("Time (HH:MM) :");

        txtTime.setPreferredSize(new java.awt.Dimension(200, 30));

        btnSave.setBackground(new java.awt.Color(26, 54, 93));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Book Appointment");
        btnSave.setBorderPainted(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(26, 54, 93));

        jLabel1.setBackground(new java.awt.Color(13, 110, 253));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SUNRISE DENTAL SERVICE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Appointment Booking Form");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "App ID", "Patient ID", "Dentist", "Treatment", "Date", "Time"
            }
        ));
        tblAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAppointmentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAppointments);

        jLabel8.setText("Appointment ID:");

        btnUpdate.setBackground(new java.awt.Color(102, 102, 102));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(204, 204, 204));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave))
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDentistName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(61, 61, 61)
                                    .addComponent(txtAppointmentId))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(90, 90, 90)
                                    .addComponent(txtPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(104, 119, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDentistName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
            if (txtPatientId.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Patient ID!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int patientId = Integer.parseInt(txtPatientId.getText().trim());
            String dentistName = txtDentistName.getText().trim();
            String treatmentType = cmbTreatment.getSelectedItem().toString();
            String date = txtDate.getText().trim();
            String time = txtTime.getText().trim();

            boolean success = appointmentController.createAppointment(patientId, dentistName, treatmentType, date, time);

            if (success) {
                JOptionPane.showMessageDialog(this, "Appointment Booked Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadAppointmentTable();
                btnClearActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Book Appointment!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric Patient ID!", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                       

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        txtAppointmentId.setText("");
        txtPatientId.setText("");
        txtDentistName.setText("");
        txtDate.setText("");
        txtTime.setText("");
        cmbTreatment.setSelectedIndex(0);
    }                                        

    private void tblAppointmentsMouseClicked(java.awt.event.MouseEvent evt) {                                             
        int selectedRow = tblAppointments.getSelectedRow();
        if (selectedRow != -1) {
            javax.swing.table.TableModel model = tblAppointments.getModel();

            txtAppointmentId.setText(model.getValueAt(selectedRow, 0).toString());
            txtPatientId.setText(model.getValueAt(selectedRow, 1).toString());
            txtDentistName.setText(model.getValueAt(selectedRow, 2).toString());
            cmbTreatment.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
            txtDate.setText(model.getValueAt(selectedRow, 4).toString());
            txtTime.setText(model.getValueAt(selectedRow, 5).toString());
        }
    }                                            

private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
    try {
        String appIdStr = txtAppointmentId.getText().trim();
        if (appIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an appointment from the table to update!");
            return;
        }

        int appointmentId = Integer.parseInt(appIdStr);
        int patientId = Integer.parseInt(txtPatientId.getText().trim());
        String dentistName = txtDentistName.getText().trim();
        String treatmentType = cmbTreatment.getSelectedItem().toString();
        String date = txtDate.getText().trim();
        String time = txtTime.getText().trim();

        boolean success = appointmentController.updateAppointment(appointmentId, patientId, dentistName, treatmentType, date, time);

        if (success) {
            JOptionPane.showMessageDialog(this, "Appointment Updated Successfully!");
            loadAppointmentTable();
            btnClearActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to Update Appointment!");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numeric IDs!", "Validation Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}                                       

private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
    try {
        String appIdStr = txtAppointmentId.getText().trim();
        if (appIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an appointment to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this appointment?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int appointmentId = Integer.parseInt(appIdStr);

          
            boolean success = appointmentController.deleteAppointment(appointmentId);

            if (success) {
                JOptionPane.showMessageDialog(this, "Appointment Deleted Successfully!");
                loadAppointmentTable();
                btnClearActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Delete Appointment!");
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid Appointment ID!", "Validation Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbTreatment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAppointments;
    private javax.swing.JTextField txtAppointmentId;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDentistName;
    private javax.swing.JTextField txtPatientId;
    private javax.swing.JTextField txtTime;
    // End of variables declaration                     
}