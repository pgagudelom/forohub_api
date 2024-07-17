package com.forohub.api.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
    @NotNull
    Long id,
    String titulo,
    String mensaje,
    String autor,
    Long curso_id
) {

}
