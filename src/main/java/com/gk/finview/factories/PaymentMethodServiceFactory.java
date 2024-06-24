package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.repositories.PaymentMethodRepository;
import main.java.com.gk.finview.repositories.inMemory.InMemoryPaymentMethodRepository;
import main.java.com.gk.finview.services.PaymentMethodService;

public class PaymentMethodServiceFactory {
    public static PaymentMethodService createPaymentMethodService() {
        PaymentMethodRepository paymentMethodRepository = new InMemoryPaymentMethodRepository();
        return new PaymentMethodService(paymentMethodRepository);
    }
}
