/**
 * 
 */
package com.lucianosilva.webservice.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucianosilva.entity.Person;
import com.lucianosilva.service.PersonService;
import com.lucianosilva.webservice.PersonServiceESBV1;

/**
 * @author ERPR12
 *
 */
@WebService(name="PersonServiceESBV1", serviceName="PersonServiceESBV1", portName="PersonServiceESBV1Port")
public class PersonServiceESBV1Impl implements PersonServiceESBV1 {

	@Autowired
	private PersonService service;
	
	/* (non-Javadoc)
	 * @see com.lucianosilva.webservice.PersonServiceESBV1#obterTodos()
	 */
	@Override
	public List<Person> obterTodos() {
		// 
		return service.findAll();
	}

}