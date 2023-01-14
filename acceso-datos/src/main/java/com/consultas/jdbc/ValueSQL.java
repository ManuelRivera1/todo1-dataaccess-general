package com.consultas.jdbc;
import lombok.Getter;
import lombok.Setter;

	/**
	 * Clase que contiene los atributos de un valor para SQL
	 */
	@Setter
	@Getter
	public class ValueSQL {

		/** Es el valor del Value SQL */
		private Object valor;

		/** Es el tipo de dato para este valor cuando es NULA */
		private Integer tipoDato;

		/**
		 * Constructor privado donde se configuran los valores globales
		 */
		private ValueSQL(Object valor, Integer tipoDato) {
			this.valor = valor;
			this.tipoDato = tipoDato;
		}

		/**
		 * Retorna una instancia de este tipo de Clase
		 */
		public static ValueSQL get(Object valor, Integer tipoDato) {
			return new ValueSQL(valor, tipoDato);
		}
	}

