package com.travel.Payment.Service.Interface;

import com.travel.Payment.Model.Payment;

import java.util.List;

public interface IPaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(String id);
    Payment createPayment(Payment payment);
    Payment updatePayment(String id, Payment payment);
    void deletePayment(String id);
}
