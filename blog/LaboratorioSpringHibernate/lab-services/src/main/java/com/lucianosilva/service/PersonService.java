/**
 * 
 */
package com.lucianosilva.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucianosilva.entity.Person;

/**
 * @author luciano.silva
 *
 */
public interface PersonService {

	/**
	 * 
	 * @return
	 */
	public List<Person> findAll();
	
}
