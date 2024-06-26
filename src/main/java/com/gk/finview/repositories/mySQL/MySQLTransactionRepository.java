package main.java.com.gk.finview.repositories.mySQL;

import main.java.com.gk.finview.models.Transaction;
import main.java.com.gk.finview.repositories.TransactionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLTransactionRepository implements TransactionRepository {
    private final Connection connection;

    public MySQLTransactionRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        String sql = "INSERT INTO transacao (nome, descricao, valor, tipo_id, metodo_id, categoria_id, usuario_id, status_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, transaction.getName());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setInt(4, transaction.getTransactionTypeId());
            preparedStatement.setInt(5, transaction.getPaymentMethodId());
            preparedStatement.setInt(6, transaction.getCategoryId());
            preparedStatement.setInt(7, transaction.getCreatedBy());
            preparedStatement.setInt(8, 2);

            preparedStatement.executeUpdate();
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                transaction.setId(generatedKeys.getInt(1));
            }
            
            return transaction;
        } catch (SQLException error) {
            System.err.println(error.getMessage());
            throw new RuntimeException("Error creating transaction " + error.getMessage());
        }
    }

    @Override
    public Transaction getTransactionById(int id) {
        String sql = "SELECT * FROM transacao WHERE transacao_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Transaction transaction = null;

            if (resultSet.next()) {
                transaction = new Transaction();
                transaction.setId(resultSet.getInt("transacao_id"));
                transaction.setName(resultSet.getString("nome"));
                transaction.setDescription(resultSet.getString("descricao"));
                transaction.setAmount(resultSet.getDouble("valor"));
                transaction.setTransactionTypeId(resultSet.getInt("tipo_id"));
                transaction.setPaymentMethodId(resultSet.getInt("metodo_id"));
                transaction.setCategoryId(resultSet.getInt("categoria_id"));
                transaction.setCreatedBy(resultSet.getInt("usuario_id"));
                transaction.setCreatedAt(resultSet.getDate("criado_em"));
                transaction.setDeletedAt(resultSet.getDate("deletado_em"));
            }

            return transaction;
        } catch (SQLException error) {
            System.err.println(error.getMessage());
            throw new RuntimeException("Error getting transaction by id " + error.getMessage());
        }
    }

    @Override
    public List<Transaction> getTransactionsByUserId(int userId) {
        String sql = "SELECT * FROM transacao WHERE usuario_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Transaction> transactions = new ArrayList<>();

            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("transacao_id"));
                transaction.setName(resultSet.getString("nome"));
                transaction.setDescription(resultSet.getString("descricao"));
                transaction.setAmount(resultSet.getDouble("valor"));
                transaction.setTransactionTypeId(resultSet.getInt("tipo_id"));
                transaction.setPaymentMethodId(resultSet.getInt("metodo_id"));
                transaction.setCategoryId(resultSet.getInt("categoria_id"));
                transaction.setCreatedBy(resultSet.getInt("usuario_id"));
                transaction.setCreatedAt(resultSet.getDate("criado_em"));
                transaction.setDeletedAt(resultSet.getDate("deletado_em"));

                transactions.add(transaction);
            }

            return transactions;
        } catch (SQLException error) {
            System.err.println(error.getMessage());
            throw new RuntimeException("Error getting transactions by user id " + error.getMessage());
        }
    }

    @Override
    public void updateTransactionById(int id, Transaction transaction) {
        String sql = "UPDATE transacao SET nome = ?, descricao = ?, valor = ?, tipo_id = ?, metodo_id = ?, categoria_id = ?, usuario_id = ? WHERE transacao_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, transaction.getName());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setInt(4, transaction.getTransactionTypeId());
            preparedStatement.setInt(5, transaction.getPaymentMethodId());
            preparedStatement.setInt(6, transaction.getCategoryId());
            preparedStatement.setInt(7, transaction.getCreatedBy());
            preparedStatement.setInt(8, id);

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            System.err.println(error.getMessage());
            throw new RuntimeException("Error updating transaction by id " + error.getMessage());
        }
    }

    @Override
    public void deleteTransactionById(int id) {
        String sql = "UPDATE transacao SET deletado_em = NOW() WHERE transacao_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            System.err.println(error.getMessage());
            throw new RuntimeException("Error deleting transaction by id " + error.getMessage());
        }
    }
}
