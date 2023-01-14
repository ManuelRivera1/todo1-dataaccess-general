package com.consultas.service;

import java.sql.Connection;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consultas.constant.SQLConstanteAccesoUsuarios;
import com.consultas.enums.Numero;
import com.consultas.jdbc.UtilJDBC;
import com.consultas.jdbc.ValueSQL;
@Service
public class AccesoUsuariosService {
	/** Contexto de la persistencia del sistema */
	@PersistenceContext
	private EntityManager em;
	
	private UtilJDBC utilJDBC;
	private Connection connection;
	
	
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
	public void initUtilJDBC() throws Exception {
		try {
			utilJDBC = UtilJDBC.getInstance();
			connection = utilJDBC.getConnection(this.em);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	@Transactional
	public boolean crearUsuarios(String usuarioIngreso, String clave) throws Exception{
		try {
		initUtilJDBC();
		utilJDBC.insertUpdate(connection, SQLConstanteAccesoUsuarios.INSERT_USUARIOS,
				ValueSQL.get(usuarioIngreso, Types.VARCHAR),
				ValueSQL.get(clave, Types.VARCHAR)
			);
		return true;
		}
		catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<Object> filtrarUsuarios() {
		// se consulta el identificador del usuario que coincida 
		Query q = this.em.createNativeQuery(SQLConstanteAccesoUsuarios.OBTENER_USER_TD);
		return q.getResultList();
	}
	
	@Transactional
	public boolean insertarTipo(String nombre) throws Exception{
		try {
			initUtilJDBC();
			utilJDBC.insertUpdate(connection, SQLConstanteAccesoUsuarios.INSERT_TIPO,
					ValueSQL.get(nombre, Types.VARCHAR)
					);
			return true;
		}
		catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<Object> filtrarTipos() {
		// se consulta el identificador del tipo que coincida 
		Query q = this.em.createNativeQuery(SQLConstanteAccesoUsuarios.OBTENER_TIPO);
		return q.getResultList();
	}
	
	@Transactional
	public boolean insertarHeroes(String nombre) throws Exception{
		try {
			initUtilJDBC();
			utilJDBC.insertUpdate(connection, SQLConstanteAccesoUsuarios.INSERT_HEROES,
					ValueSQL.get(nombre, Types.VARCHAR)
					);
			return true;
		}
		catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<Object> filtrarHeroes() {
		// se consulta el identificador del tipo que coincida 
		Query q = this.em.createNativeQuery(SQLConstanteAccesoUsuarios.OBTENER_HEROES);
		return q.getResultList();
	}
	@Transactional
	public boolean insertarCategorias(String descripcion, int idTipo,int idHeroes) throws Exception{
		try {
			initUtilJDBC();
			utilJDBC.insertUpdate(connection, SQLConstanteAccesoUsuarios.INSERT_CATEGORIAS,
					ValueSQL.get(descripcion, Types.VARCHAR),
					ValueSQL.get(idTipo, Types.INTEGER),
					ValueSQL.get(idHeroes, Types.INTEGER)
					);
			return true;
		}
		catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<Object> filtrarCategorias() {
		// se consulta el identificador del tipo que coincida 
		Query q = this.em.createNativeQuery(SQLConstanteAccesoUsuarios.OBTENER_CATEGORIAS);
		return q.getResultList();
	}

}
