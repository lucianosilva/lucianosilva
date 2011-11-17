/**
 *  Licença Creative Commons.
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.lab.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.lucianosilva.lab.core.entity.Clube;

/**
 * 
 *
 * @autor luciano.silva
 * @version $Rev$ $Date$
 */
@WebService
public interface ClubeServicesESBV1 {

	@WebMethod(operationName="ListAllClubes")
	@WebResult(name = "Clube")
	public List<Clube> listAll();
	
}
