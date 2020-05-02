package com.crud.facade;

import java.util.List;

import com.crud.model.Usuario;

public interface UsuarioFacade {

	Usuario busca(Integer id) throws Exception;

	void adiciona(Usuario usuario) throws Exception;

	void remove(Integer id) throws Exception;

	void altera(Usuario usuario) throws Exception;

	List<Usuario> lista() throws Exception;

	boolean existeUsernameEPassword(String userName, String password) throws Exception;

	boolean existeUsername(String userName) throws Exception;

}