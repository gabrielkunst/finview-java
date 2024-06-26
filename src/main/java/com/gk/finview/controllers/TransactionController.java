package main.java.com.gk.finview.controllers;

import main.java.com.gk.finview.models.Transaction;
import main.java.com.gk.finview.services.TransactionService;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

import java.util.List;

public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void createTransaction(Transaction transaction) {
        try {
            this.transactionService.createTransaction(transaction);
        } catch (Exception error) {
            throw new RuntimeException("Ops! Ocorreu um erro ao criar a transação");
        }
    }

    public Transaction getTransactionById(int id) {
        try {
            return this.transactionService.getTransactionById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException("Ops! A transação não foi encontrada");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao buscar a transação");
        }
    }

    public List<Transaction> getTransactionsByUserId(int userId) {
        try {
            return this.transactionService.getTransactionsByUserId(userId);
        } catch (Exception error) {
            throw new RuntimeException("Ops! Ocorreu um erro ao buscar as transações");
        }
    }

    public void updateTransaction(Transaction transaction) {
        try {
            this.transactionService.updateTransaction(transaction);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException("Ops! A transação não foi encontrada");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao atualizar a transação");
        }
    }

    public void deleteTransactionById(int id) {
        try {
            this.transactionService.deleteTransactionById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException("Ops! A transação não foi encontrada");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao deletar a transação");
        }
    }
}
