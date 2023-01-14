package com.consultas.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consultas.service.AccesoUsuariosService;
import com.consultas.util.Util;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Servicio que contiene todos las consultas para el micro de acceso usuarios
 * localhost:puerto/auth/
 */
@RestController
@RequestMapping("/accesoDatos/consultas")
public class AccesoUsuariosResource {
	private final Logger log = LoggerFactory.getLogger(AccesoUsuariosResource.class);

	/** 
	 * Service para que contiene los procesos de negocio para la autenticacion 
	*/
	@Autowired
	private AccesoUsuariosService accesoUsuariosService;
	
	/**
	 * Servicio que soporta el proceso de negocio para la autenticacion en el sistema
	 * @param usuarioIngreso DTO que contiene los datos de las credenciales
	 * @return DTO con los datos del response para la autenticacion en el sistema
	*/
	@GetMapping(path = "/obtenerAuteticacionUsuario")
	@ApiOperation(value = "Consultar usuario", notes = "Operación para consulta informacion del usuario")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> iniciarSesion(@RequestParam String usuarioIngreso) {
		try {
			log.info("INFORMACION iniciar sesion: "+usuarioIngreso);
			return Util.getResponseSuccessful(this.accesoUsuariosService.obtenerAuteticacionUsuario(usuarioIngreso));
		} catch (Exception e) {
			log.error("ERROR iniciar sesion: "+e.getMessage());
			return Util.getResponseError(AccesoUsuariosResource.class.getSimpleName() + ".iniciarSesion ", e.getMessage());
		}
	}
}
