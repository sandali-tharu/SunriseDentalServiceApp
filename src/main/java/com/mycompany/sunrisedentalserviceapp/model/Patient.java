package com.mycompany.sunrisedentalserviceapp.model;

/**
 * Model class representing a Patient entity
 */
public class Patient {
    private String patientId;
    private String name;
    private String address;
    private String contactNumber;
    private String medicalHistory;

    // Default Constructor
    public Patient() {
    }

    // Full Parameterized Constructor
    public Patient(String patientId, String name, String address, String contactNumber, String medicalHistory) {
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
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
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