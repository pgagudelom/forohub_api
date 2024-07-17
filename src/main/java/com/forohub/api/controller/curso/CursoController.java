package com.forohub.api.controller.curso;

import com.forohub.api.domain.cursos.Curso;
import com.forohub.api.domain.cursos.CursoRepository;
import com.forohub.api.domain.cursos.DatosRegistroCurso;
import com.forohub.api.domain.cursos.DatosResponseCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    /*
    * -----Metodo para registrar nuevos cursos--*/
    @PostMapping
    public ResponseEntity<DatosResponseCurso> registrarCurso(@RequestBody @Valid
    DatosRegistroCurso datosRegistroCurso, UriComponentsBuilder uriComponentsBuilder){
        Curso curso = cursoRepository.save(new Curso(datosRegistroCurso));
        DatosResponseCurso datosResponseCurso = new DatosResponseCurso(curso.getId(), curso.getNombre(), curso.getCategoria());

        URI url =uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(datosResponseCurso);
    }
}
