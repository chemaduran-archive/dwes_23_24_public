package velazquez._5_spring_security_jpa.controller.response;

import java.util.Objects;

public class AuthenticationResponse {
  private final String token;

  public AuthenticationResponse(String token) {
    this.token = token;
  }

  public AuthenticationResponse() {
    this.token = null;
  }

  @Override
  public String toString() {
    return "AuthenticationResponse{" + "token='" + token + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AuthenticationResponse that = (AuthenticationResponse) o;
    return Objects.equals(token, that.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token);
  }

  public String getToken() {
    return token;
  }
}
