package br.com.codenation.biblioteca.services.impl;

import br.com.codenation.biblioteca.models.Usuario;
import br.com.codenation.biblioteca.services.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret; //SENHA DA APLICACAO QUE SERÁ UTILIZADA PARA GERAR O HASH - RECOMENDADO SER  UM STRING ALEATÓRIA COM MUITOS CARACTERES


    public String gerarToken(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
        //setIssuer - QUEM ESTÁ GERANDO ESSE TOKEN
        //setSubject - STRING QUE IDENTIFIQUE UNICAMENTE MEU USUÁRIO
        //signWith - Settar a senha e o algoritmo utilizado
        return Jwts.builder()
//                .setIssuer("API Aceleradev")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {
        //DESCRIPTOGRAFA E VERIFICA SE ESTÁ OK
        try{
            //TEM QUE SER O QUE RETORNA Jws<Claims>
            //SE ELE NAO CONSEGUIR FAZER O PARSE ELE IRÁ LANCAR UMA EXCEPTION
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch(Exception e){
            return false;
        }

    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        //PEGA O ID
        return Long.parseLong(claims.getSubject());
    }
}
