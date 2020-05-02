package com.crud.repository;

import java.util.List;

import com.crud.model.Usuario;

public interface UsuarioRepository {

	Usuario busca(Integer id) throws Exception;

	void adiciona(Usuario U) throws Exception;

	void remove(Integer id) throws Exception;

	void altera(Usuario u) throws Exception;

	List<Usuario> lista() throws Exception;

	boolean existeUsernameEPassword(String userName, String password) throws Exception ;	
	
	boolean existeUsername(String userName) throws Exception;	
	
}
