/**
 * 
 */
package com.lucianosilva.lab.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * EBO data type for Fault.
 * 
 * @autor luciano
 * @version $Rev$ $Date$
 */
@XmlRootElement(name = "BusinessWSException", namespace = "http://www.lucianosilva.com/EBO/Common/V1")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.lucianosilva.lab.exception.BusinessWSException")
public class FaultInfo {

	@XmlElement(name = "ErrorCode", namespace = "http://www.lucianosilva.com/EBO/Common/V1")
	protected String errorCode;
	
	@XmlElement(name = "Description", namespace = "http://www.lucianosilva.com/EBO/Common/V1")
	protected String description;
	
	@XmlElement(name = "Instruction", namespace = "http://www.lucianosilva.com/EBO/Common/V1")
	protected String instruction;
	
	@XmlElement(name = "StackTrace", namespace = "http://www.lucianosilva.com/EBO/Common/V1")
	protected String stackTrace;
	
	@XmlElement(name = "Message", namespace = "http://www.lucianosilva.com/EBO/Common/V1")
	protected String message;

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}

	/**
	 * @param instruction
	 *            the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	/**
	 * @return the stackTrace
	 */
	public String getStackTrace() {
		return stackTrace;
	}

	/**
	 * @param stackTrace
	 *            the stackTrace to set
	 */
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}