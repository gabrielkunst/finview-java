package main.java.com.gk.finview.repositories.mySQL;

import main.java.com.gk.finview.models.Category;
import main.java.com.gk.finview.repositories.CategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoryRepository implements CategoryRepository {
    private final Connection connection;

    public MySQLCategoryRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createCategory(Category category) {
        String sql = "INSERT INTO categoria (nome, usuario_id, cor) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, String.valueOf(category.getCreatedBy()));
            preparedStatement.setString(3, category.getColor());

            preparedStatement.executeUpdate();
        } catch (Exception error) {
            throw new RuntimeException("Error creating category: " + error.getMessage());
        }
    }

    @Override
    public void updateCategoryById(int id, Category category) {
        String sql = "UPDATE categoria SET nome = ?, cor = ? WHERE categoria_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getColor());
            preparedStatement.setString(3, String.valueOf(id));

            preparedStatement.executeUpdate();
        } catch (Exception error) {
            throw new RuntimeException("Error updating category: " + error.getMessage());
        }
    }

    @Override
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM categoria WHERE categoria_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet result = preparedStatement.executeQuery();

            Category category = null;

            while (result.next()) {
                category = new Category();
                category.setId(result.getInt("categoria_id"));
                category.setName(result.getString("nome"));
                category.setCreatedBy(result.getInt("usuario_id"));
                category.setColor(result.getString("cor"));
                category.setCreatedAt(result.getDate("criado_em"));
            }

            return category;
        } catch (Exception error) {
            throw new RuntimeException("Error getting category: " + error.getMessage());
        }
    }

    @Override
    public List<Category> getCategoriesByUserId(int userId) {
        String sql = "SELECT * FROM categoria WHERE usuario_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(userId));

            ResultSet result = preparedStatement.executeQuery();

            List<Category> categories = new ArrayList<>();

            while (result.next()) {
                Category category = new Category();
                category.setId(result.getInt("categoria_id"));
                category.setName(result.getString("nome"));
                category.setCreatedBy(result.getInt("usuario_id"));
                category.setColor(result.getString("cor"));
                category.setCreatedAt(result.getDate("criado_em"));

                categories.add(category);
            }

            return categories;
        } catch (Exception error) {
            throw new RuntimeException("Error getting categories: " + error.getMessage());
        }
    }

    @Override
    public void deleteCategoryById(int id) {
        String sql = "DELETE FROM categoria WHERE categoria_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(id));

            preparedStatement.executeUpdate();
        } catch (Exception error) {
            throw new RuntimeException("Error deleting category: " + error.getMessage());
        }
    }
}
