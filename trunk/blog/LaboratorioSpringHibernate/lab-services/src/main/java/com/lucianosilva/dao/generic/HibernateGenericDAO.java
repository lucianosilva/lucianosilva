/**
 * 
 */
package com.lucianosilva.dao.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author luciano.silva
 * 
 */
public abstract class HibernateGenericDAO<T, ID extends Serializable> extends
		HibernateDaoSupport implements GenericDAO<T, ID> {

	@Autowired
	public void anyMethodName( SessionFactory sessionFactory ) {
		setSessionFactory( sessionFactory );
	}

	/**
	 * 
	 * @return
	 */
	protected abstract Class<T> getEntityClass();

	/**
	 * 
	 * @return
	 */
	protected DetachedCriteria createDetachedCriteria() {
		return DetachedCriteria.forClass(getEntityClass());
	}

	/* (non-Javadoc)
	 * @see com.lucianosilva.dao.generic.GenericDAO#save(java.lang.Object)
	 */
	@Override
	public void save(T entity) throws HibernateException {
		//
		getHibernateTemplate().save(entity);
	}

	/* (non-Javadoc)
	 * @see com.lucianosilva.dao.generic.GenericDAO#update(java.lang.Object)
	 */
	@Override
	public void update(T entity) throws HibernateException {
		// 
		getHibernateTemplate().update(entity);
	}

	/* (non-Javadoc)
	 * @see com.lucianosilva.dao.generic.GenericDAO#merge(java.lang.Object)
	 */
	@Override
	public void merge(T entity) throws HibernateException {
		// 
		getHibernateTemplate().merge(entity);
	}

	/* (non-Javadoc)
	 * @see com.lucianosilva.dao.generic.GenericDAO#remove(java.lang.Object)
	 */
	@Override
	public void remove(T entity) throws HibernateException {
		// 
		getHibernateTemplate().delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.lucianosilva.dao.generic.GenericDAO#findAll()
	 */
	@Override
	public List<T> findAll() {
		// 
		return getHibernateTemplate().findByCriteria(createDetachedCriteria());
	}

	/* (non-Javadoc)
	 * @see com.lucianosilva.dao.generic.GenericDAO#findById(java.io.Serializable)
	 */
	@Override
	public T findById(ID id) {
		// 
        return (T) getHibernateTemplate().get(getEntityClass(), id);
	}

	/* (non-Javadoc)
	 * @see com.lucianosilva.dao.generic.GenericDAO#findAllByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<T> findAllByProperty(String propertyName, Object value) {
		//
		DetachedCriteria criteria = createDetachedCriteria();
        criteria.add(Restrictions.eq(propertyName, value));
        //
        return getHibernateTemplate().findByCriteria(criteria);
	}

	/* (non-Javadoc)
	 * @see com.lucianosilva.dao.generic.GenericDAO#findAllByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public List<T> findAllByCriteria(DetachedCriteria criteria) {
		// 
        return getHibernateTemplate().findByCriteria(criteria);
	}

	/* (non-Javadoc)
	 * @see com.lucianosilva.dao.generic.GenericDAO#findWithCustomQuery(java.lang.String)
	 */
	@Override
	public List<T> findWithCustomQuery(String q) {
		// 
		return getHibernateTemplate().find(q);
	}
}