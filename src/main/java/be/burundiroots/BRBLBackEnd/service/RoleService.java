package be.burundiroots.BRBLBackEnd.service;


import be.burundiroots.BRBLBackEnd.model.Roles;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Roles> getAllRoles();
    Optional<Roles> getRoleById(Long id);

    Roles createRole(Roles role);
    Roles updateRole(Long id, Roles role);
    void deleteRole(Long id);

}
