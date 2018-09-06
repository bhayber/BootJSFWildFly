package de.adesso.testJSF.view;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "login", eager = true)
@ApplicationScoped
public class Login {

	private String email;
	private String password;

	/**
	 * @return the name
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Login() {
		System.out.println("Login started!");
	}

}