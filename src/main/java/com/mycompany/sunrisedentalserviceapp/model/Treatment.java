package com.mycompany.sunrisedentalserviceapp.model;

public class Treatment {
    private String treatmentId;
    private String treatmentName;
    private double fee;

    public Treatment(String treatmentId, String treatmentName, double fee) {
        this.treatmentId = treatmentId;
        this.treatmentName = treatmentName;
        this.fee = fee;
    }

    public String getTreatmentId() { return treatmentId; }
    public String getTreatmentName() { return treatmentName; }
    public double getFee() { return fee; }
}