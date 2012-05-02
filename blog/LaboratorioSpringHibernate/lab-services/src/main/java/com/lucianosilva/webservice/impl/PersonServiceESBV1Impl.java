/**
 * 
 */
package com.lucianosilva.webservice.impl;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
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

	@Override
	@WebMethod(operationName = "ObterTodos")
	@WebResult(name = "Person", targetNamespace = Person.NAMESPACE)
	public List<Person> obterTodos() throws BusinessWSException{
		// 
		try {
			return service.findAll();
		} catch (Exception e) {
			throw ExceptionFactory.createFault(e);
		}
	}

	@Override
	@WebMethod(operationName = "ObterPorNome")
	@WebResult(name = "Person", targetNamespace = Person.NAMESPACE)
	public List<Person> obterPorNome(@WebParam(name = "name", mode = Mode.IN) String name) throws BusinessWSException {
		// 
		try {
			return service.findByName(name);
		} catch (Exception e) {
			throw ExceptionFactory.createFault(e);
		}
	}

	@Override
	@WebMethod(operationName = "ObterPorId")
	@WebResult(name = "Person", targetNamespace = Person.NAMESPACE)
	public Person obterPorId( @WebParam(name = "id", mode = Mode.IN) Long id ) throws BusinessWSException {
		//
		try {
			return service.findById(id);
		} catch (Exception e) {
			throw ExceptionFactory.createFault(e);
		}
	}

	@Override
	@WebMethod(operationName = "Salvar")
	@WebResult(name = "Boolean")
	public Boolean salvar( @WebParam(name = "person", mode = Mode.IN) Person person ) throws BusinessWSException {
		// 
		try {
			return service.saveOrUpdate( person );
		} catch (Exception e) {
			throw ExceptionFactory.createFault(e);
		}
	}
}