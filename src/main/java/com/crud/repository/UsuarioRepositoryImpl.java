package com.crud.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.crud.dao.UsuarioDao;
import com.crud.model.Usuario;

@RequestScoped
public class UsuarioRepositoryImpl implements UsuarioRepository {	

	@Inject
	UsuarioDao usuarioDao;

	@Override
	public Usuario busca(Integer id) throws Exception {
		
		return usuarioDao.busca(id);
	}


	@Override
	public void adiciona(Usuario usuario) throws Exception {
		
		usuarioDao.adiciona(usuario);
	}


	@Override
	public void remove(Integer id) throws Exception {
		
		usuarioDao.remove(id);

	}


	@Override
	public void altera(Usuario usuario) throws Exception {
		
		usuarioDao.altera(usuario);
	}


	@Override
	public List<Usuario> lista() throws Exception {
		
		return usuarioDao.lista();
	}


	@Override
	public boolean existeUsernameEPassword(String userName, String password) throws Exception {
		
		return usuarioDao.existeUsernameEPassword(userName, password);
	}


	@Override
	public boolean existeUsername(String userName) throws Exception {
		
		return usuarioDao.existeUsername(userName);
	}

}
