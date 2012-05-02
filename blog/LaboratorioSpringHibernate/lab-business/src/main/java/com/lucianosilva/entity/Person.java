/**
 * 
 */
package com.lucianosilva.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.lucianosilva.type.PersonType;

/**
 * @author luciano.silva
 *
 */
@Entity
@Table(name = "PERSON")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person", namespace = Person.NAMESPACE)
public class Person implements BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2650757315390878777L;

	public static final String NAMESPACE = "http://www.lucianosilva.com/ESB/Person/V1";

	@Id
    @SequenceGenerator(name = "PERSON_ID", sequenceName = "PERSON_SQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_ID")
	@Column(name = "PERSON_ID", nullable = false, length = 22, updatable = false)
	@XmlElement(name = "PersonId", required = false, nillable = true, namespace = Person.NAMESPACE)
	private Long personId;

	@Column(name = "FIRSTNAME", nullable = false, length = 200)
	@XmlElement(name = "FirstName", required = true, nillable = false, namespace = Person.NAMESPACE)
	private String firstName;

	@Column(name = "LASTNAME", nullable = false, length = 200)
	@XmlElement(name = "LastName", required = true, nillable = false, namespace = Person.NAMESPACE)
	private String lastName;

	@Column(name = "SEX", nullable = false, length = 1)
	@XmlTransient
	private String sex;

	@Transient
	@XmlElement(name = "Sexo", type=PersonType.class, required = true, nillable = false, namespace = Person.NAMESPACE)
	private PersonType sexo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDATE", nullable = true, length = 7)
	@XmlElement(name = "BirthDate", required = false, nillable = true, namespace = Person.NAMESPACE)
	private Date birthDate;
	 
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", nullable = true, length = 7, updatable = false)
	@XmlElement(name = "CreateDate", required = false, nillable = true, namespace = Person.NAMESPACE)
	private Date createDate;

	/**
	 * @return the Id
	 */
	public Long getId() {
		return personId;
	}

	/**
	 * @param Id the personId to set
	 */
	public void setId(Long id) {
		this.personId = id;
	}

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	
	/**
	 * @return the sexo
	 */
	public PersonType getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(PersonType sexo) {
		this.sexo = sexo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}