package be.burundiroots.BRBLBackEnd.api.models.auth;

import be.burundiroots.BRBLBackEnd.api.models.role.RoleDto;
import be.burundiroots.BRBLBackEnd.dl.entities.Role;
import be.burundiroots.BRBLBackEnd.dl.entities.User;

import java.util.List;
import java.util.Set;

public record UserSessionDto(
    Long id,
    String username,
    List<RoleDto> roles
) {

    public static  UserSessionDto fromEntity(User user){
        return new UserSessionDto(
                user.getId(),
                user.getUsername(),
                user.getRoles().stream().map(RoleDto::fromEntity).toList()
        );
    }
}
