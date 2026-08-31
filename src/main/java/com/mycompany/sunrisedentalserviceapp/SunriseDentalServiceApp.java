package com.mycompany.sunrisedentalserviceapp;

import com.mycompany.sunrisedentalserviceapp.view.AppointmentView;

public class SunriseDentalServiceApp {

    public static void main(String[] args) {
        // Form එක visible කරවීම
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentView().setVisible(true);
            }
        });
    }
}