package com.forohub.api.domain.topico;

import com.forohub.api.domain.cursos.CursoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@Service
public class RegistrarTopicoSerivce {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosResponseTopico registrarTopico(DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uri){

        if(!cursoRepository.findById(datosRegistroTopico.curso_id()).isPresent()){
            throw new ValidationException("Este id para el curso no fue encontrado");
        }
        System.out.println(datosRegistroTopico.titulo());
        var curso =cursoRepository.findById(datosRegistroTopico.curso_id()).get();
        var fechaCreacion = LocalDateTime.now();
        var status = "active";
        var topico = new Topico(null, datosRegistroTopico.titulo(), datosRegistroTopico.mensaje(),
               fechaCreacion, status, datosRegistroTopico.autor(), curso);

        topicoRepository.save(topico);


        return new DatosResponseTopico(topico);
    }

}
