/**
 * 
 */
package com.lucianosilva.lab.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucianosilva.lab.core.BaseEntity;

/**
 * @author luciano
 *
 */
@Entity
@Table(name = "TB_CLUBES")
public class Clube implements BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5541457395540986982L;

	@Id
	@Column(name = "ID_CLUBE", nullable = false)
	private Long idClube;
	
	@Column(name = "NOME", nullable = true)
	private String nome;

	@Column(name = "NOME_POP", nullable = true)
	private String nomePopular;
	
	@Column(name = "FUNDACAO", nullable = true)
	private Date dataFundacao;

	/* (non-Javadoc)
	 * @see com.lucianosilva.lab.core.BaseEntity#getId()
	 */
	@Override
	public Long getId() {
		// 
		return this.idClube;
	}

	/* (non-Javadoc)
	 * @see com.lucianosilva.lab.core.BaseEntity#setId(java.lang.Object)
	 */
	@Override
	public void setId(Long id) {
		//
		this.idClube = id;
	}

	/**
	 * @return the idClube
	 */
	public Long getIdClube() {
		return idClube;
	}

	/**
	 * @param idClube the idClube to set
	 */
	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the nomePopular
	 */
	public String getNomePopular() {
		return nomePopular;
	}

	/**
	 * @param nomePopular the nomePopular to set
	 */
	public void setNomePopular(String nomePopular) {
		this.nomePopular = nomePopular;
	}

	/**
	 * @return the dataFundacao
	 */
	public Date getDataFundacao() {
		return dataFundacao;
	}

	/**
	 * @param dataFundacao the dataFundacao to set
	 */
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	
}
