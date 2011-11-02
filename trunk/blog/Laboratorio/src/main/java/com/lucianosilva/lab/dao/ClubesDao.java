/**
 * 
 */
package com.lucianosilva.lab.dao;

import java.util.List;

import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;

import com.lucianosilva.lab.entity.Clube;
import com.lucianosilva.lab.repository.HibernateGenericRepository;

/**
 * @author luciano
 *
 */
public class ClubesDao extends HibernateGenericRepository<Clube, Long> {

	/* (non-Javadoc)
	 * @see com.lucianosilva.lab.repository.HibernateGenericRepository#findById(java.io.Serializable)
	 */
	@Override
	public Clube findById(Long id) {
		return super.findById(id);
	}


	public ClubesDao(){
		super(Clube.class);
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Clube> findByName( String name ){
		return super.findByCriteria(Expression.like("nome", name, MatchMode.ANYWHERE));
	}
}
