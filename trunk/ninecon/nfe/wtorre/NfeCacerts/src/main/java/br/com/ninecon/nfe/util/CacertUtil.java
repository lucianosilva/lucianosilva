/**
 * 
 */
package br.com.ninecon.nfe.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
/**
 * 
 * @author luciano
 *
 */
public class CacertUtil {

	//
	private static final String ARQUIVO = "config-ninecon.properties";

	private Properties pp;

	/**
	 * 
	 */
	public CacertUtil() {
		this.pp = new Properties();
		try {
			InputStream fis = ClassLoader.getSystemResourceAsStream( ARQUIVO );
			//this.pp = new Properties();
			this.pp.load(fis);
			if (fis == null)
				return;
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param k
	 * @return
	 */
	public String getValor(String k) {
		return this.pp.getProperty(k);
	}

	/**
	 * 
	 */
	public void exibeChaveValor() {
		Enumeration keys = this.pp.keys();
		while (keys.hasMoreElements()) {
			String k = (String) keys.nextElement();
			System.out.println(k + "   : " + this.pp.getProperty(k));
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getCacertFileName(){
		return this.getValor("cacert_file");
	}

	/**
	 * 
	 * @return
	 */
	public String getCacertHosts(){
		return this.getValor("cacert_hosts");
	}
	

	/**
	 * 
	 * @return
	 */
	public String getDbDriver(){
		return this.getValor("db_orcl_drv");
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDbUser(){
		return this.getValor("db_orcl_usr");
	}

	/**
	 * 
	 * @return
	 */
	public String getDbPassword(){
		return this.getValor("db_orcl_pwd");
	}

	/**
	 * 
	 * @return
	 */
	public String getDbUrl(){
		return this.getValor("db_orcl_url");
	}


}