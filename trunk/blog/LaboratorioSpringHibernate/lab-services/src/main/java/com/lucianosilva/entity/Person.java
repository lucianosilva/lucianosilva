/**
 * 
 */
package com.lucianosilva.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Entity;

/**
 * @author luciano.silva
 *
 */
@Entity
@Table(name = "PERSON")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person", namespace = Person.NAMESPACE)
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7201459282961502948L;

	protected static final String NAMESPACE = "http://www.lucianosilva.com/ESB/Person/V1";

	@Column(name = "PERSON_ID", nullable = false, length = 22)
	@XmlElement(name = "PersonId", required = true, nillable = false, namespace = Person.NAMESPACE)
	private Long personId;

	@Column(name = "FIRSTNAME", nullable = false, length = 200)
	@XmlElement(name = "Firstname", required = true, nillable = false, namespace = Person.NAMESPACE)
	private String firstname;

	@Column(name = "LASTNAME", nullable = false, length = 200)
	@XmlElement(name = "Lastname", required = true, nillable = false, namespace = Person.NAMESPACE)
	private String lastname;

	@Column(name = "SEX", nullable = false, length = 1)
	@XmlElement(name = "Sex", required = true, nillable = false, namespace = Person.NAMESPACE)
	private String sex;

	@Temporal(TemporalType.DATE)
	@Column(name = "BORNDATE", nullable = true, length = 7)
	@XmlElement(name = "Borndate", required = false, nillable = true, namespace = Person.NAMESPACE)
	private Date borndate;
	 
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	@XmlElement(name = "CreateDate", required = true, nillable = false, namespace = Person.NAMESPACE)
	private Date createDate;

	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the borndate
	 */
	public Date getBorndate() {
		return borndate;
	}

	/**
	 * @param borndate the borndate to set
	 */
	public void setBorndate(Date borndate) {
		this.borndate = borndate;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
