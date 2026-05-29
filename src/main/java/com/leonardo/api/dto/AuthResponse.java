package com.leonardo.api.dto;

public class AuthResponse {
    private String token;
    private String tipo;
    private String email;
    private String rol;
    private String nombre;

    public AuthResponse() {}
    public AuthResponse(String token, String tipo, String email, String rol, String nombre) {
        this.token = token; this.tipo = tipo; this.email = email;
        this.rol = rol; this.nombre = nombre;
    }

    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private String token, tipo, email, rol, nombre;
        public Builder token(String t)   { this.token = t; return this; }
        public Builder tipo(String t)    { this.tipo = t; return this; }
        public Builder email(String e)   { this.email = e; return this; }
        public Builder rol(String r)     { this.rol = r; return this; }
        public Builder nombre(String n)  { this.nombre = n; return this; }
        public AuthResponse build() { return new AuthResponse(token, tipo, email, rol, nombre); }
    }

    public String getToken()   { return token; }
    public String getTipo()    { return tipo; }
    public String getEmail()   { return email; }
    public String getRol()     { return rol; }
    public String getNombre()  { return nombre; }
}
