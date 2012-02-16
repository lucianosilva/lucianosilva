/**
 * 
 */
package com.lucianosilva.lab.exception;

/**
 *
 * @autor luciano
 * @version $Rev$ $Date$
 * 
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Throwable cause;

	/**
	 * 
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
