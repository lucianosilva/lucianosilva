/**
 * 
 */
package com.lucianosilva.lab.webservices.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lucianosilva.lab.dao.ClubesDao;
import com.lucianosilva.lab.entity.Clube;
import com.lucianosilva.lab.webservices.ClubeService;

/**
 * @author luciano
 *
 */
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
@WebService(endpointInterface="com.lucianosilva.lab.webservices.ClubeService")
public class ClubeServiceImpl implements ClubeService {

	private ClubesDao clubesDao;

	public List<Clube> findByName(String name) {
		return clubesDao.findByName(name);
	}

	public List<Clube> listAll() {
		//  
		return clubesDao.listAll();
	}

	/**
	 * @return the clubesDao
	 */
	public ClubesDao getClubesDao() {
		return clubesDao;
	}

	/**
	 * @param clubesDao the clubesDao to set
	 */
	public void setClubesDao(ClubesDao clubesDao) {
		this.clubesDao = clubesDao;
	}

}