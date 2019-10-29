package com.cancha.gateway.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
public class UsuarioDto {
    private String id;
    @NotEmpty
    private TipoDocumento tipoDocumento;
    @NotEmpty
    private String documento;
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String apellidos;
    private Date fechaNacimiento;
    @NotEmpty
    private String nickname;
    @NotEmpty
    @Email
    private String email;
    private String clave;
    private List<String> rol;
    private String token;
}
