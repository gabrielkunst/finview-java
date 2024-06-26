package main.java.com.gk.finview;

import main.java.com.gk.finview.controllers.TransactionController;
import main.java.com.gk.finview.factories.TransactionControllerFactory;
import main.java.com.gk.finview.lib.DB;
import main.java.com.gk.finview.models.Transaction;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Connection connection = DB.getConnection();
            System.out.println("DB CONNECTED");

            TransactionController transactionController = TransactionControllerFactory.createTransactionController(connection);

            List<Transaction> transactions = transactionController.getTransactionsByUserId(1);

            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }

            connection.close();
            System.out.println("DB CLOSED");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}