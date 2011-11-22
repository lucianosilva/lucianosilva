/**
 *  Licença Creative Commons.
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.lab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucianosilva.lab.core.entity.Clube;

/**
 * 
 *
 * @autor luciano.silva
 * @version $Rev$ $Date$
 */
public interface ClubeService {

	List<Clube> listAll();
	
}
