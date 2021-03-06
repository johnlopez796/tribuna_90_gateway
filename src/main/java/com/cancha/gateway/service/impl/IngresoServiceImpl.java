package com.cancha.gateway.service.impl;

import com.cancha.gateway.cliente.rest.ClienteServiceRest;
import com.cancha.gateway.dto.UsuarioDto;
import com.cancha.gateway.security.EncrypterUtil;
import com.cancha.gateway.service.IngresoService;
import com.cancha.gateway.web.rest.controller.model.IngresoRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngresoServiceImpl implements IngresoService {

    public ClienteServiceRest clienteServiceRest;
    public EncrypterUtil encrypterUtil;

    public IngresoServiceImpl(ClienteServiceRest clienteServiceRest, EncrypterUtil encrypterUtil) {
        this.clienteServiceRest = clienteServiceRest;
        this.encrypterUtil = encrypterUtil;
    }

    public UsuarioDto ingreso(IngresoRequest ingresoRequest) {
        System.out.println(ingresoRequest.getPassword());
        String pass = encrypterUtil.encript(ingresoRequest.getPassword());
        ingresoRequest.setPassword(pass);
        System.out.println(pass);
        UsuarioDto usuarioDto = clienteServiceRest.validarIngreso(ingresoRequest);
        usuarioDto.setToken(this.getJWTToken(usuarioDto));
        return usuarioDto;
    }

    public UsuarioDto ingresoAdm(IngresoRequest ingresoRequest) {
        System.out.println(ingresoRequest.getPassword());
        ingresoRequest.setPassword(ingresoRequest.getPassword());
        UsuarioDto usuarioDto = clienteServiceRest.validarIngresoAdm(ingresoRequest);
        usuarioDto.setToken(this.getJWTToken(usuarioDto));
        return usuarioDto;
    }

    public UsuarioDto registroUsuario(UsuarioDto usuarioDto) {
        String pass = encrypterUtil.encript(usuarioDto.getClave());
        usuarioDto.setClave(pass);
        return clienteServiceRest.registro(usuarioDto);
    }

    public String getJWTToken(UsuarioDto usuarioDto) {
        String secretKey = "tribuna90";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(String.join(",",usuarioDto.getRol()));

        String token = Jwts
                .builder()
                .setId("user")
                .setSubject(usuarioDto.getDocumento())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .claim("usuario",usuarioDto)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
