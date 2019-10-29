package com.cancha.gateway.service;

import com.cancha.gateway.dto.UsuarioDto;
import com.cancha.gateway.web.rest.controller.model.IngresoRequest;

/**
 * Created by MARA on 14/10/2019.
 */
public interface IngresoService {

    UsuarioDto ingreso(IngresoRequest ingresoRequest);

    String getJWTToken(String username);

    UsuarioDto registroUsuario(UsuarioDto usuarioDto);
}
