package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.controllers.CategoryController;
import main.java.com.gk.finview.repositories.CategoryRepository;
import main.java.com.gk.finview.repositories.mySQL.MySQLCategoryRepository;
import main.java.com.gk.finview.services.CategoryService;

import java.sql.Connection;

public class CategoryControllerFactory {
    public static CategoryController createCategoryController(Connection connection) {
        CategoryRepository categoryRepository = new MySQLCategoryRepository(connection);
        CategoryService categoryService = new CategoryService(categoryRepository);
        return new CategoryController(categoryService);
    }
}
