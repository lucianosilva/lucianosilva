/**
 * 
 */
package com.lucianosilva.dao.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @author luciano.silva
 *
 */
public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws HibernateException
	 */
	void save(T entity) throws HibernateException;
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws HibernateException
	 */
	void update(T entity) throws HibernateException;

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws HibernateException
	 */
	void merge(T entity) throws HibernateException;

	/**
	 * 
	 * @param entity
	 * @throws HibernateException
	 */
	void remove(T entity) throws HibernateException;

	/**
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * 
	 * @param id
	 * @return
	 */
	T findById(ID id);

	/**
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	List<T> findAllByProperty(String propertyName, Object value);

	/***
	 * 
	 * @param criteria
	 * @return
	 */
	List<T> findAllByCriteria(DetachedCriteria criteria);
	
	/**
	 * 
	 * @param q
	 * @return
	 */
	List<T> findWithCustomQuery(String q);
}