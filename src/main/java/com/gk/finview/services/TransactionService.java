package main.java.com.gk.finview.services;

import main.java.com.gk.finview.models.Transaction;
import main.java.com.gk.finview.repositories.TransactionRepository;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

import java.util.List;

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return this.transactionRepository.createTransaction(transaction);
    }

    public Transaction getTransactionById(int id) {
        Transaction transactionFromDB = this.transactionRepository.getTransactionById(id);

        if (transactionFromDB == null) {
            throw new ResourceNotFoundException();
        }

        return transactionFromDB;
    }

    public List<Transaction> getTransactionsByUserId(int userId) {
        return this.transactionRepository.getTransactionsByUserId(userId);
    }

    public void updateTransaction(Transaction transaction) {
        Transaction transactionFromDB = this.transactionRepository.getTransactionById(transaction.getId());

        if (transactionFromDB == null) {
            throw new ResourceNotFoundException();
        }

        this.transactionRepository.updateTransactionById(transaction.getId(), transaction);
    }

    public void deleteTransactionById(int id) {
        Transaction transactionFromDB = this.transactionRepository.getTransactionById(id);

        if (transactionFromDB == null) {
            throw new ResourceNotFoundException();
        }

        this.transactionRepository.deleteTransactionById(id);
    }
}
