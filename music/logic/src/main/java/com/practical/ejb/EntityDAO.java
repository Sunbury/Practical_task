package com.practical.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class EntityDAO<T> implements IEntityDAO<T> {
	
	@PersistenceContext(unitName = "musicPU")
	private EntityManager entityManager;
	
	Class<T> entityClass;
	
	public EntityDAO() {
	}

	@Override
	public T create(T t) {
		entityManager.persist(t);
		return t;
	}

	@Override
	public T update(T t) {
		entityManager.merge(t);
		return t;
	}

	@Override
	public int remove(T t) {
		entityManager.remove(t);
		return 1;
	}

	@Override
	public T find(Class<T> type, Object id) {
		return entityManager.find(type, id);
	}


}
