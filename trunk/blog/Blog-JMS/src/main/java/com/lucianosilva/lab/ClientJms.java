/**
 * 
 */
package com.lucianosilva.lab;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lucianosilva.lab.entity.Person;
import com.lucianosilva.lab.jms.PersonJmsProducer;

/**
 * @author luciano
 *
 */
public class ClientJms {

	private static Logger log = Logger.getLogger( ClientJms.class.getName() );
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		log.info("Iniciando o contexto.");
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

		Person p = new Person();
		p.setPersonId(10000l);
		p.setFirstName("Luciano");
		p.setLastName("Carmo");

		log.info("Produzindo a mensagem");
		//
		PersonJmsProducer pjp = context.getBean("jmsProduce", PersonJmsProducer.class);

		log.info("Enviando...");
		pjp.send();

		log.info("Finalizando o envio.");

	}

}