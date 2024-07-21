package com.forohub.api.domain.usuarios;

import com.forohub.api.infra.errores.ValidacionDeIntegridad;
import com.forohub.api.infra.security.EncriptarClaveService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistroUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public DatosRespuestaUsuario registrarUsuario(DatosRegistroUsuario datosRegistroUsuario){

        //Validamos si el correo ya esta registrado
        var usuarioExiste = validaCorreoRegistrado(datosRegistroUsuario.login());

        if(usuarioExiste){
            throw new ValidationException("Este corrre electrónico ya se encuentra registrado");
        }

        var clave = new EncriptarClaveService(datosRegistroUsuario.clave(), passwordEncoder);

        var usuario = new Usuario(null, datosRegistroUsuario.nombre(),
                datosRegistroUsuario.login(),  clave.encriptarClave());

         usuarioRepository.save(usuario);

         return new DatosRespuestaUsuario(usuario);

    }

    public boolean validaCorreoRegistrado(String email){
        return usuarioRepository.findByEmail(email).isPresent();
    }


}
