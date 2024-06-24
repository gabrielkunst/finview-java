package main.java.com.gk.finview.repositories;

import main.java.com.gk.finview.models.Category;

public interface CategoryRepository {
    Category createCategory(Category category);
    Category updateCategory(Category category);
    Category getCategoryById(int id);
    void deleteCategoryById(int id);
}
