package com.consultas.util;

/**
 * Clase que identifica el tipo de exception de negocio
 */
public class ExcepcionComercial extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la Exception
	 * 
	 * @param msj, es el mensaje de la exception occurred
	 */
	public ExcepcionComercial(String msj) {
		super(msj);
	}
}
