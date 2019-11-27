package com.cancha.gateway.web.rest.controller.impl;

import com.cancha.gateway.dto.UsuarioDto;
import com.cancha.gateway.service.IngresoService;
import com.cancha.gateway.web.rest.controller.IngresoController;
import com.cancha.gateway.web.rest.controller.model.IngresoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class IngresoControllerImpl implements IngresoController {

    private IngresoService ingresoService;

    public IngresoControllerImpl(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> validarIngreso(@RequestBody IngresoRequest ingresoRq) {
        return ResponseEntity.ok(ingresoService.ingreso(ingresoRq));
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDto> registro(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(ingresoService.registroUsuario(usuarioDto));
    }

    @PostMapping("/adm")
    public ResponseEntity<UsuarioDto> validarIngresoAdm(@RequestBody IngresoRequest ingresoRq) {
        return ResponseEntity.ok(ingresoService.ingresoAdm(ingresoRq));
    }


}
