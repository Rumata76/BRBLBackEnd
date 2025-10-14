package be.burundiroots.BRBLBackEnd.bll.service.security.impls;

import be.burundiroots.BRBLBackEnd.bll.service.security.AuthService;
import be.burundiroots.BRBLBackEnd.dal.repositories.UserRepository;
import be.burundiroots.BRBLBackEnd.dl.entities.Role;
import be.burundiroots.BRBLBackEnd.dl.entities.User;
import be.burundiroots.BRBLBackEnd.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("User with email " + user.getEmail() + " already exists");
        }

        user.setRoles(List.of(new Role(UserRole.PARTICIPANT)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User with email " + email + " not found"));
    }
}
