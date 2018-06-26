package com.practical.ejb;

public interface IEntityManagerBean <T> {
	public T create(T t);
	public T update(T t);
	public int remove(T t);
	public T read(T t);

}
