CREATE TABLE usuarios(
     id BIGINT NOT NULL AUTO_INCREMENT,
     nombre VARCHAR(200) NOT NULL,
     correoElectronico VARCHAR(300) NOT NULL UNIQUE,
     contrasena VARCHAR(300) NOT NULL,
     PRIMARY KEY(id)
);