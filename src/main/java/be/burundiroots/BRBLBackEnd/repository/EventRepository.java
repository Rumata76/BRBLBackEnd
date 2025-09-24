package be.burundiroots.BRBLBackEnd.repository;

import be.burundiroots.BRBLBackEnd.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

    Optional<Event> findbyName(String name);
}