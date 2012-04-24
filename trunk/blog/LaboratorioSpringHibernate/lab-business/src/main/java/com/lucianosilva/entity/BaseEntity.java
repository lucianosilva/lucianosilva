/**
 * 
 */
package com.lucianosilva.entity;

import java.io.Serializable;

/**
 * @author luciano.silva
 * 
 */
public interface BaseEntity<T> extends Serializable {
	
	/**
	 * @return T
	 */
	T getId();

	/**
	 * @param id
	 */
	void setId(T id);

}