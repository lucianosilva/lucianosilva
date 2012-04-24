/**
 * 
 */
package com.lucianosilva.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lucianosilva.dao.PersonDAO;
import com.lucianosilva.entity.Person;
import com.lucianosilva.service.PersonService;

/**
 * @author luciano.silva
 *
 */
@Service
public class PersonServiceImpl extends SpringBeanAutowiringSupport implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	/* (non-Javadoc)
	 * @see com.lucianosilva.service.PersonService#findAll()
	 */
	@Override
	public List<Person> findAll() throws Exception {
		// 
		List<Person> list = null;

		list = personDAO.findAll();

		if( list == null ){
			throw new Exception("Nenhum registro encontrado. ");
		}else if( list.size() == 0 ){
			throw new Exception("Nenhum registro encontrado. ");
		}

		return list;
	}

	/**
	 * 
	 */
	@Override
	public List<Person> findByName(String personName) throws Exception {
		// 
		List<Person> list = null;
		
		list = personDAO.findLikeName( personName );

		if( list == null ){
			throw new Exception("Nenhum registro encontrado para: " + personName);
		}else if( list.size() == 0 ){
			throw new Exception("Nenhum registro encontrado para: " + personName);
		}
		
		return list;
	}

	@Override
	public Boolean saveOrUpdate(Person person) throws Exception {
		// 
		Boolean saved = true;

		try{
			personDAO.save( person );
		}catch (Exception e) {
			// 
			throw new Exception("Erro ao Gravar/Atualizar. " + e.getMessage(), e);
		}

		return saved;
	}

	@Override
	public Person findById(Long personId) throws Exception {
		// 
		return personDAO.findById( personId );
	}

}