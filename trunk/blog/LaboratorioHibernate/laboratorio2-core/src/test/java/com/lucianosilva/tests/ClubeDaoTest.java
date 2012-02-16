/**
 * 
 */
package com.lucianosilva.tests;

import java.util.Date;

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

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.dao.ClubeDao;



/**
 * @author luciano
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
@TransactionConfiguration(defaultRollback=false)
@ContextConfiguration(locations = "classpath:META-INF/spring/application-context.xml")
public class ClubeDaoTest {
	
	@Autowired
	private ClubeDao clubeDao;
	
	@Test
	public void test(){
		
		
		Clube clube = new Clube();
		clube.setIdClube(10000L);
		clube.setNome("Teste");
		clube.setDataFundacao( new Date() );
		
		try {
			clubeDao.save( clube );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
