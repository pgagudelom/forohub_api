package com.forohub.api.domain.cursos;

public record DatosResponseCurso(
    Long id,
    String nombre,
    Categoria categoria
) {
}
