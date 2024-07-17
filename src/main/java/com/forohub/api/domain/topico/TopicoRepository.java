package com.forohub.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findAllByOrderByFechaCreacionDesc(Pageable paginacion);
}