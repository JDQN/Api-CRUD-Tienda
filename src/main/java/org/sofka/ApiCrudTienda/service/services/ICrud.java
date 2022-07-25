package org.sofka.ApiCrudTienda.service.services;

public interface ICrud<T> {

	T create(T t);

	T findById(Integer id);

	T update(T t, Integer id);

	void delete(Integer id);

}
