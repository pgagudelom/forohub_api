package com.forohub.api.domain.topico;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.forohub.api.domain.cursos.Curso;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;


    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    private String status;
    private String autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String status, String autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public Curso getCursoId() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }


    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico){
        if(datosActualizarTopico.id() != null){

            if(datosActualizarTopico.titulo() != null){
                this.titulo = datosActualizarTopico.titulo();
            }

            if(datosActualizarTopico.mensaje() != null){
                this.mensaje = datosActualizarTopico.mensaje();
            }

            if(datosActualizarTopico.autor() !=null){
                this.autor = datosActualizarTopico.autor();
            }

        }
    }

    public void desactivarTopico(){
        this.status = "inactive";
    }


}
