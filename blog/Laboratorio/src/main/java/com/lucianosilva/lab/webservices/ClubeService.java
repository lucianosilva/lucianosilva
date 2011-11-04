/**
 * 
 */
package com.lucianosilva.lab.webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.lucianosilva.lab.entity.Clube;

/**
 * @author luciano
 *
 */
@WebService
public interface ClubeService {

	@WebMethod(operationName="ListAllClubes")
	@WebResult(name = "Clube")
	public List<Clube> listAll();

	@WebMethod(operationName="FindByClubeName")
	@WebResult(name = "Clube")
	public List<Clube> findByName(@WebParam(name = "clubeName") String name);

}
