package com.mycompany.sunrisedentalserviceapp.model;

public class Dentist {
    private String dentistId;
    private String name;
    private String specialization;
    private String phone;
    private String email;
    private String qualification;

    
    public Dentist() {
    }

    // Parameterized Constructor
    public Dentist(String dentistId, String name, String specialization, String phone, String email, String qualification) {
        this.dentistId = dentistId;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.qualification = qualification;
    }

    // Getters and Setters
    public String getDentistId() { return dentistId; }
    public void setDentistId(String dentistId) { this.dentistId = dentistId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }
}