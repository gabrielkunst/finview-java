package main.java.com.gk.finview.models;

import java.util.Date;

public class Transaction {
    private int id;
    private String name;
    private String description;
    private double amount;
    private int transactionTypeId;
    private int paymentMethodId;
    private int categoryId;
    private int createdBy;
    private Date paidAt;
    private Date createdAt;
    private Date deletedAt;

    public Transaction() {
        this.createdAt = new Date();
    }

    public Transaction(int id, String name, String description, double amount, int transactionTypeId, int paymentMethodId, int categoryId, int createdBy, Date paidAt, Date createdAt, Date deletedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.transactionTypeId = transactionTypeId;
        this.paymentMethodId = paymentMethodId;
        this.categoryId = categoryId;
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

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
                ", transactionTypeId=" + transactionTypeId +
                ", paymentMethodId=" + paymentMethodId +
                ", categoryId=" + categoryId +
                ", createdBy=" + createdBy +
                ", paidAt=" + paidAt +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
