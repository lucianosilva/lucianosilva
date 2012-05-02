/**
 * 
 */
package com.lucianosilva.webservice;

import java.util.List;

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
	public List<Person> obterTodos() throws BusinessWSException;
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws BusinessWSException
	 */
	public List<Person> obterPorNome( String name )
			throws BusinessWSException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws BusinessWSException
	 */
	public Person obterPorId( Long id ) throws BusinessWSException;
	
	/**
	 * 
	 * @param person
	 * @return
	 * @throws BusinessWSException
	 */
	public Boolean salvar( Person person ) throws BusinessWSException;

}