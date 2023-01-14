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
	/** SQL para crear datos*/
	public static final String INSERT_USUARIOS =
			"INSERT INTO usuario"
			+ " (nombre, clave) VALUES (?, ?)";
	/** SQL para obtener los datos personales del usuario */
	public static final String OBTENER_USER_TD =
			"SELECT * FROM usuario ";
	/** SQL para crear datos*/
	public static final String INSERT_TIPO =
			"INSERT INTO tipos"
			+ " (nombre) VALUES (?)";
	/** SQL para obtener los datos de tipos */
	public static final String OBTENER_TIPO =
			"SELECT * FROM tipos ";
	/** SQL para crear datos*/
	public static final String INSERT_HEROES =
			"INSERT INTO superheroes"
			+ " (nombre) VALUES (?)";
	/** SQL para obtener los datos de tipos */
	public static final String OBTENER_HEROES =
			"SELECT * FROM superheroes ";
	/** SQL para crear datos*/
	public static final String INSERT_CATEGORIAS =
			"INSERT INTO caregorias"
					+ " (descripcion,id_tipo,id_heroes) VALUES (?,?,?)";
	/** SQL para obtener los datos de tipos */
	public static final String OBTENER_CATEGORIAS =
			"SELECT c.id,c.descripcion,t.nombre as tipo, h.nombre FROM caregorias as c"
			+ " JOIN tipos as t on t.id =c.id_tipo"
			+ " JOIN superheroes as h on h.id = c.id_heroes";

}
