package com.leonardo.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title       = "API REST Pro",
        version     = "1.0.0",
        description = "API REST Profesional con autenticación JWT, roles y CRUD de productos. " +
                      "Desarrollada por Leonardo Gómez.",
        contact     = @Contact(
            name  = "Leonardo Gómez",
            email = "lg358356@gmail.com",
            url   = "https://github.com/lenard18"
        )
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Servidor local"),
        @Server(url = "https://api-rest-pro.onrender.com", description = "Producción")
    },
    security = @SecurityRequirement(name = "bearerAuth")
)
@SecurityScheme(
    name        = "bearerAuth",
    description = "Token JWT. Obtén el token en /api/auth/login y pégalo aquí como: Bearer <token>",
    scheme      = "bearer",
    type        = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    in          = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {}
