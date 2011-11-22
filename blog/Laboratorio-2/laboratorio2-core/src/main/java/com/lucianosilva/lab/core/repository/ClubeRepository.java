/**
 *  Licença Creative Commons.
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.lab.core.repository;

import java.util.List;

import org.codehaus.grepo.query.commons.annotation.GenericQuery;
import org.codehaus.grepo.query.jpa.repository.ReadWriteJpaRepository;
import org.springframework.stereotype.Repository;

import com.lucianosilva.lab.core.entity.Clube;

/**
 * 
 *
 * @autor luciano.silva
 * @version $Rev$ $Date$
 */
@Repository
public interface ClubeRepository extends ReadWriteJpaRepository<Clube, Long> {

	@GenericQuery( query = "from Clube where 1=1" )
	List<Clube> findAll();

}