/**
 * 
 */
package com.lucianosilva.webservice.impl;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lucianosilva.entity.Person;
import com.lucianosilva.exception.BusinessWSException;
import com.lucianosilva.exception.ExceptionFactory;
import com.lucianosilva.service.PersonService;
import com.lucianosilva.webservice.PersonServiceESBV1;

/**
 * @author luciano.silva
 *
 */
@WebService(name="PersonServiceESBV1", targetNamespace = "com.lucianosilva.webservice.PersonServiceESBV1", serviceName="PersonServiceESBV1")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PersonServiceESBV1Impl extends SpringBeanAutowiringSupport implements PersonServiceESBV1 {

	@Autowired
	private PersonService service;

	/* (non-Javadoc)
	 * @see com.lucianosilva.webservice.PersonServiceESBV1#obterTodos()
	 */
	@Override
	public List<Person> obterTodos() throws BusinessWSException{
		// 
		try {
			return service.findAll();
		} catch (Exception e) {
			throw ExceptionFactory.createFault(e);
		}
	}

	@Override
	public List<Person> obterPorNome(String name) throws BusinessWSException {
		// 
		try {
			return service.findByName(name);
		} catch (Exception e) {
			throw ExceptionFactory.createFault(e);
		}
	}

	@Override
	public Person obterPorId(Long id) throws BusinessWSException {
		//
		try {
			return service.findById(id);
		} catch (Exception e) {
			throw ExceptionFactory.createFault(e);
		}
	}

	@Override
	public Boolean salvar(Person person) throws BusinessWSException {
		// 
		try {
			return service.saveOrUpdate( person );
		} catch (Exception e) {
			throw ExceptionFactory.createFault(e);
		}
	}
}