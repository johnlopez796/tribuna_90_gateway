package com.cancha.gateway.cliente.rest;

import com.cancha.gateway.dto.UsuarioDto;
import com.cancha.gateway.web.handler.error.RestException;
import com.cancha.gateway.web.rest.controller.model.IngresoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ClienteServiceRest {

    public UsuarioDto validarIngreso(IngresoRequest ingresoRequest){
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<UsuarioDto> usuarioEntity = restTemplate.postForEntity("http://localhost:8082/cliente/ingreso",ingresoRequest,UsuarioDto.class);
            return usuarioEntity.getBody();
        }catch (RestClientException ex){
            throw new RestException(HttpStatus.UNAUTHORIZED,"Usuario o contraseña invalido");
        }
    }

    public UsuarioDto registro(UsuarioDto usuarioDto){
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<UsuarioDto> usuarioEntity = restTemplate.postForEntity("http://localhost:8082/cliente",usuarioDto,UsuarioDto.class);
            return usuarioEntity.getBody();
        }catch (RestClientException ex){
            System.out.println(ex.getMessage());
        }
        return null;

    }

    public UsuarioDto validarIngresoAdm(IngresoRequest ingresoRequest){
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<UsuarioDto> usuarioEntity = restTemplate.postForEntity("http://localhost:8083/cliente/ingreso",ingresoRequest,UsuarioDto.class);
            return usuarioEntity.getBody();
        }catch (RestClientException ex){
            throw new RestException(HttpStatus.UNAUTHORIZED,"Usuario o contraseña invalido");
        }
    }
}
