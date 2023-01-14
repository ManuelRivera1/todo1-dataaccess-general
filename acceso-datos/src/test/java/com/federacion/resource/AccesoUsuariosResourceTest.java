package com.federacion.resource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.consultas.resource.AccesoUsuariosResource;

@SpringBootTest
class AccesoUsuariosResourceTest {
	@Autowired
	AccesoUsuariosResource accesoUsuariosResource;
	private static ResponseEntity<Object> responseEntity =  null ;
	@Test
	void testIniciarSesion() {
		String usuarioIngreso="admin";
		responseEntity= accesoUsuariosResource.iniciarSesion(usuarioIngreso);
		assertAll("resultado",
				() -> assertNotNull(responseEntity.getBody()),
				() -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode())
		);
	}
	@Test
	void testIniciarSesionFalla() {
		String usuarioIngreso="admis";
		responseEntity= accesoUsuariosResource.iniciarSesion(usuarioIngreso);
		assertAll("resultado",
				() -> assertNotNull(responseEntity.getBody()),
				() -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode())
		);
	}

}
