/**
 * 
 */
package com.lucianosilva.lab.webservice.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.exception.BusinessException;
import com.lucianosilva.lab.exception.BusinessWSException;
import com.lucianosilva.lab.exception.FaultInfo;
import com.lucianosilva.lab.service.ClubeService;
import com.lucianosilva.lab.webservice.ClubeServiceESBV1;

/**
 * @author luciano
 *
 */
@WebService(name = "ClubeServiceESBV1", serviceName = "ClubeServiceESBV1", portName = "ClubeServiceESBV1Port", targetNamespace = "http://www.lucianosilva.com/ESB/ClubeServiceESB/V1")
public class ClubeServiceESBV1Impl implements ClubeServiceESBV1 {

	@Autowired
	private ClubeService service;
	
	/* (non-Javadoc)
	 * @see com.lucianosilva.lab.webservice.ClubeServiceESBV1#Gravar(com.lucianosilva.lab.core.entity.Clube)
	 */
	@Override
	public Boolean Gravar(Clube clube) throws BusinessWSException {
		// 
		Boolean isSaved = true;
		System.out.println("Gravando... ");

		try {
			isSaved = service.save(clube);
		} catch (BusinessException e) {
			System.out.println("Gerou um erro... ");
			e.printStackTrace();
			//
			FaultInfo fi = new FaultInfo();
			fi.setDescription("Description.");
			fi.setErrorCode("ERRORWS");
			fi.setMessage(e.getMessage());
			fi.setStackTrace(e.toString());
			
			throw new BusinessWSException(e.getMessage(), fi);
		}

		return isSaved;
	}

}
