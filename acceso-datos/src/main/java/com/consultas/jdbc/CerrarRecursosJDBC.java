package com.consultas.jdbc;
import java.sql.PreparedStatement;

/**
 * Clase que permite cerrar los recursos de JDBC
 */
public class CerrarRecursosJDBC {

	/**
	 * Metodo que permite cerrar el recurso PreparedStatement
	 */
	public static void closePreparedStatement(PreparedStatement pst) throws Exception {
		if (pst != null) {
			pst.close();
		}
	}
}
