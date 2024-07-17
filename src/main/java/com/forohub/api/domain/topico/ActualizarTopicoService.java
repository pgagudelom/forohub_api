package com.forohub.api.domain.topico;

import com.forohub.api.domain.cursos.Curso;
import com.forohub.api.domain.cursos.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActualizarTopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    public DatosResponseTopico actualizarTopico(DatosActualizarTopico actualizarTopico){

        Topico topico = topicoRepository.getReferenceById(actualizarTopico.id());
        topico.actualizarTopico(actualizarTopico);

        if (actualizarTopico.curso_id() != null) {
            Curso curso = cursoRepository.findById(actualizarTopico.curso_id())
                    .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
            topico.setCurso(curso);
        }

        topicoRepository.save(topico);

        return new DatosResponseTopico(topico);
    }

}
