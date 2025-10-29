package be.burundiroots.BRBLBackEnd.api.models.user;

import be.burundiroots.BRBLBackEnd.dl.entities.User;

import java.time.LocalDate;

public record UserIndexDTO(

        Long id,
        String username,
        String email,
        String password,
        String firstName,
        String lastName,
        String genre,
        LocalDate birthDate,
        String placeOfBirth ,
        String mobilePhone,
        String nationality
) {
    public static UserIndexDTO fromEntity(User user){
        return new UserIndexDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstname(),
                user.getLastname(),
                user.getGenre(),
                user.getBirthDate(),
                user.getPlaceOfBirth(),
                user.getMobilePhone(),
                user.getNationality()
        );
    }
}
