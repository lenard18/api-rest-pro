package com.leonardo.api.controller;

import com.leonardo.api.entity.User;
import com.leonardo.api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
@Tag(name = "Admin", description = "Endpoints exclusivos para administradores")
@SecurityRequirement(name = "bearerAuth")
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/usuarios")
    @Operation(summary = "Listar todos los usuarios (solo ADMIN)")
    public ResponseEntity<List<User>> listarUsuarios() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/stats")
    @Operation(summary = "Estadísticas generales (solo ADMIN)")
    public ResponseEntity<?> estadisticas() {
        long totalUsuarios  = userRepository.count();
        return ResponseEntity.ok(java.util.Map.of(
            "totalUsuarios", totalUsuarios,
            "estado",        "API funcionando correctamente",
            "version",       "1.0.0"
        ));
    }
}
