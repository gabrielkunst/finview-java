package main.java.com.gk.finview.services;

import main.java.com.gk.finview.models.Address;
import main.java.com.gk.finview.repositories.AddressRepository;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void createAddress(Address address) {
        this.addressRepository.createAddress(address);
    }

    public Address getAddressById(int id) {
        Address addressFromDB = this.addressRepository.getAddressById(id);

        if (addressFromDB == null) {
            throw new ResourceNotFoundException();
        }

        return addressFromDB;
    }

    public void updateAddress(Address address) {
        Address addressFromDB = this.addressRepository.getAddressById(address.getId());

        if (addressFromDB == null) {
            throw new ResourceNotFoundException();
        }

        this.addressRepository.updateAddressById(address.getId(), address);
    }

    public void deleteAddressById(int id) {
        Address addressFromDB = this.addressRepository.getAddressById(id);

        if (addressFromDB == null) {
            throw new ResourceNotFoundException();
        }

        this.addressRepository.deleteAddressById(id);
    }
}
