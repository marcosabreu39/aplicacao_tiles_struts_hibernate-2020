package com.crud.persistence;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	private static EntityManagerFactory emf;

	
	@PostConstruct
	private void createEntityManagerFactory() {
		 emf = Persistence.createEntityManagerFactory("CRUD-PU");
	}

	@Produces
//	@RequestScoped
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}

}
