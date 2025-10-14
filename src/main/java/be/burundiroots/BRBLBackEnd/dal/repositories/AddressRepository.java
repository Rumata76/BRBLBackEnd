package be.burundiroots.BRBLBackEnd.dal.repositories;

import be.burundiroots.BRBLBackEnd.dl.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}