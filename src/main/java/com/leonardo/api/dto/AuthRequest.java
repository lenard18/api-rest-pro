package com.leonardo.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AuthRequest {
    @Email(message = "Email inválido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    public String getEmail()           { return email; }
    public void setEmail(String e)     { this.email = e; }
    public String getPassword()        { return password; }
    public void setPassword(String p)  { this.password = p; }
}
