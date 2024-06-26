package main.java.com.gk.finview.controllers;

import main.java.com.gk.finview.models.PaymentMethod;
import main.java.com.gk.finview.services.PaymentMethodService;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

import java.util.List;

public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    public List<PaymentMethod> getPaymentMethods() {
        try {
            return this.paymentMethodService.getPaymentMethods();
        } catch (Exception error) {
            throw new RuntimeException("Ops! Ocorreu um erro ao buscar os métodos de pagamento.");
        }
    }

    public PaymentMethod getPaymentMethodById(int id) {
        try {
            return this.paymentMethodService.getPaymentMethodById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao buscar o método de pagamento.");
        }
    }
}
