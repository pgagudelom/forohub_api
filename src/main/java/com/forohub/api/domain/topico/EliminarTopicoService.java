package com.forohub.api.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EliminarTopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    public void eliminarTopico(Long id){
        topicoRepository.deleteById(id);
        //topico.desactivarTopico();
    }

}
