package de.adesso.testJSF.model;

import java.io.Serializable;

public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @return the iso
	 */
	public String getIso() {
		return iso;
	}

	/**
	 * @param iso
	 *            the iso to set
	 */
	public void setIso(String iso) {
		this.iso = iso;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	private String iso;
	private String name;

}
