package com.indianhive.web.User.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users") // We rename it to 'users' because 'User' is a reserved word in SQL
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password; // This will be encrypted (hashed)

  private String fullName;

  private String phoneNumber; // Good for confirming bookings

  private String role; // "ROLE_CUSTOMER" or "ROLE_ADMIN"

  // --- CONSTRUCTORS ---
  public User() {}

  public User(String email, String password, String fullName, String role, String phoneNumber) {
    this.email = email;
    this.password = password;
    this.fullName = fullName;
    this.role = role;
    this.phoneNumber = phoneNumber;
  }

  // --- GETTERS & SETTERS ---
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }

  public String getFullName() { return fullName; }
  public void setFullName(String fullName) { this.fullName = fullName; }

  public String getPhoneNumber() { return phoneNumber; }
  public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

  public String getRole() { return role; }
  public void setRole(String role) { this.role = role; }

  // --- SECURITY METHODS (Required by Spring Security) ---
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role));
  }

  @Override
  public String getUsername() { return email; } // We use email as the login ID

  @Override
  public boolean isAccountNonExpired() { return true; }
  @Override
  public boolean isAccountNonLocked() { return true; }
  @Override
  public boolean isCredentialsNonExpired() { return true; }
  @Override
  public boolean isEnabled() { return true; }
}
