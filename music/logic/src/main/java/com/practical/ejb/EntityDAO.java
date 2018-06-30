package com.practical.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


public class EntityDAO<T> implements IEntityDAO<T> {
	
	@PersistenceContext(unitName = "musicPU")
	private EntityManager entityManager;
	
	Class<T> entityClass;
	
	public EntityDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
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
	@Transactional
	public int remove(T t) {
		entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
		entityManager.flush();
		return 1;
	}

	@Override
	public T find(Class<T> type, Object id) {
		return entityManager.find(type, id);
	}

	@Override
	public T findByName(String name) {
		@SuppressWarnings("unchecked")
		T entity = (T) entityManager.createQuery("FROM " + entityClass.getName() + " where name = :value1").
				setParameter("value1", name).getSingleResult();
		return entity;
	}

	@Override
	public List<T> findAll() {
		Query q = entityManager.createQuery("SELECT t FROM " + entityClass.getName()
        + " t");
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) q.getResultList();
		return list;
	}


}
