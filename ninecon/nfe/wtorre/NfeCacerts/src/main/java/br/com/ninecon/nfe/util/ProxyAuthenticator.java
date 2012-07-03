/**
 * 
 */
package br.com.ninecon.nfe.util;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * @author luciano
 * 
 */
public class ProxyAuthenticator extends Authenticator {
	private String user;
	private String password;

	/**
	 * @param user
	 * @param password
	 */
	public ProxyAuthenticator(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	/**
	 * 
	 */
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password.toCharArray());
	}
}
