/**
 * 
 */
package com.lucianosilva.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.lucianosilva.entity.Person;
import com.lucianosilva.exception.BusinessWSException;

/**
 * @author luciano.silva
 *
 */
@WebService
public interface PersonServiceESBV1 {

	/**
	 * 
	 * @return
	 */
	@WebMethod(operationName = "ObterTodos")
	public List<Person> obterTodos() throws BusinessWSException;
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws BusinessWSException
	 */
	@WebMethod(operationName = "ObterPorNome")
	public List<Person> obterPorNome(String name) throws BusinessWSException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws BusinessWSException
	 */
	@WebMethod(operationName = "ObterPorId")
	public Person obterPorId( Long id ) throws BusinessWSException;
	
	/**
	 * 
	 * @param person
	 * @return
	 * @throws BusinessWSException
	 */
	@WebMethod(operationName = "Salvar")
	public Boolean salvar( Person person ) throws BusinessWSException;

}