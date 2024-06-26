package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.controllers.TransactionController;
import main.java.com.gk.finview.repositories.TransactionRepository;
import main.java.com.gk.finview.repositories.mySQL.MySQLTransactionRepository;
import main.java.com.gk.finview.services.TransactionService;

import java.sql.Connection;

public class TransactionControllerFactory {
    public static TransactionController createTransactionController(Connection connection) {
        TransactionRepository transactionRepository = new MySQLTransactionRepository(connection);
        TransactionService transactionService = new TransactionService(transactionRepository);
        return new TransactionController(transactionService);
    }
}
