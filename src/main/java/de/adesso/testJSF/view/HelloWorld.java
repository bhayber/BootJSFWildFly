package de.adesso.testJSF.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "helloWorld", eager = true)
@SessionScoped
public class HelloWorld {

	private String message;

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