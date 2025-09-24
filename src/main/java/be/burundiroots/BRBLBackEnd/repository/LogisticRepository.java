package be.burundiroots.BRBLBackEnd.repository;

import be.burundiroots.BRBLBackEnd.model.Logistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LogisticRepository extends JpaRepository<Logistic, Long>{

    Optional<Logistic> findbyName(String name);
}
