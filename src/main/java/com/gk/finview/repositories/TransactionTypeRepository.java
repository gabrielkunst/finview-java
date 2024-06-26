package main.java.com.gk.finview.repositories;

import main.java.com.gk.finview.models.TransactionType;

import java.util.List;

public interface TransactionTypeRepository {
    List<TransactionType> getTransactionTypes();
}
