/**
 * 
 */
package com.lucianosilva.dao.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.lucianosilva.dao.PersonDAO;
import com.lucianosilva.entity.Person;

/**
 * @author ERPR12
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = "classpath:META-INF/spring/app-context-test.xml")
public class PersonDaoTest {

	@Autowired
	private PersonDAO dao;

	private static Logger log = Logger.getLogger(PersonDaoTest.class); 
	
	@Test
	public void testA() {
		log.info("****************************");
		Person p = dao.findById(1L);
		log.info("Person : " + p.getFirstName() + " " + p.getLastName() );
		log.info("****************************");
	}

	@Test
	public void testB() {
		log.info("------------");
		
		List<Person> personList = dao.findAll();
		log.info( "Tamanho : " + personList.size() );

		for( Person p : personList ){
			log.info(p.getPersonId() + " -- " +  p.getFirstName() + " " + p.getLastName() );
		}

		log.info("------------");
	}
/*	*/

}