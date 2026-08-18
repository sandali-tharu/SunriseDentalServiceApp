package com.mycompany.sunrisedentalserviceapp.model;

public class Bill {
    private String billId;
    private Appointment appointment;
    private double doctorFee;
    private double treatmentFee;
    private double totalAmount;

    public Bill(String billId, Appointment appointment, double doctorFee, double treatmentFee) {
        this.billId = billId;
        this.appointment = appointment;
        this.doctorFee = doctorFee;
        this.treatmentFee = treatmentFee;
    }

    public double calculateTotal() {
        this.totalAmount = doctorFee + treatmentFee;
        return this.totalAmount;
    }

    public String getBillId() { return billId; }
    public Appointment getAppointment() { return appointment; }
    public double getTotalAmount() { return totalAmount; }
}