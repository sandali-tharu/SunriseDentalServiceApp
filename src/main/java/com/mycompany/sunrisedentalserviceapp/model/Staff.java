package com.mycompany.sunrisedentalserviceapp.model;

public class Staff extends User {
    private String staffId;
    private String staffName;

    public Staff(int userId, String username, String password, String role, String staffId, String staffName) {
        super(userId, username, password, role);
        this.staffId = staffId;
        this.staffName = staffName;
    }

    public String getStaffId() { return staffId; }
    public String getStaffName() { return staffName; }
}