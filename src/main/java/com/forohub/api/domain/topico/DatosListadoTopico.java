package com.forohub.api.domain.topico;

import com.forohub.api.domain.cursos.Curso;

import java.time.LocalDateTime;

public record DatosListadoTopico(Long id, String titulo, String mensaje,
                                 LocalDateTime fechaCreacion, String estado, String autor, Long curso) {

    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus(), topico.getAutor(), topico.getCursoId().getId());
    }
}
