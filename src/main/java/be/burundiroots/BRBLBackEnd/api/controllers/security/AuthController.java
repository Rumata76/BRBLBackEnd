package be.burundiroots.BRBLBackEnd.api.controllers.security;

import be.burundiroots.BRBLBackEnd.api.models.auth.LoginForm;
import be.burundiroots.BRBLBackEnd.api.models.auth.UserSessionDto;
import be.burundiroots.BRBLBackEnd.api.models.auth.UserTokenDto;
import be.burundiroots.BRBLBackEnd.bll.service.security.AuthService;
import be.burundiroots.BRBLBackEnd.dl.entities.User;
import be.burundiroots.BRBLBackEnd.il.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginForm form
    ) {
        User user = authService.login(form.login(), form.password());

        String token = jwtUtil.generateToken(user);

        UserTokenDto dto = new UserTokenDto(UserSessionDto.fromEntity(user), token);
        return ResponseEntity.ok(dto);
    }
}
