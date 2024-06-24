package main.java.com.gk.finview.repositories.inMemory;

import main.java.com.gk.finview.models.Address;
import main.java.com.gk.finview.models.User;
import main.java.com.gk.finview.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        int id = users.size() + 1;

        Address userAddress = user.getAddress();
        userAddress.setId(id);
        user.setId(id);
        users.add(user);

        return user;
    }

    @Override
    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public User deleteUserById(int id) {
        User userToDelete = this.getUserById(id);

        if (userToDelete != null) {
            userToDelete.setDeletedAt(LocalDateTime.now());
        }

        return userToDelete;
    }

    @Override
    public User updateUser(User user) {
        User userToUpdate = this.getUserById(user.getId());

        if (userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setCpf(user.getCpf());
            userToUpdate.setAddress(user.getAddress());
        }

        return userToUpdate;
    }
}
