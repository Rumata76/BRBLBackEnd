package be.burundiroots.BRBLBackEnd.bll.service;


import be.burundiroots.BRBLBackEnd.dl.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> getAllRoles();
    Optional<Role> getRoleById(Long id);

    Role createRole(Role role);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);

}
