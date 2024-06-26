package main.java.com.gk.finview.controllers;

import main.java.com.gk.finview.models.TransactionType;
import main.java.com.gk.finview.services.TransactionTypeService;

import java.util.List;

public class TransactionTypeController {
    private final TransactionTypeService transactionTypeService;

    public TransactionTypeController(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    public List<TransactionType> getTransactionTypes() {
        try {
            return transactionTypeService.getTransactionTypes();
        } catch (Exception error) {
            throw new RuntimeException("Ops! Ocorreu um erro ao buscar os tipos de transação.");
        }
    }
}
