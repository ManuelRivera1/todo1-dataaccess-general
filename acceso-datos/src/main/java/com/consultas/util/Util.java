package com.consultas.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.consultas.dto.transversal.MensageRespuestaDTO;
import com.consultas.enums.Numero;

/**
 * Clase que contiene los metodo utilitarios del sistema
 *
 */
@UtilityClass
public class Util {

	/**
	 * Metodo que permite construir el response de respuesta exitoso
	 */
	public static ResponseEntity<Object> getResponseSuccessful(Object body) {
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	/**
	 * Metodo que permite construir el response de respuesta OK
	 */
	public static ResponseEntity<Object> getResponseOk() {
		return ResponseEntity.status(HttpStatus.OK).body(new MensageRespuestaDTO(HttpStatus.OK.getReasonPhrase()));
	}

	/**
	 * Metodo que permite construir el response de respuesta BAD REQUEST
	 */
	public static ResponseEntity<Object> getResponseBadRequest(String bussinesMessage) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensageRespuestaDTO(bussinesMessage));
	}

	/**
	 * Metodo que permite construir el response de respuesta INTERNAL_SERVER_ERROR 
	 * 
	 * @param metodo, metodo donde se origino el error
	 * @param error, mensaje de la exception lanzada
	 */
	public static ResponseEntity<Object> getResponseError(String metodo, String error) {
		if (error == null || error.trim().length() == Numero.ZERO.valueI.intValue()) {
			error = "Exception lanzada por NullPointerException.";
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MensageRespuestaDTO(metodo + error));
	}

	/**
	 * Metodo que permite obtener un valor de un array de objecto
	 */
	public static String getValue(Object[] data, Integer index) {
		return data[index] != null ? data[index].toString() : null;
	}
}
