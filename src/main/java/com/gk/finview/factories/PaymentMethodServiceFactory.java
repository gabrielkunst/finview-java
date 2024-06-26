package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.repositories.PaymentMethodRepository;
import main.java.com.gk.finview.repositories.mySQL.MySQLPaymentMethodRepository;
import main.java.com.gk.finview.services.PaymentMethodService;

import java.sql.Connection;

public class PaymentMethodServiceFactory {
    private final Connection connection;

    public PaymentMethodServiceFactory(Connection connection) {
        this.connection = connection;
    }

    public PaymentMethodService createPaymentMethodService() {
        PaymentMethodRepository paymentMethodRepository = new MySQLPaymentMethodRepository(connection);
        return new PaymentMethodService(paymentMethodRepository);
    }
}
