package com.cancha.gateway.web.rest.controller;

import com.cancha.gateway.dto.UsuarioDto;
import com.cancha.gateway.web.handler.error.ApiError;
import com.cancha.gateway.web.rest.controller.model.IngresoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(description = "Operaciones ingreso y reggistro", tags = "ingreso, eregistro")
public interface IngresoController {


    @ApiOperation(value = "Validar ingreso a la aplicación", response = UsuarioDto.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 409, response = ApiError.class, message = "Usuario bloqueado"),
            @ApiResponse(code = 401, response = ApiError.class, message = "Contraseña y/o usuario invalido")
    })
    ResponseEntity<UsuarioDto> validarIngreso(@RequestBody IngresoRequest ingresoRq);

    @ApiOperation(value = "Registrar cliente", response = UsuarioDto.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 409, response = ApiError.class, message = "Usuario bloqueado"),
            @ApiResponse(code = 401, response = ApiError.class, message = "Contraseña y/o usuario invalido")
    })
    ResponseEntity<UsuarioDto> registro(@RequestBody UsuarioDto usuarioDto);

    ResponseEntity<UsuarioDto> validarIngresoAdm(@RequestBody IngresoRequest ingresoRq);
}
