package de.adesso.testJSF.view;



import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "login", eager = true)
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private boolean remember_me = true;

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		isLoggedIn = loggedIn;
	}

	public String getAccesToken() {
		return accesToken;
	}

	public void setAccesToken(String accesToken) {
		this.accesToken = accesToken;
	}

	private boolean isLoggedIn;
	private String accesToken;



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

	public String submit(ActionEvent actionEvent) {
		// TODO: 19.10.2018 try to obtain access token and set isLoggedIn True
		// TODO: 19.10.2018 HeaderView Managed Bean erstellen und Requestscoped machen prüfe auf kogged in sonst return login2.xhtml
		return "index.xhtml";
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

	public String getUsername() {
			return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}