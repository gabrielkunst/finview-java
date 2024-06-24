package main.java.com.gk.finview.repositories;

import main.java.com.gk.finview.models.User;

public interface UserRepository {
    User createUser(User user);
    User getUserById(int id);
    User deleteUserById(int id);
    User updateUser(User user);
}
