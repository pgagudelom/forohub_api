package com.forohub.api.domain.usuarios;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,

        @NotBlank
        String login,

        @NotBlank
        String clave) {
}
