package com.forohub.api.controller.autenticacion;

import com.forohub.api.domain.usuarios.DatosRegistroUsuario;
import com.forohub.api.domain.usuarios.DatosRespuestaUsuario;
import com.forohub.api.domain.usuarios.RegistroUsuarioService;
import com.forohub.api.domain.usuarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistroController {

    @Autowired
    RegistroUsuarioService registroService;

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        var usuario  = registroService.registrarUsuario(datosRegistroUsuario);

        return ResponseEntity.ok(usuario);
    }
}
