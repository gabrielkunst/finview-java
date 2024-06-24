package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.repositories.CategoryRepository;
import main.java.com.gk.finview.repositories.inMemory.InMemoryCategoryRepository;
import main.java.com.gk.finview.services.CategoryService;

public class CategoryServiceFactory {
    public static CategoryService createCategoryService() {
        CategoryRepository categoryRepository = new InMemoryCategoryRepository();
        return new CategoryService(categoryRepository);
    }
}
