package main.java.com.gk.finview.repositories.mySQL;

import main.java.com.gk.finview.models.Address;
import main.java.com.gk.finview.repositories.AddressRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLAddressRepository implements AddressRepository {
    private final Connection connection;

    public MySQLAddressRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Address createAddress(Address address) {
        String sql = "INSERT INTO endereco (cep, rua, bairro, cidade, uf) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, address.getZipcode());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getNeighborhood());
            preparedStatement.setString(4, address.getCity());
            preparedStatement.setString(5, address.getState());

            preparedStatement.executeUpdate();
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                address.setId(generatedKeys.getInt(1));
            }
          
            return address;
        } catch (Exception error) {
            throw new RuntimeException("Error creating address " + error.getMessage());
        }
    }

    @Override
    public Address getAddressById(int id) {
        String sql = "SELECT * FROM endereco WHERE endereco_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            Address address = null;

            if (result.next()) {
                address = new Address();
                address.setId(result.getInt("endereco_id"));
                address.setZipcode(result.getString("cep"));
                address.setStreet(result.getString("rua"));
                address.setNeighborhood(result.getString("bairro"));
                address.setCity(result.getString("cidade"));
                address.setState(result.getString("uf"));
            }

            return address;
        } catch (Exception error) {
            throw new RuntimeException("Error getting address " + error.getMessage());
        }
    }

    @Override
    public void updateAddressById(int id, Address address) {
        String sql = "UPDATE endereco SET cep = ?, rua = ?, bairro = ?, cidade = ?, uf = ? WHERE endereco_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, address.getZipcode());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getNeighborhood());
            preparedStatement.setString(4, address.getCity());
            preparedStatement.setString(5, address.getState());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
        } catch (Exception error) {
            throw new RuntimeException("Error updating address " + error.getMessage());
        }
    }

    @Override
    public void deleteAddressById(int id) {
        String sql = "DELETE FROM endereco WHERE endereco_id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (Exception error) {
            throw new RuntimeException("Error deleting address " + error.getMessage());
        }
    }
}
