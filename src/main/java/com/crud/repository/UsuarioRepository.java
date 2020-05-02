package com.crud.repository;

import java.util.List;

public interface UsuarioRepository<T> {

	T busca(Integer id);

	void adiciona(T t);

	void remove(Integer id);

	void altera(T t);

	List<T> lista();

	boolean existeUsernameEPassword(String userName, String password) ;	
	
	boolean existeUsername(String userName);

	void iniciarTransacao();
	
}
