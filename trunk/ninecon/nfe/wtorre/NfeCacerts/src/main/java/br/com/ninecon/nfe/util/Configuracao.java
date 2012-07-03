/**
 * 
 */
package br.com.ninecon.nfe.util;

import java.io.Serializable;

/**
 * @author luciano
 * 
 */
public class Configuracao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5027370470970600438L;

	private String cacertsHostName;
	private String cacertsFileName;
	private Proxy proxy;

	/**
	 * 
	 */
	public Configuracao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cacertsHostName
	 * @param cacertsFileName
	 * @param proxy
	 */
	public Configuracao(String cacertsHostName, String cacertsFileName,
			Proxy proxy) {
		super();
		this.cacertsHostName = cacertsHostName;
		this.cacertsFileName = cacertsFileName;
		this.proxy = proxy;
	}

	/**
	 * @return the cacertsHostName
	 */
	public String getCacertsHostName() {
		return cacertsHostName;
	}

	/**
	 * @param cacertsHostName
	 *            the cacertsHostName to set
	 */
	public void setCacertsHostName(String cacertsHostName) {
		this.cacertsHostName = cacertsHostName;
	}

	/**
	 * @return the cacertsFileName
	 */
	public String getCacertsFileName() {
		return cacertsFileName;
	}

	/**
	 * @param cacertsFileName
	 *            the cacertsFileName to set
	 */
	public void setCacertsFileName(String cacertsFileName) {
		this.cacertsFileName = cacertsFileName;
	}

	/**
	 * @return the proxy
	 */
	public Proxy getProxy() {
		return proxy;
	}

	/**
	 * @param proxy
	 *            the proxy to set
	 */
	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

}
