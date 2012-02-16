/**
 * 
 */
package com.lucianosilva.lab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.dao.ClubeDao;
import com.lucianosilva.lab.exception.BusinessException;
import com.lucianosilva.lab.service.ClubeService;

/**
 * @author luciano
 *
 */
@Service("clubeService")
public class ClubeServiceImpl implements ClubeService {

	@Autowired
	private ClubeDao clubeDao;
	
	public Boolean save(Clube clube) throws BusinessException {
		// 
		Boolean isSaved = true;

		try {

			clubeDao.save(clube);

		} catch (DataAccessException e) {
			throw new BusinessException(e.getMessage(), e);
		}

		return isSaved;
	}

}