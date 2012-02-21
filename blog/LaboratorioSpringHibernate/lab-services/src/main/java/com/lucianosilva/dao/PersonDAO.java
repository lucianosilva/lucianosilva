/**
 * 
 */
package com.lucianosilva.dao;

import org.springframework.stereotype.Repository;

import com.lucianosilva.dao.generic.HibernateGenericDAO;
import com.lucianosilva.entity.Person;

/**
 * @author luciano.silva
 *
 */
@Repository
public class PersonDAO extends HibernateGenericDAO<Person, Long> {

	@Override
	protected Class<Person> getEntityClass() {
		return Person.class;
	}

}