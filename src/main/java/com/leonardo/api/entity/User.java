package com.leonardo.api.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    public enum Rol { ADMIN, USER }

    public User() {}

    public User(Long id, String nombre, String email, String password, Rol rol) {
        this.id = id; this.nombre = nombre; this.email = email;
        this.password = password; this.rol = rol;
    }

    // Builder
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private Long id; private String nombre; private String email;
        private String password; private Rol rol;
        public Builder id(Long id)             { this.id = id; return this; }
        public Builder nombre(String nombre)   { this.nombre = nombre; return this; }
        public Builder email(String email)     { this.email = email; return this; }
        public Builder password(String p)      { this.password = p; return this; }
        public Builder rol(Rol rol)            { this.rol = rol; return this; }
        public User build() { return new User(id, nombre, email, password, rol); }
    }

    // Getters & Setters
    public Long getId()                { return id; }
    public void setId(Long id)         { this.id = id; }
    public String getNombre()          { return nombre; }
    public void setNombre(String n)    { this.nombre = n; }
    public String getEmail()           { return email; }
    public void setEmail(String e)     { this.email = e; }
    public void setPassword(String p)  { this.password = p; }
    public Rol getRol()                { return rol; }
    public void setRol(Rol rol)        { this.rol = rol; }

    // UserDetails
    @Override public String getPassword()   { return password; }
    @Override public String getUsername()   { return email; }
    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + rol.name()));
    }
    @Override public boolean isAccountNonExpired()     { return true; }
    @Override public boolean isAccountNonLocked()      { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled()               { return true; }
}
