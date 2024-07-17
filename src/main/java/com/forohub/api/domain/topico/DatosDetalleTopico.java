package com.forohub.api.domain.topico;

import com.forohub.api.domain.cursos.Curso;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        Long curso
) {
}
