/**
 * 
 */
package com.lucianosilva.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lucianosilva.dao.generic.HibernateGenericDAO;
import com.lucianosilva.entity.Person;

/**
 * @author luciano.silva
 *
 */
@Repository
public class PersonDAO extends HibernateGenericDAO<Person, Long> {

	@Override
	protected Class<Person> getEntityClass() {
		return Person.class;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Person> findLikeName( String name ) {
		//
		DetachedCriteria criteria = super.createDetachedCriteria();

		criteria.add( Restrictions.disjunction()
						.add( Restrictions.like("firstName", name))
						.add( Restrictions.like("lastName", name)) );

		return super.findAllByCriteria( criteria );
	}

}