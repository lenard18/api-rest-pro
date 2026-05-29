package com.leonardo.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "Email inválido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    public String getNombre()          { return nombre; }
    public void setNombre(String n)    { this.nombre = n; }
    public String getEmail()           { return email; }
    public void setEmail(String e)     { this.email = e; }
    public String getPassword()        { return password; }
    public void setPassword(String p)  { this.password = p; }
}
