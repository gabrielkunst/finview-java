package main.java.com.gk.finview.repositories;

import main.java.com.gk.finview.models.Category;

import java.util.List;

public interface CategoryRepository {
    void createCategory(Category category);
    void updateCategoryById(int id, Category category);
    Category getCategoryById(int id);
    Category getCategoryByName(String name);
    List<Category> getCategoriesByUserId(int userId);
    void deleteCategoryById(int id);
}
