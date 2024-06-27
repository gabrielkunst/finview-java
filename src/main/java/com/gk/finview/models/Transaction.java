package main.java.com.gk.finview.models;

import java.util.Date;

public class Transaction {
    private int id;
    private String name;
    private String description;
    private double amount;
    private TransactionType transactionType;
    private PaymentMethod paymentMethod;
    private Category category;
    private int createdBy;
    private Date paidAt;
    private Date createdAt;
    private Date deletedAt;

    public Transaction() {
        this.createdAt = new Date();
    }

    public Transaction(int id, String name, String description, double amount, TransactionType transactionType, PaymentMethod paymentMethod, Category category, int createdBy, Date paidAt, Date createdAt, Date deletedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.transactionType = transactionType;
        this.paymentMethod = paymentMethod;
        this.category = category;
        this.createdBy = createdBy;
        this.paidAt = paidAt;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", paymentMethod=" + paymentMethod +
                ", category=" + category +
                ", createdBy=" + createdBy +
                ", paidAt=" + paidAt +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
