/**
 *  Licença Creative Commons.
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.lab.webservice.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.service.ClubeService;
import com.lucianosilva.lab.webservice.ClubeServicesESBV1;

/**
 * 
 *
 * @autor luciano.silva
 * @version $Rev$ $Date$
 */
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
@WebService(name = "ClubeServicesESBV1", serviceName = "ClubeServicesESBV1", endpointInterface="com.lucianosilva.lab.webservice.ClubeServicesESBV1")
public class ClubeServicesESBV1Impl extends SpringBeanAutowiringSupport implements ClubeServicesESBV1 {
	
	@Autowired
	private ClubeService clubeService;
	
	/* (non-Javadoc)
	 * @see com.lucianosilva.lab.webservice.ClubeServicesESBV1#listAll()
	 */
	public List<Clube> listAll()  throws Exception{
		return clubeService.listAll();
	}

}
