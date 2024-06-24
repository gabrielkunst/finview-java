package main.java.com.gk.finview.repositories.inMemory;

import main.java.com.gk.finview.models.PaymentMethod;
import main.java.com.gk.finview.repositories.PaymentMethodRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPaymentMethodRepository implements PaymentMethodRepository {
    private final List<PaymentMethod> paymentMethods = new ArrayList<>();

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    @Override
    public PaymentMethod getPaymentMethodById(int id) {
        return paymentMethods.stream()
                .filter(paymentMethod -> paymentMethod.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
