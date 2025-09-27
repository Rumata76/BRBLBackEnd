package be.burundiroots.BRBLBackEnd.service;


import be.burundiroots.BRBLBackEnd.model.User_;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User_> getAllUsers();
    Optional<User_> getUserById(Long id);

    User_ createUser(User_ user);
    User_ updateUser(Long id, User_ user);
    void deleteUser(Long id);

}
