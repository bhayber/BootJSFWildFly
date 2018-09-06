package de.adesso.testJSF.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.DependsOn;

@ManagedBean(name = "helloWorld", eager = true)
@SessionScoped
@DependsOn(value = "login")
public class HelloWorld {

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