package main.java.com.gk.finview.repositories;

import main.java.com.gk.finview.models.Address;

public interface AddressRepository {
    void createAddress(Address address);
    Address getAddressById(int id);
    void updateAddressById(int id, Address address);
    void deleteAddressById(int id);
}
