/**
 *  Copyright (C) Abril.  All rights reserved.
 *  Editora Abril www.abril.com.br
 */
package com.lucianosilva.exception;

/**
 * Factory class for BusinessException.
 * 
 * @autor luciano
 * @version $Rev$ $Date$
 */
public class ExceptionFactory {

	/**
	 * Constructor.
	 */
	private ExceptionFactory() {
	}


	/**
	 * 
	 * @param ex
	 * @return
	 */
	public static BusinessWSException createFault(Exception ex) {

		String msg = ex.getMessage();
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setDescription(msg);
		faultInfo.setErrorCode("ERR0WS");
		faultInfo.setInstruction("Contact the administrator");

    	Throwable t = ex;
    	// looking for the original exception
    	while (t.getCause() != null) {
    		t = t.getCause();
    	}
    	//
    	if( t!=null )
    		faultInfo.setStackTrace(t.getMessage());

    	return new BusinessWSException(msg, faultInfo);
	}


}
