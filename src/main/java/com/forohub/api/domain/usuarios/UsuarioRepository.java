package com.forohub.api.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String username);

    @Query("select u from Usuario u where login=:username")
    Optional<Usuario> findByEmail(String username);
}
