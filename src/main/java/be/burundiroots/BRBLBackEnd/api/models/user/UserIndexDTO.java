package be.burundiroots.BRBLBackEnd.api.models.user;

import java.time.LocalDate;

public record UserIndexDTO() {

    Long id,
    String username,
    String email,
    String password,
    String firstName,
    String lastName,
    String genre,
    LocalDate birthdate,
}
