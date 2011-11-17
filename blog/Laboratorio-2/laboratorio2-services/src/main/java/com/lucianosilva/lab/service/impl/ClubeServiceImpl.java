/**
 *  Licença Creative Commons.
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.lab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.core.repository.ClubeRepository;
import com.lucianosilva.lab.service.ClubeService;

/**
 * 
 *
 * @autor luciano.silva
 * @version $Rev$ $Date$
 */
public class ClubeServiceImpl implements ClubeService {

	@Autowired
	private ClubeRepository clubeRepository;


	/* (non-Javadoc)
	 * @see com.lucianosilva.lab.service.ClubeService#listAll()
	 */
	public List<Clube> listAll() {
		// 
		List<Clube> list = null;
		
		list = clubeRepository.findAll();
		
		return list;
	}

}