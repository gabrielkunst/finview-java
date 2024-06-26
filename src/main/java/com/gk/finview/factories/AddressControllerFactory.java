package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.controllers.AddressController;
import main.java.com.gk.finview.repositories.AddressRepository;
import main.java.com.gk.finview.repositories.mySQL.MySQLAddressRepository;
import main.java.com.gk.finview.services.AddressService;

import java.sql.Connection;

public class AddressControllerFactory {
    public static AddressController createAddressController(Connection connection) {
        AddressRepository addressRepository = new MySQLAddressRepository(connection);
        AddressService addressService = new AddressService(addressRepository);
        return new AddressController(addressService);
    }
}
