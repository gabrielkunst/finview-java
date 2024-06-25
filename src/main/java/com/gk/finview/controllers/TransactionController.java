package main.java.com.gk.finview.controllers;

import main.java.com.gk.finview.services.TransactionService;

public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
}
