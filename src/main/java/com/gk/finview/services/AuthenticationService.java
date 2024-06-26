package main.java.com.gk.finview.services;

import main.java.com.gk.finview.models.Address;
import main.java.com.gk.finview.models.User;
import main.java.com.gk.finview.repositories.AddressRepository;
import main.java.com.gk.finview.repositories.UserRepository;

public class AuthenticationService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public AuthenticationService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public User register(User user, Address address) {
        Address createdAddress = this.addressRepository.createAddress(address);

        user.setAddressId(createdAddress.getId());

        return this.userRepository.createUser(user);
    }

    public User login(String email, String password) {
        return this.userRepository.getUserByEmail(email);
    }
}
