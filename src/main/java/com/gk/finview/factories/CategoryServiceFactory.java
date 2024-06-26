package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.repositories.CategoryRepository;
import main.java.com.gk.finview.repositories.mySQL.MySQLCategoryRepository;
import main.java.com.gk.finview.services.CategoryService;

import java.sql.Connection;

public class CategoryServiceFactory {
    private final Connection connection;

    public CategoryServiceFactory(Connection connection) {
        this.connection = connection;
    }

    public CategoryService createCategoryService() {
        CategoryRepository categoryRepository = new MySQLCategoryRepository(connection);
        return new CategoryService(categoryRepository);
    }
}
