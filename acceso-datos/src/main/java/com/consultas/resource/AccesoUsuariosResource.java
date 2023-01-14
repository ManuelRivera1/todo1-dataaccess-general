package com.consultas.resource;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(path = "/insertarUsuario")
	@ApiOperation(value = "insertar usuario", notes = "Operación para insertar informacion del usuario")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> crearUsuarios(@RequestParam String usuarioIngreso, String clave) {
		try {
			log.info("INFORMACION crear usuario: "+usuarioIngreso);
			return Util.getResponseSuccessful(this.accesoUsuariosService.crearUsuarios(usuarioIngreso, clave));
		} catch (Exception e) {
			log.error("ERROR crear usuario: "+e.getMessage());
			return Util.getResponseError(AccesoUsuariosResource.class.getSimpleName() + ".crearUsuarios ", e.getMessage());
		}
	}
	
	@GetMapping(path = "/filtrarUsuario")
	@ApiOperation(value = "filtrar usuario", notes = "Operación para filtrar informacion del usuario")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> filtrarUsuarios() {
		try {
			log.info("INFORMACION filtrar usuario: ");
			return Util.getResponseSuccessful(this.accesoUsuariosService.filtrarUsuarios());
		} catch (Exception e) {
			log.error("ERROR filtrar usuario: "+e.getMessage());
			return Util.getResponseError(AccesoUsuariosResource.class.getSimpleName() + ".filtrarUsuariosParametro ", e.getMessage());
		}
	}
	
	@GetMapping(path = "/insertarTipo")
	@ApiOperation(value = "insertar tipo", notes = "Operación para insertar informacion del tipo")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> insertarTipo(@RequestParam String nombre) {
		try {
			log.info("INFORMACION insertar tipo: "+nombre);
			return Util.getResponseSuccessful(this.accesoUsuariosService.insertarTipo(nombre));
		} catch (Exception e) {
			log.error("ERROR insertar tipo: "+e.getMessage());
			return Util.getResponseError(AccesoUsuariosResource.class.getSimpleName() + ".insertarTipo ", e.getMessage());
		}
	}
	@GetMapping(path = "/filtrarTipos")
	@ApiOperation(value = "filtrar tipos", notes = "Operación para filtrar tipo")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> filtrarTipos() {
		try {
			log.info("INFORMACION filtrarTipos");
			return Util.getResponseSuccessful(this.accesoUsuariosService.filtrarTipos());
		} catch (Exception e) {
			log.error("ERROR filtrarTipos: "+e.getMessage());
			return Util.getResponseError(AccesoUsuariosResource.class.getSimpleName() + ".filtrarTipos ", e.getMessage());
		}
	}
	@GetMapping(path = "/insertarHeroes")
	@ApiOperation(value = "insertar Heroes", notes = "Operación para insertar informacion del heroes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> insertarHeroes(@RequestParam String nombre) {
		try {
			log.info("INFORMACION insertar heroes: "+nombre);
			return Util.getResponseSuccessful(this.accesoUsuariosService.insertarHeroes(nombre));
		} catch (Exception e) {
			log.error("ERROR insertar heroes: "+e.getMessage());
			return Util.getResponseError(AccesoUsuariosResource.class.getSimpleName() + ".insertarHeroes ", e.getMessage());
		}
	}
	@GetMapping(path = "/filtrarHeroes")
	@ApiOperation(value = "filtrar heroes", notes = "Operación para filtrar heroes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> filtrarHeroes() {
		try {
			log.info("INFORMACION filtrarHeroes");
			return Util.getResponseSuccessful(this.accesoUsuariosService.filtrarHeroes());
		} catch (Exception e) {
			log.error("ERROR filtrarHeroes: "+e.getMessage());
			return Util.getResponseError(AccesoUsuariosResource.class.getSimpleName() + ".filtrarHeroes ", e.getMessage());
		}
	}
	@GetMapping(path = "/insertarCategorias")
	@ApiOperation(value = "insertar categorias", notes = "Operación para insertar informacion del categorias")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> insertarCategorias(@RequestParam String descripcion, int idTipo, int idHeroes) {
		try {
			log.info("INFORMACION insertar categorias: "+descripcion);
			return Util.getResponseSuccessful(this.accesoUsuariosService.insertarCategorias(descripcion,idTipo,idHeroes));
		} catch (Exception e) {
			log.error("ERROR insertar categorias: "+e.getMessage());
			return Util.getResponseError(AccesoUsuariosResource.class.getSimpleName() + ".insertarHeroes ", e.getMessage());
		}
	}
	@GetMapping(path = "/filtrarCategorias")
	@ApiOperation(value = "filtrar categorias", notes = "Operación para filtrar categorias")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> filtrarCategorias() {
		try {
			log.info("INFORMACION filtrarCategorias");
			return Util.getResponseSuccessful(this.accesoUsuariosService.filtrarCategorias());
		} catch (Exception e) {
			log.error("ERROR filtrarCategorias: "+e.getMessage());
			return Util.getResponseError(AccesoUsuariosResource.class.getSimpleName() + ".filtrarCategorias ", e.getMessage());
		}
	}
	
}
