/**
 * 
 */
package com.lucianosilva.lab.exception;

import javax.xml.ws.WebFault;

/**
 * @author ERPR12
 * 
 */
@WebFault(name = "BusinessWSException", targetNamespace = "http://www.lucianosilva.com/EBO/Common/V1")
public class BusinessWSException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7308929445390985336L;

	public static final String NAMESPACE = "http://www.lucianosilva.com/EBO/Common/V1";

	private FaultInfo faultInfo;

	/**
	 * 
	 public BusinessWSException(){ super(); }
	 * 
	 * /**
	 * 
	 * @param message
	 * @param faultInfo
	 */
	public BusinessWSException(String message, FaultInfo faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	/**
	 * @param cause
	 */
	public BusinessWSException(String message, FaultInfo faultInfo,
			Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	/**
	 * @return the faultInfo
	 */
	public FaultInfo getFaultInfo() {
		return faultInfo;
	}

}