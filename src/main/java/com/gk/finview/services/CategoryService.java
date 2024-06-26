package main.java.com.gk.finview.services;

import main.java.com.gk.finview.models.Category;
import main.java.com.gk.finview.repositories.CategoryRepository;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

import java.util.List;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(Category category) {
        this.categoryRepository.createCategory(category);
    }

    public Category getCategoryById(int id) {
        Category categoryFromDB = this.categoryRepository.getCategoryById(id);

        if (categoryFromDB == null) {
            throw new ResourceNotFoundException();
        }

        return categoryFromDB;
    }

    public List<Category> getCategoriesByUserId(int userId) {
        return this.categoryRepository.getCategoriesByUserId(userId);
    }

    public void updateCategory(Category category) {
        Category categoryFromDB = this.categoryRepository.getCategoryById(category.getId());

        if (categoryFromDB == null) {
            throw new ResourceNotFoundException();
        }

        this.categoryRepository.updateCategoryById(category.getId(), category);
    }

    public void deleteCategoryById(int id) {
        Category categoryFromDB = this.categoryRepository.getCategoryById(id);

        if (categoryFromDB == null) {
            throw new ResourceNotFoundException();
        }

        this.categoryRepository.deleteCategoryById(id);
    }
}
