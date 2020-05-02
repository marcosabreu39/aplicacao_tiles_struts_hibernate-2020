package com.crud.dao;

import java.util.List;

import com.crud.model.Usuario;

public interface UsuarioDao {

	void iniciarTransacao();

	Usuario busca(Integer id);

	void adiciona(Usuario usuario);

	void remove(Integer id);

	void altera(Usuario usuario);

	List<Usuario> lista();

	boolean existeUsernameEPassword(String userName, String password);

	boolean existeUsername(String userName);

}
