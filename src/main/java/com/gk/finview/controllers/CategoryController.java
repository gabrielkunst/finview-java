package main.java.com.gk.finview.controllers;

import main.java.com.gk.finview.models.Category;
import main.java.com.gk.finview.services.CategoryService;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Category createCategory (Category category) {
        try {
            return this.categoryService.createCategory(category);
        } catch (Exception error) {
            throw new RuntimeException("Ops! Ocorreu um erro ao criar a categoria.");
        }
    }

    public Category updateCategory (Category category) {
        try {
            return this.categoryService.updateCategory(category);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException("Ops! Categoria não encontrada.");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao atualizar a categoria.");
        }
    }

    public Category getCategoryById (int id) {
        try {
            return this.categoryService.getCategoryById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException("Ops! Categoria não encontrada.");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao buscar a categoria.");
        }
    }

    public void deleteCategoryById (int id) {
        try {
            this.categoryService.deleteCategoryById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException("Ops! Categoria não encontrada.");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao deletar a categoria.");
        }
    }
}
