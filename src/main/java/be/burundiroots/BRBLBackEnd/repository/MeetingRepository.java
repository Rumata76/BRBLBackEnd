package be.burundiroots.BRBLBackEnd.repository;

import be.burundiroots.BRBLBackEnd.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long>{

    Optional<Meeting> findbyName(String name);
}