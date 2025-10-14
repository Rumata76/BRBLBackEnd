package be.burundiroots.BRBLBackEnd.dal.repositories;

import be.burundiroots.BRBLBackEnd.dl.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>{

    @Query("select p from Permission p where p.ressource = :ressource")
    Optional<Permission> findbyRessource(@Param("ressource") String ressource);
}