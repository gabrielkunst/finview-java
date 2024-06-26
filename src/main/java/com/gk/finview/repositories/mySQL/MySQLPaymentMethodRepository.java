package main.java.com.gk.finview.repositories.mySQL;

import main.java.com.gk.finview.models.PaymentMethod;
import main.java.com.gk.finview.repositories.PaymentMethodRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQLPaymentMethodRepository implements PaymentMethodRepository {
    private final Connection connection;

    public MySQLPaymentMethodRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        String sql = "SELECT * FROM metodo_pagamento";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            List<PaymentMethod> paymentMethods = new ArrayList<>();

            while (result.next()) {
                PaymentMethod paymentMethod = new PaymentMethod();
                paymentMethod.setId(result.getInt("metodo_id"));
                paymentMethod.setName(result.getString("nome"));
                paymentMethod.setValue(result.getString("valor"));

                paymentMethods.add(paymentMethod);
            }

            return paymentMethods;
        } catch (Exception error) {
            throw new RuntimeException("Error getting payment methods");
        }
    }

    @Override
    public PaymentMethod getPaymentMethodById(int id) {
        String sql = "SELECT * FROM metodo_pagamento WHERE metodo_id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            PaymentMethod paymentMethod = null;

            if (result.next()) {
                paymentMethod = new PaymentMethod();
                paymentMethod.setId(result.getInt("metodo_id"));
                paymentMethod.setName(result.getString("nome"));
                paymentMethod.setValue(result.getString("valor"));
            }

            return paymentMethod;
        } catch (Exception error) {
            throw new RuntimeException("Error getting payment method with id " + id);
        }
    }
}
