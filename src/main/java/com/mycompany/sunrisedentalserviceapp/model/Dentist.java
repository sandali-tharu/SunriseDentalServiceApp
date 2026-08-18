package com.mycompany.sunrisedentalserviceapp.model;

public class Dentist {
    private String dentistId;
    private String dentistName;
    private String specialization;
    private double consultationFee;

    public Dentist(String dentistId, String dentistName, String specialization, double consultationFee) {
        this.dentistId = dentistId;
        this.dentistName = dentistName;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public String getDentistId() { return dentistId; }
    public String getDentistName() { return dentistName; }
    public String getSpecialization() { return specialization; }
    public double getFee() { return consultationFee; }
}