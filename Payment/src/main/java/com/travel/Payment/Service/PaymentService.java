package com.travel.Payment.Service;

import com.travel.Payment.Exception.NotFoundException;
import com.travel.Payment.Model.Payment;
import com.travel.Payment.Repository.PaymentRepository;
import com.travel.Payment.Service.Interface.IPaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(String id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found"));
    }

    @Override
    @Transactional
    public Payment createPayment(Payment payment) {
        payment.setId(null);

        return paymentRepository.save(payment);
    }

    @Override
    @Transactional
    public Payment updatePayment(String id, Payment payment) {
        Payment paymentToUpdate = paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found"));

        payment.setId(id);

        return paymentRepository.save(payment);
    }

    @Override
    @Transactional
    public void deletePayment(String id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found"));

        paymentRepository.delete(payment);

    }
}
