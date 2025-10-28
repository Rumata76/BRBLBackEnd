package be.burundiroots.BRBLBackEnd.bll.service;


import be.burundiroots.BRBLBackEnd.dl.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Page<User> findAllUsers(Pageable pageable);
    User findUserByEmail(String email);

    Long save(User user);
    void update(Long id, User user);
    void delete(Long id);

}
