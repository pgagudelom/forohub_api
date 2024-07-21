package com.forohub.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


public class EncriptarClaveService {


    private final String clave;
    private final PasswordEncoder passwordEncoder;


    public EncriptarClaveService(String clave, PasswordEncoder passwordEncoder) {
        this.clave = clave;
        this.passwordEncoder = passwordEncoder;
    }

    public String encriptarClave(){
        return passwordEncoder.encode(clave);
    }
}
