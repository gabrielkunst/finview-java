package main.java.com.gk.finview.repositories.mySQL;

import main.java.com.gk.finview.models.TransactionType;
import main.java.com.gk.finview.repositories.TransactionTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLTransactionTypeRepository implements TransactionTypeRepository {
    private final Connection connection;

    public MySQLTransactionTypeRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<TransactionType> getTransactionTypes() {
        String sql = "SELECT * FROM tipo_transacao";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            List<TransactionType> transactionTypes = new ArrayList<>();

            while (result.next()) {
                TransactionType transactionType = new TransactionType();
                transactionType.setId(result.getInt("tipo_id"));
                transactionType.setName(result.getString("nome"));
                transactionType.setValue(result.getString("valor"));

                transactionTypes.add(transactionType);
            }

            return transactionTypes;
        } catch (SQLException error) {
            System.err.println(error.getMessage());
            throw new RuntimeException("Error getting transaction types " + error.getMessage());
        }
    }
}
