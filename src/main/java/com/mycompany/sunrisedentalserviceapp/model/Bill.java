package com.mycompany.sunrisedentalserviceapp.model;

import java.util.Date;

public class Bill {
    private String billId;
    private String appointmentId;
    private String patientName;
    private double totalAmount;
    private double discount;
    private double netAmount;
    private String paymentStatus; // e.g., "Paid", "Pending"
    private Date billDate;

    // Default Constructor
    public Bill() {
    }

    // Parameterized Constructor
    public Bill(String billId, String appointmentId, String patientName, double totalAmount, double discount, double netAmount, String paymentStatus, Date billDate) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.netAmount = netAmount;
        this.paymentStatus = paymentStatus;
        this.billDate = billDate;
    }

    // Getters and Setters
    public String getBillId() { return billId; }
    public void setBillId(String billId) { this.billId = billId; }

    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double getNetAmount() { return netAmount; }
    public void setNetAmount(double netAmount) { this.netAmount = netAmount; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public Date getBillDate() { return billDate; }
    public void setBillDate(Date billDate) { this.billDate = billDate; }
}