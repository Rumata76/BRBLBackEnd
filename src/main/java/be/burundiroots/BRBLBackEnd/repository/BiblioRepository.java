package be.burundiroots.BRBLBackEnd.repository;

import be.burundiroots.BRBLBackEnd.model.Biblio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BiblioRepository extends JpaRepository<Biblio, Long>{

    Optional<Biblio> findbyName(String name);
}