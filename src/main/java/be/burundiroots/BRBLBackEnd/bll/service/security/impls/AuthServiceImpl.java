package be.burundiroots.BRBLBackEnd.bll.service.security.impls;

import be.burundiroots.BRBLBackEnd.bll.service.security.AuthService;
import be.burundiroots.BRBLBackEnd.dal.repositories.UserRepository;
import be.burundiroots.BRBLBackEnd.dl.entities.Role;
import be.burundiroots.BRBLBackEnd.dl.entities.User;
import be.burundiroots.BRBLBackEnd.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

    @Override
    public void register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UsernameNotFoundException("Email already in use");
        }
            user.setRoles(Set.of(new Role(UserRole.USER)));
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(user);


    }

    @Override
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new BadCredentialsException("Incorrect password");
        }

        return user;
    }
}
