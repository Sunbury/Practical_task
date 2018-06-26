package com.practical.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class EntityManagerBean<T> implements IEntityManagerBean<T> {
	
	@PersistenceContext(unitName = "musicPU")
	private EntityManager entityManager;

	T createContents(Class<T> clazz) {
        return clazz.newInstance();
    }
	
	@Override
	public T create() {
		return null;
	}

	@Override
	public T update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T read() {
		// TODO Auto-generated method stub
		return null;
	}



}
