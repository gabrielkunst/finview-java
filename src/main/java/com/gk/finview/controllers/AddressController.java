package main.java.com.gk.finview.controllers;

import main.java.com.gk.finview.models.Address;
import main.java.com.gk.finview.services.AddressService;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    public Address createAddress(Address address) {
        try {
            return this.addressService.createAddress(address);
        } catch (Exception error) {
            throw new RuntimeException("Ops! Ocorreu um erro ao criar o endereço.");
        }
    }

    public Address getAddressById(int id) {
        try {
            return this.addressService.getAddressById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException("Ops! O endereço não foi encontrado.");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao buscar o endereço.");
        }
    }

    public void updateAddress(Address address) {
        try {
            this.addressService.updateAddress(address);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException("Ops! O endereço não foi encontrado.");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao atualizar o endereço.");
        }
    }

    public void deleteAddressById(int id) {
        try {
            this.addressService.deleteAddressById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException("Ops! O endereço não foi encontrado.");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao deletar o endereço.");
        }
    }
}
