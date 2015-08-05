package com.plate.model;

import java.io.Serializable;

/**
 * @author bruno ferrari
 *
 */
public class ProviderFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String doc;

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getDoc() {
		return doc;
	}

	/**
	 * @param doc
	 */
	public void setDoc(String doc) {
		this.doc = doc;
	}

}
