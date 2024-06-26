package main.java.com.gk.finview.repositories.mySQL;

import main.java.com.gk.finview.models.User;
import main.java.com.gk.finview.repositories.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLUserRepository implements UserRepository {
    private final Connection connection;

    public MySQLUserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User createUser(User user) {
        String sql = "INSERT INTO usuario (nome, cpf, email, senha, endereco_id, cargo_id) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getCpf());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPasswordHash());
            preparedStatement.setString(5, String.valueOf(user.getAddressId()));
            preparedStatement.setString(6, String.valueOf(user.getRoleId()));

            preparedStatement.executeUpdate();
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
          
            return user;
        } catch (Exception error) {
            throw new RuntimeException("Error creating user: " + error.getMessage());
        }

    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM usuario WHERE usuario_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet result = preparedStatement.executeQuery();

            User user = null;

            while (result.next()) {
                user = new User();
                user.setId(result.getInt("usuario_id"));
                user.setName(result.getString("nome"));
                user.setCpf(result.getString("cpf"));
                user.setEmail(result.getString("email"));
                user.setPasswordHash(result.getString("senha"));
                user.setAddressId(result.getInt("endereco_id"));
                user.setRoleId(result.getInt("cargo_id"));
                user.setCreatedAt(result.getDate("criado_em"));
                user.setDeletedAt(result.getDate("deletado_em"));
            }

            return user;
        } catch (Exception error) {
            throw new RuntimeException("Error getting user: " + error.getMessage());
        }
    }

    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet result = preparedStatement.executeQuery();

            User user = null;

            while (result.next()) {
                user = new User();
                user.setId(result.getInt("usuario_id"));
                user.setName(result.getString("nome"));
                user.setCpf(result.getString("cpf"));
                user.setEmail(result.getString("email"));
                user.setPasswordHash(result.getString("senha"));
                user.setAddressId(result.getInt("endereco_id"));
                user.setRoleId(result.getInt("cargo_id"));
                user.setCreatedAt(result.getDate("criado_em"));
                user.setDeletedAt(result.getDate("deletado_em"));
            }

            return user;
        } catch (Exception error) {
            throw new RuntimeException("Error getting user: " + error.getMessage());
        }
    }

    @Override
    public void updateUserById(int id, User user) {
        String sql = "UPDATE usuario SET nome = ?, cpf = ?, email = ?, senha = ? WHERE usuario_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getCpf());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPasswordHash());
            preparedStatement.setString(5, String.valueOf(id));

            preparedStatement.executeUpdate();
        } catch (Exception error) {
            throw new RuntimeException("Error updating user: " + error.getMessage());
        }
    }

    @Override
    public void deleteUserById(int id) {
        String sql = "UPDATE usuario SET deletado_em = NOW() WHERE usuario_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(id));

            preparedStatement.executeUpdate();
        } catch (Exception error) {
            throw new RuntimeException("Error deleting user: " + error.getMessage());
        }
    }
}
