package dao;

import java.util.List;

import models.Utilisateur;

public interface Dao<T> {

	T save(T obj);

	void remove(T obj);

	T update(T obj);

	T findById(int id);

	List<T> getAll();

	Utilisateur findByLogin(String pLogin);
}
