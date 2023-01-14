package com.consultas.constant;
import lombok.experimental.UtilityClass;

/**
 * Clase constante que contiene los DMLs Y DDLs para las consultas nativas
 */
@UtilityClass
public class SQLConstanteAccesoUsuarios {
	/** SQL para obtener los datos personales del usuario con base a sus credenciales*/
	public static final String OBTENER_USER_AUTH =
		"SELECT * FROM usuario "
		+ "WHERE nombre = ?";

}
