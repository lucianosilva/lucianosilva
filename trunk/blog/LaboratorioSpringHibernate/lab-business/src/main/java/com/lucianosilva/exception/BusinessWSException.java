/**
 *  Copyright (C) Abril.  All rights reserved.
 *  Editora Abril www.abril.com.br
 */
package com.lucianosilva.exception;

import javax.xml.ws.WebFault;

/**
 * 
 * 
 * @autor luciano
 * @version $Rev$ $Date$
 */
@WebFault(name = "BusinessWSException", targetNamespace = "http://www.lucianosilva.com/EBO/Common/V1")
public class BusinessWSException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4556047717913560343L;

	FaultInfo faultInfo;

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 * 
	 */
	public BusinessWSException(String message, FaultInfo faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	
	/**
	 * 
	 * @param cause
	 * 
	 */
	public BusinessWSException(String message, FaultInfo faultInfo,
			Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	
	/**
	 * 
	 * @return the faultInfo
	 * 
	 */
	public FaultInfo getFaultInfo() {
		return faultInfo;
	}

}