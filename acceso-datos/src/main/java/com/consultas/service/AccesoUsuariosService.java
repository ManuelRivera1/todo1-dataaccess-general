package com.consultas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.consultas.constant.SQLConstanteAccesoUsuarios;
import com.consultas.enums.Numero;
@Service
public class AccesoUsuariosService {
	/** Contexto de la persistencia del sistema */
	@PersistenceContext
	private EntityManager em;
	
	
	/**
	 * Servicio que soporta el proceso de negocio para la autenticacion en el
	 * sistema
	 *
	 * @param usuarioIngreso DTO que contiene los datos de las credenciales
	 * @return 
	 * @return DTO con los datos del response para la autenticacion en el sistema
	 */
	public List<Object> obtenerAuteticacionUsuario(String usuarioIngreso) {
		// se consulta el identificador del usuario que coincida con la clave-usuario
		Query q = this.em.createNativeQuery(SQLConstanteAccesoUsuarios.OBTENER_USER_AUTH);
		q.setParameter(Numero.UNO.valueI, usuarioIngreso);
		return q.getResultList();
	}
	

}
