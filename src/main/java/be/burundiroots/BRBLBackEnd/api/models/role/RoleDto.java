package be.burundiroots.BRBLBackEnd.api.models.role;

import be.burundiroots.BRBLBackEnd.dl.entities.Role;
import be.burundiroots.BRBLBackEnd.dl.enums.UserRole;
import lombok.NonNull;

public record RoleDto(
        Long id,
        String name
        ) {
    public static RoleDto fromEntity(Role r){
        return new RoleDto(
                r.getId(),
                r.getName().toString()
        );
    }


}
