package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.controllers.TransactionTypeController;
import main.java.com.gk.finview.repositories.TransactionTypeRepository;
import main.java.com.gk.finview.repositories.mySQL.MySQLTransactionTypeRepository;
import main.java.com.gk.finview.services.TransactionTypeService;

import java.sql.Connection;

public class TransactionTypeControllerFactory {
    public static TransactionTypeController createTransactionTypeController(Connection connection) {
        TransactionTypeRepository transactionTypeRepository = new MySQLTransactionTypeRepository(connection);
        TransactionTypeService transactionTypeService = new TransactionTypeService(transactionTypeRepository);
        return new TransactionTypeController(transactionTypeService);
    }
}
