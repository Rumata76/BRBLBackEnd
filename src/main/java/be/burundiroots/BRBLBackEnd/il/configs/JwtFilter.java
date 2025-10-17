package be.burundiroots.BRBLBackEnd.il.configs;

import be.burundiroots.BRBLBackEnd.bll.service.security.AuthService;
import be.burundiroots.BRBLBackEnd.il.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorisation = request.getHeader("Authorization");

        if(authorisation != null && authorisation.startsWith("Bearer ")) {
            String token = authorisation.substring(7);

            if(jwtUtil.isValid(token)) {
                String username = jwtUtil.getEmail(token);
                UserDetails user = authService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken upt = new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        user.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(upt);
            }
        }
        filterChain.doFilter(request, response);
    }
}
