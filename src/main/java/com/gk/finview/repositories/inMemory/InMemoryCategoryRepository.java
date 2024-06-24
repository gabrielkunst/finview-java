package main.java.com.gk.finview.repositories.inMemory;

import main.java.com.gk.finview.models.Category;
import main.java.com.gk.finview.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCategoryRepository implements CategoryRepository {
    private final List<Category> categories = new ArrayList<>();

    @Override
    public Category createCategory(Category category) {
        int id = categories.size() + 1;

        category.setId(id);
        categories.add(category);

        return category;
    }

    @Override
    public Category updateCategory(Category category) {
        Category categoryToUpdate = this.getCategoryById(category.getId());

        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setColor(category.getColor());

        return categoryToUpdate;
    }

    @Override
    public Category getCategoryById(int id) {
        return categories.stream().filter(category -> category.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void deleteCategoryById(int id) {
        Category categoryToDelete = this.getCategoryById(id);

        categories.remove(categoryToDelete);
    }
}
