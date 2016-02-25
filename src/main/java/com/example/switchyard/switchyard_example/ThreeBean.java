package com.example.switchyard.switchyard_example;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.switchyard.component.bean.Service;

import com.sample.model.Property;

@Service(Three.class)
public class ThreeBean implements Three {
	
	private static final Logger LOG = Logger.getLogger(ThreeBean.class);
	private static final int SLEEP_SECONDS = 1;

	@PersistenceContext(unitName="persistenceUnit")
	EntityManager em;

	@Override
	public String process(String message) {
		LOG.info("process() - start :" + message);
		Property p = new Property();
		p.setKey(new java.util.Date().getTime() + "");
		p.setValue("message:" + message);
		// do some persistence stuff here.
		em.persist(p);
		
		Query q = em.createQuery("select p from Property p");
		List<Property> propertyList = q.getResultList();
		for (Property _p: propertyList) {
			LOG.info("property:" + _p.getKey() + ":" + _p.getValue());
		}
		
		LOG.info("before sleep");
		
		try {
		    Thread.sleep(SLEEP_SECONDS * 1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		LOG.info("process() - done ");
		return message + " " + this.getClass();
	}

}
