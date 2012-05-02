/**
 * 
 */
package com.lucianosilva.dao.listener;

import org.hibernate.event.PostLoadEvent;
import org.hibernate.event.PostLoadEventListener;
import org.hibernate.event.PreInsertEvent;
import org.hibernate.event.PreInsertEventListener;
import org.hibernate.event.PreUpdateEvent;
import org.hibernate.event.PreUpdateEventListener;

import com.lucianosilva.entity.Person;
import com.lucianosilva.type.PersonType;

/**
 * @author luciano.silva
 *
 */
public class PersonDAOListener implements PostLoadEventListener, PreInsertEventListener, PreUpdateEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9200540593722971536L;

	@Override
	public void onPostLoad(PostLoadEvent event) {
		//		// 
		if (event.getEntity() instanceof Person) {
			final Person p = (Person) event.getEntity();
			// p.setSex( p.getSexo().value() );
			p.setSexo( PersonType.fromValue(p.getSex()) );
		}
	}

	@Override
	public boolean onPreUpdate(PreUpdateEvent event) {
		// 
		if (event.getEntity() instanceof Person) {
			final Person p = (Person) event.getEntity();
			p.setSex( p.getSexo().value() );	
		}
		
		return true;
	}

	@Override
	public boolean onPreInsert(PreInsertEvent event) {
		// 
		if (event.getEntity() instanceof Person) {
			final Person p = (Person) event.getEntity();
			p.setSex( p.getSexo().value() );	
		}
		
		return true;
	}

}