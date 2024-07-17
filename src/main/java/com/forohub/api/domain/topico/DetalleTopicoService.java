package com.forohub.api.domain.topico;

import com.forohub.api.domain.cursos.CursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleTopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Transactional
    public DatosDetalleTopico detalleTopico(Long id){

        if(id == null){
            throw new ValidationException("El id es invalido");
        }

        var topicoExiste = topicoRepository.existsById(id);

        if(!topicoExiste){
            throw new ValidationException("El id consultado no existe");
        }

        Topico topico = topicoRepository.getReferenceById(id);

        return new DatosDetalleTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCursoId().getId());
    }
}
