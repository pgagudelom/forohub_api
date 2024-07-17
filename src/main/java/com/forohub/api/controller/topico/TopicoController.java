package com.forohub.api.controller.topico;

import com.forohub.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    RegistrarTopicoSerivce topicoSerivce;

    @Autowired
    ListarTopicoService listarTopicoService;

    @Autowired
    DetalleTopicoService detalleTopicoService;

    @Autowired
    ActualizarTopicoService actualizarTopicoService;

    @Autowired
    EliminarTopicoService eliminarTopicoService;

    @PostMapping
    public ResponseEntity<DatosResponseTopico> registrarTopico(
            @RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uri){

        var response = topicoSerivce.registrarTopico(datosRegistroTopico, uri);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(Pageable paginacion){
        var listado = listarTopicoService.listarTopicosRecientes(paginacion);
        return ResponseEntity.ok(listado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> muestraDetalleDeTopico(@PathVariable Long id){
       var topico =  detalleTopicoService.detalleTopico(id);

        return ResponseEntity.ok(topico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosResponseTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        var topico = actualizarTopicoService.actualizarTopico(datosActualizarTopico);

        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosResponseTopico> eliminarTopico(@PathVariable Long id){

        eliminarTopicoService.eliminarTopico(id);

        return ResponseEntity.noContent().build();
    }
}
