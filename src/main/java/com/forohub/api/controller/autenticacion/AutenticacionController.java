package com.forohub.api.controller.autenticacion;

import com.forohub.api.domain.usuarios.DatosAutenticacionUsuario;
import com.forohub.api.domain.usuarios.Usuario;
import com.forohub.api.infra.security.DatosJWTToken;
import com.forohub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datos){
        Authentication autToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.clave());

        var usuarioAutenticado = authenticationManager.authenticate(autToken);
        var JWTtoken =tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }

}
