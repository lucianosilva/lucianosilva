/**
 * 
 */
package com.lucianosilva.service;

import java.util.List;

import com.lucianosilva.entity.Person;

/**
 * @author luciano.silva
 *
 */
public interface PersonService {

	/**
	 * 
	 * @param person
	 * @return
	 * @throws Exception
	 */
	public Boolean saveOrUpdate( Person person ) throws Exception;
	
	/**
	 * 
	 * @return
	 */
	public List<Person> findAll() throws Exception;
	
	/**
	 * 
	 * @param personName
	 * @return
	 * @throws Exception
	 */
	public List<Person> findByName( String personName ) throws Exception;
	
	/**
	 * 
	 * @param personId
	 * @return
	 * @throws Exception
	 */
	public Person findById( Long personId ) throws Exception;
}
