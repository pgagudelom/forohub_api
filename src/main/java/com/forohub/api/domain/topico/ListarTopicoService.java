package com.forohub.api.domain.topico;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarTopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    @Transactional
    public Page<DatosListadoTopico> listarTopicosRecientes(Pageable paginacion){
        return topicoRepository.findAllByOrderByFechaCreacionDesc(paginacion).map(DatosListadoTopico::new);
    }
}
