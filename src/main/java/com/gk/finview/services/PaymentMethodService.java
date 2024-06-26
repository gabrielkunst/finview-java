package main.java.com.gk.finview.services;

import main.java.com.gk.finview.models.PaymentMethod;
import main.java.com.gk.finview.repositories.PaymentMethodRepository;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

import java.util.List;

public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return this.paymentMethodRepository.getPaymentMethods();
    }

    public PaymentMethod getPaymentMethodById(int id) {
        PaymentMethod paymentMethodFromDB = this.paymentMethodRepository.getPaymentMethodById(id);

        if (paymentMethodFromDB == null) {
            throw new ResourceNotFoundException();
        }

        return paymentMethodFromDB;
    }

}
