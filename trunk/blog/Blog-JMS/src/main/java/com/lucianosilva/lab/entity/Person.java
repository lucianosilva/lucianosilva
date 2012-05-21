/**
 * 
 */
package com.lucianosilva.lab.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;


/**
 * @author luciano
 * 
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7666766735436354531L;


	private Long personId;
	private String firstName;
	private String lastName;
	private String genre;
	private Date birthDate;

	public Person() {

	}

	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * @param personId
	 *            the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
/*
	public String toString(){
		StringBuffer buff = new StringBuffer("");
		
		Field[] fields = Person.class.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String campo = fields[i].getName();
			buff.append( campo );
			buff.append(" : ");
			try {
				buff.append(fields[i].getChar( fields[i]) );
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // .get(campo).toString() );
			buff.append("\n");	
		}
		
		return buff.toString();
		
	}
	*/
	
	
}