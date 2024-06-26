package main.java.com.gk.finview.controllers;

import main.java.com.gk.finview.models.Category;
import main.java.com.gk.finview.services.CategoryService;
import main.java.com.gk.finview.services.exceptions.ResourceAlreadyExistsException;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

import java.util.List;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void createCategory (Category category) {
        try {
            this.categoryService.createCategory(category);
        } catch (Exception error) {
            if (error instanceof ResourceAlreadyExistsException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao criar a categoria.");
        }
    }

    public void updateCategory (Category category) {
        try {
            this.categoryService.updateCategory(category);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao atualizar a categoria.");
        }
    }

    public Category getCategoryById (int id) {
        try {
            return this.categoryService.getCategoryById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao buscar a categoria.");
        }
    }

    public List<Category> getCategoriesByUserId (int userId) {
        try {
            return this.categoryService.getCategoriesByUserId(userId);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao buscar as categorias.");
        }
    }

    public void deleteCategoryById (int id) {
        try {
            this.categoryService.deleteCategoryById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao deletar a categoria.");
        }
    }
}
