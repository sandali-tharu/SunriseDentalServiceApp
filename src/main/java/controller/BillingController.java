package controller;

import com.mycompany.sunrisedentalserviceapp.dao.BillingDAO;
import com.mycompany.sunrisedentalserviceapp.model.Bill;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class BillingController {

    private final BillingDAO billingDAO = new BillingDAO();

    public boolean saveBill(String billId, String appointmentId, String patientName, double totalAmount, double discount, double netAmount, String paymentStatus) {
        Bill bill = new Bill();
        bill.setBillId(billId);
        bill.setAppointmentId(appointmentId);
        bill.setPatientName(patientName);
        bill.setTotalAmount(totalAmount);
        bill.setDiscount(discount);
        bill.setNetAmount(netAmount);
        bill.setPaymentStatus(paymentStatus);
        bill.setBillDate(new Date()); // Current system date

        return billingDAO.addBill(bill);
    }

    public void loadTableData(DefaultTableModel model) {
        model.setRowCount(0);
        List<Bill> list = billingDAO.getAllBills();
        for (Bill b : list) {
            model.addRow(new Object[]{
                b.getBillId(),
                b.getAppointmentId(),
                b.getPatientName(),
                b.getTotalAmount(),
                b.getDiscount(),
                b.getNetAmount(),
                b.getPaymentStatus(),
                b.getBillDate()
            });
        }
    }
}