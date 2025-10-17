package be.burundiroots.BRBLBackEnd.api.models.auth;

public record UserTokenDto(
        UserSessionDto user,
        String token
) {
}
