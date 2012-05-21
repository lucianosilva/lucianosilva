/**
 * 
 */
package com.lucianosilva.lab.jms;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * @author luciano
 *
 */
@Component
public class PersonJmsProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	//
	private static final String QUEUE_NAME = "jndi.blogQueue";

	@PostConstruct
	public void send(){
		System.out.println("mandando a mensagem mano!");
		jmsTemplate.send(QUEUE_NAME, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				// 
				return session.createTextMessage("Person -- Test");
			}
		});
	}
	
}
