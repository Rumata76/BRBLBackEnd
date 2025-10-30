package be.burundiroots.BRBLBackEnd.api.models.user;

import be.burundiroots.BRBLBackEnd.dl.entities.User;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UserForm(
        String username,

        @NotBlank
        String email,
        String password,
        String firstName,
        String lastName,
        String genre,
        LocalDate birthDate,
        String placeOfBirth ,
        String fixPhone,
        String mobilePhone,
        String nationality
) {
    public User ToEntity() {
        return new User(
                 username,
                 email,
                 password,
                 firstName,
                 lastName,
                 genre,
                 birthDate,
                 placeOfBirth ,
                 fixPhone,
                 mobilePhone,
                 nationality
        );
    }
}
