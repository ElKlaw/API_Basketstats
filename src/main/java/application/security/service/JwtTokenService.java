package application.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.security.core.Authentication;

import application.bean.User;
import application.security.model.JwtTokens;

public interface JwtTokenService {

    JwtTokens createTokens(Authentication authentication);
    String createToken(User user);
    String createRefreshToken(User user);

    JwtTokens refreshJwtToken(String token);
    Jws<Claims> validateJwtToken(String token);

}