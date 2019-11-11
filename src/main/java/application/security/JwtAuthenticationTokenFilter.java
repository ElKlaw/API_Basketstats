package application.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import application.security.service.AuthenticationService;
import application.security.service.JwtTokenService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthenticationTokenFilter extends GenericFilterBean {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Assume we have only one Authorization header value
        final Optional<String> token = Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION));

        Authentication authentication;

        if(token.isPresent()) {
        		String bearerToken = "";
        		if(token.get().startsWith("Bearer ")) {
        			bearerToken = token.get().substring("Bearer ".length());
        		} else {
        			bearerToken = token.get();
        		}
                

                try {
                    Jws<Claims> claims = jwtTokenService.validateJwtToken(bearerToken);
                    authentication = authenticationService.getAuthentication(claims);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } catch (ExpiredJwtException exception) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "error.jwt.expired");
                    return;
                } catch (JwtException exception) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "error.jwt.invalid");
                    return;
                }

        }

        chain.doFilter(servletRequest, servletResponse);

    }

}
