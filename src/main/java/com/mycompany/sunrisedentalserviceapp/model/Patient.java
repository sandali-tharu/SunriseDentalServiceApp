package com.mycompany.sunrisedentalserviceapp.model;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String contactNo;
    private String address;

    public Patient() {}

    // Constructor with ID
    public Patient(int patientId, String name, int age, String contactNo, String address) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNo = contactNo;
        this.address = address;
    }

    // Constructor without ID (For New Registration)
    public Patient(String name, int age, String contactNo, String address) {
        this.name = name;
        this.age = age;
        this.contactNo = contactNo;
        this.address = address;
    }

    // Getters and Setters
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}