package com.plate.model;

import java.io.Serializable;

/**
 * @author bruno ferrari
 *
 */
public class ClientsFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
