/**
 * 
 */
package br.com.ninecon.nfe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import br.com.ninecon.nfe.util.CacertUtil;
import br.com.ninecon.nfe.util.Configuracao;
import br.com.ninecon.nfe.util.Proxy;

/**
 * @author luciano
 *
 */
public class ConfiguracaoDAO {

	private static Logger logger 			= Logger.getLogger( ConfiguracaoDAO.class );
	private static final CacertUtil conf 	= new CacertUtil();

	/**
	 * 
	 * @param cnpjEmpresa
	 * @return
	 * @throws Exception
	 */
	public static Configuracao getConfiguracao( String cnpjEmpresa ) throws Exception{

		/**
		 * Consulta tabela de configuracao das propriedades de banco
		 */
		Connection connectionConsult = null;
		logger.debug("Iniciando conexao com o banco de dados.");

		Configuracao configuracao = null;
		
		try {

			String driver = conf.getDbDriver(); // oracle.jdbc.OracleDriver
			String url = conf.getDbUrl(); // jdbc:oracle:thin:@10.0.18.126:1569:GSD1BR
			String login = conf.getDbUser(); // apps
			String senha = conf.getDbPassword(); // apps

			logger.debug("driver: " + driver);
		    logger.debug("url: " + url);
			logger.debug("login: " + login);
			logger.debug("senha: " + senha );

			Class.forName(driver);
			connectionConsult = DriverManager.getConnection(url, login, senha);
			logger.debug("Conectado no banco de dados.");

		} catch (SQLException sqlexception) {
			logger.error(sqlexception);
			throw new Exception(sqlexception.toString());
		} catch (Exception exception) {
			logger.error(exception);
			throw new Exception(exception.toString());
		}

		PreparedStatement pstmt = null;
		ResultSet resultSet 	= null;

		if (connectionConsult != null) {
			try {
				//
				String caminhoDoCertificadoDoCliente 		= null;
				String senhaDoCertificadoDoCliente 			= null;
				String arquivoCacertsGeradoParaCadaEstado 	= null;
				String proxyVerificar 						= null;
				String proxyPort 							= null;
				String proxyUrl 							= null;
				String proxyPassword						= null;
				String proxyUser							= null;

				String consulta = "SELECT DIR_CERTIFICADO, FILE_CERTIFICADO, SENHA_CERTIFICADO, FILE_CACERTS, PROXY_VER, PROXY_PORT, PROXY_URL, PROXY_USER, PROXY_PASS, (SUBSTR(CNPJ_EMPRESA,1,8)) FROM NFEE_CONFIG_PROPERTIES WHERE CNPJ_EMPRESA = ? ";
				pstmt = connectionConsult.prepareStatement(consulta);
				pstmt.setString(1, cnpjEmpresa);

				resultSet = pstmt.executeQuery();
				if (resultSet != null) {
					if (resultSet.next()) {
						//
						caminhoDoCertificadoDoCliente 		= resultSet.getString("DIR_CERTIFICADO") + resultSet.getString("FILE_CERTIFICADO");
						senhaDoCertificadoDoCliente 		= resultSet.getString("SENHA_CERTIFICADO"); //
						arquivoCacertsGeradoParaCadaEstado 	= resultSet.getString("FILE_CACERTS"); //
						proxyVerificar 						= resultSet.getString("PROXY_VER");
						proxyPort 							= resultSet.getString("PROXY_PORT");
						proxyUrl 							= resultSet.getString("PROXY_URL");
						proxyPassword 						= resultSet.getString("PROXY_PASS");
						proxyUser 							= resultSet.getString("PROXY_USER");

						
						Proxy proxy = new Proxy();
						proxy.setVerificar(proxyVerificar);
						proxy.setPort(proxyPort);
						proxy.setUrl(proxyUrl);
						proxy.setUser(proxyUser);
						proxy.setPassword(proxyPassword);
						
						configuracao = new Configuracao();
						configuracao.setCacertsFileName( conf.getCacertFileName() );
						configuracao.setCacertsHostName( conf.getCacertHosts() );
						configuracao.setProxy(proxy);
						
						logger.debug("porxy Verifica					 : " + proxyVerificar);
						logger.debug("porxy Host					 	 : " + proxyUrl);
						logger.debug("porxy Port					 	 : " + proxyPort);
						logger.debug("porxy User					 	 : " + proxyUser);
						logger.debug("porxy Password					 : " + proxyPassword);

						logger.debug("caminhoDoCertificadoDoCliente 	 : " + caminhoDoCertificadoDoCliente);
						logger.debug("senhaDoCertificadoDoCliente 	     : " + senhaDoCertificadoDoCliente);
						logger.debug("arquivoCacertsGeradoParaCadaEstado : " + arquivoCacertsGeradoParaCadaEstado);
					}
				}

			} catch (Exception e) {
				logger.error(e);
				throw new Exception(e.toString());
	
			}

			// closing
			logger.debug("Fechando conexao...");
			
			if( resultSet!=null ) resultSet.close();
			if( pstmt!=null ) pstmt.close();
			if (connectionConsult != null) connectionConsult.close();

		} else {
			//
			logger.error("N‹o foi possivel conectar no banco de dados.");
		}

		//
		return configuracao;
	}
	
	
}
