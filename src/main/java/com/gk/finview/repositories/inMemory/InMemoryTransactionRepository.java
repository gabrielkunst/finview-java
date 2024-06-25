package main.java.com.gk.finview.repositories.inMemory;

import main.java.com.gk.finview.models.Transaction;
import main.java.com.gk.finview.repositories.TransactionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTransactionRepository implements TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public Transaction createTransaction(Transaction transaction) {
        int id = transactions.size() + 1;

        transaction.setId(id);
        transactions.add(transaction);

        return transaction;
    }

    @Override
    public Transaction getTransactionById(int id) {
        return transactions.stream().filter(transaction -> transaction.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        Transaction transactionToUpdate = this.getTransactionById(transaction.getId());

        transactionToUpdate.setName(transaction.getName());
        transactionToUpdate.setDescription(transaction.getDescription());
        transactionToUpdate.setCategory(transaction.getCategory());
        transactionToUpdate.setTransactionType(transaction.getTransactionType());
        transactionToUpdate.setPaymentMethod(transaction.getPaymentMethod());
        transactionToUpdate.setPaymentStatus(transaction.getPaymentStatus());
        transactionToUpdate.setAmount(transaction.getAmount());

        return transactionToUpdate;
    }

    @Override
    public Transaction deleteTransactionById(int id) {
        Transaction transactionToDelete = this.getTransactionById(id);

        transactionToDelete.setDeletedAt(LocalDateTime.now());

        return transactionToDelete;
    }

    @Override
    public List<Transaction> getTransactionsByUserId(int userId) {
        return transactions.stream().filter(transaction -> transaction.getCreatedBy().getId() == userId).toList(); } }
