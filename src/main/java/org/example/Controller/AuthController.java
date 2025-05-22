package org.example.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        if("rumata76@hotmail.com".equals(loginRequest.getEmail()) && "dedansCNJ1!".equals(loginRequest.getPassword())){
            return ResponseEntity.ok("Login Successfull.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants non corrects.");
        }
    }

    static class LoginRequest{
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
}
