package main.java.com.gk.finview.services;

import main.java.com.gk.finview.models.Category;
import main.java.com.gk.finview.repositories.CategoryRepository;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.createCategory(category);
    }

    public Category updateCategory(Category category) {
        this.getCategoryById(category.getId());

        return categoryRepository.updateCategory(category);
    }

    public Category getCategoryById(int id) {
        Category categoryFromDB = this.categoryRepository.getCategoryById(id);

        if (categoryFromDB == null)  {
            throw new ResourceNotFoundException();
        }

        return categoryFromDB;
    }

    public void deleteCategoryById(int id) {
        this.getCategoryById(id);


        categoryRepository.deleteCategoryById(id);
    }
}
