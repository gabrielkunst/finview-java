package main.java.com.gk.finview.models;

import java.time.LocalDateTime;

public class Category {
    private int id;
    private String name;
    private int createdBy;
    private LocalDateTime createdAt;
    private String color;

    public Category() {
        this.createdAt = LocalDateTime.now();
    }

    public Category(int id, String name, int createdBy, LocalDateTime createdAt, String color) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.color = color;
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

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", color='" + color + '\'' +
                '}';
    }
}
