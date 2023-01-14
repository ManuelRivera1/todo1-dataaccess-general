package com.consultas.dto.transversal;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Se utiliza para enviar un solo mensaje desde servidor al cliente
 */
@Getter
@Setter
@NoArgsConstructor
public class MensageRespuestaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Cuando el error es un Internal server error,
     * El mensaje es la descripcion de la exception.
     *
     * Cuando el error es provocado por un business exeption,
     * El mensaje contiene el codigo que representa el mensaje de business error
     *
     */
    private String mensaje;

    public MensageRespuestaDTO(String mensaje) {
        this.mensaje = mensaje;
    }
}
