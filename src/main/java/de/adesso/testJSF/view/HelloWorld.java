package de.adesso.testJSF.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.context.annotation.DependsOn;

@ManagedBean(name = "helloWorld", eager = true)
@RequestScoped
@DependsOn(value = "login")
public class HelloWorld implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	@ManagedProperty(value = "#{login}")
	private Login login;

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	private String loginName = "default";

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		if (login != null) {
			return login.getEmail();
		}
		System.out.println(login);
		return loginName;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorld() {
		System.out.println("HelloWorld started!");
	}

	public String getMessage() {
		return message;
	}
}