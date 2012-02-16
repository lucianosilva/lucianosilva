/**
 * 
 */
package com.lucianosilva.lab.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * @author luciano
 * 
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

	@Autowired
	public void anyMethodName(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
