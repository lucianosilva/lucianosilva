/**
 * 
 */
package br.com.ninecon.nfe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.*;

import org.apache.log4j.Logger;

import br.com.ninecon.nfe.dao.ConfiguracaoDAO;
import br.com.ninecon.nfe.util.Configuracao;
import br.com.ninecon.nfe.util.Proxy;


/**
 * @author luciano
 * 
 */
public class NFeBuildAllCacerts {
	//
	private static Logger logger 			= Logger.getLogger(NFeBuildAllCacerts.class);
	private static final int TIMEOUT_WS 	= 30;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		logger.info("Iniciando a geracao do arquivo CACERT");
		logger.info("Validando os parametros... ");
		
		if ( args != null && args.length == 1 ) {
			try {
				
				String cnpjEmpresa 			= args[0]; 

				logger.info("Carregando configuracao para o CNPJ " + cnpjEmpresa.trim() );
				Configuracao configuracao 	= ConfiguracaoDAO.getConfiguracao( cnpjEmpresa.trim() );
				
				//
				buildCacertFile( configuracao );
				
			} catch (Exception e) {
				logger.error("Erro ao preparar a configuracao para gerar o CACERT. " + e.getMessage(), e);
			}

		}else{
			logger.error("Nao foi informado o parametro CNPJ.");
		}

	}

	/**
	 * 
	 * @param conf
	 */
	private static void buildCacertFile( Configuracao configuracao ){

		logger.info("Configuracao carregada");
		
		String cacertFileName						= configuracao.getCacertsFileName();
		String cacertHostName						= configuracao.getCacertsHostName();
		Proxy proxy									= configuracao.getProxy();

		
		//
		logger.debug("Usando o proxy? ");

		if ( proxy!=null && proxy.getVerificar().equalsIgnoreCase("true") ) {
			//
			logger.debug("Sim, usando proxy.");
			System.setProperty("http.proxySet", "true");
			System.setProperty("proxySet", "true");

			logger.debug("proxy host : " + proxy.getUrl());
			logger.debug("proxy port : " + proxy.getPort());

			if (proxy.getUrl() != null && !proxy.getUrl().trim().equals("")){
				System.setProperty("http.proxyHost", proxy.getUrl() );
				System.setProperty("https.proxyHost", proxy.getUrl() );
			}

			if (proxy.getPort() != null && !proxy.getPort().trim().equals("")){
				System.setProperty("http.proxyPort", proxy.getPort());
				System.setProperty("https.proxyPort", proxy.getPort());
			}

			if (proxy.getUser() != null && !proxy.getUser().trim().equals("")){
				System.setProperty("http.proxyUser", proxy.getUser());
			}

			if (proxy.getPassword() != null && !proxy.getPassword().trim().equals("")){
				System.setProperty("http.proxyPassword", proxy.getPassword());
			}

		}else{
			logger.debug("Nao, sem proxy. ");
		}

		logger.debug("Propriedades da JVM relacionadas ao Proxy --- ");

		logger.debug(" http.proxyHost = "+ System.getProperty("http.proxyHost") );
//		logger.debug(" https.proxyHost = "+ System.getProperty("https.proxyHost") );

		logger.debug(" http.proxyPort = "+ System.getProperty("http.proxyPort") );
//		logger.debug(" https.proxyPort = "+ System.getProperty("https.proxyPort") );

		logger.debug(" http.proxyUser = "+ System.getProperty("http.proxyUser") );
//		logger.debug(" https.proxyUser = "+ System.getProperty("https.proxyUser") );

		logger.debug(" http.proxyPassword = "+ System.getProperty("http.proxyPassword") );
//		logger.debug(" https.proxyPassword = "+ System.getProperty("https.proxyPassword") );

		logger.debug("Fim --- ");

		String JSSECACERTS = cacertFileName;
		//
		logger.info("Definindo nome do arquivo CACERT : " + JSSECACERTS);
		
		try {
			char[] passphrase = "changeit".toCharArray();

			File file = new File(JSSECACERTS);
			if (file.isFile() == false) {
				char SEP = File.separatorChar;

				String fileName = System.getProperty("java.home") + SEP + "lib" + SEP + "security";
				logger.info("File Name: " + fileName + " ..." );

				File dir = new File(fileName);
				file = new File(dir, JSSECACERTS);
				if (file.isFile() == false) {
					file = new File(dir, "cacerts");
				}
			}

			logger.info("Loading KeyStore " + file + "...");
			InputStream in = new FileInputStream(file);
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(in, passphrase);
			in.close();

			//
			String hosts = cacertHostName;

			//
			String[] urlSefaz = hosts.split(";");
	
			String path = null;
			for (int i = 0; i < urlSefaz.length; i++) {
				
				try{
					path = urlSefaz[i];
					
					if( path!=null && path.length() > 0 ){
						get(path.trim(), 443, ks, JSSECACERTS, proxy);	
					}

				}catch (Exception e) {
					// 
					logger.error("Erro ao procesar o keystore para " + path);
					logger.error(e.getMessage(), e);
				}
			}

			File cafile = new File(JSSECACERTS);
			OutputStream out = new FileOutputStream(cafile);
			ks.store(out, passphrase);
			out.close();
			
			logger.info("Finished.");

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * @author luciano
	 * 
	 * @param host
	 * @param port
	 * @param ks
	 * @param JSSECACERTS
	 * @throws Exception
	 */
	private static void get(String host, int port, KeyStore ks, String JSSECACERTS, Proxy proxy) throws Exception {
		
		SSLContext context 		= SSLContext.getInstance("TLS");
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		tmf.init(ks);
		
		X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
		SavingTrustManager tm 				 = new SavingTrustManager(defaultTrustManager);
		context.init(null, new TrustManager[] { tm }, null);
		SSLSocketFactory factory 			 = context.getSocketFactory();

		logger.info("Opening connection to " + host + ":" + port + "...");
		
		
		SSLSocket socket = null;

		if ( proxy!=null && proxy.getVerificar().equalsIgnoreCase("true") ) {
			logger.debug("Setting Up Proxy for SSL Socket ---");

			// String proxyHost = Config.prefs.get("PROXY_NAME", "localhost");
	        // int proxyPort = Config.prefs.getInt("PROXY_PORT", 1080);
	        
			InetSocketAddress proxyAddr = new InetSocketAddress(proxy.getUrl(), Integer.parseInt(proxy.getPort()));
	        Socket underlying 			= new Socket( new java.net.Proxy(java.net.Proxy.Type.SOCKS, proxyAddr));

	        //
	        underlying.connect(new InetSocketAddress(host, port));
	        socket = (SSLSocket) factory.createSocket( 	underlying,
	                									proxy.getUrl(),
	                									Integer.parseInt(proxy.getPort()),
	                									true);

			logger.debug("Finished SSL Socket ---");

		}else{

			logger.debug("SSL Socket Factory was started");		
			//SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
			socket = (SSLSocket) factory.createSocket(host, port);
			socket.setSoTimeout(TIMEOUT_WS * 1000);
		}


		try {

			logger.info("Starting SSL handshake...");
			socket.startHandshake();
			socket.close();
			logger.info("No errors, certificate is already trusted");

		} catch (SSLHandshakeException e) {
			/**
			 * PKIX path building failed:
			 * sun.security.provider.certpath.SunCertPathBuilderException:
			 * unable to find valid certification path to requested target N‹o
			 * tratado, pois sempre ocorre essa exce�‹o quando o cacerts nao
			 * esta gerado.
			 */
		} catch (SSLException e) {
			logger.error("| " + e.toString());
		}

		X509Certificate[] chain = tm.chain;
		if (chain == null) {
			logger.info("Could not obtain server certificate chain");
		}

		logger.info("Server sent " + chain.length + " certificate(s):");
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		for (int i = 0; i < chain.length; i++) {
			X509Certificate cert = chain[i];
			sha1.update(cert.getEncoded());
			md5.update(cert.getEncoded());

			String alias = host + "-" + (i);
			ks.setCertificateEntry(alias, cert);
			logger.info("| Added certificate to keystore '" + JSSECACERTS + "' using alias '" + alias + "'");
		}
	}

	/**
	 * 
	 * @author luciano
	 *
	 */
	private static class SavingTrustManager implements X509TrustManager {
		private final X509TrustManager tm;
		private X509Certificate[] chain;

		SavingTrustManager(X509TrustManager tm) {
			this.tm = tm;
		}

		public X509Certificate[] getAcceptedIssuers() {
			throw new UnsupportedOperationException();
		}

		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
			throw new UnsupportedOperationException();
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
			this.chain = chain;
			tm.checkServerTrusted(chain, authType);
		}
	}

}