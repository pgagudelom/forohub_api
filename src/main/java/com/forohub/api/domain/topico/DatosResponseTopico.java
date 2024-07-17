package com.forohub.api.domain.topico;

import com.forohub.api.domain.cursos.Curso;

import java.time.LocalDateTime;

public record DatosResponseTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        Curso curso_id
) {
    public DatosResponseTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
                topico.getAutor(), topico.getCursoId());
    }
}
