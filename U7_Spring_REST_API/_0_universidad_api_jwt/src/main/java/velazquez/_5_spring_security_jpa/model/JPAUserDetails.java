package velazquez._5_spring_security_jpa.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JPAUserDetails implements UserDetails {

  private final String usuario;
  private final String password;
  private final boolean activo;
  private final List<GrantedAuthority> authorities;

  public JPAUserDetails(Usuario usuario) {

    this.usuario = usuario.getEmail();
    this.password = usuario.getPassword();
    this.activo = usuario.isEnabled();
    this.authorities = new ArrayList<>();
    this.authorities.add(new SimpleGrantedAuthority(usuario.getRole()));
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.usuario;
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
    return this.activo;
  }
}
