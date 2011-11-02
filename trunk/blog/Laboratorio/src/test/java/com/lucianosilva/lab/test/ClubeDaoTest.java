/**
 * 
 */
package com.lucianosilva.lab.test;

import java.util.List;

import org.junit.Assert;
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

import com.lucianosilva.lab.dao.ClubesDao;
import com.lucianosilva.lab.entity.Clube;

/**
 * @author luciano
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
@TransactionConfiguration(defaultRollback=true)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class ClubeDaoTest {

	@Autowired
	private ClubesDao clubeDao;

	@Test
	public void test(){
		
		List<Clube> list = null; 
		
		list = clubeDao.findByName("Barcelona");
		
		//
		Assert.assertNotNull( list );
	}
	
}
