/**
 * 
 */
package com.lucianosilva.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucianosilva.dao.PersonDAO;
import com.lucianosilva.entity.Person;
import com.lucianosilva.service.PersonService;

/**
 * @author luciano.silva
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	/* (non-Javadoc)
	 * @see com.lucianosilva.service.PersonService#findAll()
	 */
	@Override
	public List<Person> findAll() {
		// 
		return personDAO.findAll();
	}

}
