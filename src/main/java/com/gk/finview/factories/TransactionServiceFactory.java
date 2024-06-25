package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.repositories.TransactionRepository;
import main.java.com.gk.finview.repositories.inMemory.InMemoryTransactionRepository;
import main.java.com.gk.finview.services.TransactionService;

public class TransactionServiceFactory {
    public static TransactionService createTransactionService() {
        TransactionRepository transactionRepository = new InMemoryTransactionRepository();
        return new TransactionService(transactionRepository);
    }
}
