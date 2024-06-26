package main.java.com.gk.finview.repositories;

import main.java.com.gk.finview.models.User;

public interface UserRepository {
    void createUser(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    void updateUserById(int id, User user);
    void deleteUserById(int id);
}
