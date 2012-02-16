/**
 * 
 */
package com.lucianosilva.lab.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.util.CustomHibernateDaoSupport;

/**
 * @author luciano
 *
 */
@Repository("clubeDao")
public class ClubeDao extends CustomHibernateDaoSupport {
	private static Log LOG = LogFactory.getLog(ClubeDao.class);
	/**
	 * 
	 * @param clube
	 * @return
	 * @throws Exception
	 */
	public void save(Clube clube) throws DataAccessException{
		//
		
		try {
			
			getHibernateTemplate().save(clube);
			
		} catch (final HibernateException ex) {
			LOG.error(ex);
			throw convertHibernateAccessException(ex);
		}
	}
	
}
