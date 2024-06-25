package main.java.com.gk.finview.services;

import main.java.com.gk.finview.repositories.TransactionRepository;

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
