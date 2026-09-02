package com.mycompany.sunrisedentalserviceapp.model;

public class Staff extends User {
    private String staffId;
    private String staffName;

    // Default Constructor
    public Staff() {
        super();
    }

    public Staff(int userId, String username, String password, String role, String staffId, String staffName) {
        super(userId, username, password, role);
        this.staffId = staffId;
        this.staffName = staffName;
    }

    // Getters and Setters
    public String getStaffId() { return staffId; }
    public void setStaffId(String staffId) { this.staffId = staffId; }

    public String getStaffName() { return staffName; }
    public void setStaffName(String staffName) { this.staffName = staffName; }
}