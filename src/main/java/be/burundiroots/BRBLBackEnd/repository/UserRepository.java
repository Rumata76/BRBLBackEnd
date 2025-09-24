package be.burundiroots.BRBLBackEnd.repository;

import be.burundiroots.BRBLBackEnd.model.User_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User_, Long>{

    Optional<User_> findByEmail(String email);
    boolean existsByEmail(String email);

}
