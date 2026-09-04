package com.mycompany.sunrisedentalserviceapp.model;

public class Appointment {

    private int appointmentId;
    private int patientId;
    private String dentistName;
    private String treatmentType;
    private String appointmentDate;
    private String appointmentTime;

    // Default Constructor
    public Appointment() {
    }

  
    public Appointment(int appointmentId, int patientId, String dentistName, 
                       String treatmentType, String appointmentDate, String appointmentTime) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.dentistName = dentistName;
        this.treatmentType = treatmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

  
    public Appointment(int patientId, String dentistName, String treatmentType, 
                       String appointmentDate, String appointmentTime) {
        this.patientId = patientId;
        this.dentistName = dentistName;
        this.treatmentType = treatmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    // Getters & Setters
    public int getAppointmentId() { 
        return appointmentId; 
    }
    public void setAppointmentId(int appointmentId) { 
        this.appointmentId = appointmentId; 
    }

    public int getPatientId() { 
        return patientId; 
    }
    public void setPatientId(int patientId) { 
        this.patientId = patientId; 
    }

    public String getDentistName() { 
        return dentistName; 
    }
    public void setDentistName(String dentistName) { 
        this.dentistName = dentistName; 
    }

    public String getTreatmentType() { 
        return treatmentType; 
    }
    public void setTreatmentType(String treatmentType) { 
        this.treatmentType = treatmentType; 
    }

    public String getAppointmentDate() { 
        return appointmentDate; 
    }
    public void setAppointmentDate(String appointmentDate) { 
        this.appointmentDate = appointmentDate; 
    }

    public String getAppointmentTime() { 
        return appointmentTime; 
    }
    public void setAppointmentTime(String appointmentTime) { 
        this.appointmentTime = appointmentTime; 
    }
}