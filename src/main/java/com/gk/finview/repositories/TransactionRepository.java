package main.java.com.gk.finview.repositories;

import main.java.com.gk.finview.models.Transaction;

import java.util.List;

public interface TransactionRepository {
    Transaction createTransaction(Transaction transaction);
    Transaction getTransactionById(int id);
    List<Transaction> getTransactionsByUserId(int userId);
    void updateTransactionById(int id, Transaction transaction);
    void deleteTransactionById(int id);
}
