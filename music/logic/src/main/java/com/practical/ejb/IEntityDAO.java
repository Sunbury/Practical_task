package com.practical.ejb;

import java.util.List;

public interface IEntityDAO <T> {
	public T create(T t);
	public T update(T t);
	public int remove(T t);
	public List <T> findAll();
	public T find(Class<T> type, Object id);
	public T findByName(String name);

}
