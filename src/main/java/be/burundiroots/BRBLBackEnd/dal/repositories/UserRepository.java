package be.burundiroots.BRBLBackEnd.dal.repositories;

import be.burundiroots.BRBLBackEnd.dl.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("select u from User u where u.email ilike :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("select count(u)>0 from User u where u.email ilike :email")
    boolean existsByEmail(@Param("email") String email);
}
