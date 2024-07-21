package com.forohub.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.forohub.api.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;


    public String generarToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);

            return JWT.create()
                    .withIssuer("foroHub")
                    .withSubject(usuario.getUsername())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch(JWTCreationException exception){
            throw new RuntimeException(exception.toString());
        }
    }

    public String getSubject(String token){
        DecodedJWT verifier = null;
        try{
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier =JWT.require(algorithm)
                    .withIssuer("foroHub")
                    .build()
                    .verify(token);

            verifier.getSubject();
        }catch (JWTVerificationException exception){
            System.out.println(exception.toString());
        }

        if(verifier.getSubject() == null){
            throw new RuntimeException("Verifier invalido");
        }

        return verifier.getSubject();
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-05:00"));
    }
}
