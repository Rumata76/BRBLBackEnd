package be.burundiroots.BRBLBackEnd.bll.service.impl;

import be.burundiroots.BRBLBackEnd.bll.service.UserService;
import be.burundiroots.BRBLBackEnd.dal.repositories.UserRepository;
import be.burundiroots.BRBLBackEnd.dl.entities.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CacheManager cacheManager;

    @Override
    @Cacheable(value = "users" , key = "#pageable.pageNumber +'-'+#pageable.pageSize+'-'+#pageable.sort")
    public Page<User> findAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @Override
    @Cacheable(value = "user", key = "#email")
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow();
    }

    @Override
    public Long save(User user){
        Long id =  userRepository.save(user).getId();

        Objects.requireNonNull(cacheManager.getCache("users")).clear();

        return id;
    }

    @Override
    public void update(Long id, User user){
        User existing = userRepository.findById(id).orElseThrow();

        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setRoles(user.getRoles());
        existing.setFirstname(user.getFirstname());
        existing.setLastname(user.getLastname());
        existing.setAddresses(user.getAddresses());
        existing.setCourses(user.getCourses());
        existing.setGenre(user.getGenre());
        existing.setBirthDate(user.getBirthDate());
        existing.setFixPhone(user.getFixPhone());
        existing.setMobilePhone(user.getMobilePhone());
        existing.setNationality(user.getNationality());
        existing.setPlaceOfBirth(user.getPlaceOfBirth());
        existing.setUsername(user.getUsername());

        Objects.requireNonNull(cacheManager.getCache("users")).clear();
        Objects.requireNonNull(cacheManager.getCache("user")).clear();
    }

    @Override
    public void delete(Long id){

        if(!userRepository.existsById(id)){
            throw new EntityNotFoundException("User with id : "+ id+" not found !");
        }

        userRepository.deleteById(id);

        Objects.requireNonNull(cacheManager.getCache("users")).clear();
        Objects.requireNonNull(cacheManager.getCache("user")).evict(id);
    }
}
