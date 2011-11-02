/**
 * 
 */
package com.lucianosilva.lab.repository;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author luciano
 * 
 */
public class HibernateGenericRepository<T, ID extends Serializable> extends
		HibernateDaoSupport implements GenericRepository<T, ID> {

	private static Log LOG = LogFactory
			.getLog(HibernateGenericRepository.class);

	@SuppressWarnings("unchecked")
	public HibernateGenericRepository(final Class objectClass) {
		this.persistentClass = objectClass;
	}

	//
	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	/**
	 * 
	 */
	public T findById(ID id) {
		//
		try {

			return (T) this.getHibernateTemplate()
					.get(getPersistentClass(), id);

		} catch (final HibernateException ex) {
			HibernateGenericRepository.LOG.error(ex);
			throw convertHibernateAccessException(ex);
		}
	}

	/**
	 * 
	 */
	public List<T> listAll() {
		//
		try {

			return this.getHibernateTemplate().loadAll(getPersistentClass());

		} catch (HibernateException e) {
			HibernateGenericRepository.LOG.error(e);
			throw convertHibernateAccessException(e);
		}
	}

	/**
	 * 
	 */
	public T save(T entity) {
		//
		try {

			this.getHibernateTemplate().persist(entity);
			return entity;

		} catch (HibernateException e) {
			HibernateGenericRepository.LOG.error(e);
			throw convertHibernateAccessException(e);
		}
	}

	/**
	 * 
	 */
	public void delete(T entity) {
		//
		try {

			this.getHibernateTemplate().delete(entity);

		} catch (HibernateException e) {
			HibernateGenericRepository.LOG.error(e);
			throw convertHibernateAccessException(e);
		}
	}

	/**
	 * 
	 * @param criterion
	 * @return
	 */
	protected List<T> findByCriteria(Criterion... criterion) {
		//
		try {

			Criteria crit = this.getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createCriteria(getPersistentClass());
			for ( Criterion c : criterion ) {
				crit.add(c);
			}
			return crit.list();

		} catch (final HibernateException ex) {
			HibernateGenericRepository.LOG.error(ex);
			throw convertHibernateAccessException(ex);
		}
	}

}