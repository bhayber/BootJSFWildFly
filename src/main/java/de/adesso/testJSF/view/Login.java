package de.adesso.testJSF.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "login", eager = true)
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private boolean remember_me = true;

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

	public String submit() {
		return "Hello";
	}

	/**
	 * @return the remember_me
	 */
	public boolean isRemember_me() {
		return remember_me;
	}

	/**
	 * @param remember_me
	 *            the remember_me to set
	 */
	public void setRemember_me(boolean remember_me) {
		this.remember_me = remember_me;
	}

}