package be.burundiroots.BRBLBackEnd.bll.service.security;

import be.burundiroots.BRBLBackEnd.dl.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface AuthService extends UserDetailsService {

    void register(User user);
}
