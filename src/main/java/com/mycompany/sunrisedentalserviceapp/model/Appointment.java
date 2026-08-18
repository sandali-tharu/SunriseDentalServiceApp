package com.mycompany.sunrisedentalserviceapp.model;

public class Appointment {

    private int appointmentId;
    private String appointmentNo;
    private int patientId;
    private String dentistName;
    private String treatmentType;
    private String appointmentDate;
    private String appointmentTime;
    private String status;

    public Appointment() {
    }

    public Appointment(int appointmentId, String appointmentNo, int patientId, 
                       String dentistName, String treatmentType, 
                       String appointmentDate, String appointmentTime, String status) {
        this.appointmentId = appointmentId;
        this.appointmentNo = appointmentNo;
        this.patientId = patientId;
        this.dentistName = dentistName;
        this.treatmentType = treatmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    public Appointment(String appointmentNo, int patientId, String dentistName, 
                       String treatmentType, String appointmentDate, 
                       String appointmentTime, String status) {
        this.appointmentNo = appointmentNo;
        this.patientId = patientId;
        this.dentistName = dentistName;
        this.treatmentType = treatmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public String getAppointmentNo() { return appointmentNo; }
    public void setAppointmentNo(String appointmentNo) { this.appointmentNo = appointmentNo; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getDentistName() { return dentistName; }
    public void setDentistName(String dentistName) { this.dentistName = dentistName; }

    public String getTreatmentType() { return treatmentType; }
    public void setTreatmentType(String treatmentType) { this.treatmentType = treatmentType; }

    public String getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(String appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(String appointmentTime) { this.appointmentTime = appointmentTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}