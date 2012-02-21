/**
 * 
 */
package com.lucianosilva.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.lucianosilva.entity.Person;

/**
 * @author ERPR12
 *
 */
@WebService
public interface PersonServiceESBV1 {

	@WebMethod(operationName = "ObterTodos")
	public List<Person> obterTodos();
	
}
