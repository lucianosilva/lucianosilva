/**
 * 
 */
package com.lucianosilva.type;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * @author luciano.silva
 *
 */
@XmlType(name = "PersonType", namespace = "http://www.lucianosilva.com/EBO/Common/V1")
@XmlEnum
public enum PersonType {

	MASCULINO("M"),
	FEMININO("F");

	private String value;

	/**
	 * 
	 * @param value
	 */
	private PersonType( String value ){
		this.value = value;
	}

	/**
	 * 
	 * @return value
	 */
	public String value(){
		return value;
	}
	
	/**
	 * 
	 * @param v
	 * @return
	 */
	public static PersonType fromValue(String v){
		//
		for(PersonType r : PersonType.values() ){
			if( r.value.equals(v) ){
				return r;
			}
		}

		throw new IllegalArgumentException(v);
	}
}
