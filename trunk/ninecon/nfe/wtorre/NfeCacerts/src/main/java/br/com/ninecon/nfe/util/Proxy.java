/**
 * 
 */
package br.com.ninecon.nfe.util;

import java.io.Serializable;

/**
 * @author luciano
 * 
 */
public class Proxy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1578075406553547881L;

	private String verificar;
	private String port;
	private String url;
	private String user;
	private String password;

	/**
	 * 
	 */
	public Proxy() {
	}

	/**
	 * @param verificar
	 * @param port
	 * @param url
	 * @param user
	 * @param password
	 */
	public Proxy(String verificar, String port, String url, String user,
			String password) {
		super();
		this.verificar = verificar;
		this.port = port;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	/**
	 * @return the verificar
	 */
	public String getVerificar() {
		return verificar;
	}

	/**
	 * @param verificar the verificar to set
	 */
	public void setVerificar(String verificar) {
		this.verificar = verificar;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
