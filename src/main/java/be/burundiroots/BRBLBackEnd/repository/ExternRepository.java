package be.burundiroots.BRBLBackEnd.repository;

import be.burundiroots.BRBLBackEnd.model.Extern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ExternRepository extends JpaRepository<Extern, Long>{

    Optional<Extern> findbyName(String name);
}