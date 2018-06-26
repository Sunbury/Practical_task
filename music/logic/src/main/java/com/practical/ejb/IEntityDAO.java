package com.practical.ejb;

public interface IEntityDAO <T> {
	public T create(T t);
	public T update(T t);
	public int remove(T t);
	public T find(Class<T> type, Object id);

}
