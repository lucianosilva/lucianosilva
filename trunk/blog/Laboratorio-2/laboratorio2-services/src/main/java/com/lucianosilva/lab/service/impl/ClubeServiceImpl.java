/**
 *  Licen�a Creative Commons.
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.lab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.core.repository.ClubeRepository;
import com.lucianosilva.lab.service.ClubeService;

/**
 * 
 *
 * @autor luciano.silva
 * @version $Rev$ $Date$
 */
public class ClubeServiceImpl extends SpringBeanAutowiringSupport implements ClubeService {

	@Autowired
	private ClubeRepository clubeRepository;


	/* (non-Javadoc)
	 * @see com.lucianosilva.lab.service.ClubeService#listAll()
	 */
	public List<Clube> listAll() {
		// 
		return clubeRepository.findAll();

	}

}