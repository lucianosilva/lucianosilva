/**
 * 
 */
package com.lucianosilva.lab.webservice;

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.exception.BusinessWSException;

/**
 * @author luciano
 * 
 */
public interface ClubeServiceESBV1 {

	/**
	 * 
	 * @param clube
	 * @return
	 * @throws BusinessWSException
	 */
	public Boolean Gravar(Clube clube)
			throws BusinessWSException;

}
