/**
 * 
 */
package com.lucianosilva.lab.repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author luciano
 *
 */
public interface GenericRepository<T, ID extends Serializable> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	T findById( ID id );
	
	/**
	 * 
	 * @return
	 */
	List<T> listAll();
    
	/**
	 * 
	 * @param entity
	 * @return
	 */
	T save(T entity);
    
	/**
	 * 
	 * @param entity
	 */
	void delete(T entity);

}