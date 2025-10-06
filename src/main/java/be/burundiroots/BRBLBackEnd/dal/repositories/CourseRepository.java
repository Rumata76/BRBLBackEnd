package be.burundiroots.BRBLBackEnd.dal.repositories;

import be.burundiroots.BRBLBackEnd.dl.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

    @Query("select c from Course c where c.name ilike :name")
    Optional<Course> findbyName(@Param("name") String name);
}