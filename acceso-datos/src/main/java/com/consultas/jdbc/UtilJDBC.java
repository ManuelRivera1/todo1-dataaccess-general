package com.consultas.jdbc;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.consultas.enums.Numero;
/**
 * Clase que contiene las funciones comunes para los procesos de JDBC
 */
public class UtilJDBC {

	/** Instancia unica de la utilidad */
	private static UtilJDBC instance;

	/**
	 * La utilida es un singleton, no se permite instancias por fuera
	 */
	private UtilJDBC() {}

	/**
	 * Metodo que permite dar la unica instancia de la utilidad
	 */
	public static UtilJDBC getInstance() {
		if (instance == null) {
			instance = new UtilJDBC();
		}
		return instance;
	}

	/**
	 * Metodo utilitario para los UPDATES o INSERT con JDBC
	 *
	 * @param dml, es la sentencia DML a ejecutar
	 * @param valores, valores a insertar o actualizar en la tabla
	 */
	public int insertUpdate(Connection con, String dml, ValueSQL... valores) throws Exception {
		PreparedStatement pst = null;
		try {
			// se establece el PreparedStatement
			pst = con.prepareStatement(dml);

			// se recorre cada valor para configurarlo en el PreparedStatement
			int posicion = Numero.UNO.valueI.intValue();
			for (ValueSQL valueSQL : valores) {

				// se valida si se debe configurar NULL en el PreparedStatement
				if (valueSQL.getValor() != null) {
					setValorNotNull(pst, valueSQL, posicion);
				} else {
					pst.setNull(posicion, valueSQL.getTipoDato());
				}
				posicion++;
			}

			// se ejecuta la inserción
			return pst.executeUpdate();
		} finally {
			CerrarRecursosJDBC.closePreparedStatement(pst);
		}
	}


	/**
	 * Metodo que permite obtener la connection de una transaccion de HIBERNATE
	 */
	public Connection getConnection(EntityManager entityManager) {
		Session session = entityManager.unwrap(Session.class);
		ConnectionJDBC myWork = new ConnectionJDBC();
		session.doWork(myWork);
		return myWork.getConnection();
	}

	/**
	 * Metodo que permite settear un valor NOT NULL al PreparedStatement
	 */
	private void setValorNotNull(PreparedStatement pst, ValueSQL valor, int posicion) throws Exception {
		switch (valor.getTipoDato()) {
			case Types.VARCHAR:
				pst.setString(posicion, (String) valor.getValor());
				break;

			case Types.INTEGER:
				pst.setInt(posicion, (Integer) valor.getValor());
				break;

			case Types.BIGINT:
				pst.setLong(posicion, (Long) valor.getValor());
				break;

			case Types.DATE:
				pst.setDate(posicion, new java.sql.Date(((Date) valor.getValor()).getTime()));
				break;

			case Types.TIMESTAMP:
				pst.setTimestamp(posicion, new java.sql.Timestamp(((Date) valor.getValor()).getTime()));
				break;

			case Types.BLOB:
				pst.setBytes(posicion, (byte[]) valor.getValor());
				break;

			case Types.DECIMAL:
				pst.setBigDecimal(posicion, (BigDecimal) valor.getValor());
				break;
		}
	}
}
