package com.mycompany.sunrisedentalserviceapp.model;

/**
 * Model class representing a Patient entity
 */
public class Patient {
    private int patientId;
    private String name;
    private String address;
    private String contactNumber;
    private String medicalHistory;

    // Default Constructor
    public Patient() {
    }

    // Full Parameterized Constructor
    public Patient(int patientId, String name, String address, String contactNumber, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.medicalHistory = medicalHistory;
    }

    // Constructor without ID (for Database insert operations)
    public Patient(String name, String address, String contactNumber, String medicalHistory) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.medicalHistory = medicalHistory;
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}