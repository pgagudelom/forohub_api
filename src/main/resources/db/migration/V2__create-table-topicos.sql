CREATE TABLE topicos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL UNIQUE,
    mensaje LONGTEXT NOT NULL UNIQUE,
    fecha_creacion DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor VARCHAR(200) NOT NULL,
    curso_id BIGINT NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_topicos_curso_id FOREIGN KEY(curso_id) REFERENCES cursos(id)

);