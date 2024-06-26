package main.java.com.gk.finview.services;

import main.java.com.gk.finview.models.TransactionType;
import main.java.com.gk.finview.repositories.TransactionTypeRepository;

import java.util.List;

public class TransactionTypeService {
    private final TransactionTypeRepository transactionTypeRepository;

    public TransactionTypeService(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    public List<TransactionType> getTransactionTypes() {
        return transactionTypeRepository.getTransactionTypes();
    }
}
