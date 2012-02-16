/**
 * 
 */
package com.lucianosilva.lab.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.exception.BusinessException;

/**
 * @author luciano
 *
 */
@Service
@Scope("request")
@Transactional(rollbackFor=Exception.class)
public interface ClubeService {

	public Boolean save(Clube clube) throws BusinessException;
	
}
