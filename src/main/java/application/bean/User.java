package application.bean;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements UserDetails{
	/** uid */
	private static final long serialVersionUID = 6943018284785381734L;

	private Integer id;
 
    private String username;
 
    private String email;
    
    private final String userSecret;
 
    @JsonIgnore
    private String password;
 
    private Collection<? extends GrantedAuthority> authorities;
    
    public User(Integer id, String username, String email, String userSecret, String password, 
            Collection<? extends GrantedAuthority> authorities) {
	      this.id = id;
	      this.username = username;
	      this.email = email;
	      this.password = password;
	      this.authorities = authorities;
	      this.userSecret = userSecret;
    }
    
    public static User build(Utilisateur utilisateur) {
        List<GrantedAuthority> authorities = utilisateur.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());
 
        return new User(
        		utilisateur.getId(),
        		utilisateur.getIdentifiant(),
        		utilisateur.getEmail(),
        		utilisateur.getSecret(),
        		utilisateur.getMotdepasse(),
                authorities
        );
    }
    
    public Integer getId() {
        return id;
    }
 
    public String getEmail() {
        return email;
    }
 
    @Override
    public String getUsername() {
        return username;
    }
 
    public String getUserSecret() {
		return userSecret;
	}

	@Override
    public String getPassword() {
        return password;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
 

}
