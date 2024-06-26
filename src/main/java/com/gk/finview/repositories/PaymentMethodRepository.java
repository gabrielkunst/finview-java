package main.java.com.gk.finview.repositories;

import main.java.com.gk.finview.models.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository {
    List<PaymentMethod> getPaymentMethods();
    PaymentMethod getPaymentMethodById(int id);
}
