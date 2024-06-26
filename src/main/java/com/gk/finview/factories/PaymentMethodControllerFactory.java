package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.controllers.PaymentMethodController;
import main.java.com.gk.finview.repositories.PaymentMethodRepository;
import main.java.com.gk.finview.repositories.mySQL.MySQLPaymentMethodRepository;
import main.java.com.gk.finview.services.PaymentMethodService;

import java.sql.Connection;

public class PaymentMethodControllerFactory {
    public static PaymentMethodController createPaymentMethodController(Connection connection) {
        PaymentMethodRepository paymentMethodRepository = new MySQLPaymentMethodRepository(connection);
        PaymentMethodService paymentMethodService = new PaymentMethodService(paymentMethodRepository);
        return new PaymentMethodController(paymentMethodService);
    }
}
